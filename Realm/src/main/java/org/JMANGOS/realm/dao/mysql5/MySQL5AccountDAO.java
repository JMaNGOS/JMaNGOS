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

import org.JMANGOS.realm.dao.AccountDAO;
import org.JMANGOS.realm.model.account.Account;
import org.JMANGOS.realm.model.account.AccountData;
import org.JMANGOS.realm.model.base.character.CharactersData;
import org.apache.log4j.Logger;
import org.JMANGOS.common.database.DB;
import org.JMANGOS.common.database.IUStH;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


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
				.prepareStatement("SELECT * FROM realmd.account WHERE `username` = ?");

		try {
			st.setString(1, username);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				account = new Account(rs.getInt("id"));
				account.setName(rs.getString("username"));
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
				.prepareStatement("SELECT `id` FROM realmd.account WHERE `name` = ?");

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
				.prepareStatement("SELECT count(*) AS c FROM realmd.account");
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

	/* (non-Javadoc)
	 * @see org.wowemu.realm.dao.AccountDAO#updateSecurityKey(org.wowemu.realm.model.account.Account)
	 */
	public boolean updateSecurityKey(Account account) {
		int result = 0;
		PreparedStatement st = DB
				.prepareStatement("UPDATE realmd.account SET v = ?, s = ? WHERE username = ?");

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

	/* (non-Javadoc)
	 * @see org.wowemu.realm.dao.AccountDAO#saveSessionKey(java.lang.String, java.lang.String)
	 */
	public boolean saveSessionKey(String username, String key) {
		int result = 0;
		PreparedStatement st = DB
				.prepareStatement("UPDATE realmd.account SET sessionkey = ? WHERE username = ?");

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
				"UPDATE realmd.account_data SET last_server = ? WHERE id = ?",
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
		return DB.insertUpdate(
				"UPDATE realmd.account SET last_ip = ? WHERE id = ?",
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
				.prepareStatement("SELECT `last_ip` FROM realmd.`account_data` WHERE `id` = ?");

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
				.prepareStatement("SELECT sessionkey FROM realmd.account WHERE `username` = ?");

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

	/* (non-Javadoc)
	 * @see org.wowemu.realm.dao.AccountDAO#getAccountData(int)
	 */
	@Override
	public HashMap<Integer, AccountData> getAccountData(int id) {
		PreparedStatement st = DB
				.prepareStatement("SELECT `time`, `data` ,`type` FROM `characters`.`character_account_data` WHERE `guid` = ?");
		HashMap<Integer, AccountData> adf = new HashMap<Integer, AccountData>();
		try {
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				AccountData ad = new AccountData();
				ad.setTime(rs.getInt("time"));
				ad.setData(rs.getString("data"));
				adf.put(rs.getInt("type"), ad);
			}
		} catch (Exception e) {
			log.error("Can't get AccountData for account with id: " + id, e);
		} finally {
			DB.close(st);
		}
		return adf;
	}

	/* (non-Javadoc)
	 * @see org.wowemu.realm.dao.AccountDAO#getCharactersData(int)
	 */
	@Override
	public List<CharactersData> getCharactersData(int guid) {
		PreparedStatement st = DB
				.prepareStatement("SELECT characters.guid, characters.name, characters.race, characters.class, characters.gender, characters.playerBytes, characters.playerBytes2, characters.level,"
						+ "characters.zone, characters.map, characters.position_x, characters.position_y, characters.position_z, characters.orientation, guild_member.guildid, characters.playerFlags, "
						+ "characters.at_login, character_pet.entry, character_pet.modelid, character_pet.level, characters.equipmentCache "
						+ "FROM characters.characters LEFT JOIN characters.character_pet ON characters.guid=character_pet.owner AND character_pet.slot=0 "
						+ "LEFT JOIN characters.guild_member ON characters.guid = guild_member.guid "
						+ "WHERE characters.account = ? ORDER BY characters.guid");
		List<CharactersData> adf = new ArrayList<CharactersData>();
		try {
			st.setInt(1, guid);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				CharactersData cd = new CharactersData(rs.getInt("guid"));
				cd.setGuid(rs.getInt("guid"));
				cd.setName(rs.getString("name"));
				cd.setRace(rs.getByte("race"));
				cd.setClazz(rs.getByte("class"));
				cd.setGender(rs.getByte("gender"));
				cd.setPlayerBytes(rs.getInt("playerBytes"));
				cd.setPlayerBytes2(rs.getInt("playerBytes2"));
				cd.setLevel(rs.getByte("level"));
				cd.setZone(rs.getInt("zone"));
				cd.setMap(rs.getInt("map"));
				cd.setPos_x(rs.getFloat("position_x"));
				cd.setPos_y(rs.getFloat("position_y"));
				cd.setPos_z(rs.getFloat("position_z"));
				cd.setGuildId(rs.getInt("guildid"));
				cd.setPlayerFlags(rs.getInt("playerFlags"));
				cd.setItemsFromCache(rs.getString("equipmentCache").split(" "));
				cd.setOrientation(rs.getFloat("orientation"));
				adf.add(cd);
			}
		} catch (Exception e) {
			log.error("Can't get AccountData for account with id: " + guid, e);
		} finally {
			DB.close(st);
		}
		return adf;
	}

	/* (non-Javadoc)
	 * @see org.wowemu.realm.dao.AccountDAO#getTutorialsData(int)
	 */
	@Override
	public int[] getTutorialsData(int guid) {
		PreparedStatement st = DB
				.prepareStatement("SELECT tut0,tut1,tut2,tut3,tut4,tut5,tut6,tut7 FROM characters.character_tutorial WHERE account =?");
		int[] tutData = new int[8];
		try {
			st.setInt(1, guid);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				for (int i = 0; i < 8; ++i)
					tutData[i] = rs.getInt(i+1);
			}
		} catch (Exception e) {
			log.error("Can't get TutorialsData for account with id: " + guid, e);
		} finally {
			DB.close(st);
		}
		return tutData;
	}
}
