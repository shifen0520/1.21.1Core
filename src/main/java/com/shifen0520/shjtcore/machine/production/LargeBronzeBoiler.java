package com.shifen0520.shjtcore.machine.production;

import cn.howxu.mmcr.publicapi.Machines;
import cn.howxu.mmcr.publicapi.behavior.TickContext;
import cn.howxu.mmcr.publicapi.data.DataKey;
import cn.howxu.mmcr.publicapi.data.DataStore;
import cn.howxu.mmcr.publicapi.event.RegisterMachineDefinitionsEvent;
import cn.howxu.mmcr.publicapi.machine.MachineSpec;
import cn.howxu.mmcr.publicapi.presentation.TextScope;
import cn.howxu.mmcr.publicapi.recipe.IoValues;
import cn.howxu.mmcr.publicapi.recipe.requirement.Requirements;
import cn.howxu.mmcr.publicapi.runtime.IoTransaction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.fluids.FluidStack;

import static cn.howxu.mmcr.publicapi.ApiIds.id;

@EventBusSubscriber
public class LargeBronzeBoiler {

    private static final ResourceLocation LARGE_BRONZE_BOILER = id("large_bronze_boiler");

    private static final String TEMPERATURE = "temperature";
    private static final String STEAM_BUFFER = "steam_buffer";
    private static final String FUEL_BURN_TIME = "fuel_burn_time";

    private static final ResourceLocation BOILER_TEMP = id("boiler_temp");
    private static final ResourceLocation BOILER_FUEL = id("boiler_fuel");
    private static final ResourceLocation BOILER_STEAM = id("boiler_steam");
    private static final ResourceLocation BOILER_STATUS = id("boiler_status");

    private static final double MAX_TEMPERATURE = 500.0;
    private static final double HEAT_RATE = 0.05;
    private static final double COOL_RATE = 0.03;

    private static final int WATER_PER_TICK = 20;
    private static final int STEAM_PER_TICK = 100;
    private static final int MAX_STEAM_BUFFER = 10000;

    private static final int FUEL_BURN_TICKS = 200;

    private static final Ingredient FUEL = Ingredient.of(Items.COAL, Items.CHARCOAL);

    @SubscribeEvent
    public static void registerDefinitions(RegisterMachineDefinitionsEvent event) {
        if (!event.definitions().containsKey(LARGE_BRONZE_BOILER)) {
            MachineSpec machine = Machines
                    .machine(LARGE_BRONZE_BOILER)
                    .recipePool(LARGE_BRONZE_BOILER)
                    .displayNameKey("machine.mmcr.large_bronze_boiler")
                    .appearance(a -> a.machineBasicBlock(ResourceLocation.fromNamespaceAndPath("minecraft", "copper_block")))
                    .tickBehavior(behavior -> behavior.serverTick((TickContext context) -> {
                        DataStore storage = context.dataStorage();
                        if (storage == null) return;

                        double temperature = storage.get(TEMPERATURE).flatMap(DataKey::asDouble).orElse(0.0);
                        double steamBuffer = storage.get(STEAM_BUFFER).flatMap(DataKey::asDouble).orElse(0.0);
                        int burnTime = storage.get(FUEL_BURN_TIME).flatMap(DataKey::asInt).orElse(0);

                        IoTransaction waterPlan = context.ioPlan()
                                .addInput(Requirements.fluidInput(Fluids.WATER, WATER_PER_TICK));
                        boolean hasWater = waterPlan.simulate().inputsSatisfied();

                        if (!hasWater && temperature > 100.0) {
                            var level = context.level();
                            var pos = context.controllerPos();
                            level.explode(null, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                                    4.0F, false, Level.ExplosionInteraction.BLOCK);
                            return;
                        }

                        boolean consumingFuel = false;
                        if (burnTime > 0) {
                            burnTime--;
                            consumingFuel = true;
                        } else {
                            IoTransaction fuelPlan = context.ioPlan()
                                    .addInput(Requirements.itemInput(IoValues.itemInput(FUEL, 1)));
                            if (fuelPlan.simulate().inputsSatisfied() && fuelPlan.commit().successful()) {
                                burnTime = FUEL_BURN_TICKS;
                                consumingFuel = true;
                            }
                        }

                        if (consumingFuel && hasWater) {
                            temperature = Math.min(temperature + HEAT_RATE, MAX_TEMPERATURE);
                        } else {
                            temperature = Math.max(temperature - COOL_RATE, 0.0);
                        }

                        boolean running = temperature > 100.0 && hasWater && consumingFuel;

                        if (running) {
                            IoTransaction boilPlan = context.ioPlan()
                                    .addInput(Requirements.fluidInput(Fluids.WATER, WATER_PER_TICK));
                            if (boilPlan.simulate().inputsSatisfied() && boilPlan.commit().successful()) {
                                steamBuffer = Math.min(steamBuffer + STEAM_PER_TICK, MAX_STEAM_BUFFER);
                            }
                        }

                        Fluid steam = BuiltInRegistries.FLUID
                                .getOptional(ResourceLocation.parse("mekanism:steam"))
                                .orElse(Fluids.EMPTY);
                        if (steamBuffer > 0 && steam != Fluids.EMPTY) {
                            int toOutput = (int) Math.min(steamBuffer, STEAM_PER_TICK);
                            IoTransaction steamOut = context.ioPlan()
                                    .add(Requirements.fluidOutput(new FluidStack(steam, toOutput)));
                            var outSim = steamOut.simulate();
                            if (outSim.failure() == null) {
                                boolean outputOk = true;
                                for (var out : outSim.outputs()) {
                                    if (out.accepted() < out.requested()) {
                                        outputOk = false;
                                        break;
                                    }
                                }
                                if (outputOk && steamOut.commit().successful()) {
                                    steamBuffer -= toOutput;
                                }
                            }
                        }

                        storage.set(TEMPERATURE, DataKey.of(temperature));
                        storage.set(STEAM_BUFFER, DataKey.of(steamBuffer));
                        storage.set(FUEL_BURN_TIME, DataKey.of(burnTime));

                        String status = !hasWater ? "§c缺水！"
                                : (temperature < 100 ? "§e加热中" : (running ? "§a运行中" : "§7待机"));
                        context.screenText().append(TextScope.OPERATION, BOILER_TEMP,
                                Component.literal("温度: " + String.format("%.1f", temperature) + "°C"));
                        context.screenText().append(TextScope.OPERATION, BOILER_STEAM,
                                Component.literal("蒸汽缓冲: " + String.format("%.0f", steamBuffer) + " mB"));
                        context.screenText().append(TextScope.OPERATION, BOILER_FUEL,
                                Component.literal("燃料: " + (burnTime > 0 ? burnTime + " tick" : "§c无")));
                        context.screenText().append(TextScope.OPERATION, BOILER_STATUS,
                                Component.literal("状态: " + status));

                        context.jadeText().append(BOILER_TEMP,
                                Component.literal(String.format("%.0f", temperature) + "°C " +
                                        (hasWater ? "§a水 OK" : "§c缺水")));
                    }))
                    .build();
            event.registerMachine(machine);
        }
    }

    protected LargeBronzeBoiler () {}
}
