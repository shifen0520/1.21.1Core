package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 24 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials24 {

    private Materials24() {
    }

    static void init() {
        MaterialRegistry.register("pyrope_front")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8B0000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x560000))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("quantanium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0DFF02))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x089E01))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR_SMALL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("quantum_chromo_dynamically_confined_matter")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD08C38))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x805622))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("quantum_dots")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xDA0000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x870000))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("quantum_metal")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0D0D0D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x080808))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("quark_gluon")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7A00DA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4B0087))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("quartz_fiber_reinforced_silica")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEFF3F3))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xC7D3D3))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("quartz_sand")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF8EFE3))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xE6C1BB))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("quartzite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF2F5ED))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xB8E2B8))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE)
                .build();
        MaterialRegistry.register("quasifissioning")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCDBE35))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7F7520))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("quicklime")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xECFFF3))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7D8E83))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("rad_away")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE3A1D7))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9845A3))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("radiation_shielding_high_density_tungsten_steel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7A7A8B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4C4C5E))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("radium_nitrate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCD40DA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7F2787))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("radon_cracked_enriched_aquadah")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x424D4B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x282F2E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("radon_difluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8B7EFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x564E9E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("radon_naquadria_octafluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x85F378))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x52964A))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("radon_trioxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9A6DD7))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5F4385))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("radox")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x680064))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x40003E))
                .forms(MaterialForms.FOIL, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("radox_gas")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xAB57AB))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6A356A))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("rapidly_replicating_animal_cells")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8C104B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x56092E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("rare_earth")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFDC88))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xE99673))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("rare_earth_chlorides")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBDB76B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x757142))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("rare_earth_hydroxides")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x808000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F4F00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("rare_earth_metal")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x737373))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x474747))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("rare_earth_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x808000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F4F00))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("rareearth_mix")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA52A2A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x661A1A))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("rarest_metal_mixture")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCA8832))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xB21900))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("raw_brine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9F6B26))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x624217))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("raw_gasoline")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF6400))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E3E00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("raw_growth_medium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA47351))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x654732))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("raw_rubber")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x54503D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x54403D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("raw_star_matter")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFD060))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E803B))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("raw_styrene_butadiene_rubber")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x54403D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x241520))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("raw_tengam")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x819A4E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F5F30))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("rawradox")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x391539))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x230D23))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("reactivated_phase_change_microbeads")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2B2D30))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1A1B1D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("reactor_steel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB4B3B0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6F6E6D))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE_DENSE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("realgar")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF3D33))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3F0110))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("rearranged_cosmic_dust")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB1B1B1))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xE2E2E2))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("recycle_basic_mfpc")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC0C0C0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x777777))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("recycled_phase_change_microbeads")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2B2D30))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1A1B1D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("red_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC55252))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xC80000))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("red_dye")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF0000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E0000))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("red_garnet")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x950C15))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x510B04))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD)
                .build();
        MaterialRegistry.register("red_mud")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x972903))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5D1901))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("red_slurry")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x982902))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5E1901))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("red_steel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA09191))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x500404))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.ROD, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("red_zircon")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF4500))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E2A00))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("redrock")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFA49E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x52362A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
    }
}
