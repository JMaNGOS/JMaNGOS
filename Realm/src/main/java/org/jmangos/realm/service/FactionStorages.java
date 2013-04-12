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

import gnu.trove.map.hash.TIntObjectHashMap;

import java.util.List;

import javax.annotation.PostConstruct;

import org.jmangos.commons.dataholder.DataLoadService;
import org.jmangos.commons.entities.FactionEntity;
import org.jmangos.world.services.FactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The Class QuestStorages.
 */
@Component
public class FactionStorages implements DataLoadService<TIntObjectHashMap<FactionEntity>> {

    /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(FactionStorages.class);

    /** The player class level infos. */
    private TIntObjectHashMap<FactionEntity> factions = new TIntObjectHashMap<FactionEntity>();

    @Autowired
    FactionService factionService;

    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.service.Service#start()
     */
    @Override
    @PostConstruct
    public void start() {

        load();
        logger.info("Loaded " + this.factions.size() + " factions");
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.service.Service#stop()
     */
    @Override
    public void stop() {

        this.factions.clear();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.dataholder.DataLoadService#load()
     */
    @Override
    public TIntObjectHashMap<FactionEntity> load() {

        final List<FactionEntity> tempFactions = this.factionService.readFactions();

        final TIntObjectHashMap<FactionEntity> map = new TIntObjectHashMap<FactionEntity>();

        for (final FactionEntity faction : tempFactions) {
            map.put(faction.getId(), faction);
        }

        this.factions = map;
        return this.factions;
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.dataholder.DataLoadService#reload()
     */
    @Override
    public void reload() {

        // Don't replace directly because the players can't query quest while
        // it's loading!
        logger.info("Loading quest templates to temporary store.");
        final List<FactionEntity> tempFactions = this.factionService.readFactions();
        final TIntObjectHashMap<FactionEntity> tempFFactions =
                new TIntObjectHashMap<FactionEntity>();
        for (final FactionEntity faction : tempFactions) {
            tempFFactions.put(faction.getId(), faction);
        }
        logger.info("Loaded " +
            tempFFactions.size() +
            " factions. Replacing new old Faction with newer");
        this.factions = tempFFactions;
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.dataholder.DataLoadService#save()
     */
    @Override
    public void save() {

        // TODO Auto-generated method stub

    }

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.dataholder.DataLoadService#get()
     */
    @Override
    public TIntObjectHashMap<FactionEntity> get() {

        return this.factions;
    }

    // Specific getters
    public FactionEntity getQuest(final int factionId) {

        return this.factions.get(factionId);
    }
}
