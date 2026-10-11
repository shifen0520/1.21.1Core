package com.shifen0520.shjtcore.research.team;

import net.minecraft.resources.ResourceLocation;

/**
 * 一条生效中的限时算力增益。
 *
 * @param sourceId        来源增益 id
 * @param rate            额外 tfps
 * @param expireGameTime  到期时间，用 {@code server.overworld().getGameTime()} 计
 */
public record ComputeBoost(ResourceLocation sourceId, double rate, long expireGameTime) {

    public boolean expired(long now) {
        return now >= expireGameTime;
    }
}
