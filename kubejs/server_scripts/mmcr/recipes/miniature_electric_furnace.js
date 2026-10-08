ServerEvents.recipes(event => {
    const smeltingRecipes = event.findRecipes({type: 'minecraft:smelting' })

    smeltingRecipes.forEach(recipe => {
        event.custom({
            type: 'mmcr:machine_recipe',
            recipe_pool: 'mmcr:miniature_electric_furnace',
            tick_time: Math.floor(recipe.get('cookingtime').intTicks() / 2),
            parallelized: true,
            requirements:[
                {
                    type:'minecraft:item',
                    io:'input',
                    item:recipe.get('ingredient'),
                    count:1
                },
                {
                    type: 'neoforge:energy',
                    id: 'input',
                    fe_per_tick: 20
                },
                {
                    type:'minecraft:item',
                    io:'output',
                    stack: recipe.get('result')
                }
              ]      
            }).id(`mmcr_kubejs:alloy_furnace/from_smelting/${recipe.path}`)
    })
})