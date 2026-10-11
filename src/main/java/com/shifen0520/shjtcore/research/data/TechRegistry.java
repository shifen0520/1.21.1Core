package com.shifen0520.shjtcore.research.data;

import net.minecraft.resources.ResourceLocation;

import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 科技表。datapack 重载时整体替换。
 *
 * <p>提供三样东西：按 id 查定义、拓扑排序后的研究顺序、以及"机器 → 需要哪些科技"的反查索引。
 */
public final class TechRegistry {

    private final Map<ResourceLocation, TechDefinition> byId;
    /** 拓扑排序后的研究顺序（同权重按 order 稳定排序）。 */
    private final List<ResourceLocation> researchOrder;
    /** 机器 id → 解锁它所需的科技（可能多个，需全部解锁）。 */
    private final Map<ResourceLocation, List<ResourceLocation>> techsByMachine;

    private TechRegistry(Map<ResourceLocation, TechDefinition> byId,
                         List<ResourceLocation> researchOrder,
                         Map<ResourceLocation, List<ResourceLocation>> techsByMachine) {
        this.byId = byId;
        this.researchOrder = researchOrder;
        this.techsByMachine = techsByMachine;
    }

    /** 从一批定义构建；会剔除依赖缺失与存在环的科技。 */
    public static TechRegistry of(List<TechDefinition> definitions) {
        Map<ResourceLocation, TechDefinition> byId = new HashMap<>();
        for (TechDefinition def : definitions) {
            byId.put(def.id(), def);
        }

        // 丢弃指向不存在科技的前置，避免拓扑排序时 NPE
        Map<ResourceLocation, List<ResourceLocation>> edges = new HashMap<>();
        for (TechDefinition def : byId.values()) {
            List<ResourceLocation> reqs = new ArrayList<>();
            for (ResourceLocation r : def.requires()) {
                if (byId.containsKey(r) && !r.equals(def.id())) {
                    reqs.add(r);
                }
            }
            edges.put(def.id(), reqs);
        }

        List<ResourceLocation> order = topoSort(byId, edges);
        Map<ResourceLocation, List<ResourceLocation>> byMachine = new HashMap<>();
        for (ResourceLocation id : order) {
            for (ResourceLocation machine : byId.get(id).machines()) {
                byMachine.computeIfAbsent(machine, unused -> new ArrayList<>()).add(id);
            }
        }
        return new TechRegistry(byId, order, byMachine);
    }

    public static TechRegistry empty() {
        return new TechRegistry(Map.of(), List.of(), Map.of());
    }

    @Nullable
    public TechDefinition get(ResourceLocation id) {
        return byId.get(id);
    }

    public List<ResourceLocation> researchOrder() {
        return researchOrder;
    }

    public List<ResourceLocation> techsForMachine(ResourceLocation machineId) {
        return techsByMachine.getOrDefault(machineId, List.of());
    }

    /** 前置传递闭包（含自身）。用于判定"这个科技现在能不能研究"。 */
    public Set<ResourceLocation> closureOf(ResourceLocation id) {
        Set<ResourceLocation> out = new LinkedHashSet<>();
        collect(id, out, new HashSet<>());
        return out;
    }

    private void collect(ResourceLocation id, Set<ResourceLocation> out, Set<ResourceLocation> visiting) {
        if (!out.add(id) || !visiting.add(id)) {
            return;
        }
        TechDefinition def = byId.get(id);
        if (def == null) {
            visiting.remove(id);
            return;
        }
        for (ResourceLocation r : def.requires()) {
            if (byId.containsKey(r)) {
                collect(r, out, visiting);
            }
        }
        visiting.remove(id);
    }

    /** Kahn 拓扑排序；同权重按 order 字段再按 id 字符串稳定排序。 */
    private static List<ResourceLocation> topoSort(Map<ResourceLocation, TechDefinition> byId,
                                                   Map<ResourceLocation, List<ResourceLocation>> edges) {
        Map<ResourceLocation, Integer> indegree = new HashMap<>();
        Map<ResourceLocation, List<ResourceLocation>> dependents = new HashMap<>();
        for (ResourceLocation id : byId.keySet()) {
            indegree.put(id, 0);
        }
        for (Map.Entry<ResourceLocation, List<ResourceLocation>> e : edges.entrySet()) {
            for (ResourceLocation r : e.getValue()) {
                indegree.merge(e.getKey(), 1, Integer::sum);
                dependents.computeIfAbsent(r, unused -> new ArrayList<>()).add(e.getKey());
            }
        }

        List<ResourceLocation> ready = new ArrayList<>(byId.keySet());
        ready.removeIf(id -> indegree.get(id) > 0);
        sortByOrder(ready, byId);

        List<ResourceLocation> result = new ArrayList<>();
        while (!ready.isEmpty()) {
            ResourceLocation id = ready.remove(0);
            result.add(id);
            for (ResourceLocation next : dependents.getOrDefault(id, List.of())) {
                int left = indegree.merge(next, -1, Integer::sum);
                if (left == 0) {
                    ready.add(next);
                    sortByOrder(ready, byId);
                }
            }
        }
        // 有环时 result 会少一部分；剩下的科技被静默跳过（加载时已打日志）
        return result;
    }

    private static void sortByOrder(List<ResourceLocation> list, Map<ResourceLocation, TechDefinition> byId) {
        list.sort((a, b) -> {
            TechDefinition da = byId.get(a);
            TechDefinition db = byId.get(b);
            int oa = da == null ? Integer.MAX_VALUE : da.order();
            int ob = db == null ? Integer.MAX_VALUE : db.order();
            if (oa != ob) {
                return Integer.compare(oa, ob);
            }
            return a.toString().compareTo(b.toString());
        });
    }

    public int size() {
        return byId.size();
    }
}
