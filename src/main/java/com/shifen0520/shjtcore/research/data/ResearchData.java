package com.shifen0520.shjtcore.research.data;

/**
 * datapack 数据的持有者。
 *
 * <p>不要在 {@code AddReloadListenerEvent} 里把 registry 快照进别处——
 * 那个事件触发时重载还没执行，取到的是空表。正确做法是每次用时都向 loader 现取，
 * 这样 {@code /reload} 之后自动拿到新数据。
 */
public final class ResearchData {

    private static final TechDataLoader TECH = new TechDataLoader();
    private static final BoostDataLoader BOOST = new BoostDataLoader();

    public static TechDataLoader techLoader() {
        return TECH;
    }

    public static BoostDataLoader boostLoader() {
        return BOOST;
    }

    public static TechRegistry techs() {
        return TECH.registry();
    }

    public static BoostRegistry boosts() {
        return BOOST.registry();
    }

    private ResearchData() {
    }
}
