package org.jmangos.realm.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Properties;

import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.enhanced.TableGenerator;
import org.jmangos.realm.entities.CharacterData;
import org.jmangos.realm.entities.FieldsContainer;
import org.jmangos.realm.entities.FieldsGameObject;
import org.jmangos.realm.entities.FieldsItem;
import org.jmangos.realm.model.enums.HighGuid;

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
