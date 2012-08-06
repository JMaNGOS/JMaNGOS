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
package org.jmangos.realm.dao.mysql5;

import gnu.trove.map.hash.TIntObjectHashMap;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;
import org.jmangos.commons.database.DB;
import org.jmangos.realm.dao.QuestDAO;
import org.jmangos.realm.model.base.PlayerClassLevelInfo;

// TODO: Auto-generated Javadoc
/**
 * DAO that manages items.
 * 
 * @author MinimaJack
 */
public class MySQL5QuestDAO extends QuestDAO {
	
	/** The Constant log. */
	private static final Logger log = Logger.getLogger(MySQL5QuestDAO.class);

	/* (non-Javadoc)
	 * @see org.jmangos.realm.dao.QuestDAO#loadQuestPrototypes()
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
