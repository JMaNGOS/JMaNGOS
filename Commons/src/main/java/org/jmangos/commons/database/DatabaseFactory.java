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

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.jmangos.commons.service.Service;

public class DatabaseFactory implements Service
{

	/** Logger for this class. */
	private static final Logger			log	= Logger.getLogger(DatabaseFactory.class);

	/** Data Source Generates all Connections This variable is also used as indicator for "initialized" state of DatabaseFactory. */
	private static DataSource			dataSource;

	/** Connection Pool holds all connections - Idle or Active. */
	private static GenericObjectPool	connectionPool;

	/** Returns name of the database that is used  For isntance, MySQL returns "MySQL". */
	private static String				databaseName;

	/**
	 * Retursn major version that is used For instance, MySQL 5.0.51 community edition returns 5
	 */
	private static int					databaseMajorVersion;

	/**
	 * Retursn minor version that is used For instance, MySQL 5.0.51 community edition returns 0
	 */
	private static int					databaseMinorVersion;


    /**
     * Returns Hibernate Session
     */
    private static SessionFactory worldSessionFactory;
    private static SessionFactory charactersSessionFactory;
    private static SessionFactory accountsSessionFactory;

	/**
	 * Initializes DatabaseFactory.
	 */
	public synchronized void start()
	{
		if(dataSource != null)
		{
			return;
		}

        // TODO: cleanup old JDBC crap

        // Bring up hibernate
        AnnotationConfiguration config = new AnnotationConfiguration();
        config.setProperty( "hibernate.connection.driver_class", "com.mysql.jdbc.Driver" );
        config.setProperty( "hibernate.connection.url", "jdbc:mysql://localhost/characters" );
        config.setProperty( "hibernate.connection.username", "root" );
        config.setProperty( "hibernate.connection.password", "" );
        config.setProperty( "hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect" );
        config.addPackage( "org.jmangos.realm.domain" );
        config.configure();

        this.worldSessionFactory = config.buildSessionFactory();

        log.info( "Hibernate worldSessionFactory initialized..." );

        config = new AnnotationConfiguration();
        config.setProperty( "hibernate.connection.driver_class", "com.mysql.jdbc.Driver" );
        config.setProperty( "hibernate.connection.url", "jdbc:mysql://localhost/characters" );
        config.setProperty( "hibernate.connection.username", "root" );
        config.setProperty( "hibernate.connection.password", "" );
        config.setProperty( "hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect" );
        config.addPackage( "org.jmangos.realm.domain" );
        config.configure();

        this.charactersSessionFactory = config.buildSessionFactory();
        log.info( "Hibernate characterSessionFactory initialized..." );

        DatabaseConfig.load();

		try
		{
			DatabaseConfig.DATABASE_DRIVER.newInstance();
		}
		catch(Exception e)
		{
			log.fatal("Error obtaining DB driver", e);
			throw new Error("DB Driver doesnt exist!");
		}

		connectionPool = new GenericObjectPool();

		if(DatabaseConfig.DATABASE_CONNECTIONS_MIN > DatabaseConfig.DATABASE_CONNECTIONS_MAX)
		{
			log.error("Please check your database configuration. Minimum amount of connections is > maximum");
			DatabaseConfig.DATABASE_CONNECTIONS_MAX = DatabaseConfig.DATABASE_CONNECTIONS_MIN;
		}

		connectionPool.setMaxIdle(DatabaseConfig.DATABASE_CONNECTIONS_MIN);
		connectionPool.setMaxActive(DatabaseConfig.DATABASE_CONNECTIONS_MAX);

		try
		{
			dataSource = setupDataSource();
			Connection c = getConnection();
			DatabaseMetaData dmd = c.getMetaData();
			databaseName = dmd.getDatabaseProductName();
			databaseMajorVersion = dmd.getDatabaseMajorVersion();
			databaseMinorVersion = dmd.getDatabaseMinorVersion();
			c.close();
		}
		catch(Exception e)
		{
			log.fatal("Error with connection string: " + DatabaseConfig.DATABASE_URL, e);
			throw new Error("DatabaseFactory not initialized!");
		}

		log.info("Successfully connected to database");
	}

