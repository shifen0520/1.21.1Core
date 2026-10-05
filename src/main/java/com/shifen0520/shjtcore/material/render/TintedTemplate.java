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
            ItemColor[] tints = TintedTemplate.itemTintSources(this.layers, material);

            // 1) 生成模型 json：1~3 层，手持类走 handheld 模板
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

            builder.tintSource(tints);
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
                    .blockTintSource(() -> () -> blockTints)
                    .tintSource(() -> () -> itemTints);
        }
    }
}
