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
