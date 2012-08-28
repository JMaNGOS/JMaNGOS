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
import org.jmangos.realm.domain.PlayercreateinfoPK;
import org.jmangos.world.dao.PlayercreateinfoDao;
import org.jmangos.world.entities.Playercreateinfo;
import org.jmangos.world.services.PlayercreateinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("playercreateinfoService")
public class PlayercreateinfoServiceImpl implements PlayercreateinfoService {
    
    @Autowired
    private PlayercreateinfoDao playercreateinfoDao;
    
    @Override
    public Playercreateinfo readPlayercreateinfo(final PlayercreateinfoPK pk) {
    
        return this.playercreateinfoDao.readPlayercreateinfo(pk);
    }
    
    @Override
    public List<Playercreateinfo> readPlayercreateinfos(final Criterion... criterions) {
    
        return this.playercreateinfoDao.readPlayercreateinfos(criterions);
    }
    
    @Override
    public PlayercreateinfoPK createOrUpdatePlayercreateinfo(final Playercreateinfo playercreateinfo) {
    
        return this.playercreateinfoDao.createOrUpdatePlayercreateinfo(playercreateinfo);
    }
    
    @Override
    public void deletePlayercreateinfo(final Playercreateinfo playercreateinfo) {
    
        this.playercreateinfoDao.deletePlayercreateinfo(playercreateinfo);
    }
    
}
