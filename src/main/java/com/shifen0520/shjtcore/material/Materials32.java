package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 32 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials32 {

    private Materials32() {
    }

    static void init() {
        MaterialRegistry.register("trinium_tetrafluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x529E57))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x326135))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("trinium_titanium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x856F91))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x524459))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("triphenylphosphine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE7D510))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8F8409))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("tris")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x239791))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x155D59))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("tris_hydrochloride_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x239791))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x155D59))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("tritanium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC35769))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x210840))
                .data(MaterialDataTypes.MELTING_POINT.value(25000))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("tritium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF316B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xD00000))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("tritium_hydride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBA0202))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x730101))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("trona")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE6E6A5))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x87875F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("tungstate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE0FFC4))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xAB4400))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("tungsten_alloy_yg10")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3B3B46))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x262631))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("tungsten_alloy_yw3")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2D2D3C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1F1F28))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("tungsten_boron_mixture")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2D2D2D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1B1B1B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("tungsten_carbide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x635480))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x392E44))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("tungsten_fiber_reinforced_cobalt_based_composite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x171A3C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x0D0E22))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD_LONG, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("tungsten_steel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x687ECE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x03192F))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.PLATE_DENSE, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.FOIL, MaterialForms.SPRING, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("tungsten_tetraboride_ceramics")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCEE55A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9CBF38))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("tungsten_trioxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x86FF75))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x539E48))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("tungstic_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFC03))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x886217))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("turbid_dragon_blood")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4D0099))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2F005E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("turpentine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9ACD32))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5F7F1F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("uelibrium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4CA6C6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x78D4F2))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("uhtc_x1000_ultra_high_temperature_composite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x85868D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5E5F66))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("uhtc_x2000_ultra_high_temperature_composite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x752323))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4C1616))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("ultimet")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9F9FB1))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x385086))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("ultra_high_purity_silicon")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x414151))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x282832))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("ultra_lightweight_composite_steel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8B8B8B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4C4C4C))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("ultra_low_viscosity_ionic_carrier")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3C8D4F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x255730))
                .data(MaterialDataTypes.MELTING_POINT.value(7000))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ultraacidic_residue_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x848C9A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x51565F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("uncommon_residues")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3F46BD))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x272B75))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("undried_hydroxyapatite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF7F7F7))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x999999))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("unfolded_fullerene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x587F83))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x364E51))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("unknownnutrientagar")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x916E00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x594400))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("unknowwater")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3322AA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1F1569))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("uraninite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFD52E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x17212B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("uranium_235")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x46FA46))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x33342C))
                .data(MaterialDataTypes.MELTING_POINT.value(1405))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("uranium_filter_residue")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x545454))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x343434))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("uranium_hexafluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x42D126))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x288117))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("uranium_rhodium_dinaquadide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x232020))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xFF009C))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("uranium_sulfate_waste_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB1B113))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6D6D0B))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("uranium_triplatinum")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x457045))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x66FF00))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("uruium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x87CEEB))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x537F91))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.NANITES, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("uu_amplifier")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xAA2B9F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x691A62))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("uu_matter")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE86CE8))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8F428F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("uvarovite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2DED4C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x00697C))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("vanadium_gallium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x89AEEC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x00379D))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.FOIL, MaterialForms.SPRING, MaterialForms.SPRING_SMALL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("vanadium_magnetite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x505D70))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x170322))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("vanadium_pentoxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8B0000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x560000))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("vanadium_steel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB59FCC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x19140D))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("vibramantium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF009C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E0060))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.LIQUID)
                .build();
    }
}
