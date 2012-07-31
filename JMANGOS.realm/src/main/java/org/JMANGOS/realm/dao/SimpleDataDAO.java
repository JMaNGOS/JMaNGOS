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
package org.JMANGOS.realm.dao;

import java.util.HashMap;

import org.JMANGOS.realm.model.ClassLevel;
import org.JMANGOS.realm.model.RaceClassLevel;
import org.JMANGOS.realm.model.base.PlayerClassLevelInfo;
import org.JMANGOS.realm.model.base.PlayerLevelInfo;
import org.JMANGOS.common.database.dao.DAO;

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
