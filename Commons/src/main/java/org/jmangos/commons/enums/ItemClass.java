package org.jmangos.commons.enums;

/**
 * 
 * @author MinimaJack
 * 
 */
public enum ItemClass {
    CONSUMABLE,
    CONTAINER,
    WEAPON,
    GEM,
    ARMOR,
    REAGENT,
    PROJECTILE,
    TRADE_GOODS,
    GENERIC,
    RECIPE,
    MONEY,
    QUIVER,
    QUEST,
    KEY,
    PERMANENT,
    MISC,
    GLYPH;

    public static final int COUNT_ITEM_CLASS = 17;

    public static final ItemClass get(final int index) {

        if (index < COUNT_ITEM_CLASS) {
            return values()[index];
        }
        return null;
    }

}
