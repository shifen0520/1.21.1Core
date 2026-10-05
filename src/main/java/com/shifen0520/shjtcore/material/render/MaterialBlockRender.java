package com.shifen0520.shjtcore.material.render;

import com.gto.registrylib.RegistryCore;
import com.gto.registrylib.builders.BlockBuilder;
import com.shifen0520.shjtcore.material.Material;
import com.shifen0520.shjtcore.material.data.MaterialDataType;
import net.minecraft.world.level.block.Block;

import java.util.List;

public interface MaterialBlockRender {
    List<MaterialDataType<?>> requiredMaterialData();

    void apply(BlockBuilder<Block, RegistryCore> builder, Material material);
}
