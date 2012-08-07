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
package org.jmangos.auth.service;

import javax.inject.Inject;

import javolution.util.FastMap;

import org.apache.log4j.Logger;
import org.jmangos.auth.dao.RealmDAO;
import org.jmangos.auth.model.Realm;
import org.jmangos.commons.service.Service;

public class WorldListService implements Service {
	/**
	 * Logger for this class.
	 */
	private static final Logger log = Logger.getLogger(WorldListService.class);

	/**
	 * Map with realms
	 */
	private FastMap<Integer, Realm> realms;

	/** The byte size. */
	private static int byteSize;

	/** The WORL ddao. */
	@Inject
	private RealmDAO WORLDdao;

	/**
	 * Instantiates a new world list service.
	 */
	public WorldListService() {
		realms = new FastMap<Integer, Realm>().shared();
	}

	/**
	 * Gets the worlds.
	 * 
	 * @return the worlds
	 */
	public FastMap<Integer, Realm> getWorlds() {
		return realms;
	}

	/**
	 * Loads list of banned ip.
	 */
	public void start() {
		update();
		log.debug("WorldList loaded " + realms.size() + " realms.");

	}

	/**
	 * Loads account from DB and returns it, or returns null if account was not
	 * loaded.
	 * 
	 * @return loaded account or null
	 */
	public void reload() {
		update();
		log.debug("RealmList reloaded. Loaded " + realms.size() + " realms.");

	}

	/**
	 * Update.
	 */
	private void update() {
		realms = WORLDdao.getAllRealms();
		// update byte size all realms
		setByteSize(calculateWorldsSize());
	}

	/**
	 * Gets the byte size.
	 * 
	 * @return the byteSize
	 */
	public int getByteSize() {
		return byteSize;
	}

	/**
	 * Sets the byte size.
	 * 
	 * @param byteSyze
	 *            the new byte size
	 */
	public static void setByteSize(int byteSyze) {
		WorldListService.byteSize = byteSyze;
	}

	/**
	 * Gets the size.
	 * 
	 * @return the size
	 */
	public int getSize() {
		return realms.size();
	}

	/**
	 * Calculate worlds size.
	 * 
	 * @return the int
	 */
	public int calculateWorldsSize() {
		int value = 8;
		for (Realm realm : realms.values()) {
			value += realm.getSize();
		}
		return value;
	}

	/**
	 * Gets the amount characters.
	 * 
	 * @param id
	 *            the id
	 * @return the amount characters
	 */
	public FastMap<Integer, Integer> getAmountCharacters(Integer id) {
		return getWorldDAO().getAmountCharacters(id);
	}

	private RealmDAO getWorldDAO() {
		return WORLDdao;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.jmangos.commons.service.Service#stop()
	 */
	@Override
	public void stop() {
		realms.clear();
	}

}
