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
package org.jmangos.world.services.impl;

import java.util.List;

import org.jmangos.commons.entities.PlayerClassLevelInfo;
import org.jmangos.commons.entities.pk.PlayerClassLevelInfoPK;
import org.jmangos.world.dao.PlayerClassLevelInfoDao;
import org.jmangos.world.services.PlayerClassLevelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("playerClassLevelInfoService")
public class PlayerClassLevelInfoServiceImpl implements PlayerClassLevelInfoService {

    @Autowired
    private PlayerClassLevelInfoDao playerClassLevelInfoDao;

    @Override
    public PlayerClassLevelInfo readPlayerClassLevelInfo(final PlayerClassLevelInfoPK pk) {

        return this.playerClassLevelInfoDao.findOne(pk);
    }

    @Override
    public List<PlayerClassLevelInfo> readPlayerClassLevelInfos() {

        return this.playerClassLevelInfoDao.findAll();
    }

}
