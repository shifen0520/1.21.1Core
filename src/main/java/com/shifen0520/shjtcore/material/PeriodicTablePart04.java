package com.shifen0520.shjtcore.material;

/**
 * 元素周期表第 4 段（共 4 段，本段 28 个元素：原子序数 91–118）。
 *
 * <p>与 Materials01… 同理：拆成独立类文件，避免单个类 / 方法字节码过大。
 */
final class PeriodicTablePart04 {

    private PeriodicTablePart04() {
    }

    static PeriodicTable.Element[] elements() {
        return new PeriodicTable.Element[] {
            new PeriodicTable.Element(91, "protactinium", 231.04, 0xA78B6D, 0x675643, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(92, "uranium", 238.03, 0x1D891D, 0x33342C, PeriodicTable.State.SOLID, 1405, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(93, "neptunium", 237.0, 0x284D7B, 0x182F4C, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(94, "plutonium", 244.0, 0xBA2727, 0x222730, PeriodicTable.State.SOLID, 913, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(95, "americium", 243.0, 0x287869, 0x184A41, PeriodicTable.State.SOLID, 1449, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.ROD, MaterialForms.FOIL, MaterialForms.WIRE_FINE, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(96, "curium", 247.0, 0x7B544E, 0x4C3430, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(97, "berkelium", 247.0, 0x645A88, 0x3E3754, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(98, "californium", 251.0, 0xA85A12, 0x68370B, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(99, "einsteinium", 252.0, 0xCE9F00, 0x7F6200, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(100, "fermium", 257.0, 0xC99FE7, 0x890085, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(101, "mendelevium", 258.0, 0x1D4ACF, 0x112D80, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(102, "nobelium", 259.0, 0x3E4758, 0x43DEFF, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(103, "lawrencium", 266.0, 0x5D7575, 0x394848, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(104, "rutherfordium", 267.0, 0x6B6157, 0xFFF6A1, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(105, "dubnium", 268.0, 0xC7DDDE, 0x00F3FF, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(106, "seaborgium", 269.0, 0x19C5FF, 0xFF19B2, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(107, "bohrium", 270.0, 0xDE67FF, 0xDC57FF, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(108, "hassium", 269.0, 0x738786, 0x62FFD5, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(109, "meitnerium", 278.0, 0x4F3C82, 0x6E90FF, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(110, "darmstadtium", 281.0, 0x578062, 0x354F3C, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.BLOCK, MaterialForms.INGOT, MaterialForms.NUGGET, MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY, MaterialForms.PLATE, MaterialForms.PLATE_DENSE, MaterialForms.GEAR_SMALL, MaterialForms.ROD, MaterialForms.ROD_LONG, MaterialForms.BOLT, MaterialForms.SCREW, MaterialForms.ELEMENT_LIQUID}),
            new PeriodicTable.Element(111, "roentgenium", 282.0, 0x388C48, 0x198A92, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(112, "copernicium", 285.0, 0x565C5D, 0xFFD34B, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(113, "nihonium", 286.0, 0x323957, 0xBFABFF, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(114, "flerovium", 289.0, 0x2A384E, 0xD2FF00, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(115, "moscovium", 290.0, 0x2A1B40, 0xBD91FF, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(116, "livermorium", 293.0, 0x939393, 0xFF5E5E, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(117, "tennessine", 294.0, 0x785CC4, 0x7959D4, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
            new PeriodicTable.Element(118, "oganesson", 294.0, 0x443936, 0xFF1DBD, PeriodicTable.State.SOLID, 0, 0,
                    new MaterialForm[]{MaterialForms.DUST, MaterialForms.DUST_SMALL, MaterialForms.DUST_TINY}),
        };
    }
}
