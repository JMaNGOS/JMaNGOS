/*******************************************************************************
 * Copyright (c) 2011 WoWEmu
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *    WoWEmu  - initial API and implementation
 ******************************************************************************/

package org.JMANGOS.common.database;

import java.io.IOException;
import java.util.Properties;

import org.JMANGOS.common.configuration.ConfigurableProcessor;
import org.JMANGOS.common.configuration.Property;
import org.JMANGOS.common.utils.PropertiesUtils;
import org.apache.log4j.Logger;


// TODO: Auto-generated Javadoc
/**
 * This class holds all configuration of database.
 *
 */
public class DatabaseConfig
{
	
	/** Logger for database configuration. */
	private static final Logger	log	= Logger.getLogger(DatabaseConfig.class);

	/** Configuration file location. */
	public static final String	CONFIG_FILE	= "config/database/database.properties";

	/**
	 * Default database url.
	 */
	@Property(key = "database.url", defaultValue = "jdbc:mysql://localhost:3306/realmd")
	public static String		DATABASE_URL = "jdbc:mysql://localhost:3306/realmd";

	/** Name of database Driver. */
	@Property(key = "database.driver", defaultValue = "com.mysql.jdbc.Driver")
	public static Class<?>		DATABASE_DRIVER;

	/** Default database user. */
	@Property(key = "database.user", defaultValue = "root")
	public static String		DATABASE_USER;

	/** Default database password. */
	@Property(key = "database.password", defaultValue = "root")
	public static String		DATABASE_PASSWORD;

	/** Minimum amount of connections that are always active. */
	@Property(key = "database.connections.min", defaultValue = "2")
	public static int			DATABASE_CONNECTIONS_MIN;

	/** Maximum amount of connections that are allowed to use. */
	@Property(key = "database.connections.max", defaultValue = "10")
	public static int			DATABASE_CONNECTIONS_MAX;
	
	/**
	 * Loads database configuration.
	 */
	public static void load()
	{

		Properties p;
		try
		{
			p = PropertiesUtils.load(CONFIG_FILE);
		}
		catch(IOException e)
		{
			log.fatal("Can't load database configuration...");
			throw new Error("Can't load " + CONFIG_FILE, e);
		}

		ConfigurableProcessor.process(DatabaseConfig.class, p);
	}
}
