package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 4 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials04 {

    private Materials04() {
    }

    static void init() {
        MaterialRegistry.register("biomediumraw")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x42641F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x283E13))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("biotin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3E9743))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x265D29))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("biotite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x343B34))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x121200))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("biphenyl")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8B8C4F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x565630))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("bipyridine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3FA5BF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2D3C2E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("bis_cyclopentadienyl_hafnium_oxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x1F281F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2D3C2E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("bisethylenedithiotetraselenafulvalene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x72CB00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x467D00))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("bisethylenedithiotetraselenafulvalene_perrhenate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x72CB00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x467D00))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("bismuth_bronze")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFD26F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x895F3D))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("bismuth_germanate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4EA839))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x306823))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("bismuth_nitrate_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA4A7A8))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x656768))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("bismuth_tellurite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x004222))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x002815))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("bisphenol_a")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD4AA00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x836900))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("black_bronze")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8B7C70))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4B3D32))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("black_dwarf_mtter")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2A2A30))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1A1A1D))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.NANITES, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("black_dye")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x202020))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x131313))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("black_steel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x666666))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1A120E))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.ROD, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("black_titanium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3D0021))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x250014))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("blaze")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFF94D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xFF330C))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("blazecube")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF8030))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E4F1D))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("blood")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA2000A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x640006))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("blood_cells")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xAD1B00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6B1000))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("blood_plasma")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA85B00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x683800))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("bloodstone")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD80036))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x850021))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("blue_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x64B4FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3C7DBA))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("blue_dye")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0020FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x00139E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("blue_steel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x779AC6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x191948))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.ROD, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("blue_topaz")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xDBFEFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xA0C4D7))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD)
                .build();
        MaterialRegistry.register("bone")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFCFBED))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xA0A38B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("borane_dimethyl_sulfide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCEA67D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7F664D))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("borax")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFAFAFA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xD7E7E7))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("boric_acide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8FBC8F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x587458))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("bornite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFE05A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x442602))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("borocarbide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7E7E22))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4E4E15))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("boron_carbide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x1E1E1E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x121212))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("boron_carbide_ceramics")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2B2B31))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1A1A1E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("boron_carbide_composite_protective_ceramic")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3D3715))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x29270F))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE)
                .build();
        MaterialRegistry.register("boron_fluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCECAD0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7F7D80))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("boron_francium_carbide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x797979))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4B4B4B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("boron_trifluoride_acetate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x991062))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5E093C))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("boron_trioxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8FA6B5))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x586670))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("borosilicate_fiber_reinforced_aluminum_matrix_composite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF6FFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xB7F1F1))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD_LONG, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("borosilicate_glass")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFAFAFA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xFAF5C0))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("brass")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFE36E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x935828))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("brevibacterium_flavium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x667532))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3F481F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("brick")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC76245))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2D1610))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("brominated_chlorine_vapor")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBB9B72))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x736046))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("bromine_trifluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA88E57))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x685835))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("bromo_succinimide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x546A21))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x344114))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("bromobutane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF0C0C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E0707))
                .forms(MaterialForms.FLUID)
                .build();
    }
}
