package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 11 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials11 {

    private Materials11() {
    }

    static void init() {
        MaterialRegistry.register("erosion_activate_residue")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x333333))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1F1F1F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("eschericia_coli")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x546F2F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x34441D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("etched_carbon_nanotube")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x303030))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1D1D1D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("eternity")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7FE8D0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4E8F80))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.FOIL, MaterialForms.NANITES, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("ethane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC8C8FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7C7C9E))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("ethanol")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE8F0E4))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8F948D))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ethanolamine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x1B5D74))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x103947))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ethenone")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x141446))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x0C0C2B))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ethyl_acrylate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x947D15))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5B4D0D))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ethyl_hexanol")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFFCC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9E7E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ethyl_silicate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFCFFC1))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9C9E77))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ethyl_tertbutyl_ether")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB15C06))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6D3903))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ethyl_trifluoroacetate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x93A658))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5B6636))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ethylamine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5A656D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x373E43))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ethylanthrahydroquinone")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCECE00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7F7F00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ethylanthraquinone")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFF24))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9E16))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ethylbenzene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE4ECE8))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8D928F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ethylene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE1E1E1))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8B8B8B))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("ethylene_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8EB7D8))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x587185))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ethylene_sulfide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x868544))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x53522A))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ethylenediamine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x1B5D74))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x103947))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ethyleneglycol")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xADADAD))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6B6B6B))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("etrium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC0D8E8))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x77858F))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("europium_extracted_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE0E0E0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8A8A8A))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("europium_extraction_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE0E0E0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8A8A8A))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("europium_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCFCFCF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x808080))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("euv_photoresist")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4B0082))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2E0050))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("excited_scorching_cosmic_dust")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF2C6C6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xC65050))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("exciteddtec")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB36A6B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6E4142))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("exciteddtsc")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB36A6B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6E4142))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("exotic_heavy_residues")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3E8496))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x26515D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("explosivehydrazine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3B0C5C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x240739))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("extraction_residue")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB8A97C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x72684C))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("extreme_temperature_interface_stabilized_mfpc")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x404042))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x272728))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("fall_king")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFCF6B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E8042))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("fermented_biomass")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x445500))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2A3400))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ferric_ree_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x68680D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x404008))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ferrite_mixture")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB4B4B4))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x763200))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("ferrocene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7373C9))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x47477C))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ferromagnetic_residues")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x1F5D46))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x13392B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("ferrosilite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x968C80))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x97732A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("fgm_tps10_thermal_protection_composite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7D5721))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5E3A16))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE)
                .build();
        MaterialRegistry.register("fiberglass_reinforced_plastic")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE8EFE9))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xB7C6B7))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("fireclay")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFEAB6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x84581C))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("fish_oil")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xDCC15D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x887739))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("fissioned_uranium_235")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x39C9B7))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x237C71))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("flint")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC7C7C7))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x212121))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("flocculation_waste_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC7CAC1))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7B7D77))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("fluix")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8F5CCB))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x58397D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE)
                .build();
        MaterialRegistry.register("fluorinated_samarium_concentrate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x969696))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5D5D5D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
    }
}
