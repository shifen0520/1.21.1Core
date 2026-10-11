package com.shifen0520.shjtcore.material;

/**
 * 元素周期表第 1 段（共 4 段，本段 30 个元素：原子序数 1–30）。
 *
 * <p>与 Materials01… 同理：拆成独立类文件，避免单个类 / 方法字节码过大。
 */
final class PeriodicTablePart01 {

    private PeriodicTablePart01() {
    }

    static PeriodicTable.Element[] elements() {
        return new PeriodicTable.Element[] {
            new PeriodicTable.Element(1, "hydrogen", 1.008, 0x0000B5, 0x000070, PeriodicTable.State.GAS, 0, 0,
                    new MaterialForm[]{MaterialForms.ELEMENT_GAS}),
            new PeriodicTable.Element(2, "helium", 4.0026, 0xFCFF90, 0x9C9E59, PeriodicTable.State.GAS, 4, 0,
                    new MaterialForm[]{MaterialForms.ELEMENT_GAS}),
            new PeriodicTable.Element(3, "lithium", 6.94, 0xD7E7EE, 0xBDC7DB, PeriodicTable.State.SOLID, 454, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(4, "beryllium", 9.0122, 0x73D73D, 0x184537, PeriodicTable.State.SOLID, 1560, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(5, "boron", 10.81, 0xBFFDBF, 0x6D7058, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(6, "carbon", 12.011, 0x333030, 0x221C1C, PeriodicTable.State.SOLID, 4600, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(7, "nitrogen", 14.007, 0x00BFC1, 0x007677, PeriodicTable.State.GAS, 0, 0,
                    new MaterialForm[]{MaterialForms.ELEMENT_GAS}),
            new PeriodicTable.Element(8, "oxygen", 15.999, 0x6688DD, 0x3F5489, PeriodicTable.State.GAS, 85, 0,
                    new MaterialForm[]{MaterialForms.ELEMENT_GAS}),
            new PeriodicTable.Element(9, "fluorine", 18.998, 0x90E050, 0x6CA83C, PeriodicTable.State.GAS, 0, 0,
                    new MaterialForm[]{MaterialForms.ELEMENT_GAS}),
            new PeriodicTable.Element(10, "neon", 20.18, 0xFAB4B4, 0x9B6F6F, PeriodicTable.State.GAS, 0, 0,
                    new MaterialForm[]{MaterialForms.ELEMENT_GAS}),
            new PeriodicTable.Element(11, "sodium", 22.99, 0x7C80FF, 0x2B30A3, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(12, "magnesium", 24.305, 0xD6E3FF, 0x594D19, PeriodicTable.State.SOLID, 923, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(13, "aluminium", 26.982, 0x7DB9D8, 0x56AC9C, PeriodicTable.State.SOLID, 933, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.SPRING, MaterialForms.SPRING_SMALL, MaterialForms.WIRE_FINE, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(14, "silicon", 28.085, 0x707078, 0x10293B, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.FOIL, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(15, "phosphorus", 30.974, 0x77332C, 0x220202, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(16, "sulfur", 32.06, 0xFDFF31, 0xFFB400, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(17, "chlorine", 35.45, 0x1FF01F, 0x17B417, PeriodicTable.State.GAS, 0, 0,
                    new MaterialForm[]{MaterialForms.ELEMENT_GAS}),
            new PeriodicTable.Element(18, "argon", 39.948, 0x00FF00, 0x009E00, PeriodicTable.State.GAS, 0, 0,
                    new MaterialForm[]{MaterialForms.ELEMENT_GAS}),
            new PeriodicTable.Element(19, "potassium", 39.098, 0xD2E1F2, 0x6189B8, PeriodicTable.State.SOLID, 337, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(20, "calcium", 40.078, 0xFFF5DE, 0xA4A4A4, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(21, "scandium", 44.956, 0xB1B2AC, 0x1C3433, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(22, "titanium", 47.867, 0xED8EEA, 0xFF64BC, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(23, "vanadium", 50.942, 0x696D76, 0x240808, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(24, "chromium", 51.996, 0xF3E0EA, 0x441F2E, PeriodicTable.State.SOLID, 2180, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(25, "manganese", 54.938, 0x88A669, 0xCDE1B9, PeriodicTable.State.SOLID, 1519, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.FOIL, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(26, "iron", 55.845, 0xEEEEEE, 0x979797, PeriodicTable.State.SOLID, 1811, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.GEAR_SMALL, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.SPRING, MaterialForms.SPRING_SMALL, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(27, "cobalt", 58.933, 0x5050FA, 0x2D2D7A, PeriodicTable.State.SOLID, 1768, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.WIRE_FINE, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(28, "nickel", 58.693, 0xCCDFF5, 0x59563A, PeriodicTable.State.SOLID, 1728, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(29, "copper", 63.546, 0xE77C56, 0xE4673E, PeriodicTable.State.SOLID, 1358, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.RING, MaterialForms.SPRING, MaterialForms.SPRING_SMALL, MaterialForms.WIRE_FINE, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(30, "zinc", 65.38, 0xEBEBFA, 0x232C30, PeriodicTable.State.SOLID, 693, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.WIRE_FINE, MaterialForms.ELEMENT_LIQUID}),
        };
    }
}
