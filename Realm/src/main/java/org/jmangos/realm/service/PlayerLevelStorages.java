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
package org.jmangos.realm.service;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.jmangos.commons.dataholder.DataLoadService;
import org.jmangos.realm.dao.SimpleDataDAO;
import org.jmangos.realm.model.RaceClassLevel;
import org.jmangos.realm.model.base.PlayerLevelInfo;

import com.google.inject.Inject;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerLevelStorages.
 */
public class PlayerLevelStorages
		implements
			DataLoadService<HashMap<RaceClassLevel, PlayerLevelInfo>> {
	
	/** The Constant log. */
	private static final Logger log = Logger
	.getLogger(PlayerLevelStorages.class);
	
	/** The simple data dao. */
	@Inject
	SimpleDataDAO simpleDataDAO;
	
	/** The Player Race Class Level info. */
	private HashMap<RaceClassLevel, PlayerLevelInfo> PlayerRCLI = new HashMap<RaceClassLevel, PlayerLevelInfo>();
	
	/* (non-Javadoc)
	 * @see org.wowemu.common.service.Service#start()
	 */
	@Override
	public void start() {
		load();
		log.info("Loaded " + PlayerRCLI.size() + " PlayerLevelInfos");
		
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
	public HashMap<RaceClassLevel, PlayerLevelInfo> load() {
		// TODO Auto-generated method stub
		return PlayerRCLI = simpleDataDAO.getRaceClassLevelInfos();
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.dataholder.DataLoadService#reload()
	 */
	@Override
	public HashMap<RaceClassLevel, PlayerLevelInfo> reload() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.dataholder.DataLoadService#save()
	 */
	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.dataholder.DataLoadService#get()
	 */
	@Override
	public HashMap<RaceClassLevel, PlayerLevelInfo> get() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Gets the.
	 *
	 * @param race the race
	 * @param clazz the clazz
	 * @param level the level
	 * @return the player level info
	 */
	public PlayerLevelInfo get(int race, int clazz, int level) {
		RaceClassLevel cl = new RaceClassLevel(race, clazz, level);
		if (PlayerRCLI.containsKey(cl)) {
			return PlayerRCLI.get(cl);
		} else {
			log.warn("can't find proper PlayerClassLevelInfo");
			return null;
		}
	}

}
