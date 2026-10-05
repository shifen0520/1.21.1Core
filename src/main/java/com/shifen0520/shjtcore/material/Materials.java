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
        MaterialDataTypes.init();
        MaterialForms.init();
        registerMaterials();
    }

    private static void registerMaterials() {
    }
}
