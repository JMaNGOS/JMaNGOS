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

import org.hibernate.Session;
import org.jmangos.commons.database.DatabaseFactory;
import org.jmangos.commons.database.dao.DAO;
import org.jmangos.realm.model.InventoryTemplate;
import org.jmangos.realm.model.base.character.CharacterData;
import org.jmangos.realm.model.player.PlayerHomeBindData;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerDAO.
 */
public class PlayerDAO implements DAO {

	/* (non-Javadoc)
	 * @see org.jmangos.commons.database.dao.DAO#getClassName()
	 */
	@Override
	public String getClassName() {
		return PlayerDAO.class.getName();
	}

    public CharacterData getCharacter( long characterId ) {
        Session session = DatabaseFactory.getCharactersSessionFactory().openSession();
        CharacterData characterData = (CharacterData)session.get( CharacterData.class, characterId );
        return characterData;
    }

	/**
	 * Load home bind.
	 *
	 * @param objectId the object id
	 * @return the player home bind data
	 */
	public PlayerHomeBindData loadHomeBind(int objectId) {
        Session session = DatabaseFactory.getCharactersSessionFactory().openSession();
        CharacterData characterData = (CharacterData)session.get( CharacterData.class, objectId );
        return characterData.getHomeBindData();
    }

	/**
	 * Load inventory.
	 *
	 * @param objectId the object id
	 * @return the list
	 */
	public List<InventoryTemplate> loadInventory(int objectId) {
        // TODO: implement
        return new ArrayList<InventoryTemplate>();
    }

}
