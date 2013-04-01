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

import java.io.Serializable;
import java.util.HashMap;
import java.util.Properties;

import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.enhanced.TableGenerator;
import org.jmangos.commons.entities.CharacterData;
import org.jmangos.commons.entities.FieldsContainer;
import org.jmangos.commons.entities.FieldsGameObject;
import org.jmangos.commons.entities.FieldsItem;
import org.jmangos.commons.enums.HighGuid;

public class WowExtendIdGenerator extends TableGenerator {

    private static HashMap<Class<?>, Integer> hiClass;
    {
        if (hiClass == null) {
            hiClass = new HashMap<Class<?>, Integer>();
            hiClass.put(FieldsItem.class, HighGuid.ITEM.getValue());
            hiClass.put(FieldsContainer.class, HighGuid.CONTAINER.getValue());
            hiClass.put(FieldsGameObject.class, HighGuid.GAMEOBJECT.getValue());
            hiClass.put(CharacterData.class, HighGuid.PLAYER.getValue());
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.hibernate.id.enhanced.TableGenerator#determineSegmentValue(java.util
     * .Properties)
     */
    @Override
    protected String determineSegmentValue(final Properties params) {

        String segmentName = params.getProperty(TABLE);
        // Container and Item id equals
        if (segmentName.equals("fields_container")) {
            segmentName = "fields_item";
        }

        return segmentName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.hibernate.id.enhanced.TableGenerator#generate(org.hibernate.engine.spi
     * .SessionImplementor
     * , java.lang.Object)
     */
    @Override
    public synchronized Serializable generate(final SessionImplementor session, final Object obj) {

        final Serializable value = super.generate(session, obj);
        final Long l = (long) hiClass.get(obj.getClass());
        return (l << 52) | (Long) value;
    }

}
