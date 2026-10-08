package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册入口（空白模板）。
 *
 * <p>本类由 26.1.2 版本移植而来，原版在此按每 50 个材料一组拆分到
 * Materials01…Materials34 / PeriodicTablePart01…04 共 38 个类里注册了 1783 个材料
 * （含 118 个元素）。按需求“什么都不注册，作为空白”，那些材料数据类已全部移除，
 * 这里只保留材料系统的初始化顺序。
 *
 * <p>后续要注册材料时，在本类的 {@link #registerMaterials()} 里写：
 * <pre>{@code
 * MaterialRegistry.register("iron")
 *         .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC8C8C8))
 *         .data(MaterialDataTypes.MASS.mass(56))
 *         .forms(MaterialForms.INGOT, MaterialForms.DUST)
 *         .build();
 * }</pre>
 * 注册量大时请照原版做法拆分到 Materials01、Materials02… 等同包类里：
 * JVM 单方法字节码上限 64KB，一个方法塞不下上千个材料。
 */
public final class Materials {

    private Materials() {
    }

    public static void init() {
        // 1) 先初始化材料数据类型（颜色/质量/熔点/密度…）
        MaterialDataTypes.init();
        // 2) 再初始化形态（ingot/dust/plate/gear/fluid…）
        MaterialForms.init();
        // 3) 元素周期表（118 个元素，含气/液/固三态与熔点密度）
        PeriodicTable.init();
        // 4) 化合物与合金等非周期表材料（1665 个，按每 50 个一组拆 34 个文件）
        registerMaterials();
    }

    private static void registerMaterials() {
        Materials01.init();
        Materials02.init();
        Materials03.init();
        Materials04.init();
        Materials05.init();
        Materials06.init();
        Materials07.init();
        Materials08.init();
        Materials09.init();
        Materials10.init();
        Materials11.init();
        Materials12.init();
        Materials13.init();
        Materials14.init();
        Materials15.init();
        Materials16.init();
        Materials17.init();
        Materials18.init();
        Materials19.init();
        Materials20.init();
        Materials21.init();
        Materials22.init();
        Materials23.init();
        Materials24.init();
        Materials25.init();
        Materials26.init();
        Materials27.init();
        Materials28.init();
        Materials29.init();
        Materials30.init();
        Materials31.init();
        Materials32.init();
        Materials33.init();
        Materials34.init();
        // 35 段：GTM 1.21 官方表里有、原数据缺失的材料
        Materials35.init();
    }
}
