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
package org.jmangos.realm.model;

// TODO: Auto-generated Javadoc
/**
 * The Enum Classes.
 */
public enum Classes {
    
    /** The CLAS s_ warrior. */
    CLASS_WARRIOR(1),
    /** The CLAS s_ paladin. */
    CLASS_PALADIN(2),
    /** The CLAS s_ hunter. */
    CLASS_HUNTER(3),
    /** The CLAS s_ rogue. */
    CLASS_ROGUE(4),
    /** The CLAS s_ priest. */
    CLASS_PRIEST(5),
    /** The CLAS s_ deat h_ knight. */
    CLASS_DEATH_KNIGHT(6),
    /** The CLAS s_ shaman. */
    CLASS_SHAMAN(7),
    /** The CLAS s_ mage. */
    CLASS_MAGE(8),
    /** The CLAS s_ warlock. */
    CLASS_WARLOCK(9),
    /** The CLAS s_ druid. */
    CLASS_DRUID(11);
    
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
    
    public static Classes get(final int value) {
    
        for (final Classes val : values()) {
            if (val.getValue() == value) {
                return val;
            }
        }
        
        return null;
    }
}
