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
package org.jmangos.tools.dbcconverter.service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.jmangos.tools.dbc.dataholder.DBCDataLoader;
import org.jmangos.tools.dbc.dataholder.DBCStruct;

public abstract class AbstractDbcService<T1, T2 extends DBCStruct<T2>> {

    private Class<T2> entryClass;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public AbstractDbcService() {

        this.entryClass = null;
        final Class<? extends AbstractDbcService> c = getClass();
        final Type t = c.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            final Type[] p = ((ParameterizedType) t).getActualTypeArguments();
            this.entryClass = (Class<T2>) p[1];
        }
    }

    protected T2 getEntry() {

        return DBCDataLoader.loadStaticData(this.entryClass, getDbcPath());
    }

    public abstract void save(T1 t);

    public abstract void saveAll();

    public abstract String getDbcPath();

}
