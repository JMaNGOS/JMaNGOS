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
package org.jmangos.realm.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jmangos.commons.dataholder.DataLoadService;
import org.jmangos.realm.domain.PlayerClassLevelInfoPK;
import org.jmangos.realm.model.enums.Classes;
import org.jmangos.world.entities.PlayerClassLevelInfo;
import org.jmangos.world.services.PlayerClassLevelInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The Class PlayerClassLevelInfoStorages.
 */
@Component
public class PlayerClassLevelInfoStorages implements DataLoadService<HashMap<PlayerClassLevelInfoPK, PlayerClassLevelInfo>> {
    
    /** The Constant log. */
    private static final Logger                                   log       = LoggerFactory.getLogger(PlayerClassLevelInfoStorages.class);
    
    @Inject
    PlayerClassLevelInfoService                                   playerClassLevelInfoService;
    
    /** The Player cli. */
    private HashMap<PlayerClassLevelInfoPK, PlayerClassLevelInfo> playerCLI = new HashMap<PlayerClassLevelInfoPK, PlayerClassLevelInfo>();
    
    /**
     * 
     * @see org.jmangos.commons.service.Service#start()
     */
    @PostConstruct
    @Override
    public void start() {
    
        load();
        log.info("Loaded " + this.playerCLI.size() + " PlayerClassLevelInfos");
    }
    
    /**
     * 
     * @see org.jmangos.commons.service.Service#stop()
     */
    @Override
    public void stop() {
    
        // TODO Auto-generated method stub
        
    }
    
    /**
     * 
     * @see org.jmangos.commons.dataholder.DataLoadService#load()
     */
    @Override
    public HashMap<PlayerClassLevelInfoPK, PlayerClassLevelInfo> load() {
    
        final HashMap<PlayerClassLevelInfoPK, PlayerClassLevelInfo> map = new HashMap<PlayerClassLevelInfoPK, PlayerClassLevelInfo>();
        final List<PlayerClassLevelInfo> infoList = this.playerClassLevelInfoService.readPlayerClassLevelInfos();
        for (final PlayerClassLevelInfo levelInfo : infoList) {
            map.put(levelInfo.getPlayerClassLevelInfoPK(), levelInfo);
        }
        return this.playerCLI = map;
    }
    
    /**
     * 
     * @see org.jmangos.commons.dataholder.DataLoadService#reload()
     */
    @Override
    public void reload() {
    
        HashMap<PlayerClassLevelInfoPK, PlayerClassLevelInfo> tempPlayerCLI = load();
        this.playerCLI = tempPlayerCLI;
        tempPlayerCLI = null;
    }
    
    /**
     * 
     * @see org.jmangos.commons.dataholder.DataLoadService#save()
     */
    @Override
    public void save() {
    
        // TODO Auto-generated method stub
        
    }
    
    /**
     * Gets the.
     * 
     * @param clazz
     *            the clazz
     * @param level
     *            the level
     * @return the player class level info
     */
    public PlayerClassLevelInfo get(final int clazz, final int level) {
    
        final PlayerClassLevelInfoPK cl = new PlayerClassLevelInfoPK(clazz, level);
        if (this.playerCLI.containsKey(cl)) {
            return this.playerCLI.get(cl);
        } else {
            log.warn("can't find proper PlayerClassLevelInfo");
            return null;
        }
    }
    
    /**
     * Gets the.
     * 
     * @param clazz
     *            the clazz
     * @param level
     *            the level
     * @return the player class level info
     */
    public PlayerClassLevelInfo get(final Classes clazz, final int level) {
    
        return get(clazz.getValue(), level);
    }
    
    /**
     * 
     * @see org.jmangos.commons.dataholder.DataLoadService#get()
     */
    @Override
    public HashMap<PlayerClassLevelInfoPK, PlayerClassLevelInfo> get() {
    
        // TODO Auto-generated method stub
        return null;
    }
    
}
