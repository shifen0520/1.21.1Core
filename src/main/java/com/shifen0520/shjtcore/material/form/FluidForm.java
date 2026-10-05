package com.shifen0520.shjtcore.material.form;

import com.shifen0520.shjtcore.material.MaterialForm;
import com.shifen0520.shjtcore.material.data.MaterialDataUse;
import net.minecraft.resources.ResourceLocation;

public final class FluidForm extends MaterialForm {
    private final int density;
    private final int viscosity;
    private final int temperature;
    private final int tintColor;
    private final String stillTexture;
    private final String flowTexture;

    private FluidForm(ResourceLocation id, String suffix, String displayName,
                      String commonTag, MaterialDataUse<?> amount,
                      int density, int viscosity, int temperature, int tintColor,
                      String stillTexture, String flowTexture) {
        super(id, suffix, displayName, commonTag, amount);
        this.density = density;
        this.viscosity = viscosity;
        this.temperature = temperature;
        this.tintColor = tintColor;
        this.stillTexture = stillTexture;
        this.flowTexture = flowTexture;
    }

    public int density() {
        return density;
    }

    public int viscosity() {
        return viscosity;
    }

    public int temperature() {
        return temperature;
    }

    public int tintColor() {
        return tintColor;
    }

    public String stillTexture() {
        return stillTexture;
    }

    public String flowTexture() {
        return flowTexture;
    }

    @Override
    public boolean isItem() {
        return false;
    }

    @Override
    public boolean isBlock() {
        return false;
    }

    @Override
    public boolean isFluid() {
        return true;
    }

    @Override
    public FormType type() {
        return FormType.FLUID;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String suffix = "fluid";
        private String displayName = "Fluid";
        private String commonTag = "fluids";
        private MaterialDataUse<?> amount;
        private int density = 1000;
        private int viscosity = 1000;
        private int temperature = 300;
        private int tintColor = 0xFFFFFFFF;
        private String stillTexture = "block/fluid/fluid_still";
        private String flowTexture = "block/fluid/fluid_flow";

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

        public Builder density(int d) {
            this.density = d;
            return this;
        }

        public Builder viscosity(int v) {
            this.viscosity = v;
            return this;
        }

        public Builder temperature(int t) {
            this.temperature = t;
            return this;
        }

        public Builder tintColor(int c) {
            this.tintColor = c;
            return this;
        }

        public Builder texture(String still, String flow) {
            this.stillTexture = still;
            this.flowTexture = flow;
            return this;
        }

        public FluidForm build(ResourceLocation id) {
            return new FluidForm(id, suffix, displayName, commonTag, amount,
                    density, viscosity, temperature, tintColor, stillTexture, flowTexture);
        }
    }
}
