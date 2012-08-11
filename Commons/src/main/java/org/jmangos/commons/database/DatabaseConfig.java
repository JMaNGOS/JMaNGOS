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

import javax.inject.Singleton;

import org.jmangos.commons.configuration.AbstractConfig;
import org.jmangos.commons.configuration.Property;

/**
 * This class holds all configuration of database.
 */
@Singleton
public class DatabaseConfig extends AbstractConfig {
	
	/** Configuration file location. */
	private static final String CONFIG_FILE = "conf/database/database.properties";

	/**
	 * Default database url.
	 */
	@Property(key = "database.url", defaultValue = "jdbc:mysql://localhost:3306/realmd")
	public String DATABASE_URL;

	/** Name of database Driver. */
	@Property(key = "database.driver", defaultValue = "com.mysql.jdbc.Driver")
	public Class<?> DATABASE_DRIVER;

	/** Default database user. */
	@Property(key = "database.user", defaultValue = "JMaNGOS")
	public String DATABASE_USER;

	/** Default database password. */
	@Property(key = "database.password", defaultValue = "JMaNGOS")
	public String DATABASE_PASSWORD;

	/** Minimum amount of connections that are always active. */
	@Property(key = "database.connections.min", defaultValue = "2")
	public Integer DATABASE_CONNECTIONS_MIN;

	/** Maximum amount of connections that are allowed to use. */
	@Property(key = "database.connections.max", defaultValue = "10")
	public Integer DATABASE_CONNECTIONS_MAX;

	/**
	 * Loads database configuration.
	 */
	protected DatabaseConfig() {
		super(CONFIG_FILE);
	}
}
