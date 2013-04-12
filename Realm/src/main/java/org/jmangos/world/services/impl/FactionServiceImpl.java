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

import org.jmangos.commons.entities.FactionEntity;
import org.jmangos.world.dao.FactionDao;
import org.jmangos.world.services.FactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("factionService")
public class FactionServiceImpl implements FactionService {

    @Autowired
    private FactionDao factionDao;

    @Override
    public FactionEntity getById(final Integer id) {
        return this.factionDao.findOne(id);
    }

    @Override
    public List<FactionEntity> readFactions() {
        return this.factionDao.findAll();
    }

}
