package com.shifen0520.shjtcore.research;

import com.shifen0520.shjtcore.SHJTCore;
import net.minecraft.resources.ResourceLocation;

/**
 * 全项目唯一的 id 工厂 + 常量表。
 *
 * <p><b>为什么 id 只能在这里产生</b>：MMCR 的 master 分支跑在 MC 26.1.2 上，用的是
 * {@code net.minecraft.resources.Identifier}；而本项目目标是 <b>MC 1.21.1</b>，
 * 同一个类在 1.21.1 里叫 {@link ResourceLocation}。如果全项目到处写这个类型名，
 * 换版本时要改几十处。集中到这里之后，只需要改这一个文件的 import。
 *
 * <p>DataStore 的 key 也集中在这里，避免字符串散落各处拼错。
 */
public final class ResearchIds {

    /** 直接引用主类常量，避免 modid 有两份真相。 */
    public static final String MODID = SHJTCore.MODID;

    // ------------------------------------------------------------------ id 工厂

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    /** 生成指向其他命名空间（如 minecraft）的 id。 */
    public static ResourceLocation of(String namespace, String path) {
        return ResourceLocation.fromNamespaceAndPath(namespace, path);
    }

    public static ResourceLocation mc(String path) {
        return of("minecraft", path);
    }

    /** 从字符串解析 "namespace:path"。 */
    public static ResourceLocation parse(String value) {
        return ResourceLocation.parse(value);
    }

    // ------------------------------------------------------------------ MMCR 机器 id

    /** 算力节点：直 Tick 机器，消耗能量产出 tfps，向科研中心（或算力路由器）上报。 */
    public static final ResourceLocation COMPUTE_NODE = id("compute_node");

    /**
     * 算力路由器：算力网络的中间层，汇总多台算力节点后转发给科研中心。
     *
     * <p>两个网络端口：0 号口接节点（收），1 号口接科研中心（发）。
     * 节点与路由器用<b>同一个</b> {@link #REPORT_TFPS} 请求 id，
     * 所以节点代码不需要为路由器做任何改动。
     */
    public static final ResourceLocation COMPUTE_ROUTER = id("compute_router");

    /** 科研中心：接收算力上报，汇总后交给 ResearchService 推进研究。 */
    public static final ResourceLocation RESEARCH_CENTER = id("research_center");

    /** 受科技门禁的示例机器。 */
    public static final ResourceLocation QUANTUM_ASSEMBLER = id("quantum_assembler");

    /** 算力上报请求 id（生产者和中心必须用同一个）。 */
    public static final ResourceLocation REPORT_TFPS = id("report_tfps");

    // ------------------------------------------------------------------ DataStore key

    /** 每个生产者的算力桶前缀，后面接发送方 hash。 */
    public static final String KEY_TFPS = "tfps_";

    /** 每个生产者的心跳桶前缀。内置网络中心只有 hash 清理、没有时间戳，
     *  导致断电的机器会留下僵尸算力，这里补上 TTL。 */
    public static final String KEY_SEEN = "seen_";

    /** 队伍 id 缓存（避免每次都解析一遍身份卡）。 */
    public static final String KEY_TEAM = "team";

    /** 屏幕行：预计剩余时间。 */
    public static final ResourceLocation LINE_ETA = id("line_eta");

    // ------------------------------------------------------------------ 科研中心屏幕状态缓存
    // 查 FTB 任务进度、解析身份卡、遍历科技树都不便宜，这些活降频做一次，
    // 结果写进下面三个 key，屏幕每 tick 只读缓存渲染。丢了会自动重算。

    /** 当前研究目标的科技 id。key 不存在 = 没有可研究的了（全部完成）。 */
    public static final String KEY_STATUS_TECH = "status_tech";

    /** 当前研究目标已完成的研究点数。 */
    public static final String KEY_STATUS_DONE = "status_done";

    /**
     * 没有研究目标时的<b>具体原因</b>，避免把"没选目标"误显示成"全部完成"。
     * <ul>
     *     <li>{@code 0}：正在研究（{@link #KEY_STATUS_TECH} 有值）</li>
     *     <li>{@code 1}：科技表里的科技<b>确实全部</b>解锁了</li>
     *     <li>{@code 2}：还有未解锁的科技，只是当前<b>没选研究目标</b></li>
     * </ul>
     */
    public static final String KEY_STATUS_IDLE = "status_idle";

    /** 队伍当前的限时算力增益（tfps）。 */
    public static final String KEY_STATUS_BOOST = "status_boost";

    /**
     * 本周期该队伍的<b>有效研究速率</b>（tfps），已被 rateScale 乘过、加上增益。
     *
     * <p>专门用来算 ETA。屏幕每 tick 都要显示剩余时间，而真值只在
     * {@code ResearchService} 的推进周期里算一次；缓存下来让屏幕零成本读，
     * 又不至于和 {@code tick} 里用的数脱节（两者是同一个 {@link #KEY_RATE}）。
     */
    public static final String KEY_RATE = "rate";

    /** 屏幕 / Jade 文本行 id。 */
    public static final ResourceLocation LINE_TFPS = id("line_tfps");
    /** 网络连接数"已用/上限"。密钥卡报"没有可用的网络容量"时，看这行就知道是不是连满了。 */
    public static final ResourceLocation LINE_LINKS = id("line_links");
    public static final ResourceLocation LINE_TECH = id("line_tech");
    public static final ResourceLocation LINE_PROGRESS = id("line_progress");
    public static final ResourceLocation LINE_BOOST = id("line_boost");
    public static final ResourceLocation LINE_GATE = id("line_gate");
    /** 诊断：能量输入是否够（FE/t）。 */
    public static final ResourceLocation LINE_ENERGY = id("line_energy");
    /** 诊断：物品持有量 vs 需求量。用 {@link #lineStock(int)} 区分行，不要共用一个 id。 */
    public static final ResourceLocation LINE_STOCK = id("line_stock");

    /**
     * 原料诊断行 id（每种物品一行）。
     *
     * <p><b>为什么要带 slot 索引</b>：屏幕文本按 id 存储，同一个 id 重复 append 会
     * <b>后者覆盖前者</b>。之前钻石和红石都用 {@link #LINE_STOCK}，
     * 结果钻石那行被红石覆盖凭空消失，诊断工具自己骗人。
     */
    public static ResourceLocation lineStock(int slot) {
        return id("line_stock_" + slot);
    }
    /** 诊断：物品输出接口是否存在。 */
    public static final ResourceLocation LINE_OUTPUT = id("line_output");
    /** 诊断：配方池里到底有几条配方（MMCR 静默丢弃配方的高发点）。 */
    public static final ResourceLocation LINE_RECIPE = id("line_recipe");
    /** 诊断：MMCR 内部的真实加工状态与失败原因（反射读 internal 包，权威判据）。 */
    public static final ResourceLocation LINE_RUNTIME = id("line_runtime");

    // ------------------------------------------------------------------ datapack 目录

    /** 科技定义目录：data/<ns>/research/tech/*.json */
    public static final String DIR_TECH = "research/tech";

    /** 增益定义目录：data/<ns>/research/boost/*.json */
    public static final String DIR_BOOST = "research/boost";

    // ------------------------------------------------------------------ 示例科技 id

    public static final ResourceLocation TECH_BASIC_COMPUTING = id("basic_computing");
    public static final ResourceLocation TECH_QUANTUM_THEORY = id("quantum_theory");

    private ResearchIds() {
    }
}
