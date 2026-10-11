package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 16 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials16 {

    private Materials16() {
    }

    static void init() {
        MaterialRegistry.register("inert_residues")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4F4863))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x302C3D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("infinity")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE86CD8))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8F4285))
                .data(MaterialDataTypes.MELTING_POINT.value(1000000))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("infuscolium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF77FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E499E))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.NANITES, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("interface_supramolecular_self_assembly_mfpc")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x646260))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3E3C3B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("invalidation_basic_mfpc")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC0C0C0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x777777))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("invalidation_cascade_mfpc")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x303030))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1D1D1D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("invar")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE2E8E1))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x495D57))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("iodine_containing_slurry")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x666633))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3F3F1F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("iodine_monochloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x004141))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x002828))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("iridium_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x41460C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x00542E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("iridium_dioxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA2BFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x64769E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("iridium_metal_residue")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x484A5E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3E1C38))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("iridium_trichloride_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x776715))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x493F0D))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("iron_58")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEEEEEE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x979797))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("iron_chromium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB7410E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x712808))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("iron_ii_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE8E0BE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8F8A75))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("iron_iii_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x060B0B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x030606))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("iron_sulfate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8EB64F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x587030))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("irradiated_ice_crystal_volatiles")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2F7D61))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x47B191))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("isochloropropane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCDD681))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7F844F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("isophthaloylbis")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x76677E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x493F4E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("isoprene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x141414))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x0C0C0C))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("isopropyl_alcohol")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x51B31F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x326E13))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("jasper")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC85050))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7C3131))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("jupiter_air")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9E7E5A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x614E37))
                .data(MaterialDataTypes.MELTING_POINT.value(155))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("kanthal")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC2D2DF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4C4238))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.SPRING, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("kelp_slurry")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x336600))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1F3F00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("kerosene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCE57CE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7F357F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("kevlar")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9F9F53))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x626233))
                .forms(MaterialForms.FOIL, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("kh550_silane_coupling_agent")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF5F5F5))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x979797))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("krypton_difluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3FF12B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x27951A))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("kyanite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD5FFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5A69D6))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("la_nd_oxides_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9CE3DB))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x608C87))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("lafium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x235497))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x15345D))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("lanthanoids_mix_1")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEF1133))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x940A1F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("lanthanoids_mix_2")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEF1133))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x940A1F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("lanthanum_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9E9E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("lanthanum_chloride_with_impurities")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE0E0E0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8A8A8A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("lanthanum_embedded_fullerene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x91C100))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x597700))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("lanthanum_extracted_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x808080))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F4F4F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("lanthanum_extraction_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x808080))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F4F4F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("lanthanum_fullerene_mix")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD3BFEC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x827692))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("lanthanum_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCFCFCF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x808080))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("lapis")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x85A9FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2A7FFF))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD)
                .build();
        MaterialRegistry.register("lapotron")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7497EA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1C0B39))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("laurenium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFB7EF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E7194))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("lazurite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2836F1))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x183CA3))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD)
                .build();
        MaterialRegistry.register("leach_residue")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x644629))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3E2B19))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("leached_turpentine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCD9B1D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7F6011))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("lead_magnesium_niobate_shape_piezoelectric_ceramic")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBB7D8A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7A5258))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ROD_LONG, MaterialForms.FOIL)
                .build();
    }
}
