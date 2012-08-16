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

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.jmangos.commons.database.DatabaseFactory;
import org.jmangos.realm.model.base.PlayerClassLevelInfo;
import org.jmangos.realm.model.base.QuestPrototype;

import java.util.List;

/**
 * The Class QuestDAO.
 */
public class QuestDAO {

	/**
	 * Load quest prototypes.
	 * @return the t int object hash map
	 */
	public TIntObjectHashMap<QuestPrototype> loadQuestPrototypes() {
        Session session = DatabaseFactory.getWorldSessionFactory().openSession();
        Criteria criteria = session.createCriteria(QuestPrototype.class);
        List<QuestPrototype> questPrototypeList = criteria.list();

        // Quest map by id
        TIntObjectHashMap<QuestPrototype> map = new TIntObjectHashMap<QuestPrototype>();

        for ( QuestPrototype quest : questPrototypeList ) {
            map.put( quest.getEntry(), quest );
        }

        return map;
    }

}
