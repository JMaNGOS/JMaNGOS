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

import javax.inject.Inject;

import gnu.trove.map.hash.TIntObjectHashMap;

import org.apache.log4j.Logger;
import org.jmangos.commons.dataholder.DataLoadService;
import org.jmangos.realm.dao.QuestDAO;
import org.jmangos.realm.model.base.PlayerClassLevelInfo;

// TODO: Auto-generated Javadoc
/**
 * The Class QuestStorages.
 */
public class QuestStorages
		implements
			DataLoadService<TIntObjectHashMap<PlayerClassLevelInfo>> {

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(QuestStorages.class);

	/** The player class level infos. */
	private TIntObjectHashMap<PlayerClassLevelInfo> playerClassLevelInfos = new TIntObjectHashMap<PlayerClassLevelInfo>();
	
	/** The quest dao. */
	@Inject
	private QuestDAO questDAO;

	/* (non-Javadoc)
	 * @see org.wowemu.common.service.Service#start()
	 */
	@Override
	public void start() {
		load();
		logger.info("Loaded " + playerClassLevelInfos.size() + " questPrototypes");

	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.service.Service#stop()
	 */
	@Override
	public void stop() {
		playerClassLevelInfos.clear();

	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.dataholder.DataLoadService#load()
	 */
	@Override
	public TIntObjectHashMap<PlayerClassLevelInfo> load() {
		playerClassLevelInfos = questDAO.loadQuestPrototypes();
		return playerClassLevelInfos;
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.dataholder.DataLoadService#reload()
	 */
	@Override
	public TIntObjectHashMap<PlayerClassLevelInfo> reload() {
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
	public TIntObjectHashMap<PlayerClassLevelInfo> get() {
		// TODO Auto-generated method stub
		return null;
	}

}
