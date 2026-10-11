package com.shifen0520.shjtcore.research.team;

import com.shifen0520.shjtcore.research.ResearchIds;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.saveddata.SavedData;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 科研系统的存档。权威状态之一。
 *
 * <p>存三样：每队伍的小数余量 / 限时增益 / 发放账本、以及"科技 → FTB 任务 id"的覆写表。
 * 注意 MMCR 的 {@code DataStore} 不保证持久化，所以进度类数据绝不能只放那里。
 */
public final class ResearchSaveData extends SavedData {

    private static final String FILE_ID = ResearchIds.MODID + "_research";
    private static final int VERSION = 1;

    private final Map<UUID, TeamResearchState> teams = new HashMap<>();
    private final Map<ResourceLocation, Long> taskOverrides = new HashMap<>();

    // ------------------------------------------------------------------ 取用

    public static ResearchSaveData get(MinecraftServer server) {
        return server.overworld().getDataStorage().computeIfAbsent(
                new Factory<>(ResearchSaveData::new, ResearchSaveData::load), FILE_ID);
    }

    public TeamResearchState team(UUID teamId) {
        return teams.computeIfAbsent(teamId, unused -> new TeamResearchState());
    }

    @Nullable
    public TeamResearchState teamIfPresent(UUID teamId) {
        return teams.get(teamId);
    }

    public Map<UUID, TeamResearchState> teams() {
        return teams;
    }

    /** 任务 id 覆写表（/shjtresearch bind 写入，优先级高于 datapack JSON）。 */
    @Nullable
    public Long taskOverride(ResourceLocation techId) {
        return taskOverrides.get(techId);
    }

    public void setTaskOverride(ResourceLocation techId, long taskId) {
        taskOverrides.put(techId, taskId);
        setDirty();
    }

    public Map<ResourceLocation, Long> taskOverrides() {
        return taskOverrides;
    }

    // ------------------------------------------------------------------ NBT

    private static ResearchSaveData load(CompoundTag tag, HolderLookup.Provider provider) {
        ResearchSaveData data = new ResearchSaveData();
        int version = tag.getInt("version");

        CompoundTag overrides = tag.getCompound("overrides");
        for (String key : overrides.getAllKeys()) {
            data.taskOverrides.put(ResourceLocation.parse(key), overrides.getLong(key));
        }

        CompoundTag teamsTag = tag.getCompound("teams");
        for (String teamKey : teamsTag.getAllKeys()) {
            UUID teamId;
            try {
                teamId = UUID.fromString(teamKey);
            } catch (IllegalArgumentException e) {
                continue;
            }
            CompoundTag t = teamsTag.getCompound(teamKey);
            TeamResearchState state = new TeamResearchState();

            CompoundTag carry = t.getCompound("carry");
            for (String k : carry.getAllKeys()) {
                state.setCarry(ResourceLocation.parse(k), carry.getDouble(k));
            }

            ListTag boosts = t.getList("boosts", Tag.TAG_COMPOUND);
            for (int i = 0; i < boosts.size(); i++) {
                CompoundTag b = boosts.getCompound(i);
                state.addBoost(new ComputeBoost(
                        ResourceLocation.parse(b.getString("src")),
                        b.getDouble("rate"),
                        b.getLong("expire")));
            }

            CompoundTag granted = t.getCompound("granted");
            for (String k : granted.getAllKeys()) {
                state.markGranted(ResourceLocation.parse(k), granted.getLong(k));
            }

            ListTag unlocked = t.getList("unlocked", Tag.TAG_STRING);
            for (int i = 0; i < unlocked.size(); i++) {
                state.markUnlocked(ResourceLocation.parse(unlocked.getString(i)));
            }

            if (t.contains("focus")) {
                state.setFocus(ResourceLocation.parse(t.getString("focus")));
            }
            data.teams.put(teamId, state);
        }

        if (version != VERSION) {
            data.setDirty();
        }
        return data;
    }

    @Override
    public CompoundTag save(CompoundTag tag, HolderLookup.Provider provider) {
        tag.putInt("version", VERSION);

        CompoundTag overrides = new CompoundTag();
        taskOverrides.forEach((k, v) -> overrides.putLong(k.toString(), v));
        tag.put("overrides", overrides);

        CompoundTag teamsTag = new CompoundTag();
        teams.forEach((teamId, state) -> {
            CompoundTag t = new CompoundTag();

            CompoundTag carry = new CompoundTag();
            state.carryMap().forEach((k, v) -> carry.putDouble(k.toString(), v));
            t.put("carry", carry);

            ListTag boosts = new ListTag();
            for (ComputeBoost b : state.boosts()) {
                CompoundTag bt = new CompoundTag();
                bt.putString("src", b.sourceId().toString());
                bt.putDouble("rate", b.rate());
                bt.putLong("expire", b.expireGameTime());
                boosts.add(bt);
            }
            t.put("boosts", boosts);

            CompoundTag granted = new CompoundTag();
            state.grantedMap().forEach((k, v) -> granted.putLong(k.toString(), v));
            t.put("granted", granted);

            ListTag unlocked = new ListTag();
            for (ResourceLocation id : state.unlockedCache()) {
                unlocked.add(StringTag.valueOf(id.toString()));
            }
            t.put("unlocked", unlocked);

            if (state.focus() != null) {
                t.putString("focus", state.focus().toString());
            }
            teamsTag.put(teamId.toString(), t);
        });
        tag.put("teams", teamsTag);
        return tag;
    }
}
