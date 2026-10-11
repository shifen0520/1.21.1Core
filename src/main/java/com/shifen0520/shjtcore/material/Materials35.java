package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 35 段：GTM 1.21 官方材料表里有、而本模组原有数据缺失的 19 个材料。
 *
 * <p>颜色严格取自 GTM 1.21 分支的 GTMaterials；形态按 GTM 的类型标记映射：
 * 气体 → GAS，常温流体 → FLUID，熔融 → LIQUID，粉尘 → DUST 系列，锭 → BLOCK/INGOT 系列。
 */
final class Materials35 {

    private Materials35() {
    }

    static void init() {
        MaterialRegistry.register("air")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA9D0F5))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x698198))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("bauxite_slag")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x6F2DA8))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x451C68))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("bauxite_sludge")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x563D2D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x35261C))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("bauxite_slurry")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x051650))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x030E32))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("blackstone")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3C3947))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x160F10))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("cracked_bauxite_slurry")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x052C50))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x031B32))
                .forms(MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("decalcified_bauxite_sludge")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x6F2DA8))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x451C68))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("heavy_oil")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0A0A0A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x060606))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("hydrogen_peroxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0CBDD7))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x077585))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ilmenite_slag")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8B0000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x560000))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("lava")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF4000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E2800))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("light_oil")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0A0A0A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x060606))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("netherite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4B4042))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x474447))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("plutonium_239")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBA2727))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x222730))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("raw_oil")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0A0A0A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x060606))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("red_granite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF0080))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E004F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("tuff")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x75756A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8A8A80))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("uranium_238")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x1D891D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x33342C))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("water")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0000FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x00009E))
                .forms(MaterialForms.FLUID)
                .build();
    }
}
