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
package org.jmangos.commons.model;

/**
 * The Class NamedObject.
 */
public class NamedObject implements ManagedObject {

    private long objectId;

    /**
     * Default constructor for persistence content
     */
    public NamedObject() {

    }

    /**
     * Instantiates a new named object.
     * 
     * @param objectId
     *        the object id
     */
    public NamedObject(final long objectId) {

        this.objectId = objectId;
    }

    /** The name. */
    private String name;

    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {

        return this.name;
    }

    /**
     * Sets the name.
     * 
     * @param name
     *        the name to set
     */
    public void setName(final String name) {

        this.name = name;
    }

    @Override
    public long getObjectId() {

        return this.objectId;
    }

    @Override
    public void setObjectId(final long objectId) {

        this.objectId = objectId;

    }

}
