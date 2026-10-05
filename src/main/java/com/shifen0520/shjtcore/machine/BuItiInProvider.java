package com.shifen0520.shjtcore.machine;

import cn.howxu.mmcr.publicapi.event.RegisterMachineDefinitionsEvent;
import cn.howxu.mmcr.publicapi.registration.MachineDefinitionProvider;
import com.shifen0520.shjtcore.machine.electric.MiniatureElectricFurnace;
import com.shifen0520.shjtcore.machine.production.LargeBronzeBoiler;

public final class BuItiInProvider implements MachineDefinitionProvider {
    @Override
    public void register(RegisterMachineDefinitionsEvent event) {
        MiniatureElectricFurnace.registerDefinitions(event);
        LargeBronzeBoiler.registerDefinitions(event);
    }
}
