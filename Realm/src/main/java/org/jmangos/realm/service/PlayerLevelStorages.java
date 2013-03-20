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

import org.jmangos.commons.dataholder.DataLoadService;
import org.jmangos.commons.entities.PlayerLevelInfo;
import org.jmangos.commons.entities.pk.PlayerLevelInfoPK;
import org.jmangos.commons.enums.Classes;
import org.jmangos.commons.enums.Races;
import org.jmangos.world.services.PlayerLevelInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The Class PlayerLevelStorages.
 */
@Component
public class PlayerLevelStorages
        implements DataLoadService<HashMap<PlayerLevelInfoPK, PlayerLevelInfo>> {

    /** The Constant log. */
    private static final Logger log = LoggerFactory.getLogger(PlayerLevelStorages.class);

    @Autowired
    PlayerLevelInfoService playerLevelInfoService;

    /** The Player Race Class Level info. */
    private HashMap<PlayerLevelInfoPK, PlayerLevelInfo> playerRCLI =
            new HashMap<PlayerLevelInfoPK, PlayerLevelInfo>();

    /**
     * 
     * @see org.jmangos.commons.service.Service#start()
     */
    @PostConstruct
    @Override
    public void start() {

        load();
        log.info("Loaded " + this.playerRCLI.size() + " PlayerLevelInfos");

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
    public HashMap<PlayerLevelInfoPK, PlayerLevelInfo> load() {

        final HashMap<PlayerLevelInfoPK, PlayerLevelInfo> map =
                new HashMap<PlayerLevelInfoPK, PlayerLevelInfo>();
        final List<PlayerLevelInfo> infoList = this.playerLevelInfoService.readPlayerLevelInfos();
        for (final PlayerLevelInfo levelInfo : infoList) {
            map.put(levelInfo.getPlayerLevelInfoPK(), levelInfo);
        }
        return this.playerRCLI = map;
    }

    /**
     * 
     * @see org.jmangos.commons.dataholder.DataLoadService#reload()
     */
    @Override
    public void reload() {

        final HashMap<PlayerLevelInfoPK, PlayerLevelInfo> playerRCLITemp =
                new HashMap<PlayerLevelInfoPK, PlayerLevelInfo>();
        final List<PlayerLevelInfo> infoList = this.playerLevelInfoService.readPlayerLevelInfos();
        for (final PlayerLevelInfo levelInfo : infoList) {
            playerRCLITemp.put(levelInfo.getPlayerLevelInfoPK(), levelInfo);
        }
        this.playerRCLI = playerRCLITemp;
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
     *        the race
     * @param clazz
     *        the clazz
     * @param level
     *        the level
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
     *        the race
     * @param clazz
     *        the clazz
     * @param level
     *        the level
     * @return the player level info
     */
    public PlayerLevelInfo get(final Races race, final Classes clazz, final int level) {

        return get(race.getValue(), clazz.getValue(), level);
    }

}
