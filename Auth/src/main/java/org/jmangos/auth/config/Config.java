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

import java.net.InetSocketAddress;

import org.jmangos.commons.config.Compatiple;
import org.jmangos.commons.configuration.AbstractConfig;
import org.jmangos.commons.configuration.Property;
import org.springframework.stereotype.Component;

/**
 * The Class Config.
 * 
 * @author MinimaJack
 * 
 */
@Component
public class Config extends AbstractConfig {

	/** The Constant CONFIG_FILE. */
	private static final String CONFIG_FILE = "conf/network/auth.network.properties";

	/** Login Server address to client. */
	@Property(key = "network.client.address", defaultValue = "*:3724")
	public InetSocketAddress CLIENT_ADDRESS;

	/** The UPDAT e_ interval. */
	@Property(key = "network.service.updateRealmlistInterval", defaultValue = "60")
	public Integer UPDATE_INTERVAL;

	/** The COMPATIBLE. */
	@Property(key = "network.compatible", defaultValue = "NONE")
	public Compatiple COMPATIBLE;

	/**
	 * Load configuration.
	 */
	protected Config() {
		super(CONFIG_FILE);
	}
}
