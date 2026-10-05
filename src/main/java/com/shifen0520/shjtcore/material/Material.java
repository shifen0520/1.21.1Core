package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataType;
import com.shifen0520.shjtcore.material.data.MaterialDataUse;
import com.shifen0520.shjtcore.material.form.MaterialFormRegistry;
import net.minecraft.resources.ResourceLocation;

import java.util.*;

public final class Material {
    private final ResourceLocation id;
    private final Map<MaterialDataType<?>, MaterialDataUse<?>> data;
    private final Set<ResourceLocation> formIds;   // ← 新方案用这个

    Material(ResourceLocation id,
             Map<MaterialDataType<?>, MaterialDataUse<?>> data,
             Set<ResourceLocation> formIds) {
        this.id = id;
        this.data = Map.copyOf(data);
        this.formIds = Set.copyOf(formIds);
    }

    public ResourceLocation id() { return id; }
    public Set<ResourceLocation> formIds() { return formIds; }

    @SuppressWarnings("unchecked")
    public <D> Optional<D> data(MaterialDataType<D> type) {
        MaterialDataUse<?> use = data.get(type);
        return use == null ? Optional.empty() : Optional.of((D) use.data());
    }

    public List<MaterialForm> forms() {
        return formIds.stream()
                .map(MaterialFormRegistry::get)
                .filter(Objects::nonNull)
                .toList();
    }
}
