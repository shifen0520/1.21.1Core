package com.shifen0520.shjtcore.material;

import com.shifen0520.shjtcore.material.data.MaterialDataTypes;

/**
 * 材料注册第 8 段（共 34 段，本段 50 个材料）。
 *
 * <p>拆成独立类而不是一个大类里的多个方法，是为了避开 JVM 单方法 64KB 字节码上限，
 * 同时让 1665 个材料的注册代码按文件分布，便于定位与增量修改。
 */
final class Materials08 {

    private Materials08() {
    }

    static void init() {
        MaterialRegistry.register("cyan_dye")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x00FFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x009E9E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("cyclohexane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE8B113))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x602A10))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("cyclohexanone_oxime")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xEBEBF0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x919194))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("cyclooctadiene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD4E982))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x839050))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("cycloparaphenylene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x000000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x000000))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("cyclopentadiene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x2AA62A))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1A661A))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("cyclopentadienyl_titanium_trichloride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xB22DB2))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6E1B6E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("dalisenite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA4AC11))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x656A0A))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.FOIL, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("damascus_steel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x6E6E6E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x302222))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("dark_ash")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x8B8989))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x555353))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("dark_matter_bound_nodes")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3C3C5C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x282832))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("dark_steel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x414751))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x282C32))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("debrominated_brine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xAB8C6D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6A5643))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("decaborane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x95B78F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5C7158))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("deepslate")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x797979))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2F2F37))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("degenerate_rhenium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4646FF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2B2B9E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("deglycerated_soap")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFB000))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E6D00))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("dense_hydrazine_fuel_mixture")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x4A223B))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2D1524))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("dense_neutron")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9CE89C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x608F60))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("depleted_uranium_alloy")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x444B42))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x2A2E28))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.LIQUID)
                .build();
        MaterialRegistry.register("depleted_uranium_hexafluoride")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x74BA66))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x47733F))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("desh")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xF2A057))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x966335))
                .forms(MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE_DENSE)
                .build();
        MaterialRegistry.register("deuterium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD0E8F0))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x808F94))
                .forms(MaterialForms.GAS)
                .build();
        MaterialRegistry.register("diamagnetic_residues")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x30845E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1D513A))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("diaminobenzidine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x337D59))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1F4D37))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("diaminodiphenylmethanmixture")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x94851D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5B5211))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("diamond")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC8FFFF))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7C9E9E))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.BOLT, MaterialForms.SCREW)
                .build();
        MaterialRegistry.register("diatomite")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xFFFAFA))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x9E9B9B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("dibenzyltetraacetylhexaazaisowurtzitane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x64704D))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x3E452F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("dibismuthhydroborat")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x007D32))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x004D1F))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("diborane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xBEEBCD))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x75917F))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("dibromoacrolein")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x3E3E3E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x262626))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("dibromomethylbenzene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x06B584))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x037051))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("dichlorobenzene")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x004455))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x002A34))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("dichlorobenzidine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA1DEA6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x638966))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("dichlorocyclooctadieneplatinium")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD4E982))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x839050))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("dichlorodicyanobenzoquinone")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x302399))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1D155E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("dichlorodicyanohydroquinone")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x302399))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x1D155E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("dichlorodiphenylsulfone")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x7ACF7F))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x4B804E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("dichloroethane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xAFC979))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6C7C4B))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("dichloromethane")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x832663))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x51173D))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("diesel")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC8A040))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7C6327))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("diethyl_ether")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x9AB0B2))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x5F6D6E))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("diethyleneglycol")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xADADAD))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x6B6B6B))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("diethylenetriamine")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xA9D9A7))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x688667))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("diethylenetriamine_pentaacetonitrile")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCBBFD6))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x7D7684))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("diethylenetriaminepentaacetic_acid")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xE8C93C))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0xC99118))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
        MaterialRegistry.register("diethylthiourea")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x23A687))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x156653))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("difluoroaniline")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0x348F3E))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x205826))
                .forms(MaterialForms.FLUID)
                .build();
        MaterialRegistry.register("difluorobenzophenone")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xCF51AE))
                .data(MaterialDataTypes.SECONDARY_COLOR.rgb(0x80326B))
                .forms(MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY)
                .build();
    }
}
