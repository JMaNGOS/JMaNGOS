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

import gnu.trove.map.hash.TIntObjectHashMap;

import org.jmangos.commons.database.dao.DAO;
import org.jmangos.realm.model.base.item.ItemPrototype;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemDAO.
 */
public abstract class ItemDAO implements DAO {

	/* (non-Javadoc)
	 * @see org.wowemu.common.database.dao.DAO#getClassName()
	 */
	@Override
	public String getClassName() {
		return  ItemDAO.class.getName();
	}

	/**
	 * Load item prototypes.
	 *
	 * @return the t int object hash map
	 */
	public abstract TIntObjectHashMap<ItemPrototype> loadItemPrototypes();

	/**
	 * Load item prototype.
	 *
	 * @param guid the guid
	 * @return the item prototype
	 */
	public abstract ItemPrototype loadItemPrototype(int guid);
}
