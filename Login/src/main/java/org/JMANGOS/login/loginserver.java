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
package org.JMANGOS.login;

import org.JMANGOS.common.config.Compatiple;
import org.JMANGOS.common.database.DatabaseFactory;
import org.JMANGOS.common.log4j.LoggingService;
import org.JMANGOS.common.network.netty.service.NetworkService;
import org.JMANGOS.common.service.ServiceContent;
import org.JMANGOS.common.threadpool.ThreadPoolManager;
import org.JMANGOS.login.config.Config;
import org.JMANGOS.login.module.HandlerDM;
import org.JMANGOS.login.service.BanIpService;
import org.JMANGOS.login.service.UpdateService;
import org.JMANGOS.login.service.WorldListService;
import org.JMANGOS.login.utils.ShutdownHook;

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
