package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 13 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials13 {

    private Materials13() {
    }

    static void init() {
        MaterialRegistry.register("glowstone")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFCB34C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xCE7533))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("glucose")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCACACE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7D7D7F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("glucose_iron_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC9C9C9))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7C7C7C))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("glue")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD8C4A0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x857963))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("gluons")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFBFBF9))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9B9B9A))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("glutamine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x948635))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5B5320))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("glycerol")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x87DE87))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x538953))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("glyceryl_trinitrate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD8D8A0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x858563))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("glycolonitrile")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5B8C8F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x385658))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("glyoxal")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF0ED4D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x94922F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("goethite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x97873A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x313131))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("gold_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCCCC66))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7E7E3F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("gold_cyanide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x736F50))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x474431))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("gold_depleted_molybdenite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x757587))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x484853))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("gold_trifluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE8C478))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8F794A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("granite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD69077))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x71352C))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("granite_red")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF0080))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E004F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("granitic_mineral_sand")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD69077))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x71352C))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("graphene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x808080))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3D3838))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.FOIL)
                .build();
        MaterialRegistry.register("graphene_gel_suspension")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x535353))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x333333))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("graphene_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x535353))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x333333))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("graphite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA8A89E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x172602))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("graphite_copper_composite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x534F17))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3A3611))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD_LONG, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("graphite_copper_composite_pre")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x534F17))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3A3611))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("gray_dye")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x808080))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F4F4F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("grcop84")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE5D8AA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xB7A97D))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("green_dye")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x00FF00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x009E00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("green_sapphire")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9AE6B0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x64C882))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD)
                .build();
        MaterialRegistry.register("green_sapphire_slurry")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x64C882))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3E7C50))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("grisium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x355D6A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x203941))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("grossular")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFB777))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x856F48))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("grossular_front")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD2691E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x824112))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("gunpowder")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA4A4A4))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x767676))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("gypsum")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFAEC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x71570A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("hafnium_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5C5C69))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x393941))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("hafnium_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3C3C3C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x252525))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("harmony_residue")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8A7BA6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x554C66))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("hassium_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5828B2))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x36186E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("hastelloy_c_276")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xAB2F2F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6A1D1D))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("hastelloy_n")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xAAAAAA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x696969))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("hastelloy_n_75")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8B6914))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x56410C))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("hastelloy_x")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5784B8))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x355172))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("hastelloyk_243")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x92D959))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5A8637))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("hastelloyx_78")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3C5B7F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x25384E))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("heavily_fluorinated_trinium_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x169A33))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x0D5F1F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("heavy_diamagnetic_residues")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x22316A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x151E41))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("heavy_ferromagnetic_residues")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x26743E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x174726))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("heavy_fuel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA07830))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x634A1D))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("heavy_lepton_mixture")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3AD931))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x23861E))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("heavy_metallic_residues")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x1C0986))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x110553))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
    }
}
