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

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.jmangos.commons.database.DB;
import org.jmangos.realm.dao.SimpleDataDAO;
import org.jmangos.realm.model.ClassLevel;
import org.jmangos.realm.model.RaceClassLevel;
import org.jmangos.realm.model.base.PlayerClassLevelInfo;
import org.jmangos.realm.model.base.PlayerLevelInfo;

// TODO: Auto-generated Javadoc
/**
 * DAO that manages items.
 * 
 * @author minimajack
 */
public class MySQL5SimpleDataDAO extends SimpleDataDAO {
	
	/** The Constant log. */
	private static final Logger log = Logger
			.getLogger(MySQL5SimpleDataDAO.class);
	
	/* (non-Javadoc)
	 * @see org.wowemu.realm.dao.SimpleDataDAO#getClassLevelInfos()
	 */
	@Override
	public HashMap<ClassLevel, PlayerClassLevelInfo> getClassLevelInfos() {
		HashMap<ClassLevel, PlayerClassLevelInfo> mps = new HashMap<ClassLevel, PlayerClassLevelInfo>();
		PreparedStatement st = DB
				.prepareStatement("SELECT * FROM mangos.player_classlevelstats;");
		try {
			st.setFetchSize(Integer.MIN_VALUE);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				mps.put(new ClassLevel(rs.getInt("class"), rs.getInt("level")),
						new PlayerClassLevelInfo(rs.getInt("basehp"), rs
								.getInt("basemana")));
			}
			rs.close();
		} catch (Exception e) {
			log.error("Can't load classlevelstats  ", e);
		} finally {
			DB.close(st);
		}
		return mps;
	}
	
	/* (non-Javadoc)
	 * @see org.wowemu.realm.dao.SimpleDataDAO#getRaceClassLevelInfos()
	 */
	@Override
	public HashMap<RaceClassLevel, PlayerLevelInfo> getRaceClassLevelInfos() {
		HashMap<RaceClassLevel, PlayerLevelInfo> mps = new HashMap<RaceClassLevel, PlayerLevelInfo>();
		PreparedStatement st = DB
				.prepareStatement("SELECT * FROM mangos.player_levelstats;");
		try {
			st.setFetchSize(Integer.MIN_VALUE);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				mps.put(new RaceClassLevel(rs.getInt("race"), rs
						.getInt("class"), rs.getInt("level")),
						new PlayerLevelInfo(new int[]{rs.getInt("str"),
								rs.getInt("agi"), rs.getInt("sta"),
								rs.getInt("inte"), rs.getInt("spi")}));
			}
			rs.close();
		} catch (Exception e) {
			log.error("Can't load PlayerLevelInfo  ", e);
		} finally {
			DB.close(st);
		}
		return mps;
	}

}
