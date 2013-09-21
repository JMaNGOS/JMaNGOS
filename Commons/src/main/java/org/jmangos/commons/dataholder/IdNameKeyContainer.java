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
package org.jmangos.commons.dataholder;

import javolution.util.FastMap;

import org.jmangos.commons.model.NamedObject;

public abstract class IdNameKeyContainer<T extends NamedObject> extends IdKeyContainer<T> {

    /** name-data relations */
    private final FastMap<String, T> namedData = new FastMap<String, T>().shared();

    public T getNamedObject(final String name) {

        return this.namedData.get(name);
    }

    @Override
    public void addObject(final T object) {

        super.addObject(object);
        if (this.namedData.containsKey(object.getName())) {
            onDataAlreadyAddedEvent(object.getObjectId());
            return;
        }
        this.namedData.put(object.getName(), object);
    }

    @Override
    public void removeObject(final T object) {

        super.removeObject(object);
        if (!this.namedData.containsKey(object.getName())) {
            onDataNotPresentEvent(object.getObjectId());
            return;
        }
        this.namedData.remove(object.getName());
    }

    @Override
    public void clearData() {

        super.clearData();
        this.namedData.clear();
    }
}
