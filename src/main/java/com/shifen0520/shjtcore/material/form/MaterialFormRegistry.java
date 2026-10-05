package com.shifen0520.shjtcore.material.form;

import com.shifen0520.shjtcore.material.MaterialForm;
import net.minecraft.resources.ResourceLocation;

import java.util.*;
import java.util.function.Function;

public final class MaterialFormRegistry {
    private static final Map<ResourceLocation, MaterialForm> REGISTRY = new LinkedHashMap<>();

    private MaterialFormRegistry() {}

    public static MaterialForm register(String path, Function<ResourceLocation, MaterialForm> factory) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath("shjtcore", path);
        MaterialForm form = factory.apply(id);
        REGISTRY.put(id, form);
        return form;
    }

    public static MaterialForm get(ResourceLocation id) { return REGISTRY.get(id); }

    public static List<MaterialForm> all() { return List.copyOf(REGISTRY.values()); }
}