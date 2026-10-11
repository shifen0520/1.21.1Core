package com.shifen0520.shjtcore.research.service;

import com.mojang.logging.LogUtils;
import com.shifen0520.shjtcore.Config;
import com.shifen0520.shjtcore.research.data.BoostDefinition;
import com.shifen0520.shjtcore.research.data.BoostRegistry;
import com.shifen0520.shjtcore.research.data.ResearchData;
import com.shifen0520.shjtcore.research.data.TechDefinition;
import com.shifen0520.shjtcore.research.data.TechRegistry;
import com.shifen0520.shjtcore.research.ftb.FtbBridge;
import com.shifen0520.shjtcore.research.ftb.ResearchTaskBinder;
import com.shifen0520.shjtcore.research.team.ComputeBoost;
import com.shifen0520.shjtcore.research.db.ResearchDatabase;
import com.shifen0520.shjtcore.research.team.ResearchSaveData;
import com.shifen0520.shjtcore.research.team.TeamResearchState;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * 科研系统的大脑：聚合算力 → 换算成进度 → 写进 FTB → 判解锁 → 发增益。
 *
 * <p>设计要点：
 * <ul>
 *     <li><b>贡献心跳</b>：机器每周期上报一次，超过 TTL 没上报就剔除。
 *         拆机 / 断电 / 区块卸载都靠这一层自动收敛，不需要额外的拆除回调。</li>
 *     <li><b>权威状态分离</b>：科技定义在 datapack，解锁真值在 FTB 的 TeamData，
 *         小数余量与限时增益在我们的 SavedData。MMCR 的 DataStore 只当缓存，绝不存权威数据。</li>
 *     <li><b>前置自己判</b>：FTB 的 {@code addProgress} 会绕过任务书里的任务依赖，
 *         所以前置科技必须在这里用闭包判断，不能指望任务书挡住。</li>
 * </ul>
 */
public final class ResearchService {

    private static final Logger LOGGER = LogUtils.getLogger();

    /** 一台机器一个周期的贡献。算力按队伍聚合，不按科技分桶——
     *  研究目标由卡/队伍指定的焦点或自动推进决定，与"算力来自哪台机器"无关。 */
    private record Contribution(UUID teamId, double tfps, long lastSeen) {
    }

    private static final Map<String, Contribution> CONTRIBUTIONS = new HashMap<>();

    private static long lastRun = Long.MIN_VALUE;
    private static long lastBoostScan = Long.MIN_VALUE;

    /**
     * 上一轮 {@link #tick} 用的服务器实例（弱引用，避免把已停止的服务器钉在内存里）。
     *
     * <p><b>为什么必须记录它</b>：上面三样都是 {@code static}，而每个存档的
     * {@code MinecraftServer} 是<b>不同的实例</b>。换存档时如果不当场作废，
     * 会漏出两个很隐蔽的错：
     * <ol>
     *     <li><b>研究彻底停摆</b>：新世界的 {@code gameTime} 从 0 重新计数，
     *         而 {@code lastRun} 还留着上个存档的大数值，
     *         {@code now - lastRun} 是负数、恒小于周期 → {@code tick} 每次都直接 return。</li>
     *     <li><b>幽灵算力</b>：上个存档的机器条目还留在 {@code CONTRIBUTIONS} 里，
     *         TTL 判定 {@code now - lastSeen > ttl} 同样为负 → 永远剔不掉，
     *         新存档一台机器都没放也能"凭空"推进研究。</li>
     * </ol>
     * 专门监听 {@code ServerStoppedEvent} 也能解决，但那依赖事件一定派发；
     * 这里在 {@code tick} 入口直接比对实例，任何路径都不会漏。
     */
    private static java.lang.ref.WeakReference<MinecraftServer> currentServer =
            new java.lang.ref.WeakReference<>(null);

    /**
     * 清空所有跨存档残留的运行时状态。
     *
     * <p>服务器停止、换存档、重进单人世界时调用。存档内的<b>持久化</b>数据
     * （{@code ResearchSaveData} / {@code ResearchDatabase}）本来就挂在各自的
     * {@code overworld().getDataStorage()} 上，不需要也不应该在这里动。
     */
    public static void resetRuntime() {
        CONTRIBUTIONS.clear();
        lastRun = Long.MIN_VALUE;
        lastBoostScan = Long.MIN_VALUE;
        currentServer = new java.lang.ref.WeakReference<>(null);
    }

