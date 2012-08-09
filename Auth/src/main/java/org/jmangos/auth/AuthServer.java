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

import javax.inject.Inject;

import org.jmangos.auth.config.Config;
import org.jmangos.auth.module.HandlerDM;
import org.jmangos.auth.service.BanIpService;
import org.jmangos.auth.service.UpdateService;
import org.jmangos.auth.service.WorldListService;
import org.jmangos.auth.utils.ShutdownHook;
import org.jmangos.commons.config.Compatiple;
import org.jmangos.commons.database.DatabaseFactory;
import org.jmangos.commons.log4j.LoggingService;
import org.jmangos.commons.network.netty.service.NetworkService;
import org.jmangos.commons.service.ServiceContent;
import org.jmangos.commons.threadpool.ThreadPoolManager;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * The Class AuthServer.
 * 
 * @author MinimaJack
 */
public class AuthServer {
	
	@Inject 
	private static Config config;

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 * @throws Exception
	 *             the exception
	 */
	public static void main(String[] args) throws Exception {
		Injector injector = Guice.createInjector(new HandlerDM());
		ServiceContent.setInjector(injector);
		injector.getInstance(LoggingService.class).start();
		injector.getInstance(DatabaseFactory.class).start();
		injector.getInstance(WorldListService.class).start();
		if (config.COMPATIBLE != Compatiple.MANGOS) {
			injector.getInstance(BanIpService.class).start();
		}
		injector.getInstance(ThreadPoolManager.class).start();

		if (config.COMPATIBLE == Compatiple.MANGOS)
			injector.getInstance(UpdateService.class).start();

		Runtime.getRuntime().addShutdownHook(
				injector.getInstance(ShutdownHook.class));
		System.gc();
		injector.getInstance(NetworkService.class).start();
	}
}