package com.shifen0520.shjtcore.machine;

import cn.howxu.mmcr.publicapi.event.RegisterMachineDefinitionsEvent;
import cn.howxu.mmcr.publicapi.registration.MachineDefinitionProvider;
import com.shifen0520.shjtcore.machine.electric.MiniatureElectricFurnace;
import com.shifen0520.shjtcore.machine.generation.SteamTurbineUnit;
import com.shifen0520.shjtcore.machine.production.LargeBronzeBoiler;
import com.shifen0520.shjtcore.research.mmcr.MachineRecipes;

public final class BuItiInProvider implements MachineDefinitionProvider {
    @Override
    public void register(RegisterMachineDefinitionsEvent event) {
        LargeBronzeBoiler.registerDefinitions(event);
        SteamTurbineUnit.registerDefinitions(event);
        MiniatureElectricFurnace.registerDefinitions(event);
    }

}
