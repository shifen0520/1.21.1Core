MMCREvents.server(event => {

    const api = event.getAPI()
    const structure = event.createStructure("shjtcore:quantum_assembler")
    structure
        .pattern("XXXX", "XAUX", "XXXX")
        .pattern("XXXX", "A  A", "XXXX")
        .pattern("XXXX", "A  A", "XXXX")
        .pattern("XXXX", "XCAX", "XXXX")
        .set('X', api.block('minecraft:cyan_concrete'))
        // A 是通用接口位；U 单独留给升级总线，必须留一个放身份卡，
        // 否则 TechGate 和机器归属都读不到卡。
        .set('A', api.anyOf(
            api.anyOfEnergyInput(),
            api.anyOfItemInput(),
            api.anyOfItemOutput(),
            api.dataStorage(),
            api.block('minecraft:red_terracotta')
        ))
        .set('U', api.anyOfUpgradeBus())
        .controller('C')
        .build()
})