    /** 服务器实例变了就先把运行时状态作废，保证每个存档各自从零开始。 */
    private static void syncServer(MinecraftServer server) {
        if (currentServer.get() != server) {
            CONTRIBUTIONS.clear();
            lastRun = Long.MIN_VALUE;
            lastBoostScan = Long.MIN_VALUE;
            currentServer = new java.lang.ref.WeakReference<>(server);
            LOGGER.info("[research] 检测到新的服务器实例，已清空科研运行时状态（每个存档独立）");
        }
    }

    // ------------------------------------------------------------------ 注册表
    // 每次现取，保证 /reload 之后立刻拿到新数据（不要在这里缓存快照）

    public static TechRegistry techs() {
        return ResearchData.techs();
    }

    public static BoostRegistry boosts() {
        return ResearchData.boosts();
    }

    // ------------------------------------------------------------------ 贡献上报

    public static String machineKey(ResourceKey<Level> dimension, BlockPos pos) {
        return dimension.location() + "|" + pos.toShortString();
    }

    /** 由科研中心机器每周期调用。 */
    public static void report(String key, UUID teamId, double tfps, long now) {
        CONTRIBUTIONS.put(key, new Contribution(teamId, tfps, now));
    }

    /** 机器停机时主动撤销（可选，心跳超时也会自动清）。 */
    public static void withdraw(String key) {
        CONTRIBUTIONS.remove(key);
    }

    // ------------------------------------------------------------------ 周期驱动

    public static void tick(MinecraftServer server) {
        // 换存档后必须先把上个存档的贡献表和周期基线作废，否则跨存档串数据（见 currentServer 注释）
        syncServer(server);
        long now = server.overworld().getGameTime();
        int period = Config.RESEARCH_PERIOD_TICKS.get();
        if (lastRun != Long.MIN_VALUE && now - lastRun < period) {
            return;
        }
        lastRun = now;

        purgeStale(now);

        // teamId → 该队伍的总算力速率
        Map<UUID, Double> byTeam = new HashMap<>();
        for (Contribution c : CONTRIBUTIONS.values()) {
            byTeam.merge(c.teamId(), c.tfps(), Double::sum);
        }
        if (byTeam.isEmpty()) {
            return;
        }

        ResearchSaveData data = ResearchSaveData.get(server);
        boolean dirty = false;

        for (Map.Entry<UUID, Double> entry : byTeam.entrySet()) {
            UUID teamId = entry.getKey();
            TeamResearchState state = data.team(teamId);
            if (state.purgeBoosts(now)) {
                dirty = true;
            }

            ResourceLocation tech = resolveTarget(server, data, teamId, state);
            if (tech == null) {
                continue;
            }

            TechDefinition def = ResearchData.techs().get(tech);
            if (def == null) {
                continue;
            }
            long taskId = ResearchTaskBinder.effectiveTaskId(tech, def, data);
            if (taskId < 0) {
                continue;
            }

double seconds = period / 20.0;
double rate = effectiveRate(entry.getValue(), def.rateScale(), state.boostRate(now));
double pointsPerSecond = Config.RESEARCH_POINTS_PER_TFPS_SECOND.get();

// 最短耗时封顶：算力堆再多也不允许快过这个速度，于是"至少要研究 N 分钟"
// 是硬下限而不是平均值。没配 duration_ticks 的科技不受影响（返回 +∞）。
double cap = def.maxPointsPerSecond(pointsPerSecond);
if (pointsPerSecond > cap) {
    pointsPerSecond = cap;
}
double points = rate * seconds * pointsPerSecond + state.carry(tech);

            long whole = (long) Math.floor(points);
            state.setCarry(tech, points - whole);
            dirty = true;

            if (whole > 0) {
                FtbBridge.addProgress(teamId, taskId, whole);
                if (FtbBridge.isCompleted(teamId, taskId) && !state.isCachedUnlocked(tech)) {
                    state.markUnlocked(tech);
                    LOGGER.info("[research] 队伍 {} 完成科技 {}", teamId, tech);
                }
            }
        }

        // 授权数据库是 FTB 真值的**派生镜像**，每个周期都重新对齐一次。
        // 不能只在"研究完成那一瞬间"写：科技可能早已完成（FTB 手动打勾、旧存档、
        // /ftbquests reset 后重做），那一刻的写入分支根本不会触发，库就永远是空的。
        syncAuthorizations(server, data, byTeam.keySet());

        if (now - lastBoostScan >= Config.RESEARCH_BOOST_SCAN_PERIOD.get()) {
            lastBoostScan = now;
            if (scanBoosts(server, data, byTeam.keySet(), now)) {
                dirty = true;
            }
        }

        if (dirty) {
            data.setDirty();
        }
    }

