/**
 * 
 */
package org.jmangos.commons.enums;

/**
 * @author MinimaJack
 * 
 */
public enum SpellFamily {
    GENERIC,
    UNK1,                            // events, holidays
    UNUSED,
    MAGE,
    WARRIOR,
    WARLOCK,
    PRIEST,
    DRUID,
    ROGUE,
    HUNTER,
    PALADIN,
    SHAMAN,
    UNK2,                          // 2 spells (silence resistance)
    POTION,
    UNUSED2,
    DEATHKNIGHT,
    UNUSED3,
    PET;

    public static final int MAX_SPELL_FAMILY = 18;

    public static final SpellFamily get(int value) {
        if (value < MAX_SPELL_FAMILY) {
            return values()[value];
        }
        return null;
    }
}
