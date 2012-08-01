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

import java.util.List;

import org.jmangos.commons.database.dao.DAO;
import org.jmangos.realm.model.InventoryTemplate;
import org.jmangos.realm.model.player.PlayerCharacterData;
import org.jmangos.realm.model.player.PlayerHomeBindData;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerDAO.
 */
public abstract class PlayerDAO implements DAO {

	/* (non-Javadoc)
	 * @see org.wowemu.common.database.dao.DAO#getClassName()
	 */
	@Override
	public String getClassName() {
		return PlayerDAO.class.getName();
	}

	/**
	 * Load home bind.
	 *
	 * @param objectId the object id
	 * @return the player home bind data
	 */
	public abstract PlayerHomeBindData loadHomeBind(int objectId);

	/**
	 * Load from db.
	 *
	 * @param objectId the object id
	 * @return the player character data
	 */
	public abstract PlayerCharacterData loadFromDB(int objectId);

	/**
	 * Load inventory.
	 *
	 * @param objectId the object id
	 * @return the list
	 */
	public abstract List<InventoryTemplate> loadInventory(int objectId) ;

}
