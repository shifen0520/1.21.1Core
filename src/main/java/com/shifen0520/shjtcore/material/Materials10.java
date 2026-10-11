package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 10 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials10 {

    private Materials10() {
    }

    static void init() {
        MaterialRegistry.register("dragon_element")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9933FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5E1F9E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("drilling_fluid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFFAA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9E69))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("dry_graphene_gel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x202079))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x13134B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("duranium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF3E7A9))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9C9487))
                .data(MaterialDataTypes.MELTING_POINT.value(7500))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.ROD, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("duranium_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x378D94))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x22575B))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("durene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x708090))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x454F59))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("dusty_liquid_helium_iii")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x774060))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x49273B))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("dye_carrier_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB8B8B8))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x727272))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("dysprosium_extracted_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x00FFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x009E9E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("dysprosium_extraction_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x00FFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x009E9E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("dysprosium_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCFCFCF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x808080))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("echo_shard")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x002B2D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x001A1B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD)
                .build();
        MaterialRegistry.register("echoite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x26734D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x17472F))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ROD, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("edta")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x239791))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x155D59))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("eglin_steel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4E270B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x301806))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("electronic_grade_silicon")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x414151))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x282832))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("electrotine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x83CBF5))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x004585))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("electrum")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFF8B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xFF8533))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("emerald")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x17FF6C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x003F00))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD)
                .build();
        MaterialRegistry.register("emulsified_dye_carrier_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA7A7A7))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x676767))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("end_steel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD6D980))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x84864F))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("ender_air")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x283454))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x182034))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("ender_eye")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB5E45A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x001430))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE)
                .build();
        MaterialRegistry.register("ender_pearl")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8CF4E2))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x032620))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE)
                .build();
        MaterialRegistry.register("enderite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x006699))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x003F5E))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("enderium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x75EDE2))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x48928C))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.NANITES, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("endstone")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF6FABD))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xC5BE8B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("energetic_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFB545))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E702A))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("energetic_netherite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4B4042))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2E2728))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ROD_LONG)
                .build();
        MaterialRegistry.register("enriched_bacterial_sludge")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7FFF00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4E9E00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("enriched_dragon_breath")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF00FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E009E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("enriched_light_emitting_charged_suspicious_waste")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x79ECF4))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4B9297))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("enriched_naquadah")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3C3C3C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x122F06))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("enriched_naquadah_front")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x58D00F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x368009))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("enriched_naquadah_fuel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x292929))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x191919))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("enriched_naquadah_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3AAD3A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x236B23))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("enriched_naquadah_sulfate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF8023))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x044610))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("enriched_naquadah_trinium_europium_duranide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC6B083))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x45063D))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("enriched_naquadah_waste")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x355B35))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x203820))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("enriched_potassium_iodide_slurry")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x00FFCC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x009E7E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("enriched_rare_earth_chloride_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x87CEFA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x537F9B))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("enriched_uranium_hexafluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4BF52A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2E971A))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("enriched_xenoxene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5C5A58))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x393736))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("epichlorohydrin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x712400))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x461600))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("epidermal_growth_factor")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x772B61))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x491A3C))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("epoxy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF6FABD))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xC88C14))
                .forms(MaterialForms.PLATE, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("er_lu_oxides_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFB3FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E6E9E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("erbium_extracted_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF00FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E009E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("erbium_extraction_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF00FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E009E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("erbium_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCFCFCF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x808080))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
    }
}
