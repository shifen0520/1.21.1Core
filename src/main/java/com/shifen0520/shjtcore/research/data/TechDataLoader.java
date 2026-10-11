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
 * 加载 {@code data/<ns>/research/tech/*.json}。
 *
 * <p>id 由文件路径决定，与标准 datapack 一致：{@code data/shjtcore/research/tech/quantum_theory.json}
 * → {@code shjtcore:quantum_theory}。
 */
public final class TechDataLoader extends SimpleJsonResourceReloadListener {

    private static final Logger LOGGER = LogUtils.getLogger();
    private static final Gson GSON = new GsonBuilder().create();

    private volatile TechRegistry registry = TechRegistry.empty();

    public TechDataLoader() {
        super(GSON, ResearchIds.DIR_TECH);
    }

    public TechRegistry registry() {
        return registry;
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> contents, ResourceManager manager, ProfilerFiller profiler) {
        List<TechDefinition> defs = new ArrayList<>();
        for (Map.Entry<ResourceLocation, JsonElement> entry : contents.entrySet()) {
            ResourceLocation id = entry.getKey();
            if (!entry.getValue().isJsonObject()) {
                LOGGER.warn("[research] 科技定义 {} 不是 JSON 对象，已跳过", id);
                continue;
            }
            JsonObject obj = entry.getValue().getAsJsonObject();
            try {
                List<ResourceLocation> requires = new ArrayList<>();
                JsonElement reqEl = obj.get("requires");
                if (reqEl != null && reqEl.isJsonArray()) {
                    for (JsonElement e : reqEl.getAsJsonArray()) {
                        requires.add(ResearchIds.parse(e.getAsString()));
                    }
                }
                List<ResourceLocation> machines = new ArrayList<>();
                JsonElement machEl = obj.get("machines");
                if (machEl != null && machEl.isJsonArray()) {
                    for (JsonElement e : machEl.getAsJsonArray()) {
                        machines.add(ResearchIds.parse(e.getAsString()));
                    }
                }
                JsonElement titleEl = obj.get("quest_task_title");
                String title = null;
                if (titleEl != null && titleEl.isJsonPrimitive()) {
                    title = titleEl.getAsString();
                    if (title.isBlank()) {
                        title = null;
                    }
                }

                defs.add(new TechDefinition(
                        id,
                        TechJson.display(obj),
                        TechJson.longValue(obj, "computing_cost", 1000L),
                        sanitizeDuration(id, TechJson.longValue(obj, "duration_ticks", 0L)),
                        requires,
                        machines,
                        TechJson.intValue(obj, "order", 100),
                        sanitizeRateScale(id, TechJson.doubleValue(obj, "rate_scale", 1.0)),
                        TechJson.longValue(obj, "quest_task", -1L),
                        title
                ));
            } catch (Exception e) {
                LOGGER.error("[research] 解析科技定义 {} 失败，已跳过", id, e);
            }
        }

        TechRegistry built = TechRegistry.of(defs);
        // 有环 / 前置缺失的科技会被拓扑排序丢掉，这里提示一下
        if (built.researchOrder().size() != defs.size()) {
            LOGGER.warn("[research] 科技图存在环或前置缺失：定义了 {} 条，成功排序 {} 条，"
                            + "未排序的科技不会被自动推进研究", defs.size(), built.researchOrder().size());
        }
        registry = built;
        LOGGER.info("[research] 已加载 {} 条科技定义", built.size());
    }

    /** rate_scale 的合法上限。超过它等于"一个 tick 研究完"，不可能是设计意图。 */
    private static final double MAX_RATE_SCALE = 1000.0;

    /**
     * 校验研究效率倍率，异常值回落 1.0。
     *
     * <p><b>为什么必须有这道检查</b>：{@code rate_scale} 是 JSON 里的裸数字，
     * 多打几位就会静默改变玩法。实测把 {@code 1.0} 写成 {@code 2496785979869918672}
     * 之后，算力乘上这个倍率直接把进度灌满、所有科技"瞬间研究完成"，
     * 而日志里一个字都没有——玩家只会以为研究系统坏了或者进度串存档了。
     * 这里把非有限值 / 非正值 / 离谱大值统一按 1.0 处理并留一条日志。
     */
    private static double sanitizeRateScale(ResourceLocation id, double value) {
        if (!Double.isFinite(value) || value <= 0.0 || value > MAX_RATE_SCALE) {
            LOGGER.warn("[research] 科技 {} 的 rate_scale={} 不在 (0, {}] 内，已按 1.0 处理",
                    id, value, MAX_RATE_SCALE);
            return 1.0;
        }
        return value;
    }

    /** 最短耗时的上限：超过一整天多半是写错了单位（比如本想写分钟写成了 tick）。 */
    private static final long MAX_DURATION_TICKS = 1_728_000L;

    /**
     * 校验最短耗时，负数按"不限制"处理。
     *
     * <p>允许负数是有意的：{@code duration_ticks} 不写等价于"这条科技纯按算力算，
     * 堆节点就瞬间完成"。想让某个高科技保持"必须研究一段时间"的仪式感时才写它。
     */
    private static long sanitizeDuration(ResourceLocation id, long value) {
        if (value <= 0L) {
            return 0L;
        }
        if (value > MAX_DURATION_TICKS) {
            LOGGER.warn("[research] 科技 {} 的 duration_ticks={} 超过一天（{}），已按不限制处理。"
                    + "注意单位是 tick，1 分钟 = 1200 tick", id, value, MAX_DURATION_TICKS);
            return 0L;
        }
        return value;
    }
}
