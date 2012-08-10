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
import org.jmangos.commons.configuration.ConfigurableProcessor;
import org.jmangos.commons.configuration.Property;
import org.jmangos.commons.utils.PropertiesUtils;

/**
 * This class holds all configuration of database.
 * 
 */
public class DatabaseConfig {

	/** Logger for database configuration. */
	private static final Logger log = Logger.getLogger(DatabaseConfig.class);

	/** Configuration file location. */
	public static final String CONFIG_FILE = "conf/database/database.properties";

	/**
	 * Default database url.
	 */
	@Property(key = "database.url", defaultValue = "jdbc:mysql://localhost:3306/realmd")
	public static String DATABASE_URL = "jdbc:mysql://localhost:3306/realmd";

	/** Name of database Driver. */
	@Property(key = "database.driver", defaultValue = "com.mysql.jdbc.Driver")
	public static Class<?> DATABASE_DRIVER;

	/** Default database user. */
	@Property(key = "database.user", defaultValue = "JMaNGOS")
	public static String DATABASE_USER;

	/** Default database password. */
	@Property(key = "database.password", defaultValue = "JMaNGOS")
	public static String DATABASE_PASSWORD;

	/** Minimum amount of connections that are always active. */
	@Property(key = "database.connections.min", defaultValue = "2")
	public static int DATABASE_CONNECTIONS_MIN;

	/** Maximum amount of connections that are allowed to use. */
	@Property(key = "database.connections.max", defaultValue = "10")
	public static int DATABASE_CONNECTIONS_MAX;

	/**
	 * Loads database configuration.
	 */
	public static void load() {

		Properties p;
		try {
			p = PropertiesUtils.load(CONFIG_FILE);
		} catch (IOException e) {
			log.fatal("Can't load database configuration...");
			throw new Error("Can't load " + CONFIG_FILE, e);
		}

		ConfigurableProcessor.process(DatabaseConfig.class, p);
	}
}
