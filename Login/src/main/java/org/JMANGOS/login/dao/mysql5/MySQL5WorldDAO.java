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
package org.JMANGOS.login.dao.mysql5;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.JMANGOS.common.database.DB;
import org.JMANGOS.common.database.ParamReadStH;
import org.JMANGOS.common.database.ReadStH;
import org.JMANGOS.login.dao.WorldDAO;
import org.JMANGOS.login.model.World;

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
