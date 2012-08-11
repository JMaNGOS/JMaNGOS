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
package org.jmangos.commons.database;

import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.jmangos.commons.service.Service;

import javax.sql.DataSource;

public class DatabaseFactory implements Service {

	/** Logger for this class. */
	private static final Logger			log	= Logger.getLogger(DatabaseFactory.class);

	/**
     * Returns Hibernate Session
     */
    private static SessionFactory worldSessionFactory;
    private static SessionFactory charactersSessionFactory;
    private static SessionFactory accountsSessionFactory;

	/**
	 * Initializes DatabaseFactory.
	 */
	public synchronized void start() {
        // Loading config fields
        DatabaseConfig.load();

        /*try {
            getAccountsSessionFactory();
        } catch (Exception e ) {
            log.fatal("Account Database initialization error!", e);
        }

		try {
            getCharactersSessionFactory();
		} catch(Exception e) {
			log.fatal("Character Database initialization error!", e);
		}

        try {
            getACCOUNTSessionFactory();
        } catch (Exception e ) {
            log.fatal("ACCOUNT Database initialization error!", e);
        }

        log.info("Successfully connected to database");
        */
	}

	/**
	 * Returns number of active connections in the pool.
	 * 
	 * @return int Active DB Connections
	 */
	public int getActiveConnections()
	{
        Long count = getCharactersSessionFactory().getStatistics().getSessionOpenCount() - getCharactersSessionFactory().getStatistics().getSessionCloseCount();
		count += getWorldSessionFactory().getStatistics().getSessionOpenCount() - getWorldSessionFactory().getStatistics().getSessionCloseCount();

        return count.intValue();
	}

	/**
	 * Returns number of Idle connections. Idle connections represent the number of instances in Database Connections
	 * that have once been connected and now are closed and ready for re-use. The 'getConnection' function will grab
	 * idle connections before creating new ones.
	 * 
	 * @return int Idle DB Connections
	 */
	public int getIdleConnections() {
        // TODO: reimplement
		return 0;
        //return connectionPool.getNumIdle();
	}

	/**
	 * Shuts down pool and closes connections.
	 */
	public synchronized void stop() {
		try {
            if( worldSessionFactory != null )
			    worldSessionFactory.close();
            if (charactersSessionFactory != null)
                charactersSessionFactory.close();
            if (accountsSessionFactory!=null)
                accountsSessionFactory.close();
		} catch(Exception e) {
			log.warn("Failed to shutdown DatabaseFactory", e);
		}

		worldSessionFactory = null;
        charactersSessionFactory = null;
        accountsSessionFactory = null;
	}

	/**
     * Returns ACCOUNT Database's hibernate session
     * @return Hibernate Session
     */
    public static SessionFactory getWorldSessionFactory() {
        if (charactersSessionFactory == null) {
            AnnotationConfiguration config = new AnnotationConfiguration();
            config.setProperty( "hibernate.connection.driver_class", DatabaseConfig.WORLD_DATABASE_DRIVER );
            config.setProperty( "hibernate.connection.url", DatabaseConfig.WORLD_DATABASE_URL + DatabaseConfig.WORLD_DATABASE_NAME + "?autoReconnect=true" );
            config.setProperty( "hibernate.connection.username", DatabaseConfig.WORLD_DATABASE_USER );
            config.setProperty( "hibernate.connection.password", DatabaseConfig.WORLD_DATABASE_PASSWORD );
            config.setProperty( "hibernate.dialect", DatabaseConfig.WORLD_DATABASE_DIALECT );
            config.setProperty( "hibernate.c3p0.min_size", DatabaseConfig.WORLD_DATABASE_CONNECTIONS_MIN.toString() );
            config.setProperty( "hibernate.c3p0.max_size", DatabaseConfig.WORLD_DATABASE_CONNECTIONS_MAX.toString() );
            config.configure("world.cfg.xml");
            worldSessionFactory = config.buildSessionFactory();
            worldSessionFactory.getStatistics().setStatisticsEnabled( true );

            log.info( "Hibernate ACCOUNTSessionFactory initialized..." );
        }
            
        return worldSessionFactory;
    }

    /**
     * Returns Character Database's hibernate session
     * @return Hibernate Session
     */
    public static SessionFactory getCharactersSessionFactory() {
        if ( charactersSessionFactory == null ) {
            // Bring up hibernate

            AnnotationConfiguration config = new AnnotationConfiguration();
            config.setProperty( "hibernate.connection.driver_class", DatabaseConfig.CHARS_DATABASE_DRIVER );
            config.setProperty( "hibernate.connection.url", DatabaseConfig.CHARS_DATABASE_URL + DatabaseConfig.CHARS_DATABASE_NAME + "?autoReconnect=true" );
            config.setProperty( "hibernate.connection.username", DatabaseConfig.CHARS_DATABASE_USER );
            config.setProperty( "hibernate.connection.password", DatabaseConfig.CHARS_DATABASE_PASSWORD );
            config.setProperty( "hibernate.dialect", DatabaseConfig.CHARS_DATABASE_DIALECT );
            config.setProperty( "hibernate.c3p0.min_size", DatabaseConfig.CHARS_DATABASE_CONNECTIONS_MIN.toString() );
            config.setProperty( "hibernate.c3p0.max_size", DatabaseConfig.CHARS_DATABASE_CONNECTIONS_MAX.toString() );
            config.configure("/characters.cfg.xml");

            charactersSessionFactory = config.buildSessionFactory();
            charactersSessionFactory.getStatistics().setStatisticsEnabled( true );
            log.info( "Hibernate charactersSessionFactory initialized..." );
        }

        return charactersSessionFactory;
    }

    public static SessionFactory getAccountsSessionFactory() {
        if ( accountsSessionFactory == null ) {
            // Bring up hibernate
            AnnotationConfiguration config = new AnnotationConfiguration();
            config.setProperty( "hibernate.connection.driver_class", DatabaseConfig.ACCOUNT_DATABASE_DRIVER );
            config.setProperty( "hibernate.connection.url", DatabaseConfig.ACCOUNT_DATABASE_URL + DatabaseConfig.ACCOUNT_DATABASE_NAME + "?autoReconnect=true" );
            config.setProperty( "hibernate.connection.username", DatabaseConfig.ACCOUNT_DATABASE_USER );
            config.setProperty( "hibernate.connection.password", DatabaseConfig.ACCOUNT_DATABASE_PASSWORD );
            config.setProperty( "hibernate.dialect", DatabaseConfig.ACCOUNT_DATABASE_DIALECT );
            config.setProperty( "hibernate.c3p0.min_size", DatabaseConfig.ACCOUNT_DATABASE_CONNECTIONS_MIN.toString() );
            config.setProperty( "hibernate.c3p0.max_size", DatabaseConfig.ACCOUNT_DATABASE_CONNECTIONS_MAX.toString() );
            config.configure("/accounts.cfg.xml");

            accountsSessionFactory = config.buildSessionFactory();
            log.info( "Hibernate accountsSessionFactory initialized..." );
        }

        return accountsSessionFactory;
    }

	/**
	 * Default constructor.
	 */
	public DatabaseFactory() {}
}
