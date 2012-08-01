/*******************************************************************************
 * Copyright (c) 2012 JMANGOS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     JMANGOS - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.realm.model.base.guid;

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
	HighGuid(int value) {
		this.setValue(value);
	}

	/**
	 * Sets the value.
	 * 
	 * @param value
	 *            the new value
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public long getValue() {
		return value;
	}

	/**
	 * Gets the type.
	 * 
	 * @param typeID
	 *            the type id
	 * @return the type
	 */
	public static HighGuid getType(int typeID) {
		for (HighGuid type : HighGuid.values())
			if (type.getValue() == typeID)
				return type;
		return null;
	}
}
