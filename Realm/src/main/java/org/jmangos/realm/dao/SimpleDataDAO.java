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

import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.jmangos.commons.database.DatabaseFactory;
import org.jmangos.commons.database.dao.DAO;
import org.jmangos.realm.model.base.PlayerClassLevelInfo;
import org.jmangos.realm.model.base.PlayerClassLevelInfoPK;
import org.jmangos.realm.model.base.PlayerLevelInfo;
import org.jmangos.realm.model.base.PlayerLevelInfoPK;

/**
 * The Class SimpleDataDAO.
 */
public class SimpleDataDAO implements DAO {

	/* (non-Javadoc)
	 * @see org.jmangos.commons.database.dao.DAO#getClassName()
	 */
	@Override
	public String getClassName() {
		return  SimpleDataDAO.class.getName();
	}

	/**
	 * Gets the class level infos.
	 *
	 * @return the class level infos
	 */
	public HashMap<PlayerClassLevelInfoPK, PlayerClassLevelInfo> getClassLevelInfos() {
        HashMap<PlayerClassLevelInfoPK, PlayerClassLevelInfo> map = new HashMap<PlayerClassLevelInfoPK, PlayerClassLevelInfo>();
        Session session = DatabaseFactory.getWorldSessionFactory().openSession();
        List<PlayerClassLevelInfo> infoList = (List<PlayerClassLevelInfo>)session.createQuery( "select pcli from PlayerClassLevelInfo pcli" ).list();
        for( PlayerClassLevelInfo levelInfo : infoList ) {
            map.put( levelInfo.getPlayerClassLevelInfoPK(), levelInfo );
        }

        return map;
    }

	/**
	 * Gets the race class level infos.
	 *
	 * @return the race class level infos
	 */
	public HashMap<PlayerLevelInfoPK, PlayerLevelInfo> getRaceClassLevelInfos() {
        HashMap<PlayerLevelInfoPK, PlayerLevelInfo> map = new HashMap<PlayerLevelInfoPK, PlayerLevelInfo>();
        Session session = DatabaseFactory.getWorldSessionFactory().openSession();
        List<PlayerLevelInfo> infoList = (List<PlayerLevelInfo>)session.createQuery( "select pli from PlayerLevelInfo pli" ).list();
        for( PlayerLevelInfo levelInfo : infoList ) {
            map.put( levelInfo.getPlayerLevelInfoPK(), levelInfo );
        }

        return map;
    }

}
