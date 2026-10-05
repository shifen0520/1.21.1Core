package com.shifen0520.shjtcore.material.data;

import net.minecraft.resources.ResourceLocation;

import java.util.LinkedHashMap;
import java.util.Map;

public class MaterialDataRegistry {
    private static final Map<ResourceLocation, MaterialDataType<?>> REGISTRY = new LinkedHashMap<>();

    public static <D, H extends MaterialDataType<D>> H register(String path, H handle) {
        REGISTRY.put(ResourceLocation.fromNamespaceAndPath("shjtcore", path), handle);
        return handle;
    }

    static <D> MaterialDataUse<D> use(MaterialDataType<D> type, D data) {
        return new MaterialDataUse<>(type, data);
    }
}
