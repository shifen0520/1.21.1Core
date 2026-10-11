package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 28 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials28 {

    private Materials28() {
    }

    static void init() {
        MaterialRegistry.register("sodium_sulfide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFD83D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xC54A00))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sodium_tetrafluoroborate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA6640F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x663E09))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sodium_thiocyanate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7C4456))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4C2A35))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("sodium_thiosulfate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x145A9D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x0C3761))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sodium_toluenesulfonate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB5B41D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x706F11))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("sol_gel_qd_interface_modified_mfpc")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x868080))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x534F4F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("soldering_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8C8CA7))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8675A7))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("soul_crystal")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7CE8E8))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4C8F8F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("soul_jade_crystal_residue")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB19CD9))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6D6086))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("soularium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7C674D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4C3F2F))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("spacetime")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9A6CFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5F429E))
                .data(MaterialDataTypes.MELTING_POINT.value(1))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.NANITES, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("spacetime_continuum")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB07CFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6D4C9E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("spatialfluid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x6CC8FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x427C9E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("special_ceramics")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5C5909))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x393705))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("spessartine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFA81E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xB33700))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("spessartine_front")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEE5C42))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x933928))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("sphalerite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFDC88))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x0F1605))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sphalerite_front")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEEE9E9))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x939090))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("spodumene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFBCBC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xC490FF))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("stable_baryonic_matter")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x50C8A0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x317C63))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("stainless_steel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEDEDFD))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x19191D))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("stainless_steel_15_5ph")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD2D7DC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xA1A6AC))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("stainless_steel_316")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEAE9E3))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xB7B8B1))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("stainless_steel_420")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC1C3C5))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8F9294))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("stainless_steel_gc4")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC5CBD0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x929AA1))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("stainless_steel_jbk75")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF7FAFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9FA1A3))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("star_blood_crystal_residue")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7B68EE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4C4093))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("starlight")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFE86C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E8F42))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("starlite_steel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD2D2D2))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9A9A9A))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("starmetal")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0000E6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x00008E))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.NANITES, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("steam")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD8E8F0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x858F94))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("steam_cracked_butadiene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xAD5203))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6B3201))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("steam_cracked_butane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x852C18))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x521B0E))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("steam_cracked_butene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x993E05))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5E2603))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("steam_cracked_ethane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9696BC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5D5D74))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("steam_cracked_ethylene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA3A3A0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x656563))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("steam_cracked_fluoro_carbon_lanthanide_slurry")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7F7FFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4E4E9E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("steam_cracked_propane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBEA540))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x756627))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("steam_cracked_propene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBEA540))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x756627))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("steam_cracked_turpentine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8B6914))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x56410C))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("stearic_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x239791))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x155D59))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("steel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA7A7A7))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x121C37))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.PLATE_DENSE, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.SPRING, MaterialForms.SPRING_SMALL, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("stellar_energy_rocket_fuel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xDF362D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8A211B))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("stellar_matter_remnant_dust")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFD878))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xC6A650))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("stellite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x888192))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x544F5A))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("stellite_100")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCFCFEE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x808093))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("sterilized_growth_medium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xAC876E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6A5344))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("sterling_silver")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFAF4DC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x484434))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("stibnite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x656565))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x0A1432))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("stone")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8F8F8F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x898989))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR)
                .build();
    }
}
