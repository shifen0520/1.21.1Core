package com.shifen0520.shjtcore.research.mmcr;

import cn.howxu.mmcr.api.recipe.RecipeRegistry;
import cn.howxu.mmcr.publicapi.Machines;
import cn.howxu.mmcr.publicapi.behavior.MachineContext;
import cn.howxu.mmcr.publicapi.event.RegisterMachineDefinitionsEvent;
import cn.howxu.mmcr.publicapi.machine.MachineSpec;
import cn.howxu.mmcr.publicapi.presentation.TextScope;
import cn.howxu.mmcr.publicapi.runtime.IoSnapshot;
import com.shifen0520.shjtcore.research.ResearchIds;
import com.shifen0520.shjtcore.research.gate.TechGate;
import com.shifen0520.shjtcore.research.owner.HardDiskItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

/**
 * 受科技门禁控制的量子装配机。
 *
 * <p>门禁落点只有一个：{@code recipeBehavior.beforeStart} 里 {@code ctx.cancel()}。
 *
 * <p><b>不要再加直驱 tick（曾经踩过的坑）</b>：本类早期版本同时挂了
 * {@code tickBehavior.serverTick}，每 tick 用 {@code IoPlan} 扣 64 FE 显示"运行中：0/1"。
 * 这个 tick 有三个致命问题：
 * <ol>
 *     <li><b>抢能量</b>：它和配方共用同一份能量。MMCR 的
 *         {@code RecipeEnergyPrefetchFacet} 在启动配方前会预抽并保留能量，
 *         直驱 tick 同时也在抽，配方就永远拿不满 {@code fe_per_tick}（本配方 4000 FE/t）
 *         而静默不启动——表现为"有原料、有电、就是不加工"。</li>
 *     <li><b>误导</b>：它显示的"运行中：1"只代表这 64 FE 扣上了，跟配方有没有在加工毫无关系，
 *         排查问题时会被带偏。</li>
 *     <li><b>直接关掉配方</b>：{@code tickBehavior} 会把机器切成"纯 tick 机器"，
 *         配方加工被彻底关闭。这条最致命且最难察觉，详见下面的"行为模式"说明。</li>
 * </ol>
 * 所以这里只保留 {@code beforeStart} 门禁，能量完全交给配方自己的
 * {@code neoforge:energy} 需求支配。
 *
 * <p>诊断信息改用 {@code controller(...)} 这个<b>纯只读</b>钩子渲染：它只读升级总线和数据库，
 * 不做任何 IO 计划、不耗一焦耳，所以既能告诉你"为什么没跑"，又不会反过来把配方饿死。
 *
 * <p>结构（KubeJS 定义，见 {@code kubejs/server_scripts/mmcr/structrue/quantum_assembler.js}）里必须留
 * 升级总线槽位（{@code api.anyOfUpgradeBus()}），否则读不到硬盘，机器会被拦下。
 * {@code allowModifiers(false)} 是为了防止硬盘被 MMCR 当成升级品消耗掉。
 *
 * <p><b>当前门禁判据</b>：{@link TechGate#allowWithDisk} —— 读升级总线里的
 * {@link com.shifen0520.shjtcore.research.owner.HardDiskItem}，再和授权数据库交叉校验。
 * 不查 FTB、不查身份卡，所以链路上只有"硬盘 + 数据库"两环，最短最稳。
 * 旧的 {@link TechGate#allow}（身份卡 + FTB 队伍 + ResearchService）保留在门禁类里，
 * 需要切回旧链路时改这一处调用即可。
 *
 * <p><b>注册方式</b>：机器定义由 {@code BuItiInProvider} 统一调用（ServiceLoader），本类<b>不挂</b>
 * {@code @EventBusSubscriber}。结构已迁到KubeJS 定义。
 *
 * <p><b>行为模式：只能有 recipeBehavior，不能再有 tickBehavior</b>（这是本类最贵的一个坑）。
 * {@code recipeBehavior} 和 {@code tickBehavior} <b>不是叠加关系，是互斥的模式选择</b>——
 * 文档原文「后一次模式配置可替换前一次」。所以只要在 {@code recipeBehavior(...)} 之后
 * 再调一次 {@code tickBehavior(...)}，整台机器就被切成"纯 tick 机器"，配方加工被<b>彻底关闭</b>。
 *<p>MMCR 内部的判据是 {@code MachineControllerBlockEntity.hasTickBehavior(StructureSnapshot)}：
 * <pre>
 *   formed() &amp;&amp; structureAreaLoaded()
 *       &amp;&amp; (machine() != null ? machine() : configuredMachine()).behavior() instanceof TickBehavior
 * </pre>
 * 一旦命中，{@code hasActiveOperation()} 直接返回 false，
 * {@code tryStartNewRecipe()} 永远不会被调用——<b>连一次都不会试</b>。
 *<p>症状极具误导性：配方池已注册、候选配方 2 条、能量充足、原料齐全、
 * 输出也放得下（{@code ioView()} 这些全是真实查询，不骗人），
 * 但机器永远 IDLE，而且 {@code lastFailure} 为 null、{@code recipeSearchAttemptCounter} 为 0。
 * 也就是说<b>没有任何失败记录</b>，因为它压根没走到"尝试"这一步。
 * <p>本类原先把诊断挂在 {@code tickBehavior(hooks -> hooks.serverTick(...))} 上，
 * 结果诊断 tick 把配方模式顶掉了。现在改用 {@code postServerTick}：
 * 它是<b>顶层 pre/post tick 钩子</b>，文档明确「顶层 pre/post tick 钩子只适用于配方模式」，
 * 正是配方模式下做周期性只读诊断的正确落点。
 * <p>要保留门禁就保留 {@code beforeStart}；要周期诊断就用 {@code postServerTick}。
 * <b>永远不要为了加诊断而调用 {@code tickBehavior}。</b>
 */
