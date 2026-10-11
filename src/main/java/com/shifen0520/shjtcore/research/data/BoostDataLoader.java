package com.shifen0520.shjtcore.research.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.logging.LogUtils;
import com.shifen0520.shjtcore.research.ResearchIds;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 加载 {@code data/<ns>/research/boost/*.json}（限时算力增益）。
 *
 * <p>因为算力是流量模型，"加算力"只能表达成一段限时增益。
 */
public final class BoostDataLoader extends SimpleJsonResourceReloadListener {

    private static final Logger LOGGER = LogUtils.getLogger();
    private static final Gson GSON = new GsonBuilder().create();

    private volatile BoostRegistry registry = BoostRegistry.empty();

    public BoostDataLoader() {
        super(GSON, ResearchIds.DIR_BOOST);
    }

    public BoostRegistry registry() {
        return registry;
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> contents, ResourceManager manager, ProfilerFiller profiler) {
        List<BoostDefinition> defs = new ArrayList<>();
        for (Map.Entry<ResourceLocation, JsonElement> entry : contents.entrySet()) {
            ResourceLocation id = entry.getKey();
            if (!entry.getValue().isJsonObject()) {
                continue;
            }
            JsonObject obj = entry.getValue().getAsJsonObject();
            try {
                defs.add(new BoostDefinition(
                        id,
                        TechJson.display(obj),
                        TechJson.longValue(obj, "quest_task", -1L),
                        TechJson.doubleValue(obj, "rate", 0.0),
                        TechJson.longValue(obj, "duration_ticks", 1200L),
                        TechJson.boolValue(obj, "stackable", false),
                        TechJson.intValue(obj, "max_stacks", 1)
                ));
            } catch (Exception e) {
                LOGGER.error("[research] 解析增益定义 {} 失败，已跳过", id, e);
            }
        }
        registry = BoostRegistry.of(defs);
        LOGGER.info("[research] 已加载 {} 条增益定义", defs.size());
    }
}
