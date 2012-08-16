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
import java.util.HashSet;
import java.util.Set;

import org.jmangos.auth.dao.BanIpDAO;
import org.jmangos.auth.model.BanIp;
import org.jmangos.commons.database.DB;
import org.jmangos.commons.database.IUStH;
import org.jmangos.commons.database.ParamReadStH;
import org.jmangos.commons.database.ReadStH;
import org.springframework.stereotype.Component;

@Component
public class MySQL5BannedIpDAO extends BanIpDAO {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public BanIp insert(String ip) {
		return insert(ip, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BanIp insert(final String mask, final Long expireTime) {
		BanIp result = new BanIp();
		result.setIp(mask);
		result.setTimeEnd(expireTime);

		if (insert(result))
			return result;
		else
			return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean insert(final BanIp bannedIP) {
		boolean insert = DB
				.insertUpdate(
						"INSERT INTO ip_banned(ip, bandate, unbandate) VALUES (?, ?, ?)",
						new IUStH() {

							@Override
							public void handleInsertUpdate(
									PreparedStatement preparedStatement)
									throws SQLException {
								preparedStatement
										.setString(1, bannedIP.getIp());
								preparedStatement.setLong(2,
										System.currentTimeMillis() / 1000);
								preparedStatement.setLong(3,
										System.currentTimeMillis() / 1000
												+ bannedIP.getTimeEnd());
								preparedStatement.execute();
							}
						});

		if (!insert)
			return false;

		final BanIp result = new BanIp();
		DB.select("SELECT * FROM ip_banned WHERE ip = ?", new ParamReadStH() {

			@Override
			public void setParams(PreparedStatement preparedStatement)
					throws SQLException {
				preparedStatement.setString(1, bannedIP.getIp());
			}

			@Override
			public void handleRead(ResultSet resultSet) throws SQLException {
				resultSet.next(); // mask is unique, only one result allowed
				result.setIp(resultSet.getString("ip"));
				result.setTimeEnd(resultSet.getLong("unbandate"));
			}
		});
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean update(final BanIp bannedIP) {
		return DB.insertUpdate("UPDATE ip_banned SET ip = ?, unbandate = ? ",
				new IUStH() {
					@Override
					public void handleInsertUpdate(
							PreparedStatement preparedStatement)
							throws SQLException {
						preparedStatement.setString(1, bannedIP.getIp());
						preparedStatement.setLong(2, bannedIP.getTimeEnd());
						preparedStatement.execute();
					}
				});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean remove(final String ip) {
		return DB.insertUpdate("DELETE FROM ip_banned WHERE ip = ?",
				new IUStH() {
					@Override
					public void handleInsertUpdate(
							PreparedStatement preparedStatement)
							throws SQLException {
						preparedStatement.setString(1, ip);
						preparedStatement.execute();
					}
				});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean remove(final BanIp bannedIP) {
		return DB.insertUpdate("DELETE FROM ip_banned WHERE ip = ?",
				new IUStH() {

					@Override
					public void handleInsertUpdate(
							PreparedStatement preparedStatement)
							throws SQLException {
						// Changed from id to mask because we don't get id of
						// last inserted ban
						preparedStatement.setString(1, bannedIP.getIp());
						preparedStatement.execute();
					}
				});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<BanIp> getAllBans() {

		final Set<BanIp> result = new HashSet<BanIp>();
		DB.select(
				"SELECT t1.* FROM realmd.ip_banned t1 RIGHT JOIN (select MAX(unbandate) as maxu, ip FROM realmd.ip_banned GROUP BY ip) t2 ON t1.unbandate = t2.maxu AND t1.ip = t2.ip AND t1.unbandate > UNIX_TIMESTAMP()",
				new ReadStH() {
					@Override
					public void handleRead(ResultSet resultSet)
							throws SQLException {
						while (resultSet.next()) {
							BanIp ip = new BanIp();
							ip.setIp(resultSet.getString("ip"));
							ip.setTimeEnd(resultSet.getLong("unbandate"));
							result.add(ip);
						}
					}
				});
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.wowemu.login.dao.BanIpDAO#getBan(java.lang.String)
	 */
	@Override
	public BanIp getBan(final String ip) {
		final BanIp result = new BanIp();
		DB.select(
				" SELECT unbandate FROM ip_banned WHERE (unbandate = bandate OR unbandate > UNIX_TIMESTAMP()) AND ip = ?",
				new ParamReadStH() {

					@Override
					public void setParams(PreparedStatement preparedStatement)
							throws SQLException {
						preparedStatement.setString(1, ip);
					}

					@Override
					public void handleRead(ResultSet resultSet)
							throws SQLException {
						resultSet.next(); // mask is unique, only one
											// result allowed
						result.setIp(resultSet.getString("ip"));
						result.setTimeEnd(resultSet.getLong("unbandate"));
					}
				});
		return result;
	}
}
