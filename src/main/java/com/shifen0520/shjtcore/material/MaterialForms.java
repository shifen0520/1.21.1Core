package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;
import com.shifen0520.shjtcore.material.form.BlockForm;
import com.shifen0520.shjtcore.material.form.FluidForm;
import com.shifen0520.shjtcore.material.form.ItemForm;
import com.shifen0520.shjtcore.material.form.MaterialFormRegistry;
import com.shifen0520.shjtcore.material.render.TintedTemplate;

/**
 * 内置标准材料形态（ingot/dust/plate/gear/fluid…）的注册引导类。
 * 对应 odysseyindustrial 的 com.gto.oi.data.material.BuiltinOIMaterialForms。
 *
 * 注意：twtdlcore 最初误用了 {@code MaterialForm.INGOT} 这类并不存在的静态字段，
 * 标准形态必须在此处通过 MaterialFormRegistry.register(...) 真正注册后才能被 Materials 引用。
 */
public final class MaterialForms {
    /** 金属块（方块形态）：凡有锭的材料都会额外注册一个 <材料>_block 方块。 */
    public static final MaterialForm BLOCK;
    public static final MaterialForm INGOT;
    public static final MaterialForm DUST;
    public static final MaterialForm PLATE;
    public static final MaterialForm GEAR;
    public static final MaterialForm FLUID;
    /** 气态元素形态：低密度、低粘度、常温（300K）。气态材料挂此形态后由 Fluids 注册为流体。 */
    public static final MaterialForm GAS;
    /** 液态元素形态：接近水的密度/粘度。液态元素（如溴、汞）挂此形态后由 Fluids 注册为流体。 */
    public static final MaterialForm LIQUID;

    // 补全的固体材料形态（参考 GTM 形态划分，复用既有染色贴图）
    public static final MaterialForm NUGGET;
    public static final MaterialForm DUST_SMALL;
    public static final MaterialForm DUST_TINY;
    public static final MaterialForm ROD;
    public static final MaterialForm ROD_LONG;
    public static final MaterialForm GEAR_SMALL;
    public static final MaterialForm PLATE_DENSE;
    public static final MaterialForm BOLT;
    public static final MaterialForm FOIL;
    public static final MaterialForm RING;
    public static final MaterialForm SCREW;

    // ===== 补全形态：命名对齐 GTM，贴图沿用 OI 模板 =====
    /** 细导线（对应 GTM 的 GENERATE_FINE_WIRE）。注意：是细导线物品，不是线圈方块，也不是线缆方块。 */
    public static final MaterialForm WIRE_FINE;
    /** 元素气体（纯色流体，区别于化合物的灰度水/岩浆纹理）。 */
    public static final MaterialForm ELEMENT_GAS;
    /** 熔融态元素液体（纯色流体，温度为真实熔点，如铁水 1811K）。 */
    public static final MaterialForm ELEMENT_LIQUID;
    /** 常温液态元素（汞、溴）：常温即为液体、非熔化所得，用液体纹理而非熔融岩浆纹理。 */
    public static final MaterialForm ELEMENT_FLUID;
    /** 弹簧。 */
    public static final MaterialForm SPRING;
    /** 小弹簧。 */
    public static final MaterialForm SPRING_SMALL;
    /** 双层板。 */
    public static final MaterialForm PLATE_DOUBLE;
    /** 热锭（对应 GTM 的 hot ingot）。 */
    public static final MaterialForm INGOT_HOT;
    /** 纳米蜂群（对应 GTOCore 的 GENERATE_NANITES）：动画贴图，仅高等级材料拥有。 */
    public static final MaterialForm NANITES;

    private MaterialForms() {
    }

    /** 显式触发类初始化（静态块里完成注册）。空实现，仅为调用方提供语义清晰的入口。 */
    public static void init() {
    }

