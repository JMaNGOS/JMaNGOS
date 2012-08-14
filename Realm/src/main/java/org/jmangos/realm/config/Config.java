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
package org.jmangos.realm.config;

import java.net.InetSocketAddress;

import org.jmangos.commons.config.Compatiple;
import org.jmangos.commons.configuration.AbstractConfig;
import org.jmangos.commons.configuration.Property;

/**
 * The Class Config.
 */
public class Config extends AbstractConfig {

	/** The Constant CONFIG_FILE. */
	private static final String CONFIG_FILE = "./conf/network/realm.network.properties";

	/** Login Server address to client. */
	@Property(key = "network.client.address", defaultValue = "*:8085")
	public InetSocketAddress CLIENT_ADDRESS;

	/** The UPDAT e_ interval. */
	@Property(key = "network.service.updateRealmlistInterval", defaultValue = "60")
	public Integer UPDATE_INTERVAL;

	/** The COMPATIBLE. */
	@Property(key = "network.compatible", defaultValue = "NONE")
	public Compatiple COMPATIBLE;

	/** Auth server to connect */
	@Property(key = "network.auth.address", defaultValue = "localhost:3724")
	public InetSocketAddress AUTH_ADDRESS;

	/** Auth login */
	@Property(key = "network.auth.login", defaultValue = "JMaNGOS")
	public String AUTH_LOGIN;

	/** Auth password */
	@Property(key = "network.auth.password", defaultValue = "JMaNGOS")
	public String AUTH_PASSWORD;

	/** Displayed name in realmList */
	@Property(key = "network.realm.name", defaultValue = "JMaNGOS")
	public String REALM_NAME;

	/** Address for clients */
	@Property(key = "network.realm.address", defaultValue = "127.0.0.1")
	public String REALM_ADDRESS;

	/** Port for clients */
	@Property(key = "network.realm.port", defaultValue = "8085")
	public Integer REALM_PORT;

	/** Icon for clients */
	@Property(key = "network.realm.icon", defaultValue = "1")
	public Integer REALM_ICON;

	/** Icon for clients */
	@Property(key = "network.realm.flags", defaultValue = "0")
	public Integer REALM_FLAGS;

	/** Timezone for clients */
	@Property(key = "network.realm.timezone", defaultValue = "1")
	public Integer REALM_TIME_ZONE;

	/** AllowedSecurityLevel for clients */
	@Property(key = "network.realm.allowedSecurityLevel", defaultValue = "0")
	public Integer REALM_ALLOWED_SECURITY_LVL;

	/** Allowed client build */
	@Property(key = "network.realm.allowedClientBuild", defaultValue = "12340")
	public String REALM_ALLOWED_CLIENT_BUILD;

	/** Time to reconnect realm with auth server in milliseconds */
	@Property(key = "network.realm.reconnectDelay", defaultValue = "5000")
	public Long AUTH_RECONNECT_DELAY;

	/**
	 * Load configuration.
	 */
	public Config() {
		super(CONFIG_FILE);
	}
}
