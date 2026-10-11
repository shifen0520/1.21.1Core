package com.shifen0520.shjtcore.research.data;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

/**
 * 一条科技定义，来自 datapack：{@code data/<ns>/research/tech/<path>.json}。
 *
 * <p><b>FTB 任务要玩家自己在编辑器里建</b>：建好 Custom 任务后，把它的标题写进
 * JSON 的 {@code quest_task_title}（推荐）或把它的 id 写进 {@code quest_task}，
 * mod 只负责把算力上限配上去。也可以直接在游戏里用 {@code /shjtresearch bind}。
 *
 * @param id            科技 id，由文件路径决定
 * @param display       显示名
 * @param computingCost 研究所需算力点，会写进 FTB CustomTask 的 maxProgress
 * @param durationTicks  该科技的<b>最短耗时</b>（tick）。即使算力无限也至少要这么久，
 *                      避免"堆节点就瞬间完成"。≤0 表示不限制（纯按算力折算）
 * @param requires      前置科技（传递闭包，图必须无环）
 * @param machines      该科技解锁的机器 id（供反查与展示；真正的门禁靠代码调用 TechGate）
 * @param order         自动推进排序权重，越小越先研究；同时决定 FTB 任务在章节里的格子位置
 * @param rateScale     该科技的研究效率倍率
 * @param questTaskId   手动指定的 FTB 任务 id，负数表示未指定。<b>优先级最低</b>，
 *                      id 会随任务增删漂移，尽量用 {@code quest_task_title}
 * @param questTaskTitle 手动指定的 FTB 任务标题。<b>推荐</b>：标题是稳定的语义标识，
 *                      在编辑器里增删排序任务都不会错位
 */
public record TechDefinition(
        ResourceLocation id,
        Component display,
        long computingCost,
        long durationTicks,
        List<ResourceLocation> requires,
        List<ResourceLocation> machines,
        int order,
        double rateScale,
        long questTaskId,
        String questTaskTitle
) {

    /** 1 游戏小时 = 72000 tick。 */
    public static final long TICKS_PER_HOUR = 72_000L;

    /** 是否设了最短耗时。 */
    public boolean hasDuration() {
        return durationTicks > 0L;
    }

    /**
     * 这条科技允许的<b>最大</b>研究速率（点/秒）。
     *
     * <p>由 {@code computingCost / durationTicks} 反推：算力再高也不允许快于这个速度，
     * 于是"最短耗时"是一个<b>硬下限</b>而不是平均值。
     *
     * <p>没设 {@code durationTicks} 时返回 {@link Double#POSITIVE_INFINITY}，
     * 即不封顶——保持旧行为。
     */
    public double maxPointsPerSecond(double pointsPerTfpsSecond) {
        if (!hasDuration() || pointsPerTfpsSecond <= 0.0) {
            return Double.POSITIVE_INFINITY;
        }
        double seconds = durationTicks / 20.0;
        if (seconds <= 0.0) {
            return Double.POSITIVE_INFINITY;
        }
        return computingCost / seconds;
    }

    /** 最短耗时的人类可读描述（屏幕 / 报错用），已本地化。 */
    public Component durationText() {
        if (!hasDuration()) {
            return Component.translatable("tech.shjtcore.duration.none");
        }
        long minutes = durationTicks / 1200L;
        if (minutes < 1L) {
            return Component.translatable("tech.shjtcore.duration.seconds",
                    String.valueOf(Math.max(1L, durationTicks / 20L)));
        }
        return Component.translatable("tech.shjtcore.duration.minutes",
                String.valueOf(minutes));
    }

    /** 是否绑定了 FTB 任务（标题或 id 任一给了就算）。 */
    public boolean isBound() {
        return questTaskTitle != null || questTaskId >= 0;
    }

    /** 是否显式给了任务标题（{@code quest_task_title}）。 */
    public boolean hasTitle() {
        return questTaskTitle != null && !questTaskTitle.isBlank();
    }
}
