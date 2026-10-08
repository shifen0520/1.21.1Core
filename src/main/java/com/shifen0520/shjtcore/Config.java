package com.shifen0520.shjtcore;

import java.util.List;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue LOG_DIRT_BLOCK = BUILDER
            .comment("Whether to log the dirt block on common setup")
            .define("logDirtBlock", true);

    public static final ModConfigSpec.IntValue MAGIC_NUMBER = BUILDER
            .comment("A magic number")
            .defineInRange("magicNumber", 42, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.ConfigValue<String> MAGIC_NUMBER_INTRODUCTION = BUILDER
            .comment("What you want the introduction message to be for the magic number")
            .define("magicNumberIntroduction", "The magic number is... ");

    // a list of strings that are treated as resource locations for items
    public static final ModConfigSpec.ConfigValue<List<? extends String>> ITEM_STRINGS = BUILDER
            .comment("A list of items to log on common setup.")
            .defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), () -> "", Config::validateItemName);

    // ------------------------------------------------------------------
    // 科研系统（MMCR 算力 → FTB 任务进度 → 解锁科技 → 机器门禁）
    // ------------------------------------------------------------------

    public static final ModConfigSpec.IntValue RESEARCH_PERIOD_TICKS = BUILDER
            .comment("科研系统：算力聚合与 FTB 进度写入周期（tick）。调大可减轻服务端压力。")
            .defineInRange("research.periodTicks", 20, 1, 1200);

    public static final ModConfigSpec.DoubleValue RESEARCH_POINTS_PER_TFPS_SECOND = BUILDER
            .comment("科研系统：1 tfps 运行 1 秒折算的研究点数。")
            .defineInRange("research.pointsPerTfpsSecond", 1.0, 0.0, 1_000_000.0);

    public static final ModConfigSpec.IntValue RESEARCH_CONTRIBUTION_TTL = BUILDER
            .comment("科研系统：贡献心跳存活 tick 数。机器停机或区块卸载超时后停止计入算力。")
            .defineInRange("research.contributionTtl", 60, 1, 72000);

    public static final ModConfigSpec.IntValue RESEARCH_BOOST_SCAN_PERIOD = BUILDER
            .comment("科研系统：限时增益发放扫描周期（tick）。")
            .defineInRange("research.boostScanPeriod", 80, 1, 72000);

    public static final ModConfigSpec.BooleanValue RESEARCH_DEBUG_LOG = BUILDER
            .comment("科研系统：输出调试日志。")
            .define("research.debugLog", false);

    static final ModConfigSpec SPEC = BUILDER.build();

    private static boolean validateItemName(final Object obj) {
        return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(itemName));
    }
}
