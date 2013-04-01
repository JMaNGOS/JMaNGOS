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

import org.jmangos.commons.entities.SpellEntity;
import org.jmangos.world.dao.SpellDao;
import org.jmangos.world.services.SpellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.googlecode.ehcache.annotations.Cacheable;

@Service("spellService")
public class SpellServiceImpl implements SpellService {

    @Autowired
    private SpellDao spellDao;

    @Override
    @Cacheable(cacheName = "spellCache")
    public SpellEntity getSpellById(final Integer id) {

        return this.spellDao.findOne(id);
    }

    @Override
    public List<SpellEntity> readSpells() {

        return this.spellDao.findAll();
    }

}
