package com.shifen0520.shjtcore.material.data;

import net.minecraft.resources.ResourceLocation;

public final class MassDataType extends MaterialDataType<Integer> {
    public MassDataType(ResourceLocation id) {
        super(id);
    }

    public MaterialDataUse<Integer> mass(int mass) {
        return use(mass);
    }
}
