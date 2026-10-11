package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 1 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials01 {

    private Materials01() {
    }

    static void init() {
        MaterialRegistry.register("1_octene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x666D61))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3F433C))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("abs")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE8E7E5))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8F8F8D))
                .forms(MaterialForms.PLATE, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("absolute_ethanol")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF4500))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E2A00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("abyssalalloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9E706A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x614541))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("acetaldehyde")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x666D61))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3F433C))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("acetic_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC8B4A0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7C6F63))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("acetic_anhydride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE0D182))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8A8150))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("acetone")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xAFAFAF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6C6C6C))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("acetonitrile")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5A6161))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x373C3C))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("acetyl_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD1B117))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x816D0E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("acetylacetonate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFFF0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9E94))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("acetylating_reagent")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x724C50))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x462F31))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("acetylene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7F8552))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4E5232))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("acidic_bromine_exhaust")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8F681E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x584012))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("acidic_bromine_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC49B52))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x796032))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("acidic_enriched_naquadah_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3DD63D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x258425))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("acidic_iridium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x634E3A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3D3023))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("acidic_monazite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9ACD32))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5F7F1F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("acidic_naquadria_caesiumfluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x75EB00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x489100))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("acidic_naquadria_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x70D670))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x458445))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("acidic_osmium_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xDAC5C5))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x877A7A))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("acrylic_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB41558))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6F0D36))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("acrylonitrile")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA4A4E1))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x65658B))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("actinium_hydride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB8C6F1))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x727A95))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("actinium_nitrate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xDAE0EE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x878A93))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("actinium_oxalate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCFCFCF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x808080))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("actinium_radium_hydroxide_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC3E0DC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x788A88))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("actinium_radium_nitrate_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x89C0B3))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x54776E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("actinium_superhydride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x52B051))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x326D32))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GAS)
                .build();
        MaterialRegistry.register("actinium_trinium_hydroxides")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xAD47CF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6B2C80))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("actinoids_mix")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x72D22E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x46821C))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("actinoids_mix_1")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x80EB33))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F911F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("actinoids_mix_2")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x80EB33))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F911F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("activated_carbon")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x212125))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x15151A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("adamantine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE6E600))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8E8E00))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("adamantine_compounds")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xDAA520))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x876613))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("adamantium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEFBE35))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x947520))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("aerogel_porous_particles")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE2E2E2))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xB1B1B1))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("agar")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBDD168))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x403218))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("algae_extract")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA3CA00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x657D00))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("alien_algae")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x808000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F4F00))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("alkaline_earth_mix")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC1155E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x770D3A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("alkaline_mix")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xDD186B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x890E42))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("all_vanadium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF4D00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E2F00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("allyl_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x87DEAA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x538969))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("almandine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA21717))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4B1E0C))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("almandine_front")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB22222))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6E1515))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("alpha_particle")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x378D94))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x22575B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("alumina")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x1D4759))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x112C37))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("alumina_ceramic")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE8F0FE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8F949D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
    }
}
