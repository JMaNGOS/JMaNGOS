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
import java.util.Map;

import javax.annotation.PostConstruct;

import javolution.util.FastMap;

import org.jmangos.commons.dataholder.DataLoadService;
import org.jmangos.commons.entities.ChrRaces;
import org.jmangos.commons.enums.Races;
import org.jmangos.world.services.ChrRacesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The Class ChrRacesStorages.
 */
@Component
public class ChrRacesStorages implements DataLoadService<Map<Races, ChrRaces>> {

    /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(ChrRacesStorages.class);

    private Map<Races, ChrRaces> chrRaces = new FastMap<Races, ChrRaces>();

    @Autowired
    ChrRacesService chrRacesService;

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.service.Service#start()
     */
    @Override
    @PostConstruct
    public void start() {

        load();
        logger.info("Loaded " + this.chrRaces.size() + " ChrRaces");
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.service.Service#stop()
     */
    @Override
    public void stop() {

        this.chrRaces.clear();
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.dataholder.DataLoadService#load()
     */
    @Override
    public Map<Races, ChrRaces> load() {

        final List<ChrRaces> tempRaces = this.chrRacesService.readChrRaces();

        final Map<Races, ChrRaces> map = new FastMap<Races, ChrRaces>(Races.values().length);

        for (final ChrRaces chrRace : tempRaces) {
            map.put(chrRace.getId(), chrRace);
        }

        this.chrRaces = map;
        return this.chrRaces;
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
        final List<ChrRaces> tempRaces = this.chrRacesService.readChrRaces();

        final Map<Races, ChrRaces> map = new FastMap<Races, ChrRaces>(Races.values().length);

        for (final ChrRaces chrRace : tempRaces) {
            map.put(chrRace.getId(), chrRace);
        }

        this.chrRaces = map;
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
    public Map<Races, ChrRaces> get() {

        return this.chrRaces;
    }

    // Specific getters
    public ChrRaces getChrRace(final Races race) {

        return this.chrRaces.get(race);
    }
}
