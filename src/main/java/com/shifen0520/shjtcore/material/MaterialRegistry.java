package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataType;
import com.shifen0520.shjtcore.material.data.MaterialDataUse;
import net.minecraft.resources.ResourceLocation;

import java.util.*;

public final class MaterialRegistry {
    private static final Map<ResourceLocation, Material> REGISTRY = new LinkedHashMap<>();
    private static boolean frozen = false;

    private MaterialRegistry() {
    }

    public static Builder register(String path) {
        return register(ResourceLocation.fromNamespaceAndPath("shjtcore", path));
    }

    public static Builder register(ResourceLocation id) {
        return new Builder(id);
    }

    public static Material require(ResourceLocation id) {
        Material material = REGISTRY.get(id);
        if (material == null) {
            throw new IllegalStateException("no material for " + id);
        }
        return material;
    }

    public static List<Material> registered() {
        return List.copyOf(REGISTRY.values());
    }

    public static boolean isFrozen() {
        return frozen;
    }

    public static void freeze() {
        frozen = true;
    }

    public static final class Builder {
        private final ResourceLocation id;
        private final Map<MaterialDataType<?>, MaterialDataUse<?>> data = new LinkedHashMap<>();
        private final Set<ResourceLocation> formIds = new LinkedHashSet<>();

        private Builder(ResourceLocation id) {
            this.id = id;
        }

        public Builder data(MaterialDataUse<?> use) {
            this.data.put(use.type(), use);
            return this;
        }

        public Builder forms(MaterialForm... forms) {
            for (MaterialForm f : forms) {
                this.formIds.add(f.id());
            }
            return this;
        }

        public Material build() {
            if (frozen) throw new IllegalStateException("material registry is frozen");
            if (REGISTRY.containsKey(id)) throw new IllegalStateException("duplicate material " + id);
            Material material = new Material(id, data, formIds);
            REGISTRY.put(id, material);
            return material;
        }
    }
}