public final class GatedDemoMachine {

    /**
     * 诊断用的能量下限：取第一道配方（quantum_core）的 4000 FE/t。
     * 只用于"提示玩家能量够不够"，<b>不</b>参与任何实际 IO 计划。
     */
    private static final long REQUIRED_FE_PER_TICK = 4000L;

    /**
     * 机器定义。由 {@code MachineDefinitionProvider} 调用，<b>不要</b>加 {@code @SubscribeEvent}。
     */
    public static void registerDefinitions(RegisterMachineDefinitionsEvent event) {
        if (event.definitions().containsKey(ResearchIds.QUANTUM_ASSEMBLER)) {
            return;
        }
        MachineSpec machine = Machines.machine(ResearchIds.QUANTUM_ASSEMBLER)
                .recipePool(ResearchIds.QUANTUM_ASSEMBLER)
                .displayNameKey("machine.shjtcore.quantum_assembler")
                .appearance(a -> a.machineBasicBlock(ResearchIds.mc("cyan_concrete")))
                .allowModifiers(false)
                // 门禁：配方启动前校验硬盘 + 授权数据库
                .recipeBehavior(hooks -> hooks.beforeStart(ctx -> {
                    if (!TechGate.allowWithDisk(ctx.machineContext(), ResearchIds.TECH_QUANTUM_THEORY)) {
                        ctx.cancel();
                    }
                }))
                // 诊断 tick：只读升级总线 + 数据库写状态文本，不建 IoPlan、不耗能量
                .postServerTick(GatedDemoMachine::describeGate)
                .build();
        event.registerMachine(machine);
    }

    /**
     * 把"门禁为什么没放行"写进控制器屏幕。
     *
     * <p><b>纯只读，零能耗</b>：只读升级总线和授权数据库，<b>不</b>创建 {@code IoPlan}、
     * <b>不</b>调 {@code Requirements.energy}。这与早期版本每 tick 扣 64 FE 的写法有本质区别——
     * 那版会和配方抢能量导致配方永远启动不了。
     *
     * <p>存在的意义：门禁拦下时 MMCR 不给任何默认提示，玩家只看到"有原料但不加工"，
     * 无从判断是缺硬盘、没刻盘、还是科技没研究。这里把失败原因逐一显式写出来。
     */
    private static void describeGate(MachineContext machine) {
        machine.screenText().append(TextScope.OPERATION, ResearchIds.LINE_GATE, gateStatus(machine));

        // 门禁过了才查运行条件，避免把两种失败混在一起看
        if (TechGate.allowWithDisk(machine, ResearchIds.TECH_QUANTUM_THEORY)) {
            describeRuntime(machine);
        }

        // 最后一行：MMCR 自己的判据。这行是权威答案——上面所有"够/不够"都是我们
        // 重算的推测，只有这里读的是 MMCR 内部真实的加工状态和失败原因。
        machine.screenText().append(TextScope.OPERATION, ResearchIds.LINE_RUNTIME,
                Component.literal(MmcrRuntimeProbe.describe(machine)));
    }

    /** 门禁三态：无盘 / 未刻盘 / 通过 / 未授权。 */
    private static Component gateStatus(MachineContext machine) {
        ItemStack disk = null;
        for (ItemStack stack : machine.upgradeItems()) {
            if (!stack.isEmpty() && HardDiskItem.isHardDisk(stack)) {
                disk = stack;
                break;
            }
        }
        if (disk == null) {
            return Component.translatable("message.shjtcore.research.gate.no_disk");
        }
        if (!HardDiskItem.isWritten(disk)) {
            return Component.translatable("message.shjtcore.research.gate.disk_not_written");
        }
        if (TechGate.allowWithDisk(machine, ResearchIds.TECH_QUANTUM_THEORY)) {
            return Component.translatable("message.shjtcore.research.gate.disk_ok");
        }
        return Component.translatable("message.shjtcore.research.gate.disk_no_auth",
                ResearchIds.TECH_QUANTUM_THEORY.toString());
    }

