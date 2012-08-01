/*******************************************************************************
 * Copyright (c) 2012 JMANGOS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     JMANGOS - initial API and implementation
 ******************************************************************************/
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
