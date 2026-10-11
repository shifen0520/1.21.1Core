package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 25 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials25 {

    private Materials25() {
    }

    static void init() {
        MaterialRegistry.register("redstone")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF0000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x340605))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("redstone_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF66565))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x983E3E))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("redstone_front")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEE0000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x930000))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("refinery_gas")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB4B4B4))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6F6F6F))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("reinforced_epoxy_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9ECAAD))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xB1B2A1))
                .forms(MaterialForms.PLATE, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("remnant_erosion_catalyst")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x454545))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2A2A2A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("remnant_spirit_stone_residue")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4F4F4F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x303030))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("reprecipitated_rhodium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD40849))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x83042D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("residual_triniite_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x068B59))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x035637))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("resonarium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x60E8C0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3B8F77))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("resorcinol")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8E2518))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x58160E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("rhenium_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x392857))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x231835))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("rhenium_hassium_thallium_isophtaloylbisdiethylthiourea_hexaf")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8F7718))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x58490E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("rhenium_pentacarbonyl_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3A373B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x59565A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("rhenium_sulfuric_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC0C0EA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x777791))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("rhodium_filter_cake")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x87350C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x532007))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("rhodium_filter_cake_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x87350C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x532007))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("rhodium_nitrate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8C5A0C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x563707))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("rhodium_plated_palladium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD1D1D1))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x000000))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.PLATE_DENSE, MaterialForms.GEAR_SMALL, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("rhodium_rhenium_naquadah")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x944648))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5B2B2C))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("rhodium_salt")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x61200A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3C1306))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("rhodium_salt_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x61200A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3C1306))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("rhodium_sulfate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEEAA55))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x936934))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("rhodium_sulfate_gas")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBD8743))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x755329))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("rhodium_triphenylphosphine_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x776715))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x493F0D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("rhugnor")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA800E2))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x68008C))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("rock_salt")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFEAE1))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xF0C8C8))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("rocket_fuel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBDB78C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x757156))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("rocket_fuel_cn3h7o3")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA636AC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x66216A))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("rocket_fuel_h8n4c2o4")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4AA11B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2D6310))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("rocket_fuel_rp_1")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF321B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E1F10))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("rose_gold")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xECD5B8))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xD85F2D))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("roughly_rhodium_metal")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x594C1A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x372F10))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("rp_1")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF523E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E3226))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("rtm_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x30306B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1D1D42))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.SPRING, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("rubber")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x353529))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x080808))
                .forms(MaterialForms.GEAR, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ruby")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD72310))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x960B6D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD)
                .build();
        MaterialRegistry.register("ruby_slurry")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF6464))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E3E3E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ruridit")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x88B5B9))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4E885C))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.WIRE_FINE)
                .build();
        MaterialRegistry.register("ruthenium_iron_silicon_heusler_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD2D2D2))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9A9A9A))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("ruthenium_tetroxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBEB809))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4E4E4D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("ruthenium_tetroxide_hot")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9B9B9B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x606060))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("ruthenium_tetroxide_lq")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA8A8A8))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x686868))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ruthenium_trinium_americium_neutronate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x897B76))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x00C0FF))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("rutile")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x892506))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x330101))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("salt")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFAFAFA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9B9B9B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("salt_water")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0000C8))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x00007C))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("saltpeter")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE6E6E6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xE6E1CF))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("samarium_chloride_concentrate_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB0C4DE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6D7989))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("samarium_chloride_sodium_chloride_mixture")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC0C0C0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x777777))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
    }
}
