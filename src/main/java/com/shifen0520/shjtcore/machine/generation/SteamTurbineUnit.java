package com.shifen0520.shjtcore.machine.generation;

import cn.howxu.mmcr.publicapi.Machines;
import cn.howxu.mmcr.publicapi.event.RegisterMachineDefinitionsEvent;
import cn.howxu.mmcr.publicapi.event.RegisterMachineRecipesEvent;
import cn.howxu.mmcr.publicapi.machine.MachineSpec;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

import static cn.howxu.mmcr.api.registration.ApiIds.id;

@EventBusSubscriber
public class SteamTurbineUnit {

    private static final ResourceLocation STEAM_TURBINE_UNIT = id("steam_turbine_unit");

    @SubscribeEvent
    public static void registerDefinitions(RegisterMachineDefinitionsEvent event) {
        if (!event.definitions().containsKey(SteamTurbineUnit.STEAM_TURBINE_UNIT)) {
            MachineSpec machine = Machines
                    .machine(STEAM_TURBINE_UNIT)
                    .recipePool(STEAM_TURBINE_UNIT)
                    .displayNameKey("machine.mmcr.steam_turbine_unit")
                    .appearance(a -> a.machineBasicBlock(ResourceLocation.fromNamespaceAndPath("minecraft", "iron_block")))
                    .build();
            event.registerMachine(machine);
        }
    }
}
