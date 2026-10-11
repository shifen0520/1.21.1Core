MMCREvents.server(event => {

    const api = event.getAPI()
    const structure = event.createStructure("shjtcore:compute_router")
    structure
        // 顶层：两个网络接口位。I = 接算力节点（入口），O = 接科研中心（出口）。
        // 必须写在同一层、同一行，且宽度与其他层一致：MMCR 要求
        // 「所有层等宽 + 等高」，宽度或行数不一致会直接抛
        // IllegalArgumentException: All pattern slices must have the same width。
        .pattern("XXXX", "XIOX", "XXXX")
        .pattern("XXXX", "A  A", "XXXX")
        .pattern("XXXX", "A  A", "XXXX")
        // 底层：控制器。至少留一个 A 位接能源，路由器转发要吃电。
        .pattern("XXXX", "XCAX", "XXXX")
        .set('X', api.block('minecraft:gray_concrete'))
        // 通用接口位：能量输入 + 数据存储 + 留空
        .set('A', api.anyOf(
            api.anyOfEnergyInput(),
            api.dataStorage(),
            api.block('minecraft:red_terracotta')
        ))
        // I 和 O 必须用**不同字符**。MMCR 扫描网络接口时会把
        // "可能是网络接口"的位置排除出其他功能的识别范围，
        // 两个接口混在同一个 anyOf 里会被当成同一个槽位处理。
        .set('I', api.networkInterface())
        .set('O', api.networkInterface())
        .controller('C')
        .build()
})
