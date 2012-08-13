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
package org.jmangos.auth;

import org.jmangos.auth.config.Config;
import org.jmangos.auth.network.netty.packet.client.CMD_AUTH_LOGON_CHALLENGE;
import org.jmangos.auth.service.AuthNetworkService;
import org.jmangos.auth.service.BanIpService;
import org.jmangos.auth.service.UpdateService;
import org.jmangos.auth.service.WorldListService;
import org.jmangos.auth.utils.ShutdownHook;
import org.jmangos.commons.config.Compatiple;
import org.jmangos.commons.database.DatabaseConfig;
import org.jmangos.commons.database.DatabaseFactory;
import org.jmangos.commons.log4j.LoggingService;
import org.jmangos.commons.service.ServiceContent;
import org.jmangos.commons.threadpool.ThreadPoolManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * The Class AuthServer.
 * 
 * @author MinimaJack
 */
public class AuthServer {

	private static Config config;

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 * @throws Exception
	 *             the exception
	 */
	public static void main(String[] args) throws Exception {;

		ApplicationContext context = new FileSystemXmlApplicationContext(
				"conf/context/auth-context.xml");
		ServiceContent.setContext(context);

		context.getBean(LoggingService.class).start();
		config = context.getBean(Config.class);
		context.getBean(DatabaseConfig.class); // not actual!
		context.getBean(DatabaseFactory.class).start(); // not actual!
		context.getBean(WorldListService.class).start();
		if (config.COMPATIBLE != Compatiple.MANGOS) {
			context.getBean(BanIpService.class).start();
		}
		context.getBean(ThreadPoolManager.class).start();
		if (config.COMPATIBLE == Compatiple.MANGOS) {
			context.getBean(UpdateService.class).start();
		}
		Runtime.getRuntime().addShutdownHook(
				context.getBean(ShutdownHook.class));
		System.gc();
		context.getBean(AuthNetworkService.class).start();
		context.getBean(CMD_AUTH_LOGON_CHALLENGE.class);

	}
}