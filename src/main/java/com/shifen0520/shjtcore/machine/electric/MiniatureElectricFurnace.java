package com.shifen0520.shjtcore.machine.electric;

import cn.howxu.mmcr.publicapi.Machines;
import cn.howxu.mmcr.publicapi.event.RegisterMachineDefinitionsEvent;
import cn.howxu.mmcr.publicapi.machine.MachineSpec;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

import static cn.howxu.mmcr.api.registration.ApiIds.id;

@EventBusSubscriber
public class MiniatureElectricFurnace {
    private static final ResourceLocation ELECTRIC_FURNACE = id("miniature_electric_furnace");

    @SubscribeEvent
    public static void registerDefinitions(RegisterMachineDefinitionsEvent event) {
        if(!event.definitions().containsKey(ELECTRIC_FURNACE)) {
            MachineSpec machine = Machines
                    .machine(ELECTRIC_FURNACE)
                    .recipePool(ELECTRIC_FURNACE)
                    .displayNameKey("machine,mmcr,miniature_electric_furnace")
                    .appearance(a -> a.machineBasicBlock("minecraft:iron_block"))
                    .maxParallelism(16)
                    .parallelizable(true)
                    .build();
            event.registerMachine(machine);
        }
    }

    private MiniatureElectricFurnace() {}
}
