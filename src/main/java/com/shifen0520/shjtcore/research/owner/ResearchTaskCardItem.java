package com.shifen0520.shjtcore.research.owner;

import com.shifen0520.shjtcore.research.data.TechDefinition;
import com.shifen0520.shjtcore.research.ftb.FtbBridge;
import com.shifen0520.shjtcore.research.service.ResearchService;
import com.shifen0520.shjtcore.research.team.ResearchSaveData;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

/**
 * 科研任务卡：给玩家挑"当前要研究哪条科技"的道具。
 *
 * <p><b>为什么单独一张卡</b>：身份卡（{@link IdentityCardItem}）解决的是
 * "这台机器是谁的"，必须一直插在升级总线上；任务卡解决的是"这台机器这会儿在研究什么"，
 * 是会频繁改的操作。把两者合并会出两个麻烦：换目标得把身份卡从机器里掏出来，
 * 而身份卡一旦离机器机器就失去归属。两张卡各管一件事，互不干扰。
 *
 * <p><b>用法</b>：对着空气右键 = 切到下一个可研究的科技，潜行右键 = 反向。
 * 只列出「未研究完 + 前置已完成」的，所以按几下一定会停在真能推的目标上。
 * 选完立即生效（写队伍状态），不必把卡插回任何机器。
 *
 * <p>NBT 写在 {@code CUSTOM_DATA} 里，只有一个字段：
 * <ul>
 *     <li>{@code tech}：本卡指定的科技 id；缺省表示交给自动推进</li>
 * </ul>
 */
public class ResearchTaskCardItem extends Item {

    public static final String TAG_TECH = "tech";

    public ResearchTaskCardItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        // 队伍解析在服务端，客户端直接跳过（否则会算出一个空目标）
        if (level.isClientSide() || !(player instanceof ServerPlayer serverPlayer)) {
            return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
        }
        MinecraftServer server = serverPlayer.getServer();
        if (server == null) {
            return InteractionResultHolder.sidedSuccess(stack, false);
        }

        UUID teamId = FtbBridge.teamIdOf(serverPlayer);
        if (teamId == null) {
            serverPlayer.sendSystemMessage(Component.translatable("message.shjtcore.research.task_card_no_team"));
            return InteractionResultHolder.sidedSuccess(stack, false);
        }

        boolean forward = !player.isShiftKeyDown();
        ResourceLocation current = getTech(stack);
        ResourceLocation next = ResearchService.cycleTarget(server, teamId, current, forward);
        if (next == null) {
            // 两种可能：全研究完了 / 前置都还没做（还有能研究的但都卡在依赖上）
            boolean allDone = ResearchService.remainingTechs(server, teamId) == 0L;
            serverPlayer.sendSystemMessage(Component.translatable(allDone
                    ? "message.shjtcore.research.task_card_all_done"
                    : "message.shjtcore.research.task_card_no_target"));
            return InteractionResultHolder.sidedSuccess(stack, false);
        }

        // cycleTarget 只返回 researchable 过的科技，这里再挡一道：
        // 万一 setFocus 的调用方以后绕过 cycleTarget 直接塞值，至少不会悄悄生效。
        List<ResourceLocation> missing = ResearchService.missingPrerequisites(server, teamId, next);
        if (!missing.isEmpty()) {
            serverPlayer.sendSystemMessage(Component.translatable(
                    "message.shjtcore.research.task_card_prereq_missing", describe(server, missing)));
            return InteractionResultHolder.sidedSuccess(stack, false);
        }

        // 卡上记一份（掉地上被别人捡走也不会错），队伍状态也写一份（当前机器立刻按新目标推进）
        setTech(stack, next);
        ResearchSaveData data = ResearchSaveData.get(server);
        data.team(teamId).setFocus(next);
        data.setDirty();

        TechDefinition def = ResearchService.techs().get(next);
        Component name = def == null ? Component.literal(next.toString()) : def.display();
        serverPlayer.sendSystemMessage(Component.translatable("message.shjtcore.research.task_card_focus",
                name, Component.literal(next.toString())));
        return InteractionResultHolder.sidedSuccess(stack, false);
    }

    // ------------------------------------------------------------------ 数据读写

    public static boolean isTaskCard(ItemStack stack) {
        return stack.getItem() instanceof ResearchTaskCardItem;
    }

    /** 卡上指定的科研任务；null 表示"自动推进"。 */
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
            // 科技被删 / 手改坏了 NBT：当成没指定，别让 tooltip 崩掉
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

    // ------------------------------------------------------------------ 悬停提示

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context,
                                List<Component> tooltip, TooltipFlag flag) {
        ResourceLocation tech = getTech(stack);
        tooltip.add(tech == null
                ? Component.translatable("item.shjtcore.research_task_card.auto")
                : Component.translatable("item.shjtcore.research_task_card.focus", displayName(tech)));
        tooltip.add(Component.translatable("item.shjtcore.research_task_card.cycle_hint"));
    }

    /**
     * 科技的中文显示名，供 tooltip 用。
     *
     * <p>tooltip 里显示裸 id（{@code shjtcore:basic_computing}）对玩家毫无意义，
     * 这里翻成 display 里的名字。科技表是 datapack 数据，客户端理论上有，
     * 但加载时序不保证，所以取不到就退回 id，绝不因为渲染 tooltip 抛异常。
     */
    private static Component displayName(ResourceLocation tech) {
        try {
            TechDefinition def = ResearchService.techs().get(tech);
            if (def != null) {
                return def.display();
            }
        } catch (Throwable ignored) {
            // 客户端数据还没就绪：退回 id
        }
        return Component.literal(tech.toString());
    }

    /** 把科技 id 列表翻成中文名，用顿号分隔（给玩家看的报错）。 */
    private static String describe(MinecraftServer server, List<ResourceLocation> ids) {
        StringBuilder sb = new StringBuilder();
        for (ResourceLocation id : ids) {
            if (sb.length() > 0) {
                sb.append('、');
            }
            sb.append(displayName(id).getString());
        }
        return sb.toString();
    }
}
