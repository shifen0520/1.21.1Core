package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 12 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials12 {

    private Materials12() {
    }

    static void init() {
        MaterialRegistry.register("fluorine_cracked_aquadah")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x424D4B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x282F2E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("fluorite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x18B400))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x0E6F00))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("fluoro_benzene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8FBC8F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x587458))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("fluoro_carbon_lanthanide_cerium_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7F7F7F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4E4E4E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("fluoro_carbon_lanthanide_cerium_rare_earth_suspension")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBEBEBE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x757575))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("fluoro_carbon_lanthanide_cerium_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3888D2))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x225482))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("fluoroantimonic_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE8E0A0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8F8A63))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("fluoroboric_acide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8FBC8F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x587458))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("fluorocarborane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x00EC80))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x00924F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("fluorosilicic_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x49BF61))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2D763C))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("fluorotoluene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xDAD386))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x878253))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("fluxed_electrum")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF8F8D6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x999984))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("flyb")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x890A95))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x54065C))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("force")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xDEDE00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x898900))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("formaldehyde")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xDDECED))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x899292))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("formamide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5CCCB6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x397E70))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("formic_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA6A6A6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x666666))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("francium_caesium_cadmium_bromide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA34D1A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x652F10))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("francium_carbide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA1A1A1))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x636363))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("free_alpha_gas")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB5AB06))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x706A03))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("free_electron_gas")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x033C3C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x012525))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("free_proton_gas")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2089AA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x135469))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("frozen_volatile_ice")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x78D4F2))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4CA6C6))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("fullerene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x86C2B8))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x537872))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("fullerene_doped_nanotubes")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x562356))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x351535))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("fullerene_polymer_matrix_pulp")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x23221E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x151512))
                .forms(MaterialForms.FOIL, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("fullers_earth")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF3EFBB))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xB8D066))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("fuming_nitric_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB46800))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6F4000))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("fusion_residue")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5A4C9E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x372F61))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("gadolinium_extracted_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF0F0F0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x949494))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("gadolinium_extraction_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF0F0F0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x949494))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("gadolinium_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCFCFCF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x808080))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("galena")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF3E8FA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x331D42))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("gallium_arsenide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x938FFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8C548C))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("gallium_sulfide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFEE5D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xEDF008))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("gamma_rays_photoresist")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x556B2F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x34421D))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("gammabutyrolactone")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCCCCA1))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7E7E63))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("garnet_sand")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCC4C25))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x510B04))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("garnierite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x32C880))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x344028))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("gasoline")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFAA500))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9B6600))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("gelatin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFAF7CB))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x693D00))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("gelatin_mixture")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x588BAE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x36566B))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("germanium_ash")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x706699))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x453F5E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("germanium_containing_precipitate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x666699))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3F3F5E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("germanium_dioxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9E9E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("germanium_tetrachloride_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x66FFCC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3F9E7E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("germanium_tungsten_nitride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7070A2))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x454564))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("glacial_air")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7FDFF4))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4E8A97))
                .data(MaterialDataTypes.MELTING_POINT.value(12))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("glass")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9E9E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("glauconite_sand")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x1DA351))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1A6E8F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
    }
}
