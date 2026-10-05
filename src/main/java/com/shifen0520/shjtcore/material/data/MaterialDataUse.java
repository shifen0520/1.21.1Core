package com.shifen0520.shjtcore.material.data;

public final class MaterialDataUse<D> {
    private final MaterialDataType<D> type;
    private final D data;

    MaterialDataUse(MaterialDataType<D> type, D data) {
        this.type = type;
        this.data = data;
    }

    public MaterialDataType<D> type() {
        return type;
    }
    public D data() {
        return data;
    }

}
