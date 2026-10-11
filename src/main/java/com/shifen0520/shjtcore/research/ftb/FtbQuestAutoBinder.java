package com.shifen0520.shjtcore.research.ftb;

import com.mojang.logging.LogUtils;
import com.shifen0520.shjtcore.research.service.ResearchService;
import com.shifen0520.shjtcore.research.team.ResearchSaveData;
import net.minecraft.server.MinecraftServer;
import org.slf4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * 监视 FTB 任务书和科技 JSON 的文件改动，<b>自动重新绑定</b>。
 *
 * <p><b>为什么需要它</b>：FTB 的 {@code setMaxProgress} / {@code setCheck} 是<b>运行时</b>设置，
 * 不会写回 {@code config/ftbquests/quests/*.snbt}。所以在 FTB 编辑器里改完任务书、
 * 或者改了科技 JSON 的算力成本之后，必须重跑一次绑定才生效。
 * 以前这只能靠"记得敲 {@code /shjtresearch reload}"或者干脆重启服务器。
 *
 * <p><b>为什么用文件时间戳而不是文件哈希</b>：任务书 snbt 动辄几十万字节，
 * 每 tick 全量读进来算哈希纯属浪费。改任务书必然伴随 mtime 变化，
 * 用 {@code lastModified} 判断足够，且几乎零开销。
 *
 * <p><b>轮询间隔</b>：默认 40 tick（2 秒）。这个频率对玩家完全无感，
 * 又能在你保存任务书后两三秒内自动生效，省掉一次手动命令。
 *
 * <p><b>不做什么</b>：只在<b>检测到变化</b>时才重绑，并打日志说明重绑了多少条。
 * 没变化时完全不打扰，也不会刷屏。
 */
public final class FtbQuestAutoBinder {

    private static final Logger LOGGER = LogUtils.getLogger();

    /** 轮询间隔（tick）。2 秒一次，对玩家无感。 */
    private static final int POLL_INTERVAL_TICKS = 40;

    private static final FtbQuestAutoBinder INSTANCE = new FtbQuestAutoBinder();

    private MinecraftServer server;
    private int tickCounter;
    /** 上一次扫描到的文件时间戳；为空表示还没扫过（首次一定会触发一次重绑）。 */
    private Set<PathStamp> lastStamps = Set.of();
    /** 首次扫描不重绑（服务器启动时本来就会绑一次），否则日志会误导。 */
    private boolean firstScanDone;
    /**
     * 正在因为"检测到变化"而重绑中。
     *
     * <p>存在的唯一理由：重绑会自己写任务书文件，写完mtime 变了，
     * 下一轮轮询又会被当成"玩家改了东西"，于是无限重绑 → 无限写盘 → 死循环。
     */
    private boolean suppressSelfWrite;

    private record PathStamp(Path path, long modified) {
    }

    public static FtbQuestAutoBinder get() {
        return INSTANCE;
    }

    /** 服务器停止时清掉，避免换存档后还拿着上个存档的文件时间戳。 */
    public void reset() {
        server = null;
        tickCounter = 0;
        lastStamps = Set.of();
        firstScanDone = false;
    }

    public void attach(MinecraftServer server) {
        this.server = server;
        this.tickCounter = 0;
        // 重置 firstScanDone：换世界/重进游戏后要重新建立基线，
        // 但基线建立本身不触发重绑（onServerStarted 已经绑过了）。
        this.firstScanDone = false;
        this.lastStamps = Set.of();
    }

    /** 每 tick 调一次，内部自己节流。 */
    public void tick() {
        MinecraftServer svc = this.server;
        if (svc == null) {
            return;
        }
        if (++tickCounter < POLL_INTERVAL_TICKS) {
            return;
        }
        tickCounter = 0;

        Set<PathStamp> current = scanStamps(svc);
        if (!firstScanDone) {
            firstScanDone = true;
            lastStamps = current;
            return;
        }
        if (current.equals(lastStamps)) {
            return;
        }

        // 只把变化的路径打出来，方便判断是自己改的还是 FTB 自动重排的
        Set<Path> changed = new HashSet<>();
        for (PathStamp stamp : current) {
            if (!lastStamps.contains(stamp)) {
                changed.add(stamp.path());
            }
        }
        for (PathStamp stamp : lastStamps) {
            if (!current.contains(stamp)) {
                changed.add(stamp.path());
            }
        }
        lastStamps = current;

        // 自写盘守卫：重绑过程自己会写任务书（writeDataFull），
        // 写完 mtime 变了 → 下一轮又检测到"变化" → 再写一次……
        // 实测会变成每 2 秒一轮的死循环，日志刷屏而且每次都新建一批对象。
        // 这里把时间戳记成"这次重绑之后的样子"，让它下一轮扫到相同内容时闭嘴。
        suppressSelfWrite = true;

        LOGGER.info("[research] 检测到任务书/科技配置有改动（{} 个文件），自动重新绑定科研任务", changed.size());
        for (Path p : changed) {
            LOGGER.info("[research]   变化：{}", p.getFileName());
        }
        try {
            int bound = ResearchTaskBinder.bindAll(svc, ResearchService.techs(), ResearchSaveData.get(svc));
            LOGGER.info("[research] 自动重绑完成：{}/{} 个科研任务", bound, ResearchService.techs().size());
        } catch (Throwable t) {
            // 绝不能因为监视逻辑炸了把游戏带崩
            LOGGER.warn("[research] 自动重新绑定失败（不影响游戏，可手动执行 /shjtresearch reload）", t);
        } finally {
            // 关键：重绑过程自己写出去的文件，其 mtime 是"现在"，
            // 而 lastStamps 里记的还是"重绑之前"的旧 mtime。
            // 这里立刻重新扫一遍把基线对齐到当前状态，
            // 否则下一轮一定会把自写的那批文件当成玩家改动，又触发一轮重绑。
            lastStamps = suppressSelfWrite ? scanStamps(svc) : lastStamps;
            suppressSelfWrite = false;
        }
    }

    /**
     * 收集需要监视的文件时间戳。
     *
     * <p>监视范围刻意保守——只盯这两个目录：
     * <ul>
     *     <li>{@code config/ftbquests/}：FTB 编辑器保存任务书的地方</li>
     *     <li>科技 JSON 所在的数据包目录：改算力成本/绑定关系的地方</li>
     * </ul>
     * 全盘扫描存档目录会拖慢 tick，而且大部分文件与科研无关。
     */
    private Set<PathStamp> scanStamps(MinecraftServer svc) {
        Set<PathStamp> out = new HashSet<>();
        // 1) FTB 编辑器保存任务书的地方
        collect(out, svc.getServerDirectory().resolve("config").resolve("ftbquests"));
        // 2) 数据包：世界内的 datapacks + 服务端级datapacks
        Path world = svc.getServerDirectory().resolve(svc.getWorldData().getLevelName());
        collect(out, world.resolve("datapacks"));
        collect(out, svc.getServerDirectory().resolve("datapacks"));
        return out;
    }

    /** 递归收集目录下所有普通文件的 mtime。目录不存在就直接跳过（没装 FTB Quests 等情况）。 */
    private void collect(Set<PathStamp> out, Path root) {
        if (!Files.isDirectory(root)) {
            return;
        }
        // 限制深度，避免在超大整合包里递归过深
        try (Stream<Path> walk = Files.walk(root, 6)) {
            walk.filter(Files::isRegularFile)
                    .forEach(p -> {
                        try {
                            out.add(new PathStamp(p, Files.getLastModifiedTime(p).toMillis()));
                        } catch (IOException ignored) {
                            // 文件刚好被删/被占用，跳过即可
                        }
                    });
        } catch (IOException e) {
            LOGGER.debug("[research] 扫描 {} 失败", root, e);
        }
    }
}