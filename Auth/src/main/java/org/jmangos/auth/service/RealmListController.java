/*******************************************************************************
 * Copyright (C) 2012 JMaNGOS <http://jmangos.org/>
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
 *******************************************************************************/
package org.jmangos.auth.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import javolution.util.FastMap;

import org.jmangos.auth.entities.RealmEntity;
import org.jmangos.auth.services.impl.RealmServiceImpl;
import org.jmangos.commons.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RealmListController implements Service {
    
    /**
     * Logger for this class.
     */
    private final Logger                     log            = LoggerFactory.getLogger(getClass());
    
    /**
     * Map with realms
     */
    private final FastMap<Long, RealmEntity> realms         = new FastMap<Long, RealmEntity>().shared();
    
    /** The byte size. */
    private int                              byteSize;
    
    /** The realm dao. */
    @Inject
    private RealmServiceImpl                 realmService;
    
    private long                             nextUpdateTime = 0;
    
    /**
     * Gets the worlds.
     * 
     * @return the worlds
     */
    public FastMap<Long, RealmEntity> getWorlds() {
    
        return this.realms;
    }
    
    public void addFromConnected(final RealmEntity realmEntity) {
    
        if (this.realms.containsKey(realmEntity.getId())) {
            this.log.debug("Server with this id already connected. Replaced data.");
            this.realms.remove(realmEntity.getId());
            this.realms.put(realmEntity.getId(), realmEntity);
        } else {
            this.realms.put(realmEntity.getId(), realmEntity);
            this.byteSize = calculateWorldsSize();
        }
    }
    
    /**
     * Loads list of banned ip.
     */
    @PostConstruct
    @Override
    public void start() {
    
        update();
        this.log.debug("WorldList loaded {} realms.", this.realms.size());
        
    }
    
    /**
     * Update if need
     */
    public void update() {
    
        if (this.nextUpdateTime > System.currentTimeMillis()) {
            return;
        }
        final long UPDATE_INTERVAL = 2000;
        this.nextUpdateTime = System.currentTimeMillis() + UPDATE_INTERVAL;
        
        final List<RealmEntity> realmList = this.realmService.readRealms();
        for (final RealmEntity realmEntity : realmList) {
            if (this.realms.containsKey(realmEntity.getId())) {
                this.realms.get(realmEntity.getId()).setPopulation(realmEntity.getPopulation());
            } else {
                this.realms.put(realmEntity.getId(), realmEntity);
            }
        }
        // update byte size all realms
        this.byteSize = calculateWorldsSize();
    }
    
    /**
     * Gets the byte size.
     * 
     * @return the byteSize
     */
    public int getByteSize() {
    
        return this.byteSize;
    }
    
    /**
     * Gets the size.
     * 
     * @return the size
     */
    public int getRealmCount() {
    
        return this.realms.size();
    }
    
    /**
     * Calculate worlds size.
     * 
     * @return the int
     */
    public int calculateWorldsSize() {
    
        int value = 8;
        for (final RealmEntity realmEntity : this.realms.values()) {
            value += 8 + 4 + realmEntity.getAddress().length() + 1 + realmEntity.getPort().toString().length() + realmEntity.getName().length();
        }
        return value;
    }
    
    /**
     * Gets the amount characters.
     * 
     * @param id
     *            the id
     * @return the amount characters
     */
    public FastMap<Integer, Integer> getAmountCharacters(final Long id) {
    
        // TODO:implement
        return new FastMap<Integer, Integer>();
    }
    
    /**
     * @return the realms
     */
    public final FastMap<Long, RealmEntity> getRealms() {
    
        return this.realms;
    }
    
    /**
     * @see org.jmangos.commons.service.Service#stop()
     */
    @Override
    public void stop() {
    
        this.realms.clear();
    }
    
}
