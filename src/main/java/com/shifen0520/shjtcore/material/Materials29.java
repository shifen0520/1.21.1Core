package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 29 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials29 {

    private Materials29() {
    }

    static void init() {
        MaterialRegistry.register("stone_dust_residue")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x585858))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x363636))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("streptococcus_pyogenes")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x19520B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x0F3206))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("strontium_carbonate_ceramic")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC5C5C5))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7A7A7A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("strontium_europium_aluminate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB62D78))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x701B4A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("strontium_sulfate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x6A67F1))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x413F95))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("structural_steel_45")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xDBDEE0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9EA1A3))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("structural_steel_q690")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x898989))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5C5C5C))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("styrene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD2C8BE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x827C75))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("styrene_butadiene_rubber")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x34312B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x110B09))
                .forms(MaterialForms.RING, MaterialForms.FOIL, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("succinaldehyde")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x63577D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3D354D))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("succinic_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x104E5C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x093039))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("succinic_anhydride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x401116))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x270A0D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("succinimide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x21A7C5))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x14677A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("succinimidyl_acetate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x64704D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3E452F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sugar")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x545468))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sulfonated_poly_arylene_ether_sulfone_random_copolymer")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7F7F7F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4E4E4E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sulfur_dioxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0E4880))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x082C4F))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("sulfur_trioxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA0A014))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x63630C))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("sulfuric_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD8D060))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x85803B))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("sulfuric_copper_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x48A5C0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2C6677))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("sulfuric_gas")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xECDCCC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x92887E))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("sulfuric_heavy_fuel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA88040))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x684F27))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("sulfuric_light_fuel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD8B868))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x857240))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("sulfuric_naphtha")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD0B470))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x806F45))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("sulfuric_nickel_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3EB640))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x267027))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("sunnarium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFCFC00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9C9C00))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("super_mutated_living_solder")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB662FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x703C9E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("superconducting_ion")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0000FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x00009E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("supercritical_carbon_dioxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9AC8F3))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5F7C96))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("supercritical_sodium_potassium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x64FCB4))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3E9C6F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("supercritical_steam")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC4C4C4))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x797979))
                .data(MaterialDataTypes.MELTING_POINT.value(1000))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("superheavy_h_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE84B36))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8F2E21))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("superheavy_l_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2B45DF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1A2A8A))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("superheavy_mix")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3E2C2B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x261B1A))
                .data(MaterialDataTypes.MELTING_POINT.value(12000))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("superheavyradox")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x6C006C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x420042))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("superlightradox")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x6C006C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x420042))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("surface_functionalized_phase_change_microbeads")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2B2D30))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1A1B1D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("t1000_carbon_fiber_tow")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9A9A9A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x666666))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("t1200_carbon_fiber_tow")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xAAAAAA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x717171))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("t1500_carbon_fiber_tow")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB7B7B7))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7D7D7D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("t300_carbon_fiber_tow")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3A3A3A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x262626))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("t400_carbon_fiber_tow")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4A4A4A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x333333))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("t600_carbon_fiber_tow")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5A5A5A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3D3D3D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("t700_carbon_fiber_tow")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x6D6D6D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4A4A4A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("t800_carbon_fiber_tow")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7D7D7D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x555555))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("t900_carbon_fiber_tow")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8B8B8B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5E5E5E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("tairitsu")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x1C1C1C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x111111))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("talc")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEBFFE9))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6FE19B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("tanmolyium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x97249A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5D165F))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("tannic")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFF66))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9E3F))
                .forms(MaterialForms.FLUID)
                .build();
    }
}
