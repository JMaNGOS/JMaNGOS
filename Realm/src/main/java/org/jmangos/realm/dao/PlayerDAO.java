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
package org.jmangos.realm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.jmangos.commons.database.DatabaseFactory;
import org.jmangos.commons.database.dao.DAO;
import org.jmangos.realm.domain.InventoryItem;
import org.jmangos.realm.domain.PlayerHomeBindData;
import org.jmangos.realm.domain.CharacterData;
import org.springframework.stereotype.Component;

/**
 * The Class PlayerDAO.
 */
@Component
public class PlayerDAO implements DAO {
    
    @Inject
    private DatabaseFactory databaseFactory;
    
    /**
     * 
     * @see org.jmangos.commons.database.dao.DAO#getClassName()
     */
    @Override
    public String getClassName() {
    
        return PlayerDAO.class.getName();
    }
    
    public CharacterData getCharacter(final long characterId) {
    
        final Session session = this.databaseFactory.getCharactersSessionFactory().openSession();
        final CharacterData characterData = (CharacterData) session.get(CharacterData.class, characterId);
        return characterData;
    }
    
    /**
     * Load home bind.
     * 
     * @param objectId
     *            the object id
     * @return the player home bind data
     */
    public PlayerHomeBindData loadHomeBind(final Long objectId) {
    
        final Session session = this.databaseFactory.getCharactersSessionFactory().openSession();
        final CharacterData characterData = (CharacterData) session.get(CharacterData.class, objectId);
        return characterData.getHomeBindData();
    }
    
    /**
     * Load inventory.
     * 
     * @param objectId
     *            the object id
     * @return the list
     */
    public List<InventoryItem> loadInventory(final Long objectId) {
    
        // TODO: implement
        return new ArrayList<InventoryItem>();
    }
    
}
