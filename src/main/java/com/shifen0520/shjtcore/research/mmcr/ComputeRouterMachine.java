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
import com.shifen0520.shjtcore.research.owner.OwnerResolver;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * 算力路由器：算力网络的<b>中间层</b>，把分散的算力节点汇成一路输出给科研中心。
 *
 * <p><b>为什么需要它</b>：没有路由器时，一台科研中心的网络接口直接连所有算力节点，
 * 于是节点数量受科研中心的连接上限约束，而且玩家必须把线从每台节点一路拉到中心。
 * 路由器把拓扑变成<b>星形 + 可级联</b>：节点只管连路由器，路由器再连科研中心，
 * 想扩容就多加一台路由器。
 *
 * <p><b>两端口设计</b>：结构里有<b>两个</b>网络接口位（见
 * {@code kubejs/server_scripts/mmcr/structrue/compute_router.js}），
 * 一个接算力节点、一个接科研中心。两个接口<b>必须分字符</b>，
 * 和科研中心把网络接口与升级总线分开是同一个原因。
 *
 * <p><b>不依赖端口顺序</b>：MMCR 给的端口下标取决于结构扫描顺序，写死
 * "第 0 个是入口"很脆（换个摆法就接反，而且不报错，只是静默不转发）。
 * 这里改成按<b>上报来源</b>判定：向本路由器 {@code REPORT_TFPS} 上报过的
 * 对端一律算<b>上游</b>，其余连接都是<b>下游</b>。于是玩家把节点和中心接反也照样能跑，
 * 端口只是两个物理插槽。
 *
 * <p><b>转发不是广播</b>：只往第一个下游连接发。路由器之间也可以级联
 * （另一台路由器把它当节点看待即可，因为两边都实现了 {@code REPORT_TFPS} 处理）。
 *
 * <p><b>耗时开销</b>：路由器自己每 tick 扣 {@link #FE_PER_TICK} 电，纯粹是转发成本。
 * 这样堆路由器不会被当成免费的算力放大器。
 *
 * <p><b>僵尸算力防护</b>：与科研中心同款的双重判定（连接 hash + TTL）。
 * MMCR 内置网络只按连接清理，生产者断电后会一直算着它最后一次上报的旧值。
 */
public final class ComputeRouterMachine {

    /** 每 tick 耗电（FE）——转发开销。 */
    private static final long FE_PER_TICK = 40L;
    /**
     * 网络连接数上限。必须与 {@code networkInterface(2, MAX_CONNECTIONS)} 一致——
     * 屏幕上的"上游 + 下游"就是这个口径，密钥卡"没有可用的网络容量"指的是它超了。
     */
    private static final int MAX_CONNECTIONS = 64;
    /** 每多少 tick 向上游汇总并转发一次。 */
    private static final int FORWARD_PERIOD = 20;
    /** 汇总算力、显示连接数的刷新周期。 */
    private static final int STATUS_PERIOD = 4;
    /** 转发体里的字段名，必须与科研中心的 {@code onReport} 一致。 */
    private static final String FIELD_TFPS = "tfps";
    /** 标记"本轮已上报、等 tick 补时间戳"的哨兵值。 */
    private static final long PENDING_TIME = -1L;

    private static final ResourceLocation LINE_TOTAL = ResearchIds.id("compute_router_total");
    private static final ResourceLocation LINE_PEERS = ResearchIds.id("compute_router_peers");
    private static final ResourceLocation LINE_LINK = ResearchIds.id("compute_router_link");

    private ComputeRouterMachine() {
    }

    /**
     * 机器定义。由 {@code MachineDefinitionProvider} 调用，<b>不要</b>加 {@code @SubscribeEvent}。
     */
    public static void registerDefinitions(RegisterMachineDefinitionsEvent event) {
        if (event.definitions().containsKey(ResearchIds.COMPUTE_ROUTER)) {
            return;
        }
        MachineSpec machine = Machines.machine(ResearchIds.COMPUTE_ROUTER)
                .recipePool(ResearchIds.COMPUTE_ROUTER)
                .displayNameKey("machine.shjtcore.compute_router")
                .appearance(a -> a.machineBasicBlock(ResearchIds.mc("gray_concrete")))
                // 两个端口：一个接算力节点，一个接科研中心（具体哪个无所谓，见类注释）
                // maxCount = 允许的网络接口<b>方块</b>数（结构里正好两个：I 和 O），
                // maxConnections = 连接总数上限。路由器就是拿来"汇集"的，64 起步。
                .networkInterface(2, MAX_CONNECTIONS)
                .allowNetworkMachine(ResearchIds.COMPUTE_NODE)
                // 出口允许接科研中心，也允许再接一台路由器（级联）
                .allowNetworkMachine(ResearchIds.RESEARCH_CENTER)
                .allowNetworkMachine(ResearchIds.COMPUTE_ROUTER)
                .allowModifiers(false)
                // 接收算力节点上报：与科研中心用同一个请求 id，所以节点代码完全不用改
                .requestProcess(ResearchIds.REPORT_TFPS, ComputeRouterMachine::onReport)
                .tickBehavior(behavior -> behavior.serverTick(ComputeRouterMachine::tick))
                .build();
        event.registerMachine(machine);
    }

    /**
     * 收到上游算力上报：按发送方 hash 分桶。
     *
     * <p>字段名与 {@code ResearchCenterMachine.onReport} 一致，
     * 所以同一台算力节点<b>不用改任何代码</b>就能改连路由器——
     * {@code ComputeNodeMachine} 声明的是 {@code allowNetworkMachine(...)}，
     * 只要把目标换成路由器即可。
     *
     * <p>时间戳先写哨兵：本回调拿不到 {@code TickContext}，没有 gameTime。
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
        if (storage == null || ctx.level() == null || ctx.level().getServer() == null) {
            return;
        }
        long now = ctx.level().getServer().overworld().getGameTime();

        // 转发要耗电，缺电就整台停摆（并停止转发）
        IoTransaction energy = ctx.ioPlan();
        energy.addInput(Requirements.energy(IoDirection.INPUT, FE_PER_TICK));
        boolean powered = energy.simulate().energySatisfied() && energy.commit().successful();

        pruneStaleBuckets(ctx, storage, now, Config.RESEARCH_CONTRIBUTION_TTL.get());

        List<NetworkPortView> ports = Networks.interfaces(ctx);
        // 上报过算力的对端 = 上游；其余连接 = 下游。不依赖端口下标。
        Set<String> sources = sourceHashes(storage);
        int upstream = countConnections(ports, sources, true);
        int downstream = countConnections(ports, sources, false);

        if (ctx.isDue(STATUS_PERIOD)) {
            double total = sumTfps(storage);
            ctx.screenText().append(TextScope.OPERATION, LINE_TOTAL, Component.translatable(
                    powered ? "machine.shjtcore.compute_router.total"
                            : "machine.shjtcore.compute_router.no_power",
                    String.format("%.1f", total)));
            ctx.screenText().append(TextScope.OPERATION, LINE_PEERS, Component.translatable(
                    "machine.shjtcore.compute_router.peers", upstream, downstream, MAX_CONNECTIONS));
            ctx.screenText().append(TextScope.OPERATION, LINE_LINK, Component.translatable(
                    downstream > 0 ? "machine.shjtcore.compute_router.linked"
                            : "machine.shjtcore.compute_router.unlinked"));
            ctx.jadeText().append(LINE_TOTAL, Component.literal(String.format("%.1f tfps", sumTfps(storage))));
        }

        if (!powered || !ctx.isDue(FORWARD_PERIOD)) {
            return;
        }
        Exit exit = pickExit(ports, sources);
        if (exit == null) {
            return;
        }
        forward(exit, sumTfps(storage));
    }

    /**
     * 把汇总算力发往<b>第一个下游连接</b>。
     *
     * <p><b>只发一个</b>而不是广播：多个出口会让同一份算力被重复计入，
     * 越级联越离谱。要接多个科研中心就摆多台路由器。
     */
    private static void forward(Exit exit, double total) {
        try {
            Networks.sendRequest(exit.port(), exit.node(), ResearchIds.REPORT_TFPS,
                    RequestPayload.of(Map.of(FIELD_TFPS, DataKey.of(total))));
        } catch (IllegalArgumentException e) {
            // 对端不在连接表里时 sendRequest 会同步抛异常，忽略，下个周期再试
        }
    }

    /** 一个"出口"：端口 + 该端口上的某个下游连接。{@code sendRequest} 两者都要。 */
    private record Exit(NetworkPortView port, NodeView node) {
    }

    /**
     * 本路由器的上游集合：凡是向它上报过算力的对端 hash。
     *
     * <p>用 hash 而不是端口下标，是因为<b>上报行为本身就是最可靠的上下游证据</b>——
     * 结构怎么摆、MMCR 按什么顺序扫端口都不影响判定。
     */
    private static Set<String> sourceHashes(DataStore storage) {
        Set<String> out = new HashSet<>();
        for (String key : storage.values().keySet()) {
            if (key.startsWith(ResearchIds.KEY_TFPS)) {
                out.add(key.substring(ResearchIds.KEY_TFPS.length()));
            }
        }
        return out;
    }

    /** 取第一个<b>不是</b>上游的连接作为出口。 */
    private static Exit pickExit(List<NetworkPortView> ports, Set<String> sources) {
        if (ports == null) {
            return null;
        }
        for (NetworkPortView port : ports) {
            List<NodeView> nodes = port.connections();
            if (nodes == null) {
                continue;
            }
            for (NodeView node : nodes) {
                if (!sources.contains(String.valueOf(node.hash()))) {
                    return new Exit(port, node);
                }
            }
        }
        return null;
    }

    /** 按上下游角色统计连接数，纯粹给屏幕显示用。 */
    private static int countConnections(List<NetworkPortView> ports, Set<String> sources, boolean wantUpstream) {
        if (ports == null) {
            return 0;
        }
        int n = 0;
        for (NetworkPortView port : ports) {
            List<NodeView> nodes = port.connections();
            if (nodes == null) {
                continue;
            }
            for (NodeView node : nodes) {
                if (sources.contains(String.valueOf(node.hash())) == wantUpstream) {
                    n++;
                }
            }
        }
        return n;
    }

    // ------------------------------------------------------------------ 汇总

    /**
     * 清理僵尸桶：连接 hash + TTL 双保险。
     *
     * <p>{@code DataStore} 是活对象，边遍历边改会踩
     * {@code ConcurrentModificationException}，所以先快照 key 再删。
     */
    private static void pruneStaleBuckets(TickContext ctx, DataStore storage, long now, int ttl) {
        List<NetworkPortView> ports = Networks.interfaces(ctx);
        Set<String> connected = new HashSet<>();
        if (ports != null) {
            for (NetworkPortView port : ports) {
                List<NodeView> nodes = port.connections();
                if (nodes == null) {
                    continue;
                }
                for (NodeView node : nodes) {
                    connected.add(String.valueOf(node.hash()));
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

            if (seenAt == PENDING_TIME) {
                storage.set(seenKey, DataKey.of(now));
                continue;
            }
            if (now - seenAt > ttl || !connected.contains(hash)) {
                stale.add(key);
                stale.add(seenKey);
            }
        }
        for (String key : stale) {
            storage.remove(key);
        }
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

    /**
     * 本路由器的队伍归属（读升级总线里的身份卡）。
     *
     * <p>路由器本身不驱动研究，只做转发，所以归属只用于屏幕显示与将来可能的
     * "按队伍分账"。走的是和科研中心同一套 {@link OwnerResolver}。
     */
    @SuppressWarnings("unused") // 结构已预留升级总线位，等级/分账功能上线时启用
    public static UUID resolveTeam(TickContext ctx) {
        return OwnerResolver.resolveTeam(ctx);
    }
}