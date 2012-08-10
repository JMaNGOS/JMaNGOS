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
package org.jmangos.auth.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.jmangos.auth.model.Account;
import org.jmangos.auth.model.Realm;
import org.jmangos.commons.database.DatabaseFactory;
import org.jmangos.commons.database.dao.DAO;

import javolution.util.FastMap;

import java.util.Iterator;

/**
 * The Class WorldDAO.
 * 
 * @author MinimaJack
 * 
 */
public class RealmDAO implements DAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.wowemu.common.database.dao.DAO#getClassName()
	 */
	@Override
	public String getClassName() {
		return RealmDAO.class.getName();
	}

	/**
	 * Gets the all worlds.
	 * 
	 * @return the all worlds
	 */
	public FastMap<Integer, Realm> getAllRealms() {
        Session session = DatabaseFactory.getAccountsSessionFactory().openSession();
        Query query = session.createQuery("select r from Realm r");
        Iterator<Realm> realmIterator = query.iterate();
        FastMap<Integer, Realm> map = new FastMap<Integer, Realm>();

        while ( realmIterator.hasNext() ) {
            Realm realm = realmIterator.next();
            map.put( realm.getId(), realm );
        }

        session.close();
        return map;
    }

	/**
	 * Gets the amount characters.
	 * 
	 * @param id
	 *            the realm id
	 * @return the amount characters
	 */
	public FastMap<Integer, Integer> getAmountCharacters(final Integer id) {
        // TODO:implement
        return new FastMap<Integer, Integer>();
    }

}
