MMCREvents.server(event => {

    const api = event.getAPI()
    const structure = event.createStructure("mmcr:miniature_electric_furnace")
    structure
        .pattern("XXX", "XXX", "XXX")
        .pattern("XXX", "XAX", "XXX")
        .pattern("XXX", "XCX", "XXX")
        .set('X', api.anyOf(api.block('minecraft:iron_block'),
                            api.anyOfItemOutput(),
                            api.anyOfEnergyInput(),
                            api.anyOfItemInput(),
                            api.parallelControllers()))
        .set('A', api.block('minecraft:redstone_block'))
        .controller('C')
        .build() 
})