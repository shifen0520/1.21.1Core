MMCREvents.server(event => {

    const api = event.getAPI()
    const structure = event.createStructure("mmcr:large_bronze_boiler")
    structure
        .pattern("XXX", "XXX", "XXX", "XXX")
        .pattern("XXX", "X X", "X X", "XXX")
        .pattern("XXX", "XCX", "XXX", "XXX")
        .set('X', api.anyOf(api.block('minecraft:waxed_copper_block'),
                            api.anyOfItemOutput(),
                            api.anyOfFluidInput(),
                            api.anyOfFluidOutput(),
                            api.anyOfItemInput()))
        .controller('C')
        .build()
})