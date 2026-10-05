package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataUse;
import net.minecraft.resources.ResourceLocation;

/**
 * 材料形态基类。一个“形态”描述材料能变成的某种东西（ingot/dust/plate/gear/fluid/block…）。
 * 参考 odysseyindustrial 的 com.gto.oi.api.material.form.MaterialForm（此处为 twtdlcore 的简化自包含实现）。
 */
public abstract class MaterialForm {
    private final ResourceLocation id;
    private final String suffix;
    private final String displayName;
    private final String commonTag;
    private final MaterialDataUse<?> amount;

    protected MaterialForm(ResourceLocation id, String suffix, String displayName, String commonTag, MaterialDataUse<?> amount) {
        this.id = id;
        this.suffix = suffix;
        this.displayName = displayName;
        this.commonTag = commonTag;
        this.amount = amount;
    }

    public ResourceLocation id() {
        return id;
    }

    /** 形态后缀，例如 ingot / dust / plate，用于拼出物品/方块注册名 iron_ingot。 */
    public String suffix() {
        return suffix;
    }

    public String displayName() {
        return displayName;
    }

    public String commonTag() {
        return commonTag;
    }

    public MaterialDataUse<?> amount() {
        return amount;
    }

    /** 由材料路径与形态后缀拼出该形态在本材料下的注册名，例如 iron_ingot。 */
    public String registryName(String materialPath) {
        return materialPath + "_" + suffix;
    }

    public abstract boolean isItem();
    public abstract boolean isBlock();
    public abstract boolean isFluid();

    public abstract FormType type();

    public enum FormType { ITEM, BLOCK, FLUID }
}
