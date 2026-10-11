package com.shifen0520.shjtcore.research.ftb;

import com.mojang.logging.LogUtils;
import dev.ftb.mods.ftbquests.quest.BaseQuestFile;
import dev.ftb.mods.ftbquests.quest.Quest;
import dev.ftb.mods.ftbquests.quest.QuestObjectBase;
import dev.ftb.mods.ftbquests.quest.ServerQuestFile;
import dev.ftb.mods.ftbquests.quest.TeamData;
import dev.ftb.mods.ftbquests.quest.task.CustomTask;
import dev.ftb.mods.ftbquests.quest.task.Task;
import dev.ftb.mods.ftbquests.quest.translation.TranslationKey;
import dev.ftb.mods.ftbquests.quest.translation.TranslationManager;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * FTB Quests 桥接层。<b>整个项目只有这里能调 FTB 的 API</b>。
 *
 * <p>签名已按 FTB Quests <b>2101.1.x（1.21.1/main 分支）</b>核对过：
 * <ul>
 *     <li>{@code ServerQuestFile.INSTANCE} 是 public 静态字段（不是 getInstance()——
 *         那个返回的是 Optional，语义不一样）。</li>
 *     <li>{@code BaseQuestFile.getOrCreateTeamData(Entity)} 内部已经走 FTB Teams 把玩家
 *         解析成队伍，所以这里不需要再依赖 FTB Teams API。</li>
 *     <li>{@code CustomTask} 的 setCheck / setCheckTimer / setMaxProgress / setEnableButton 都在。</li>
 * </ul>
 */
public final class FtbBridge {

    private static final Logger LOGGER = LogUtils.getLogger();

    @Nullable
    public static BaseQuestFile file() {
        return ServerQuestFile.INSTANCE;
    }

    @Nullable
    public static CustomTask task(long taskId) {
        BaseQuestFile file = file();
        if (file == null) {
            return null;
        }
        return file.getTask(taskId) instanceof CustomTask custom ? custom : null;
    }

    /**
     * 按标题查找 CustomTask。
     *
     * <p><b>为什么用标题而不是 id</b>：FTB 的任务 id 按创建顺序分配，
     * 删一个中间任务会让后面全部错位，而错绑不会报错、只是研究推进到了
     * 别的科技上——这种错极难发现。标题是稳定的语义标识。
     *
     * <p><b>为什么不能只比 {@code getRawTitle()}</b>（这就是"task 永远是 -1"的根因）：
     * 字节码实证 {@code QuestObjectBase.getRawTitle()} 在服务端走的是
     * <pre>
     *   getTranslationManager().getStringTranslation(this, getQuestFile().getLocale(), TITLE)
     *       .orElse("")
     * </pre>
     * 而 {@code ServerQuestFile.getLocale()} 直接返回 {@code getFallbackLocale()}，
     * 也就是 {@code data.snbt} 里的 {@code fallback_locale}（默认 {@code en_us}）。
     * <p>偏偏 FTB <b>编辑器</b>在客户端是按<b>客户端语言</b>把标题写进
     * {@code lang/<locale>.snbt} 的（键名 {@code quest.<ID>.title}），中文客户端就写进
     * {@code lang/zh_cn.snbt}、<b>不写 en_us</b>，而 quest 的 snbt 里根本没有 title 字段。
     * 于是服务端拿 {@code en_us} 去查必然查不到 → 标题变空串 → 按标题匹配全部失败。
     *
     * <p>所以这里按<b>多来源</b>匹配：snbt 原始值 → 翻译表里<b>任意 locale</b> 的 title；
     * 对象上先看 <b>Quest</b> 再看任务自己（原因见 {@link #taskTitle}）。
     * 这样中文客户端建的标题也能被服务端认出来，与客户端语言无关。
     *
     * @return 匹配的 CustomTask；没找到返回 null
     */
    @Nullable
    public static CustomTask taskByTitle(String title) {
        BaseQuestFile file = file();
        if (file == null || title == null || title.isBlank()) {
            return null;
        }
        String needle = title.trim();
        for (Task t : file.getAllTasks()) {
            if (t instanceof CustomTask custom && titleMatches(custom, needle)) {
                return custom;
            }
        }
        return null;
    }

    /**
     * 这个 CustomTask 是否匹配标题 {@code needle}：<b>所属 Quest 的标题也算</b>。
     *
     * <p><b>为什么必须看 Quest</b>：玩家在 FTB 编辑器里点开一个任务格，右边那个大大的
     * "Title" 字段改的是 <b>Quest</b> 的标题（翻译键 {@code quest.<ID>.title}），
     * 而 {@code task.*.title} 是任务格里面那个小条目的名字（默认"算力"这种）。
     * 只比任务自己的标题，玩家按提示填的科技名永远匹配不上。
     */
    private static boolean titleMatches(CustomTask task, String needle) {
        if (titleOf(task).equals(needle)) {
            return true;
        }
        Quest quest = task.getQuest();
        return quest != null && titleOf(quest).equals(needle);
    }

