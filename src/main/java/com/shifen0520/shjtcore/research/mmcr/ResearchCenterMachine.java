package com.shifen0520.shjtcore.research.mmcr;

import cn.howxu.mmcr.publicapi.Machines;
import cn.howxu.mmcr.publicapi.behavior.TickContext;
import cn.howxu.mmcr.publicapi.data.DataKey;
import cn.howxu.mmcr.publicapi.data.DataStore;
import cn.howxu.mmcr.publicapi.event.RegisterMachineDefinitionsEvent;
import cn.howxu.mmcr.publicapi.machine.MachineSpec;
import cn.howxu.mmcr.publicapi.network.NetworkPortView;
import cn.howxu.mmcr.publicapi.network.Networks;
import cn.howxu.mmcr.publicapi.network.NodeView;
import cn.howxu.mmcr.publicapi.network.RequestDetails;
import cn.howxu.mmcr.publicapi.network.RequestPayload;
import cn.howxu.mmcr.publicapi.presentation.TextScope;
import cn.howxu.mmcr.publicapi.recipe.IoDirection;
import cn.howxu.mmcr.publicapi.recipe.requirement.Requirements;
import cn.howxu.mmcr.publicapi.runtime.IoTransaction;
import com.shifen0520.shjtcore.Config;
import com.shifen0520.shjtcore.research.ResearchIds;
import com.shifen0520.shjtcore.research.data.ResearchData;
import com.shifen0520.shjtcore.research.data.TechDefinition;
import com.shifen0520.shjtcore.research.ftb.FtbBridge;
import com.shifen0520.shjtcore.research.ftb.ResearchTaskBinder;
import com.shifen0520.shjtcore.research.owner.OwnerResolver;
import com.shifen0520.shjtcore.research.service.ResearchService;
import com.shifen0520.shjtcore.research.team.ResearchSaveData;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * 科研中心：算力网络的接收端，也是整个系统的驱动源。
 *
 * <p>职责链：
 * <ol>
 *     <li>接收算力节点上报，按发送方 hash 分桶存 DataStore（{@code tfps_<hash>} + {@code seen_<hash>}）。</li>
 *     <li>每周期清理僵尸桶、汇总总算力。</li>
 *     <li>读升级总线里的身份卡 → 队伍 → 焦点科技 → 上报给 {@link ResearchService}。</li>
 * </ol>
 *
 * <p><b>注册方式（重要）</b>：机器定义由 {@code BuItiInProvider}（{@code MachineDefinitionProvider}，
 * ServiceLoader）统一调用，本类<b>不挂</b> {@code @EventBusSubscriber}。结构已迁到 KubeJS 定义，
 * 见 {@code kubejs/server_scripts/mmcr/structrue/research_center.js}。
 * 定义只能走 ServiceLoader 的原因见 {@code BuItiInProvider} 的类注释——MMCR 发定义事件时我们的订阅者还没被注册。
 *
 * <p><b>为什么补 {@code seen_} 时间戳</b>：MMCR 内置的网络中心只按连接 hash 清理，
 * 没有时间戳。生产者一断电，中心会一直算着它最后一次上报的旧算力（僵尸算力）。
 * 这里同时用 TTL 和连接 hash 双重剔除。
 *
 * <p><b>为什么显示降频</b>：查 FTB 任务进度、解析身份卡、遍历科技树都不便宜，
 * 这些活每 {@code STATUS_PERIOD} tick 做一次并缓存进 DataStore，
 * 屏幕每 tick 只读缓存渲染，所以数字不会闪，也不会把服务器拖住。
 */
public final class ResearchCenterMachine {

    private static final long FE_PER_TICK = 200L;
    /** 汇总算力、驱动一次全局研究推进的周期。 */
    private static final int AGGREGATE_PERIOD = 20;
    /** 屏幕 / Jade 状态的刷新周期：这一档只放重活（FTB 查询、身份卡解析）。 */
    private static final int STATUS_PERIOD = 10;
    /** "刚上报过、还没盖时间戳"的哨兵值。 */
    private static final long PENDING_TIME = -1L;
    /**
     * 网络连接数上限。必须与 {@code networkInterface(1, MAX_CONNECTIONS)} 一致——
     * 屏幕拿它显示"已用/上限"，密钥卡"没有可用的网络容量"就是指超了这个值。
     */
    private static final int MAX_CONNECTIONS = 64;

