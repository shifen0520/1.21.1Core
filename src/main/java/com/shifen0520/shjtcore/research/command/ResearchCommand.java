package com.shifen0520.shjtcore.research.command;

import cn.howxu.mmcr.api.machine.MachineRegistry;
import cn.howxu.mmcr.api.recipe.MachineRecipe;
import cn.howxu.mmcr.api.recipe.RecipeRegistry;
import cn.howxu.mmcr.api.recipe.requirement.EnergyRequirement;
import cn.howxu.mmcr.api.recipe.requirement.ItemRequirement;
import cn.howxu.mmcr.api.recipe.requirement.MachineRequirement;
import cn.howxu.mmcr.api.recipe.modifier.RecipeModifier;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.LongArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.shifen0520.shjtcore.research.ResearchIds;
import com.shifen0520.shjtcore.research.data.TechDefinition;
import com.shifen0520.shjtcore.research.data.TechRegistry;
import com.shifen0520.shjtcore.research.db.ResearchDatabase;
import com.shifen0520.shjtcore.research.ftb.FtbBridge;
import com.shifen0520.shjtcore.research.ftb.ResearchTaskBinder;
import com.shifen0520.shjtcore.research.owner.HardDiskItem;
import com.shifen0520.shjtcore.research.owner.IdentityCardItem;
import com.shifen0520.shjtcore.research.owner.ResearchTaskCardItem;
import com.shifen0520.shjtcore.research.service.ResearchService;
import com.shifen0520.shjtcore.research.team.ResearchSaveData;
import com.shifen0520.shjtcore.research.team.TeamResearchState;
import dev.ftb.mods.ftbquests.quest.BaseQuestFile;
import dev.ftb.mods.ftbquests.quest.task.CustomTask;
import dev.ftb.mods.ftbquests.quest.task.Task;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/** {@code /shjtresearch} 调试与配置命令。 */
public final class ResearchCommand {

