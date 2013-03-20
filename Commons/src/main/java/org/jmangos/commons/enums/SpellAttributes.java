/**
 * 
 */
package org.jmangos.commons.enums;

/**
 * @author MinimaJack
 * 
 */
public enum SpellAttributes {
    UNK0(0x00000001), // 0
    RANGED(0x00000002), // 1 All ranged abilites have this flag
    ON_NEXT_SWING_1(0x00000004), // 2 on next swing
    UNK3(0x00000008), // 3 not set in 3.0.3
    ABILITY(0x00000010), // 4 isAbility
    TRADESPELL(0x00000020), // 5 trade spells, will be added by client to a
                            // sublist of profession spell
    PASSIVE(0x00000040), // 6 Passive spell
    HIDDEN_CLIENTSIDE(0x00000080), // 7 can't be linked in chat?
    HIDE_IN_COMBAT_LOG(0x00000100), // 8 hide created item in tooltip (for effect=24)
    TARGET_MAINHAND_ITEM(0x00000200), // 9
    ON_NEXT_SWING_2(0x00000400), // 10 on next swing 2
    UNK11(0x00000800), // 11
    DAYTIME_ONLY(0x00001000), // 12 only useable at daytime, not set in 2.4.2
    NIGHT_ONLY(0x00002000), // 13 only useable at night, not set in 2.4.2
    INDOORS_ONLY(0x00004000), // 14 only useable indoors, not set in 2.4.2
    OUTDOORS_ONLY(0x00008000), // 15 Only useable outdoors.
    NOT_SHAPESHIFT(0x00010000), // 16 Not while shapeshifted
    ONLY_STEALTHED(0x00020000), // 17 Must be in stealth
    UNK18(0x00040000), // 18
    LEVEL_DAMAGE_CALCULATION(0x00080000), // 19 spelldamage depends on caster
                                          // level
    STOP_ATTACK_TARGET(0x00100000), // 20 Stop attack after use this spell (and
                                    // not begin attack if use)
    IMPOSSIBLE_DODGE_PARRY_BLOCK(0x00200000), // 21 Cannot be
                                              // dodged/parried/blocked
    SET_TRACKING_TARGET(0x00400000), // 22 SetTrackingTarget
    UNK23(0x00800000), // 23 castable while dead?
    CASTABLE_WHILE_MOUNTED(0x01000000), // 24 castable while mounted
    DISABLED_WHILE_ACTIVE(0x02000000), // 25 Activate and start cooldown after
                                       // aura fade or remove summoned creature
                                       // or go
    UNK26(0x04000000), // 26
    CASTABLE_WHILE_SITTING(0x08000000), // 27 castable while sitting
    CANT_USED_IN_COMBAT(0x10000000), // 28 Cannot be used in combat
    UNAFFECTED_BY_INVULNERABILITY(0x20000000), // 29 unaffected by
                                               // invulnerability (hmm possible
                                               // not...)
    ATTR_BREAKABLE_BY_DAMAGE(0x40000000), // 30 breakable by damage?
    CANT_CANCEL(0x80000000);// 31 positive aura can't be canceled

    private int value;

    SpellAttributes(int value) {

        this.value = value;
    }

    /**
     * @return the value
     */
    public final int getValue() {

        return this.value;
    }

    /**
     * @param value
     *        the value to set
     */
    public final void setValue(int value) {

        this.value = value;
    }

    public final boolean contains(final int value) {

        return (this.getValue() & value) == this.getValue();
    }

    public static final String getAllInString(int value) {
        StringBuilder sb = new StringBuilder();
        for (SpellAttributes attr : values()) {
            if ((attr.getValue() & value) == attr.getValue()) {
                sb.append(attr).append(" ");
            }
        }
        return sb.toString();
    }
}
