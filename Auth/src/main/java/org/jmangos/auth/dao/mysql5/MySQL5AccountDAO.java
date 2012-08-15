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

import org.apache.log4j.Logger;
import org.jmangos.auth.dao.AccountDAO;
import org.jmangos.auth.model.Account;
import org.jmangos.commons.database.DB;
import org.jmangos.commons.database.IUStH;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * MySQL5 Account DAO implementation.
 * 
 * @author MinimaJack
 * 
 */
@Component
public class MySQL5AccountDAO extends AccountDAO {

	/** Logger. */
	private static final Logger log = Logger.getLogger(MySQL5AccountDAO.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Account getAccount(String username) {
		Account account = null;
		PreparedStatement st = DB
				.prepareStatement("SELECT * FROM account WHERE `username` = ?");

		try {
			st.setString(1, username);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				account = new Account(rs.getInt("id"));
				account.setName(username);
				account.setLocked(rs.getByte("locked"));
				account.setPasswordHash(rs.getString("sha_pass_hash"));
				account.setAccessLevel(rs.getByte("gmlevel"));
				account.setLastIp(rs.getString("last_ip"));
				account.setV(rs.getString("v"));
				account.setS(rs.getString("s"));
				account.setSessionKey(rs.getString("sessionkey"));
			}
		} catch (Exception e) {
			log.error("Can't select account with name: " + username, e);
		} finally {
			DB.close(st);
		}

		return account;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getAccountId(String name) {
		int id = -1;
		PreparedStatement st = DB
				.prepareStatement("SELECT `id` FROM account WHERE `name` = ?");

		try {
			st.setString(1, name);

			ResultSet rs = st.executeQuery();

			rs.next();

			id = rs.getInt("id");
		} catch (SQLException e) {
			log.error("Can't select id after account insertion", e);
		} finally {
			DB.close(st);
		}

		return id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getAccountCount() {
		PreparedStatement st = DB
				.prepareStatement("SELECT count(*) AS c FROM account");
		ResultSet rs = DB.executeQuerry(st);

		try {
			rs.next();

			return rs.getInt("c");
		} catch (SQLException e) {
			log.error("Can't get account count", e);
		} finally {
			DB.close(st);
		}

		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.wowemu.login.dao.AccountDAO#updateSecurityKey(org.wowemu.login.model
	 * .Account)
	 */
	public boolean updateSecurityKey(Account account) {
		int result = 0;
		PreparedStatement st = DB
				.prepareStatement("UPDATE account SET v = ?, s = ? WHERE username = ?");

		try {
			st.setString(1, account.getV());
			st.setString(2, account.getS());
			st.setString(3, account.getName());
			st.executeUpdate();
		} catch (SQLException e) {
			log.error("Can't update account");
		} finally {
			DB.close(st);
		}

		return result > 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.wowemu.login.dao.AccountDAO#updateSessionKey(java.lang.String,
	 * java.lang.String)
	 */
	public boolean updateSessionKey(String username, String key) {
		int result = 0;
		PreparedStatement st = DB
				.prepareStatement("UPDATE account SET sessionkey = ? WHERE username = ?");

		try {
			st.setString(1, key);
			st.setString(2, username);
			st.executeUpdate();
		} catch (SQLException e) {
			log.error("Can't update account");
		} finally {
			DB.close(st);
		}

		return result > 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updateLastServer(final int accountId, final byte lastServer) {
		return DB.insertUpdate(
				"UPDATE account_data SET last_server = ? WHERE id = ?",
				new IUStH() {
					@Override
					public void handleInsertUpdate(
							PreparedStatement preparedStatement)
							throws SQLException {
						preparedStatement.setByte(1, lastServer);
						preparedStatement.setInt(2, accountId);
						preparedStatement.execute();
					}
				});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updateLastIp(final int accountId, final String ip) {
		return DB.insertUpdate("UPDATE account SET last_ip = ? WHERE id = ?",
				new IUStH() {
					@Override
					public void handleInsertUpdate(
							PreparedStatement preparedStatement)
							throws SQLException {
						preparedStatement.setString(1, ip);
						preparedStatement.setInt(2, accountId);
						preparedStatement.execute();
					}
				});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getLastIp(final int accountId) {
		String lastIp = "";
		PreparedStatement st = DB
				.prepareStatement("SELECT `last_ip` FROM `account_data` WHERE `id` = ?");

		try {
			st.setInt(1, accountId);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				lastIp = rs.getString("last_ip");
			}
		} catch (Exception e) {
			log.error("Can't select last IP of account ID: " + accountId, e);
			return "";
		} finally {
			DB.close(st);
		}

		return lastIp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.wowemu.login.dao.AccountDAO#getSessionKey(java.lang.String)
	 */
	@Override
	public String getSessionKey(String username) {
		PreparedStatement st = DB
				.prepareStatement("SELECT sessionkey FROM account WHERE `username` = ?");

		try {
			st.setString(1, username);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				return rs.getString("sessionkey");
			}
		} catch (Exception e) {
			log.error("Can't get sessionkey for: " + username, e);
		} finally {
			DB.close(st);
		}
		return null;
	}
}
