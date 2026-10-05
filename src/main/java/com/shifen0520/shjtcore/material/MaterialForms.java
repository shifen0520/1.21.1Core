package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;
import com.shifen0520.shjtcore.material.form.BlockForm;
import com.shifen0520.shjtcore.material.form.FluidForm;
import com.shifen0520.shjtcore.material.form.ItemForm;
import com.shifen0520.shjtcore.material.form.MaterialFormRegistry;
import com.shifen0520.shjtcore.material.render.TintedTemplate;

public final class MaterialForms {
    public static final MaterialForm BLOCK;
    public static final MaterialForm INGOT;
    public static final MaterialForm DUST;
    public static final MaterialForm PLATE;
    public static final MaterialForm GEAR;
    public static final MaterialForm FLUID;
    public static final MaterialForm GAS;
    public static final MaterialForm LIQUID;

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

    public static final MaterialForm WIRE_FINE;
    public static final MaterialForm ELEMENT_GAS;
    public static final MaterialForm ELEMENT_LIQUID;
    public static final MaterialForm ELEMENT_FLUID;
    public static final MaterialForm SPRING;
    public static final MaterialForm SPRING_SMALL;
    public static final MaterialForm PLATE_DOUBLE;
    public static final MaterialForm INGOT_HOT;
    public static final MaterialForm NANITES;

    private MaterialForms() {
    }

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

        BLOCK = MaterialFormRegistry.register("block", id -> BlockForm.builder()
                .suffix("block").displayName("Block").commonTag("storage_blocks")
                .render(TintedTemplate.block(
                        TintedTemplate.opaque(TintedTemplate.tinted(MaterialDataTypes.PRIMARY_COLOR, "block/material/block")),
                        TintedTemplate.opaque(TintedTemplate.tinted(MaterialDataTypes.SECONDARY_COLOR, "block/material/block_secondary"))))
                .build(id));

        NANITES = MaterialFormRegistry.register("nanites", id -> ItemForm.builder()
                .suffix("nanites").displayName("Nanites").commonTag("nanites")
                .render(TintedTemplate.item(
                        TintedTemplate.tinted(MaterialDataTypes.PRIMARY_COLOR, "item/material/nanites")))
                .build(id));
    }
}
