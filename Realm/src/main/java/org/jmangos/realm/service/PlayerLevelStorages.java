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

import org.apache.log4j.Logger;
import org.jmangos.commons.dataholder.DataLoadService;
import org.jmangos.realm.dao.SimpleDataDAO;
import org.jmangos.realm.model.Classes;
import org.jmangos.realm.model.Races;
import org.jmangos.realm.model.base.PlayerLevelInfo;
import org.jmangos.realm.model.base.PlayerLevelInfoPK;

import com.google.inject.Inject;

/**
 * The Class PlayerLevelStorages.
 */
public class PlayerLevelStorages implements DataLoadService<HashMap<PlayerLevelInfoPK, PlayerLevelInfo>> {
    
    /** The Constant log. */
    private static final Logger                         log        = Logger.getLogger(PlayerLevelStorages.class);
    
    /** The simple data dao. */
    @Inject
    SimpleDataDAO                                       simpleDataDAO;
    
    /** The Player Race Class Level info. */
    private HashMap<PlayerLevelInfoPK, PlayerLevelInfo> playerRCLI = new HashMap<PlayerLevelInfoPK, PlayerLevelInfo>();
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.service.Service#start()
     */
    @Override
    public void start() {
    
        load();
        log.info("Loaded " + this.playerRCLI.size() + " PlayerLevelInfos");
        
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.service.Service#stop()
     */
    @Override
    public void stop() {
    
        // TODO Auto-generated method stub
        
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.dataholder.DataLoadService#load()
     */
    @Override
    public HashMap<PlayerLevelInfoPK, PlayerLevelInfo> load() {
    
        // TODO Auto-generated method stub
        return this.playerRCLI = this.simpleDataDAO.getRaceClassLevelInfos();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.dataholder.DataLoadService#reload()
     */
    @Override
    public void reload() {
    
        HashMap<PlayerLevelInfoPK, PlayerLevelInfo> playerRCLITemp = this.simpleDataDAO.getRaceClassLevelInfos();
        this.playerRCLI = playerRCLITemp;
        playerRCLITemp = null;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.dataholder.DataLoadService#save()
     */
    @Override
    public void save() {
    
        // TODO Auto-generated method stub
        
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.dataholder.DataLoadService#get()
     */
    @Override
    public HashMap<PlayerLevelInfoPK, PlayerLevelInfo> get() {
    
        // TODO Auto-generated method stub
        return null;
    }
    
    /**
     * Gets the.
     * 
     * @param race
     *            the race
     * @param clazz
     *            the clazz
     * @param level
     *            the level
     * @return the player level info
     */
    public PlayerLevelInfo get(final int race, final int clazz, final int level) {
    
        final PlayerLevelInfoPK cl = new PlayerLevelInfoPK(race, clazz, level);
        if (this.playerRCLI.containsKey(cl)) {
            return this.playerRCLI.get(cl);
        } else {
            log.warn("can't find proper PlayerClassLevelInfo PCLI size: " + this.playerRCLI.size());
            return null;
        }
    }
    
    /**
     * Gets the.
     * 
     * @param race
     *            the race
     * @param clazz
     *            the clazz
     * @param level
     *            the level
     * @return the player level info
     */
    public PlayerLevelInfo get(final Races race, final Classes clazz, final int level) {
    
        return get(race.getValue(), clazz.getValue(), level);
    }
    
}
