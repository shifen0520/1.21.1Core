package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 23 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials23 {

    private Materials23() {
    }

    static void init() {
        MaterialRegistry.register("polyvinylpyrrolidone")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE0F2CF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8A9680))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("poor_mix")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x916D12))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x59430B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("positive_electron")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x59764C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x37492F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("potash")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFA772))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x922F1B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("potassium_bisulfite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x807D72))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F4D46))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("potassium_bromide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA34A76))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x652D49))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("potassium_carbonate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA66C71))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x802D67))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("potassium_cyanide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x93BADB))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x0C5696))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("potassium_dichromate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF6000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xFF0000))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("potassium_ethylate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCD661D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7F3F11))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("potassium_ethylxanthate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCDC8B1))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7F7C6D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("potassium_feldspar")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFE3BC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xD4918A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("potassium_ferrocyanide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC9A842))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x947110))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("potassium_fluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB9B9B9))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x727272))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("potassium_hydroxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD1C299))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x85623A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("potassium_hydroxylaminedisulfonate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4C6226))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2F3C17))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("potassium_iodide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA66C71))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x802D67))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("potassium_pyrosulfate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF9900))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E5E00))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("potassium_sulfate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEBAB34))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xB5570E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("potin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xAAADA3))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5E3320))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("powellite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD8CFAC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xBC7A2C))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("praseodymium_extracted_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA0A0A0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x636363))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("praseodymium_extraction_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA0A0A0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x636363))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("praseodymium_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCFCFCF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x808080))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("prasiolite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9EB749))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x61712D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("pre_zylon")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x562050))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x351331))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("primordialmatter")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA050C8))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x63317C))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("promethium_extracted_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC0C0C0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x777777))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("promethium_extraction_nano_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC0C0C0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x777777))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("promethium_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCFCFCF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x808080))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("propadiene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x323B0A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1F2406))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("propane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFAE250))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9B8C31))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("propargyl_alcohol")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBCB600))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x747000))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("propargyl_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x776B00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x494200))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("propene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFDD55))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E8934))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("propylene_carbonate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBF0F7F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x76094E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("prussian_blue")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x102E5E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x010C42))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("prussian_blue_copper_i_nanotubes")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3A373B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x59565A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("pulsating_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x6AE26E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x418C44))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("pure_silane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB5B5B5))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x707070))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("pure_trichlorosilane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB7B7B7))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x717171))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("purified_tengam")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x819A4E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F5F30))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("purified_xenoxene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5C7A58))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x394B36))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("purple_dye")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x800080))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F004F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("pyridine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x555642))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x343528))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("pyrite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFEE6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xB69F4E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("pyrochlore")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5B4838))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x331400))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("pyrolusite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC7B5AB))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x595756))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("pyromellitic_dianhydride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x708090))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x454F59))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("pyrope")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE81958))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x811E00))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
    }
}
