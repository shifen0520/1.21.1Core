package com.shifen0520.shjtcore.client;

import com.shifen0520.shjtcore.SHJTCore;
import com.shifen0520.shjtcore.material.Material;
import com.shifen0520.shjtcore.material.MaterialForm;
import com.shifen0520.shjtcore.material.MaterialRegistry;
import com.shifen0520.shjtcore.material.data.MaterialDataTypes;
import com.shifen0520.shjtcore.material.data.RgbColorData;
import com.shifen0520.shjtcore.material.form.BlockForm;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

/**
 * 客户端染色注册（1.21.1 正确姿势）。
 *
 * <p>为什么需要这个类：registrylib 8.0.16 的
 * {@code builder.tintSource(...)} / {@code blockTintSource(...)}
 * 整体被 {@code doDatagen()} 包住 —— 只在数据生成进程里生效，
 * 正常启动游戏时什么都不注册，于是物品/方块全显示灰度模板原色
 * （截图中"灰色方块"就是这个原因）。
 *
 * <p>这里用 1.21.1 的 {@link RegisterColorHandlersEvent.Item} / {@code .Block}
 * 按材料注册运行时染色：tintIndex 0 → 主色，1 → 副色，其他 → 白（不染）。
 *
 * <p>注册时机：由 {@link com.shifen0520.shjtcore.client.SHJTCoreClient} 在客户端
 * 把这两个方法挂到 mod 事件总线上（RegisterColorHandlersEvent 属于 MOD bus）。
 * 不用 {@code @EventBusSubscriber(bus = Bus.MOD)} 是因为 1.21.1 里 bus() 已废弃并
 * 标记移除，行为不再可靠。
 */
public final class ClientTintSetup {

    private ClientTintSetup() {
    }

    private static int primary(Material m) {
        return m.data(MaterialDataTypes.PRIMARY_COLOR).map(RgbColorData::rgb).orElse(0xFFFFFF);
    }

    private static int secondary(Material m) {
        return m.data(MaterialDataTypes.SECONDARY_COLOR).map(RgbColorData::rgb).orElse(0xFFFFFF);
    }

    /** ItemColor/BlockColor 要的是 0xAARRGGBB，材料里存的是 0xRRGGBB，必须补 alpha。 */
    private static int opaque(int rgb) {
        return 0xFF000000 | (rgb & 0xFFFFFF);
    }

    /** 分层染色：模型第 0 层主色、第 1 层副色、更高层（overlay 高光）不染。 */
    private static int tintByIndex(Material m, int tintIndex) {
        return opaque(switch (tintIndex) {
            case 0 -> primary(m);
            case 1 -> secondary(m);
            default -> 0xFFFFFF;
        });
    }

    public static void onItemColors(RegisterColorHandlersEvent.Item event) {
        int count = 0;
        for (Material material : MaterialRegistry.registered()) {
            String path = material.id().getPath();
            for (MaterialForm form : material.forms()) {
                if (form.isFluid()) {
                    // 流体桶：<流体名>_bucket。
                    // 注意 clientExtension 只负责"流体方块"的渲染，管不到桶物品；
                    // 桶物品的第 0 层是流体覆盖层（灰度，必须染主色），
                    // 第 1 层是原版桶底（不能染，否则桶也变成材料色）。
                    Item bucket = BuiltInRegistries.ITEM.get(
                            ResourceLocation.fromNamespaceAndPath(SHJTCore.MODID,
                                    form.registryName(path) + "_bucket"));
                    if (bucket == Items.AIR) {
                        continue;
                    }
                    int tint = opaque(primary(material));
                    event.register((stack, tintIndex) -> tintIndex == 0 ? tint : 0xFFFFFFFF, bucket);
                    count++;
                    continue;
                }
                Item item = BuiltInRegistries.ITEM.get(
                        ResourceLocation.fromNamespaceAndPath(SHJTCore.MODID, form.registryName(path)));
                if (item == Items.AIR) {
                    continue;
                }
                ItemColor color = (stack, tintIndex) -> tintByIndex(material, tintIndex);
                event.register(color, item);
                count++;
            }
        }
        SHJTCore.LOGGER.info("Registered runtime item tints for {} material items", count);
    }

    public static void onBlockColors(RegisterColorHandlersEvent.Block event) {
        int count = 0;
        for (Material material : MaterialRegistry.registered()) {
            String path = material.id().getPath();
            for (MaterialForm form : material.forms()) {
                if (!(form instanceof BlockForm)) {
                    continue;
                }
                Block block = BuiltInRegistries.BLOCK.get(
                        ResourceLocation.fromNamespaceAndPath(SHJTCore.MODID, form.registryName(path)));
                if (block == Blocks.AIR) {
                    continue;
                }
                event.register((state, level, pos, tintIndex) -> tintByIndex(material, tintIndex), block);
                count++;
            }
        }
        SHJTCore.LOGGER.info("Registered runtime block tints for {} material blocks", count);
    }
}
