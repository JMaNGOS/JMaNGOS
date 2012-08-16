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
import org.jmangos.realm.model.account.AccountData;


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

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.jmangos.commons.model.Account;
import org.jmangos.realm.model.base.character.CharacterData;

/**
 * DAO that manages accounts.
 *
 * @author MinimaJack
 *
 */
public class AccountDAO implements DAO
{
    Logger logger = Logger.getLogger( AccountDAO.class );

    /**
     * Returns account by name or null.
     *
     * @param name account name
     * @return account object or null
     */
    public Account getAccount(String name) {
        Session session = DatabaseFactory.getAccountsSessionFactory().openSession();
        Query query = session.createQuery("select a from Account a where a.username = :name").setString( "name", name );
        return (Account)query.uniqueResult();
    }

    /**
     * Retuns account id or -1 in case of error.
     *
     * @param name name of account
     * @return id or -1 in case of error
     */
    public int getAccountId(String name) {
        Session session = DatabaseFactory.getAccountsSessionFactory().openSession();
        Query query = session.createQuery("select a from Account a where a.username = :name").setString( "name", name );
        Account account = (Account)query.uniqueResult();
        if ( account == null )
            return -1;
        session.close();
        return account.getId();
    }

    /**
     * Reruns account count If error occured - returns -1.
     *
     * @return account count
     */
    public int getAccountCount() {
        Session session = DatabaseFactory.getAccountsSessionFactory().openSession();
        Query query = session.createQuery("select a from Account a");
        int accCount = query.list().size();
        return accCount;
    }

    /**
     * Update security key.
     *
     * @param account the account
     * @return true, if successful
     */
    public boolean updateSecurityKey(Account account) {
        Session session = DatabaseFactory.getAccountsSessionFactory().openSession();
        session.getTransaction().begin();
        boolean success = false;
        try {
            session.saveOrUpdate( account );
            session.getTransaction().commit();
            success = true;
        } finally {
            if( session.getTransaction().isActive() )
                session.getTransaction().rollback();
            session.close();
        }

        return success;
    }

    /**
     * Updates lastServer field of account.
     *
     * @param accountId account id
     * @param lastServer last accessed server
     * @return was updated successful or not
     */
    public boolean updateLastServer(int accountId, byte lastServer) {
        Session session = DatabaseFactory.getAccountsSessionFactory().openSession();
        Query query = session.createQuery("select a from Account a where a.id = :id").setInteger( "id", accountId );
        Account account = (Account)query.uniqueResult();

        if ( account == null ) {
            session.close();
            logger.warn( "Account with id (" + accountId + ") not found!" );
            return false;
        }

        account.setLastServer( lastServer );
        session.getTransaction().begin();
        boolean success = false;
        try {
            session.saveOrUpdate( account );
            session.getTransaction().commit();
            success = true;
        } finally {
            if( session.getTransaction().isActive() )
                session.getTransaction().rollback();
            session.close();
        }

        return success;
    }

    /**
     * Updates last ip that was used to access an account.
     *
     * @param accountId account id
     * @param ip ip address
     * @return was update successful or not
     */
    public boolean updateLastIp(int accountId, String ip) {
        Session session = DatabaseFactory.getAccountsSessionFactory().openSession();
        Query query = session.createQuery("select a from Account a where a.id = :id").setInteger( "id", accountId );
        Account account = (Account)query.uniqueResult();

        if ( account == null ) {
            session.close();
            logger.warn( "Account with id (" + accountId + ") not found!" );
            return false;
        }

        account.setLastIp( ip );
        session.getTransaction().begin();
        boolean success = false;
        try {
            session.saveOrUpdate( account );
            session.getTransaction().commit();
            success = true;
            logger.info( String.format( "Account (#%d) updated. New IP: %s.", accountId, ip ) );
        } finally {
            if( session.getTransaction().isActive() )
                session.getTransaction().rollback();
            session.close();
        }

        return success;
    }

    /**
     * Get last ip that was used to access an account.
     *
     * @param accountId account id
     * @return ip address
     */
    public String getLastIp(int accountId) {
        Session session = DatabaseFactory.getAccountsSessionFactory().openSession();
        Query query = session.createQuery("select a from Account a where a.id = :accountid").setInteger("accountid", accountId);
        Account account = (Account)query.uniqueResult();

        if ( account == null ) {
            session.close();
            logger.warn( "Account with id (" + accountId + ") not found!" );
            return "";
        }

        String lastIp = account.getLastIp();
        session.close();
        return lastIp;
    }

    /**
     * Returns uniquire class name for all implementations.
     *
     * @return uniquire class name for all implementations
     */
    @Override
    public final String getClassName()  {
        return AccountDAO.class.getName();
    }

    /**
     * Update session key.
     *
     * @param username the username
     * @param key the key
     * @return true, if successful
     */
    public boolean updateSessionKey(String username, String key) {
        Session session = DatabaseFactory.getAccountsSessionFactory().openSession();
        Query query = session.createQuery("select a from Account a where a.username = :username").setString( "username", username );
        Account account = (Account)query.uniqueResult();

        if ( account == null ) {
            session.close();
            logger.warn( "Account with id (" + username + ") not found!" );
            return false;
        }

        account.setSessionKey( key );
        session.getTransaction().begin();
        boolean success = false;
        try {
            session.saveOrUpdate( account );
            session.getTransaction().commit();
            success = true;
            logger.info( String.format( "Account (%s) updated. New session key: %s.", username, key ) );
        } finally {
            if( session.getTransaction().isActive() )
                session.getTransaction().rollback();
            session.close();
        }

        return success;
    }

    /**
     * Gets the session key.
     *
     * @param username the username
     * @return the session key
     */
    public String getSessionKey(String username) {
        Session session = DatabaseFactory.getAccountsSessionFactory().openSession();
        Query query = session.createQuery("select a from Account a where a.username = :username").setString( "username", username );
        Account account = (Account)query.uniqueResult();

        if ( account == null ) {
            session.close();
            logger.warn( "Account with id (" + username + ") not found!" );
            return "";
        }

        return account.getMsessionKey();
    }

    /**
     * Returns character list
     * @param accountId account to query
     * @return List&lt;CharacterData&gt; caracters
     */
    public List<CharacterData> getCharacters( int accountId ) {
        Session session = DatabaseFactory.getCharactersSessionFactory().openSession();
        Query query = session.createQuery("from CharacterData where account = :accountid").setInteger( "accountid", accountId );
        return (List<CharacterData>)query.list();
    }

    public void saveSessionKey(String username, String key) {
    }

    public int[] getTutorialsData(int guid) {
        return new int[]{ 0,0,0,0,0,0,0,0 };
    }

    public HashMap<Integer, AccountData> getAccountData(int accountId) {
        return new HashMap<Integer, AccountData>();
    }
}
