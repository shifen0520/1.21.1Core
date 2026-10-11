package com.shifen0520.shjtcore.research.ftb;

import com.mojang.logging.LogUtils;
import com.shifen0520.shjtcore.research.data.TechDefinition;
import com.shifen0520.shjtcore.research.data.TechRegistry;
import com.shifen0520.shjtcore.research.team.ResearchSaveData;
import dev.ftb.mods.ftbquests.quest.task.CustomTask;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;

/**
 * 把科技绑定到 FTB 任务书里的 CustomTask。
 *
 * <p><b>绑定优先级</b>（从高到低）：
 * <ol>
 *     <li>{@code /shjtresearch bind} 的存档内覆写（{@link ResearchSaveData#taskOverride}）</li>
 *     <li>datapack JSON 的 {@code quest_task_title}（<b>手写任务时用</b>）</li>
 *     <li>datapack JSON 的 {@code quest_task}（数字 id，兼容保留）</li>
 * </ol>
 *
 * <p><b>没标上面两项的科技就是未绑定</b>：任务书里的 Custom 任务要由玩家在
 * FTB 编辑器里自己建（或用 {@code /shjtresearch bind} 临时绑），本类只负责
 * 把算力上限配一遍（{@code setMaxProgress} 是运行时设置，不会写进任务书文件，
 * 每次启动都要重配）。
 *
 * <p><b>为什么优先用标题而不是 id</b>：FTB Quests 的任务 id 按创建顺序自动分配。
 * 在编辑器里删掉一个中间任务、或者调整章节顺序，后面所有任务的 id 都会整体错位。
 * 硬编码数字 id 错绑之后<b>不会报错</b>——任务照样能点、能研究，只是推进到了别的科技上，
 * 这种错误极难发现。标题是稳定的语义标识，增删排序任务都不用改 JSON。
 *
 * <p><b>改完怎么生效</b>：改科技 JSON → {@code /reload} → {@code /shjtresearch reload}。
 * 不想手动敲命令可以直接重启服务器，效果相同；{@link FtbQuestAutoBinder} 也会
 * 在检测到文件改动后自动重绑。
 */
public final class ResearchTaskBinder {

    private static final Logger LOGGER = LogUtils.getLogger();

    /**
     * 把每条科技解析到的 CustomTask 配一遍算力上限。
     *
     * <p><b>失败绝不抛异常</b>：任务书没加载、科技没绑任务都是正常状态（玩家可能
     * 还没装 FTB Quests），只记日志。抛异常会导致整条科技注册链断掉。
     *
     * @return 成功绑定的科技数量
     */
    public static int bindAll(MinecraftServer server, TechRegistry registry, ResearchSaveData saveData) {
        int bound = 0;
        List<ResourceLocation> unbound = new ArrayList<>();
        for (ResourceLocation techId : registry.researchOrder()) {
            TechDefinition def = registry.get(techId);
            if (def == null) {
                continue;
            }
            CustomTask task = resolve(techId, def, saveData);
            if (task == null) {
                unbound.add(techId);
                continue;
            }
            if (FtbBridge.configure(task, def.computingCost())) {
                bound++;
            }
        }
        LOGGER.info("[research] 已绑定 {}/{} 个科研任务", bound, registry.size());
        if (!unbound.isEmpty()) {
            LOGGER.warn("[research] 以下 {} 条科技没有可用任务，暂时不可研究：{}", unbound.size(), unbound);
            LOGGER.warn("[research]   排查顺序：① 任务书是否加载 ② 科技 JSON 有没有写 quest_task_title"
                    + " ③ 在 FTB 编辑器里是不是改过标题或删过任务"
                    + " ④ 用 /shjtresearch tasks 看现有 Custom 任务的标题，或 /shjtresearch bind 直接绑 id");
            // 把任务书里实际存在的 Custom 任务直接列出来，省得再逐条敲命令
            List<String> available = FtbBridge.customTaskSummaries();
            LOGGER.warn("[research]   任务书里现有 {} 个 Custom 任务：{}",
                    available.size(), available.isEmpty() ? "(一个都没有)" : String.join(" | ", available));
        }
        return bound;
    }

    /**
     * 找出这条科技该绑哪个任务：覆写 → 标题 → 数字 id。
     *
     * @return 匹配到的 CustomTask；一条都没配上返回 {@code null}（该科技不可研究）
     */
    public static CustomTask resolve(ResourceLocation techId, TechDefinition def, ResearchSaveData saveData) {
        Long override = saveData.taskOverride(techId);
        if (override != null) {
            // 手动 bind 的优先级最高，即使 JSON 里也配了
            return FtbBridge.task(override);
        }
        if (def.hasTitle()) {
            CustomTask byTitle = FtbBridge.taskByTitle(def.questTaskTitle());
            if (byTitle != null) {
                return byTitle;
            }
            // 标题找不到是有价值的信号：可能任务书没加载，也可能是标题打错了。
            LOGGER.warn("[research] 科技 {} 按标题 \"{}\" 没找到 FTB 任务。"
                    + "请用 /shjtresearch tasks 查看现有 Custom 任务的 id 和标题", techId, def.questTaskTitle());
            return null;
        }
        if (def.questTaskId() >= 0) {
            return FtbBridge.task(def.questTaskId());
        }
        return null;
    }

    /**
     * 取这条科技生效的任务 id，供诊断命令显示。
     *
     * <p>覆写优先，其次是按标题解析出来的真实 id，最后才是 JSON 里的裸 id。
     * 返回负数表示未绑定。
     */
    public static long effectiveTaskId(ResourceLocation techId, TechDefinition def, ResearchSaveData saveData) {
        Long override = saveData.taskOverride(techId);
        if (override != null) {
            return override;
        }
        CustomTask task = resolve(techId, def, saveData);
        return task == null ? -1L : task.id;
    }

    private ResearchTaskBinder() {
    }
}