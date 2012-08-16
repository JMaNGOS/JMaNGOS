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
package org.jmangos.realm.model.base.guid;

// TODO: Auto-generated Javadoc
/**
 * The Enum HighGuid.
 */
public enum HighGuid {
    
    /** The HIGHGUI d_ item. */
    HIGHGUID_ITEM(0x4700), // blizz 4700
    /** The HIGHGUI d_ container. */
    HIGHGUID_CONTAINER(0x4700), // blizz 4700
    /** The HIGHGUI d_ player. */
    HIGHGUID_PLAYER(0x0000), // blizz 0700
    /** The HIGHGUI d_ gameobject. */
    HIGHGUID_GAMEOBJECT(0xF110), // blizz F110/F510
    /** The HIGHGUI d_ transport. */
    HIGHGUID_TRANSPORT(0xF120), // blizz F120/F520 (for
    // GAMEOBJECT_TYPE_TRANSPORT)
    /** The HIGHGUI d_ unit. */
    HIGHGUID_UNIT(0xF130), // blizz F130/F530
    /** The HIGHGUI d_ pet. */
    HIGHGUID_PET(0xF140), // blizz F140/F540
    /** The HIGHGUI d_ vehicle. */
    HIGHGUID_VEHICLE(0xF150), // blizz F150/F550
    /** The HIGHGUI d_ dynamicobject. */
    HIGHGUID_DYNAMICOBJECT(0xF100), // blizz F100/F500
    /** The HIGHGUI d_ corpse. */
    HIGHGUID_CORPSE(0xF500), // blizz F100/F500 used second variant to resolve
    // conflict with HIGHGUID_DYNAMICOBJECT
    /** The HIGHGUI d_ m o_ transport. */
    HIGHGUID_MO_TRANSPORT(0x1FC0); // blizz 1FC0 (for
    
    // GAMEOBJECT_TYPE_MO_TRANSPORT)
    
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
