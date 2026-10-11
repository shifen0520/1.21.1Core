package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 19 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials19 {

    private Materials19() {
    }

    static void init() {
        MaterialRegistry.register("modulated_fluoro_carbon_lanthanide_slurry")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5A5AFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x37379E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("molten_calcium_salts")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7F478B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4E2C56))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("molybdenite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE3DDC3))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x191919))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("molybdenum_concentrate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x47443E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2C2A26))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("molybdenum_disilicide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x564A84))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x352D51))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD_LONG, MaterialForms.RING, MaterialForms.SPRING, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("molybdenum_flue")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4B626F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2E3C44))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("molybdenum_trioxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x757587))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x484853))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("monazite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD0EE98))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x520505))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("monazite_front")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x838B83))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x515651))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("monazite_rare_earth_precipitate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x808080))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F4F4F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("monazite_rare_earth_turbid_liquid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x81624C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F3C2F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("monochloramine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3F9F80))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x27624F))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("monomethylhydrazine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9E9E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("moon_goddess_titanium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD3B8D2))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xA899A8))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("mutagen")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x00FF7F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x009E4E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("mutated_living_solder")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC18FCC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x77587E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("n_difluorophenylpyrrole")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2F7E8A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1D4E55))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("n_hydroxysuccinimide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7B717F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4C464E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("n_hydroxysuccinimide_lipoic_ester")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7B717F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4C464E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("n_methylphthalimide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF7CC0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E4C77))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("nano_gold_deposited_carbon_nanotube")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3CADA8))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x256B68))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("nano_gold_deposited_carbon_nanotube_modified_nhs_lipoic_ester_q_dot")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x57ACAD))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x356A6B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("nano_scale_alumina")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFF5E1))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xC7BFA1))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("nano_scale_aluminum")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFD700))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xC6A300))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("nano_scale_molybdenum")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9999CC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x737399))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("nano_scale_niobium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBFCFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8B9AC6))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("nano_scale_rhenium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x6666FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4C4CBB))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("nano_scale_silicon_carbide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x76DFCF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4ACCCA))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("nano_scale_tungsten")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA3BB51))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7D8C3A))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("nano_scale_yttria")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE6F6FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xB7D9FF))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("nano_scale_zirconium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD9D9D9))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xA1A1A1))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("nano_strengthened_shape_memory_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF8080))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xCC6060))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("nanocrack_regulated_self_humidifying_composite_material")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0D7F0D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x084E08))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.FOIL)
                .build();
        MaterialRegistry.register("naphtha")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD0B060))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x806D3B))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("naphthalene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF4F4D7))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x979785))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("naquadah")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x323232))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1E251B))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.FOIL, MaterialForms.SPRING, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("naquadah_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x323232))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x301131))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.PLATE_DENSE, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.SPRING, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("naquadah_contain_rare_earth")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFD700))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E8500))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("naquadah_contain_rare_earth_fluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB3B300))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6E6E00))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("naquadah_fuel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x292929))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x191919))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("naquadah_oxide_mixture")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x000A1B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x000610))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("naquadah_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x00FF00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x009E00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("naquadria")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x1E1E1E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x59B3FF))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.ROD, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.FOIL, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("naquadria_caesium_xenonnonfluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x54C248))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x34782C))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("naquadria_caesiumfluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xAAEB69))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x699141))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("naquadria_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x61AD61))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3C6B3C))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("naquadria_sulfate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x85FF5A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x006633))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("naquadria_waste")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x425B42))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x283828))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("naquadriatictaranium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x000D1A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x000810))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE_DENSE, MaterialForms.ROD, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("natural_gas")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD8E4D0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x858D80))
                .forms(MaterialForms.GAS)
                .build();
    }
}
