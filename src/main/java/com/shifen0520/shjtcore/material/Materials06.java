package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 6 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials06 {

    private Materials06() {
    }

    static void init() {
        MaterialRegistry.register("celestial_tungsten")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x303030))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1D1D1D))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("celestine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3C4899))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x252C5E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("cerium_4_sulfate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0D7F7F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x084E4E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("cerium_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x808080))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F4F4F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("cerium_extracted_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x969696))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5D5D5D))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("cerium_extraction_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x969696))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5D5D5D))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("cerium_oxalate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x969696))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5D5D5D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("cerium_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCFCFCF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x808080))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("cerium_rich_mixture")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x808080))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F4F4F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("certus_quartz")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC2D6FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x86BACF))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE)
                .build();
        MaterialRegistry.register("cesium_carborane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xAE6EDA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6B4487))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("cesium_carborane_precursor")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBA5C69))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x733941))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("cetane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFF68F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9858))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("cetane_boosted_diesel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC8FF00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7C9E00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("cfc_sic1500_carbon_fiber_reinforced_composite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x1A5F68))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x103A3F))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("chalcocite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x657882))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x33302E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("chalcopyrite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x96C185))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xE3AF1A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("chalcopyrite_front")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCDAA7D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7F694D))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("chaos")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x000000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x000000))
                .data(MaterialDataTypes.MELTING_POINT.value(1000000))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("chaos_infinity_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x000000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x000000))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("charcoal")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7D6F58))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x13110D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("charcoal_byproducts")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x784421))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4A2A14))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("charged_caesium_cerium_cobalt_indium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4DA323))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2F6515))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("chitin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x998422))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5E5115))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("chitosan")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x96990E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5D5E08))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("chloroacetic_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x239791))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x155D59))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("chloroauric_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFD700))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E8500))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("chlorobenzene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x326A3E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1F4126))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("chloroethoxyethane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFDAAC0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9C6977))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("chloroform")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x892CA0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x541B63))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("chloromethane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC82CA0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7C1B63))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("chloropropyltriethoxysilane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB8BB90))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x727359))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("chlorosulfonic_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x682F0D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x401D08))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("chromatic_glass")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x80E0F0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F8A94))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("chromic_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9A0B0B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5F0606))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("chromic_acid_waste")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCA4B4B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7D2E2E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("chromite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC5C1A8))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4C1A69))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("chromium_54")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF3E0EA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x441F2E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("chromium_sulfate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x1F1F1F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x131313))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("chromium_trioxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFE4E1))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E8D8B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("cinnabar")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF335F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3F0110))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("cinobite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x000000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x000000))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("circuit_compound")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x00210E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x001408))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("citral")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC3DA00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x788700))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("citric_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFADD0C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9B8907))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("clay")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBEC9E8))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x373944))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("clean_bedrock_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x778899))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x49545E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("clean_inert_residues")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x187F4D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x0E4E2F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("clean_raw_tengam")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x819A4E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F5F30))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("clear_ammonia_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x48B7A5))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2C7166))
                .forms(MaterialForms.FLUID)
                .build();
    }
}
