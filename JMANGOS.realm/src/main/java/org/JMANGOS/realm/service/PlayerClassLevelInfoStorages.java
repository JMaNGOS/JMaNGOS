/*******************************************************************************
 * Copyright (c) 2011 WoWEmu
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *    WoWEmu  - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.realm.service;

import java.util.HashMap;


import org.JMANGOS.realm.dao.SimpleDataDAO;
import org.JMANGOS.realm.model.ClassLevel;
import org.JMANGOS.realm.model.base.PlayerClassLevelInfo;
import org.apache.log4j.Logger;
import org.JMANGOS.common.dataholder.DataLoadService;

import com.google.inject.Inject;

// TODO: Auto-generated Javadoc
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
	private HashMap<ClassLevel, PlayerClassLevelInfo> PlayerCLI = new HashMap<ClassLevel, PlayerClassLevelInfo>();

	/* (non-Javadoc)
	 * @see org.wowemu.common.service.Service#start()
	 */
	@Override
	public void start() {
		load();
		log.info("Loaded " + PlayerCLI.size() + " PlayerClassLevelInfos");
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.service.Service#stop()
	 */
	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.dataholder.DataLoadService#load()
	 */
	@Override
	public HashMap<ClassLevel, PlayerClassLevelInfo> load() {
		return PlayerCLI = simpleDataDAO.getClassLevelInfos();
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.dataholder.DataLoadService#reload()
	 */
	@Override
	public HashMap<ClassLevel, PlayerClassLevelInfo> reload() {
		PlayerCLI.clear();
		return load();
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.dataholder.DataLoadService#save()
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
		if (PlayerCLI.containsKey(cl)) {
			return PlayerCLI.get(cl);
		} else {
			log.warn("can't find proper PlayerClassLevelInfo");
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.dataholder.DataLoadService#get()
	 */
	@Override
	public HashMap<ClassLevel, PlayerClassLevelInfo> get() {
		// TODO Auto-generated method stub
		return null;
	}

}
