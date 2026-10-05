package com.shifen0520.shjtcore.material.render;

import com.gto.registrylib.RegistryCore;
import com.gto.registrylib.builders.BlockBuilder;
import com.shifen0520.shjtcore.material.Material;
import com.shifen0520.shjtcore.material.data.MaterialDataType;
import net.minecraft.world.level.block.Block;

import java.util.List;

/**
 * 方块形态渲染契约：把某个材料方块形态（如 block）的模型与染色应用到 registrylib 的 BlockBuilder 上。
 * 参考 odysseyindustrial 的 com.gto.oi.api.material.render.MaterialBlockRender。
 */
public interface MaterialBlockRender {
    List<MaterialDataType<?>> requiredMaterialData();

    void apply(BlockBuilder<Block, RegistryCore> builder, Material material);
}
