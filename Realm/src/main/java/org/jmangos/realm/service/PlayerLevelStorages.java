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

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.jmangos.commons.dataholder.DataLoadService;
import org.jmangos.realm.dao.SimpleDataDAO;
import org.jmangos.realm.model.RaceClassLevel;
import org.jmangos.realm.model.base.PlayerLevelInfo;
import org.springframework.stereotype.Component;

/**
 * The Class PlayerLevelStorages.
 */
@Component
public class PlayerLevelStorages implements
		DataLoadService<HashMap<RaceClassLevel, PlayerLevelInfo>> {

	/** The Constant log. */
	private static final Logger log = Logger
			.getLogger(PlayerLevelStorages.class);

	/** The simple data dao. */
	@Inject
	SimpleDataDAO simpleDataDAO;

	/** The Player Race Class Level info. */
	private HashMap<RaceClassLevel, PlayerLevelInfo> playerRCLI = new HashMap<RaceClassLevel, PlayerLevelInfo>();

	/**
	 * 
	 * @see org.jmangos.commons.service.Service#start()
	 */
	@PostConstruct
	@Override
	public void start() {
		load();
		log.info("Loaded " + playerRCLI.size() + " PlayerLevelInfos");

	}

	/**
	 * 
	 * @see org.jmangos.commons.service.Service#stop()
	 */
	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @see org.jmangos.commons.dataholder.DataLoadService#load()
	 */
	@Override
	public HashMap<RaceClassLevel, PlayerLevelInfo> load() {
		// TODO Auto-generated method stub
		return playerRCLI = simpleDataDAO.getRaceClassLevelInfos();
	}

	/**
	 * 
	 * @see org.jmangos.commons.dataholder.DataLoadService#reload()
	 */
	@Override
	public HashMap<RaceClassLevel, PlayerLevelInfo> reload() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @see org.jmangos.commons.dataholder.DataLoadService#save()
	 */
	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @see org.jmangos.commons.dataholder.DataLoadService#get()
	 */
	@Override
	public HashMap<RaceClassLevel, PlayerLevelInfo> get() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Gets the.
	 * 
	 * @param race
	 *            the race
	 * @param clazz
	 *            the clazz
	 * @param level
	 *            the level
	 * @return the player level info
	 */
	public PlayerLevelInfo get(int race, int clazz, int level) {
		RaceClassLevel cl = new RaceClassLevel(race, clazz, level);
		if (playerRCLI.containsKey(cl)) {
			return playerRCLI.get(cl);
		} else {
			log.warn("can't find proper PlayerClassLevelInfo");
			return null;
		}
	}

}
