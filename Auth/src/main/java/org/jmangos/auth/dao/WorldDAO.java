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
package org.jmangos.auth.dao;

import org.jmangos.auth.model.World;
import org.jmangos.commons.database.dao.DAO;

import javolution.util.FastMap;

/**
 * The Class WorldDAO.
 * 
 * @author MinimaJack
 * 
 */
public abstract class WorldDAO implements DAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.wowemu.common.database.dao.DAO#getClassName()
	 */
	@Override
	public String getClassName() {
		return WorldDAO.class.getName();
	}

	/**
	 * Gets the all worlds.
	 * 
	 * @return the all worlds
	 */
	public abstract FastMap<Integer, World> getAllWorlds();

	/**
	 * Gets the amount characters.
	 * 
	 * @param id
	 *            the id
	 * @return the amount characters
	 */
	public abstract FastMap<Integer, Integer> getAmountCharacters(
			final Integer id);

}
