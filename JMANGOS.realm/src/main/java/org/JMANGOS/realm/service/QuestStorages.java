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

import javax.inject.Inject;

import gnu.trove.TIntObjectHashMap;

import org.JMANGOS.realm.dao.QuestDAO;
import org.JMANGOS.realm.model.base.PlayerClassLevelInfo;
import org.apache.log4j.Logger;
import org.JMANGOS.common.dataholder.DataLoadService;

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
