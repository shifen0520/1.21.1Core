package com.shifen0520.shjtcore.research.mmcr;

import cn.howxu.mmcr.publicapi.Machines;
import cn.howxu.mmcr.publicapi.behavior.TickContext;
import cn.howxu.mmcr.publicapi.data.DataKey;
import cn.howxu.mmcr.publicapi.data.DataStore;
import cn.howxu.mmcr.publicapi.event.RegisterMachineDefinitionsEvent;
import cn.howxu.mmcr.publicapi.machine.MachineSpec;
import cn.howxu.mmcr.publicapi.network.NetworkPortView;
import cn.howxu.mmcr.publicapi.network.Networks;
import cn.howxu.mmcr.publicapi.network.NodeView;
import cn.howxu.mmcr.publicapi.network.RequestPayload;
import cn.howxu.mmcr.publicapi.presentation.TextScope;
import cn.howxu.mmcr.publicapi.recipe.IoDirection;
import cn.howxu.mmcr.publicapi.recipe.requirement.Requirements;
import cn.howxu.mmcr.publicapi.runtime.IoTransaction;
import com.shifen0520.shjtcore.research.ResearchIds;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.Map;

/**
 * 算力节点（生产者）：每 tick 耗电，每 20 tick 结算一次算力并上报给科研中心。
 *
 * <p><b>注册方式</b>：机器定义由 {@code BuItiInProvider} 统一调用（ServiceLoader），本类<b>不挂</b>
 * {@code @EventBusSubscriber}。结构已迁到 KubeJS 定义，见
 * {@code kubejs/server_scripts/mmcr/structrue/compute_node.js}。要新增同类机器，改 {@code BuItiInProvider} 一处即可。
 *
 * <p><b>为什么必须自带一台</b>：MMCR 内置的 {@code network_producer_machine} 只
 * {@code allowNetworkMachine(mmcr:network_center_machine)}，而 {@code allowNetworkMachine}
 * 是<b>发送方</b>的硬校验，内置生产者永远不可能把算力发到我们的科研中心。
 * 抢注内置 id 会破坏其他内容，所以这里自己注册一台。
 *
 * <p><b>可以直连科研中心，也可以先接算力路由器</b>：{@code allowNetworkMachine}
 * 同时声明了 {@link ResearchIds#COMPUTE_ROUTER}，且两者用同一个请求 id，
 * 所以"把线接到路由器还是直接接中心"是纯玩法选择，节点代码不用改。
 */
public final class ComputeNodeMachine {

    /** 每 tick 耗电（FE）。 */
    private static final long FE_PER_TICK = 100L;
    /** 每多少 tick 结算一次算力并上报。 */
    private static final int REPORT_PERIOD = 20;
    /** 有电时每周期产出多少 tfps。 */
    private static final double TFPS_POWERED = 20.0;
    /** 缺电时的保底产出。 */
    private static final double TFPS_IDLE = 0.0;
    /** 上报体里的字段名；科研中心的 {@code onReport} 必须用同一个字符串。 */
    private static final String FIELD_TFPS = "tfps";
    /** 把自己最近一次产出缓存进 DataStore 的 key（屏幕/Jade 之外的调试用）。 */
    private static final String KEY_SELF_TFPS = "self_tfps";

    private static final ResourceLocation LINE_STATE = ResearchIds.id("compute_node_state");

    /**
     * 网络连接数上限，必须与 {@code networkInterface(1, MAX_CONNECTIONS)} 一致。
     *
     * <p><b>故意保持 1</b>：节点只允许接一条线（中心<b>或</b>路由器，二选一）。
     * 放开会让同一份算力被两条路径各记一次——中心直接收一次、路由器转发后再收一次，
     * 屏幕上算力翻倍却看不出原因。所以这里不调大，改成把"已连接 N/1"显示出来，
     * 玩家就不会把"我需要改接线"误判成"机器坏了"。
     */
    private static final int MAX_CONNECTIONS = 1;

