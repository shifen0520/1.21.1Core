package com.shifen0520.shjtcore.material.data;

import net.minecraft.resources.ResourceLocation;

public final class IntDataType extends MaterialDataType<Integer> {
    public IntDataType(ResourceLocation id) {
        super(id);
    }

    public MaterialDataUse<Integer> value(int v) {
        return use(v);
    }
}
