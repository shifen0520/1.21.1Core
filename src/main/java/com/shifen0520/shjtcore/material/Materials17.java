package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 17 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials17 {

    private Materials17() {
    }

    static void init() {
        MaterialRegistry.register("lead_niobate_magnesium_niobate_ceramic")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF4500))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E2A00))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("lead_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFD700))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E8500))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("lead_zinc_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB0B8C0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6D7277))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("lead_zirconate_titanate_ceramic")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFA500))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E6600))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("lead_zirconate_titanate_shape_piezoelectric_ceramic")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB357BA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7A3A7D))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ROD_LONG, MaterialForms.FOIL)
                .build();
        MaterialRegistry.register("legendarium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x00FFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x009E9E))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("lepidolite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFDAE4))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x75376F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("light_blue_dye")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x6080FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3B4F9E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("light_emitting_charged_suspicious_waste")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x39CCF4))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x237E97))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("light_fuel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD8B858))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x857236))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("light_gray_dye")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC0C0C0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x777777))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("light_quarks")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0000CE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x00007F))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("lightly_hydro_cracked_gas")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA0A0A0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x636363))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("lightly_hydro_cracked_heavy_fuel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFF00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9E00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("lightly_hydro_cracked_light_fuel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB7AF08))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x716C04))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("lightly_hydro_cracked_naphtha")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBFB608))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x767004))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("lightly_steam_cracked_gas")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE0E0E0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8A8A8A))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("lightly_steam_cracked_heavy_fuel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC0A050))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x776331))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("lightly_steam_cracked_light_fuel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD8C070))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x857745))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("lightly_steam_cracked_naphtha")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBFB608))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x767004))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("lightradox")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x6C006C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x420042))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("lime_dye")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x80FF80))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F9E4F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("linoleic_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x979744))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5D5D2A))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("lipoic_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7B717F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4C464E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("liquid_air")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA9D0F5))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x688097))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("liquid_ammonia")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4FC4A2))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x307964))
                .data(MaterialDataTypes.MELTING_POINT.value(240))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("liquid_ender_air")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x283454))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x182034))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("liquid_hydrogen")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4FC4A2))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x307964))
                .data(MaterialDataTypes.MELTING_POINT.value(20))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("liquid_nether_air")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4C3434))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2F2020))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("liquid_nitrogen")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x057A99))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x034B5E))
                .data(MaterialDataTypes.MELTING_POINT.value(77))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("liquid_starlight")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFF0A0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9463))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("liquidcrystalkevlar")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9F9F50))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x626231))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("lithium_aluminium_fluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xAD1F58))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6B1336))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("lithium_aluminium_hydride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xABD7DF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6A858A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("lithium_bis_trifluoromethanesulfonylimide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0CCFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x07809E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("lithium_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xDEDEFA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x89899B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("lithium_cyclopentadienide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7B4657))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4C2B35))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("lithium_fluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x6D6D6D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x434343))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("lithium_iodide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC10014))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x77000C))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("lithium_niobate_nanoparticles")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC1C12D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x77771B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("lithium_oxide_ceramics")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF3FFF3))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x969E96))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("lithium_thiinediselenide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x72CB00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x467D00))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("low_purity_naquadah_emulsion")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x363635))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x212120))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("low_purity_naquadah_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x374939))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x222D23))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("lpg")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFCFCAC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9C9C6A))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("lubricant")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD0A850))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x806831))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("lumiium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD9E222))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x868C15))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("lumin_essence")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x838914))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x51540C))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("lutetium_extracted_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x800080))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F004F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("lutetium_extraction_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x800080))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F004F))
                .forms(MaterialForms.FLUID)
                .build();
    }
}
