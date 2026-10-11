package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 27 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials27 {

    private Materials27() {
    }

    static void init() {
        MaterialRegistry.register("silicon_carbide_fiber_reinforced_titanium_matrix_composite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x6D4041))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4C292A))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("silicon_dioxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF2F2F2))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xB2C4C7))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("silicon_nitride_ceramic")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x29C824))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1B7A1B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("silicone_rubber")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF0F0F0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xE8E8E0))
                .forms(MaterialForms.GEAR, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("siliconoil")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xADADAD))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6B6B6B))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("silver_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8D8D8D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x575757))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("silver_coated_hollow_ceramic_microspheres")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2B2D30))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1A1B1D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("silver_coated_octane_ceramic_beads")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2B2D30))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1A1B1D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("silver_iodide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xACA56A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6A6641))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("silver_nitrate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFCE0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9C8A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("silver_nitrate_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFCE0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9C8A))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("silver_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2B2B2B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1A1A1A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("silver_perchlorate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEDEDED))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x929292))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("silver_tetrafluoroborate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x76750F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x494809))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("sm_gd_oxides_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFF99))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9E5E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("soap")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF9D1B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E6110))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("soapstone")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5A7261))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x464C4B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("soda_ash")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xDCDCFF))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sodalite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3D54FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x210D78))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD)
                .build();
        MaterialRegistry.register("sodium_allylsulfonate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3F7F0D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x274E08))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("sodium_aluminate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xDEE8EA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x898F91))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sodium_aluminium_hydride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x87BFBF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x537676))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sodium_azanide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2381B3))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x154F6E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sodium_azide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x1018F0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x090E94))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sodium_bicarbonate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xA7D2DF))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sodium_bisulfate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFEFFED))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xF1F0A3))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sodium_borohydride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9AB0B2))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5F6D6E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sodium_bromide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC588C4))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7A5479))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sodium_chlorate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA5A5A5))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x666666))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sodium_cyanide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4F6774))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x303F47))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("sodium_ethylate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9BCD9B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x607F60))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sodium_ethylxanthate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCDAD00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7F6B00))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sodium_fluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x460011))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2B000A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sodium_formate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF1939C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x955B60))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("sodium_hexafluoroaluminate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA47732))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x65491F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("sodium_hydride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x757475))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x484748))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sodium_hydroxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF5FEFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xA4EBF1))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sodium_hydroxide_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x000791))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x000459))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("sodium_hypochlorite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x66F14C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3F952F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sodium_molybdate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBCDEF0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x748994))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sodium_nitrate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4E2A40))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x301A27))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sodium_nitrate_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2B387E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1A224E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("sodium_nitrite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCFBF65))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x85600B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sodium_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x036DEE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x014393))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sodium_perchlorate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF0F0F0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x949494))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sodium_persulfate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE0E8E8))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8A8F8F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("sodium_potassium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x64FCB4))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3E9C6F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("sodium_rutheniate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x282C8C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x181B56))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sodium_seaborgate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x55BBD4))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x347383))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("sodium_sulfate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF9F6CF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9A9880))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
    }
}
