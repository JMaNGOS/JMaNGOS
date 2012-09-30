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
package org.jmangos.auth.realm.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import javolution.util.FastMap;

import org.jmangos.auth.entities.RealmEntity;
import org.jmangos.auth.realm.container.RealmServersContainer;
import org.jmangos.auth.realm.services.RealmService;
import org.jmangos.commons.dataholder.Visitor;
import org.jmangos.commons.model.RealmInfo;
import org.jmangos.commons.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RealmListController implements Service {

    /**
     * Logger for this class.
     */
    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * Map with realms
     */
    private final RealmServersContainer realms = new RealmServersContainer();

    /** The byte size. */
    private int byteSize;

    /** The realm dao. */
    @Inject
    private RealmService realmService;

    private long nextUpdateTime = 0;

    /**
     * Gets the worlds.
     * 
     * @return the worlds
     */
    public RealmServersContainer getWorlds() {

        return this.realms;
    }

    public void addFromConnected(final RealmInfo realmInfo) {

        this.realms.addObject(realmInfo);
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
            if (this.realms.containsObject(realmEntity.getId())) {
                this.realms.getObject(realmEntity.getId()).setPopulation(
                        realmEntity.getPopulation());
            } else {
                final RealmInfo realmInfo = new RealmInfo(realmEntity.getId());
                realmInfo.setName(realmEntity.getName());
                realmInfo.setAddress(realmEntity.getAddress());
                realmInfo.setRealmbuilds(realmEntity.getRealmbuilds());
                realmInfo.setRealmflags(realmEntity.getRealmflags());
                realmInfo.setAllowedSecurityLevel(realmEntity.getAllowedSecurityLevel());
                realmInfo.setIcon(realmEntity.getIcon());
                realmInfo.setPopulation(realmEntity.getPopulation());
                realmInfo.setPort(realmEntity.getPort());
                realmInfo.setTimezone(realmEntity.getTimezone());
                this.realms.addObject(realmInfo);
            }
        }
        // update byte size all realms
        calculateWorldsSize();
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
    public void calculateWorldsSize() {

        this.byteSize = 8;
        this.realms.iterate(new Visitor<RealmInfo>() {

            @Override
            public void visit(final RealmInfo realmInfo) {

                RealmListController.this.byteSize +=
                        8 +
                            4 +
                            realmInfo.getAddress().length() +
                            1 +
                            realmInfo.getPort().toString().length() +
                            realmInfo.getName().length();

            }
        });
    }

    /**
     * Gets the amount characters.
     * 
     * @param id
     *        the id
     * @return the amount characters
     */
    public FastMap<Integer, Integer> getAmountCharacters(final Long id) {

        // TODO:implement
        return new FastMap<Integer, Integer>();
    }

    /**
     * @return the realms
     */
    public final RealmServersContainer getRealms() {

        return this.realms;
    }

    /**
     * @see org.jmangos.commons.service.Service#stop()
     */
    @Override
    public void stop() {

        this.realms.clearData();
    }

}
