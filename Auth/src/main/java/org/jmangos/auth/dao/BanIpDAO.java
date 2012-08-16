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
/*
 * Copyright (C) 2011 WoWEmu
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If
 * not, see <http://www.gnu.org/licenses/>.
 */
package org.jmangos.auth.dao;

import java.util.Set;

import org.jmangos.auth.model.BanIp;
import org.jmangos.commons.database.dao.DAO;

/**
 * The Class BanIpDAO.
 * 
 * @author MinimaJack
 * 
 */
public abstract class BanIpDAO implements DAO {
	/**
	 * Inserts ip mask to database, returns BannedIP object that represents
	 * inserted mask or null if error.<br>
	 * Expire time is null so ban never expires.<br>
	 * 
	 * @param mask
	 *            ip mask to ban
	 * @return BannedIP object represetns mask or null if error happened
	 */
	public abstract BanIp insert(String mask);

	/**
	 * Inserts ip mask to database with given expireTime.<br>
	 * Null is allowed for expire time in case of infinite ban.<br>
	 * Returns object that represents ip mask or null in case of error.<br>
	 * 
	 * @param mask
	 *            ip mask to ban
	 * @param expireTime
	 *            expiration time of ban
	 * @return object that represetns added ban or null in case of error
	 */
	public abstract BanIp insert(String mask, Long expireTime);

	/**
	 * Inserts BannedIP object to database.<br>
	 * ID of object must be NULL.<br>
	 * If insert was successfull - sets the assigned id to BannedIP object and
	 * returns true.<br>
	 * In case of error returns false without modification of bannedIP object.<br>
	 * 
	 * @param bannedIp
	 *            record to add to db
	 * @return true in case of success or false
	 */
	public abstract boolean insert(BanIp bannedIp);

	/**
	 * Updates BannedIP object.<br>
	 * ID of object must NOT be null.<br>
	 * In case of success returns true.<br>
	 * In case of error returns false.<br>
	 * 
	 * @param bannedIp
	 *            record to update
	 * @return true in case of success or false in other case
	 */
	public abstract boolean update(BanIp bannedIp);

	/**
	 * Removes ban by mask.<br>
	 * Returns true in case of success, false othervise.<br>
	 * 
	 * @param ip
	 *            the ip
	 * @return true in case of success, false in other case
	 */
	public abstract boolean remove(String ip);

	/**
	 * Removes BannedIP record by ID. Id must not be null.<br>
	 * Returns true in case of success, false in case of error
	 * 
	 * @param bannedIp
	 *            record to unban
	 * @return true if removeas wass successfull, false in case of error
	 */
	public abstract boolean remove(BanIp bannedIp);

	/**
	 * Returns all bans from database.
	 * 
	 * @return all bans from database.
	 */
	public abstract Set<BanIp> getAllBans();

	/**
	 * Gets the ban.
	 * 
	 * @param ip
	 *            the ip
	 * @return the ban
	 */
	public abstract BanIp getBan(String ip);

	/**
	 * Returns class name that will be uses as unique identifier for all DAO
	 * classes.
	 * 
	 * @return class name
	 */
	@Override
	public final String getClassName() {
		return BanIpDAO.class.getName();
	}
}
