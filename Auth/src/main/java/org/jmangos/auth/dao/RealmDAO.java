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

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jmangos.auth.model.Realm;
import org.jmangos.commons.database.DatabaseFactory;
import org.jmangos.commons.database.dao.DAO;

import javolution.util.FastMap;

import java.util.Iterator;
import java.util.List;

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
        Criteria criteria = session.createCriteria(Realm.class);
        FastMap<Integer, Realm> realmFastMap = new FastMap<Integer, Realm>();
        List<Realm> realmList = (List<Realm>)criteria.list();

        for ( Realm realm : realmList )
            realmFastMap.put( realm.getId(), realm );

        session.close();
        return realmFastMap;
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