	/**
	 * Sets up Connection Factory and Pool.
	 *
	 * @return DataSource configured datasource
	 * @throws Exception if initialization failed
	 */
	private static DataSource setupDataSource() throws Exception
	{
		ConnectionFactory conFactory = new DriverManagerConnectionFactory(DatabaseConfig.DATABASE_URL,
			DatabaseConfig.DATABASE_USER, DatabaseConfig.DATABASE_PASSWORD);
		new PoolableConnectionFactoryW(conFactory, connectionPool, null, 1, false, true);
		return new PoolingDataSource(connectionPool);
	}

	/**
	 * Returns an active connection from pool. This function utilizes the dataSource which grabs an object from the
	 * ObjectPool within its limits. The GenericObjectPool.borrowObject()' function utilized in
	 * 'DataSource.getConnection()' does not allow any connections to be returned as null, thus a null check is not
	 * needed. Throws SQLException in case of a Failed Connection
	 *
	 * @return Connection pooled connection
	 * @throws SQLException the sQL exception
	 */
	public static Connection getConnection() throws SQLException
	{
		return dataSource.getConnection();
	}

	/**
	 * Returns number of active connections in the pool.
	 * 
	 * @return int Active DB Connections
	 */
	public int getActiveConnections()
	{
		return connectionPool.getNumActive();
	}

	/**
	 * Returns number of Idle connections. Idle connections represent the number of instances in Database Connections
	 * that have once been connected and now are closed and ready for re-use. The 'getConnection' function will grab
	 * idle connections before creating new ones.
	 * 
	 * @return int Idle DB Connections
	 */
	public int getIdleConnections()
	{
		return connectionPool.getNumIdle();
	}

	/**
	 * Shuts down pool and closes connections.
	 */
	public synchronized void stop()
	{
		try
		{
			connectionPool.close();
		}
		catch(Exception e)
		{
			log.warn("Failed to shutdown DatabaseFactory", e);
		}
		dataSource = null;
	}

	/**
	 * Close.
	 *
	 * @param con the con
	 */
	public static void close(Connection con)
	{
		if (con == null)
			return;
		
		try
		{
			con.close();
		}
		catch (SQLException e)
		{
			log.warn("DatabaseFactory: Failed to close database connection!", e);
		}
	}

	/**
	 * Returns database name. For instance MySQL 5.0.51 community edition returns MySQL
	 * 
	 * @return database name that is used.
	 */
	public static String getDatabaseName()
	{
		return databaseName;
	}

	/**
	 * Returns database version. For instance MySQL 5.0.51 community edition returns 5
	 * 
	 * @return database major version
	 */
	public static int getDatabaseMajorVersion()
	{
		return databaseMajorVersion;
	}

	/**
	 * Returns database minor version. For instance MySQL 5.0.51 community edition reutnrs 0
	 * 
	 * @return database minor version
	 */
	public static int getDatabaseMinorVersion()
	{
		return databaseMinorVersion;
	}

    /**
     * Returns World Database's hibernate session
     * @return Hibernate Session
     */
    public static SessionFactory getWorldSessionFactory() {
        return worldSessionFactory;
    }

    /**
     * Returns Character Database's hibernate session
     * @return Hibernate Session
     */
    public static SessionFactory getCharactersSessionFactory() {
        return charactersSessionFactory;
    }

    public static SessionFactory getAccountsSessionFactory() {
        if ( accountsSessionFactory == null ) {
            // Bring up hibernate
            AnnotationConfiguration config = new AnnotationConfiguration();
            config.setProperty( "hibernate.connection.driver_class", "com.mysql.jdbc.Driver" );
            config.setProperty( "hibernate.connection.url", "jdbc:mysql://localhost/accounts" );
            config.setProperty( "hibernate.connection.username", "root" );
            config.setProperty( "hibernate.connection.password", "" );
            config.setProperty( "hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect" );
            config.configure();

            accountsSessionFactory = config.buildSessionFactory();
            log.info( "Hibernate accountsSessionFactory initialized..." );
        }

        return accountsSessionFactory;
    }

	/**
	 * Default constructor.
	 */
	public DatabaseFactory()
	{
		//
	}
}
