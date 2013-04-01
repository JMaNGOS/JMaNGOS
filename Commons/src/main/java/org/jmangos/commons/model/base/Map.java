/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
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
 ******************************************************************************/
package org.jmangos.commons.model.base;

import gnu.trove.map.hash.TLongObjectHashMap;

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
     * @param id
     *        the id
     */
    public Map(final int id) {

        super();
        this.id = id;
    }

    /**
     * Adds the object.
     * 
     * @param plObject
     *        the pl object
     */
    public void addObject(final WorldObject plObject) {

        switch (plObject.getObjectTypeId()) {
            case PLAYER:
                this.playerList.put(plObject.getObjectId(), plObject);
            break;
            case UNIT:
                this.units.put(plObject.getObjectId(), plObject);
            break;
            default:
            break;
        }

    }

    /**
     * Update.
     * 
     * @return true, if successful
     */
    public boolean update() {

        for (final Object pl : this.playerList.values()) {
            System.out.println("Player name: " + ((WorldObject) pl).getName());
        };
        System.out.println("Player on map " + this.playerList.size());
        System.out.println("units on map " + this.units.size());
        return true;
    }

    /**
     * @return the id
     */
    public final int getId() {

        return this.id;
    }

    /**
     * @param id
     *        the id to set
     */
    public final void setId(final int id) {

        this.id = id;
    }

}
