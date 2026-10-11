package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 33 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials33 {

    private Materials33() {
    }

    static void init() {
        MaterialRegistry.register("vibranium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF0000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E0000))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.NANITES, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("vibranium_unstable")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFA8072))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9B4F46))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("vibrant_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA4FF70))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x659E45))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("vinyl_2_bipyridine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x1FC81F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2D3C2E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("vinyl_acetate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE1B380))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8B6E4F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("vinyl_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE1F0F0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8B9494))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("viscoelastic_polyurethane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xECFBEC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x929B92))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("viscoelastic_polyurethane_foam")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xECFBEC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x929B92))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("vitamin_a")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9D60AB))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x613B6A))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("water_agar_mix")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x88FFC0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x549E77))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("water_gas")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5D5B57))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x393835))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("watertight_steel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2B4B56))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1A2E35))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("wax")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFABF29))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9B7619))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("well_mixed_ybc_oxides")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x283301))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x181F00))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("wet_zeolite_sieving_pellets")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x1D173C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x110E25))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("wheat")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xDCBB65))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x565138))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("white_dwarf_mtter")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF0F0FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x94949E))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.NANITES, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("white_dye")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9E9E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("wood")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC29F6D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x643200))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW)
                .build();
        MaterialRegistry.register("wood_gas")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xDECD87))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xDEB287))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("wood_tar")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3A271A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x28170B))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("wood_vinegar")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD45500))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x905800))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("woods_glass")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x730099))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x47005E))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("wrought_iron")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBCBCBC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x521C0B))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("wulfenite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF9000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xFF0000))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("xenic_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x443A76))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2A2349))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("xenoauric_fluoroantimonic_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE0BD74))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8A7547))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("xenon_hexafluoro_enriched_naquadate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x255A55))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x163734))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("xenon_trioxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x359FC3))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x206278))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("xenoxene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5C5A58))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x393736))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("xenoxene_crystal")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5C5A58))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x393736))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("xenoxene_mixture")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5C7A58))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x394B36))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("yeast")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xAE9C00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6B6000))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("yellow_dye")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFF00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9E00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("yellow_garnet")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF6FF09))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xE7A800))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD)
                .build();
        MaterialRegistry.register("yellow_limonite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF5E315))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xC06F33))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("ytterbium_178")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9E9E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ytterbium_extracted_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFF00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9E00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ytterbium_extraction_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFF00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9E00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ytterbium_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCFCFCF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x808080))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("yttrium_barium_cuprate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x796D72))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x260A3A))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.FOIL, MaterialForms.SPRING, MaterialForms.SPRING_SMALL, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("yttrium_extracted_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x008000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x004F00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("yttrium_extraction_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x008000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x004F00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("yttrium_nitrate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xAAC6E4))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x697A8D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("yttrium_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCFCFCF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x808080))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("zeolite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF2E3E0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xEABEB4))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("zeolite_sieving_pellets")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4D3E9F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2F2662))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("zeron_100")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x294972))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x192D46))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("zinc_70")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEBEBFA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x232C30))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("zinc_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x6D9CEE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x436093))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
    }
}
