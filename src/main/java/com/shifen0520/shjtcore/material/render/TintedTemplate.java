package com.shifen0520.shjtcore.material.render;

import com.gto.registrylib.RegistryCore;
import com.gto.registrylib.builders.BlockBuilder;
import com.gto.registrylib.builders.ItemBuilder;
import com.gto.registrylib.util.RegistryLibTintSources;
import com.gto.registrylib.util.TextureRef;
import com.gto.registrylib.util.color.RgbColor;
import com.gto.registrylib.util.visual.BlockModelLayer;
import com.shifen0520.shjtcore.material.Material;
import com.shifen0520.shjtcore.material.data.MaterialDataType;
import com.shifen0520.shjtcore.material.data.RgbColorData;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 材质染色模板：把一个材料形态的物品/方块渲染成 1~3 层带染色的模型。
 * 移植自 odysseyindustrial 的 com.gto.oi.data.material.common.render.TintedTemplate，
 * 仅把依赖的 Material / RgbColorData 换成 shjtcore 自身实现，其余 registrylib 调用保持一致。
 *
 * <p><b>26.1.2 → 1.21.1 移植改动</b>：
 * <ul>
 *   <li>{@code net.minecraft.client.data.models.model.*} → {@code net.minecraft.data.models.model.*}
 *       （1.21.1 的 datagen 模型类不在 client 子包下）</li>
 *   <li>{@code ItemTintSource / BlockTintSource} → {@code ItemColor / BlockColor}
 *       （registrylib 8.0.16 的 RegistryLibTintSources 返回的是这两个类型）</li>
 *   <li>物品染色不再写进模型 json：1.21.1 没有 {@code ItemModelUtils.tintedModel}，
 *       改为 {@code ItemBuilder.tintSource(ItemColor...)} 由 registrylib 注册染色</li>
 *   <li>{@code TextureMapping} 直接吃 {@code ResourceLocation}，不再需要 sprite.Material 包装</li>
 * </ul>
 */
public final class TintedTemplate {
    private TintedTemplate() {
    }

    private static ResourceLocation rl(String texturePath) {
        return ResourceLocation.fromNamespaceAndPath("shjtcore", texturePath);
    }

    public static Layer tinted(MaterialDataType<RgbColorData> requiredData, String texturePath) {
        return new Layer(texturePath, Objects.requireNonNull(requiredData, "requiredData"));
    }

    public static Layer flat(String texturePath) {
        return new Layer(texturePath, null);
    }

    public static BlockLayer opaque(Layer layer) {
        return new BlockLayer(layer, false);
    }

    public static BlockLayer translucent(Layer layer) {
        return new BlockLayer(layer, true);
    }

    public static MaterialItemRender item(Layer... layers) {
        List<Layer> list = List.of(layers);
        if (list.isEmpty() || list.size() > 3) {
            throw new IllegalArgumentException("tinted template render requires 1 to 3 item render layers");
        }
        return new ItemRender(list, false);
    }

    public static MaterialItemRender handheldItem(Layer... layers) {
        List<Layer> list = List.of(layers);
        if (list.isEmpty() || list.size() > 3) {
            throw new IllegalArgumentException("tinted template render requires 1 to 3 item render layers");
        }
        return new ItemRender(list, true);
    }

    public static MaterialBlockRender block(BlockLayer... layers) {
        List<BlockLayer> list = List.of(layers);
        if (list.isEmpty() || list.size() > 3) {
            throw new IllegalArgumentException("tinted template render requires 1 to 3 block render layers");
        }
        return new BlockRender(list);
    }

    /** 贴图路径 → ResourceLocation（1.21.1 的 TextureMapping 直接用 ResourceLocation）。 */
    private static ResourceLocation templateTexture(Layer layer) {
        return rl(layer.texturePath);
    }

    private static ItemColor[] itemTintSources(List<Layer> layers, Material material) {
        ItemColor[] tints = new ItemColor[layers.size()];
        for (int index = 0; index < layers.size(); ++index) {
            tints[index] = RegistryLibTintSources.itemConstant(RgbColor.of(layerColor(layers.get(index), material)));
        }
        return tints;
    }

    private static int layerColor(Layer layer, Material material) {
        if (layer.requiredData == null) {
            return 0xFFFFFF;
        }
        return material.data(layer.requiredData).map(RgbColorData::rgb).orElse(0xFFFFFF);
    }

    private static TextureRef templateTextureRef(Layer layer) {
        return TextureRef.of(rl(layer.texturePath));
    }

    private static BlockModelLayer[] blockModelLayers(List<BlockLayer> layers) {
        BlockModelLayer[] result = new BlockModelLayer[layers.size()];
        for (int index = 0; index < layers.size(); ++index) {
            BlockLayer blockLayer = layers.get(index);
            Layer layer = blockLayer.layer;
            TextureRef texture = templateTextureRef(layer);
            result[index] = layer.requiredData != null
                    ? BlockModelLayer.tinted(texture, index, blockLayer.forceTranslucent)
                    : BlockModelLayer.untinted(texture, blockLayer.forceTranslucent);
        }
        return result;
    }

    private static BlockColor[] blockTintSources(List<BlockLayer> layers, Material material) {
        BlockColor[] tints = new BlockColor[layers.size()];
        for (int index = 0; index < layers.size(); ++index) {
            tints[index] = RegistryLibTintSources.blockConstant(RgbColor.of(layerColor(layers.get(index).layer, material)));
        }
        return tints;
    }

