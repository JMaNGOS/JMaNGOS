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
package org.jmangos.auth;

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

// TODO: Auto-generated Javadoc
/**
 * The Class loginserver.
 *
 * @author minimajack
 */
public class loginserver {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception {
		Injector injector = Guice.createInjector(new HandlerDM());
		ServiceContent.setInjector(injector);
		injector.getInstance(LoggingService.class).start();
		injector.getInstance(DatabaseFactory.class).start();
		injector.getInstance(WorldListService.class).start();
		injector.getInstance(Config.class).load();
		if (Config.COMPATIBLE != Compatiple.MANGOS) {
			injector.getInstance(BanIpService.class).start();
		}
		injector.getInstance(ThreadPoolManager.class).start();

		if (Config.COMPATIBLE == Compatiple.MANGOS)
			injector.getInstance(UpdateService.class).start();

		Runtime.getRuntime().addShutdownHook(
				injector.getInstance(ShutdownHook.class));
		System.gc();
		injector.getInstance(NetworkService.class).start();
	}
}
