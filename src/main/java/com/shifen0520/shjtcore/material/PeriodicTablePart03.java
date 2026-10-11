package com.shifen0520.shjtcore.material;

/**
 * 元素周期表第 3 段（共 4 段，本段 30 个元素：原子序数 61–90）。
 *
 * <p>与 Materials01… 同理：拆成独立类文件，避免单个类 / 方法字节码过大。
 */
final class PeriodicTablePart03 {

    private PeriodicTablePart03() {
    }

    static PeriodicTable.Element[] elements() {
        return new PeriodicTable.Element[] {
            new PeriodicTable.Element(61, "promethium", 145.0, 0x814947, 0xD0FF71, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(62, "samarium", 150.36, 0xC2C289, 0x235254, PeriodicTable.State.SOLID, 1345, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ROD_LONG, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(63, "europium", 151.96, 0x20FFFF, 0x429393, PeriodicTable.State.SOLID, 1099, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD_LONG, MaterialForms.FOIL, MaterialForms.SPRING, MaterialForms.WIRE_FINE, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(64, "gadolinium", 157.25, 0x828A7A, 0x363420, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(65, "terbium", 158.93, 0xCEDAB4, 0x263640, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(66, "dysprosium", 162.5, 0x6A664B, 0x423307, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(67, "holmium", 164.93, 0xF6FC9C, 0xA3A3A3, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(68, "erbium", 167.26, 0xECCBDB, 0x5D625A, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(69, "thulium", 168.93, 0x467681, 0x682C2C, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(70, "ytterbium", 173.05, 0xA7A7A7, 0x676767, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(71, "lutetium", 174.97, 0x00CCFF, 0x4C687A, PeriodicTable.State.SOLID, 1925, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(72, "hafnium", 178.49, 0x99999A, 0x2B4A3A, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(73, "tantalum", 180.95, 0xA8A7C6, 0x1F2B20, PeriodicTable.State.SOLID, 3290, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.FOIL, MaterialForms.WIRE_FINE, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(74, "tungsten", 183.84, 0x3B3A32, 0x2A2800, PeriodicTable.State.SOLID, 3695, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.FOIL, MaterialForms.SPRING, MaterialForms.SPRING_SMALL, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(75, "rhenium", 186.21, 0xCBCFD7, 0x37393D, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(76, "osmium", 190.23, 0x54AFFF, 0x6E6EFF, PeriodicTable.State.SOLID, 3306, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.FOIL, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(77, "iridium", 192.22, 0x99FEDE, 0x6CD1CF, PeriodicTable.State.SOLID, 2719, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.GEAR, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.WIRE_FINE, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(78, "platinum", 195.08, 0xFFF4BA, 0x8D8D71, PeriodicTable.State.SOLID, 2041, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.SPRING_SMALL, MaterialForms.WIRE_FINE, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(79, "gold", 196.97, 0xFDF55F, 0xF25833, PeriodicTable.State.SOLID, 1337, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.RING, MaterialForms.FOIL, MaterialForms.SPRING, MaterialForms.SPRING_SMALL, MaterialForms.WIRE_FINE, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(80, "mercury", 200.59, 0xE6DCDC, 0x8E8888, PeriodicTable.State.LIQUID, 0, 13534,
                    new MaterialForm[]{MaterialForms.ELEMENT_FLUID}),
            new PeriodicTable.Element(81, "thallium", 204.38, 0x5D6B8E, 0x815B63, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(82, "lead", 207.2, 0x7E6F82, 0x290633, PeriodicTable.State.SOLID, 600, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.SPRING, MaterialForms.SPRING_SMALL, MaterialForms.WIRE_FINE, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(83, "bismuth", 208.98, 0x5FDDDD, 0x517385, PeriodicTable.State.SOLID, 545, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(84, "polonium", 209.0, 0x163B27, 0x00FF78, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(85, "astatine", 210.0, 0x65204F, 0x17212B, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(86, "radon", 222.0, 0xFF39FF, 0x9E239E, PeriodicTable.State.GAS, 0, 0,
                    new MaterialForm[]{MaterialForms.ELEMENT_GAS}),
            new PeriodicTable.Element(87, "francium", 223.0, 0xAAAAAA, 0x0000FF, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(88, "radium", 226.0, 0x838361, 0x89FF21, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(89, "actinium", 227.0, 0xC3D1FF, 0x397090, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(90, "thorium", 232.04, 0x25411B, 0x051E05, PeriodicTable.State.SOLID, 2023, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.ELEMENT_LIQUID}),
        };
    }
}
