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
 * The Enum UnitStandFlags.
 */
public enum UnitStandFlags {
    
    /** The UNI t_ stan d_ flag s_ un k1. */
    UNIT_STAND_FLAGS_UNK1(1 << 0),
    
    /** The UNI t_ stan d_ flag s_ creep. */
    UNIT_STAND_FLAGS_CREEP(1 << 1),
    
    /** The UNI t_ stan d_ flag s_ un k3. */
    UNIT_STAND_FLAGS_UNK3(1 << 2),
    
    /** The UNI t_ stan d_ flag s_ un k4. */
    UNIT_STAND_FLAGS_UNK4(1 << 3),
    
    /** The UNI t_ stan d_ flag s_ un k5. */
    UNIT_STAND_FLAGS_UNK5(1 << 4),
    
    /** The UNI t_ stan d_ flag s_ all. */
    UNIT_STAND_FLAGS_ALL(0xFF);
    
    /** The flag. */
    private int flag;
    
    /**
     * Instantiates a new unit stand flags.
     * 
     * @param flag
     *            the flag
     */
    UnitStandFlags(final int flag) {
    
        this.flag = flag;
    }
    
    /**
     * Gets the value.
     * 
     * @return the value
     */
    public int getValue() {
    
        return this.flag;
    }
}
