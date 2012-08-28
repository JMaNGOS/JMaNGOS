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
package org.jmangos.realm.services.impl;

import gnu.trove.map.hash.TByteObjectHashMap;

import javax.annotation.PostConstruct;

import org.jmangos.commons.dataholder.DataLoadService;
import org.jmangos.realm.dao.SimpleDataDAO;
import org.jmangos.realm.entities.PlayerXpForLevelEntity;
import org.jmangos.realm.services.SimpleStoragesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The Class SimpleStoragesServiceImpl.
 */
@Service("simpleStoragesService")
public class SimpleStoragesServiceImpl implements DataLoadService<TByteObjectHashMap<PlayerXpForLevelEntity>>, SimpleStoragesService {
    
    /** The Constant log. */
    private static final Logger                        logger         = LoggerFactory.getLogger(SimpleStoragesServiceImpl.class);
    /** The simple data dao. */
    @Autowired
    SimpleDataDAO                                      simpleDataDAO;
    
    /** */
    private TByteObjectHashMap<PlayerXpForLevelEntity> xpForNextLevel = new TByteObjectHashMap<PlayerXpForLevelEntity>();
    
    @PostConstruct
    @Override
    public void start() {
    
        load();
        logger.info("Loaded {} XP level infos.", this.xpForNextLevel.size());
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void stop() {
    
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public TByteObjectHashMap<PlayerXpForLevelEntity> load() {
    
        return this.xpForNextLevel = this.simpleDataDAO.getXpForLevel();
    }
    
    @Override
    public void reload() {
    
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void save() {
    
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public TByteObjectHashMap<PlayerXpForLevelEntity> get() {
    
        return this.xpForNextLevel;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.realm.services.impl.SimpleStoragesService#getXpForLevel(byte)
     */
    @Override
    public Integer getXpForLevel(final byte level) {
    
        if (this.xpForNextLevel.contains(level)) {
            return this.xpForNextLevel.get(level).getXpForNextLevel();
        }
        logger.warn("Level {} does not have XP for level data. Returned 100.", level);
        return 100;
    }
    
}
