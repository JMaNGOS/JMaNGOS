/*******************************************************************************
 * Copyright (C) 2012 JMaNGOS <http://jmangos.org/>
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package org.jmangos.realm.model.unit;

// TODO: Auto-generated Javadoc
/**
 * The Enum UnitFlags.
 */
public enum UnitFlags {
    
    /** The UNI t_ fla g_ un k_0. */
    UNIT_FLAG_UNK_0(1 << 0),
    
    /** The UNI t_ fla g_ no n_ attackable. */
    UNIT_FLAG_NON_ATTACKABLE(1 << 1), // not attackable
    /** The UNI t_ fla g_ disabl e_ move. */
    UNIT_FLAG_DISABLE_MOVE(1 << 2),
    
    /** The UNI t_ fla g_ pv p_ attackable. */
    UNIT_FLAG_PVP_ATTACKABLE(1 << 3), // allow apply pvp rules to attackable state in addition to
                                      // faction dependent state
    /** The UNI t_ fla g_ rename. */
    UNIT_FLAG_RENAME(1 << 4),
    
    /** The UNI t_ fla g_ preparation. */
    UNIT_FLAG_PREPARATION(1 << 5), // don't take reagents for spells with
                                   // SPELL_ATTR_EX5_NO_REAGENT_WHILE_PREP
    /** The UNI t_ fla g_ un k_6. */
    UNIT_FLAG_UNK_6(1 << 6),
    
    /** The UNI t_ fla g_ no t_ attackabl e_1. */
    UNIT_FLAG_NOT_ATTACKABLE_1(1 << 7), // ?? (UNIT_FLAG_PVP_ATTACKABLE |
                                        // UNIT_FLAG_NOT_ATTACKABLE_1) is NON_PVP_ATTACKABLE
    /** The UNI t_ fla g_ oo c_ no t_ attackable. */
    UNIT_FLAG_OOC_NOT_ATTACKABLE(1 << 8), // 2.0.8 - (OOC Out Of Combat) Can not be attacked when
                                          // not in combat. Removed if unit for some reason enter
                                          // combat (flag probably removed for the attacked and it's
                                          // party/group only)
    /** The UNI t_ fla g_ passive. */
    UNIT_FLAG_PASSIVE(1 << 9), // makes you unable to attack everything. Almost identical to our
                               // "civilian"-term. Will ignore it's surroundings and not engage in
                               // combat unless "called upon" or engaged by another unit.
    /** The UNI t_ fla g_ looting. */
    UNIT_FLAG_LOOTING(1 << 10), // loot animation
    /** The UNI t_ fla g_ pe t_ i n_ combat. */
    UNIT_FLAG_PET_IN_COMBAT(1 << 11), // in combat?, 2.0.8
    /** The UNI t_ fla g_ pvp. */
    UNIT_FLAG_PVP(1 << 12), // changed in 3.0.3
    /** The UNI t_ fla g_ silenced. */
    UNIT_FLAG_SILENCED(1 << 13), // silenced, 2.1.1
    /** The UNI t_ fla g_ un k_14. */
    UNIT_FLAG_UNK_14(1 << 14), // 2.0.8
    /** The UNI t_ fla g_ un k_15. */
    UNIT_FLAG_UNK_15(1 << 15),
    
    /** The UNI t_ fla g_ un k_16. */
    UNIT_FLAG_UNK_16(1 << 16), // removes attackable icon
    /** The UNI t_ fla g_ pacified. */
    UNIT_FLAG_PACIFIED(1 << 17), // 3.0.3 ok
    /** The UNI t_ fla g_ stunned. */
    UNIT_FLAG_STUNNED(1 << 18), // 3.0.3 ok
    /** The UNI t_ fla g_ i n_ combat. */
    UNIT_FLAG_IN_COMBAT(1 << 19),
    
    /** The UNI t_ fla g_ tax i_ flight. */
    UNIT_FLAG_TAXI_FLIGHT(1 << 20), // disable casting at client side spell not allowed by taxi
                                    // flight (mounted?), probably used with 0x4 flag
    /** The UNI t_ fla g_ disarmed. */
    UNIT_FLAG_DISARMED(1 << 21), // 3.0.3, disable melee spells casting..., "Required melee weapon"
                                 // added to melee spells tooltip.
    /** The UNI t_ fla g_ confused. */
    UNIT_FLAG_CONFUSED(1 << 22),
    
    /** The UNI t_ fla g_ fleeing. */
    UNIT_FLAG_FLEEING(1 << 23),
    
    /** The UNI t_ fla g_ playe r_ controlled. */
    UNIT_FLAG_PLAYER_CONTROLLED(1 << 24), // used in spell Eyes of the Beast for pet... let attack
                                          // by controlled creature
    /** The UNI t_ fla g_ no t_ selectable. */
    UNIT_FLAG_NOT_SELECTABLE(1 << 25),
    
    /** The UNI t_ fla g_ skinnable. */
    UNIT_FLAG_SKINNABLE(1 << 26),
    
    /** The UNI t_ fla g_ mount. */
    UNIT_FLAG_MOUNT(1 << 27),
    
    /** The UNI t_ fla g_ un k_28. */
    UNIT_FLAG_UNK_28(1 << 28),
    
    /** The UNI t_ fla g_ un k_29. */
    UNIT_FLAG_UNK_29(1 << 29), // used in Feing Death spell
    /** The UNI t_ fla g_ sheathe. */
    UNIT_FLAG_SHEATHE(1 << 30),
    
    /** The UNI t_ fla g_ un k_31. */
    UNIT_FLAG_UNK_31(1 << 31); // set skinnable icon and also changes color of portrait
    
    /** The value. */
    private int value;
    
    /**
     * Instantiates a new unit flags.
     * 
     * @param flag
     *            the flag
     */
    UnitFlags(final int flag) {
    
        this.value = flag;
    }
    
    /**
     * Gets the value.
     * 
     * @return the value
     */
    public int getValue() {
    
        return this.value;
    }
}
