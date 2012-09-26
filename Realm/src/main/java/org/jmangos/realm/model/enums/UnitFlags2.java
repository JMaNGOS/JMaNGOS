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
package org.jmangos.realm.model.enums;

/**
 * The Enum UnitFlags.
 */
public enum UnitFlags2 {
    
    /** The UNIT_FLAG2_FEIGN_DEATH. */
    UNIT_FLAG2_FEIGN_DEATH(1 << 0),
    
    /** The UNIT_FLAG2_UNK1. */
    UNIT_FLAG2_UNK1(1 << 1),
    
    /** The UNIT_FLAG2_UNK2. */
    UNIT_FLAG2_UNK2(1 << 2),
    
    /** The UNIT_FLAG2_COMPREHEND_LANG. */
    UNIT_FLAG2_COMPREHEND_LANG(1 << 3),
    
    /** The UNIT_FLAG2_CLONED. */
    UNIT_FLAG2_CLONED(1 << 4),
    
    /** The UNIT_FLAG2_UNK5. */
    UNIT_FLAG2_UNK5(1 << 5),
    
    /** The UNIT_FLAG2_FORCE_MOVE. */
    UNIT_FLAG2_FORCE_MOVE(1 << 6),
    
    /** The UNIT_FLAG2_DISARM_OFFHAND. */
    UNIT_FLAG2_DISARM_OFFHAND(1 << 7),
    
    /** The UNIT_FLAG2_UNK8. */
    UNIT_FLAG2_UNK8(1 << 8),
    
    /** The UNIT_FLAG2_UNK9. */
    UNIT_FLAG2_UNK9(1 << 9),
    
    /** The UNIT_FLAG2_DISARM_RANGED. */
    UNIT_FLAG2_DISARM_RANGED(1 << 10),
    
    /** The UNIT_FLAG2_REGENERATE_POWER. */
    UNIT_FLAG2_REGENERATE_POWER(1 << 11);
    
    /** The value. */
    private int value;
    
    /**
     * Instantiates a new unit flags.
     * 
     * @param flag
     *            the flag
     */
    UnitFlags2(final int flag) {
    
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
