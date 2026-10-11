package com.shifen0520.shjtcore.research.data;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import net.minecraft.network.chat.Component;

import java.util.List;

/**
 * 科技 / 增益 JSON 的共用地读取工具。
 *
 * <p>显示名支持两种写法：
 * <pre>
 * "display": "基础算力"                              → 直接文本
 * "display": { "translate": "tech.shjtcore.basic" }  → 翻译键
 * </pre>
 * 之所以不用 {@code Component.Serializer}，是因为它在 1.21.1 上需要 HolderLookup.Provider 参数，
 * 自己解析可以少依赖一个签名。
 */
final class TechJson {

    static Component display(JsonObject obj) {
        return parseDisplay(obj.get("display"));
    }

    private static Component parseDisplay(JsonElement el) {
        if (el == null) {
            return Component.literal("unnamed");
        }
        if (el instanceof JsonPrimitive primitive && primitive.isString()) {
            return Component.literal(primitive.getAsString());
        }
        if (el.isJsonObject()) {
            JsonObject o = el.getAsJsonObject();
            JsonElement tr = o.get("translate");
            if (tr != null && tr.isJsonPrimitive()) {
                return Component.translatable(tr.getAsString());
            }
            JsonElement lit = o.get("text");
            if (lit != null && lit.isJsonPrimitive()) {
                return Component.literal(lit.getAsString());
            }
        }
        return Component.literal("unnamed");
    }

    static String string(JsonObject obj, String key, String fallback) {
        JsonElement el = obj.get(key);
        return el != null && el.isJsonPrimitive() ? el.getAsString() : fallback;
    }

    static long longValue(JsonObject obj, String key, long fallback) {
        JsonElement el = obj.get(key);
        if (el == null || !el.isJsonPrimitive()) {
            return fallback;
        }
        try {
            return el.getAsLong();
        } catch (NumberFormatException e) {
            return fallback;
        }
    }

    static double doubleValue(JsonObject obj, String key, double fallback) {
        JsonElement el = obj.get(key);
        if (el == null || !el.isJsonPrimitive()) {
            return fallback;
        }
        try {
            return el.getAsDouble();
        } catch (NumberFormatException e) {
            return fallback;
        }
    }

    static int intValue(JsonObject obj, String key, int fallback) {
        return (int) longValue(obj, key, fallback);
    }

    static boolean boolValue(JsonObject obj, String key, boolean fallback) {
        JsonElement el = obj.get(key);
        if (el == null || !el.isJsonPrimitive()) {
            return fallback;
        }
        try {
            return el.getAsBoolean();
        } catch (RuntimeException e) {
            return fallback;
        }
    }

    private TechJson() {
    }
}
