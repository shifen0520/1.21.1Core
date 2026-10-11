package com.shifen0520.shjtcore.research.gate;

import cn.howxu.mmcr.publicapi.behavior.MachineContext;
import cn.howxu.mmcr.publicapi.presentation.TextScope;
import com.shifen0520.shjtcore.research.ResearchIds;
import com.shifen0520.shjtcore.research.data.TechDefinition;
import com.shifen0520.shjtcore.research.data.TechRegistry;
import com.shifen0520.shjtcore.research.db.ResearchDatabase;
import com.shifen0520.shjtcore.research.owner.HardDiskItem;
import com.shifen0520.shjtcore.research.owner.OwnerResolver;
import com.shifen0520.shjtcore.research.service.ResearchService;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.item.ItemStack;

import java.util.Set;
import java.util.UUID;

/**
 * 科技门禁。在<b>你自己注册的 MMCR 机器</b>里调一行就能拦住未解锁的科技。
 *
 * <pre>
 * // 配方机器：在配方启动前取消
 * .recipeBehavior(h -&gt; h.beforeStart(ctx -&gt; {
 *     if (!TechGate.allow(ctx.machineContext(), TECH_X)) ctx.cancel();
 * }))
 *
 * // 直驱机器（纯 tick，无配方）：在 tick 开头返回
 * .tickBehavior(h -&gt; h.serverTick(ctx -&gt; {
 *     if (!TechGate.allow(ctx, TECH_X)) return;
 * }))
 * </pre>
 *
 * <p><b>⚠ 上面的两种写法只能二选一，绝不能同时出现在同一台机器上。</b>
 * {@code recipeBehavior} 与 {@code tickBehavior} 是<b>互斥的行为模式</b>，
 * MMCR 文档原文：「后一次模式配置可替换前一次」。
 * 在配方机器上顺手加一个 {@code tickBehavior}（哪怕只是想做诊断），
 * 会把整台机器切成"纯 tick 机器"，<b>配方加工被彻底关闭且不报任何错</b>——
 * 表现为配方、能量、原料、输出全部正常，机器却永远 IDLE。
 * 配方机器需要周期诊断请用顶层 {@code .postServerTick(ctx -&gt; ...)}，
 * 它是配方模式专用的顶层钩子。
 *
 * <p><b>作用域是诚实的</b>：只能管我们自己注册的机器。MMCR 内置机器的定义改不了，
 * 对它们只能做"软门禁"——把高级配方和中间产物只放进自有机器的配方池。
 *
 * <p>另外注意：{@code Requirements.level(...)} 是<b>硬件等级</b>（由结构方块材质决定，
 * 类似格雷的电压分级），跟"玩家是否解锁科技"无关，别拿它当科技门禁。
 */
public final class TechGate {

    /** 全部科技都已解锁才放行；任一未解锁就拦下并写提示。 */
    public static boolean allow(MachineContext ctx, ResourceLocation... techIds) {
        MinecraftServer server = ctx.level().getServer();
        if (server == null) {
            return false;
        }

        UUID teamId = OwnerResolver.resolveTeam(ctx);
        if (teamId == null) {
            hint(ctx, Component.translatable("message.shjtcore.research.gate.no_card"));
            return false;
        }

        TechRegistry registry = ResearchService.techs();
        for (ResourceLocation tech : techIds) {
            if (ResearchService.isUnlocked(server, teamId, tech)) {
                continue;
            }
            TechDefinition def = registry.get(tech);
            Component name = def == null ? Component.literal(tech.toString()) : def.display();
            hint(ctx, Component.translatable("message.shjtcore.research.gate.locked", name));
            return false;
        }
        return true;
    }

    /** 放行但不写提示（用于只想知道状态的场合）。 */
    public static boolean check(MachineContext ctx, ResourceLocation tech) {
        MinecraftServer server = ctx.level().getServer();
        if (server == null) {
            return false;
        }
        UUID teamId = OwnerResolver.resolveTeam(ctx);
        return teamId != null && ResearchService.isUnlocked(server, teamId, tech);
    }

    /**
     * 基于<b>硬盘</b>的门禁：从升级总线读硬盘，校验它已写入授权、且授权数据库里该队伍确实被授权。
     *
     * <p>与 {@link #allow(MachineContext, ResourceLocation...)} 的区别：这里不依赖身份卡 / FTB 长链，
     * 机器只看升级总线里的硬盘，比对授权数据库。研究完成会自动写库，玩家把授权从库"刻"进硬盘后放进机器即可。
     *
     * @return 全部科技都被硬盘授权 → true；否则写提示并 return false
     */
    public static boolean allowWithDisk(MachineContext ctx, ResourceLocation... techIds) {
        MinecraftServer server = ctx.level().getServer();
        if (server == null) {
            return false;
        }

        // 1) 升级总线里必须有一张硬盘
        ItemStack disk = null;
        for (ItemStack stack : ctx.upgradeItems()) {
            if (!stack.isEmpty() && HardDiskItem.isHardDisk(stack)) {
                disk = stack;
                break;
            }
        }
        if (disk == null) {
            hint(ctx, Component.translatable("message.shjtcore.research.gate.no_disk"));
            return false;
        }
        if (!HardDiskItem.isWritten(disk)) {
            hint(ctx, Component.translatable("message.shjtcore.research.gate.disk_not_written"));
            return false;
        }

        // 2) 硬盘记录的授权 + 数据库交叉校验
        UUID team = HardDiskItem.getTeam(disk);
        Set<ResourceLocation> diskAuth = HardDiskItem.getAuth(disk);
        ResearchDatabase db = ResearchDatabase.get(server);
        TechRegistry registry = ResearchService.techs();

        for (ResourceLocation tech : techIds) {
            if (team != null && diskAuth.contains(tech) && db.isAuthorized(team, tech)) {
                continue;
            }
            TechDefinition def = registry.get(tech);
            Component name = def == null ? Component.literal(tech.toString()) : def.display();
            hint(ctx, Component.translatable("message.shjtcore.research.gate.disk_no_auth", name));
            // 区分"没研究出来"和"研究出来了但盘装不下"——分级硬盘之后
            // 后者才是最常见的失败原因，不说清楚玩家会以为要去重新做研究
            if (team != null && db.isAuthorized(team, tech) && !diskAuth.contains(tech)) {
                hint(ctx, Component.translatable("message.shjtcore.research.gate.disk_full",
                        HardDiskItem.capacityTextOf(disk)));
            }
            return false;
        }
        return true;
    }

    private static void hint(MachineContext ctx, Component text) {
        ctx.screenText().append(TextScope.OPERATION, ResearchIds.LINE_GATE, text);
        ctx.jadeText().append(ResearchIds.LINE_GATE, text);
    }

    private TechGate() {
    }
}
