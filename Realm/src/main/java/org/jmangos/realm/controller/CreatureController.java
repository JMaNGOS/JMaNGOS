package org.jmangos.realm.controller;

import java.util.List;

import org.jmangos.commons.entities.Creature;
import org.jmangos.commons.entities.Position;
import org.jmangos.commons.model.base.Map;
import org.jmangos.commons.service.CreatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreatureController {

    @Autowired
    private CreatureService creatureServiceImpl;

    public List<Creature> loadCreatureForMapWithPositionBBox(final Map map, final Position poslc,
            final Position posrc) {
        return this.creatureServiceImpl.getCreatureForMapWithPositionBBox(map, poslc, posrc);
    }
}
