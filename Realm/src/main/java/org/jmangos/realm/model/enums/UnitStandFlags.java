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
 * The Enum UnitStandFlags.
 */
public enum UnitStandFlags {
    
    /** The UNK1. */
    UNK1(1 << 0),
    
    /** The CREEP. */
    CREEP(1 << 1),
    
    /** The UNK3. */
    UNK3(1 << 2),
    
    /** The UNK4. */
    UNK4(1 << 3),
    
    /** The UNK5. */
    UNK5(1 << 4),
    
    /** The ALL. */
    ALL(0xFF);
    
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
