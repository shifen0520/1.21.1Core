package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 3 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials03 {

    private Materials03() {
    }

    static void init() {
        MaterialRegistry.register("ash")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD1D1D1))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8B8989))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("ash_leaching_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x666699))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3F3F5E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("astatide_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4FF417))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x30970E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("astral_titanium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF6CBF6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x987D98))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("astrium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x31BAD5))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xEE595A))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ROD_LONG, MaterialForms.FOIL)
                .build();
        MaterialRegistry.register("attuned_tengam")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x819A4E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F5F30))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ROD_LONG)
                .build();
        MaterialRegistry.register("awakened_draconium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCC6600))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7E3F00))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("azafullerene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB3A500))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6E6600))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("babbitt_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA19CA4))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x636065))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("bacteria")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x808000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F4F00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("bacterial_growth_medium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x004401))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x002A00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("bacterial_sludge")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x355E3B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x203A24))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("barite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE8E2D1))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xF4B74B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("barium_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE9705F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x90453A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("barium_hydroxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF6FEFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x989D9E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("barium_nitrate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE464D6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8D3E84))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("barium_sulfide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x80784A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2C333B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("barium_titanate_ceramic")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFCBE2))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E7D8C))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("barnarda_air")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x563A24))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x352316))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("basalt")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5C5C5C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1B2632))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("basaltic_mineral_sand")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5C5C5C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x283228))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("basic_fibroblast_growth_factor")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBD03B4))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x75016F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("basic_mfpc")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC0C0C0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x777777))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("bastnasite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCAAB60))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xC8502D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("battery_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCAC0FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5B0020))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("bauxite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCFB853))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xE6220C))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("bedrock_gas")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC0C0C0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x777777))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("bedrock_smoke")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA9A9A9))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x686868))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("bedrock_soot_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x191970))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x0F0F45))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("bedrockium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x808080))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F4F4F))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE)
                .build();
        MaterialRegistry.register("bentonite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEDE8A3))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xCDB44C))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("benzaldehyde")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x905A1B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x593710))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("benzene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x1A1A1A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x101010))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("benzenediazonium_tetrafluoroborate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8FBC8F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x587458))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("benzenesulfonic_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7F0F7F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4E094E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("benzoic_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3F0F7F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x27094E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("benzoic_anhydride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3F4F7F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x27304E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("benzophenanthrenylacetonitrile")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9222C7))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5A157B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("benzoyl_peroxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3F7F7F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x274E4E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("benzyl_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9FF6FB))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x62989B))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("benzylamine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5B6363))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x383D3D))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("beryllium_aluminium_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x689D79))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4B6F58))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("beryllium_aluminum_f")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0D8980))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x07544D))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("beryllium_aluminum_z")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x47B191))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2F7D61))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("beta_ionone")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD60B7F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x84064E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("beta_pinene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x059600))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x035D00))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("bifidobacterium_breve")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4D7511))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2F480A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("bio_diesel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF8000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E4F00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("biohmediumsterilized")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x72B125))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x466D16))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("biomass")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x00FF00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x009E00))
                .forms(MaterialForms.FLUID)
                .build();
    }
}
