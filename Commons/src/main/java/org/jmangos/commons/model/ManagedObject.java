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
package org.jmangos.commons.model;

import java.util.Random;

/**
 * The Class ManagedObject.
 */
public class ManagedObject {

    /**
     * The object id.
     */
    private final Integer objectId;

    public ManagedObject() {
        Random random = new Random();
        objectId = random.nextInt();
    }

    /**
     * Instantiates a new managed object.
     *
     * @param objectId the object id
     */
    public ManagedObject(int objectId) {
        this.objectId = objectId;
    }

    /**
     * Gets the object id.
     *
     * @return objectId
     */
    public final int getObjectId() {
        return objectId;
    }

    /**
     * Sets the object id.
     *
     * @param objectId the object id
     * @return the int
     */
    public final int setObjectId(int objectId) {
        return objectId;
    }
}
