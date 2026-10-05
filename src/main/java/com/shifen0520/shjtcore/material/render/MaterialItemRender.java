package com.shifen0520.shjtcore.material.render;

import com.gto.registrylib.RegistryCore;
import com.gto.registrylib.builders.ItemBuilder;
import com.shifen0520.shjtcore.material.Material;
import com.shifen0520.shjtcore.material.data.MaterialDataType;
import net.minecraft.world.item.Item;

import java.util.List;

/**
 * 物品形态渲染契约：把某个材料形态（如 ingot）的模型与染色应用到 registrylib 的 ItemBuilder 上。
 * 参考 odysseyindustrial 的 com.gto.oi.api.material.render.MaterialItemRender。
 */
public interface MaterialItemRender {
    /** 该渲染所需、材料必须携带的颜色数据类型（用于校验与染色）。 */
    List<MaterialDataType<?>> requiredMaterialData();

    /** 在注册阶段把模型/染色写入 builder。 */
    void apply(ItemBuilder<Item, RegistryCore> builder, Material material);
}
