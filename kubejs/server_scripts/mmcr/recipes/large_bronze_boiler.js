ServerEvents.recipes(event => {
    const fire = (time, input1, id1) => {
        event.custom({
            type: 'mmcr:machine_recipe',
            recipe_pool: 'mmcr_kubejs:large_bronze_boiler',
            tick_time: time,
            requirements: [
                {
                    type: 'minecraft:item',
                    io: 'input',
                    item: { item:input1 },
                    count: 1
                }
            ]
        }).id('mmcr_kubejs:fire_' + id1)}
        
    fire(30, 'minecraft:oak_planks', 'oak_1')
    fire(160, 'minecraft:coal', 'coal_1')
})