    /**
     * 取 CustomTask"人能看到"的标题：<b>优先所属 Quest 的标题</b>，没有才用任务自己的。
     *
     * <p>Quest 标题也优先取 snbt 原始值，为空再按 locale 顺序找第一个非空翻译
     * （FTB 编辑器建的标题只存在翻译表里，见 {@link #taskByTitle}）。
     */
    public static String taskTitle(CustomTask task) {
        Quest quest = task.getQuest();
        if (quest != null) {
            String t = titleOf(quest);
            if (!t.isEmpty()) {
                return t;
            }
        }
        return titleOf(task);
    }

    /**
     * 任务书里所有 Custom 任务的 {@code id=标题} 摘要，用于绑定失败时的诊断日志。
     *
     * <p>把"我实际能看到的标题"直接打出来，省得再去逐条执行 {@code /shjtresearch tasks}。
     */
    public static List<String> customTaskSummaries() {
        List<String> out = new ArrayList<>();
        BaseQuestFile file = file();
        if (file == null) {
            return out;
        }
        for (Task t : file.getAllTasks()) {
            if (t instanceof CustomTask custom) {
                String title = taskTitle(custom);
                out.add(t.id + "=" + (title.isEmpty() ? "(无标题)" : title));
            }
        }
        return out;
    }

    /**
     * 取这个对象"人能看到"的标题：优先 snbt 原始值，为空则按 locale 顺序找第一个非空翻译。
     *
     * <p>服务端 {@code getRawTitle()} 只有 {@code data.snbt} 的 {@code fallback_locale}
     * 那一份翻译表可见，所以中文客户端建的标题必须靠这条兜底路径才读得到。
     */
    public static String titleOf(QuestObjectBase obj) {
        String raw = rawTitle(obj);
        if (!raw.isEmpty()) {
            return raw;
        }
        for (String locale : locales(obj)) {
            String t = translationTitle(obj, locale);
            if (!t.isEmpty()) {
                return t;
            }
        }
        return "";
    }

    /** 取指定 locale 下的 title 翻译；查不到返回空串。 */
    private static String translationTitle(QuestObjectBase obj, String locale) {
        try {
            var manager = obj.getQuestFile().getTranslationManager();
            return manager.getStringTranslation(obj, locale, TranslationKey.TITLE).orElse("");
        } catch (Throwable t) {
            return "";
        }
    }

    /**
     * 翻译表里目前有内容的全部 locale。
     *
     * <p>FTB 没有公开"列出所有 locale"的 API（{@code TranslationManager.map} 是私有的），
     * 所以反射取一下 keySet；拿不到就退回常见语言列表，至少中文/英文这两种覆盖到。
     * 反射失败不是致命问题，只是匹配能力退化，所以异常一律吞掉。
     */
    private static List<String> locales(QuestObjectBase obj) {
        if (obj == null) {
            return FALLBACK_LOCALES;
        }
        try {
            var manager = obj.getQuestFile().getTranslationManager();
            Object raw = MAP_FIELD.get(manager);
            if (raw instanceof Map<?, ?> m && !m.isEmpty()) {
                List<String> out = new ArrayList<>(m.size());
                for (Object k : m.keySet()) {
                    if (k instanceof String s) {
                        out.add(s);
                    }
                }
                return out;
            }
        } catch (Throwable ignored) {
            // 反射失败：退回固定列表
        }
        return FALLBACK_LOCALES;
    }

    /** 反射不到翻译表时的兜底 locale 列表。 */
    private static final List<String> FALLBACK_LOCALES = List.of("zh_cn", "en_us");

    /** {@code TranslationManager.map}（locale → 翻译表）。FTB 没给 getter，只能反射。 */
    private static final java.lang.reflect.Field MAP_FIELD = findMapField();

    private static java.lang.reflect.Field findMapField() {
        try {
            var f = TranslationManager.class.getDeclaredField("map");
            f.setAccessible(true);
            return f;
        } catch (Throwable t) {
            LOGGER.warn("[research] 拿不到 TranslationManager.map，标题匹配将退回固定 locale 列表", t);
            return null;
        }
    }

    /**
     * 取任务的原始标题，异常时返回空串而不是外抛。
     *
     * <p>注意：服务端下这里读的是<b>翻译表</b>而不是 snbt 原始值（见
     * {@link #taskByTitle} 的说明），所以它<b>不能</b>单独作为标题的真相来源。
     * 不同 FTB Quests 版本的 {@code getRawTitle()} 也可能返回 {@code null}，
     * 这里统一压成空串，调用方只需判空一次。
     */
    public static String rawTitle(QuestObjectBase obj) {
        try {
            String raw = obj == null ? null : obj.getRawTitle();
            return raw == null ? "" : raw.trim();
        } catch (Throwable t) {
            return "";
        }
    }