    /**
     * 机器定义。由 {@code MachineDefinitionProvider} 调用，<b>不要</b>加 {@code @SubscribeEvent}。
     */
    public static void registerDefinitions(RegisterMachineDefinitionsEvent event) {
        if (event.definitions().containsKey(ResearchIds.RESEARCH_CENTER)) {
            return;
        }
        MachineSpec machine = Machines.machine(ResearchIds.RESEARCH_CENTER)
                .recipePool(ResearchIds.RESEARCH_CENTER)
                .displayNameKey("machine.shjtcore.research_center")
                .appearance(a -> a.machineBasicBlock(ResearchIds.mc("black_concrete")))
                // 连接上限 64：一台中心直连十几台节点很常见，16 太紧，
                // 撞上限后密钥卡只报"没有可用的网络容量"，玩家根本看不出是哪种满了。
                .networkInterface(1, MAX_CONNECTIONS)
                .allowNetworkMachine(ResearchIds.COMPUTE_NODE)
                // 必须显式允许路由器：MMCR 的白名单是**双向**校验的
                // （allows(源→目标) && allows(目标→源)，见 NetworkInterfaceBindingCoordinator.allows），
                // 只在上游声明不够——中心不认路由器，密钥卡就报"机器白名单拒绝了此次连接"。
                .allowNetworkMachine(ResearchIds.COMPUTE_ROUTER)
                .allowModifiers(false)
                .requestProcess(ResearchIds.REPORT_TFPS, ResearchCenterMachine::onReport)
                .tickBehavior(behavior -> behavior.serverTick(ResearchCenterMachine::tick))
                .build();
        event.registerMachine(machine);
    }

    // ------------------------------------------------------------------ 请求回调

    /**
     * 收到算力节点上报：按发送方 hash 分桶。
     *
     * <p>这个回调里没有 {@code TickContext}，拿不到 gameTime，所以时间戳先写哨兵
     * {@link #PENDING_TIME}：它的含义是"这一轮上报过了"，由汇总 tick 补成真实时间，
     * 再由 TTL 判断是否过期。生产者一停报，TTL 就会把它剔出去。
     */
    private static void onReport(RequestPayload body, RequestDetails request,
                                 DataStore senderStorage, DataStore receiverStorage) {
        if (receiverStorage == null) {
            return;
        }
        double reported = body.get("tfps").flatMap(DataKey::asDouble).orElse(0.0);
        long hash = request.peer().hash();
        receiverStorage.set(ResearchIds.KEY_TFPS + hash, DataKey.of(reported));
        receiverStorage.set(ResearchIds.KEY_SEEN + hash, DataKey.of(PENDING_TIME));
    }

    // ------------------------------------------------------------------ 每 tick

