/*******************************************************************************
 * Copyright (c) 2011 WoWEmu
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *    WoWEmu  - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.realm.model.base.guid;

import org.JMANGOS.common.model.NamedObject;

// TODO: Auto-generated Javadoc
/**
 * The Class ObjectGuid.
 */
public class ObjectGuid extends NamedObject{
	
	/** The guid. */
	private long guid = 0;
	
	/** The high. */
	private HighGuid high = null;

	/**
	 * Instantiates a new object guid.
	 */
	public ObjectGuid() {
		super(0);
		guid = 0;
	};

	/**
	 * Instantiates a new object guid.
	 *
	 * @param _guid the _guid
	 */
	public ObjectGuid(int _guid) {
		super(_guid);
		guid = _guid;
		high = HighGuid.HIGHGUID_PLAYER;
	}

	/**
	 * Instantiates a new object guid.
	 *
	 * @param _guid the _guid
	 */
	public ObjectGuid(long _guid) {
		super((int) (_guid & 0xFFFFFFFF));
		guid = _guid & 0xFFFFFFFF;
		high = HighGuid.getType((int) (_guid >> 48 & 0xFFFF));
	}

	/**
	 * Instantiates a new object guid.
	 *
	 * @param hi the hi
	 * @param entry the entry
	 * @param counter the counter
	 */
	public ObjectGuid(HighGuid hi, int entry, int counter) {
		super((int) (counter | (entry << 24)));
		guid = counter | (entry << 24);
		high = hi;
	};

	/**
	 * Instantiates a new object guid.
	 *
	 * @param hi the hi
	 * @param counter the counter
	 */
	public ObjectGuid(HighGuid hi, int counter) {
		super(counter);
		guid = counter;
		high = hi;
	};

	/**
	 * Gets the raw value.
	 *
	 * @return the raw value
	 */
	public long getRawValue() {
		return (high.getValue() << 48) | guid;
	}

	/**
	 * Gets the high.
	 *
	 * @return the high
	 */
	public HighGuid getHigh() {
		return high;
	};

	/**
	 * Checks if is empty.
	 *
	 * @return true, if successful
	 */
	boolean IsEmpty() {
		return guid == 0;
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
		return !IsEmpty() && getHigh() == HighGuid.HIGHGUID_PLAYER;
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
	 * @param high the high
	 * @return the type id
	 */
	public static TypeId getTypeId(HighGuid high) {
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
	 * @param _guid the _guid
	 * @return the long
	 */
	public static long MakeUnitGuid(long _guid){
		return (HighGuid.HIGHGUID_UNIT.getValue() << 48) | _guid ;
	}
}
