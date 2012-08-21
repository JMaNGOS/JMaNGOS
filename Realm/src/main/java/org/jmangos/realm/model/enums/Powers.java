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
 * The Enum Powers.
 */
public enum Powers {
    
    /** The MANA. */
    MANA(0),
    
    /** The RAGE. */
    RAGE(1),
    
    /** The FOCUS. */
    FOCUS(2),
    
    /** The ENERGY. */
    ENERGY(3),
    
    /** The HAPPINESS. */
    HAPPINESS(4),
    
    /** The RUNE. */
    RUNE(5),
    
    /** The RUNIC_POWER. */
    RUNIC_POWER(6),
    
    /** The HEALTH. */
    HEALTH(0xFFFFFFFE);
    
    /** The value. */
    private int       value;
    
    /** The MA x_ power. */
    public static int MAX_POWER = 7;
    
    /**
     * Instantiates a new powers.
     * 
     * @param val
     *            the val
     */
    Powers(final int val) {
    
        setValue(val);
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
}
