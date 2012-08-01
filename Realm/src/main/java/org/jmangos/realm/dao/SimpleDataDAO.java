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

import java.util.HashMap;

import org.jmangos.commons.database.dao.DAO;
import org.jmangos.realm.model.ClassLevel;
import org.jmangos.realm.model.RaceClassLevel;
import org.jmangos.realm.model.base.PlayerClassLevelInfo;
import org.jmangos.realm.model.base.PlayerLevelInfo;

// TODO: Auto-generated Javadoc
/**
 * The Class SimpleDataDAO.
 */
public abstract class SimpleDataDAO implements DAO {

	/* (non-Javadoc)
	 * @see org.wowemu.common.database.dao.DAO#getClassName()
	 */
	@Override
	public String getClassName() {
		return  SimpleDataDAO.class.getName();
	}

	/**
	 * Gets the class level infos.
	 *
	 * @return the class level infos
	 */
	public abstract HashMap<ClassLevel, PlayerClassLevelInfo> getClassLevelInfos();

	/**
	 * Gets the race class level infos.
	 *
	 * @return the race class level infos
	 */
	public abstract HashMap<RaceClassLevel, PlayerLevelInfo> getRaceClassLevelInfos();

}
