package com.shifen0520.shjtcore;

/**
 * 材料显示名工具：把 registry path 转成可读英文名（供 lang 生成用）。
 * 例如 {@code iron_ingot} → {@code Iron Ingot}、{@code abyssalalloy} → {@code Abyssalalloy}。
 */
public final class MaterialNames {

    private MaterialNames() {
    }

    /** 下划线分词 + 首字母大写。 */
    public static String display(String path) {
        StringBuilder sb = new StringBuilder();
        for (String word : path.split("_")) {
            if (word.isEmpty()) {
                continue;
            }
            if (!sb.isEmpty()) {
                sb.append(" ");
            }
            sb.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1));
        }
        return sb.toString();
    }
}
