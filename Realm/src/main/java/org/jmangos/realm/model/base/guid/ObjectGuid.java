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

import org.jmangos.commons.model.ManagedObject;
import org.jmangos.realm.model.enums.HighGuid;
import org.jmangos.realm.model.enums.TypeID;

/**
 * The Class ObjectGuid.
 */
public class ObjectGuid extends ManagedObject {
    
    /** The high. */
    private HighGuid high = null;
    
    /**
     * Instantiates a new object guid.
     */
    public ObjectGuid() {
    
        super(0);
    };
    
    /**
     * Instantiates a new object guid.
     * 
     * @param _guid
     *            the _guid
     */
    public ObjectGuid(final long _guid) {
    
        super((int) (_guid & 0xFFFFFFFF));
        this.high = HighGuid.getType((int) ((_guid >> 48) & 0xFFFF));
    }
    
    /**
     * Instantiates a new object guid.
     * 
     * @param hi
     *            the hi
     * @param entry
     *            the entry
     * @param counter
     *            the counter
     */
    public ObjectGuid(final HighGuid hi, final int entry, final Integer counter) {
    
        super(counter | (entry << 24));
        this.high = hi;
    };
    
    /**
     * Instantiates a new object guid.
     * 
     * @param hi
     *            the hi
     * @param counter
     *            the counter
     */
    public ObjectGuid(final HighGuid hi, final Integer counter) {
    
        super(counter);
        this.high = hi;
    };
    
    /**
     * Gets the raw value.
     * 
     * @return the raw value
     */
    public long getRawValue() {
    
        return (this.high.getValue() << 48) | getObjectId();
    }
    
    /**
     * Gets the high.
     * 
     * @return the high
     */
    public HighGuid getHigh() {
    
        return this.high;
    };
    
    /**
     * Checks if is creature.
     * 
     * @return true, if successful
     */
    boolean IsCreature() {
    
        return getHigh() == HighGuid.UNIT;
    }
    
    /**
     * Checks if is pet.
     * 
     * @return true, if successful
     */
    boolean IsPet() {
    
        return getHigh() == HighGuid.PET;
    }
    
    /**
     * Checks if is vehicle.
     * 
     * @return true, if successful
     */
    boolean IsVehicle() {
    
        return getHigh() == HighGuid.VEHICLE;
    }
    
    /**
     * Checks if is creature or pet.
     * 
     * @return true, if successful
     */
    boolean IsCreatureOrPet() {
    
        return IsCreature() | IsPet();
    }
    
    /**
     * Checks if is creature or vehicle.
     * 
     * @return true, if successful
     */
    boolean IsCreatureOrVehicle() {
    
        return IsCreature() || IsVehicle();
    }
    
    /**
     * Checks if is player.
     * 
     * @return true, if successful
     */
    boolean IsPlayer() {
    
        return (getHigh() == HighGuid.PLAYER);
    }
    
    /**
     * Checks if is unit.
     * 
     * @return true, if successful
     */
    boolean IsUnit() {
    
        return IsCreatureOrPet() || IsPlayer();
    }
    
    /**
     * Checks if is item.
     * 
     * @return true, if successful
     */
    boolean IsItem() {
    
        return getHigh() == HighGuid.ITEM;
    }
    
    /**
     * Checks if is gameobject.
     * 
     * @return true, if successful
     */
    boolean IsGameobject() {
    
        return getHigh() == HighGuid.GAMEOBJECT;
    }
    
    /**
     * Checks if is dynamic object.
     * 
     * @return true, if successful
     */
    boolean IsDynamicObject() {
    
        return getHigh() == HighGuid.DYNAMICOBJECT;
    }
    
    /**
     * Checks if is corpse.
     * 
     * @return true, if successful
     */
    boolean IsCorpse() {
    
        return getHigh() == HighGuid.CORPSE;
    }
    
    /**
     * Checks if is transport.
     * 
     * @return true, if successful
     */
    boolean IsTransport() {
    
        return getHigh() == HighGuid.TRANSPORT;
    }
    
    /**
     * Checks if is mo transport.
     * 
     * @return true, if successful
     */
    boolean IsMOTransport() {
    
        return getHigh() == HighGuid.MO_TRANSPORT;
    }
    
    /**
     * Gets the type id.
     * 
     * @param high
     *            the high
     * @return the type id
     */
    public static TypeID getTypeID(final HighGuid high) {
    
        switch (high) {
            case ITEM:
                return TypeID.ITEM;
            case UNIT:
                return TypeID.UNIT;
            case PET:
                return TypeID.UNIT;
            case PLAYER:
                return TypeID.PLAYER;
            case GAMEOBJECT:
                return TypeID.GAMEOBJECT;
            case DYNAMICOBJECT:
                return TypeID.DYNAMICOBJECT;
            case CORPSE:
                return TypeID.CORPSE;
            case MO_TRANSPORT:
                return TypeID.GAMEOBJECT;
            case VEHICLE:
                return TypeID.UNIT;
            default:
                return TypeID.OBJECT;
        }
    }
    
    /**
     * Gets the type id.
     * 
     * @return the type id
     */
    public TypeID GetTypeID() {
    
        return ObjectGuid.getTypeID(getHigh());
    }
    
    /**
     * Make unit guid.
     * 
     * @param _guid
     *            the _guid
     * @return the long
     */
    public static long MakeUnitGuid(final long _guid) {
    
        return (HighGuid.UNIT.getValue() << 48) | _guid;
    }
    
    public boolean hasEntry() {
    
        switch (this.high) {
            case ITEM:
            case PLAYER:
            case DYNAMICOBJECT:
            case CORPSE:
            case MO_TRANSPORT:
                return false;
            case GAMEOBJECT:
            case TRANSPORT:
            case UNIT:
            case PET:
            case VEHICLE:
            default:
                return true;
        }
    }
    
    public long getCounter() {
    
        return hasEntry() ? (getObjectId() & 0xFFFFFF) : (getObjectId() & 0xFFFFFFFF);
    }
}
