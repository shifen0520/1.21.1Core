package com.shifen0520.shjtcore.material.render;

import com.gto.registrylib.RegistryCore;
import com.gto.registrylib.builders.ItemBuilder;
import com.shifen0520.shjtcore.material.Material;
import com.shifen0520.shjtcore.material.data.MaterialDataType;
import net.minecraft.world.item.Item;

import java.util.List;

public interface MaterialItemRender {
    List<MaterialDataType<?>> requiredMaterialData();

    void apply(ItemBuilder<Item, RegistryCore> builder, Material material);
}
