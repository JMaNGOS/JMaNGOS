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
package org.jmangos.auth.config;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.jmangos.commons.config.Compatiple;
import org.jmangos.commons.configuration.ConfigurableProcessor;
import org.jmangos.commons.configuration.Property;
import org.jmangos.commons.utils.PropertiesUtils;

/**
 * The Class Config.
 * 
 * @author MinimaJack
 * 
 */
public class Config {
	/**
	 * Logger for this class.
	 */
	protected static final Logger log = Logger.getLogger(Config.class);

	/** The Constant CONFIG_FILE. */
	public static final String CONFIG_FILE = "conf/network/auth.network.properties";

	/** Login Server address to client. */
	@Property(key = "network.client.address", defaultValue = "*:3724")
	public static InetSocketAddress CLIENT_ADDRESS;

	/** The UPDAT e_ interval. */
	@Property(key = "network.service.updateRealmlistInterval", defaultValue = "60")
	public static int UPDATE_INTERVAL;

	/** The COMPATIBLE. */
	@Property(key = "network.compatible", defaultValue = "NONE")
	public static Compatiple COMPATIBLE;

	/**
	 * Load configuration.
	 */
	public void load() {

		Properties p;
		try {
			p = PropertiesUtils.load(CONFIG_FILE);
		} catch (IOException e) {
			log.fatal("Can't load network configuration...");
			throw new Error("Can't load " + CONFIG_FILE, e);
		}

		ConfigurableProcessor.process(Config.class, p);
	}
}
