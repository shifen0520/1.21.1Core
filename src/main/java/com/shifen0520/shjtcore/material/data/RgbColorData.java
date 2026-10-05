package com.shifen0520.shjtcore.material.data;

public final class RgbColorData {

    private final int rgb;

    private RgbColorData(int rgb) {
        this.rgb = rgb;
    }

    static RgbColorData create(int rgb) {
        return new RgbColorData(rgb);
    }

    public int rgb() {
        return rgb;
    }
}