    static {
        INGOT = MaterialFormRegistry.register("ingot", id -> ItemForm.builder()
                .suffix("ingot").displayName("Ingot").commonTag("ingots")
                .render(TintedTemplate.item(
                        TintedTemplate.tinted(MaterialDataTypes.PRIMARY_COLOR, "item/material/ingot"),
                        TintedTemplate.tinted(MaterialDataTypes.SECONDARY_COLOR, "item/material/ingot_secondary"),
                        TintedTemplate.flat("item/material/ingot_overlay")))
                .build(id));

        DUST = MaterialFormRegistry.register("dust", id -> ItemForm.builder()
                .suffix("dust").displayName("Dust").commonTag("dusts")
                .render(TintedTemplate.item(
                        TintedTemplate.tinted(MaterialDataTypes.PRIMARY_COLOR, "item/material/dust"),
                        TintedTemplate.tinted(MaterialDataTypes.SECONDARY_COLOR, "item/material/dust_secondary")))
                .build(id));

        PLATE = MaterialFormRegistry.register("plate", id -> ItemForm.builder()
                .suffix("plate").displayName("Plate").commonTag("plates")
                .render(TintedTemplate.item(
                        TintedTemplate.tinted(MaterialDataTypes.PRIMARY_COLOR, "item/material/plate"),
                        TintedTemplate.tinted(MaterialDataTypes.SECONDARY_COLOR, "item/material/plate_secondary"),
                        TintedTemplate.flat("item/material/plate_overlay")))
                .build(id));

        GEAR = MaterialFormRegistry.register("gear", id -> ItemForm.builder()
                .suffix("gear").displayName("Gear").commonTag("gears")
                .render(TintedTemplate.item(
                        TintedTemplate.tinted(MaterialDataTypes.PRIMARY_COLOR, "item/material/gear"),
                        TintedTemplate.tinted(MaterialDataTypes.SECONDARY_COLOR, "item/material/gear_secondary"),
                        TintedTemplate.flat("item/material/gear_overlay")))
                .build(id));

        FLUID = MaterialFormRegistry.register("fluid", id -> FluidForm.builder()
                .suffix("fluid").displayName("Fluid").commonTag("fluids")
                .texture("block/fluid/fluid_still", "block/fluid/fluid_flow")
                .build(id));

        GAS = MaterialFormRegistry.register("gas", id -> FluidForm.builder()
                .suffix("fluid").displayName("Gas").commonTag("gases")
                .density(1).viscosity(10).temperature(300).tintColor(0xFFFFFFFF)
                .texture("block/fluid/gas_still", "block/fluid/gas_flow")
                .build(id));

        LIQUID = MaterialFormRegistry.register("liquid", id -> FluidForm.builder()
                .suffix("fluid").displayName("Liquid").commonTag("liquids")
                .density(1000).viscosity(1000).temperature(300).tintColor(0xFFFFFFFF)
                .texture("block/fluid/molten_still", "block/fluid/molten_flow")
                .build(id));

        // ===== 以下为补全的固体材料形态，复用既有染色贴图（参考 GTM 的形态划分） =====

        NUGGET = MaterialFormRegistry.register("nugget", id -> ItemForm.builder()
                .suffix("nugget").displayName("Nugget").commonTag("nuggets")
                .render(TintedTemplate.item(
                        TintedTemplate.tinted(MaterialDataTypes.PRIMARY_COLOR, "item/material/nugget"),
                        TintedTemplate.tinted(MaterialDataTypes.SECONDARY_COLOR, "item/material/nugget_secondary"),
                        TintedTemplate.flat("item/material/nugget_overlay")))
                .build(id));

        DUST_SMALL = MaterialFormRegistry.register("dust_small", id -> ItemForm.builder()
                .suffix("dust_small").displayName("Dust Small").commonTag("dusts_small")
                .render(TintedTemplate.item(
                        TintedTemplate.tinted(MaterialDataTypes.PRIMARY_COLOR, "item/material/dust_small"),
                        TintedTemplate.tinted(MaterialDataTypes.SECONDARY_COLOR, "item/material/dust_small_secondary")))
                .build(id));

        DUST_TINY = MaterialFormRegistry.register("dust_tiny", id -> ItemForm.builder()
                .suffix("dust_tiny").displayName("Tiny Dust").commonTag("dusts_tiny")
                .render(TintedTemplate.item(
                        TintedTemplate.tinted(MaterialDataTypes.PRIMARY_COLOR, "item/material/dust_tiny"),
                        TintedTemplate.tinted(MaterialDataTypes.SECONDARY_COLOR, "item/material/dust_tiny_secondary")))
                .build(id));

        ROD = MaterialFormRegistry.register("rod", id -> ItemForm.builder()
                .suffix("rod").displayName("Rod").commonTag("rods")
                .render(TintedTemplate.item(
                        TintedTemplate.tinted(MaterialDataTypes.PRIMARY_COLOR, "item/material/rod"),
                        TintedTemplate.tinted(MaterialDataTypes.SECONDARY_COLOR, "item/material/rod_secondary")))
                .build(id));

        ROD_LONG = MaterialFormRegistry.register("rod_long", id -> ItemForm.builder()
                .suffix("rod_long").displayName("Long Rod").commonTag("rods_long")
                .render(TintedTemplate.item(
                        TintedTemplate.tinted(MaterialDataTypes.PRIMARY_COLOR, "item/material/rod_long"),
                        TintedTemplate.tinted(MaterialDataTypes.SECONDARY_COLOR, "item/material/rod_long_secondary")))
                .build(id));

        GEAR_SMALL = MaterialFormRegistry.register("gear_small", id -> ItemForm.builder()
                .suffix("gear_small").displayName("Small Gear").commonTag("gears_small")
                .render(TintedTemplate.item(
                        TintedTemplate.tinted(MaterialDataTypes.PRIMARY_COLOR, "item/material/gear_small"),
                        TintedTemplate.tinted(MaterialDataTypes.SECONDARY_COLOR, "item/material/gear_small_secondary"),
                        TintedTemplate.flat("item/material/gear_small_overlay")))
                .build(id));

        PLATE_DENSE = MaterialFormRegistry.register("plate_dense", id -> ItemForm.builder()
                .suffix("plate_dense").displayName("Dense Plate").commonTag("plates_dense")
                .render(TintedTemplate.item(
                        TintedTemplate.tinted(MaterialDataTypes.PRIMARY_COLOR, "item/material/plate_dense"),
                        TintedTemplate.tinted(MaterialDataTypes.SECONDARY_COLOR, "item/material/plate_dense_secondary"),
                        TintedTemplate.flat("item/material/plate_dense_overlay")))
                .build(id));

        BOLT = MaterialFormRegistry.register("bolt", id -> ItemForm.builder()
                .suffix("bolt").displayName("Bolt").commonTag("bolts")
                .render(TintedTemplate.item(
                        TintedTemplate.tinted(MaterialDataTypes.PRIMARY_COLOR, "item/material/bolt"),
                        TintedTemplate.tinted(MaterialDataTypes.SECONDARY_COLOR, "item/material/bolt_secondary"),
                        TintedTemplate.flat("item/material/bolt_overlay")))
                .build(id));

        FOIL = MaterialFormRegistry.register("foil", id -> ItemForm.builder()
                .suffix("foil").displayName("Foil").commonTag("foils")
                .render(TintedTemplate.item(
                        TintedTemplate.tinted(MaterialDataTypes.PRIMARY_COLOR, "item/material/foil"),
                        TintedTemplate.tinted(MaterialDataTypes.SECONDARY_COLOR, "item/material/foil_secondary"),
                        TintedTemplate.flat("item/material/foil_overlay")))
                .build(id));

        RING = MaterialFormRegistry.register("ring", id -> ItemForm.builder()
                .suffix("ring").displayName("Ring").commonTag("rings")
                .render(TintedTemplate.item(
                        TintedTemplate.tinted(MaterialDataTypes.PRIMARY_COLOR, "item/material/ring"),
                        TintedTemplate.tinted(MaterialDataTypes.SECONDARY_COLOR, "item/material/ring_secondary"),
                        TintedTemplate.flat("item/material/ring_overlay")))
                .build(id));

        SCREW = MaterialFormRegistry.register("screw", id -> ItemForm.builder()
                .suffix("screw").displayName("Screw").commonTag("screws")
                .render(TintedTemplate.item(
                        TintedTemplate.tinted(MaterialDataTypes.PRIMARY_COLOR, "item/material/screw"),
                        TintedTemplate.tinted(MaterialDataTypes.SECONDARY_COLOR, "item/material/screw_secondary"),
                        TintedTemplate.flat("item/material/screw_overlay")))
                .build(id));

        // ===== 补全形态：与 GTM 形态命名对齐，贴图沿用 OI 模板（细导线 = wire_fine） =====


        WIRE_FINE = MaterialFormRegistry.register("wire_fine", id -> ItemForm.builder()
                .suffix("wire_fine").displayName("Fine Wire").commonTag("wires_fine")
                .render(TintedTemplate.item(
                        TintedTemplate.tinted(MaterialDataTypes.PRIMARY_COLOR, "item/material/wire_fine"),
                        TintedTemplate.tinted(MaterialDataTypes.SECONDARY_COLOR, "item/material/wire_fine_secondary"),
                        TintedTemplate.flat("item/material/wire_fine_overlay")))
                .build(id));

        ELEMENT_GAS = MaterialFormRegistry.register("element_gas", id -> FluidForm.builder()
                .suffix("fluid").displayName("Gas").commonTag("gases")
                .density(1).viscosity(10).temperature(300).tintColor(0xFFFFFFFF)
                .texture("block/fluid/flat_still", "block/fluid/flat_flow")
                .build(id));

        // 熔融态元素液体（铁 1811K、金 1337K、钨 3695K…）：温度取材料的真实熔点，
        // 这里的 1000K 只是拿不到熔点时的兜底值。
        ELEMENT_LIQUID = MaterialFormRegistry.register("element_liquid", id -> FluidForm.builder()
                .suffix("fluid").displayName("Molten").commonTag("liquids")
                .density(1000).viscosity(1000).temperature(1000).tintColor(0xFFFFFFFF)
                .texture("block/fluid/flat_still", "block/fluid/flat_flow")
                .build(id));

        // 常温液态元素（汞 234K、溴 266K 熔点都低于室温）：现实中常温即为液体，
        // 并非熔化所得，所以用"水"的液体纹理，不归入熔融（岩浆纹理 / 熔点温度）。
        ELEMENT_FLUID = MaterialFormRegistry.register("element_fluid", id -> FluidForm.builder()
                .suffix("fluid").displayName("Liquid").commonTag("liquids")
                .density(1000).viscosity(1000).temperature(300).tintColor(0xFFFFFFFF)
                .texture("block/fluid/fluid_still", "block/fluid/fluid_flow")
                .build(id));


        SPRING = MaterialFormRegistry.register("spring", id -> ItemForm.builder()
                .suffix("spring").displayName("Spring").commonTag("springs")
                .render(TintedTemplate.item(
                        TintedTemplate.tinted(MaterialDataTypes.PRIMARY_COLOR, "item/material/spring"),
                        TintedTemplate.tinted(MaterialDataTypes.SECONDARY_COLOR, "item/material/spring_secondary"),
                        TintedTemplate.flat("item/material/spring_overlay")))
                .build(id));

        SPRING_SMALL = MaterialFormRegistry.register("spring_small", id -> ItemForm.builder()
                .suffix("spring_small").displayName("Small Spring").commonTag("springs_small")
                .render(TintedTemplate.item(
                        TintedTemplate.tinted(MaterialDataTypes.PRIMARY_COLOR, "item/material/spring_small"),
                        TintedTemplate.tinted(MaterialDataTypes.SECONDARY_COLOR, "item/material/spring_small_secondary"),
                        TintedTemplate.flat("item/material/spring_small_overlay")))
                .build(id));

        PLATE_DOUBLE = MaterialFormRegistry.register("plate_double", id -> ItemForm.builder()
                .suffix("plate_double").displayName("Double Plate").commonTag("plates_double")
                .render(TintedTemplate.item(
                        TintedTemplate.tinted(MaterialDataTypes.PRIMARY_COLOR, "item/material/plate_double"),
                        TintedTemplate.tinted(MaterialDataTypes.SECONDARY_COLOR, "item/material/plate_double_secondary"),
                        TintedTemplate.flat("item/material/plate_double_overlay")))
                .build(id));

        INGOT_HOT = MaterialFormRegistry.register("ingot_hot", id -> ItemForm.builder()
                .suffix("ingot_hot").displayName("Hot Ingot").commonTag("ingots_hot")
                .render(TintedTemplate.item(
                        TintedTemplate.tinted(MaterialDataTypes.PRIMARY_COLOR, "item/material/ingot_hot"),
                        TintedTemplate.tinted(MaterialDataTypes.SECONDARY_COLOR, "item/material/ingot_hot_secondary"),
                        TintedTemplate.flat("item/material/ingot_hot_overlay")))
                .build(id));

        // ===== 方块形态：金属块（BlockForm，注册出来的真方块，不是物品）=====
        BLOCK = MaterialFormRegistry.register("block", id -> BlockForm.builder()
                .suffix("block").displayName("Block").commonTag("storage_blocks")
                .render(TintedTemplate.block(
                        TintedTemplate.opaque(TintedTemplate.tinted(MaterialDataTypes.PRIMARY_COLOR, "block/material/block")),
                        TintedTemplate.opaque(TintedTemplate.tinted(MaterialDataTypes.SECONDARY_COLOR, "block/material/block_secondary"))))
                .build(id));

        // ===== 纳米蜂群（GTOCore GENERATE_NANITES）=====
        NANITES = MaterialFormRegistry.register("nanites", id -> ItemForm.builder()
                .suffix("nanites").displayName("Nanites").commonTag("nanites")
                .render(TintedTemplate.item(
                        TintedTemplate.tinted(MaterialDataTypes.PRIMARY_COLOR, "item/material/nanites")))
                .build(id));
    }
}