    private static void tick(TickContext ctx) {
        DataStore storage = ctx.dataStorage();
        ServerLevel level = ctx.level();
        MinecraftServer server = level != null ? level.getServer() : null;
        if (storage == null || server == null) {
            return;
        }

        // ---- 0. 耗电：每 tick 结算一次，缺电就停研究
        IoTransaction energy = ctx.ioPlan();
        energy.addInput(Requirements.energy(IoDirection.INPUT, FE_PER_TICK));
        boolean powered = energy.simulate().energySatisfied() && energy.commit().successful();

        long now = server.overworld().getGameTime();

        // ---- 1. 清僵尸桶 + 汇总总算力（每 tick 刷新，数字要实时）
        List<NetworkPortView> interfaces = Networks.interfaces(ctx);
        pruneStaleBuckets(storage, interfaces, now, Config.RESEARCH_CONTRIBUTION_TTL.get());
        double total = sumTfps(storage);
        // 缓存给 ETA 用：屏幕每 tick 都要显示剩余时间，而真值只在上报周期里更新
        storage.set(ResearchIds.KEY_RATE, DataKey.of(total));

        // ---- 2. 屏幕 / Jade。归属解析与 FTB 查询降频（STATUS_PERIOD），结果缓存进 DataStore
        ctx.screenText().append(TextScope.OPERATION, ResearchIds.LINE_TFPS,
                Component.translatable("machine.shjtcore.research_center.tfps", String.format("%.1f", total)));
        // 连接数：密钥卡"没有可用的网络容量"是这条最容易踩的坑，
        // 屏幕上直接写出 已用/上限，玩家一眼就知道是不是连满了（而不是去猜白名单）。
        ctx.screenText().append(TextScope.OPERATION, ResearchIds.LINE_LINKS,
                Component.translatable("machine.shjtcore.research_center.links",
                        countConnections(interfaces), MAX_CONNECTIONS));
        ctx.screenText().append(TextScope.OPERATION, ResearchIds.LINE_PROGRESS,
                Component.translatable(powered ? "machine.shjtcore.research_center.powered"
                        : "machine.shjtcore.research_center.no_power"));
        ctx.jadeText().append(ResearchIds.LINE_TFPS, Component.literal(String.format("%.1f tfps", total)));

        UUID teamId = readCachedTeam(storage);
        if (ctx.isDue(STATUS_PERIOD)) {
            teamId = OwnerResolver.resolveTeam(ctx);
            refreshStatus(storage, server, teamId);
        }
        appendStatus(ctx, storage, teamId);

        // ---- 3. 上报总算力 + 驱动一次全局推进（降频在 ResearchService 内部再加一道）
        if (!powered || !ctx.isDue(AGGREGATE_PERIOD)) {
            return;
        }
        if (teamId == null) {
            return;
        }
        // 只有卡上<b>明确写了</b>焦点才覆盖队伍状态。
        //
        // 以前这里是无条件 setFocus(focus)：卡上没写科技时 focus 为 null，
        // 会把玩家用 /shjtresearch focus 设的目标每周期清一次。
        // 而 ResearchService 现在只在有焦点时才推进（不再自动挑下一项），
        // 于是只要机器一通电，刚设好的目标立刻被抹掉 → 永远没有研究目标
        // → 屏幕显示"全部科技已完成"。卡没写就不要动它。
        ResourceLocation focus = OwnerResolver.resolveFocus(ctx);
        if (focus != null) {
            // 卡上写的科技也必须前置齐备才生效：老存档 / 手改 NBT 可能留下一个
            // 前置没做完的科技，直接 setFocus 会让屏幕显示一个推不动的死目标，
            // 玩家看着"研究中：XXX 0/1000"却永远不动，且没有任何报错。
            // 这里挡掉并清焦点，让屏幕回到"未选择研究目标"的正确状态。
            if (ResearchService.canResearch(server, teamId, focus)) {
                ResearchSaveData.get(server).team(teamId).setFocus(focus);
            } else {
                ResearchSaveData data = ResearchSaveData.get(server);
                data.team(teamId).setFocus(null);
                data.setDirty();
            }
        }

        BlockPos pos = ctx.controllerPos();
        ResourceKey<Level> dimension = level.dimension();
        ResearchService.report(ResearchService.machineKey(dimension, pos), teamId, total, now);
        ResearchService.tick(server);
    }

    // ------------------------------------------------------------------ 汇总

    /**
     * 清理僵尸桶：连接 hash 判定 + TTL 双保险。
     *
     * <p>DataStore 是<b>活</b>对象（写入/删除立即生效），边遍历边 set/remove 会踩
     * {@code ConcurrentModificationException}，所以先把 key 快照出来再改
     * （MMCR 内置网络中心也是把删除攒到循环之后才做的）。
     */
    private static void pruneStaleBuckets(DataStore storage, List<NetworkPortView> interfaces,
                                          long now, int ttl) {
        Set<String> connectedHashes = new HashSet<>();
        if (interfaces != null) {
            for (NetworkPortView iface : interfaces) {
                List<NodeView> nodes = iface.connections();
                if (nodes == null) {
                    continue;
                }
                for (NodeView node : nodes) {
                    connectedHashes.add(String.valueOf(node.hash()));
                }
            }
        }

        List<String> stale = new ArrayList<>();
        for (String key : new ArrayList<>(storage.values().keySet())) {
            if (!key.startsWith(ResearchIds.KEY_TFPS)) {
                continue;
            }
            String hash = key.substring(ResearchIds.KEY_TFPS.length());
            String seenKey = ResearchIds.KEY_SEEN + hash;
            long seenAt = storage.get(seenKey).flatMap(DataKey::asLong).orElse(PENDING_TIME);

            // 刚上报过：这里补上真实时间戳，下个周期再判 TTL
            if (seenAt == PENDING_TIME) {
                storage.set(seenKey, DataKey.of(now));
                continue;
            }
            if (now - seenAt > ttl || !connectedHashes.contains(hash)) {
                stale.add(key);
                stale.add(seenKey);
            }
        }
        for (String key : stale) {
            storage.remove(key);
        }
    }

