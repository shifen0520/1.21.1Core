package com.shifen0520.shjtcore.machine.production;

import cn.howxu.mmcr.publicapi.Machines;
import cn.howxu.mmcr.publicapi.behavior.TickContext;
import cn.howxu.mmcr.publicapi.data.DataKey;
import cn.howxu.mmcr.publicapi.data.DataStore;
import cn.howxu.mmcr.publicapi.event.RegisterMachineDefinitionsEvent;
import cn.howxu.mmcr.publicapi.event.RegisterMachineRecipesEvent;
import cn.howxu.mmcr.publicapi.machine.MachineSpec;
import cn.howxu.mmcr.publicapi.presentation.TextScope;
import cn.howxu.mmcr.publicapi.recipe.IoValues;
import cn.howxu.mmcr.publicapi.recipe.requirement.Requirements;
import cn.howxu.mmcr.publicapi.runtime.IoTransaction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.fluids.FluidStack;

import java.util.List;

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
    private static final ResourceLocation BOILER_RATE = id("boiler_rate");

    private static final ResourceLocation JADE_BURN = id("jade_burn");
    private static final ResourceLocation JADE_RATE = id("jade_rate");

    private static final double INITIAL_TEMPERATURE = 36.5;
    private static final double MAX_TEMPERATURE = 500.0;
    private static final double HEAT_RATE = 0.05;
    private static final double COOL_RATE = 0.03;

    private static final int WATER_PER_TICK = 20;
    private static final int STEAM_RATIO = 160;
    private static final int STEAM_IDLE_DRAIN = 100;
    private static final int MAX_STEAM_BUFFER = 10000;

    private static final class FuelEntry {
        final Item item;
        final int burnDuration;
        FuelEntry(Item item, int burnDuration) {
            this.item = item;
            this.burnDuration = burnDuration;
        }
    }

    private static final List<FuelEntry> FUELS = List.of(
            new FuelEntry(Items.COAL, 160),
            new FuelEntry(Items.CHARCOAL, 160),
            new FuelEntry(Items.COAL_BLOCK, 1600),
            new FuelEntry(Items.BLAZE_ROD, 240),
            new FuelEntry(Items.DRIED_KELP_BLOCK, 400),
            new FuelEntry(Items.BAMBOO_BLOCK, 150),
            new FuelEntry(Items.HAY_BLOCK, 150),
            new FuelEntry(Items.DIAMOND, 6400),
            new FuelEntry(Items.DIAMOND_BLOCK, 64000),
            new FuelEntry(Items.STICK, 10),
            new FuelEntry(Items.OAK_PLANKS, 30),
            new FuelEntry(Items.OAK_LOG, 30),
            new FuelEntry(Items.SPRUCE_PLANKS, 30),
            new FuelEntry(Items.SPRUCE_LOG, 30),
            new FuelEntry(Items.BIRCH_PLANKS, 30),
            new FuelEntry(Items.BIRCH_LOG, 30),
            new FuelEntry(Items.JUNGLE_PLANKS, 30),
            new FuelEntry(Items.JUNGLE_LOG, 30),
            new FuelEntry(Items.ACACIA_PLANKS, 30),
            new FuelEntry(Items.ACACIA_LOG, 30),
            new FuelEntry(Items.DARK_OAK_PLANKS, 30),
            new FuelEntry(Items.DARK_OAK_LOG, 30),
            new FuelEntry(Items.MANGROVE_PLANKS, 30),
            new FuelEntry(Items.MANGROVE_LOG, 30),
            new FuelEntry(Items.CHERRY_PLANKS, 30),
            new FuelEntry(Items.CHERRY_LOG, 30),
            new FuelEntry(Items.BAMBOO_PLANKS, 30),
            new FuelEntry(Items.CRIMSON_PLANKS, 30),
            new FuelEntry(Items.WARPED_PLANKS, 30)
    );

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

                        double temperature = storage.get(TEMPERATURE).flatMap(DataKey::asDouble).orElse(INITIAL_TEMPERATURE);
                        double steamBuffer = storage.get(STEAM_BUFFER).flatMap(DataKey::asDouble).orElse(0.0);
                        int burnTime = storage.get(FUEL_BURN_TIME).flatMap(DataKey::asInt).orElse(0);

                        IoTransaction waterPlan = context.ioPlan()
                                .addInput(Requirements.fluidInput(Fluids.WATER, 1));
                        boolean hasWater = waterPlan.simulate().inputsSatisfied();

                        if (!hasWater && temperature > 100.0) {
                            Level level = context.level();
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
                            for (FuelEntry fuel : FUELS) {
                                IoTransaction fuelPlan = context.ioPlan()
                                        .addInput(Requirements.itemInput(IoValues.itemInput(fuel.item, 1)));
                                if (fuelPlan.simulate().inputsSatisfied()) {
                                    if (fuelPlan.commit().successful()) {
                                        burnTime = fuel.burnDuration;
                                        consumingFuel = true;
                                    }
                                    break;
                                }
                            }
                        }

                        if (consumingFuel) {
                            temperature = Math.min(temperature + HEAT_RATE, MAX_TEMPERATURE);
                        } else {
                            temperature = Math.max(temperature - COOL_RATE, INITIAL_TEMPERATURE);
                        }

                        boolean producing = temperature > 100.0 && hasWater;
                        double heatFactor = temperature / MAX_TEMPERATURE;

                        if (producing) {
                            int waterNeed = Math.max(1, (int) Math.round(WATER_PER_TICK * heatFactor));
                            IoTransaction boilPlan = context.ioPlan()
                                    .addInput(Requirements.fluidInput(Fluids.WATER, waterNeed));
                            if (boilPlan.simulate().inputsSatisfied() && boilPlan.commit().successful()) {
                                int steamMade = waterNeed * STEAM_RATIO;
                                if (steamBuffer + steamMade <= MAX_STEAM_BUFFER) {
                                    steamBuffer += steamMade;
                                }
                            }
                        }

                        Fluid steam = BuiltInRegistries.FLUID
                                .getOptional(ResourceLocation.parse("mekanism:steam"))
                                .orElse(Fluids.EMPTY);
                        if (steamBuffer > 0 && steam != Fluids.EMPTY) {
                            int drain = producing
                                    ? Math.max(1, (int) Math.round(WATER_PER_TICK * STEAM_RATIO * heatFactor))
                                    : STEAM_IDLE_DRAIN;
                            int toOutput = (int) Math.min(steamBuffer, drain);
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

                        int rateWater = producing ? Math.max(1, (int) Math.round(WATER_PER_TICK * heatFactor)) : 0;
                        int rateSteam = producing ? Math.max(1, (int) Math.round(WATER_PER_TICK * STEAM_RATIO * heatFactor)) : 0;
                        String status = !hasWater ? "§c缺水！"
                                : (temperature < 100 ? "§e加热中"
                                : (consumingFuel ? "§a运行中" : "§a余温产汽"));
                        context.screenText().append(TextScope.OPERATION, BOILER_TEMP,
                                Component.literal("温度: " + String.format("%.1f", temperature) + "°C"));
                        context.screenText().append(TextScope.OPERATION, BOILER_STEAM,
                                Component.literal("蒸汽缓冲: " + String.format("%.0f", steamBuffer) + " mB"));
                        context.screenText().append(TextScope.OPERATION, BOILER_FUEL,
                                Component.literal("燃料: " + (burnTime > 0 ? burnTime + " tick" : "§c无")));
                        context.screenText().append(TextScope.OPERATION, BOILER_STATUS,
                                Component.literal("状态: " + status));
                        context.screenText().append(TextScope.OPERATION, BOILER_RATE,
                                Component.literal("速率: 耗水 " + rateWater + " mB/t / 产汽 " + rateSteam + " mB/t"));

                        context.jadeText().append(BOILER_TEMP,
                                Component.literal(String.format("%.0f", temperature) + "°C " +
                                        (hasWater ? "§a水 OK" : "§c缺水")));
                        context.jadeText().append(JADE_BURN,
                                Component.literal("燃料: " + (burnTime > 0 ? burnTime + " tick" : "§c无")));
                        int jadeSteamOut = producing ? rateSteam : (steamBuffer > 0 ? STEAM_IDLE_DRAIN : 0);
                        context.jadeText().append(JADE_RATE,
                                Component.literal("蒸汽输出: " + jadeSteamOut + " mB/t"));
                    }))
                    .build();
            event.registerMachine(machine);
        }
    }
}
