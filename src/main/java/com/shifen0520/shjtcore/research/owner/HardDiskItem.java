package com.shifen0520.shjtcore.research.owner;

import com.shifen0520.shjtcore.research.db.ResearchDatabase;
import com.shifen0520.shjtcore.research.ftb.FtbBridge;
import com.shifen0520.shjtcore.research.service.ResearchService;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * 硬盘：把授权数据库的授权数据"刻"进物品里，作为门禁的物理钥匙。
 *
 * <p>类比格雷科技的数据棒：研究完成后，把授权从数据库拷进这张硬盘（右键 / {@code /shjtresearch write}），
 * 再把硬盘放进量子装配机的<b>升级总线</b>槽位，机器读盘校验后放行。
 *
 * <p><b>硬盘分等级</b>，等级决定<b>能刻多少条授权</b>：
 * <pre>
 * T1 基础盘  4 条
 * T2 加密盘 16 条
 * T3 扩容盘 64 条
 * T4 量子盘 不限（{@link #UNLIMITED}）
 * </pre>
 * 刻盘时按<b>研究顺序</b>取前 N 条——先研究完的科技优先保留，
 * 所以低等级盘的"取舍"符合直觉：越早解锁的越该留在盘上。
 * 容量不够时会明确告诉玩家"还有多少条没刻进去"，避免以为刻满了。
 *
 * <p><b>容量只卡写入、不卡校验</b>：门禁只查"盘里这条授权在不在"，不查盘等级。
 * 这样低等级盘刻 4 条照样能用，玩家不必为每个机器配一块顶级盘。
 *
 * <p>NBT 结构（写在 {@code CUSTOM_DATA} 里）：
 * <ul>
 *     <li>{@code owner}：写盘玩家 UUID</li>
 *     <li>{@code team}：被授权的队伍 UUID（与数据库主键一致）</li>
 *     <li>{@code auth}：已授权的科技 id 列表</li>
 *     <li>{@code written}：是否已写入</li>
 * </ul>
 */
public class HardDiskItem extends Item {

    public static final String TAG_OWNER = "owner";
    public static final String TAG_TEAM = "team";
    public static final String TAG_AUTH = "auth";
    public static final String TAG_WRITTEN = "written";

    /** 容量哨兵值：不限。 */
    public static final int UNLIMITED = Integer.MAX_VALUE;

    /** 本盘能刻的授权条数。 */
    private final int capacity;

    public HardDiskItem(Properties properties, Tier tier) {
        super(properties);
        this.capacity = tier.capacity;
    }

    /** 本盘能刻的授权条数。 */
    public int capacity() {
        return capacity;
    }

    /** 容量是否无上限。 */
    public boolean isUnlimited() {
        return capacity == UNLIMITED;
    }

    /**
     * 硬盘等级。
     *
     * <p>等级只影响"能刻多少条"，门禁校验不看等级——见类注释。
     * 容量取 4 的幂次，是为了让"研究顺序第 k 条"和"等级允许的 k"对应得上，
     * 科技表扩容时不用重调数值。
     */
    public enum Tier {
        T1("basic", 4),
        T2("encrypted", 16),
        T3("expanded", 64),
        /** 最高级：不限条数，能刻下全部授权。 */
        T4("quantum", UNLIMITED);

        private final String key;
        private final int capacity;

        Tier(String key, int capacity) {
            this.key = key;
            this.capacity = capacity;
        }

        public int capacity() {
            return capacity;
        }

        /** 翻译键后缀，拼成 {@code item.shjtcore.hard_disk.<key>}。 */
        public String key() {
            return key;
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        // FTB 队伍解析与数据库都在服务端，客户端直接跳过（否则会写出一个空盘）
        if (!level.isClientSide() && player instanceof ServerPlayer serverPlayer) {
            writeFromDatabase(stack, serverPlayer);
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }

    /** 把玩家所在队伍的数据库授权写入这张硬盘（右键或命令共用）。 */
    public static void writeFromDatabase(ItemStack stack, ServerPlayer player) {
        MinecraftServer server = player.getServer();
        if (server == null) {
            return;
        }
        UUID owner = player.getUUID();
        UUID team = FtbBridge.teamIdOf(player);
        if (team == null) {
            team = owner; // 单人未组队时，队伍即玩家自身（与 OwnerResolver 的回退一致）
        }
        // 刻盘前先按 FTB 真值对齐一次数据库：否则玩家刚进游戏就直接右键刻盘、
        // 或科技是在 FTB 里手动打勾完成（没经过本模组 tick）时，会刻出一张 0 项授权的空盘。
        ResearchService.syncAuthorizations(server, team);
        Set<ResourceLocation> all = ResearchDatabase.get(server).authorizedTechs(team);
        Result result = write(stack, owner, team, all);

        if (result.dropped() > 0) {
            player.sendSystemMessage(Component.translatable("message.shjtcore.research.disk_capacity_warning",
                    capacityTextOf(stack), String.valueOf(result.kept()), String.valueOf(result.dropped())));
        } else {
            player.sendSystemMessage(Component.translatable("message.shjtcore.research.disk_bound",
                    player.getName().getString(), String.valueOf(result.kept())));
        }
        if (result.kept() == 0) {
            // 空盘几乎总是"还没研究完 / 没绑 FTB 任务"，直接给出下一步，省得反复试
            player.sendSystemMessage(Component.translatable("message.shjtcore.research.disk_empty_hint"));
        }
    }

    /** 本盘的容量描述（供命令与提示复用）。 */
    public static Component capacityTextOf(ItemStack stack) {
        return stack.getItem() instanceof HardDiskItem disk ? disk.capacityComponent() : Component.empty();
    }

    private Component capacityComponent() {
        return isUnlimited()
                ? Component.translatable("item.shjtcore.hard_disk.capacity.unlimited")
                : Component.translatable("item.shjtcore.hard_disk.capacity.limited", capacity);
    }

    /**
     * 刻盘结果：实际写进去多少条、被容量挡掉多少条。
     *
     * @param kept    写进 NBT 的条数
     * @param dropped 因超出容量没写进去的条数（0 = 全刻下了）
     */
    public record Result(int kept, int dropped) {
    }

    /** 直接写盘（供命令或测试调用）。会按本盘容量截断。 */
    public static Result write(ItemStack stack, UUID owner, UUID team, Set<ResourceLocation> techs) {
        int capacity = stack.getItem() instanceof HardDiskItem disk ? disk.capacity : UNLIMITED;
        // 按研究顺序排序后截断：先研究完的先留，低等级盘的取舍才符合直觉
        List<ResourceLocation> ordered = orderByResearch(techs);
        int limit = capacity == UNLIMITED ? ordered.size() : Math.min(capacity, ordered.size());
        Set<ResourceLocation> kept = new LinkedHashSet<>(ordered.subList(0, limit));
        int dropped = ordered.size() - limit;

        CustomData data = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        CompoundTag tag = data.copyTag();
        tag.putUUID(TAG_OWNER, owner);
        tag.putUUID(TAG_TEAM, team);
        ListTag list = new ListTag();
        for (ResourceLocation t : kept) {
            list.add(StringTag.valueOf(t.toString()));
        }
        tag.put(TAG_AUTH, list);
        tag.putBoolean(TAG_WRITTEN, true);
        stack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
        return new Result(kept.size(), dropped);
    }

    /**
     * 把授权集合按研究顺序排好。
     *
     * <p>拿不到科技表时（客户端 / 科技还没加载）退化成按 id 字典序，
     * 至少保证<b>同一个盘每次刻出来内容一致</b>——顺序随机的话，
     * 低等级盘每次丢掉的可能不是同一条科技，玩家会以为系统在乱来。
     */
    private static List<ResourceLocation> orderByResearch(Set<ResourceLocation> techs) {
        if (techs.isEmpty()) {
            return List.of();
        }
        List<ResourceLocation> order;
        try {
            order = ResearchService.techs().researchOrder();
        } catch (Throwable t) {
            order = null;
        }
        if (order == null || order.isEmpty()) {
            List<ResourceLocation> fallback = new ArrayList<>(techs);
            fallback.sort(ResourceLocation::compareTo);
            return fallback;
        }
        // researchOrder 里可能有表外的 id（科技被删），只按表内顺序排，表外的沉底
        Set<ResourceLocation> known = new HashSet<>(order);
        List<ResourceLocation> sorted = new ArrayList<>(techs.size());
        for (ResourceLocation id : order) {
            if (techs.contains(id)) {
                sorted.add(id);
            }
        }
        List<ResourceLocation> rest = new ArrayList<>();
        for (ResourceLocation id : techs) {
            if (!known.contains(id)) {
                rest.add(id);
            }
        }
        rest.sort(ResourceLocation::compareTo);
        sorted.addAll(rest);
        return sorted;
    }

    // ------------------------------------------------------------------ 识别与读取

    public static boolean isHardDisk(ItemStack stack) {
        return stack.getItem() instanceof HardDiskItem;
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

    @Nullable
    public static UUID getTeam(ItemStack stack) {
        CustomData data = stack.get(DataComponents.CUSTOM_DATA);
        if (data == null) {
            return null;
        }
        CompoundTag tag = data.copyTag();
        return tag.hasUUID(TAG_TEAM) ? tag.getUUID(TAG_TEAM) : null;
    }

    public static boolean isWritten(ItemStack stack) {
        CustomData data = stack.get(DataComponents.CUSTOM_DATA);
        if (data == null) {
            return false;
        }
        return data.copyTag().getBoolean(TAG_WRITTEN);
    }

    /** 硬盘里记录的授权科技集合（未写入时返回空集合）。 */
    public static Set<ResourceLocation> getAuth(ItemStack stack) {
        CustomData data = stack.get(DataComponents.CUSTOM_DATA);
        if (data == null) {
            return Set.of();
        }
        CompoundTag tag = data.copyTag();
        if (!tag.contains(TAG_AUTH)) {
            return Set.of();
        }
        Set<ResourceLocation> result = new HashSet<>();
        ListTag list = tag.getList(TAG_AUTH, Tag.TAG_STRING);
        for (int i = 0; i < list.size(); i++) {
            try {
                result.add(ResourceLocation.parse(list.getString(i)));
            } catch (RuntimeException ignored) {
                // 手改坏的单条跳过，别让整张盘读不出来
            }
        }
        return result;
    }

    // ------------------------------------------------------------------ 悬停提示

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context,
                               List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(capacityComponent());
        UUID owner = getOwner(stack);
        if (owner == null) {
            tooltip.add(Component.translatable("item.shjtcore.hard_disk.unbound"));
            return;
        }
        tooltip.add(Component.translatable("item.shjtcore.hard_disk.bound", owner.toString()));
        if (!isWritten(stack)) {
            tooltip.add(Component.translatable("item.shjtcore.hard_disk.empty"));
            return;
        }
        Set<ResourceLocation> authSet = getAuth(stack);
        tooltip.add(Component.translatable("item.shjtcore.hard_disk.written", authSet.size()));
        for (ResourceLocation t : authSet) {
            tooltip.add(Component.translatable("item.shjtcore.hard_disk.auth", t.toString()));
        }
    }
}
