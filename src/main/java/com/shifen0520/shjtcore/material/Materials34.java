package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 34 段（共 34 段，本段 15 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials34 {

    private Materials34() {
    }

    static void init() {
        MaterialRegistry.register("zinc_iodide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFF00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9E00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("zinc_sulfate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x533C1B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x332510))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("zinc_sulfide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFF4D5))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xDADADA))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("zincite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF9F49))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xFF0000))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("zircon")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xDE953C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x895C25))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("zircon_chlorinating_residue")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x33CA33))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1F7D1F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("zirconia_ceramic")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEAEAEA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x919191))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("zirconia_nickel_base_graded_composite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4B7F4C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x30522F))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ROD_LONG, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("zirconiu_hafnium_oxychloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x33CA33))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1F7D1F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("zirconium_carbide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD2BFAA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x827669))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("zirconium_diboride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4E5166))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x30323F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("zirconium_hafnium_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x33CA33))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1F7D1F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("zirconium_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3C3C3C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x252525))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("znfealcl")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCF51AA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x803269))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("zylon")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD2B800))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x827200))
                .forms(MaterialForms.FOIL, MaterialForms.FLUID)
                .build();
    }
}
