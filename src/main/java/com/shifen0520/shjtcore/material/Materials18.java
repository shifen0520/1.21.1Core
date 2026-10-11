package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 18 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials18 {

    private Materials18() {
    }

    static void init() {
        MaterialRegistry.register("lutetium_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCFCFCF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x808080))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("magenta_dye")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF00FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E009E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("magmatter")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC060FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x773B9E))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ROD_LONG, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("magnalium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x98B9E9))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2F0B51))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("magnesia")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x998282))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x594D19))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("magnesite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFBFBF6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x80705E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("magnesium_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEEE4E9))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xD40D5C))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("magnesium_chloride_bromide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x99234D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5E152F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("magnesium_diboride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x603C1A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x423E39))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("magnesium_oxide_ceramic")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFE198))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E8B5E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("magnetic_controlled_shape_memory_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF8080))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xCC6060))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("magnetic_iron")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEEEEEE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x979797))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.BOLT, MaterialForms.SCREW)
                .build();
        MaterialRegistry.register("magnetic_neodymium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9A8B94))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2C2C2C))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ROD)
                .build();
        MaterialRegistry.register("magnetic_samarium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC5C5B3))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x183E3F))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ROD_LONG)
                .build();
        MaterialRegistry.register("magnetic_steel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA7A7A7))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x121C37))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE_DENSE, MaterialForms.ROD)
                .build();
        MaterialRegistry.register("magnetite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9D9D9D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x06070E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("magneto_resonatic")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF97FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E5D9E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("magnetohydrodynamically_constrained_star_matter")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF9A3C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E5F25))
                .data(MaterialDataTypes.MELTING_POINT.value(100))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("malachite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x00F1B0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x107A47))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("maleic_anhydride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x321B90))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1F1059))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("manganese_phosphide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE1B454))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x223033))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("mar_m_200_steel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x515151))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x323232))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("maraging_steel_300")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x505B6E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x313844))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("marble")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF0F5F4))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xB3B3B3))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("massicot")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFDD55))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x000000))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("mc_guffium_239")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8CE860))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x568F3B))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("meat")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE85048))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x470A06))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("mercury_acetate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xDDDD00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x898900))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("mercury_barium_calcium_cuprate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x928547))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3F2E2E))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("mestitylene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFF8DC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9988))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("metal_compound_particle_front")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC6D6E6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7A848E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("metal_compound_particles")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xAFA5A0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xCC8430))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("metal_mixture")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x697077))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x502D16))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("metal_residue")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x652118))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3E140E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("metallic_residues")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x205A53))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x133733))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("metalloid_mix")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x916D12))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x59430B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("metastable_hassium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x78766F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4A4944))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("metastable_oganesson")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8B000E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x560008))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("methane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF0078))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E004A))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("methanol")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xAA8800))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x695400))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("methyl_acetate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEEC6AF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x937A6C))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("methyl_acrylate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3C8D4F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x255730))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("methylamine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x45486F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2A2C44))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("methylbenzophenanthrene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x79260C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4B1707))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("mica")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xECFEFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xC2A03C))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("microwave_attenuating_coated_phase_change_microbeads")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2B2D30))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1A1B1D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("milk")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFBF0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xF6EAC8))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("mirabilite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF9E7E7))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xB57A7A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("mithril")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4DA6FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2F669E))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.SPRING, MaterialForms.SPRING_SMALL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("mixed_astatide_salts")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x67E83C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3F8F25))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
    }
}
