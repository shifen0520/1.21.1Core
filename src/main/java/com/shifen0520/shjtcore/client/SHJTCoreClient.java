package com.shifen0520.shjtcore.client;

import com.shifen0520.shjtcore.SHJTCore;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

/**
 * 客户端入口。用 {@code @Mod(dist = Dist.CLIENT)} 而不是在主类里注册，
 * 是为了让服务端加载时完全不触碰 {@code net.minecraft.client.*} 的类
 * （否则专用服务器会因 NoClassDefFoundError 直接崩）。
 *
 * <p>职责：把材料/方块/流体桶的染色注册挂到 mod 事件总线。
 * RegisterColorHandlersEvent 属于 MOD bus，所以走 modEventBus。
 */
@Mod(value = SHJTCore.MODID, dist = Dist.CLIENT)
public class SHJTCoreClient {

    public SHJTCoreClient(IEventBus modEventBus) {
        modEventBus.addListener(ClientTintSetup::onItemColors);
        modEventBus.addListener(ClientTintSetup::onBlockColors);
    }
}
