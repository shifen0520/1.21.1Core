package com.shifen0520.shjtcore.material.form;

import com.shifen0520.shjtcore.material.MaterialForm;
import com.shifen0520.shjtcore.material.data.MaterialDataUse;
import com.shifen0520.shjtcore.material.render.MaterialItemRender;
import net.minecraft.resources.ResourceLocation;

/**
 * 物品形态（ingot/dust/plate/gear…）。持有渲染模板，注册时由 Items 应用到 ItemBuilder。
 * 参考 odysseyindustrial 的 com.gto.oi.data.material.common.form.ItemForm。
 */
public final class ItemForm extends MaterialForm {
    private final MaterialItemRender render;

    private ItemForm(ResourceLocation id, String suffix, String displayName,
                     String commonTag, MaterialDataUse<?> amount, MaterialItemRender render) {
        super(id, suffix, displayName, commonTag, amount);
        this.render = render;
    }

    public MaterialItemRender render() {
        return render;
    }

    @Override
    public boolean isItem() {
        return true;
    }

    @Override
    public boolean isBlock() {
        return false;
    }

    @Override
    public boolean isFluid() {
        return false;
    }

    @Override
    public FormType type() {
        return FormType.ITEM;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String suffix;
        private String displayName;
        private String commonTag;
        private MaterialDataUse<?> amount;
        private MaterialItemRender render;

        public Builder suffix(String s) {
            this.suffix = s;
            return this;
        }

        public Builder displayName(String n) {
            this.displayName = n;
            return this;
        }

        public Builder commonTag(String t) {
            this.commonTag = t;
            return this;
        }

        public Builder amount(MaterialDataUse<?> a) {
            this.amount = a;
            return this;
        }

        public Builder render(MaterialItemRender r) {
            this.render = r;
            return this;
        }

        public ItemForm build(ResourceLocation id) {
            return new ItemForm(id, suffix, displayName, commonTag, amount, render);
        }
    }
}