    /**
     * 科技 id 的 Tab 补全。
     *
     * <p><b>为什么必须有</b>：科技 id 是 {@code shjtcore:basic_computing} 这种机器可读的名字，
     * 玩家既记不住也不想打。有了补全，敲 {@code /shjtresearch focus } 再按 Tab 就能从列表里挑，
     * 不用再去翻文档。补全项顺便带上中文名做悬停提示。
     */
    private static final SuggestionProvider<CommandSourceStack> TECH_SUGGESTIONS = (ctx, builder) -> {
        String typed = builder.getRemainingLowerCase();
        for (ResourceLocation id : ResearchService.techs().researchOrder()) {
            String full = id.toString().toLowerCase(Locale.ROOT);
            // 既接受完整 id（shjtcore:basic_computing），也接受只打后半段（basic）
            if (!full.startsWith(typed) && !id.getPath().toLowerCase(Locale.ROOT).contains(typed)) {
                continue;
            }
            TechDefinition def = ResearchService.techs().get(id);
            builder.suggest(id.toString(), def == null ? null : def.display());
        }
        return builder.buildFuture();
    };

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("shjtresearch")
                .then(Commands.literal("list")
                        .executes(ctx -> list(ctx.getSource())))
                .then(Commands.literal("focus")
                        .executes(ctx -> focus(ctx.getSource(), null))
                        .then(Commands.argument("tech", StringArgumentType.string())
                                .suggests(TECH_SUGGESTIONS)
                                .executes(ctx -> focus(ctx.getSource(),
                                        StringArgumentType.getString(ctx, "tech")))))
                // 不记科技 id 也能推进：直接切到下一个可研究的科技（等价于身份卡右键）
                .then(Commands.literal("next")
                        .executes(ctx -> nextTech(ctx.getSource())))
                .then(Commands.literal("bind")
                        .then(Commands.argument("tech", StringArgumentType.string())
                                .suggests(TECH_SUGGESTIONS)
                                .then(Commands.argument("taskId", LongArgumentType.longArg())
                                        .executes(ctx -> bind(ctx.getSource(),
                                                StringArgumentType.getString(ctx, "tech"),
                                                LongArgumentType.getLong(ctx, "taskId"))))))
                .then(Commands.literal("tasks")
                        .executes(ctx -> listTasks(ctx.getSource())))
                .then(Commands.literal("debug")
                        .executes(ctx -> debug(ctx.getSource())))
                // 手持硬盘写入数据库授权（等价于右键硬盘）
                .then(Commands.literal("write")
                        .executes(ctx -> writeDisk(ctx.getSource())))
                // 直接把某个科技授权进数据库，跳过 FTB 任务（调试 / 快速验证门禁用）
                .then(Commands.literal("grant")
                        .requires(src -> src.hasPermission(2))
                        .then(Commands.argument("tech", StringArgumentType.string())
                                .suggests(TECH_SUGGESTIONS)
                                .executes(ctx -> grant(ctx.getSource(),
                                        StringArgumentType.getString(ctx, "tech")))))
                // 列出数据库全部授权
                .then(Commands.literal("db")
                        .executes(ctx -> dumpDb(ctx.getSource())))
                // 强制按 FTB 真值回填授权数据库（硬盘刻出 0 项时先跑这个）
                .then(Commands.literal("sync")
                        .executes(ctx -> syncDb(ctx.getSource())))
                // 查 MMCR 配方池：机器"有原料但不加工"时先跑这个
                .then(Commands.literal("recipes")
                        .executes(ctx -> dumpRecipes(ctx.getSource())))
                .then(Commands.literal("reload")
                        .requires(src -> src.hasPermission(2))
                        .executes(ctx -> reload(ctx.getSource())))
        );
    }

    /** 手持硬盘 → 把数据库里本队伍的授权刻进硬盘。 */
    private static int writeDisk(CommandSourceStack source) {
        ServerPlayer player = source.getPlayer();
        if (player == null) {
            source.sendFailure(Component.translatable("command.shjtcore.research.player_only"));
            return 0;
        }
        ItemStack held = player.getMainHandItem();
        if (!HardDiskItem.isHardDisk(held)) {
            source.sendFailure(Component.translatable("command.shjtcore.research.not_disk"));
            return 0;
        }
        HardDiskItem.writeFromDatabase(held, player);
        return 1;
    }

    /** 直接授权，跳过研究流程；便于快速验证量子装配机的硬盘门禁。 */
    private static int grant(CommandSourceStack source, String techArg) {
        ResourceLocation tech = parseTech(techArg);
        if (ResearchService.techs().get(tech) == null) {
            source.sendFailure(Component.translatable("command.shjtcore.research.unknown_tech", tech.toString()));
            return 0;
        }
        ServerPlayer player = source.getPlayer();
        if (player == null) {
            source.sendFailure(Component.translatable("command.shjtcore.research.player_only"));
            return 0;
        }
        UUID ftbTeam = FtbBridge.teamIdOf(player);
        // 单人未组队时队伍即玩家自身（与 OwnerResolver / HardDiskItem 的回退保持一致）
        UUID teamId = ftbTeam != null ? ftbTeam : player.getUUID();
        ResearchDatabase.get(source.getServer()).authorize(teamId, tech);
        source.sendSuccess(() -> Component.translatable("command.shjtcore.research.granted",
                tech.toString(), teamId.toString()), false);
        return 1;
    }

    /** 强制按 FTB 真值回填授权数据库。硬盘刻出 0 项时先跑这个。 */
    private static int syncDb(CommandSourceStack source) {
        ServerPlayer player = source.getPlayer();
        if (player == null) {
            source.sendFailure(Component.translatable("command.shjtcore.research.player_only"));
            return 0;
        }
        UUID ftbTeam = FtbBridge.teamIdOf(player);
        UUID teamId = ftbTeam != null ? ftbTeam : player.getUUID();
        int count = ResearchService.syncAuthorizations(source.getServer(), teamId);
        ResearchDatabase db = ResearchDatabase.get(source.getServer());
        source.sendSuccess(() -> Component.translatable("command.shjtcore.research.synced",
                String.valueOf(count)), false);
        if (count == 0) {
            source.sendSuccess(() -> Component.translatable("command.shjtcore.research.sync_none"), false);
        }
        // 顺带把库内容打出来，省得玩家再敲一次 db
        db.all().forEach((t, set) -> {
            if (!t.equals(teamId)) {
                return;
            }
            List<String> names = new ArrayList<>();
            set.forEach(x -> names.add(x.toString()));
            source.sendSuccess(() -> Component.literal("  " + t + " -> ")
                    .append(copyable(String.join(", ", names), String.join(", ", names))), false);
        });
        return 1;
    }

    /** 打印数据库里"队伍 -> 已授权科技"，排查"为什么硬盘过不了门禁"。 */
    private static int dumpDb(CommandSourceStack source) {
        ResearchDatabase db = ResearchDatabase.get(source.getServer());
        if (db.all().isEmpty()) {
            source.sendSuccess(() -> Component.translatable("command.shjtcore.research.db_empty"), false);
            return 1;
        }
        source.sendSuccess(() -> Component.translatable("command.shjtcore.research.db_header"), false);
        db.all().forEach((teamId, set) -> {
            List<String> names = new ArrayList<>();
            set.forEach(t -> names.add(t.toString()));
            source.sendSuccess(() -> Component.literal("  " + teamId + " -> ")
                    .append(copyable(String.join(", ", names), String.join(", ", names))), false);
        });
        return 1;
    }

    /**
     * 打印 MMCR 配方池的真实内容，排查"有原料、有电、门禁也过了，机器就是不加工"。
     *
     * <p><b>为什么不能查原版 {@code ServerRecipeManager}</b>：MMCR 根本不用原版的配方加载器。
     * 它自己注册了一个 {@code ContextAwareReloadListener}
     * （{@code MachineRecipeDataReloadListener}），在数据重载时直接
     * {@code resourceManager.listResources("recipes", path -> path.endsWith(".json"))}，
     * 然后自己 {@code JsonParser} 读文件、比对 {@code type == "mmcr:machine_recipe"}，
     * 再塞进自己的四层注册表 {@code RecipeRegistry}（static / dataPack / kubeJS / client）。
     * 所以 {@code /recipe} 和 JEI 之外，<b>原版 API 一个 MMCR 配方都看不到</b>。
     *
     * <p>唯一能查的入口是 {@code RecipeRegistry.recipesForPool(池id)}，它返回的是
     * "合并四层 + 按池过滤"之后的最终结果——也就是机器实际会考虑的配方集合。
     *
     * <p>顺带把 {@code registeredRecipeCount()} 一起打出来：如果它是 0，说明
     * KubeJS 脚本压根没跑通（或者 JSON 解析失败被 MMCR 吞进了 errors 列表），
     * 这时候诊断全绿也白搭——机器没有配方可选，自然只能待机。
     */
    private static int dumpRecipes(CommandSourceStack source) {
        // 0) 先看机器本身在不在 MMCR 的注册表里。
        //    KubeJSRecipeSync.filterRecipesWithRegisteredPools 会用
        //    MachineRegistry.containsRecipePool(pool) 逐条过滤，池子没注册就整批丢弃，
        //    而它只在日志里 warn 一句 "Skipping KubeJS recipe {}: unknown recipe pool {}"，
        //    游戏内完全无声 —— 这是"配方不加载"最阴的一种。
        boolean poolKnown = MachineRegistry.containsRecipePool(ResearchIds.QUANTUM_ASSEMBLER);
        boolean machineKnown = MachineRegistry.getMachine(ResearchIds.QUANTUM_ASSEMBLER) != null;
        source.sendSuccess(() -> Component.literal("机器已注册："
                + (machineKnown ? "是" : "否 ← 这就是配方被丢弃的原因")
                + " | 配方池 " + ResearchIds.QUANTUM_ASSEMBLER + " 已注册："
                + (poolKnown ? "是" : "否 ← 这就是配方被丢弃的原因")), false);
        source.sendSuccess(() -> Component.literal("MMCR 已注册机器总数："
                + MachineRegistry.effectiveSnapshot().size()
                + " | 结构已装："
                + MachineRegistry.getAllCompiled().size()), false);

        // 1) 配方表本身
        source.sendSuccess(() -> Component.literal("MMCR 已注册配方总数："
                + RecipeRegistry.registeredRecipeCount()
                + "（reloadVersion=" + RecipeRegistry.reloadVersion() + "）"), false);

        // 分层看一下：KubeJS 层为空就说明脚本没产出配方
        int kube = RecipeRegistry.kubeJSSnapshot().size();
        int pack = RecipeRegistry.dataPackSnapshot().size();
        source.sendSuccess(() -> Component.literal("  分层：kubeJS=" + kube
                + " | dataPack=" + pack
                + " | static=" + RecipeRegistry.staticSnapshot().size()), false);

        List<MachineRecipe> pool = RecipeRegistry.recipesForPool(ResearchIds.QUANTUM_ASSEMBLER);
        if (pool.isEmpty()) {
            source.sendFailure(Component.literal("配方池 " + ResearchIds.QUANTUM_ASSEMBLER
                    + " 里没有任何配方！机器不可能加工。"));
            source.sendFailure(Component.literal("常见原因（按可能性排序）："));
            if (!poolKnown) {
                source.sendFailure(Component.literal("  ① 配方池没注册 —— MMCR 会静默丢弃整批配方，"
                        + "检查 GatedDemoMachine 的 recipePool(...) 声明和注册时序"));
            }
            if (kube == 0) {
                source.sendFailure(Component.literal("  ② KubeJS 层是空的 —— 看启动日志有没有 "
                        + "[KubeJS Server] 报错，脚本本身没跑起来"));
            } else if (poolKnown) {
                // 池注册了、KubeJS 层也有配方，偏偏池里是空的 —— 只剩一种可能：
                // 我们的配方在 KubeJS 解析阶段就被丢掉了。
                // 这时游戏内聊天框顶部会出现 "! KubeJS errors found [N]!!"，N 就是被丢的条数。
                source.sendFailure(Component.literal("  ③ 我们的配方在 KubeJS 解析阶段被丢弃 —— "
                        + "注意聊天框顶部的 \"! KubeJS errors found [N]!!\""));
                source.sendFailure(Component.literal("     N 正好等于配方条数时，说明每条都报错了。"
                        + "日志里搜 \"Error parsing recipe\" 直接看原因，例如："));
                source.sendFailure(Component.literal("     · Unknown output type: xxx"
                        + " —— outputs 数组里的 type 是 MMCR 的 OutputType 注册表（mmcr:item 等），"
                        + "和 requirement 的类型注册表不是同一套；"
                        + "最省事的写法是照抄官方示例"
                        + "（kubejs/server_scripts/mmcr/recipes/miniature_electric_furnace.js）："
                        + "唯一正确写法是把产物写进 requirements、用 io:'output' 标记，"
                        + "即 requirements: [ ...输入..., "
                        + "{type:'minecraft:item', io:'output', stack:{id:'...', count:N}} ]"));
                source.sendFailure(Component.literal("     · RecipeJsonException"
                        + " —— JSON 字段被 MMCR schema 拒收（合法键：recipe_pool / tick_time /"
                        + " modifiers / requirements / max_threads / parallelized /"
                        + " cancelIfPerTickFails / allow_partial_outputs）"));
            }
            source.sendFailure(Component.literal("  ④ 其它 —— 用命令 /shjtresearch recipes "
                    + "已排除配方池和 KubeJS 层，请直接看 logs/latest.log 搜 "
                    + "\"Error parsing recipe\" 或 \"RecipeJsonException\""));
            return 0;
        }

        source.sendSuccess(() -> Component.literal("配方池 " + ResearchIds.QUANTUM_ASSEMBLER
                + " 共 " + pool.size() + " 条："), false);
        for (MachineRecipe r : pool) {
            // 配方头信息也走 safely：MachineRecipe 的 hostIds 同样可能是 null
            source.sendSuccess(() -> Component.literal("  " + safely(r.id())
                    + " | tick=" + r.tickTime()
                    + " | priority=" + r.priority()
                    + " | parallel=" + r.isParallelized()
                    + " | hosts=" + nullSafe(r.requiredHostIds()).size()), false);
            // 逐条包 try-catch：诊断工具自己崩掉比"少打一行"糟糕得多。
            // MMCR 的 ItemRequirement 有多个可空字段（ingredient/stack/tags/components），
            // 任何一条畸形数据都不该让整份配方列表打不出来。
            //
            // 只读 runtimeRequirements()，不读 machineOutputs()：
            // 产物写在 requirements 里用 io:'output' 标记是 MMCR 唯一正确的写法
            // （见 kubejs/server_scripts/mmcr/recipes/miniature_electric_furnace.js 官方示例）。
            // machineOutputs() 是 MMCR 从 requirements 反推出来的派生视图，
            // 在这条路径下它跟 requirements 里的 OUTPUT 条目信息重复，
            // 两边都打只会让人怀疑"为什么同一个产物出现两次、还带不同数量"。
            for (MachineRequirement req : nullSafe(r.runtimeRequirements())) {
                source.sendSuccess(() -> Component.literal("      " + describeRequirement(req)), false);
            }
        }
        return 1;
    }

    /** 包一层异常保护，把任意对象的 toString 压成一行文本，出错也不外抛。 */
    private static String safely(Object value) {
        try {
            return String.valueOf(value);
        } catch (Throwable t) {
            return "<读取失败: " + t.getClass().getSimpleName()
                    + (t.getMessage() == null ? "" : ": " + t.getMessage()) + ">";
        }
    }

    /** 取列表，为 null 时返回空列表而不是抛 NPE。 */
    private static <T> List<T> nullSafe(List<T> list) {
        return list == null ? List.of() : list;
    }

    /** 取集合，为 null 时返回空集合而不是抛 NPE。 */
    private static <T> java.util.Set<T> nullSafe(java.util.Set<T> set) {
        return set == null ? java.util.Set.of() : set;
    }

    /**
     * 把一条 requirement 压成一行可读文本，方便直接和 KubeJS 里的 JSON 对照。
     *
     * <p><b>方向前缀</b>由 {@link ItemRequirement#io()} 决定：{@code ←} 是投入，
     * {@code →} 是产出。这样一眼就能对上 KubeJS 里的 {@code io:'input'/'output'}，
     * 不用去数第几行。
     *
     * <p><b>坑 1：{@code resolvedStack()} 对普通 item ingredient 返回空</b>。
     * 它只对"由产物反推出来的 requirement"有效；JSON 里手写的
     * {@code item:{item:"minecraft:diamond"}} 走的是 {@code ingredient()}，
     * 直接 {@code String.valueOf(ingredient())} 会打印成 {@code Ingredient@256fffd7}
     * 这种对象哈希，完全看不出是哪个物品。所以这里统一走
     * {@code ingredient().getItems()} 展开。
     *
     * <p><b>坑 2：输出项的 {@code count()} 恒为 0</b>。产物数量在
     * {@code ItemOutput.stack().getCount()}，{@code count()} 是 requirement 侧的字段，
     * 对 {@code io:OUTPUT} 条目没有意义。直接打 count 会得到
     * {@code item OUTPUT minecraft:beacon x0} 这种看着像"产物是 0 个"的假象。
     */
    private static String describeRequirement(MachineRequirement req) {
        try {
            return describeRequirementUnsafe(req);
        } catch (Throwable t) {
            return "<描述失败: " + t.getClass().getSimpleName()
                    + (t.getMessage() == null ? "" : ": " + t.getMessage()) + ">";
        }
    }

    private static String describeRequirementUnsafe(MachineRequirement req) {
        if (req instanceof ItemRequirement item) {
            // stack()/ingredient() 都可能是 null，交给 describeIngredient 判空，
            // 这里只负责把"数量"取对位置。
            long amount = item.count();
            ItemStack stack = item.stack();
            boolean output = item.io() == RecipeModifier.IOType.OUTPUT;
            if (output && stack != null) {
                amount = stack.getCount(); // 产物数量在 stack 里，count() 恒为 0
            }
            return (output ? "→ " : "← ")
                    + describeIngredient(item) + " x" + amount;
        }
        if (req instanceof EnergyRequirement energy) {
            // 注意是 fePerTick()，不是 amount() —— 这条需求本身就是"每 tick 多少 FE"
            return (energy.io() == RecipeModifier.IOType.OUTPUT ? "→ " : "← ")
                    + energy.fePerTick() + " FE/t";
        }
        return req.getClass().getSimpleName() + " " + safely(req);
    }

    /**
     * 把 Ingredient 展开成物品 id 列表。
     *
     * <p><b>坑 3：{@code ingredient()} 可能是 null</b>。它只在 requirement 真正
     * 带 Ingredient 时才非空；{@code io:OUTPUT} 的条目是把 {@code MachineOutput}
     * 反推回来的，ingredient 为 null，只能从 {@code stack()} 读物品。
     * 之前没判空直接 {@code ingredient().getItems()}，命令一跑到输出项就抛
     * {@code Cannot invoke "Ingredient.getItems()" because ... is null}，
     * 整条配方列表打印到一半断掉——诊断工具自己崩掉比不诊断还糟。
     *
     * <p>所以顺序是：先试 stack（对输出项和单一物品都有效），
     * stack 为空再退到 ingredient().getItems()（处理 tag 匹配项）。
     */
    private static String describeIngredient(ItemRequirement item) {
        // 输出项 / 已解析的条目：stack() 最可靠
        ItemStack direct = item.stack();
        if (!direct.isEmpty()) {
            return BuiltInRegistries.ITEM.getKey(direct.getItem()).toString();
        }
        // 原料项：stack() 可能是空壳，真值在 ingredient 里
        Ingredient ingredient = item.ingredient();
        if (ingredient == null) {
            return "(无物品)";
        }
        ItemStack[] candidates = ingredient.getItems();
        if (candidates == null || candidates.length == 0) {
            return "(空:" + ingredient.getClass().getSimpleName() + ")";
        }
        StringBuilder sb = new StringBuilder();
        int shown = Math.min(candidates.length, 3);
        for (int i = 0; i < shown; i++) {
            if (i > 0) {
                sb.append('/');
            }
            sb.append(BuiltInRegistries.ITEM.getKey(candidates[i].getItem()));
        }
        if (candidates.length > shown) {
            sb.append(" +").append(candidates.length - shown).append(" more");
        }
        return sb.toString();
    }

    private static int list(CommandSourceStack source) {
        TechRegistry registry = ResearchService.techs();
        if (registry.size() == 0) {
            source.sendFailure(Component.translatable("command.shjtcore.research.no_tech"));
            return 0;
        }
        source.sendSuccess(() -> Component.translatable("command.shjtcore.research.list_header"), false);
        ResearchSaveData saveData = ResearchSaveData.get(source.getServer());

        // 玩家执行时顺带把"本存档"的解锁状态打出来。研究进度本来就按存档独立存，
        // 但只看 task= 那一列看不出进度，换存档时没法一眼确认有没有串数据。
        UUID teamId = null;
        if (source.getEntity() instanceof ServerPlayer viewer) {
            teamId = FtbBridge.teamIdOf(viewer);
        }
        final UUID viewerTeam = teamId;

        long unlockedCount = 0L;
        for (ResourceLocation id : registry.researchOrder()) {
            TechDefinition def = registry.get(id);
            if (def == null) {
                continue;
            }
            // 显示"生效值"：/shjtresearch bind 的覆写优先 → quest_task_title → quest_task
            long taskId = ResearchTaskBinder.effectiveTaskId(id, def, saveData);
            boolean overridden = saveData.taskOverride(id) != null;
            boolean unlocked = viewerTeam != null
                    && ResearchService.isUnlocked(source.getServer(), viewerTeam, id);
            if (unlocked) {
                unlockedCount++;
            }
            source.sendSuccess(() -> Component.literal("  " + id + " | cost=" + def.computingCost() + " | task=")
                    .append(copyable(String.valueOf(taskId), String.valueOf(taskId)))
                    .append(Component.literal(overridden ? " (手动覆写)" : bindSource(def)))
                    .append(Component.literal(" | requires=" + def.requires().size()))
                    .append(def.hasDuration()
                            ? Component.literal(" | " + def.durationText().getString())
                            : Component.empty())
                    .append(viewerTeam == null ? Component.empty()
                            : unlocked ? Component.literal(" | 已解锁")
                            : blockedReason(source.getServer(), viewerTeam, id)), false);
        }
        if (viewerTeam != null) {
            final long done = unlockedCount;
            source.sendSuccess(() -> Component.literal("本存档已完成 " + done + " / " + registry.size()
                    + " 条科技（队伍 " + viewerTeam + "）。换存档后这里应当从 0 开始。"), false);
        }
        source.sendSuccess(() -> Component.literal("提示：改完 FTB 任务书或科技 JSON 会自动重绑，"
                + "也可手动执行 /shjtresearch reload"), false);
        return 1;
    }

    /** 标注这条科技的绑定来自哪里，方便一眼看出绑定是否正常。 */
    private static String bindSource(TechDefinition def) {
        if (def.hasTitle()) {
            return " (手动指定标题: " + def.questTaskTitle() + ")";
        }
        if (def.questTaskId() >= 0) {
            return " (手动指定裸id，id 会随任务增删漂移，建议改用 quest_task_title)";
        }
        return " (未绑定，需在 FTB 编辑器里建 Custom 任务后写 quest_task_title 或 /shjtresearch bind)";
    }

    /**
     * 未解锁的原因。<b>只列直接前置</b>而不是整个传递闭包——
     * 闭包会把"根节点的祖先"都算进来，玩家看到一堆不相干的科技名会更困惑。
     *
     * <p>而且这里<b>必须</b>用直接前置重新算一遍，不能复用闭包：闭包虽然能得出
     * "缺哪条"，但玩家真正需要的是"我下一步该去研究哪条"，那一定是直接前置。
     */
    private static Component blockedReason(MinecraftServer server, UUID teamId, ResourceLocation tech) {
        TechDefinition def = ResearchService.techs().get(tech);
        if (def == null) {
            return Component.literal(" | 未知科技");
        }
        List<ResourceLocation> missingDirect = new ArrayList<>();
        for (ResourceLocation req : def.requires()) {
            if (!ResearchService.isUnlocked(server, teamId, req)) {
                missingDirect.add(req);
            }
        }
        if (!missingDirect.isEmpty()) {
            return Component.literal(" | 未解锁 · 需前置 " + formatTechList(missingDirect));
        }
        // 直接前置都齐了但仍未解锁 → 自己的 FTB 任务没完成
        return Component.literal(" | 未解锁 · 本科技待完成");
    }

    private static int focus(CommandSourceStack source, String techArg) {
        ServerPlayer player = source.getPlayer();
        if (player == null) {
            source.sendFailure(Component.translatable("command.shjtcore.research.player_only"));
            return 0;
        }
        UUID teamId = FtbBridge.teamIdOf(player);
        if (teamId == null) {
            source.sendFailure(Component.translatable("command.shjtcore.research.no_team"));
            return 0;
        }
        ResearchSaveData data = ResearchSaveData.get(source.getServer());
        TeamResearchState state = data.team(teamId);

        // 卡上的焦点是 OwnerResolver 的优先数据源，所以主手拿着卡时一并写进卡里，
        // 否则"往卡上写焦点"这条路径没有任何入口。
        ItemStack held = player.getMainHandItem();
        boolean wroteCard = held.getItem() instanceof IdentityCardItem;

        if (techArg == null || techArg.isBlank()) {
            state.setFocus(null);
            if (wroteCard) {
                IdentityCardItem.setTech(held, null);
            }
            data.setDirty();
            source.sendSuccess(() -> Component.translatable(wroteCard
                    ? "command.shjtcore.research.focus_auto_card"
                    : "command.shjtcore.research.focus_auto"), false);
            return 1;
        }
        ResourceLocation tech = parseTech(techArg);
        if (ResearchService.techs().get(tech) == null) {
            source.sendFailure(Component.translatable("command.shjtcore.research.unknown_tech", tech.toString()));
            return 0;
        }
        // 前置没解锁就明确拒绝：setFocus 本身只是记一个值，玩家（尤其命令补全选错了）
        // 会以为已经开始了，但机器那边 researchable 判否 → 一动不动，非常难排查。
        // 这里主动报错并列出缺哪几条前置。
        List<ResourceLocation> missing = ResearchService.missingPrerequisites(source.getServer(), teamId, tech);
        if (!missing.isEmpty()) {
            source.sendFailure(Component.translatable("command.shjtcore.research.focus_prereq_missing",
                    formatTechList(missing)));
            return 0;
        }
        state.setFocus(tech);
        // 任务卡是新的正规载体：拿着任务卡时焦点写卡上，插到别的机器也能用
        if (held.getItem() instanceof ResearchTaskCardItem) {
            ResearchTaskCardItem.setTech(held, tech);
        } else if (wroteCard) {
            IdentityCardItem.setTech(held, tech);
        }
        data.setDirty();
        source.sendSuccess(() -> Component.translatable(wroteCard
                ? "command.shjtcore.research.focus_set_card"
                : "command.shjtcore.research.focus_set", tech.toString()), false);
        return 1;
    }

    /** 把科技 id 列表翻成中文名，空格分隔（报错时列缺失前置用）。 */
    private static String formatTechList(List<ResourceLocation> ids) {
        StringBuilder sb = new StringBuilder();
        for (ResourceLocation id : ids) {
            if (sb.length() > 0) {
                sb.append('、');
            }
            TechDefinition def = ResearchService.techs().get(id);
            sb.append(def == null ? id.toString() : def.display().getString());
        }
        return sb.toString();
    }

    /**
     * 切到下一个可研究的科技——给"不想记 id、也不想拿身份卡"的场合用。
     *
     * <p>和身份卡右键共用 {@link ResearchService#cycleTarget}，所以跳过的规则完全一致：
     * 已解锁的和前置没做完的都会被跳过。落地仍然走 {@link #focus}，
     * 这样主手拿着卡时同样会把目标写进卡里。
     */
    private static int nextTech(CommandSourceStack source) {
        ServerPlayer player = source.getPlayer();
        if (player == null) {
            source.sendFailure(Component.translatable("command.shjtcore.research.player_only"));
            return 0;
        }
        UUID teamId = FtbBridge.teamIdOf(player);
        if (teamId == null) {
            source.sendFailure(Component.translatable("command.shjtcore.research.no_team"));
            return 0;
        }
        ResearchSaveData data = ResearchSaveData.get(source.getServer());
        ResourceLocation current = data.team(teamId).focus();
        ResourceLocation next = ResearchService.cycleTarget(source.getServer(), teamId, current, true);
        if (next == null) {
            if (ResearchService.remainingTechs(source.getServer(), teamId) == 0L) {
                source.sendSuccess(() -> Component.translatable("message.shjtcore.research.card_all_done"), false);
            } else {
                source.sendFailure(Component.translatable("message.shjtcore.research.card_no_target"));
            }
            return 0;
        }
        return focus(source, next.toString());
    }

    /** 科技 id 允许省略命名空间：{@code basic_computing} → {@code shjtcore:basic_computing}。 */
    private static ResourceLocation parseTech(String arg) {
        String s = arg.trim();
        return ResearchIds.parse(s.indexOf(':') < 0 ? "shjtcore:" + s : s);
    }

    /** 把科技绑到任务书里的 CustomTask，优先级高于 datapack JSON。 */
    private static int bind(CommandSourceStack source, String techArg, long taskId) {
        ResourceLocation tech = parseTech(techArg);
        TechDefinition def = ResearchService.techs().get(tech);
        if (def == null) {
            source.sendFailure(Component.translatable("command.shjtcore.research.unknown_tech", tech.toString()));
            return 0;
        }
        ResearchSaveData data = ResearchSaveData.get(source.getServer());
        data.setTaskOverride(tech, taskId);
        if (FtbBridge.configure(taskId, def.computingCost())) {
            source.sendSuccess(() -> Component.translatable("command.shjtcore.research.bound",
                    tech.toString(), taskId), false);
            return 1;
        }
        source.sendFailure(Component.translatable("command.shjtcore.research.bind_failed", taskId));
        return 0;
    }

    /**
     * 列出任务书里所有 CustomTask 的 id 和标题，方便把 id 填进 /shjtresearch bind。
     * 只有 CustomTask 能被本模组写进度，其它类型列出来也没意义。
     */
    private static int listTasks(CommandSourceStack source) {
        BaseQuestFile file = FtbBridge.file();
        if (file == null) {
            source.sendFailure(Component.literal("任务书尚未加载（ServerQuestFile == null）"));
            return 0;
        }
        List<CustomTask> customs = new ArrayList<>();
        for (Task t : file.getAllTasks()) {
            if (t instanceof CustomTask custom) {
                customs.add(custom);
            }
        }
        if (customs.isEmpty()) {
            source.sendFailure(Component.literal("任务书里没有任何 Custom（自定义）任务。"
                    + "请在 FTB 编辑器里给科技各建一个 Custom 任务后再来绑定。"));
            return 0;
        }
        source.sendSuccess(() -> Component.literal(
                "任务书里的 Custom 任务（标题即任务格里那个名字，复制它填进 JSON 的 quest_task_title）："), false);
        for (CustomTask t : customs) {
            // 用 taskTitle 而不是 rawTitle：① FTB 编辑器建的标题只存在 lang/<客户端语言>.snbt 里，
            // 服务端按 fallback_locale 读到的是空串；② 玩家改的是 Quest 的标题，不是任务自己的
            String title = FtbBridge.taskTitle(t);
            source.sendSuccess(() -> Component.literal("  任务id=")
                    .append(copyable(String.valueOf(t.id), String.valueOf(t.id)))
                    .append(Component.literal("  标题=")
                            .append(copyable(title.isEmpty() ? "(无标题)" : title, title))), false);
        }
        source.sendSuccess(() -> Component.literal("小技巧：在 FTB 编辑器里把任务格的标题起成固定名字，"
                + "JSON 写 quest_task_title 就能免掉每次手工对 id"), false);
        return 1;
    }

    private static int debug(CommandSourceStack source) {
        List<String> lines = ResearchService.debugLines(source.getServer());
        for (String line : lines) {
            source.sendSuccess(() -> Component.literal(line), false);
        }
        return 1;
    }

    /** 任务书被 /ftbquests reset 或 reload 后调用：清掉解锁缓存，重新绑定任务上限。 */
    private static int reload(CommandSourceStack source) {
        ResearchService.invalidate(source.getServer());
        ResearchTaskBinder.bindAll(source.getServer(), ResearchService.techs(),
                ResearchSaveData.get(source.getServer()));
        source.sendSuccess(() -> Component.translatable("command.shjtcore.research.reloaded"), false);
        return 1;
    }

    /** 让一段文本可点击复制到剪贴板，悬停提示"点击复制"。 */
    private static Component copyable(String label, String value) {
        return Component.literal(label).withStyle(Style.EMPTY
                .withClickEvent(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, value))
                .withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                        Component.literal("点击复制"))));
    }

    private ResearchCommand() {
    }
}
