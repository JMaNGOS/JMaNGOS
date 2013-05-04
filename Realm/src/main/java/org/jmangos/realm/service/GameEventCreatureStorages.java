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
package org.jmangos.realm.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.jmangos.commons.dataholder.DataLoadService;
import org.jmangos.commons.entities.GameEventCreature;
import org.jmangos.world.services.GameEventCreatureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.ArrayListMultimap;

/**
 * The Class GameEventCreatureStorages.
 */
@Component
public class GameEventCreatureStorages
        implements DataLoadService<ArrayListMultimap<Integer, Integer>> {

    /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(GameEventCreatureStorages.class);

    // Contains eventID and list creatures guids for this event
    private final ArrayListMultimap<Integer, Integer> eventsCreatures = ArrayListMultimap.create();
    @Autowired
    GameEventCreatureService gameEventCreatureService;

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.service.Service#start()
     */
    @Override
    @PostConstruct
    public void start() {

        load();
        logger.info("Loaded for {} events creatures.", this.eventsCreatures.size());
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.service.Service#stop()
     */
    @Override
    public void stop() {

        this.eventsCreatures.clear();
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.dataholder.DataLoadService#load()
     */
    @Override
    public ArrayListMultimap<Integer, Integer> load() {

        final List<GameEventCreature> tempCreatures =
                this.gameEventCreatureService.readGameEventCreatures();

        for (final GameEventCreature faction : tempCreatures) {
            this.eventsCreatures.put(faction.getEvent(), faction.getGuid());
        }

        return this.eventsCreatures;
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.dataholder.DataLoadService#reload()
     */
    @Override
    public void reload() {

        logger.info("Loading event creatures to temporary store.");
        final List<GameEventCreature> tempCreatures =
                this.gameEventCreatureService.readGameEventCreatures();

        for (final GameEventCreature faction : tempCreatures) {
            this.eventsCreatures.put(faction.getEvent(), faction.getGuid());
        }

    }

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.dataholder.DataLoadService#save()
     */
    @Override
    public void save() {

    }

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.dataholder.DataLoadService#get()
     */
    @Override
    public ArrayListMultimap<Integer, Integer> get() {

        return this.eventsCreatures;
    }

    // Specific getters
    public boolean isCreatureEventable(final int guid) {
        return this.eventsCreatures.containsValue(guid);
    }
}
