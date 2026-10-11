package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 7 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials07 {

    private Materials07() {
    }

    static void init() {
        MaterialRegistry.register("clostridium_pasteurianum")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x6B8E23))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x425815))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("co_ac_ab")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x544422))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x342A15))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("coal")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x393E41))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x101015))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("coal_gas")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x333333))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1F1F1F))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("coal_slurry")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3E3C3A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x262523))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("coal_tar")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x1A1A1A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x101010))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("cobalt_brass")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBAA365))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x596338))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("cobalt_manganese_gallium_heusler_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFD27A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xCCAA5E))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("cobalt_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3CB099))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3B5C66))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("cobalt_oxide_ceramic")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x222534))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x151620))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("cobaltite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x1975FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x56071F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("cocoa")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x976746))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x301A0A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("coke")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x575E5B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1F1F29))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("collagen")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFADB7))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x80471C))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("compressed_stone")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x696969))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x414141))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("concentrated_bromine_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x91481E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x592C12))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("concentrated_cerium_chloride_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x00FFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x009E9E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("concentrated_monazite_rare_earth_hydroxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC0C0C0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x777777))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("concentrated_rare_earth_chloride_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x00BFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x00769E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("concentration_mixing_hyper_fuel_1")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x000000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x000000))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("concentration_mixing_hyper_fuel_2")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x000000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x000000))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("concrete")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFAF3E8))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xBBBABA))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("conductive_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF7B29B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x996E60))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("construction_foam")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x808080))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F4F4F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("coolant_liquid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4B59FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2E379E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("cooperite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE9FFA7))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x665F2F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("copper76")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE77C56))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8F4C35))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("copper_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC79738))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7B5D22))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("copper_nitrate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8EFAF4))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x589B97))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("cosmic")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2D3E5E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1B263A))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ROD_LONG, MaterialForms.WIRE_FINE)
                .build();
        MaterialRegistry.register("cosmic_computing_mixture")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8B8925))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x565416))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("cosmic_dust")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xAA7ACA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7A4C9A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("cosmic_dust_copper_i_kpba_nanotubes")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3A373B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x59565A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("cosmic_dust_dispersant")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCC8430))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xAFA5A0))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("cosmic_element")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA366FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x653F9E))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("cosmic_mesh")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x181878))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x0E0E4A))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("cosmic_neutronium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x000D1A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x000810))
                .data(MaterialDataTypes.MELTING_POINT.value(1000000))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.SPRING, MaterialForms.SPRING_SMALL, MaterialForms.NANITES, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("cosmic_superconductor")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x00FFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x009E9E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("crackedradox")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xAB57AB))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6A356A))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("creosote")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x804000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F2700))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("crude_hexanitrohexaaxaisowurtzitane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x19586D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x0F3643))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("cruptix")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7A4C9A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xAA7ACA))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("crystal_matrix")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x33FFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1F9E9E))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.SPRING, MaterialForms.SPRING_SMALL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("crystalline_nitric_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCDBD14))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7F750C))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("ctab")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x239791))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x155D59))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("cubic_zirconia")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF3D5D7))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x968485))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE)
                .build();
        MaterialRegistry.register("cumene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x552200))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x341500))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("cupriavidus_necator")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x008C07))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x005604))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("cupric_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8DF7CF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x57696E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("cupronickel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFDA8A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xCD2B00))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.SPRING, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
    }
}
