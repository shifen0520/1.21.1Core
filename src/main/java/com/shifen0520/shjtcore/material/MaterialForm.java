package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataUse;
import net.minecraft.resources.ResourceLocation;

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

    public String registryName(String materialPath) {
        return materialPath + "_" + suffix;
    }

    public abstract boolean isItem();
    public abstract boolean isBlock();
    public abstract boolean isFluid();

    public abstract FormType type();

    public enum FormType { ITEM, BLOCK, FLUID }
}
