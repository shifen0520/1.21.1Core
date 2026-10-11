package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 5 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials05 {

    private Materials05() {
    }

    static void init() {
        MaterialRegistry.register("bromodihydrothiine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x50C44D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x31792F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("bronze")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFC370))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x806752))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("brown_dye")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x604000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3B2700))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("butadiene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB55A10))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x703709))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("butane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB6371E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x702212))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("butane_1_4_diol")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC4534C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x79332F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("butene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCF5005))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x803103))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("butyl_lithium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9F6AF6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x624198))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("butyraldehyde")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x554A3F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x342D27))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("cadmium_sulfide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD4BA19))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x83730F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("cadmium_tungstate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x757770))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x484945))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("caesium_fluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF7A5F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E4B3A))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("caesium_hydroxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD7D7D7))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x858585))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("caesium_iodide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEEEEE2))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x93938C))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("caesium_nitrate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x821EC7))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x50127B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("caesium_xenontrioxide_fluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5067D7))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x313F85))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("calcite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFEF8))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xBBAF62))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("calcium_48")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFF5DE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xA4A4A4))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("calcium_carbide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x47443E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2C2A26))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("calcium_carbonate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD9CA9C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xAD913B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("calcium_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xE7E7D7))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("calcium_ferrocyanide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC9A842))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x947110))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("calcium_hydroxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x72DBD4))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x138A80))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("calcium_oxide_ceramic")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF1F3FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x95969E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("calcium_phosphide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFF5DE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xF6BABA))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("californium_252")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA85A12))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x68370B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("californium_cyclopentadienide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x78374A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4A222D))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("californium_trichloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x286224))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x183C16))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("calorite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE65757))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8E3535))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE_DENSE)
                .build();
        MaterialRegistry.register("caprolactam")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFEF8))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xBAB7A2))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("carbon_dioxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA9D0F5))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x688097))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("carbon_disulfide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x104E8B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x093056))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("carbon_fiber_epoxy_composite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8D8C31))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5E5D21))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD_LONG, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("carbon_fiber_peek_composite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3A3A3A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x262626))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD_LONG, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("carbon_fiber_phenolic_resin_composite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x531E1E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x361414))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD_LONG, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("carbon_fiber_polyimide_composite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC68430))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8B5420))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD_LONG, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("carbon_fiber_polyphenylene_sulfide_composite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x24221D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x171614))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD_LONG, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("carbon_fiber_reinforced_epoxy_composite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x225B27))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x163A18))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD_LONG, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("carbon_monoxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0E4880))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x082C4F))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("carbon_nanotube_coated_phase_change_microbeads")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2B2D30))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1A1B1D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("carbon_nanotube_reinforced_aluminum_matrix_composite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x1AAD94))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x0D7F66))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ROD_LONG, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("carbon_nanotube_reinforced_nickel_matrix_composite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x1C7212))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x104D0A))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ROD_LONG, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("carbon_nanotubes")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x000000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x000000))
                .forms(MaterialForms.FOIL, MaterialForms.WIRE_FINE, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("carbon_tetrachloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0E9000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x085900))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("carbon_tetrafluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9E9E))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("cascade_mfpc")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x303030))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1D1D1D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("cassiterite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x89847E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3B3B35))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("cassiterite_sand")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x89847E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3B3B35))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("catalase")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBD577E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x75354E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ce_ox_poly_dopamine_reinforced_polytetrafluoroethylene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0D7F7F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x084E4E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.FOIL)
                .build();
    }
}
