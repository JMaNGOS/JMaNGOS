package org.jmangos.commons.model.base;

import java.util.List;

import org.jmangos.commons.entities.Creature;
import org.jmangos.commons.entities.FieldsObject;
import org.jmangos.commons.service.CreatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
@Lazy(value = true)
public class Area extends Map {

    boolean spawned = false;
    @Autowired
    CreatureService creature;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jmangos.commons.model.base.Map#addObject(org.jmangos.commons.entities
     * .FieldsObject)
     */
    @Override
    public void addObject(final FieldsObject plObject) {
        if (!this.spawned) {
            final Map map = (Map) getRootMap();
            if (map != null) {
                final List<Creature> creatures =
                        this.creature.getCreatureForMapWithPositionBBox(map, getLeftCorner(),
                                getRightCorner());
                for (final Creature creature : creatures) {
                    super.addObject(creature);
                }
            }
        }
        super.addObject(plObject);

    }

}
