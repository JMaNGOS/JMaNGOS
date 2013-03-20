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
import org.jmangos.commons.entities.PlayerXpForLevel;
import org.jmangos.world.services.PlayerXpForLevelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The Class PlayerLevelStorages.
 */
@Component
public class PlayerXpForLevelStorages implements DataLoadService<HashMap<Byte, PlayerXpForLevel>> {

    /** The Constant log. */
    private static final Logger logger = LoggerFactory.getLogger(PlayerXpForLevelStorages.class);

    @Autowired
    PlayerXpForLevelService playerXpForLevelService;

    /** The Player XP For level info. */
    private HashMap<Byte, PlayerXpForLevel> playerXpFL = new HashMap<Byte, PlayerXpForLevel>();

    /**
     * 
     * @see org.jmangos.commons.service.Service#start()
     */
    @PostConstruct
    @Override
    public void start() {

        load();
        logger.info("Loaded {} XpForLevels", this.playerXpFL.size());

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
    public HashMap<Byte, PlayerXpForLevel> load() {

        final HashMap<Byte, PlayerXpForLevel> map = new HashMap<Byte, PlayerXpForLevel>();
        final List<PlayerXpForLevel> infoList = this.playerXpForLevelService.readPlayerLevelInfos();
        for (final PlayerXpForLevel playerXpForLevel : infoList) {
            map.put(playerXpForLevel.getLevel(), playerXpForLevel);
        }
        return this.playerXpFL = map;
    }

    /**
     * 
     * @see org.jmangos.commons.dataholder.DataLoadService#reload()
     */
    @Override
    public void reload() {

        final HashMap<Byte, PlayerXpForLevel> playerXpFLTemp =
                new HashMap<Byte, PlayerXpForLevel>();
        final List<PlayerXpForLevel> infoList = this.playerXpForLevelService.readPlayerLevelInfos();
        for (final PlayerXpForLevel playerXpForLevel : infoList) {
            playerXpFLTemp.put(playerXpForLevel.getLevel(), playerXpForLevel);
        }
        this.playerXpFL = playerXpFLTemp;
    }

    /**
     * 
     * @see org.jmangos.commons.dataholder.DataLoadService#save()
     */
    @Override
    public void save() {

        // TODO Auto-generated method stub

    }

    public Integer getXpForLevel(final Byte level) {

        if (this.playerXpFL.containsKey(level)) {
            return this.playerXpFL.get(level).getXpForNextLevel();
        }
        logger.warn("Level {} does not have XP for level data. Returned 100.", level);
        return 100;
    }

    @Override
    public HashMap<Byte, PlayerXpForLevel> get() {

        // TODO Auto-generated method stub
        return null;
    }

}
