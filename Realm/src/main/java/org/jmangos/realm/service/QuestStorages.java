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

import gnu.trove.map.hash.TIntObjectHashMap;

import java.util.List;

import javax.inject.Inject;

import org.jmangos.commons.dataholder.DataLoadService;
import org.jmangos.world.entities.QuestPrototype;
import org.jmangos.world.services.QuestPrototypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The Class QuestStorages.
 */
@Component
public class QuestStorages implements DataLoadService<TIntObjectHashMap<QuestPrototype>> {
    
    /** The Constant logger. */
    private static final Logger               logger   = LoggerFactory.getLogger(QuestStorages.class);
    
    /** The player class level infos. */
    private TIntObjectHashMap<QuestPrototype> questMap = new TIntObjectHashMap<QuestPrototype>();
    
    @Inject
    QuestPrototypeService                     questPrototypeService;
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.service.Service#start()
     */
    @Override
    public void start() {
    
        load();
        logger.info("Loaded " + this.questMap.size() + " questPrototypes");
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.service.Service#stop()
     */
    @Override
    public void stop() {
    
        this.questMap.clear();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.dataholder.DataLoadService#load()
     */
    @Override
    public TIntObjectHashMap<QuestPrototype> load() {
    
        final List<QuestPrototype> questPrototypeList = this.questPrototypeService.readQuestPrototypes();
        
        // Quest map by id
        final TIntObjectHashMap<QuestPrototype> map = new TIntObjectHashMap<QuestPrototype>();
        
        for (final QuestPrototype quest : questPrototypeList) {
            map.put(quest.getEntry(), quest);
        }
        
        this.questMap = map;
        return this.questMap;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.dataholder.DataLoadService#reload()
     */
    @Override
    public void reload() {
    
        // Don't replace directly becouse the players can't query quest while it's loading!
        logger.info("Loading quest templates to temoary store.");
        final List<QuestPrototype> questPrototypeList = this.questPrototypeService.readQuestPrototypes();
        TIntObjectHashMap<QuestPrototype> tempQuestMap = new TIntObjectHashMap<QuestPrototype>();
        for (final QuestPrototype quest : questPrototypeList) {
            tempQuestMap.put(quest.getEntry(), quest);
        }
        logger.info("Loaded " + tempQuestMap.size() + " quests. Replacing new old Quests with newer");
        this.questMap = tempQuestMap;
        tempQuestMap = null;
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
    public TIntObjectHashMap<QuestPrototype> get() {
    
        // TODO Auto-generated method stub
        return null;
    }
    
    // Specific getters
    public QuestPrototype getQuest(final int questId) {
    
        return this.questMap.get(questId);
    }
}
