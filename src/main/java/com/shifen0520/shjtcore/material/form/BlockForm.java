package com.shifen0520.shjtcore.material.form;

import com.shifen0520.shjtcore.material.MaterialForm;
import com.shifen0520.shjtcore.material.data.MaterialDataUse;
import com.shifen0520.shjtcore.material.render.MaterialBlockRender;
import net.minecraft.resources.ResourceLocation;

/**
 * 方块形态（block/ore…）。持有渲染模板，注册时由 Blocks 应用到 BlockBuilder。
 * 参考 odysseyindustrial 的 com.gto.oi.data.material.common.form.BlockForm。
 */
public final class BlockForm extends MaterialForm {
    private final MaterialBlockRender render;

    private BlockForm(ResourceLocation id, String suffix, String displayName,
                      String commonTag, MaterialDataUse<?> amount, MaterialBlockRender render) {
        super(id, suffix, displayName, commonTag, amount);
        this.render = render;
    }

    public MaterialBlockRender render() {
        return render;
    }

    @Override
    public boolean isItem() {
        return false;
    }

    @Override
    public boolean isBlock() {
        return true;
    }

    @Override
    public boolean isFluid() {
        return false;
    }

    @Override
    public FormType type() {
        return FormType.BLOCK;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String suffix;
        private String displayName;
        private String commonTag;
        private MaterialDataUse<?> amount;
        private MaterialBlockRender render;

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

        public Builder render(MaterialBlockRender r) {
            this.render = r;
            return this;
        }

        public BlockForm build(ResourceLocation id) {
            return new BlockForm(id, suffix, displayName, commonTag, amount, render);
        }
    }
}
