package com.shifen0520.shjtcore.material;

/**
 * 元素周期表第 2 段（共 4 段，本段 30 个元素：原子序数 31–60）。
 *
 * <p>与 Materials01… 同理：拆成独立类文件，避免单个类 / 方法字节码过大。
 */
final class PeriodicTablePart02 {

    private PeriodicTablePart02() {
    }

    static PeriodicTable.Element[] elements() {
        return new PeriodicTable.Element[] {
            new PeriodicTable.Element(31, "gallium", 69.723, 0x7A84CA, 0x13132E, PeriodicTable.State.SOLID, 303, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.FOIL, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(32, "germanium", 72.63, 0x4A4A4A, 0x2D2612, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(33, "arsenic", 74.922, 0x9C9C8D, 0x676756, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ELEMENT_GAS}),
            new PeriodicTable.Element(34, "selenium", 78.971, 0xFFDF77, 0x055D28, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(35, "bromine", 79.904, 0x912200, 0x080101, PeriodicTable.State.LIQUID, 0, 3120,
                    new MaterialForm[]{MaterialForms.ELEMENT_FLUID}),
            new PeriodicTable.Element(36, "krypton", 83.798, 0x80FF80, 0x4F9E4F, PeriodicTable.State.GAS, 0, 0,
                    new MaterialForm[]{MaterialForms.ELEMENT_GAS}),
            new PeriodicTable.Element(37, "rubidium", 85.468, 0xDE0F0F, 0x3A1F1F, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(38, "strontium", 87.62, 0x7A7953, 0x4C0B06, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(39, "yttrium", 88.906, 0x7D8072, 0x15161A, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(40, "zirconium", 91.224, 0xB99B7E, 0x271813, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(41, "niobium", 92.906, 0xB494B4, 0x4B3F4D, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(42, "molybdenum", 95.95, 0xC1C1CE, 0x404068, PeriodicTable.State.SOLID, 2896, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.FOIL, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(43, "technetium", 98.0, 0x7430E1, 0x7430E1, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(44, "ruthenium", 101.07, 0xA2CDE0, 0x3C7285, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.GEAR, MaterialForms.FOIL, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(45, "rhodium", 102.91, 0xFD46B1, 0xDC0C58, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.WIRE_FINE, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(46, "palladium", 106.42, 0xBD92B5, 0x535B14, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.FOIL, MaterialForms.WIRE_FINE, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(47, "silver", 107.87, 0xDCDCFF, 0x5A4705, PeriodicTable.State.SOLID, 1235, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.WIRE_FINE, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(48, "cadmium", 112.41, 0x636377, 0x431A34, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(49, "indium", 114.82, 0x5C3588, 0x2B0B4A, PeriodicTable.State.SOLID, 430, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(50, "tin", 118.71, 0xFAFEFF, 0x4E676C, PeriodicTable.State.SOLID, 505, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.SPRING, MaterialForms.SPRING_SMALL, MaterialForms.WIRE_FINE, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(51, "antimony", 121.76, 0xEAEAFF, 0x8181BD, PeriodicTable.State.SOLID, 904, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(52, "tellurium", 127.6, 0x8FEA66, 0x00BFFF, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(53, "iodine", 126.9, 0x3E4467, 0x021E40, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(54, "xenon", 131.29, 0x00FFFF, 0x009E9E, PeriodicTable.State.GAS, 0, 0,
                    new MaterialForm[]{MaterialForms.ELEMENT_GAS}),
            new PeriodicTable.Element(55, "caesium", 132.91, 0xD1821C, 0x231F14, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(56, "barium", 137.33, 0xEDE192, 0xA7AD4D, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(57, "lanthanum", 138.91, 0xD17D50, 0x4A3560, PeriodicTable.State.SOLID, 1193, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(58, "cerium", 140.12, 0x87917D, 0x5E6458, PeriodicTable.State.SOLID, 1068, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(59, "praseodymium", 140.91, 0x718060, 0x3F3447, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(60, "neodymium", 144.24, 0x6C5863, 0x2C1919, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.ELEMENT_LIQUID}),
        };
    }
}
