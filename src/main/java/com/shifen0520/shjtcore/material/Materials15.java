package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 15 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials15 {

    private Materials15() {
    }

    static void init() {
        MaterialRegistry.register("hsla_steel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x686868))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x404040))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.SPRING, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("hsse")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9D9CBE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2B0350))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("hssg")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9CBABE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x032550))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.FOIL, MaterialForms.SPRING, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("hsss")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA482BF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x66000E))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("hydrazine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9E9E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("hydro_cracked_butadiene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xAD5203))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6B3201))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("hydro_cracked_butane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x852C18))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x521B0E))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("hydro_cracked_butene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x993E05))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5E2603))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("hydro_cracked_ethane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9696BC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5D5D74))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("hydro_cracked_ethylene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA3A3A0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x656563))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("hydro_cracked_propane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBEA540))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x756627))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("hydro_cracked_propene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBEA540))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x756627))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("hydrobromic_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA2573F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x643527))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("hydrochloric_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC8DC70))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7C8845))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("hydrofluoric_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0088AA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x005469))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("hydrogen_cyanide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x72DBD4))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x468783))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("hydrogen_iodide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8187A6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F5366))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("hydrogen_sulfide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD8E0C0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x858A77))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("hydroiodic_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0382E2))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x01508C))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("hydroquinone")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8E2518))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x58160E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("hydroxyapatite_ceramic")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x76C1DA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x497787))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("hydroxylamine_hydrochloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x433217))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x291F0E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("hydroxylammonium_sulfate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x848075))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x514F48))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("hyper_fuel_1")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF9FF3D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9A9E25))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("hyper_fuel_2")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD1D54D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x81842F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("hyper_fuel_3")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7A7C3C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4B4C25))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("hyper_fuel_4")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3F4028))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x272718))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("hyperthermophilic_archaeon")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEF281F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2D3C2E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("hypochlorous_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x6F8A91))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x445559))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("hypogen")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xDA916B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8F993B))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("ice")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEEF6FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6389C9))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ice_crystal_volatiles")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x07544D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x0D8980))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ilmenite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2B2A24))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2B1700))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("impregnated_alkane_filled_mfpc")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB2B0B0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6E6D6D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("impure_enriched_naquadah_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x388438))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x225122))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("impure_naquadria_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x518451))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x325132))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("inactive_remnant_erosion_catalyst")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3A3A3A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x232323))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("incoloy_ma_956")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2D9B66))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1B603F))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("inconel_242")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x575762))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2E2E38))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("inconel_617")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2D3C2E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1F281F))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("inconel_625")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x00CD66))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x007F3F))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("inconel_718")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x1F4134))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x142822))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("inconel_792")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x44974A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2A5D2D))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("inconel_x750")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x59565A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3A373B))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("indalloy_140")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x6A5ACD))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x41377F))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("indium_concentrate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0E2950))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x081931))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("indium_gallium_phosphide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA77BD7))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4E546B))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("indium_phosphide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x734D77))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2C272D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("indium_tin_barium_titanium_cuprate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x686760))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x673300))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("inert_metal_mixture")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2B0645))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6A1600))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
    }
}
