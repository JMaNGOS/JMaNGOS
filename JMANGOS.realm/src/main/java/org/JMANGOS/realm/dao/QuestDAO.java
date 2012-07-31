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

import gnu.trove.TIntObjectHashMap;

import org.JMANGOS.realm.model.base.PlayerClassLevelInfo;

// TODO: Auto-generated Javadoc
/**
 * The Class QuestDAO.
 */
public abstract class QuestDAO {

	/**
	 * Load quest prototypes.
	 *
	 * @return the t int object hash map
	 */
	public abstract TIntObjectHashMap<PlayerClassLevelInfo> loadQuestPrototypes();

}