    /** 按标题或 id 取任务：标题优先，标题没给才回落到 id。 */
    @Nullable
    public static CustomTask resolveTask(Long taskId, String title) {
        CustomTask byTitle = taskByTitle(title);
        if (byTitle != null) {
            return byTitle;
        }
        return taskId == null || taskId < 0 ? null : task(taskId);
    }

    /** 玩家 → 队伍数据（内部会解析到 FTB 队伍，没有队伍时返回 null）。 */
    @Nullable
    public static TeamData teamOfPlayer(ServerPlayer player) {
        BaseQuestFile file = file();
        return file == null ? null : file.getOrCreateTeamData(player);
    }

    @Nullable
    public static TeamData team(UUID teamId) {
        BaseQuestFile file = file();
        return file == null ? null : file.getOrCreateTeamData(teamId);
    }

    /** 玩家 → 队伍 UUID；没有队伍时返回 null。 */
    @Nullable
    public static UUID teamIdOf(ServerPlayer player) {
        TeamData data = teamOfPlayer(player);
        return data == null ? null : data.getTeamId();
    }

    public static long progress(UUID teamId, long taskId) {
        CustomTask task = task(taskId);
        if (task == null) {
            return 0L;
        }
        TeamData data = team(teamId);
        return data == null ? 0L : data.getProgress(task);
    }

    public static long maxProgress(long taskId) {
        CustomTask task = task(taskId);
        return task == null ? 0L : task.getMaxProgress();
    }

    /**
     * 该队伍是否已完成这个任务。
     *
     * <p><b>必须挡掉 {@code maxProgress <= 0}</b>：FTB 的完成判定本质是
     * {@code progress >= maxProgress}，上限为 0 时"0 >= 0"成立，
     * 于是<b>任何</b>没配过上限的任务都会被判成已完成。绑定失败或任务书还没
     * 加载完时上限就是默认值，这条防护能让"全部科技已完成"这种假象不再出现。
     */
    public static boolean isCompleted(UUID teamId, long taskId) {
        CustomTask task = task(taskId);
        if (task == null) {
            return false;
        }
        if (task.getMaxProgress() <= 0L) {
            return false;
        }
        TeamData data = team(teamId);
        return data != null && data.isCompleted(task);
    }

    /**
     * 给研究任务加进度。
     *
     * <p>三个必须做的防护，缺一个都会出事：
     * <ol>
     *     <li>{@code addProgress} 内部只 clamp 到 [0, max]，<b>不阻止减少</b>——
     *         传负数会把已完成的任务进度往回扣，所以只接受正数。</li>
     *     <li>先判 {@code isCompleted}，完成后不再写入。</li>
     *     <li>按剩余量截断，避免无意义写入。</li>
     * </ol>
     *
     * @return 实际写入的量
     */
    public static long addProgress(UUID teamId, long taskId, long amount) {
        if (amount <= 0L) {
            return 0L;
        }
        CustomTask task = task(taskId);
        if (task == null) {
            return 0L;
        }
        TeamData data = team(teamId);
        if (data == null) {
            return 0L;
        }
        if (data.isCompleted(task)) {
            return 0L;
        }
        long remaining = Math.max(0L, task.getMaxProgress() - data.getProgress(task));
        long toAdd = Math.min(amount, remaining);
        if (toAdd <= 0L) {
            return 0L;
        }
        data.addProgress(task, toAdd);
        return toAdd;
    }

    /**
     * 把一个 CustomTask 配成"纯算力推进"模式：上限 = 科技成本，关掉自动检测与手动提交按钮。
     *
     * <p>{@code setCheck(null)} 之后 {@code autoSubmitOnPlayerTick()} 返回 0，
     * FTB 不会再自己检测这个任务，进度完全由研究机写入。
     *
     * @param task 已经解析好的任务（按标题或 id 查来的都行）
     */
    public static boolean configure(CustomTask task, long maxProgress) {
        if (task == null) {
            LOGGER.warn("[research] configure 收到 null 任务，已跳过");
            return false;
        }
        task.setMaxProgress(maxProgress);
        task.setCheck(null);
        task.setCheckTimer(0);
        task.setEnableButton(false);
        return true;
    }

    /** 按 id取任务再配置，保留给只需要 id 的调用方。 */
    public static boolean configure(long taskId, long maxProgress) {
        return configure(task(taskId), maxProgress);
    }

    private FtbBridge() {
    }
}
