package com.shifen0520.shjtcore.research.owner;

import cn.howxu.mmcr.publicapi.behavior.MachineContext;
import cn.howxu.mmcr.publicapi.data.DataKey;
import cn.howxu.mmcr.publicapi.data.DataStore;
import com.shifen0520.shjtcore.research.ResearchIds;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * 从机器的升级总线里读身份卡，解析出"这台机器归哪个 FTB 队伍"。
 *
 * <p>MMCR 没有 owner 概念，这是唯一可靠的归属来源。
 * 解析结果缓存在机器的 DataStore 里（key: {@code team}），
 * 由调用方在 {@code isDue(...)} 时刷新，避免每 tick 都遍历物品。
 */
public final class OwnerResolver {

    /** 解析成功返回队伍 UUID；读不到卡 / 玩家离线 / 没有队伍都返回 null。 */
    @Nullable
    public static UUID resolveTeam(MachineContext ctx) {
        DataStore storage = ctx.dataStorage();
        MinecraftServer server = ctx.level().getServer();
        if (server == null) {
            return null;
        }

        // 先读缓存（DataStore 不保证持久化，丢了就重新解析，无所谓）
        if (storage != null) {
            Optional<DataKey> cached = storage.get(ResearchIds.KEY_TEAM);
            if (cached.isPresent()) {
                Optional<String> value = cached.get().asString();
                if (value.isPresent()) {
                    try {
                        return UUID.fromString(value.get());
                    } catch (IllegalArgumentException ignored) {
                        // 缓存坏了，走下面的重新解析
                    }
                }
            }
        }

        UUID teamId = resolveFromCards(server, ctx.upgradeItems());
        if (storage != null && teamId != null) {
            storage.set(ResearchIds.KEY_TEAM, DataKey.of(teamId.toString()));
        }
        return teamId;
    }

    @Nullable
    private static UUID resolveFromCards(MinecraftServer server, List<ItemStack> upgrades) {
        UUID owner = null;
        for (ItemStack stack : upgrades) {
            if (stack.isEmpty()) {
                continue;
            }
            UUID candidate = IdentityCardItem.getOwner(stack);
            if (candidate == null) {
                continue;
            }
            if (owner == null) {
                owner = candidate;
            } else if (!owner.equals(candidate)) {
                // 多个人的卡：只认第一张，避免算力串队
                break;
            }
        }
        if (owner == null) {
            return null;
        }

        ServerPlayer player = server.getPlayerList().getPlayer(owner);
        if (player != null) {
            // 在线：走 FTB 的玩家→队伍解析（内部会过 FTB Teams）
            var teamData = com.shifen0520.shjtcore.research.ftb.FtbBridge.teamOfPlayer(player);
            if (teamData != null) {
                return teamData.getTeamId();
            }
        }
        // 离线：拿不到队伍，直接退回玩家 UUID。单人未组队时 FTB 也是这么存的。
        return owner;
    }

    /** 卡上指定的焦点科技；null = 自动推进。 */
    @Nullable
    public static ResourceLocation resolveFocus(MachineContext ctx) {
        ResourceLocation fromTaskCard = null;
        ResourceLocation fromLegacyCard = null;
        for (ItemStack stack : ctx.upgradeItems()) {
            if (stack.isEmpty()) {
                continue;
            }
            // 任务卡是正规来源；身份卡上的 tech 是拆分任务卡之前的老字段，只作兼容回退
            if (ResearchTaskCardItem.isTaskCard(stack)) {
                ResourceLocation tech = ResearchTaskCardItem.getTech(stack);
                if (tech != null) {
                    fromTaskCard = tech;
                }
            } else {
                ResourceLocation tech = IdentityCardItem.getTech(stack);
                if (tech != null) {
                    fromLegacyCard = tech;
                }
            }
        }
        return fromTaskCard != null ? fromTaskCard : fromLegacyCard;
    }

    private OwnerResolver() {
    }
}
