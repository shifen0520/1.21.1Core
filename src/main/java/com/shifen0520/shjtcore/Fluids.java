package com.shifen0520.shjtcore;

import com.shifen0520.shjtcore.material.Material;
import com.shifen0520.shjtcore.material.MaterialForm;
import com.shifen0520.shjtcore.material.MaterialForms;
import com.shifen0520.shjtcore.material.MaterialRegistry;
import com.shifen0520.shjtcore.material.data.MaterialDataTypes;
import com.shifen0520.shjtcore.material.form.FluidForm;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 把带流体形态的材料落成真实流体（含桶，桶进 fluids 标签页）。
 *
 * <p>形态分工对应 GTM：
 * <ul>
 *   <li>{@link MaterialForms#ELEMENT_GAS} / {@link MaterialForms#GAS} —— 气态（元素气体 / 化合物气体）</li>
 *   <li>{@link MaterialForms#ELEMENT_LIQUID} / {@link MaterialForms#LIQUID} —— 熔融（固体对应）</li>
 *   <li>{@link MaterialForms#ELEMENT_FLUID} —— 常温液态元素（汞、溴）</li>
 *   <li>{@link MaterialForms#FLUID} —— 一般化合物流体</li>
 * </ul>
 */
public final class Fluids {

    private Fluids() {
    }

    public static void register() {
        // 收集全部流体形态并按材料名排序，让 fluids 标签页里的桶按字母序排列
        record FluidEntry(Material material, FluidForm form) {
        }
        List<FluidEntry> entries = new ArrayList<>();
        for (Material material : MaterialRegistry.registered()) {
            for (MaterialForm form : material.forms()) {
                if (form instanceof FluidForm fluidForm) {
                    entries.add(new FluidEntry(material, fluidForm));
                }
            }
        }
        entries.sort(Comparator.comparing(e -> e.material.id().getPath()));

        for (FluidEntry entry : entries) {
            Material material = entry.material;
            FluidForm fluidForm = entry.form;
            MaterialForm form = fluidForm;
            String materialPath = material.id().getPath();
            String name = form.registryName(materialPath); // 例如 hydrogen_fluid
                // 流体贴图取自形态共享模板：熔融=灰度岩浆 / 其余=灰度水 / 元素=纯色
                ResourceLocation still =
                        ResourceLocation.fromNamespaceAndPath(SHJTCore.MODID, fluidForm.stillTexture());
                ResourceLocation flow =
                        ResourceLocation.fromNamespaceAndPath(SHJTCore.MODID, fluidForm.flowTexture());

                // 温度优先取材料真实熔点（铁 1811K / 金 1337K / 钨 3695K）；
                // 常温液态元素（汞、溴）没有熔点数据 —— 常温即为液体，回落形态默认室温 300K。
                int temperature = material.data(MaterialDataTypes.MELTING_POINT)
                        .orElse(fluidForm.temperature());
                int density = material.data(MaterialDataTypes.DENSITY)
                        .orElse(fluidForm.density());

                // 桶的流体覆盖层是灰度贴图，颜色完全靠 tint：优先取材料主色
                int tint = material.data(MaterialDataTypes.PRIMARY_COLOR)
                        .<Integer>map(c -> 0xFF000000 | c.rgb())
                        .orElse(fluidForm.tintColor());

                boolean molten = form == MaterialForms.LIQUID || form == MaterialForms.ELEMENT_LIQUID;

                var builder = SHJTCore.REGISTRY
                        .fluid(name, still, flow, BaseFlowingFluid.Flowing::new)
                        .properties(p -> p.density(density).viscosity(fluidForm.viscosity()).temperature(temperature))
                        .lang(molten ? "Molten " + MaterialNames.display(materialPath)
                                : MaterialNames.display(materialPath))
                        .clientExtension(still, flow, tint)
                        .defaultBucketTab(BuiltinSHJTCreativeTabs.FLUIDS_KEY)
                        // 常见流体标签（c: 约定，参考 GTM）
                        .tag(TagKey.create(Registries.FLUID,
                                ResourceLocation.fromNamespaceAndPath("c", "fluids/" + materialPath)))
                        .tag(TagKey.create(Registries.FLUID,
                                ResourceLocation.fromNamespaceAndPath("c", "fluids")));

                // 气态 / 液态再补一份更精确的标签
                if (form == MaterialForms.GAS || form == MaterialForms.ELEMENT_GAS) {
                    builder.tag(TagKey.create(Registries.FLUID,
                                    ResourceLocation.fromNamespaceAndPath("c", "gases/" + materialPath)))
                            .tag(TagKey.create(Registries.FLUID,
                                    ResourceLocation.fromNamespaceAndPath("c", "gases")));
                } else if (form == MaterialForms.LIQUID || form == MaterialForms.ELEMENT_LIQUID
                        || form == MaterialForms.ELEMENT_FLUID) {
                    builder.tag(TagKey.create(Registries.FLUID,
                                    ResourceLocation.fromNamespaceAndPath("c", "liquids/" + materialPath)))
                            .tag(TagKey.create(Registries.FLUID,
                                    ResourceLocation.fromNamespaceAndPath("c", "liquids")));
                }

                builder.register();
        }
    }
}
