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

import org.jmangos.commons.model.NamedObject;

// TODO: Auto-generated Javadoc
/**
 * The Class ObjectGuid.
 */
public class ObjectGuid extends NamedObject {
    
    /** The guid. */
    private long     guid = 0;
    
    /** The high. */
    private HighGuid high = null;
    
    /**
     * Instantiates a new object guid.
     */
    public ObjectGuid() {
    
        super(0);
        this.guid = 0;
    };
    
    /**
     * Instantiates a new object guid.
     * 
     * @param _guid
     *            the _guid
     */
    public ObjectGuid(final int _guid) {
    
        super(_guid);
        this.guid = _guid;
        this.high = HighGuid.HIGHGUID_PLAYER;
    }
    
    /**
     * Instantiates a new object guid.
     * 
     * @param _guid
     *            the _guid
     */
    public ObjectGuid(final long _guid) {
    
        super((int) (_guid & 0xFFFFFFFF));
        this.guid = _guid & 0xFFFFFFFF;
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
    public ObjectGuid(final HighGuid hi, final int entry, final int counter) {
    
        super(counter | (entry << 24));
        this.guid = counter | (entry << 24);
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
    public ObjectGuid(final HighGuid hi, final int counter) {
    
        super(counter);
        this.guid = counter;
        this.high = hi;
    };
    
    /**
     * Gets the raw value.
     * 
     * @return the raw value
     */
    public long getRawValue() {
    
        return (this.high.getValue() << 48) | this.guid;
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
     * Checks if is empty.
     * 
     * @return true, if successful
     */
    boolean IsEmpty() {
    
        return this.guid == 0;
    }
    
    /**
     * Checks if is creature.
     * 
     * @return true, if successful
     */
    boolean IsCreature() {
    
        return getHigh() == HighGuid.HIGHGUID_UNIT;
    }
    
    /**
     * Checks if is pet.
     * 
     * @return true, if successful
     */
    boolean IsPet() {
    
        return getHigh() == HighGuid.HIGHGUID_PET;
    }
    
    /**
     * Checks if is vehicle.
     * 
     * @return true, if successful
     */
    boolean IsVehicle() {
    
        return getHigh() == HighGuid.HIGHGUID_VEHICLE;
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
    
        return !IsEmpty() && (getHigh() == HighGuid.HIGHGUID_PLAYER);
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
    
        return getHigh() == HighGuid.HIGHGUID_ITEM;
    }
    
    /**
     * Checks if is gameobject.
     * 
     * @return true, if successful
     */
    boolean IsGameobject() {
    
        return getHigh() == HighGuid.HIGHGUID_GAMEOBJECT;
    }
    
    /**
     * Checks if is dynamic object.
     * 
     * @return true, if successful
     */
    boolean IsDynamicObject() {
    
        return getHigh() == HighGuid.HIGHGUID_DYNAMICOBJECT;
    }
    
    /**
     * Checks if is corpse.
     * 
     * @return true, if successful
     */
    boolean IsCorpse() {
    
        return getHigh() == HighGuid.HIGHGUID_CORPSE;
    }
    
    /**
     * Checks if is transport.
     * 
     * @return true, if successful
     */
    boolean IsTransport() {
    
        return getHigh() == HighGuid.HIGHGUID_TRANSPORT;
    }
    
    /**
     * Checks if is mo transport.
     * 
     * @return true, if successful
     */
    boolean IsMOTransport() {
    
        return getHigh() == HighGuid.HIGHGUID_MO_TRANSPORT;
    }
    
    /**
     * Gets the type id.
     * 
     * @param high
     *            the high
     * @return the type id
     */
    public static TypeId getTypeId(final HighGuid high) {
    
        switch (high) {
            case HIGHGUID_ITEM:
                return TypeId.TYPEID_ITEM;
            case HIGHGUID_UNIT:
                return TypeId.TYPEID_UNIT;
            case HIGHGUID_PET:
                return TypeId.TYPEID_UNIT;
            case HIGHGUID_PLAYER:
                return TypeId.TYPEID_PLAYER;
            case HIGHGUID_GAMEOBJECT:
                return TypeId.TYPEID_GAMEOBJECT;
            case HIGHGUID_DYNAMICOBJECT:
                return TypeId.TYPEID_DYNAMICOBJECT;
            case HIGHGUID_CORPSE:
                return TypeId.TYPEID_CORPSE;
            case HIGHGUID_MO_TRANSPORT:
                return TypeId.TYPEID_GAMEOBJECT;
            case HIGHGUID_VEHICLE:
                return TypeId.TYPEID_UNIT;
            default:
                return TypeId.TYPEID_OBJECT;
        }
    }
    
    /**
     * Gets the type id.
     * 
     * @return the type id
     */
    public TypeId GetTypeId() {
    
        return ObjectGuid.getTypeId(getHigh());
    }
    
    /**
     * Make unit guid.
     * 
     * @param _guid
     *            the _guid
     * @return the long
     */
    public static long MakeUnitGuid(final long _guid) {
    
        return (HighGuid.HIGHGUID_UNIT.getValue() << 48) | _guid;
    }
}
