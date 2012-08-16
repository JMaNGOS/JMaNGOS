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

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.jmangos.auth.module.HandlerDM;
import org.jmangos.auth.service.BanIpService;
import org.jmangos.auth.service.RealmListService;
import org.jmangos.auth.service.jmx.JmxRealmList;
import org.jmangos.auth.utils.ShutdownHook;
import org.jmangos.commons.database.DatabaseFactory;
import org.jmangos.commons.network.jmx.JmxNetworkService;
import org.jmangos.commons.network.netty.service.NetworkService;
import org.jmangos.commons.service.ServiceContent;
import org.jmangos.commons.threadpool.ThreadPoolManager;

/**
 * The Class AuthServer.
 * 
 * @author MinimaJack
 */
public class AuthServer {
	
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
		injector.getInstance(DatabaseFactory.class).start();
		injector.getInstance(RealmListService.class).start();
		injector.getInstance(BanIpService.class).start();
		injector.getInstance(ThreadPoolManager.class).start();
		
		injector.getInstance(JmxRealmList.class).start();
		injector.getInstance(JmxNetworkService.class).start();
		
		Runtime.getRuntime().addShutdownHook(
				injector.getInstance(ShutdownHook.class));
		System.gc();
		
		injector.getInstance(NetworkService.class).start();
	}
}