package com.shifen0520.shjtcore.material.data;

import net.minecraft.resources.ResourceLocation;

public final class RgbColorDataType extends MaterialDataType<RgbColorData> {
    public RgbColorDataType(ResourceLocation id) {
        super(id);
    }

    public MaterialDataUse<RgbColorData> rgb(int rgb) {
        return use(RgbColorData.create(rgb));
    }
}