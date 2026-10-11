package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 2 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials02 {

    private Materials02() {
    }

    static void init() {
        MaterialRegistry.register("alumina_fiber_reinforced_aluminum_matrix_composite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE6F5FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xB7D9FF))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD_LONG, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("aluminium_bronze")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFDEAD))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E896B))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("aluminium_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA4C4C6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x65797A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("aluminium_hydride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x315C6E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1E3944))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("aluminium_hydroxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEBEEF0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x919394))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("aluminium_sulfite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD4ECF9))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xA6B9B6))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("aluminium_trifluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB8601A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x723B10))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("aluminum_acetylacetonate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFD700))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E8500))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("aluminum_alloy_2090")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x95E3E2))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6ABED1))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("aluminum_alloy_5a06")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x78E2F2))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4CBFD1))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("aluminum_alloy_7050")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x94D4EE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6ABED1))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("aluminum_alloy_8090")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x518FBE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x38648C))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("aluminum_nitride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4F3C8D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x302557))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("aluminum_oxynitride_glass_ceramic")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xDEDEDE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xA1A1A1))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE)
                .build();
        MaterialRegistry.register("aluminum_reinforced_with_silicon_carbide_particles")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x133E5C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x0D2A3F))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD_LONG, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("aluminum_reinforced_with_silicon_carbide_particles_pre")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x133E5C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x0D2A3F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("alunite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFBD677))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xE11E0A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("amethyst")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCFA0F3))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x734FBC))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD)
                .build();
        MaterialRegistry.register("aminated_fullerene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3842F0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x222894))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("aminophenol")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x784421))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4A2A14))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ammonia")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4465A2))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3F3480))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("ammonium_bifluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x26C6BB))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x177A73))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("ammonium_bifluoride_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCBC5B7))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7D7A71))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ammonium_bromide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF7700))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E4900))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("ammonium_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x60A1C5))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x48619C))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("ammonium_fluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB80926))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x720517))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ammonium_formate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x93BADB))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5B7387))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("ammonium_nitrate_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE1FFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8B9E9E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("ammonium_perrhenate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x161637))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x0D0D22))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("andesite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA8AA9A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x68695F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("andradite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFCE26))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x647D59))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("aniline")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3D7517))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x25480E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("animal_cells")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8C8C43))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x565629))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("annealed_copper")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF2C079))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xE45534))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.WIRE_FINE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("anthracene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x929E92))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5A615A))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("antihydrogen")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x6A5ACD))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x41377F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("antimatter")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9932CC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5E1F7E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("antimony_beryllium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEAEAFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8181BD))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("antimony_pentafluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD5D5BD))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x848475))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("antimony_trichloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBCBCBC))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x747474))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("antimony_trifluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFBEF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xF7EABC))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("antimony_trioxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF5F5FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xC4C4D6))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("antineutron")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE6E6FA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8E8E9B))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("antiproton")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4945AF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2D2A6C))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("apatite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x06CDF1))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x701C07))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.BOLT, MaterialForms.SCREW)
                .build();
        MaterialRegistry.register("aqua_regia")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFB132))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E6D1F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("arceusalloy2b")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x79740E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4B4708))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("arsenic_trioxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF9F3F3))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3B5C66))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("artherium_tin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x551A8B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x341056))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("asbestos")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE6E6E6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xDBD7BF))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
    }
}
