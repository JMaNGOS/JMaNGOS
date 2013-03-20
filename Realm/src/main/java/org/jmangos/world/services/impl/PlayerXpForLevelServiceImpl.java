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
package org.jmangos.world.services.impl;

import java.util.List;

import org.jmangos.commons.entities.PlayerXpForLevel;
import org.jmangos.world.dao.PlayerXpForLevelDao;
import org.jmangos.world.services.PlayerXpForLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The Class PlayerXpForLevelServiceImpl.
 */
@Service("playerXpForLevelService")
public class PlayerXpForLevelServiceImpl implements PlayerXpForLevelService {

    /** The playerXpForLevelDao. */
    @Autowired
    PlayerXpForLevelDao playerXpForLevelDao;

    @Override
    public PlayerXpForLevel readPlayerXpForLevel(final Byte level) {

        return this.playerXpForLevelDao.readXpForLevel(level);
    }

    @Override
    public List<PlayerXpForLevel> readPlayerLevelInfos() {

        return this.playerXpForLevelDao.readPlayerXpForLevels();
    }

    @Override
    public Byte createOrUpdatePlayerLevelInfo(final PlayerXpForLevel playerXpForLevel) {

        return this.playerXpForLevelDao.createOrUpdatePlayerLevelInfo(playerXpForLevel);
    }

    @Override
    public void deletePlayerXpForLevel(final PlayerXpForLevel playerXpForLevel) {

        this.playerXpForLevelDao.deletePlayerXpForLevel(playerXpForLevel);

    }

}