    /**
     * 逐条报出配方跑不起来的具体原因。全部走 {@link IoSnapshot} 的只读查询，
     * 不消耗任何资源，纯粹给人看。
     *
     * <p>每一项都对应 MMCR 自己的失败原因（{@code gui.mmcr.controller.failure.*}）：
     * {@code missing_energy} / {@code missing_input} / {@code missing_output}。
     * 之前玩家只能看到"有原料但不运行"，就是因为这些原因默认只显示在 Jade 悬浮层。
     */
    private static void describeRuntime(MachineContext machine) {
        IoSnapshot io = machine.ioView();
        if (io == null) {
            return;
        }

        // 0) 配方池。MMCR 会在 KubeJS 同步时用
        //    MachineRegistry.containsRecipePool(pool) 过滤配方，池子没注册就整批丢弃，
        //    日志里只有一行 warn，游戏内完全无声。所以这一条必须排在最前面：
        //    池里没配方时，下面那些"能量够、原料够、输出够"全是绿的，也没有意义。
        int recipeCount = RecipeRegistry.recipesForPool(ResearchIds.QUANTUM_ASSEMBLER).size();
        machine.screenText().append(TextScope.OPERATION, ResearchIds.LINE_RECIPE,
                Component.translatable(recipeCount > 0
                                ? "message.shjtcore.research.diag.recipe_ok"
                                : "message.shjtcore.research.diag.recipe_none",
                        String.valueOf(recipeCount)));

        // 1) 能量：注意 energyInput() 返回的是**可提供的总量上限**（能量仓容量），
        // 不是每 tick 速率，所以数值很大是正常的，这里只判断"有没有能量可用"。
        long energy = io.energyInput();
        machine.screenText().append(TextScope.OPERATION, ResearchIds.LINE_ENERGY,
                Component.translatable(energy >= REQUIRED_FE_PER_TICK
                                ? "message.shjtcore.research.diag.energy_ok"
                                : "message.shjtcore.research.diag.energy_low",
                        String.valueOf(energy), String.valueOf(REQUIRED_FE_PER_TICK)));

        // 2) 原料：把第一道配方所需物品逐一报出持有量。
        //    <b>slot</b> 用来区分行 id —— 之前两行都用 LINE_STOCK，
        //    后一行直接覆盖前一行，钻石那行就凭空消失了（诊断工具骗人比没诊断更糟）。
        reportItem(machine, io, ResearchIds.mc("diamond"), 1, 0);
        reportItem(machine, io, ResearchIds.mc("redstone"), 8, 1);

        // 3) 输出：产物送不出去就永远无法完成。
        // 用 itemOutputCapacity(待放入的产物) 查询——比翻 displays() 的本地化 label 可靠得多
        // （label 是中文，搜 "output" 永远搜不到；早先就是这么误报的）。
        ItemStack product = new ItemStack(Items.BEACON);
        long outRoom = io.itemOutputCapacity(product);
        machine.screenText().append(TextScope.OPERATION, ResearchIds.LINE_OUTPUT,
                Component.translatable(outRoom > 0
                                ? "message.shjtcore.research.diag.output_ok"
                                : "message.shjtcore.research.diag.no_output",
                        String.valueOf(outRoom)));
    }

    /**
     * 报单个物品的可用量 vs 需求量。
     *
     * <p>用 {@code ioView().itemAmount(Ingredient)} 精确查询——这是 MMCR 自己算配方匹配时用的
     * 同一个入口，所以报出来的数字和"机器实际认为够不够"必然一致。
     *
     * <p><b>历史坑（已修）</b>：早期手写遍历 {@code io.itemInputs()}，用
     * {@code entry.resource().getCount()} 拿数量。但 {@code ResourceAmount} 是 record
     * {@code (resource, amount)}，{@code resource()} 只是"代表物品"（每种只 1 个），
     * 真正的数量在 {@code amount()}。结果输入总线里明明有 64 个红石，却报"只有 1"。
     */
    private static void reportItem(MachineContext machine, IoSnapshot io, ResourceLocation item, long need, int slot) {
        Item target = BuiltInRegistries.ITEM.get(item);
        if (target == null || target == Items.AIR) {
            return; // 物品 id 写错了，跳过以免刷屏
        }
        Ingredient ingredient = Ingredient.of(target);
        long have = io.itemAmount(ingredient);
        machine.screenText().append(TextScope.OPERATION, ResearchIds.lineStock(slot),
                Component.translatable(have >= need
                                ? "message.shjtcore.research.diag.item_ok"
                                : "message.shjtcore.research.diag.item_low",
                        item.toString(), String.valueOf(have), String.valueOf(need)));
    }

    private GatedDemoMachine() {
    }
}
