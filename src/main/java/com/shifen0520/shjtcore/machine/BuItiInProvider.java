package com.shifen0520.shjtcore.machine;

import cn.howxu.mmcr.publicapi.event.RegisterMachineDefinitionsEvent;
import cn.howxu.mmcr.publicapi.registration.MachineDefinitionProvider;
import com.shifen0520.shjtcore.machine.electric.MiniatureElectricFurnace;
import com.shifen0520.shjtcore.machine.generation.SteamTurbineUnit;
import com.shifen0520.shjtcore.machine.production.LargeBronzeBoiler;
import com.shifen0520.shjtcore.research.mmcr.ComputeNodeMachine;
import com.shifen0520.shjtcore.research.mmcr.ComputeRouterMachine;
import com.shifen0520.shjtcore.research.mmcr.GatedDemoMachine;
import com.shifen0520.shjtcore.research.mmcr.ResearchCenterMachine;

/**
 * 本 mod 的机器定义注册入口：<b>新增机器只需要在这里登记</b>。
 *
 * <p>为什么必须走 {@code MachineDefinitionProvider}（ServiceLoader），而不用
 * {@code @SubscribeEvent}：MMCR 是在<b>自己</b>的 {@code FMLConstructModEvent} 里
 * {@code post(RegisterMachineDefinitionsEvent)} 的，也就是 "MMCR 这个 mod 被构造完"
 * 的那一瞬间。NeoForge 是在每个 mod 的 {@code constructMod()} <b>末尾</b>才注入
 * {@code @EventBusSubscriber} 的，而本 mod 的 {@code neoforge.mods.toml} 里对 mmcr
 * 声明了 {@code ordering="AFTER"}，所以 MMCR 发事件时本 mod 的订阅者还没被注册，
 * 事件会被静默丢掉，机器根本不存在。
 *
 * <p>ServiceLoader 提供者在 {@code eventBus.post(definitions)} 之前就被 MMCR 直接调用，
 * 与事件总线注册时机无关，所以只有这条路靠得住——MMCR 内置机器也是这么做的。
 *
 * <p>量子装配机配方已迁到 KubeJS（kubejs/server_scripts/mmcr/recipes/quantum_assembler.js），
 * 由 KubeJS 的 {@code ServerEvents.recipes} 注册，不再走 Java。科研门禁（需研究
 * shjtcore:quantum_theory）在 {@code GatedDemoMachine} 的机器定义里。
 */
public final class BuItiInProvider implements MachineDefinitionProvider {

    @Override
    public void register(RegisterMachineDefinitionsEvent event) {
        // 常规机器
        LargeBronzeBoiler.registerDefinitions(event);
        SteamTurbineUnit.registerDefinitions(event);
        MiniatureElectricFurnace.registerDefinitions(event);
        // 科研系统：算力节点（生产者）+ 算力路由器（中间层）+ 科研中心（接收端）+ 门禁示例机
        ComputeNodeMachine.registerDefinitions(event);
        ComputeRouterMachine.registerDefinitions(event);
        ResearchCenterMachine.registerDefinitions(event);
        GatedDemoMachine.registerDefinitions(event);
    }
}
