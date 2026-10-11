package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 21 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials21 {

    private Materials21() {
    }

    static void init() {
        MaterialRegistry.register("olivine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA7E404))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x166439))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD)
                .build();
        MaterialRegistry.register("opal")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF9E3EA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x16BBE0))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD)
                .build();
        MaterialRegistry.register("orange_dye")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF8000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E4F00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("organic_molecule")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x00FF00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x009E00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("orichalcum")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF78C9))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E4A7C))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.NANITES, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("origin_core_crystal_residue")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF2E8C6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x968F7A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("osmiridium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x47ADB6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x241A44))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("osmium_oxide_metal")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4E748F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x304758))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("osmium_tetroxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x578D9F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x394117))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("ostrum")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE5939B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8D5B60))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE_DENSE)
                .build();
        MaterialRegistry.register("oxalic_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA0FFA0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x639E63))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("oxide_dispersion_strengthened_nickel_base_superalloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x43A75C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2E7F3F))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.ROD_LONG, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("oxide_dispersion_strengthened_nickel_based_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x106643))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x0A3A28))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD_LONG, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("oxidized_residual_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2CD3CB))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1B827D))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("oxidized_residues")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x330D4A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1F082D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("oxydianiline")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFD700))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E8500))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ozone")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0176C4))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x004979))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("p507")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFF00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9E00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("p_nitroaniline")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCC9037))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7E5922))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("p_phenylenediamine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xDCCF52))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x888032))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("paa")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEAD05E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x91803A))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("palladium_fullerene_matrix")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x96B4B4))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5D6F6F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("palladium_metal")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBD92B5))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x535B14))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("palladium_raw")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5D4E1A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x33352D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("paper")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF9F9F9))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xECECEC))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE)
                .build();
        MaterialRegistry.register("para_benzoquinone")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCF7CA0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x804C63))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("paracetamol")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF2EDCB))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x96927D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("paramagnetic_residues")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x25788B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x164A56))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("partially_oxidized_residues")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8F1515))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x580D0D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("pcb_coolant")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD5D69C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x848460))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("pcbs")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x758A61))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x48553C))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("pentaerythritol")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xACACAC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6A6A6A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("pentlandite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE3CF13))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x29315B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("pentlandite_front")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCDAA7D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7F694D))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("perfluorobenzene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x15752B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x0D481A))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("perfluorooctanesulfonic_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0D7F7F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x084E4E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("perfluorosulfonic_acid_polytetrafluoroethylene_copolymer")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFD0DDF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9C088A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.FOIL)
                .build();
        MaterialRegistry.register("periodicium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3D4BF6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x252E98))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("perlite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEEE0E0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xC1B9A9))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("phenol")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x784421))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4A2A14))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("phenolic_resin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7F4503))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4E2A01))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("phenylenedioxydiacetic_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7C4456))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4C2A35))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("phenylpentanoic_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4D3833))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2F221F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("phenylsodium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2626AB))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x17176A))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("phosgene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0E6C11))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x08420A))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("phosphate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE8DABD))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xA48B56))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("phosphoric_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xDCDC01))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x888800))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("phosphoric_acid_chromium_phosphate_cement")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8A9A5B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x555F38))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("phosphoric_acid_magnesium_phosphate_cement")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFE135))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E8B20))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("phosphorus_free_samarium_concentrate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD3D3D3))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x828282))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
    }
}
