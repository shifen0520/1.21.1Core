package com.shifen0520.shjtcore.research.data;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

/**
 * 一条限时算力增益定义，来自 datapack：{@code data/<ns>/research/boost/<path>.json}。
 *
 * <p>因为本项目采用<b>流量直通</b>模型（算力不存储），"FTB 任务加算力"只能表达成
 * 一段限时增益：在 {@code durationTicks} 内给队伍额外 {@code rate} 的 tfps。
 *
 * @param questTaskId 触发源：这个 FTB 任务完成时发放增益
 * @param rate        额外算力速率（tfps）
 * @param durationTicks 持续 tick 数
 * @param stackable   可否与自身叠加
 * @param maxStacks   最大叠加层数
 */
public record BoostDefinition(
        ResourceLocation id,
        Component display,
        long questTaskId,
        double rate,
        long durationTicks,
        boolean stackable,
        int maxStacks
) {
    public boolean isBound() {
        return questTaskId >= 0;
    }
}