    /**
     * 该机器所有网络接口上的连接总数。
     *
     * <p>口径必须和 MMCR 的容量判定一致（{@code NetworkInterfaceBindingCoordinator.connect}
     * 是对该机器<b>全部</b>接口的 connections 求和再比 {@code maxConnections}），
     * 所以这里也遍历全部接口，而不是只看第 0 个——否则屏幕上显示"还有空位"，
     * 密钥卡却报"没有可用的网络容量"。
     */
    private static int countConnections(List<NetworkPortView> interfaces) {
        if (interfaces == null) {
            return 0;
        }
        int n = 0;
        for (NetworkPortView iface : interfaces) {
            List<NodeView> nodes = iface.connections();
            if (nodes != null) {
                n += nodes.size();
            }
        }
        return n;
    }

    private static double sumTfps(DataStore storage) {
        double total = 0.0;
        for (Map.Entry<String, DataKey> entry : storage.values().entrySet()) {
            if (entry.getKey().startsWith(ResearchIds.KEY_TFPS)) {
                total += entry.getValue().asDouble().orElse(0.0);
            }
        }
        return total;
    }

    // ------------------------------------------------------------------ 状态缓存

    /**
     * 重活都放这里：找当前研究目标、查 FTB 任务进度、算限时增益。
     * 结果全部写进 DataStore，屏幕每 tick 只读缓存渲染。
     */
    private static void refreshStatus(DataStore storage, MinecraftServer server, UUID teamId) {
        if (teamId == null) {
            // 没卡 / 没队伍：清掉缓存，避免拆卡后屏幕上还挂着旧科技
            storage.remove(ResearchIds.KEY_STATUS_TECH);
            storage.remove(ResearchIds.KEY_STATUS_DONE);
            storage.remove(ResearchIds.KEY_STATUS_IDLE);
            storage.remove(ResearchIds.KEY_STATUS_BOOST);
            return;
        }

        ResearchSaveData saveData = ResearchSaveData.get(server);
        ResourceLocation tech = ResearchService.currentTarget(server, teamId);
        if (tech == null) {
            storage.remove(ResearchIds.KEY_STATUS_TECH);
            storage.remove(ResearchIds.KEY_STATUS_DONE);
            // 没有研究目标有两种截然不同的原因，必须分开告诉玩家：
            //   1 = 科技表里确实都解锁完了；2 = 还有得研究，只是没指定目标。
            // 以前一律按 1 显示"全部科技已完成"，新存档刚进来也会看到这句，
            // 看着像是上个存档的进度串过来了。
            storage.set(ResearchIds.KEY_STATUS_IDLE,
                    DataKey.of(ResearchService.remainingTechs(server, teamId) == 0L ? 1L : 2L));
        } else {
            storage.set(ResearchIds.KEY_STATUS_TECH, DataKey.of(tech.toString()));
            TechDefinition def = ResearchData.techs().get(tech);
            long done = 0L;
            if (def != null) {
                long taskId = ResearchTaskBinder.effectiveTaskId(tech, def, saveData);
                if (taskId >= 0) {
                    done = FtbBridge.progress(teamId, taskId);
                }
            }
            storage.set(ResearchIds.KEY_STATUS_DONE, DataKey.of(done));
            storage.set(ResearchIds.KEY_STATUS_IDLE, DataKey.of(0L));
        }
        storage.set(ResearchIds.KEY_STATUS_BOOST,
                DataKey.of(saveData.team(teamId).boostRate(server.overworld().getGameTime())));
    }

    /**
 * 剩余时间估算。
 *
 * <p><b>速率要和 {@code ResearchService.tick} 里真正用的那个一致</b>，
 * 也就是"实际算力 × rateScale + 增益，再被 {@code maxPointsPerSecond} 封顶"。
 * 这里漏掉封顶的话，玩家在算力堆到一定程度后会看到 ETA 越算越短，
 * 最后突然变成 0 秒——非常像 bug。
 */
private static Component etaText(TechDefinition def, long done, double rate, double boost) {
        long remain = Math.max(0L, def.computingCost() - done);
        if (remain == 0L) {
            return Component.empty();
        }
        // 走 ResearchService 的同一个公式，绝不自己重算 —— 否则两处公式不同步，
        // 玩家会看到"ETA 越算越短、最后突然归零"
        double tfps = ResearchService.effectiveRate(rate, def.rateScale(), boost);
        double pointsPerSecond = tfps * Config.RESEARCH_POINTS_PER_TFPS_SECOND.get();
        double cap = def.maxPointsPerSecond(Config.RESEARCH_POINTS_PER_TFPS_SECOND.get());
        if (pointsPerSecond > cap) {
            pointsPerSecond = cap;
        }
        if (pointsPerSecond <= 0.0) {
            // 没算力：只提示"需要算力"，不编一个 ETA 出来
            return Component.translatable("machine.shjtcore.research_center.need_tfps");
        }
        long seconds = (long) Math.ceil(remain / pointsPerSecond);
        return Component.translatable("machine.shjtcore.research_center.eta", formatSeconds(seconds));
    }