    private static void purgeStale(long now) {
        int ttl = Config.RESEARCH_CONTRIBUTION_TTL.get();
        CONTRIBUTIONS.entrySet().removeIf(e -> now - e.getValue().lastSeen() > ttl);
    }

    /**
     * 有效研究速率（tfps）= 机器算力 × rateScale + 限时增益。
     *
     * <p>抽成 public 是因为科研中心屏幕要用它算 ETA，而<b>两边必须用同一个公式</b>。
     * 各自算一遍的话，以后谁改了这里忘了改那里，玩家就会看到"ETA 越算越短、
     * 最后突然归零"这种看起来像 bug 的现象——而实际上只是两处公式不同步。
     *
     * <p>参数拆开而不是收 {@code TeamResearchState}：屏幕侧只需要拿两个数算一下，
     * 不该为了调个公式去构造一个队伍状态对象。
     */
    public static double effectiveRate(double machineTfps, double rateScale, double boostRate) {
        return machineTfps * rateScale + boostRate;
    }

    /**
     * 把「已解锁」状态从 FTB 真值同步进授权数据库。
     *
     * <p><b>为什么必须每周期做而不是只在完成瞬间写一次</b>：解锁真值在 FTB，
     * 而 FTB 的完成态有大量途径先于本模组的 tick 出现——玩家在任务书里手动打勾、
     * 旧存档里早就完成、{@code /ftbquests reset} 后重做完成。如果只在
     * {@code tick} 里"刚写完进度且判定完成"那一刻授权一次，这些情况全部会漏掉，
     * 数据库保持空表，于是硬盘刻出 0 项授权、门禁永远拦下。
     *
     * <p>所以这里做幂等镜像：每个活跃队伍遍历科技表，凡是 FTB 判定完成就授权。
     * {@code authorize} 内部是 Set.add，重复调用不会重复写也不会抛异常。
     *
     * @return 本次新授权的条目数（用于日志）
     */
    private static int syncAuthorizations(MinecraftServer server, ResearchSaveData data, Set<UUID> teamIds) {
        ResearchDatabase db = ResearchDatabase.get(server);
        int added = 0;
        for (UUID teamId : teamIds) {
            TeamResearchState state = data.team(teamId);
            for (ResourceLocation tech : ResearchData.techs().researchOrder()) {
                if (db.isAuthorized(teamId, tech)) {
                    continue; // 已有，跳过（绝大多数科技走这条，不碰 FTB）
                }
                long taskId = ResearchTaskBinder.effectiveTaskId(tech, ResearchData.techs().get(tech), data);
                if (taskId < 0) {
                    continue; // 没绑 FTB 任务，谈不上完成
                }
                if (FtbBridge.isCompleted(teamId, taskId)) {
                    db.authorize(teamId, tech);
                    state.markUnlocked(tech);
                    added++;
                }
            }
        }
        if (added > 0) {
            LOGGER.info("[research] 授权数据库新增 {} 条授权（已与 FTB 对齐）", added);
        }
        return added;
    }

    /**
     * 供命令 / 写盘前主动对齐：把该队伍已完成的科技全部写进授权数据库。
     *
     * <p>玩家右键硬盘或 {@code /shjtresearch write} 时会先调一次，
     * 这样即使从没跑过 tick（例如刚进游戏就直接刻盘）也能拿到完整授权。
     *
     * @return 该队伍当前已授权的科技数
     */
    public static int syncAuthorizations(MinecraftServer server, UUID teamId) {
        ResearchSaveData data = ResearchSaveData.get(server);
        syncAuthorizations(server, data, Set.of(teamId));
        return ResearchDatabase.get(server).authorizedTechs(teamId).size();
    }

    /**
     * 决定这个队伍本周期推进哪个科技：
     * 只允许推进<b>玩家显式设定</b>的焦点科技。焦点完成/未设定时不再自动开下一项，
     * 必须玩家重新用 {@code /shjtresearch focus <科技>} 或把科技写进身份卡后才开始，
     * 对应"研究完一项要等玩家点下一项"的需求。
     */
    @Nullable
    private static ResourceLocation resolveTarget(MinecraftServer server, ResearchSaveData data,
                                                  UUID teamId, TeamResearchState state) {
        ResourceLocation focus = state.focus();
        if (focus != null && ResearchData.techs().get(focus) != null && researchable(server, data, teamId, state, focus)) {
            return focus;
        }
        // 不自动推进下一项：没有有效焦点就idle，等玩家显式开始。
        return null;
    }

