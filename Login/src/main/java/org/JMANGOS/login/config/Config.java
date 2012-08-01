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
package org.JMANGOS.login.config;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.JMANGOS.common.config.Compatiple;
import org.JMANGOS.common.configuration.ConfigurableProcessor;
import org.JMANGOS.common.configuration.Property;
import org.JMANGOS.common.utils.PropertiesUtils;

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
	public static final String CONFIG_FILE = "config/network/login.network.properties";

	/** Login Server address to client. */
	@Property(key = "network.client.address", defaultValue = "*:3724")
	public static InetSocketAddress CLIENT_ADDRESS;

	/** The UPDAT e_ interval. */
	@Property(key = "network.service.updateRealmlistInterval", defaultValue = "60")
	public static int UPDATE_INTERVAL;

	/** The COMPATIBLE. */
	@Property(key = "network.compatible", defaultValue = "NONE")
	public static Compatiple COMPATIBLE;

	/** The REAL m_ address. */
	@Property(key = "network.realm.address", defaultValue = "*:3740")
	public static InetSocketAddress REALM_ADDRESS;

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
