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
import org.jmangos.commons.entities.ChrClasses;
import org.jmangos.commons.enums.Classes;
import org.jmangos.world.services.ChrClassesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The Class ChrClassesStorages.
 */
@Component
public class ChrClassesStorages implements DataLoadService<Map<Classes, ChrClasses>> {

    /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(ChrClassesStorages.class);

    private Map<Classes, ChrClasses> chrClasses = new FastMap<Classes, ChrClasses>();

    @Autowired
    ChrClassesService chrClassesService;

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.service.Service#start()
     */
    @Override
    @PostConstruct
    public void start() {

        load();
        logger.info("Loaded " + this.chrClasses.size() + " ChrClasses");
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.service.Service#stop()
     */
    @Override
    public void stop() {

        this.chrClasses.clear();
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.dataholder.DataLoadService#load()
     */
    @Override
    public Map<Classes, ChrClasses> load() {

        final List<ChrClasses> tempClasses = this.chrClassesService.readChrClasses();

        final Map<Classes, ChrClasses> map =
                new FastMap<Classes, ChrClasses>(Classes.values().length);

        for (final ChrClasses chrClass : tempClasses) {
            map.put(chrClass.getId(), chrClass);
        }

        this.chrClasses = map;
        return this.chrClasses;
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
        final List<ChrClasses> tempClasses = this.chrClassesService.readChrClasses();

        final Map<Classes, ChrClasses> map =
                new FastMap<Classes, ChrClasses>(Classes.values().length);

        for (final ChrClasses chrClass : tempClasses) {
            map.put(chrClass.getId(), chrClass);
        }

        this.chrClasses = map;
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
    public Map<Classes, ChrClasses> get() {

        return this.chrClasses;
    }

    // Specific getters
    public ChrClasses getChrClass(final Classes clazz) {

        return this.chrClasses.get(clazz);
    }
}
