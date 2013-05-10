package org.jmangos.realm.model;

import java.util.List;

import org.jmangos.commons.entities.CharacterData;
import org.jmangos.commons.entities.Creature;
import org.jmangos.commons.entities.FieldsObject;
import org.jmangos.commons.service.CreatureService;
import org.jmangos.realm.service.GameEventCreatureStorages;
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
    @Autowired
    GameEventCreatureStorages gameEventCreatureStorages;

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.model.base.Map#addObject(org.jmangos.commons.entities
     *      .FieldsObject)
     */
    @Override
    public void addObject(final FieldsObject plObject) {
        log.info("Add player {} to area {}", ((CharacterData) plObject).getName(), getId());
        log.info("Area is spawned {}", this.spawned);
        if (!this.spawned) {
            final Map map = (Map) getRootMap();
            log.info("Root map {} for area {}.", map.getId(), this.getId());
            if (map != null) {
                final List<Creature> creatures =
                        this.creature.getCreatureForMapWithPositionBBox(map, getLeftCorner(),
                                getRightCorner());
                for (final Creature creature : creatures) {
                    if (this.gameEventCreatureStorages.isCreatureEventable((int) (creature.getGuid() & 0xFFFFFF))) {
                        // now ignore creatures for any event
                    } else {
                        super.addObject(creature);
                    }
                }
            }
            this.spawned = true;
        }
        super.addObject(plObject);

    }

}
