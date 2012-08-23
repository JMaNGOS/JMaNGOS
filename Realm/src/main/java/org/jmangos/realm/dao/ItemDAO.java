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

import gnu.trove.map.hash.TLongObjectHashMap;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.jmangos.commons.database.DatabaseFactory;
import org.jmangos.commons.database.dao.DAO;
import org.jmangos.realm.domain.ItemPrototype;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The Class ItemDAO.
 */
@Component
public class ItemDAO implements DAO {
    
    Logger                  log = LoggerFactory.getLogger(getClass());
    
    @Inject
    private DatabaseFactory databaseFactory;
    
    /**
     * 
     * @see org.jmangos.commons.database.dao.DAO#getClassName()
     */
    @Override
    public String getClassName() {
    
        return ItemDAO.class.getName();
    }
    
    /**
     * Load item prototypes.
     * 
     * @return the t int object hash map
     */
    public TLongObjectHashMap<ItemPrototype> loadItemPrototypes() {
    
        Long eTime = System.currentTimeMillis();
        
        final Session session = this.databaseFactory.getWorldSessionFactory().openSession();
        final Query query = session.createQuery("from ItemPrototype order by id");
        
        final TLongObjectHashMap<ItemPrototype> map = new TLongObjectHashMap<ItemPrototype>();
        @SuppressWarnings("unchecked")
        final List<ItemPrototype> itemPrototypeList = query.list();
        
        // Fill map
        for (final ItemPrototype item : itemPrototypeList) {
            map.put(item.getEntry(), item);
        }
        
        eTime = System.currentTimeMillis() - eTime;
        this.log.info(String.format("Loaded [%d] ItemPrototypes under %d ms", map.size(), eTime));
        
        return map;
    }
    
    /**
     * Load item prototype.
     * 
     * @param guid
     *            the guid
     * @return the item prototype
     */
    public ItemPrototype loadItemPrototype(final int guid) {
    
        this.log.info("Loading single item from database with id: " + guid);
        final Session session = this.databaseFactory.getWorldSessionFactory().openSession();
        return (ItemPrototype) session.get(ItemPrototype.class, guid);
    }
}