    private static String formatSeconds(long seconds) {
        if (seconds < 60L) {
            return seconds + " 秒";
        }
        long minutes = seconds / 60L;
        long restSeconds = seconds % 60L;
        if (minutes < 60L) {
            return restSeconds == 0L ? minutes + " 分钟" : minutes + " 分 " + restSeconds + " 秒";
        }
        long hours = minutes / 60L;
        long restMinutes = minutes % 60L;
        return restMinutes == 0L ? hours + " 小时" : hours + " 小时 " + restMinutes + " 分";
    }

/** 屏幕是玩家唯一能直接看到进度的地方，每 tick 都从缓存渲染一遍。 */
    private static void appendStatus(TickContext ctx, DataStore storage, UUID teamId) {
        if (teamId == null) {
            ctx.screenText().append(TextScope.OPERATION, ResearchIds.LINE_TECH,
                    Component.translatable("machine.shjtcore.research_center.no_card"));
            return;
        }

        String techId = cachedString(storage, ResearchIds.KEY_STATUS_TECH);
        if (techId == null) {
            // 只有"科技表里确实全解锁完了"才说全部完成；否则是还没选目标。
            // 这两句以前共用一句"全部科技已完成"，换到新存档也会显示它，
            // 玩家自然会以为研究进度串存档了。
            long idle = cachedLong(storage, ResearchIds.KEY_STATUS_IDLE);
            ctx.screenText().append(TextScope.OPERATION, ResearchIds.LINE_TECH,
                    Component.translatable(idle == 1L
                            ? "machine.shjtcore.research_center.all_done"
                            : "machine.shjtcore.research_center.no_focus"));
            return;
        }

        TechDefinition def = ResearchData.techs().get(ResearchIds.parse(techId));
        if (def == null) {
            // datapack 重载后缓存可能指向已删除的科技，清掉，下个周期自然重算
            storage.remove(ResearchIds.KEY_STATUS_TECH);
            return;
        }

        long done = Math.max(0L, cachedLong(storage, ResearchIds.KEY_STATUS_DONE));
        long cost = def.computingCost();

        ctx.screenText().append(TextScope.OPERATION, ResearchIds.LINE_TECH,
                Component.translatable("machine.shjtcore.research_center.researching",
                        def.display(), done, cost));
        ctx.jadeText().append(ResearchIds.LINE_TECH,
                Component.literal(def.display().getString() + " " + done + "/" + cost));

        // 剩余时间估算。只有在拿到实际算力时才显示，否则给"???"——
        // 缺电或没节点时给一个假的 ETA 反而误导玩家。
        ctx.screenText().append(TextScope.OPERATION, ResearchIds.LINE_ETA,
                etaText(def, done, cachedDouble(storage, ResearchIds.KEY_RATE),
                        cachedDouble(storage, ResearchIds.KEY_STATUS_BOOST)));

        double boost = cachedDouble(storage, ResearchIds.KEY_STATUS_BOOST);
        if (boost > 0.0) {
            ctx.screenText().append(TextScope.OPERATION, ResearchIds.LINE_BOOST,
                    Component.translatable("machine.shjtcore.research_center.boost",
                            String.format("%.1f", boost)));
        }
    }

    /** OwnerResolver 把解析结果缓存在 DataStore（key: {@code team}），这里直接读回来。 */
    private static UUID readCachedTeam(DataStore storage) {
        String raw = cachedString(storage, ResearchIds.KEY_TEAM);
        if (raw == null) {
            return null;
        }
        try {
            return UUID.fromString(raw);
        } catch (IllegalArgumentException ignored) {
            return null;
        }
    }

    private static String cachedString(DataStore storage, String key) {
        return storage.get(key).flatMap(DataKey::asString).orElse(null);
    }

    private static long cachedLong(DataStore storage, String key) {
        return storage.get(key).flatMap(DataKey::asLong).orElse(0L);
    }

    private static double cachedDouble(DataStore storage, String key) {
        return storage.get(key).flatMap(DataKey::asDouble).orElse(0.0);
    }

    private ResearchCenterMachine() {
    }
}