    /**
     * 机器定义。由 {@code MachineDefinitionProvider} 调用，<b>不要</b>加 {@code @SubscribeEvent}。
     */
    public static void registerDefinitions(RegisterMachineDefinitionsEvent event) {
        if (event.definitions().containsKey(ResearchIds.COMPUTE_NODE)) {
            return;
        }
        MachineSpec machine = Machines.machine(ResearchIds.COMPUTE_NODE)
                .recipePool(ResearchIds.COMPUTE_NODE)
                .displayNameKey("machine.shjtcore.compute_node")
                .appearance(a -> a.machineBasicBlock(ResearchIds.mc("white_concrete")))
                .networkInterface(1, MAX_CONNECTIONS)
                // 目标可以是科研中心，也可以是算力路由器。两者用同一个 REPORT_TFPS
                // 请求 id 和同一个 onReport 分桶逻辑，所以节点这边**完全不用改代码**，
                // 只需要把线接到不同的机器上。
                .allowNetworkMachine(ResearchIds.RESEARCH_CENTER)
                .allowNetworkMachine(ResearchIds.COMPUTE_ROUTER)
                .allowModifiers(false)
                .tickBehavior(behavior -> behavior.serverTick(ComputeNodeMachine::tick))
                .build();
        event.registerMachine(machine);
    }

    private static void tick(TickContext ctx) {
        IoTransaction energy = ctx.ioPlan();
        energy.addInput(Requirements.energy(IoDirection.INPUT, FE_PER_TICK));
        boolean powered = energy.simulate().energySatisfied() && energy.commit().successful();

        double tfps = powered ? TFPS_POWERED : TFPS_IDLE;

        // 接口 / 连接都可能不存在（还没接上线、或者对端拆了），按内置机器的写法逐层判空
        List<NetworkPortView> interfaces = Networks.interfaces(ctx);

        ctx.screenText().append(TextScope.OPERATION, LINE_STATE,
                Component.translatable(powered ? "machine.shjtcore.compute_node.powered"
                        : "machine.shjtcore.compute_node.no_power", tfps));
        // 节点只允许一条连接（MAX_CONNECTIONS = 1）。密钥卡报"没有可用的网络容量"，
        // 大半是这里已经占了位——玩家需要先断开旧线再改接路由器，屏幕上写出来就不用猜。
        int links = countConnections(interfaces);
        ctx.screenText().append(TextScope.OPERATION, ResearchIds.LINE_LINKS,
                Component.translatable(links >= MAX_CONNECTIONS
                                ? "machine.shjtcore.compute_node.linked"
                                : "machine.shjtcore.compute_node.unlinked",
                        links, MAX_CONNECTIONS));
        ctx.jadeText().append(LINE_STATE, Component.literal(tfps + " tfps"));

        if (!ctx.isDue(REPORT_PERIOD)) {
            return;
        }

        if (interfaces == null || interfaces.isEmpty()) {
            return;
        }
        NetworkPortView iface = interfaces.get(0);
        List<NodeView> connections = iface.connections();
        if (connections == null || connections.isEmpty()) {
            return;
        }
        NodeView target = connections.get(0);

        DataStore storage = ctx.dataStorage();
        if (storage != null) {
            storage.set(KEY_SELF_TFPS, DataKey.of(tfps));
        }
        try {
            Networks.sendRequest(iface, target, ResearchIds.REPORT_TFPS,
                    RequestPayload.of(Map.of(FIELD_TFPS, DataKey.of(tfps))));
        } catch (IllegalArgumentException e) {
            // 目标不在连接表里时 sendRequest 会同步抛异常，这里忽略（下个周期再试）
        }
    }

    private ComputeNodeMachine() {
    }

    /** 该机器所有网络接口上的连接总数，口径与 MMCR 的容量判定一致（遍历全部接口）。 */
    private static int countConnections(List<NetworkPortView> interfaces) {
        if (interfaces == null) {
            return 0;
        }
        int n = 0;
        for (NetworkPortView iface : interfaces) {
            List<NodeView> nodes = iface.connections();
            if (nodes != null) {
                n += nodes.size();
            }
        }
        return n;
    }
}
