package com.shifen0520.shjtcore;

import com.gto.registrylib.RegistryCore;
import com.gto.registrylib.builders.ItemBuilder;
import com.shifen0520.shjtcore.material.Material;
import com.shifen0520.shjtcore.material.MaterialForm;
import com.shifen0520.shjtcore.material.MaterialForms;
import com.shifen0520.shjtcore.material.MaterialRegistry;
import com.shifen0520.shjtcore.material.form.MaterialFormRegistry;
import com.shifen0520.shjtcore.material.form.BlockForm;
import com.shifen0520.shjtcore.material.form.ItemForm;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * 把材料 + 形态落成真实的物品 / 方块。
 *
 * <p>遍历 {@link MaterialRegistry#registered()}，跳过流体形态（流体由 {@link Fluids} 单独注册），
 * 其余按形态类型注册：
 * <ul>
 *   <li>{@link ItemForm}（锭/粉/板/杆…）→ 物品，进 materials 标签页</li>
 *   <li>{@link BlockForm}（压缩方块）→ 方块，其方块物品进 blocks 标签页</li>
 * </ul>
 * 物品名、显示名（lang）、模型（model）都交给 registrylib 在数据生成阶段产出。
 */
public final class Items {

    private Items() {
    }

    public static void register() {
        // 收集所有 (材料, 形态) 对，按「形态种类 → 材料名」排序后注册，
        // 这样创造标签页里物品按种类分区（所有锭一片、所有粉一片…），组内按字母序。
        List<ItemEntry> entries = new ArrayList<>();
        for (Material material : MaterialRegistry.registered()) {
            for (MaterialForm form : material.forms()) {
                if (form.isFluid()) {
                    continue;
                }
                if (isVanillaDuplicate(material.id().getPath(), form)) {
                    continue; // 原版已有同样东西，不重复注册
                }
                entries.add(new ItemEntry(material, form));
            }
        }
        List<MaterialForm> formOrder = MaterialFormRegistry.all();
        entries.sort(Comparator
                .comparingInt((ItemEntry e) -> formOrder.indexOf(e.form))
                .thenComparing(e -> e.material.id().getPath()));

        for (ItemEntry entry : entries) {
            Material material = entry.material;
            MaterialForm form = entry.form;
            String materialPath = material.id().getPath();
            String name = form.registryName(materialPath);
            String displayName = MaterialNames.display(materialPath) + " " + form.displayName();

            if (form instanceof ItemForm itemForm) {
                ItemBuilder<Item, RegistryCore> builder =
                        SHJTCore.REGISTRY.item(name, Item::new);
                builder.lang(displayName);
                if (itemForm.render() != null) {
                    itemForm.render().apply(builder, material);
                }
                // 按形态挂常见标签（c: 约定，参考 GTM）：c:{commonTag}/{material} + 聚合标签 c:{commonTag}
                String commonTag = form.commonTag();
                if (commonTag != null && !commonTag.isEmpty()) {
                    builder.addTag(TagKey.create(Registries.ITEM,
                            ResourceLocation.fromNamespaceAndPath("c", commonTag + "/" + materialPath)));
                    builder.addTag(TagKey.create(Registries.ITEM,
                            ResourceLocation.fromNamespaceAndPath("c", commonTag)));
                }
                // 材料类物品默认进 materials 标签页
                builder.addDefaultTab();
                builder.register();
            } else if (form instanceof BlockForm blockForm) {
                var builder = SHJTCore.REGISTRY.block(name, Block::new);
                builder.lang(displayName);
                // 渲染模板必须先应用：它一次性决定方块模型、方块染色源和方块物品的染色源。
                if (blockForm.render() != null) {
                    blockForm.render().apply(builder, material);
                }
                builder.properties(p -> p.strength(5.0F, 6.0F));
                String blockTag = form.commonTag();
                if (blockTag != null && !blockTag.isEmpty()) {
                    builder.addTag(TagKey.create(Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath("c", blockTag + "/" + materialPath)));
                    builder.addTag(TagKey.create(Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath("c", blockTag)));
                }
                builder.addTag(TagKey.create(Registries.BLOCK,
                        ResourceLocation.fromNamespaceAndPath("minecraft", "mineable/pickaxe")));
                // 方块物品：进 "blocks" 标签页，并挂同名物品标签
                builder.item(blockItem -> {
                    blockItem.addTab(BuiltinSHJTCreativeTabs.BLOCKS_KEY);
                    if (blockTag != null && !blockTag.isEmpty()) {
                        blockItem.addTag(TagKey.create(Registries.ITEM,
                                ResourceLocation.fromNamespaceAndPath("c", blockTag + "/" + materialPath)));
                        blockItem.addTag(TagKey.create(Registries.ITEM,
                                ResourceLocation.fromNamespaceAndPath("c", blockTag)));
                    }
                }).register();
            }
        }
    }

    /**
     * 原版 Minecraft 已经提供了成品的形态，就不再重复注册。
     *
     * <p>铁/金/铜：原版有 iron_ingot / raw_iron / iron_block；下界合金：原版有锭和块。
     * 这些材料的 GTM 专有形态（粉、板、杆、齿轮…）照常注册，流体也照常。
     */
    private static final Set<String> VANILLA_MATERIALS = Set.of("iron", "gold", "copper", "netherite");

    private static boolean isVanillaDuplicate(String materialPath, MaterialForm form) {
        if (!VANILLA_MATERIALS.contains(materialPath)) {
            return false;
        }
        return form == MaterialForms.INGOT || form == MaterialForms.RAW_ORE || form == MaterialForms.BLOCK;
    }

    /** 排序用的 (材料, 形态) 对。 */
    private record ItemEntry(Material material, MaterialForm form) {
    }

}
