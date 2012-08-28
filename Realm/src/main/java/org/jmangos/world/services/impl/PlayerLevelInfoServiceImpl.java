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

import org.criteria4jpa.criterion.Criterion;
import org.jmangos.realm.domain.PlayerLevelInfoPK;
import org.jmangos.world.dao.PlayerLevelInfoDao;
import org.jmangos.world.entities.PlayerLevelInfo;
import org.jmangos.world.services.PlayerLevelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("playerLevelInfoService")
public class PlayerLevelInfoServiceImpl implements PlayerLevelInfoService {
    
    @Autowired
    private PlayerLevelInfoDao playerLevelInfoDao;
    
    @Override
    public PlayerLevelInfo readPlayerLevelInfo(final PlayerLevelInfoPK pk) {
    
        return this.playerLevelInfoDao.readPlayerLevelInfo(pk);
    }
    
    @Override
    public List<PlayerLevelInfo> readPlayerLevelInfos(final Criterion... criterions) {
    
        return this.playerLevelInfoDao.readPlayerLevelInfos(criterions);
    }
    
    @Override
    public PlayerLevelInfoPK createOrUpdatePlayerLevelInfo(final PlayerLevelInfo playerLevelInfo) {
    
        return this.playerLevelInfoDao.createOrUpdatePlayerLevelInfo(playerLevelInfo);
    }
    
    @Override
    public void deletePlayerLevelInfo(final PlayerLevelInfo playerLevelInfo) {
    
        this.playerLevelInfoDao.deletePlayerLevelInfo(playerLevelInfo);
    }
    
}
