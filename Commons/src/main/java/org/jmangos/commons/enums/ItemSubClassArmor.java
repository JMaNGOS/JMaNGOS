package org.jmangos.commons.enums;

/**
 * 
 * @author MinimaJack
 * 
 */
public enum ItemSubClassArmor {
    MISC,
    CLOTH,
    LEATHER,
    MAIL,
    PLATE,
    BUCKLER,
    SHIELD,
    LIBRAM,
    IDOL,
    TOTEM,
    SIGIL;

    public static final int COUNT_ITEM_SUB_CLASS = 11;

    public static final ItemSubClassArmor get(final int index) {

        if (index < COUNT_ITEM_SUB_CLASS) {
            return values()[index];
        }
        return null;
    }

    public static final ItemSubClassArmor getFirstByMask(final int mask) {
        for (ItemSubClassArmor armor : values()) {
            if ((1 << armor.ordinal() & mask) > 0) {
                return armor;
            }
        }
        return null;
    }
}
