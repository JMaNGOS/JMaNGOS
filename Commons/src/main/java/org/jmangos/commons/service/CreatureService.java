package org.jmangos.commons.service;

import java.util.List;

import org.jmangos.commons.entities.Creature;
import org.jmangos.commons.entities.CreaturePrototype;
import org.jmangos.commons.entities.Position;
import org.jmangos.commons.model.base.NestedMap;

public interface CreatureService {

    public abstract List<Creature> getCreatureForMapWithPositionBBox(NestedMap map, Position poslc,
            Position posrc);

    CreaturePrototype getCreatureTemplate(long entry);

}
