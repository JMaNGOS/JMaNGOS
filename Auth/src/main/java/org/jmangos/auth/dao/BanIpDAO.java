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

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jmangos.auth.model.BanIp;
import org.jmangos.commons.database.DatabaseFactory;
import org.jmangos.commons.database.dao.DAO;

/**
 * The Class BanIpDAO.
 * 
 * @author MinimaJack
 * 
 */
public class BanIpDAO implements DAO {
	/**
	 * Inserts ip mask to database, returns BannedIP object that represents
	 * inserted mask or null if error.<br>
	 * Expire time is null so ban never expires.<br>
	 * 
	 * @param mask
	 *            ip mask to ban
	 * @return BannedIP object represetns mask or null if error happened
	 */
	public BanIp insert(String mask) {
        return insert( mask, null );
    }

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
	public BanIp insert(String mask, Timestamp expireTime) {
        BanIp banIp = new BanIp( mask, expireTime );
        return insert( banIp );
    }

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
	public BanIp insert(BanIp bannedIp) {
        Session hibernateSession = DatabaseFactory.getAccountsSessionFactory().openSession();
        hibernateSession.getTransaction();
        try {
            hibernateSession.save( bannedIp );
        } catch ( HibernateException e ) {
            log.warn( "This IP is already in the database." );
        } finally {
            if( hibernateSession.getTransaction().isActive() )
                hibernateSession.getTransaction().rollback();
        }

        return bannedIp;
    }

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
	public boolean update(BanIp bannedIp) {
        Session hibernateSession = DatabaseFactory.getAccountsSessionFactory().openSession();
        hibernateSession.getTransaction();
        try {
            hibernateSession.update(bannedIp);
            return true;
        } catch ( HibernateException e ) {
            log.warn( "Update not persisted IP? Try save instead!" );
            return false;
        } finally {
            if( hibernateSession.getTransaction().isActive() )
                hibernateSession.getTransaction().rollback();
        }
    }

	/**
	 * Removes ban by mask.<br>
	 * Returns true in case of success, false othervise.<br>
	 * 
	 * @param ip
	 *            the ip
	 * @return true in case of success, false in other case
	 */
	public boolean remove(String ip) {
        Session hibernateSession = DatabaseFactory.getAccountsSessionFactory().openSession();
        hibernateSession.getTransaction();
        try {
            hibernateSession.delete(BanIp.class.getSimpleName(), ip);
            return true;
        } catch ( HibernateException e ) {
            log.warn( "This BanIP entry not found with this IP: " + ip );
            return false;
        } finally {
            if( hibernateSession.getTransaction().isActive() )
                hibernateSession.getTransaction().rollback();
        }
    }

	/**
	 * Removes BannedIP record by ID. Id must not be null.<br>
	 * Returns true in case of success, false in case of error
	 * 
	 * @param bannedIp
	 *            record to unban
	 * @return true if removeas wass successfull, false in case of error
	 */
	public boolean remove(BanIp bannedIp) {
        Session hibernateSession = DatabaseFactory.getAccountsSessionFactory().openSession();
        hibernateSession.getTransaction();
        try {
            hibernateSession.delete(bannedIp);
            return true;
        } catch ( HibernateException e ) {
            log.warn( "This BanIP entry not found with this IP: " + bannedIp.getIp() );
            return false;
        } finally {
            if( hibernateSession.getTransaction().isActive() )
                hibernateSession.getTransaction().rollback();
        }
    }

	/**
	 * Returns all bans from database.
	 * 
	 * @return all bans from database.
	 */
	public List<BanIp> getAllBans() {
        Session hibernateSession = DatabaseFactory.getAccountsSessionFactory().openSession();
        Criteria crit = hibernateSession.createCriteria( BanIp.class );
        return (List<BanIp>)crit.list();
    }

	/**
	 * Gets the ban.
	 * 
	 * @param ip
	 *            the ip
	 * @return the ban
	 */
	public BanIp getBan(String ip) {
        Session hibernateSession = DatabaseFactory.getAccountsSessionFactory().openSession();
        return (BanIp)hibernateSession.get( BanIp.class, ip );
    }

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
