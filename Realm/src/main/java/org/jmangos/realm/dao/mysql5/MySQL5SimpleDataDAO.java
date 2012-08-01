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
