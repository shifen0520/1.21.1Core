package com.shifen0520.shjtcore.material.data;

import net.minecraft.resources.ResourceLocation;

public abstract class MaterialDataType<D> {
    private final ResourceLocation id;

    protected MaterialDataType(ResourceLocation id) {
        this.id = id;
    }

    public final ResourceLocation id() {
        return id;
    }

    protected final MaterialDataUse<D> use(D data) {
        return MaterialDataRegistry.use(this, data);
    }
}
