package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 30 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials30 {

    private Materials30() {
    }

    static void init() {
        MaterialRegistry.register("tantalite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4E6B94))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x632300))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("tantalloy_61")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x363636))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x212121))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("tantalum_carbide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x999900))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5E5E00))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("taranium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x000033))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x00001F))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.SPRING, MaterialForms.SPRING_SMALL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("taranium_enriched_liquid_helium_3")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x57F26D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x359643))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("taranium_rich_liquid_helium_4")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x57F26D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x359643))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("tartarite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD36232))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x823C1F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("tb_ho_oxides_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x99FF99))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5E9E5E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("tellurate_ceramics")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFEA9E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9161))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("tellurium_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD0D0D0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x808080))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("tempo")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF0000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E0000))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("temporalfluid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF7CD0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E4C80))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("terbium_extracted_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0080FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x004F9E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("terbium_extraction_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0080FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x004F9E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("terbium_nitrate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0080FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x004F9E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("terbium_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCFCFCF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x808080))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("terephthalaldehyde")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4A7454))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2D4734))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("terephthalicacid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD6D6D6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x848484))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("terephthaloyl_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x00E60B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x008E06))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("tert_butanol")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xACB500))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6A7000))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("tert_butyl_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF3ECC0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x969277))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("tertbuthylcarbonylazide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xACB500))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6A7000))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("tetraacetyldinitrosohexaazaisowurtzitane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x500449))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x31022D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("tetracene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8F7718))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x58490E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("tetrachloroethane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3F7F0F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x274E09))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("tetrachlorosilane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9E9E9E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x616161))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("tetraethylammonium_bromide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC20CFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x78079E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("tetraethylammonium_tetrafluoroborate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0CDDDF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x07898A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("tetrafluoroethylene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7D7D7D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4D4D4D))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("tetrafluorosilane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF6F7FB))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x98999B))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("tetrafluorosilane_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF6F7FB))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x98999B))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("tetrahedrite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA3A09B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x143313))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("tetrahydrofuran")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x86E4CE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x538D7F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("tetramethyl_bisphenol_a")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7F04AF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4E026C))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("tetramethylpiperidine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF00FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E009E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("tetranitromethane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0F2828))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x091818))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("thallium_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCC5350))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7E3331))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("thallium_thulium_doped_caesium_iodide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE8B97F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8F724E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("thermal_conductive_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFE278))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xC2A664))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("thionyl_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF8F5E0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x99978A))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("thorite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7D7D7D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4D4D4D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("thorium_phosphate_refined")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x545454))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x343434))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("thulium_extracted_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF0000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E0000))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("thulium_extraction_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF0000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E0000))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("thulium_hexaboride_ceramics")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x6CDCFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3AB1FF))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("thulium_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCFCFCF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x808080))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("ti_al_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x6E1050))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x440931))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("tin_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC8C8C8))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8B8B8B))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("titan_precision_steel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x595137))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x373222))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("titanium3_carbide_ceramic")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x6B423B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4E2F2A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
    }
}
