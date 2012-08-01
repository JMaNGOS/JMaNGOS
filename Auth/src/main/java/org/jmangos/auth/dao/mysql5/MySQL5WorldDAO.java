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

import org.jmangos.auth.dao.WorldDAO;
import org.jmangos.auth.model.World;
import org.jmangos.commons.database.DB;
import org.jmangos.commons.database.ParamReadStH;
import org.jmangos.commons.database.ReadStH;

import javolution.util.FastMap;

// TODO: Auto-generated Javadoc
/**
 * The Class MySQL5WorldDAO.
 *
 * @author minimajack
 * @desc World DAO implementation for MySQL5
 */
public class MySQL5WorldDAO extends WorldDAO {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FastMap<Integer, World> getAllWorlds() {

		final FastMap<Integer, World> result = new FastMap<Integer, World>();
		DB
				.select(
						"SELECT * FROM realmd.realmlist WHERE (realmflags & 1) = 0 ORDER BY name;",
						new ReadStH() {
							@Override
							public void handleRead(ResultSet resultSet)
									throws SQLException {
								while (resultSet.next()) {
									World world = new World();
									world.setId(resultSet.getInt("id"));
									world.setName(resultSet.getString("name"));
									world.setAddress(resultSet
											.getString("address"));
									world.setPort(resultSet.getInt("port"));
									world.setIcon(resultSet.getInt("icon"));
									world.setRealmflags(resultSet
											.getInt("realmflags"));
									world.setTimezone(resultSet
											.getInt("timezone"));
									world.setAllowedSecurityLevel(resultSet
											.getInt("allowedSecurityLevel"));
									world.setPopulation(resultSet
											.getFloat("population"));
									world.setRealmbuilds(resultSet
											.getString("realmbuilds"));
									result.put(world.getId(), world);
								}
							}
						});
		return result;
	}

	/* (non-Javadoc)
	 * @see org.wowemu.login.dao.WorldDAO#getAmountCharacters(java.lang.Integer)
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
							result.put(resultSet.getInt("realmid"), resultSet
									.getInt("numchars"));
						}
					}

				});
		return result;
	}
}
