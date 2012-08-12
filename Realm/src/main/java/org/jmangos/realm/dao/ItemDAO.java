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
package org.jmangos.realm.dao;

import gnu.trove.map.hash.TIntObjectHashMap;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jmangos.commons.database.DatabaseFactory;
import org.jmangos.commons.database.dao.DAO;
import org.jmangos.realm.model.base.item.ItemPrototype;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemDAO.
 */
public class ItemDAO implements DAO {
    Logger log = Logger.getLogger( getClass() );

	/* (non-Javadoc)
	 * @see org.jmangos.commons.database.dao.DAO#getClassName()
	 */
	@Override
	public String getClassName() {
		return  ItemDAO.class.getName();
	}

	/**
	 * Load item prototypes.
	 *
	 * @return the t int object hash map
	 */
	public TIntObjectHashMap<ItemPrototype> loadItemPrototypes() {
        Long eTime = System.currentTimeMillis();

        Session session = DatabaseFactory.getWorldSessionFactory().openSession();
        Query query = session.createQuery( "from ItemPrototype" );

        TIntObjectHashMap<ItemPrototype> map = new TIntObjectHashMap<ItemPrototype>();
        List<ItemPrototype> itemPrototypeList = (List<ItemPrototype>)query.list();

        // Fill map
        for ( ItemPrototype item : itemPrototypeList ) {
            map.put( item.getEntry(), item );
        }

        eTime = System.currentTimeMillis() - eTime;
        log.info( String.format( "Loaded [%d] ItemPrototypes under %d ms", map.size(), eTime ) );

        return map;
    }

	/**
	 * Load item prototype.
	 *
	 * @param guid the guid
	 * @return the item prototype
	 */
	public ItemPrototype loadItemPrototype(int guid) {
        Session session = DatabaseFactory.getWorldSessionFactory().openSession();
        return (ItemPrototype)session.get( ItemPrototype.class, guid );
    }
}
