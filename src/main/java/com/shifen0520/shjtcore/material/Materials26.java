package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 26 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials26 {

    private Materials26() {
    }

    static void init() {
        MaterialRegistry.register("samarium_chloride_with_impurities")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB0B0B0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6D6D6D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("samarium_extracted_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD0D0D0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x808080))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("samarium_extraction_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD0D0D0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x808080))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("samarium_iron_arsenic_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x850E85))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x332F33))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("samarium_oxalate_with_impurities")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x808080))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F4F4F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("samarium_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCFCFCF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x808080))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("samarium_precipitate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x969696))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5D5D5D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("samarium_rare_earth_concentrate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x808080))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F4F4F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("samarium_rare_earth_diluted_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA9A9A9))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x686868))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("samarium_rare_earth_slurry")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x808080))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F4F4F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("samarium_rare_earth_turbid_liquid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCFC883))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x807C51))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("samarium_refined")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8A6D7D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x55434D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("samarium_terbium_mixture")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x969696))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5D5D5D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sapphire")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3235E3))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x211455))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD)
                .build();
        MaterialRegistry.register("sapphire_slurry")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x6464C8))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3E3E7C))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("sarcosine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x809324))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F5B16))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("saturated_monazite_rare_earth")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9E9E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("scalm_alloy_s")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD7FCFE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9EF1F5))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("scandium_extracted_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x808000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F4F00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("scandium_extraction_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x808000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F4F00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("scandium_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCFCFCF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x808080))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("scandium_titanium_50_mixture")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEB315F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x911E3A))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("scheelite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD7E8B3))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x143CAE))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("scorching_cosmic_dust")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC65050))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xF27878))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sculk")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x015A5C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x001616))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("seaborgium_doped_nanotubes")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x242473))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x161647))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("sealed_phase_change_beads")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2B2D30))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1A1B1D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("seaweedbroth")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2C9400))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1B5B00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("seed_oil")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9E9E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("selenium_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFF71C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9911))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("severely_hydro_cracked_gas")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC8C8C8))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7C7C7C))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("severely_hydro_cracked_heavy_fuel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFF00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9E00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("severely_hydro_cracked_light_fuel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB7AF08))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x716C04))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("severely_hydro_cracked_naphtha")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBFB608))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x767004))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("severely_steam_cracked_gas")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE0E0E0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8A8A8A))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("severely_steam_cracked_heavy_fuel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB09040))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6D5927))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("severely_steam_cracked_light_fuel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD0B860))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x80723B))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("severely_steam_cracked_naphtha")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBFB608))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x767004))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("shewanella")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x800C4F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F0730))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("shirabon")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC61361))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7A0B3C))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("silane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB5B5B5))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x707070))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("silica_alumina_gel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0C849F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x075162))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("silica_carbon_composite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x141417))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x0D0D0E))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD_LONG, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("silica_ceramic")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x393941))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x232328))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("silica_gel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x57C3E4))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x35788D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("silica_gel_base")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x39967A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x235D4B))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("silica_sol")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8D3C4F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x572530))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("silicic_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD3D2D5))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x828284))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("silicon_carbide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x34ADB6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x206B70))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("silicon_carbide_fiber_reinforced_nickel_based_composite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x1D4A2F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x102D1A))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD_LONG, MaterialForms.LIQUID)
                .build();
    }
}
