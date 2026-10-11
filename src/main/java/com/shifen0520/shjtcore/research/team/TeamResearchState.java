package com.shifen0520.shjtcore.research.team;

import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 单个 FTB 队伍的科研状态。
 *
 * <p>这里存的都是<b>FTB 里存不下</b>的东西：小数余量、限时增益、发放账本。
 * 科技是否解锁的真值仍然以 FTB 的任务完成状态为准，{@code unlockedCache} 只是缓存。
 */
public final class TeamResearchState {

    /** 各科技累积的小数余量。速率很低时若每次都取整会永远推不动进度。 */
    private final Map<ResourceLocation, Double> carry = new HashMap<>();

    /** 生效中的限时增益。 */
    private final List<ComputeBoost> boosts = new ArrayList<>();

    /** 增益发放账本：boostId → 到期时间。防止同一任务反复发放。 */
    private final Map<ResourceLocation, Long> grantedBoosts = new HashMap<>();

    /** 解锁缓存；可被清空后按 FTB 真值重建。 */
    private final Set<ResourceLocation> unlockedCache = new HashSet<>();

    /** 队伍当前研究目标；null = 自动推进。 */
    @Nullable
    private ResourceLocation focus;

    // ------------------------------------------------------------------ 小数余量

    public double carry(ResourceLocation tech) {
        return carry.getOrDefault(tech, 0.0);
    }

    public void setCarry(ResourceLocation tech, double value) {
        if (value <= 0.0) {
            carry.remove(tech);
        } else {
            carry.put(tech, value);
        }
    }

    // ------------------------------------------------------------------ 增益

    public List<ComputeBoost> boosts() {
        return boosts;
    }

    /** 移除已过期的增益，返回是否有变化。 */
    public boolean purgeBoosts(long now) {
        return boosts.removeIf(b -> b.expired(now));
    }

    public void addBoost(ComputeBoost boost) {
        boosts.add(boost);
    }

    /** 当前生效的增益总速率。 */
    public double boostRate(long now) {
        double total = 0.0;
        for (ComputeBoost b : boosts) {
            if (!b.expired(now)) {
                total += b.rate();
            }
        }
        return total;
    }

    @Nullable
    public Long grantedUntil(ResourceLocation boostId) {
        return grantedBoosts.get(boostId);
    }

    public void markGranted(ResourceLocation boostId, long expireGameTime) {
        grantedBoosts.put(boostId, expireGameTime);
    }

    public void clearGranted(ResourceLocation boostId) {
        grantedBoosts.remove(boostId);
    }

    // ------------------------------------------------------------------ 解锁缓存

    public boolean isCachedUnlocked(ResourceLocation tech) {
        return unlockedCache.contains(tech);
    }

    public void markUnlocked(ResourceLocation tech) {
        unlockedCache.add(tech);
    }

    public void clearUnlockedCache() {
        unlockedCache.clear();
    }

    public Set<ResourceLocation> unlockedCache() {
        return unlockedCache;
    }

    // ------------------------------------------------------------------ 焦点科技

    @Nullable
    public ResourceLocation focus() {
        return focus;
    }

    public void setFocus(@Nullable ResourceLocation tech) {
        this.focus = tech;
    }

    // ------------------------------------------------------------------ NBT

    public Map<ResourceLocation, Double> carryMap() {
        return carry;
    }

    public Map<ResourceLocation, Long> grantedMap() {
        return grantedBoosts;
    }
}
