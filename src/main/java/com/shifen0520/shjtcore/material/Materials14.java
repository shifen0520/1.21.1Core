package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 14 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials14 {

    private Materials14() {
    }

    static void init() {
        MaterialRegistry.register("heavy_oxidized_residues")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x310D48))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1E082C))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("heavy_paramagnetic_residues")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x1A8E2F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x10581D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("heavy_quark_degenerate_matter")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x52A733))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x32671F))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("heavy_quark_enriched_mixture")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xECECEC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x929292))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("heavy_quarks")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x007000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x004500))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("heavyradox")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x6C006C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x420042))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("helium_3")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE0D0F0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8A8094))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("helium_iii_hydride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9F9F02))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x626201))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("hematite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF7161))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x330817))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("hexabenzylhexaazaisowurtzitane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x64704D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3E452F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("hexadecyl_bromide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFF68F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9858))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("hexafluoride_enriched_naquadah_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x868D7F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x53574E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("hexafluoride_naquadria_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x25C213))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x16780B))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("hexafluorophosphoric_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD5D54B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x84842E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("hexamethyldisilazane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE0E0E0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8A8A8A))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("hexamethyldisiloxane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9E9E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("hexamethylenetetramine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5A6261))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x373C3C))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("hexanitrohexaaxaisowurtzitane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3D464B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x252B2E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("hexaphasecopper")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEC7916))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x924B0D))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.NANITES, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("high_durability_compound_steel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2D3C2D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1B251B))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("high_energy_mixture")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xDBD69C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x878460))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("high_energy_quark_gluon")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7400CE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x47007F))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("high_entropy_shape_memory_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB2A6A0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7A6E68))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("high_octane_gasoline")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFA500))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E6600))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("high_pressure_argon")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB3D9BD))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6E8675))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("high_pressure_helium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFEF3D2))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9D9682))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("high_pressure_hydrogen")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x00009D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x000061))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("high_pressure_krypton")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3ACA32))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x237D1F))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("high_pressure_neon")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF6E40))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E4427))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("high_pressure_nitrogen")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x139099))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x0B595E))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("high_pressure_oxygen")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3FA2D4))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x276483))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("high_pressure_static_adsorption_mfpc")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA4A0A0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x656363))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("high_pressure_steam")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEEF2E9))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x939690))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("high_purity_calcium_carbonate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEEEEE0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x93938A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("high_purity_silica")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9E9E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("high_temperature_shape_memory_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFE0B2))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xC6AA88))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("hikarium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE2BEDE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8C7589))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("hmxexplosive")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF3FFDB))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x969E87))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("hollow_ceramic_microsphere_rough_embryo")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2B2D30))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1A1B1D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("hollow_ceramic_microspheres")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2B2D30))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1A1B1D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("holmium_extracted_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x00FF00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x009E00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("holmium_extraction_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x00FF00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x009E00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("holmium_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCFCFCF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x808080))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("honey")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFCD12C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9C811B))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("hot_alkaline_debrominated_brine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBE8938))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x755422))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("hot_brine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBE6026))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x753B17))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("hot_chlorinated_brominated_brine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xAB765D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6A4939))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("hot_debrominated_brine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xAB896D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6A5443))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("hot_oganesson")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x42145D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x280C39))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("hot_sodium_potassium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x64FCB4))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3E9C6F))
                .forms(MaterialForms.FLUID)
                .build();
    }
}
