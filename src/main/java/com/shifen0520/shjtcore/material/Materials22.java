package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 22 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials22 {

    private Materials22() {
    }

    static void init() {
        MaterialRegistry.register("phosphorus_pentachloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBE3F0D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x752708))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("phosphorus_pentasulfide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE7A123))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8F6315))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("phosphorus_pentoxide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE89188))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x220202))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("phosphorus_trichloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD5D54B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x84842E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("photonic_kristallite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFCFCFD))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1E1E1E))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.FOIL, MaterialForms.NANITES, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("photopolymer")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x73445B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x472A38))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("photoresist")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2F4F4F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1D3030))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("phototuning_agent")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEFE8EF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2D3C2E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("phthalic_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD1D1D1))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x818181))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("phthalic_anhydride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8C8C8C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x565656))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("pickled_electronic_grade_silicon")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x414151))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x282832))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("pikyonium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x244780))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x162C4F))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("pink_dye")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFC0C0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E7777))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("piranha_solution")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xAC2FFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6A1D9E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("pitchblende")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFD647))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x0D1E2F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("plasma_quenched_beads")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF27878))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xC65050))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("platinum_front")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCDC9A5))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7F7C66))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("platinum_group_sludge")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x343228))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x001E00))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("platinum_manganese_antimony_heusler_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE6E6E6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xB3B3B3))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("platinum_metal")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFF4BA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x8D8D71))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("platinum_raw")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA09A7B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4E4E45))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("platinum_rhodium_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEDEFE7))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xE4E4E4))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("platinum_slag")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x343318))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x201F0E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("platinum_sludge_residue")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5E4B40))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4B403D))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("pluripotency_induction_gene_plasmids")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x569907))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x355E04))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("pluripotency_induction_gene_therapy_fluid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x800C4F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4F0730))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("plutonium_241")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF4C4C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x222730))
                .data(MaterialDataTypes.MELTING_POINT.value(913))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("plutonium_beryllium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF4C4C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x222730))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("pollucite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEED9E1))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x72A6A7))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("polous_polyolefin_sulfonate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFF00))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9E00))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.FOIL)
                .build();
        MaterialRegistry.register("poly_aluminium_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF3FFE5))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x969E8D))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("poly_dopamine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x0D7F0D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x084E08))
                .forms(MaterialForms.PLATE, MaterialForms.FOIL, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("poly_vinyl_bpy_rhenium_carbonyl_hexafluorophosphate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x262631))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3B3B46))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.FOIL)
                .build();
        MaterialRegistry.register("polyacrylonitrile")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8F8D3C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x585725))
                .forms(MaterialForms.PLATE, MaterialForms.FOIL, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("polybenzimidazole")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x464441))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x382E1B))
                .forms(MaterialForms.FOIL, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("polycaprolactam")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3F3D2D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x43432E))
                .forms(MaterialForms.PLATE, MaterialForms.FOIL, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("polychlorinated_biphenyl")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCACC0E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7D7E08))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("polycyclic_aromatic_mixture")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8F7718))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x58490E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("polydimethylsiloxane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF5F5F5))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9D9FA1))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("polyetheretherketone")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x33334D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1F1F2F))
                .forms(MaterialForms.WIRE_FINE, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("polyethylene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC8C8C8))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7C7C7C))
                .forms(MaterialForms.FOIL, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("polyimide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF6730))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E3F1D))
                .forms(MaterialForms.PLATE, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("polyphenylene_sulfide")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x5E5E08))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2C373C))
                .forms(MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.FOIL, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("polystyrene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC6C6C6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7A7A7A))
                .data(MaterialDataTypes.MELTING_POINT.value(240))
                .forms(MaterialForms.FOIL, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("polytetrafluoroethylene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x6E6E6E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x202020))
                .forms(MaterialForms.PLATE, MaterialForms.FOIL, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("polyurethane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xACF4BF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6A9776))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("polyurethaneresin")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9A9A51))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5F5F32))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("polyvinyl_acetate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF9955))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E5E34))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("polyvinyl_butyral")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3E7051))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x535648))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("polyvinyl_chloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFF9955))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6CA5BF))
                .forms(MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.FLUID)
                .build();
    }
}
