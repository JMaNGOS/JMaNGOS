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
package org.jmangos.realm.service;

import java.util.HashMap;


import org.apache.log4j.Logger;
import org.jmangos.commons.dataholder.DataLoadService;
import org.jmangos.realm.dao.SimpleDataDAO;
import org.jmangos.realm.model.ClassLevel;
import org.jmangos.realm.model.base.PlayerClassLevelInfo;

import com.google.inject.Inject;

/**
 * The Class PlayerClassLevelInfoStorages.
 */
public class PlayerClassLevelInfoStorages
		implements
			DataLoadService<HashMap<ClassLevel, PlayerClassLevelInfo>> {
	
	/** The Constant log. */
	private static final Logger log = Logger
			.getLogger(PlayerClassLevelInfoStorages.class);
	
	/** The simple data dao. */
	@Inject
	SimpleDataDAO simpleDataDAO;
	
	/** The Player cli. */
	private HashMap<ClassLevel, PlayerClassLevelInfo> playerCLI = new HashMap<ClassLevel, PlayerClassLevelInfo>();

	/* (non-Javadoc)
	 * @see org.jmangos.commons.service.Service#start()
	 */
	@Override
	public void start() {
		load();
		log.info("Loaded " + playerCLI.size() + " PlayerClassLevelInfos");
	}

	/* (non-Javadoc)
	 * @see org.jmangos.commons.service.Service#stop()
	 */
	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.jmangos.commons.dataholder.DataLoadService#load()
	 */
	@Override
	public HashMap<ClassLevel, PlayerClassLevelInfo> load() {
		return playerCLI = simpleDataDAO.getClassLevelInfos();
	}

	/* (non-Javadoc)
	 * @see org.jmangos.commons.dataholder.DataLoadService#reload()
	 */
	@Override
	public HashMap<ClassLevel, PlayerClassLevelInfo> reload() {
		playerCLI.clear();
		return load();
	}

	/* (non-Javadoc)
	 * @see org.jmangos.commons.dataholder.DataLoadService#save()
	 */
	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	/**
	 * Gets the.
	 *
	 * @param clazz the clazz
	 * @param level the level
	 * @return the player class level info
	 */
	public PlayerClassLevelInfo get(byte clazz, byte level) {
		ClassLevel cl = new ClassLevel(clazz, level);
		if (playerCLI.containsKey(cl)) {
			return playerCLI.get(cl);
		} else {
			log.warn("can't find proper PlayerClassLevelInfo");
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see org.jmangos.commons.dataholder.DataLoadService#get()
	 */
	@Override
	public HashMap<ClassLevel, PlayerClassLevelInfo> get() {
		// TODO Auto-generated method stub
		return null;
	}

}
