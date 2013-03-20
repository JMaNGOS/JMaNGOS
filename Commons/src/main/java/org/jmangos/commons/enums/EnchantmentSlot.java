package org.jmangos.commons.enums;

/**
 * 
 * @author MinimaJack
 * 
 */
public enum EnchantmentSlot {
    PERM((byte) 0),
    TEMP((byte) 1),
    SOCK_1((byte) 2),
    SOCK_2((byte) 3),
    SOCK_3((byte) 4),
    BONUS((byte) 5),
    PRISMATIC((byte) 6), // added at apply special permanent enchantment
    PROP_0((byte) 7), // used with RandomSuffix
    PROP_1((byte) 8), // used with RandomSuffix
    PROP_2((byte) 9), // used with RandomSuffix and RandomProperty
    PROP_3((byte) 10), // used with RandomProperty
    PROP_4((byte) 11); // used with RandomProperty

    public static final byte MAX_INSPECTED_ENCHANTMENT_SLOT = 7;
    private byte slot;

    EnchantmentSlot(final byte givenSlot) {

        this.slot = givenSlot;
    }

    /**
     * @return the slot
     */
    public final byte getSlot() {

        return this.slot;
    }

    /**
     * @param slot
     *        the slot to set
     */
    public final void setSlot(final byte slot) {

        this.slot = slot;
    }

    public static EnchantmentSlot get(final byte value) {

        for (final EnchantmentSlot it : values()) {
            if (it.getSlot() == value) {
                return it;
            }
        }
        return null;
    }
}
