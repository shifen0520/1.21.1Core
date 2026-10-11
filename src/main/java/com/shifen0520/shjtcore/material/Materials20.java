package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 20 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials20 {

    private Materials20() {
    }

    static void init() {
        MaterialRegistry.register("neodymium_extracted_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB0B0B0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6D6D6D))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("neodymium_extraction_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB0B0B0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6D6D6D))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("neodymium_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCFCFCF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x808080))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("neodymium_rare_earth_concentrate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x969696))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5D5D5D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("nether_air")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4C3434))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2F2020))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("nether_quartz")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF8EFE3))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xE6C1BB))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE)
                .build();
        MaterialRegistry.register("nether_star")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFEFFC6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7FD7E2))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("netherrack")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7C4249))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x400B0B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("neutralised_red_mud")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x972903))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5D1901))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("neutronium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x000000))
                .data(MaterialDataTypes.MELTING_POINT.value(100000))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("neutronium_doped_nanotubes")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5BF5F5))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x389797))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("nichrome")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xAF94B2))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5B4C6A))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.SPRING, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("nickel_64")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCCDFF5))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x59563A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("nickel_front")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC1CDCD))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x777F7F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("nickel_titanium_tin_heusler_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFD2B8))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xCCAA88))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("nickel_zinc_ferrite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3F2821))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2C2725))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.RING, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("niobium_nitride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x574457))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x332E3C))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("niobium_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC0C4C0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x777977))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("niobium_titanium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD2D9F9))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x262528))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.FOIL, MaterialForms.SPRING, MaterialForms.SPRING_SMALL, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("nitinol_50_shape_memory_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF8080))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xCC6060))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("nitrated_triniite_compound_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5E9699))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3A5D5E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("nitration_mixture")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE6E2AB))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8E8C6A))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("nitric_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCCCC00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7E7E00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("nitric_leachate_from_monazite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xADD8E6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6B858E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("nitric_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7DC8F0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4D7C94))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("nitrided_samarium_terbium_mixture")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7F7F7F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4E4E4E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("nitrobenzene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x704936))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x452D21))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("nitrochlorobenzene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8FB51A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x587010))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("nitrogen_dioxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x85FCFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x529C9E))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("nitrogen_pentoxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x162BB3))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x0D1A6E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("nitronium_tetrafluoroborate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3C3F40))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x252727))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("nitrosonium_octafluoroxenate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x953D9F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5C2562))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("nitrosonium_tetrafluoroborate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x485054))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2C3134))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("nitrosyl_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF3F100))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x969500))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("nitrous_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA0C8FD))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x637C9C))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("nitrous_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7DC8FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4D7C9E))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("nitryl_fluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8B7EFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x564E9E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("nmethylpyrolidone")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD0D0D0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x808080))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("noble_gas_mix")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xED8DEA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x925791))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("not_found_mix")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x1E0EBE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x120875))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("obsidian")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3B2754))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x000001))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.PLATE_DENSE)
                .build();
        MaterialRegistry.register("octane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8A0A09))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x550605))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("octane_loaded_phase_change_microbeads")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2B2D30))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1A1B1D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("odyssey_nano_superalloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4C7A6A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2E4C3C))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("oganesson_breeding_base")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB8676C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x723F42))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("oil")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0A0A0A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x060606))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("oil_heavy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0A0A0A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x060606))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("oil_light")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0A0A0A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x060606))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("oil_medium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0A0A0A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x060606))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("oilsands")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE3C78A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x161E22))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
    }
}
