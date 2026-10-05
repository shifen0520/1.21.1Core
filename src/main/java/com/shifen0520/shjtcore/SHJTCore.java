package com.shifen0520.shjtcore;

import com.gto.registrylib.RegistryCore;
import com.shifen0520.shjtcore.material.MaterialRegistry;
import com.shifen0520.shjtcore.material.Materials;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(SHJTCore.MODID)
public class SHJTCore {

    public static final String MODID = "shjtcore";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
    public static final RegistryCore REGISTRY = RegistryCore.create(MODID);

    public SHJTCore(IEventBus modEventBus, ModContainer modContainer) {
        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        // 材料系统初始化：只搭建框架（数据类型 + 形态），Materials 内不注册任何材料
        Materials.init();
        // 冻结材料注册表，防止运行期再注册
        MaterialRegistry.freeze();

        LOGGER.info("SHJTech Core loaded: material system ready, 0 materials registered.");
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        // 空白：不往任何创造模式物品栏添加内容
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }
}
