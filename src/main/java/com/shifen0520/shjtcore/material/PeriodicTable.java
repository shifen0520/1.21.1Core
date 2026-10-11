package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

import java.util.Arrays;

/**
 * 元素周期表材料注册（颜色与形态逐元素对齐 GTM 1.20.1；铁 Fe 由此处注册）。
 *
 * <p>形态按 GTM 每个元素的基础类型（ingot / dust / gem / liquid / gas / fluid / plasma）与
 * GENERATE_* 标志（含 EXT_METAL / EXT2_METAL 共享集合）逐元素还原。元素流体一律纯色
 * （ELEMENT_GAS / ELEMENT_LIQUID），区别于化合物的灰度岩浆/水纹理。
 *
 * <p>118 个元素按每 30 个一组放在 PeriodicTablePart01…PeriodicTablePart04 里，
 * 本类拼接后统一注册（同样是为了避开 JVM 单方法 64KB 字节码上限）。
 */
public final class PeriodicTable {
    public enum State { SOLID, LIQUID, GAS }

    /** 元素原始数据：原子序数、注册路径、原子量、GTM 主色、GTM 次级色、常温物态、
     *  熔点 K（0 = 无，流体回落形态默认温度）、密度 kg/m³（0 = 无）、对齐 GTM 的形态集。 */
    public record Element(int number, String id, double mass, int color, int secondary,
                          State state, int meltingPoint, int density, MaterialForm[] forms) {
    }

    private static final Element[] ELEMENTS = join(
            PeriodicTablePart01.elements(),
            PeriodicTablePart02.elements(),
            PeriodicTablePart03.elements(),
            PeriodicTablePart04.elements()
    );

    private static Element[] join(Element[]... parts) {
        int total = 0;
        for (Element[] part : parts) {
            total += part.length;
        }
        Element[] all = new Element[total];
        int at = 0;
        for (Element[] part : parts) {
            System.arraycopy(part, 0, all, at, part.length);
            at += part.length;
        }
        return all;
    }

    private PeriodicTable() {
    }

    /** 触发类初始化（静态块里完成全部元素注册）。 */
    public static void init() {
    }

    static {
        for (Element e : ELEMENTS) {
            var builder = MaterialRegistry.register(e.id)
                    .data(MaterialDataTypes.PRIMARY_COLOR.rgb(e.color))
                    .data(MaterialDataTypes.SECONDARY_COLOR.rgb(e.secondary))
                    .data(MaterialDataTypes.MASS.mass((int) Math.round(e.mass)));
            // 熔点/密度为 0 表示"未知"，流体回落形态默认温度（常温液态元素如汞、溴即走此路径，
            // 它们常温就是液体，不是熔化所得）。
            if (e.meltingPoint > 0) {
                builder.data(MaterialDataTypes.MELTING_POINT.value(e.meltingPoint));
            }
            if (e.density > 0) {
                builder.data(MaterialDataTypes.DENSITY.value(e.density));
            }
            builder.forms(withRawOre(e.forms)).build();
        }
    }

    /**
     * 给单元素金属附加粗矿（原矿）形态。
     *
     * <p>判定依据：元素自身形态里含 {@link MaterialForms#INGOT} 的，就是铁/金/锡这类可冶炼金属。
     * 气体（氢、氦…）、常温液体（汞、溴）、非金属固体（碳、硫…）都不带 INGOT，
     * 因此不会被误加粗矿。
     */
    private static MaterialForm[] withRawOre(MaterialForm[] forms) {
        for (MaterialForm form : forms) {
            if (form == MaterialForms.INGOT) {
                MaterialForm[] withOre = Arrays.copyOf(forms, forms.length + 1);
                withOre[forms.length] = MaterialForms.RAW_ORE;
                return withOre;
            }
        }
        return forms;
    }
}
