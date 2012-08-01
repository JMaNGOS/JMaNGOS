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
