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
package org.jmangos.realm.model.base;

import org.jmangos.realm.model.unit.Units;

import gnu.trove.map.hash.TLongObjectHashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class Map.
 */
public class Map {
	
	/** The id. */
	int id = 0; 
	
	/** The player list. */
	TLongObjectHashMap<WorldObject> playerList = new TLongObjectHashMap<WorldObject>();
	
	/** The units. */
	TLongObjectHashMap<WorldObject> units = new TLongObjectHashMap<WorldObject>();
	
	/**
	 * Instantiates a new map.
	 *
	 * @param id the id
	 */
	public Map(int id) {
		super();
		this.id = id;
	}
	
	/**
	 * Adds the object.
	 *
	 * @param plObject the pl object
	 */
	public void AddObject(WorldObject plObject){
		switch (plObject.getObjectTypeId()) {
			case TYPEID_PLAYER :
				playerList.put(plObject.getObjectGuid().getRawValue(), plObject);
				break;
			case TYPEID_UNIT :
				units.put(plObject.getObjectGuid().getRawValue(), plObject);
				break;
			default :
				break;
		}
		
	}
	
	/**
	 * Update.
	 *
	 * @return true, if successful
	 */
	public boolean update() {
		for (Object pl : playerList.values()) {
			System.out.println("Player name: " + ((Units)pl).getName());
		};
		for (Object pl : units.values()) {
			System.out.println("Units name: " + ((Units)pl).getName());
		};
		System.out.println("Player on map " + playerList.size());
		System.out.println("units on map " + units.size());
		return true;
	}

}
