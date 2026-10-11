package com.shifen0520.shjtcore.research.db;

import com.shifen0520.shjtcore.research.ResearchIds;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.saveddata.SavedData;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * 授权数据库：门禁系统的权威数据源。
 *
 * <p>存的是「哪个队伍被授权运行哪些受门禁的机器/配方」——即 {@code 队伍UUID -> 已授权科技集合}。
 * 研究完成（或 {@code /shjtresearch grant}）时写入；硬盘（{@link com.shifen0520.shjtcore.research.owner.HardDiskItem}）
 * 从这儿把授权拷进物品 NBT，再由机器从升级总线读盘校验。
 *
 * <p>挂在主世界 {@code SavedData} 上，随服务器存档持久化，重启不丢。
 */
public final class ResearchDatabase extends SavedData {

    private static final String FILE_ID = ResearchIds.MODID + "_auth_db";
    private static final int VERSION = 1;

    private final Map<UUID, Set<ResourceLocation>> auth = new HashMap<>();

    // ------------------------------------------------------------------ 取用

    public static ResearchDatabase get(MinecraftServer server) {
        return server.overworld().getDataStorage().computeIfAbsent(
                new Factory<>(ResearchDatabase::new, ResearchDatabase::load), FILE_ID);
    }

    /** 授权某队伍运行某科技对应的受门禁机器。 */
    public void authorize(UUID teamId, ResourceLocation tech) {
        auth.computeIfAbsent(teamId, unused -> new HashSet<>()).add(tech);
        setDirty();
    }

    /** 某队伍是否被授权运行该科技对应的机器。 */
    public boolean isAuthorized(UUID teamId, ResourceLocation tech) {
        Set<ResourceLocation> set = auth.get(teamId);
        return set != null && set.contains(tech);
    }

    /** 某队伍被授权的全部科技（不可变快照）。 */
    public Set<ResourceLocation> authorizedTechs(UUID teamId) {
        return Set.copyOf(auth.getOrDefault(teamId, Set.of()));
    }

    /** 整库内容（调试用）。 */
    public Map<UUID, Set<ResourceLocation>> all() {
        return auth;
    }

    // ------------------------------------------------------------------ NBT

    private static ResearchDatabase load(CompoundTag tag, HolderLookup.Provider provider) {
        ResearchDatabase db = new ResearchDatabase();
        int version = tag.getInt("version");

        CompoundTag teams = tag.getCompound("teams");
        for (String key : teams.getAllKeys()) {
            UUID teamId;
            try {
                teamId = UUID.fromString(key);
            } catch (IllegalArgumentException e) {
                continue;
            }
            Set<ResourceLocation> set = new HashSet<>();
            ListTag list = teams.getList(key, Tag.TAG_STRING);
            for (int i = 0; i < list.size(); i++) {
                set.add(ResourceLocation.parse(list.getString(i)));
            }
            db.auth.put(teamId, set);
        }

        if (version != VERSION) {
            db.setDirty();
        }
        return db;
    }

    @Override
    public CompoundTag save(CompoundTag tag, HolderLookup.Provider provider) {
        tag.putInt("version", VERSION);

        CompoundTag teams = new CompoundTag();
        auth.forEach((teamId, set) -> {
            ListTag list = new ListTag();
            for (ResourceLocation t : set) {
                list.add(StringTag.valueOf(t.toString()));
            }
            teams.put(teamId.toString(), list);
        });
        tag.put("teams", teams);
        return tag;
    }
}
