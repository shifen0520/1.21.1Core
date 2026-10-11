// 量子装配机（shjtcore:quantum_assembler）配方。
//
// 科研门禁在 Java 侧：机器定义见
// src/main/java/com/shifen0520/shjtcore/research/mmcr/GatedDemoMachine.java，
// 未研究 shjtcore:quantum_theory 时会在配方启动前取消（TechGate）。
// 结构见 kubejs/server_scripts/mmcr/structrue/quantum_assembler.js。
//
// ── MMCR 配方的唯一正确写法 ──────────────────────────────────────────
//
// 一切以 MMCR 自带的官方示例为准：
//     kubejs/server_scripts/mmcr/recipes/miniature_electric_furnace.js
//
// 输入和产物**都写在 requirements 里**，靠 io 字段区分方向：
//
//     requirements: [
//         { type:'minecraft:item',    io:'input',  item:  { item:'minecraft:diamond' }, count:1 },
//         { type:'neoforge:energy',   id:'input',   fe_per_tick:4000 },
//         { type:'minecraft:item',    io:'output', stack: { id:'minecraft:beacon' },   count:1 }
//     ]
//
// ⛔ 不要用独立的 outputs 数组。
//    outputs 走 MMCR 的 OutputType 注册表（mmcr:item / mmcr:fluid ...），
//    requirements 走 RequirementType 注册表（minecraft:item / neoforge:energy ...），
//    是两套独立的 type 命名空间。在 outputs 里写 type:'minecraft:item' 会报
//        Unknown output type: minecraft:item
//    整条配方被 KubeJS 静默丢弃——机器表现为"有原料、有电、门禁也过了，就是不加工"，
//    而游戏内除了聊天框顶部的 "! KubeJS errors found [N]!!" 之外没有任何提示。
//
// ⛔ 字段名必须严格对齐 MMCR 的 KubeJS schema（MachineRecipeSchema），写错的键
//    不会报"未知字段"，而是整条配方被丢，痕迹只有日志里的 RecipeJsonException。
//    合法键：recipe_pool / tick_time / modifiers / requirements / max_threads
//           / parallelized / cancelIfPerTickFails / allow_partial_outputs
//
// ✅ 写完务必用 /shjtresearch recipes 确认配方真的进了 RecipeRegistry，
//    且输出项显示为 "→ <物品> x<数量>"（← 是投入）。
//
// ── 能耗注意 ────────────────────────────────────────────────────────
// fe_per_tick 是「每 tick」不是总量。第一道 4000 FE/t，第二道 12000 FE/t，
// 荒诞（ludicrous）能量仓 transfer 上限 256000 FE/t，两者都够。

ServerEvents.recipes(event => {
    // 第一道：钻石 + 红石 → 信标（beacon）
    event.custom({
        type: 'mmcr:machine_recipe',
        recipe_pool: 'shjtcore:quantum_assembler',
        tick_time: 200,
        requirements: [
            { type: 'minecraft:item', io: 'input', item: { item: 'minecraft:diamond' }, count: 1 },
            { type: 'minecraft:item', io: 'input', item: { item: 'minecraft:redstone' }, count: 8 },
            { type: 'neoforge:energy', id: 'input', fe_per_tick: 4000 },
            { type: 'minecraft:item', io: 'output', stack: { id: 'minecraft:beacon', count: 1 } }
        ]
    }).id('shjtcore:quantum_core')

    // 第二道：下界残骸 + 金锭 → 下界合金锭（netherite_ingot）
    event.custom({
        type: 'mmcr:machine_recipe',
        recipe_pool: 'shjtcore:quantum_assembler',
        tick_time: 400,
        requirements: [
            { type: 'minecraft:item', io: 'input', item: { item: 'minecraft:netherite_scrap' }, count: 4 },
            { type: 'minecraft:item', io: 'input', item: { item: 'minecraft:gold_ingot' }, count: 4 },
            { type: 'neoforge:energy', id: 'input', fe_per_tick: 12000 },
            { type: 'minecraft:item', io: 'output', stack: { id: 'minecraft:netherite_ingot', count: 1 } }
        ]
    }).id('shjtcore:matrix_unit')
})