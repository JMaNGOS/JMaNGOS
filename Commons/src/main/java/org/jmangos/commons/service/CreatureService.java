package org.jmangos.commons.service;

import java.util.List;

import org.jmangos.commons.entities.Creature;
import org.jmangos.commons.entities.Position;
import org.jmangos.commons.model.base.Map;

public interface CreatureService {

    public abstract List<Creature> getCreatureForMapWithPositionBBox(Map map, Position poslc,
            Position posrc);

}
