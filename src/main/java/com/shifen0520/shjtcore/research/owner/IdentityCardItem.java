package com.shifen0520.shjtcore.research.owner;

import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

/**
 * 身份卡：机器的"归属凭证"。
 *
 * <p>MMCR 的机器上下文拿不到玩家/队伍（没有 owner、没有成型回调、没有右键钩子），
 * 所以归属只能靠这张卡：把它放进机器的<b>升级总线</b>槽位，
 * 机器通过 {@code MachineContext.upgradeItems()} 读到它，再解析成 FTB 队伍。
 *
 * <p><b>右键（对着空气）把自己写进卡里。</b>一张卡只回答"这台机器是谁的"，
 * 长期插在机器上不动；"这会儿研究哪条科技"交给 {@link ResearchTaskCardItem}，
 * 由玩家手持切换。两件事分开，换目标时不用把身份卡从机器里掏出来。
 *
 * <p>NBT 结构（写在 {@code CUSTOM_DATA} 里）：
 * <ul>
 *     <li>{@code owner}：绑定玩家 UUID</li>
 *     <li>{@code tech}：<b>已废弃</b>，仅在解析老存档里的旧卡时读取，见
 *         {@link OwnerResolver#resolveFocus}</li>
 * </ul>
 */
public class IdentityCardItem extends Item {

    public static final String TAG_OWNER = "owner";

    /**
     * 旧字段：拆分任务卡之前，焦点科技是写在身份卡上的。
     *
     * <p>保留读写方法纯粹为了不丢老存档里的卡面信息，
     * 新逻辑一律走 {@link ResearchTaskCardItem#TAG_TECH}。
     */
    public static final String TAG_TECH = "tech";

    public IdentityCardItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (level.isClientSide()) {
            return InteractionResultHolder.sidedSuccess(stack, true);
        }
        // 已绑定过就直接返回：避免反复右键刷聊天栏
        if (getOwner(stack) != null) {
            return InteractionResultHolder.sidedSuccess(stack, false);
        }
        setOwner(stack, player.getUUID());
        player.sendSystemMessage(Component.translatable("message.shjtcore.research.card_bound",
                player.getName().getString()));
        return InteractionResultHolder.sidedSuccess(stack, false);
    }

    // ------------------------------------------------------------------ 数据读写

    public static void setOwner(ItemStack stack, UUID playerUuid) {
        CustomData data = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        CompoundTag tag = data.copyTag();
        tag.putUUID(TAG_OWNER, playerUuid);
        stack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
    }

    @Nullable
    public static UUID getOwner(ItemStack stack) {
        CustomData data = stack.get(DataComponents.CUSTOM_DATA);
        if (data == null) {
            return null;
        }
        CompoundTag tag = data.copyTag();
        return tag.hasUUID(TAG_OWNER) ? tag.getUUID(TAG_OWNER) : null;
    }

    /** 卡上记录的科技 id（<b>仅供兼容老卡</b>，新逻辑走 {@link ResearchTaskCardItem}）。 */
    @Nullable
    public static ResourceLocation getTech(ItemStack stack) {
        CustomData data = stack.get(DataComponents.CUSTOM_DATA);
        if (data == null) {
            return null;
        }
        CompoundTag tag = data.copyTag();
        if (!tag.contains(TAG_TECH)) {
            return null;
        }
        try {
            return ResourceLocation.parse(tag.getString(TAG_TECH));
        } catch (RuntimeException e) {
            return null;
        }
    }

    public static void setTech(ItemStack stack, @Nullable ResourceLocation tech) {
        CustomData data = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        CompoundTag tag = data.copyTag();
        if (tech == null) {
            tag.remove(TAG_TECH);
        } else {
            tag.putString(TAG_TECH, tech.toString());
        }
        stack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
    }

    public static boolean isCard(ItemStack stack) {
        return getOwner(stack) != null;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context,
                                List<Component> tooltip, net.minecraft.world.item.TooltipFlag flag) {
        UUID owner = getOwner(stack);
        if (owner == null) {
            tooltip.add(Component.translatable("item.shjtcore.identity_card.unbound"));
            return;
        }
        tooltip.add(Component.translatable("item.shjtcore.identity_card.bound", owner.toString()));
        tooltip.add(Component.translatable("item.shjtcore.identity_card.placement_hint"));
    }
}
