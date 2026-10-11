MMCREvents.server(event => {

    const api = event.getAPI()
    const structure = event.createStructure("shjtcore:research_center")
    structure
        .pattern("XXXX", "XNUX", "XXXX")
        .pattern("XXXX", "A  A", "XXXX")
        .pattern("XXXX", "A  A", "XXXX")
        .pattern("XXXX", "XCAX", "XXXX")
        .set('X', api.block('minecraft:black_concrete'))
        .set('A', api.anyOf(
            api.anyOfEnergyInput(),
            api.dataStorage(),
            api.block('minecraft:red_terracotta')
        ))
        // 网络接口与升级总线必须分字符：MMCR 在扫描升级总线时会排除
        // "可能是网络接口"的位置。若混在同一个 anyOf 里，升级总线永远
        // 不会被识别，身份卡也就读不到。
        .set('N', api.networkInterface())
        .set('U', api.anyOfUpgradeBus())
        .controller('C')
        .build()
})
