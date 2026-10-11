package com.shifen0520.shjtcore.research.data;

import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 限时增益表。datapack 重载时整体替换。 */
public final class BoostRegistry {

    private final Map<ResourceLocation, BoostDefinition> byId;
    private final List<BoostDefinition> all;

    private BoostRegistry(Map<ResourceLocation, BoostDefinition> byId) {
        this.byId = byId;
        this.all = Collections.unmodifiableList(new ArrayList<>(byId.values()));
    }

    public static BoostRegistry of(List<BoostDefinition> definitions) {
        Map<ResourceLocation, BoostDefinition> map = new HashMap<>();
        for (BoostDefinition def : definitions) {
            map.put(def.id(), def);
        }
        return new BoostRegistry(map);
    }

    public static BoostRegistry empty() {
        return new BoostRegistry(Map.of());
    }

    public List<BoostDefinition> all() {
        return all;
    }

    public BoostDefinition get(ResourceLocation id) {
        return byId.get(id);
    }
}
