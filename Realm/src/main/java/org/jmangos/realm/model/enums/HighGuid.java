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
 * The Enum HighGuid.
 */
public enum HighGuid {
    
    /** The ITEM. */
    ITEM(0x4700),
    
    /** The CONTAINER. */
    CONTAINER(0x4700),
    
    /** The PLAYER. */
    PLAYER(0x0000),
    
    /** The GAMEOBJECT. */
    GAMEOBJECT(0xF110),
    
    /** The TRANSPORT. */
    TRANSPORT(0xF120),
    
    /** The UNIT. */
    UNIT(0xF130),
    
    /** The PET. */
    PET(0xF140),
    
    /** The VEHICLE. */
    VEHICLE(0xF150),
    
    /** The DYNAMICOBJECT. */
    DYNAMICOBJECT(0xF100),
    
    /** The CORPSE. */
    CORPSE(0xF500),
    
    /** The MO_TRANSPORT. */
    MO_TRANSPORT(0x1FC0),
    
    /** The INSTANCE */
    INSTANCE(0x1F4),
    
    /** The GROUP */
    GROUP(0x1F5);
    
    /** The value. */
    private int value;
    
    /**
     * Instantiates a new high guid.
     * 
     * @param value
     *            the value
     */
    HighGuid(final int value) {
    
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
    public long getValue() {
    
        return this.value;
    }
    
    /**
     * Gets the type.
     * 
     * @param typeID
     *            the type id
     * @return the type
     */
    public static HighGuid getType(final int typeID) {
    
        for (final HighGuid type : HighGuid.values()) {
            if (type.getValue() == typeID) {
                return type;
            }
        }
        return null;
    }
}
