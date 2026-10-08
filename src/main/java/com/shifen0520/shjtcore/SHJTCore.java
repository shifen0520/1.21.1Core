package com.shifen0520.shjtcore;

import com.gto.registrylib.RegistryCore;
import com.shifen0520.shjtcore.material.MaterialRegistry;
import com.shifen0520.shjtcore.material.Materials;
import com.shifen0520.shjtcore.research.command.ResearchCommand;
import com.shifen0520.shjtcore.research.data.ResearchData;
import com.shifen0520.shjtcore.research.ftb.ResearchTaskBinder;
import com.shifen0520.shjtcore.research.registry.ResearchItems;
import com.shifen0520.shjtcore.research.service.ResearchService;
import com.shifen0520.shjtcore.research.team.ResearchSaveData;
import net.minecraft.server.MinecraftServer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.AddReloadListenerEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SHJTech Core —— 1.21.1 空白模板。
 *
 * <p>材料注册系统由 26.1.2 版本移植而来（保留 Material / MaterialRegistry /
 * MaterialForm / MaterialForms / data / form / render 整套框架），
 * 但按需求“什么都不注册，作为空白”：不注册任何材料、物品、方块、流体、机器。
 *
 * <p>前置：registrylib（{@code com.gto:registrylib-neoforge-1.21.1:8.0.16}，modId=registrylib）。
 */
@Mod(SHJTCore.MODID)
public class SHJTCore {

    public static final String MODID = "shjtcore";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
    public static final RegistryCore REGISTRY = RegistryCore.create(MODID);

    public SHJTCore(IEventBus modEventBus, ModContainer modContainer) {
        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        // AddReloadListenerEvent 是游戏（NeoForge）总线事件，不能挂到 mod 总线
        NeoForge.EVENT_BUS.addListener(this::addReloadListeners);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        // 1) 创造模式标签页：materials / fluids / blocks / research
        BuiltinSHJTCreativeTabs.init();
        // 2) 材料系统：数据类型 → 形态 → 118 元素 + 1665 化合物/合金
        Materials.init();
        // 3) 把材料落成真实物品/方块/流体
        Items.register();
        Fluids.register();
        // 4) 科研系统物品（身份卡）
        ResearchItems.register();
        // 4.5) MMCR 机器 / 结构 / 配方由 BuItiInProvider 通过 @EventBusSubscriber 自注册
        // 5) 全部注册完成后再冻结材料注册表，防止运行期增删
        MaterialRegistry.freeze();

        LOGGER.info("SHJTech Core loaded: {} materials registered.",
                MaterialRegistry.registered().size());
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        // 空白：不往任何创造模式物品栏添加内容
    }

    /** 科研系统的科技 / 增益定义走 datapack，只需要把 loader 挂上去。 */
    private void addReloadListeners(AddReloadListenerEvent event) {
        event.addListener(ResearchData.techLoader());
        event.addListener(ResearchData.boostLoader());
    }

    /**
     * FTB 的 {@code setMaxProgress} 是运行时设置、不会写进任务书文件，
     * 所以每次服务器启动都要重新绑一次。
     */
    @SubscribeEvent
    public void onServerStarted(ServerStartedEvent event) {
        MinecraftServer server = event.getServer();
        ResearchTaskBinder.bindAll(server, ResearchService.techs(), ResearchSaveData.get(server));
    }

    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event) {
        ResearchCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }
}
