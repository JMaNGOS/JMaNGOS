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
package org.jmangos.commons.enums;

/**
 * The Enum UnitFlags.
 */
public enum UnitFlags {

    /** The UNK_0. */
    UNK_0(1 << 0),

    /** The NON_ATTACKABLE. */
    NON_ATTACKABLE(1 << 1),

    /** The DISABLE_MOVE. */
    DISABLE_MOVE(1 << 2),

    /** The PVP_ATTACKABLE. */
    PVP_ATTACKABLE(1 << 3),

    /** The RENAME. */
    RENAME(1 << 4),

    /** The PREPARATION. */
    PREPARATION(1 << 5),

    /** The UNK_6. */
    UNK_6(1 << 6),

    /** The NOT_ATTACKABLE_1. */
    NOT_ATTACKABLE_1(1 << 7),

    /** The OOC_NOT_ATTACKABLE. */
    OOC_NOT_ATTACKABLE(1 << 8),

    /** The PASSIVE. */
    PASSIVE(1 << 9),

    /** The LOOTING. */
    LOOTING(1 << 10),

    /** The PET_IN_COMBAT. */
    PET_IN_COMBAT(1 << 11),

    /** The PVP. */
    PVP(1 << 12),

    /** The SILENCED. */
    SILENCED(1 << 13),

    /** The UNK_14. */
    UNK_14(1 << 14),

    /** The UNK_15. */
    UNK_15(1 << 15),

    /** The UNK_16. */
    UNK_16(1 << 16),

    /** The PACIFIED. */
    PACIFIED(1 << 17),

    /** The STUNNED. */
    STUNNED(1 << 18),

    /** The IN_COMBAT. */
    IN_COMBAT(1 << 19),

    /** The TAXI_FLIGHT. */
    TAXI_FLIGHT(1 << 20),

    /** The DISARMED. */
    DISARMED(1 << 21),

    /** The CONFUSED. */
    CONFUSED(1 << 22),

    /** The FLEEING. */
    FLEEING(1 << 23),

    /** The PLAYER_CONTROLLED. */
    PLAYER_CONTROLLED(1 << 24),

    /** The NOT_SELECTABLE. */
    NOT_SELECTABLE(1 << 25),

    /** The SKINNABLE. */
    SKINNABLE(1 << 26),

    /** The MOUNT. */
    MOUNT(1 << 27),

    /** The UNK_28. */
    UNK_28(1 << 28),

    /** The UNK_29. */
    UNK_29(1 << 29),

    /** The SHEATHE. */
    SHEATHE(1 << 30),

    /** The UNK_31. */
    UNK_31(1 << 31);

    /** The value. */
    private int value;

    /**
     * Instantiates a new unit flags.
     * 
     * @param flag
     *        the flag
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
