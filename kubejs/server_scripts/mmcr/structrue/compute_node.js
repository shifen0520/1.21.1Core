MMCREvents.server(event => {

    const api = event.getAPI()
    const structure = event.createStructure("shjtcore:compute_node")
    structure
        .pattern("XXXX", "XNAX", "XXXX")
        .pattern("XXXX", "A  A", "XXXX")
        .pattern("XXXX", "A  A", "XXXX")
        .pattern("XXXX", "XCAX", "XXXX")
        .set('X', api.block('minecraft:white_concrete'))
        // A 是通用接口位；N 单独留给网络接口，避免和网络接口混用导致扫描异常。
        .set('A', api.anyOf(
            api.anyOfEnergyInput(),
            api.dataStorage(),
            api.block('minecraft:red_terracotta')
        ))
        .set('N', api.networkInterface())
        .controller('C')
        .build()
})
