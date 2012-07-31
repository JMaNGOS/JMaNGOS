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
package org.JMANGOS.realm.dao.mysql5;

import gnu.trove.TIntObjectHashMap;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.JMANGOS.realm.dao.QuestDAO;
import org.JMANGOS.realm.model.base.PlayerClassLevelInfo;
import org.apache.log4j.Logger;
import org.JMANGOS.common.database.DB;

// TODO: Auto-generated Javadoc
/**
 * DAO that manages items.
 * 
 * @author minimajack
 */
public class MySQL5QuestDAO extends QuestDAO {
	
	/** The Constant log. */
	private static final Logger log = Logger.getLogger(MySQL5QuestDAO.class);

	/* (non-Javadoc)
	 * @see org.wowemu.realm.dao.QuestDAO#loadQuestPrototypes()
	 */
	@Override
	public TIntObjectHashMap<PlayerClassLevelInfo> loadQuestPrototypes() {
		TIntObjectHashMap<PlayerClassLevelInfo> mps = new TIntObjectHashMap<PlayerClassLevelInfo>();
		PreparedStatement st = DB.prepareStatement("SELECT * FROM mangos.quest_template;");

		try {
			st.setFetchSize(Integer.MIN_VALUE);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				mps.put(rs.getInt("entry"), getPrototypeByData(rs));
			}
			rs.close();
		} catch (Exception e) {
			log.error("Can't load ItemPrototypes  ", e);
		} finally {
			DB.close(st);
		}
		return mps;
	}

	/**
	 * Gets the prototype by data.
	 *
	 * @param rs the rs
	 * @return the prototype by data
	 */
	private PlayerClassLevelInfo getPrototypeByData(ResultSet rs) {
		return null;
	}

}
