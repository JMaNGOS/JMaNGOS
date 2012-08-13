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

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.jmangos.commons.configuration.AbstractConfig;
import org.jmangos.commons.configuration.Property;
import org.jmangos.commons.utils.PropertiesUtils;

import javax.swing.*;


// TODO: Auto-generated Javadoc
/**
 * This class holds all configuration of database.
 *
 */
public class DatabaseConfig extends AbstractConfig {
	
	/** Logger for database configuration. */
	private final Logger	log	= Logger.getLogger(DatabaseConfig.class);

	/** Configuration file location. */
	public static final String	CONFIG_FILE	= "conf/database/database.properties";

	/**
	 *  Default world driver class to database
	 */
	@Property(key = "world.database.driver", defaultValue = "com.mysql.jdbc.Driver" )
    public String        WORLD_DATABASE_DRIVER;

    /**
	 * World database uri !!!with trailing slash!!!
	 */
	@Property(key = "world.database.url", defaultValue="jdbc:mysql://localhost:3306/")
	public String 		WORLD_DATABASE_URL = "jdbc:mysql://localhost:3306/";

    /**
	 * World Database Hibernate dialect (see http://hibernate.org)
	 */
	@Property(key = "world.database.dialect", defaultValue="org.hibernate.dialect.MySQL5Dialect")
	public String 		WORLD_DATABASE_DIALECT;

    /**
	 * World Database user
	 */
	@Property(key = "world.database.user", defaultValue="JMaNGOS")
	public String 		WORLD_DATABASE_USER;

    /**
	 * World Database password
	 */
	@Property(key = "world.database.password", defaultValue="JMaNGOS")
	public String 		WORLD_DATABASE_PASSWORD;

    /**
	 * World Database name
	 */
	@Property(key = "world.database.name", defaultValue="mangos")
	public String 		WORLD_DATABASE_NAME;

    /**
	 * World Minimum amount of database connections
	 */
	@Property(key = "world.database.connections.min", defaultValue="5")
	public Integer 		WORLD_DATABASE_CONNECTIONS_MIN;

    /**
	 * World Maximum amount of database connections
	 */
	@Property(key = "world.database.connections.max", defaultValue="10")
	public Integer 		WORLD_DATABASE_CONNECTIONS_MAX;

    /****************************-- CHARACTER --******************************/
    /**
     *  Default chars driver class to database
     */
    @Property(key = "chars.database.driver", defaultValue = "com.mysql.jdbc.Driver" )
    public String        CHARS_DATABASE_DRIVER;

    /**
     * Characters database uri !!!with trailing slash!!!
     */
    @Property(key = "chars.database.url", defaultValue="jdbc:mysql://localhost:3306/")
    public String 		CHARS_DATABASE_URL = "jdbc:mysql://localhost:3306/";

    /**
     * Characters Database Hibernate dialect (see http://hibernate.org)
     */
    @Property(key = "chars.database.dialect", defaultValue="org.hibernate.dialect.MySQL5Dialect")
    public String 		CHARS_DATABASE_DIALECT;

    /**
     * Characters Database user
     */
    @Property(key = "chars.database.user", defaultValue="JMaNGOS")
    public String 		CHARS_DATABASE_USER;

    /**
     * Characters Database password
     */
    @Property(key = "chars.database.password", defaultValue="JMaNGOS")
    public String 		CHARS_DATABASE_PASSWORD;

    /**
     * Characters Database name
     */
    @Property(key = "chars.database.name", defaultValue="characters")
    public String 		CHARS_DATABASE_NAME;

    /**
     * Characters Minimum amount of database connections
     */
    @Property(key = "chars.database.connections.min", defaultValue="5")
    public Integer 		CHARS_DATABASE_CONNECTIONS_MIN;

    /**
     * Characters Maximum amount of database connections
     */
    @Property(key = "chars.database.connections.max", defaultValue="10")
    public Integer 		CHARS_DATABASE_CONNECTIONS_MAX;


    /****************************-- ACCOUNT --******************************/
    /**
     *  Default chars driver class to database
     */
    @Property(key = "account.database.driver", defaultValue = "com.mysql.jdbc.Driver" )
    public String        ACCOUNT_DATABASE_DRIVER;

    /**
     * Account database uri !!!with trailing slash!!!
     */
    @Property(key = "account.database.url", defaultValue="jdbc:mysql://localhost:3306/")
    public String 		ACCOUNT_DATABASE_URL = "jdbc:mysql://localhost:3306/";

    /**
     * Characters Database Hibernate dialect (see http://hibernate.org)
     */
    @Property(key = "account.database.dialect", defaultValue="org.hibernate.dialect.MySQL5Dialect")
    public String 		ACCOUNT_DATABASE_DIALECT;

    /**
     * Characters Database user
     */
    @Property(key = "account.database.user", defaultValue="JMaNGOS")
    public String 		ACCOUNT_DATABASE_USER;

    /**
     * Characters Database password
     */
    @Property(key = "account.database.password", defaultValue="JMaNGOS")
    public String 		ACCOUNT_DATABASE_PASSWORD;

    /**
     * Characters Database name
     */
    @Property(key = "account.database.name", defaultValue="accounts")
    public String 		ACCOUNT_DATABASE_NAME;

    /**
     * Characters Minimum amount of database connections
     */
    @Property(key = "account.database.connections.min", defaultValue="5")
    public Integer 		ACCOUNT_DATABASE_CONNECTIONS_MIN;

    /**
     * Characters Maximum amount of database connections
     */
    @Property(key = "account.database.connections.max", defaultValue="10")
    public Integer 		ACCOUNT_DATABASE_CONNECTIONS_MAX;

    DatabaseConfig() {
        super(CONFIG_FILE);
    }
}
