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
package org.jmangos.auth.dao.mysql5;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jmangos.auth.dao.RealmDAO;
import org.jmangos.auth.model.Realm;
import org.jmangos.commons.database.DB;
import org.jmangos.commons.database.ParamReadStH;
import org.jmangos.commons.database.ReadStH;
import org.springframework.stereotype.Component;

import javolution.util.FastMap;

/**
 * The Class MySQL5RealmDAO.
 * 
 * @author MinimaJack
 * 
 * @desc Realm DAO implementation for MySQL5
 */
@Component
public class MySQL5RealmDAO extends RealmDAO {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FastMap<Integer, Realm> getAllRealms() {

		final FastMap<Integer, Realm> result = new FastMap<Integer, Realm>();
		DB.select(
				"SELECT * FROM realmd.realmlist WHERE (realmflags & 1) = 0 ORDER BY name;",
				new ReadStH() {
					@Override
					public void handleRead(ResultSet resultSet)
							throws SQLException {
						while (resultSet.next()) {
							Realm realm = new Realm();
							realm.setId(resultSet.getInt("id"));
							realm.setName(resultSet.getString("name"));
							realm.setAddress(resultSet.getString("address"));
							realm.setPort(resultSet.getInt("port"));
							realm.setIcon(resultSet.getInt("icon"));
							realm.setRealmflags(resultSet.getInt("realmflags"));
							realm.setTimezone(resultSet.getInt("timezone"));
							realm.setAllowedSecurityLevel(resultSet
									.getInt("allowedSecurityLevel"));
							realm.setPopulation(resultSet
									.getFloat("population"));
							realm.setRealmbuilds(resultSet
									.getString("realmbuilds"));
							result.put(realm.getId(), realm);
						}
					}
				});
		return result;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.jmangos.login.dao.RealmDAO#getAmountCharacters(java.lang.Integer)
	 */
	public FastMap<Integer, Integer> getAmountCharacters(final Integer id) {
		final FastMap<Integer, Integer> result = new FastMap<Integer, Integer>();
		DB.select(
				"SELECT realmid,numchars FROM realmcharacters WHERE acctid=?",
				new ParamReadStH() {
					@Override
					public void setParams(PreparedStatement preparedStatement)
							throws SQLException {
						preparedStatement.setInt(1, id);
					}

					@Override
					public void handleRead(ResultSet resultSet)
							throws SQLException {
						while (resultSet.next()) {
							result.put(resultSet.getInt("realmid"),
									resultSet.getInt("numchars"));
						}
					}

				});
		return result;
	}
}