    /** 前置闭包全部完成，且自己还没完成 → 可研究。 */
    private static boolean researchable(MinecraftServer server, ResearchSaveData data, UUID teamId,
                                        TeamResearchState state, ResourceLocation tech) {
        // 已经研究完的不该再占着焦点
        if (isUnlocked(server, data, teamId, state, tech)) {
            return false;
        }
        for (ResourceLocation id : ResearchData.techs().closureOf(tech)) {
            if (id.equals(tech)) {
                continue; // 闭包含自身，前面已经单独判过了
            }
            if (!isUnlocked(server, data, teamId, state, id)) {
                return false;
            }
        }
        return true;
    }

    /** 该科技此刻能否开始研究（前置全解锁且自己没研究完）。 */
    public static boolean canResearch(MinecraftServer server, UUID teamId, ResourceLocation tech) {
        if (ResearchData.techs().get(tech) == null) {
            return false;
        }
        ResearchSaveData data = ResearchSaveData.get(server);
        return researchable(server, data, teamId, data.team(teamId), tech);
    }

    /**
     * 该科技还差哪些前置没解锁（{@link #researchable} 判否时给玩家看）。
     *
     * @return 未完成的前置 id；只差自己就是空集
     */
    public static List<ResourceLocation> missingPrerequisites(MinecraftServer server, UUID teamId,
                                                              ResourceLocation tech) {
        ResearchSaveData data = ResearchSaveData.get(server);
        TeamResearchState state = data.team(teamId);
        List<ResourceLocation> missing = new ArrayList<>();
        for (ResourceLocation id : ResearchData.techs().closureOf(tech)) {
            if (id.equals(tech)) {
                continue;
            }
            if (!isUnlocked(server, data, teamId, state, id)) {
                missing.add(id);
            }
        }
        return missing;
    }

    /** 该队伍本周期实际会推进的科技（供屏幕显示用）。 */
    @Nullable
    public static ResourceLocation currentTarget(MinecraftServer server, UUID teamId) {
        ResearchSaveData data = ResearchSaveData.get(server);
        return resolveTarget(server, data, teamId, data.team(teamId));
    }

    /**
     * 按研究顺序找<b>下一个可以开始研究的</b>科技，给身份卡右键切换用。
     *
     * <p>"可以开始研究"直接用 {@link #researchable} 判定，所以已经解锁的、以及
     * 前置还没做完的都会被跳过——玩家一路右键过去只会停在真正能推的科技上，
     * 不会选中一个插进去也不动的死目标。
     *
     * @param current 当前焦点，可为 null（表示还没选过）
     * @param forward true 向后找下一个，false 向前找上一个
     * @return 新的焦点科技；一项都轮不到时返回 null
     */
    @Nullable
    public static ResourceLocation cycleTarget(MinecraftServer server, UUID teamId,
                                               @Nullable ResourceLocation current, boolean forward) {
        ResearchSaveData data = ResearchSaveData.get(server);
        TeamResearchState state = data.team(teamId);
        List<ResourceLocation> order = ResearchData.techs().researchOrder();
        int size = order.size();
        if (size == 0) {
            return null;
        }
        int start = current == null ? -1 : order.indexOf(current);
        if (start < 0) {
            // 当前目标不在表里（科技被删了 / 还没选过）：从表头或表尾起步
            start = forward ? -1 : 0;
        }
        for (int step = 1; step <= size; step++) {
            int idx = Math.floorMod(start + (forward ? step : -step), size);
            ResourceLocation candidate = order.get(idx);
            if (ResearchData.techs().get(candidate) == null) {
                continue;
            }
            if (researchable(server, data, teamId, state, candidate)) {
                return candidate;
            }
        }
        return null;
    }

    // ------------------------------------------------------------------ 解锁查询

    /** 科技是否已解锁（真值在 FTB，本地只做缓存）。 */
    public static boolean isUnlocked(MinecraftServer server, UUID teamId, ResourceLocation tech) {
        ResearchSaveData data = ResearchSaveData.get(server);
        return isUnlocked(server, data, teamId, data.team(teamId), tech);
    }