    private static ItemColor[] blockItemTintSources(List<BlockLayer> layers, Material material) {
        ItemColor[] tints = new ItemColor[layers.size()];
        for (int index = 0; index < layers.size(); ++index) {
            tints[index] = RegistryLibTintSources.itemConstant(RgbColor.of(layerColor(layers.get(index).layer, material)));
        }
        return tints;
    }

    public static final class Layer {
        private final String texturePath;
        private final MaterialDataType<RgbColorData> requiredData;

        private Layer(String texturePath, MaterialDataType<RgbColorData> requiredData) {
            if (texturePath == null || texturePath.isBlank()) {
                throw new IllegalArgumentException("tinted template render layer requires a texture path");
            }
            this.texturePath = texturePath;
            this.requiredData = requiredData;
        }
    }

    public static final class BlockLayer {
        private final Layer layer;
        private final boolean forceTranslucent;

        private BlockLayer(Layer layer, boolean forceTranslucent) {
            this.layer = Objects.requireNonNull(layer, "layer");
            this.forceTranslucent = forceTranslucent;
        }
    }

    private static final class ItemRender implements MaterialItemRender {
        private static final ModelTemplate TWO_LAYERED_HANDHELD = new ModelTemplate(
                Optional.of(ResourceLocation.fromNamespaceAndPath("minecraft", "item/handheld")),
                Optional.empty(), TextureSlot.LAYER0, TextureSlot.LAYER1);
        private static final ModelTemplate THREE_LAYERED_HANDHELD = new ModelTemplate(
                Optional.of(ResourceLocation.fromNamespaceAndPath("minecraft", "item/handheld")),
                Optional.empty(), TextureSlot.LAYER0, TextureSlot.LAYER1, TextureSlot.LAYER2);
        private final List<Layer> layers;
        private final boolean handheld;

        private ItemRender(List<Layer> layers, boolean handheld) {
            this.layers = layers;
            this.handheld = handheld;
        }

        @Override
        public List<MaterialDataType<?>> requiredMaterialData() {
            ArrayList<MaterialDataType<RgbColorData>> requirements = new ArrayList<>();
            for (Layer layer : this.layers) {
                if (layer.requiredData == null) continue;
                requirements.add(layer.requiredData);
            }
            return List.copyOf(requirements);
        }

        @Override
        public void apply(ItemBuilder<Item, RegistryCore> builder, Material material) {
            // 只负责生成模型 json；运行时染色交给 ClientTintSetup
            // （RegisterColorHandlersEvent.Item，按层索引取主色/副色）。
            //
            // 这里千万不能调 builder.tintSource(...)：它内部会再注册一张默认单层
            // 模型，和我们的多层模板模型抢同一个输出位置，重复写入被吞掉后留下的
            // 就是默认模型（引用不存在的 item/<物品名> 贴图 → 紫黑格）。

            // 生成模型 json：1~3 层，手持类走 handheld 模板
            builder.model(() -> (item, generator) -> {
                ModelTemplate template = switch (this.layers.size()) {
                    case 1 -> this.handheld ? ModelTemplates.FLAT_HANDHELD_ITEM : ModelTemplates.FLAT_ITEM;
                    case 2 -> this.handheld ? TWO_LAYERED_HANDHELD : ModelTemplates.TWO_LAYERED_ITEM;
                    case 3 -> this.handheld ? THREE_LAYERED_HANDHELD : ModelTemplates.THREE_LAYERED_ITEM;
                    default -> throw new IllegalStateException(
                            "Unsupported tinted template item layer count: " + this.layers.size());
                };
                TextureMapping mapping = switch (this.layers.size()) {
                    case 1 -> TextureMapping.layer0(TintedTemplate.templateTexture(this.layers.get(0)));
                    case 2 -> TextureMapping.layered(
                            TintedTemplate.templateTexture(this.layers.get(0)),
                            TintedTemplate.templateTexture(this.layers.get(1)));
                    default -> TextureMapping.layered(
                            TintedTemplate.templateTexture(this.layers.get(0)),
                            TintedTemplate.templateTexture(this.layers.get(1)),
                            TintedTemplate.templateTexture(this.layers.get(2)));
                };
                generator.generateWithTemplate(item, template, mapping);
            });
        }
    }

    private static final class BlockRender implements MaterialBlockRender {
        private final List<BlockLayer> layers;

        private BlockRender(List<BlockLayer> layers) {
            this.layers = layers;
        }

        @Override
        public List<MaterialDataType<?>> requiredMaterialData() {
            ArrayList<MaterialDataType<RgbColorData>> requirements = new ArrayList<>();
            for (BlockLayer blockLayer : this.layers) {
                if (blockLayer.layer.requiredData == null) continue;
                requirements.add(blockLayer.layer.requiredData);
            }
            return List.copyOf(requirements);
        }

        @Override
        public void apply(BlockBuilder<Block, RegistryCore> builder, Material material) {
            TextureRef particle = TintedTemplate.templateTextureRef(this.layers.get(0).layer);
            BlockColor[] blockTints = TintedTemplate.blockTintSources(this.layers, material);
            ItemColor[] itemTints = TintedTemplate.blockItemTintSources(this.layers, material);
            builder.layeredCube(particle, TintedTemplate.blockModelLayers(this.layers))
                    // 1.21.1 的 BlockBuilder 这两个方法收 Supplier<Supplier<...>>，需包一层
                    .blockTintSource(() -> () -> blockTints)
                    .tintSource(() -> () -> itemTints);
        }
    }
}
