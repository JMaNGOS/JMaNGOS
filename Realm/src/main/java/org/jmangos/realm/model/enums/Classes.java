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
 * The Enum WoW Classes.
 * 
 */
public enum Classes {
    
    /** The game class warrior. */
    WARRIOR(1),
    /** The game class paladin. */
    PALADIN(2),
    /** The game class hunter. */
    HUNTER(3),
    /** The game class rogue. */
    ROGUE(4),
    /** The game class priest. */
    PRIEST(5),
    /** The game class death knight. */
    DEATH_KNIGHT(6),
    /** The game class shaman. */
    SHAMAN(7),
    /** The game class mage. */
    MAGE(8),
    /** The game class warlock. */
    WARLOCK(9),
    /** The game class druid. */
    DRUID(11);
    
    /** The value. */
    private int value;
    
    /**
     * Instantiates a new classes.
     * 
     * @param value
     *            the value
     */
    Classes(final int value) {
    
        setValue(value);
    }
    
    /**
     * Sets the value.
     * 
     * @param value
     *            the new value
     */
    public void setValue(final int value) {
    
        this.value = value;
    }
    
    /**
     * Gets the value.
     * 
     * @return the value
     */
    public int getValue() {
    
        return this.value;
    }
    
    /**
     * 
     * @param value
     *            - id value of the class
     * @return Game class
     */
    public static Classes get(final int value) {
    
        for (final Classes val : values()) {
            if (val.getValue() == value) {
                return val;
            }
        }
        
        return null;
    }
}