    private static boolean isUnlocked(MinecraftServer server, ResearchSaveData data, UUID teamId,
                                      TeamResearchState state, ResourceLocation tech) {
        if (state.isCachedUnlocked(tech)) {
            return true;
        }
        TechDefinition def = ResearchData.techs().get(tech);
        if (def == null) {
            return false;
        }
        long taskId = ResearchTaskBinder.effectiveTaskId(tech, def, data);
        if (taskId < 0) {
            return false;
        }
        boolean done = FtbBridge.isCompleted(teamId, taskId);
        if (done) {
            state.markUnlocked(tech);
        }
        return done;
    }

    /**
     * 该队伍还有多少条科技没解锁。
     *
     * <p>科研中心屏幕用它区分「真的全研究完了」和「只是没选研究目标」——
     * 两者都表现为"当前没有在研究的科技"，但给玩家的提示天差地别。
     * 科技表通常只有几十条，且屏幕那边是降频调用的，逐个查 FTB 不划算也够用。
     */
    public static long remainingTechs(MinecraftServer server, UUID teamId) {
        ResearchSaveData data = ResearchSaveData.get(server);
        TeamResearchState state = data.team(teamId);
        long remaining = 0L;
        for (ResourceLocation tech : ResearchData.techs().researchOrder()) {
            if (!isUnlocked(server, data, teamId, state, tech)) {
                remaining++;
            }
        }
        return remaining;
    }

    // ------------------------------------------------------------------ 限时增益

    /** 扫描"加算力任务"是否完成，完成后发一段限时增益。任务被 reset 则清账本，可再次领取。 */
    private static boolean scanBoosts(MinecraftServer server, ResearchSaveData data, Set<UUID> activeTeams, long now) {
        boolean dirty = false;
        for (UUID teamId : activeTeams) {
            TeamResearchState state = data.team(teamId);
            for (BoostDefinition def : ResearchData.boosts().all()) {
                if (!def.isBound()) {
                    continue;
                }
                if (!FtbBridge.isCompleted(teamId, def.questTaskId())) {
                    // 任务未完成（或被 /ftbquests reset 重置）→ 清账本，允许下次再领
                    if (state.grantedUntil(def.id()) != null) {
                        state.clearGranted(def.id());
                        dirty = true;
                    }
                    continue;
                }
                if (state.grantedUntil(def.id()) != null) {
                    continue;
                }
                int stacks = countStacks(state, def.id());
                if (!def.stackable() && stacks >= 1 || stacks >= Math.max(1, def.maxStacks())) {
                    continue;
                }
                long expire = now + def.durationTicks();
                state.addBoost(new ComputeBoost(def.id(), def.rate(), expire));
                state.markGranted(def.id(), expire);
                dirty = true;
                LOGGER.info("[research] 队伍 {} 获得算力增益 {}（+{} tfps，{} tick）",
                        teamId, def.id(), def.rate(), def.durationTicks());
            }
        }
        return dirty;
    }

    private static int countStacks(TeamResearchState state, ResourceLocation boostId) {
        int n = 0;
        for (ComputeBoost b : state.boosts()) {
            if (b.sourceId().equals(boostId)) {
                n++;
            }
        }
        return n;
    }

    // ------------------------------------------------------------------ 调试

    public static List<String> debugLines(MinecraftServer server) {
        List<String> lines = new ArrayList<>();
        long now = server.overworld().getGameTime();
        Map<UUID, Double> totals = new HashMap<>();
        for (Contribution c : CONTRIBUTIONS.values()) {
            totals.merge(c.teamId(), c.tfps(), Double::sum);
        }
        lines.add("活跃机器: " + CONTRIBUTIONS.size() + "，活跃队伍: " + totals.size());
        ResearchSaveData data = ResearchSaveData.get(server);
        for (Map.Entry<UUID, Double> e : totals.entrySet()) {
            TeamResearchState state = data.team(e.getKey());
            double boost = state.boostRate(now);
            lines.add("  队伍 " + e.getKey() + " -> 机器算力 " + String.format("%.2f", e.getValue())
                    + " tfps + 增益 " + String.format("%.2f", boost) + " tfps"
                    + "，焦点 " + (state.focus() == null ? "自动" : state.focus()));
        }
        return lines;
    }

    /** 任务书被重置 / 重载后调用，清掉解锁缓存以免门禁误放行。 */
    public static void invalidate(MinecraftServer server) {
        ResearchSaveData data = ResearchSaveData.get(server);
        for (TeamResearchState state : data.teams().values()) {
            state.clearUnlockedCache();
        }
        data.setDirty();
    }

    private ResearchService() {
    }
}
