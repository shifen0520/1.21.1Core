package com.shifen0520.shjtcore.research.registry;

import com.shifen0520.shjtcore.BuiltinSHJTCreativeTabs;
import com.shifen0520.shjtcore.SHJTCore;
import com.shifen0520.shjtcore.research.owner.HardDiskItem;
import com.shifen0520.shjtcore.research.owner.IdentityCardItem;
import com.shifen0520.shjtcore.research.owner.ResearchTaskCardItem;

/**
 * 科研系统的物品注册。
 *
 * <p>这里用项目统一的 registrylib（{@code SHJTCore.REGISTRY}）而不是原生 DeferredRegister，
 * 与 {@code Items} / {@code Fluids} 的写法保持一致：lang 和模型都交给 registrylib 在数据生成阶段产出，
 * 所以<b>不要</b>再手写 {@code assets/shjtcore/models/item/identity_card.json}。
 */
public final class ResearchItems {

    public static void register() {
        var card = SHJTCore.REGISTRY.item("identity_card", IdentityCardItem::new);
        card.lang("身份卡");
        card.addTab(BuiltinSHJTCreativeTabs.RESEARCH_KEY);
        card.register();

        // 任务卡：手持右键切换研究目标，与身份卡（长期插在机器上）职责分离
        var taskCard = SHJTCore.REGISTRY.item("research_task_card", ResearchTaskCardItem::new);
        taskCard.lang("科研任务卡");
        taskCard.addTab(BuiltinSHJTCreativeTabs.RESEARCH_KEY);
        taskCard.register();

        // 硬盘四个等级。等级只影响"能刻多少条授权"，门禁校验不看等级。
        registerDisk("basic_disk", HardDiskItem.Tier.T1, "基础硬盘");
        registerDisk("encrypted_disk", HardDiskItem.Tier.T2, "加密硬盘");
        registerDisk("expanded_disk", HardDiskItem.Tier.T3, "扩容硬盘");
        // hard_disk 是旧 id，老存档里刻过盘的物品都指着它。
        // 保留下来当最高级（不限量），老玩家不会因为升级而突然被砍容量。
        registerDisk("hard_disk", HardDiskItem.Tier.T4, "量子硬盘");
    }

    private static void registerDisk(String id, HardDiskItem.Tier tier, String name) {
        var disk = SHJTCore.REGISTRY.item(id, props -> new HardDiskItem(props, tier));
        disk.lang(name);
        disk.addTab(BuiltinSHJTCreativeTabs.RESEARCH_KEY);
        disk.register();
    }

    private ResearchItems() {
    }
}
