package com.shifen0520.shjtcore.material.data;

import net.minecraft.resources.ResourceLocation;

/**
 * 通用整型材料数据。目前用于熔点（开尔文）与密度（kg/m³）——
 * 流体注册时优先取材料自身的这类数据，取不到才回落形态的默认值。
 */
public final class IntDataType extends MaterialDataType<Integer> {
    public IntDataType(ResourceLocation id) {
        super(id);
    }

    public MaterialDataUse<Integer> value(int v) {
        return use(v);
    }
}
