package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 31 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials31 {

    private Materials31() {
    }

    static void init() {
        MaterialRegistry.register("titanium_50")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD58EED))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x845892))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("titanium_50_tetrachloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xAFEEEE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6C9393))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("titanium_50_tetrafluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD68FED))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x845892))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("titanium_5553")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC380C6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8B5E8B))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("titanium_carbide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x90092F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x59051D))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("titanium_dioxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFCF6FC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9C989C))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("titanium_dioxide_nanotube_reinforced_titanium_matrix_composite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x91269D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5E167D))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("titanium_dioxide_nanotubes")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x491506))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x130101))
                .forms(MaterialForms.FOIL, MaterialForms.WIRE_FINE, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("titanium_nanotube_precursor")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x808080))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F4F4F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("titanium_nitride_ceramic")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD4AC4B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9C7A34))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("titanium_steel_composite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBB7390))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7A4C5E))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD_LONG, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("titanium_tb6")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB9A7BA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7A6A7A))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("titanium_tc11")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8C7A8B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5E4C5E))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("titanium_tc21")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC6A5B1))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8B6A7A))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("titanium_tetrachloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD40D5C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x830839))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("titanium_tetrafluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD68FED))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x845892))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("titanium_ti53311s")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD2B8C6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9A7A88))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("titanium_ti64")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCBBCC5))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8B7A8B))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("titanium_trifluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8F00FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x341465))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("titanium_tungsten_carbide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x680B0B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x400606))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("titansteel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE60000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8E0000))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("titanyl_sulfate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF82296))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x99155D))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("toluene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE8F0EC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8F9492))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("toluene_diisocyanate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xACF4BF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6A9776))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("topaz")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE8D73A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xF4680F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD)
                .build();
        MaterialRegistry.register("transcendent_metal")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9E9E))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.NANITES, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("transition_mix")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x989594))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5E5C5B))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("transition_mix_1")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA19E9D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x636161))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("transition_mix_2")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x908D8C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x595756))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("transition_mix_3")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x838180))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x514F4F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("treated_wood")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x644218))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4E0B00))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD)
                .build();
        MaterialRegistry.register("tricalcium_phosphate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFDDB))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xFFFF00))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("tricalcium_phosphate_ceramic")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE9F4F4))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x909797))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("trichloroflerane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x42145D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x280C39))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("trichlorosilane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB7B7B7))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x717171))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("tricotylphosphine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE7D510))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8F8409))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("triethoxysilane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBCBEC4))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x747579))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("trifluoroacetic_phosphate_ester")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA99F45))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x68622A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("trifluoromethanesulfonic_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x68680D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x404008))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("trifluoromethanesulfonyl_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x68680D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x404008))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("trimethylamine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCEA67D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7F664D))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("trimethylchlorosilane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x591399))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x370B5E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("trimethylsilane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7D2FC3))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4D1D78))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("trimethylsilanol")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x622998))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3C195E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("trimethyltin_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x72685F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x46403A))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("trinaquadalloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x281832))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x180E1F))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("trinium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x81808A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x351D4B))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("trinium_compound")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x675989))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3F3754))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("trinium_compound_front")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBAE8E6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x738F8E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("trinium_sulfide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE68066))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6F143A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
    }
}
