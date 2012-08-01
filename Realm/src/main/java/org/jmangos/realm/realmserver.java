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
package org.jmangos.realm;

import org.jmangos.commons.database.DatabaseFactory;
import org.jmangos.commons.log4j.LoggingService;
import org.jmangos.commons.network.netty.service.NetworkService;
import org.jmangos.commons.service.ServiceContent;
import org.jmangos.commons.threadpool.ThreadPoolManager;
import org.jmangos.realm.config.Config;
import org.jmangos.realm.module.Handler;
import org.jmangos.realm.service.ItemStorages;
import org.jmangos.realm.service.MapService;
import org.jmangos.realm.service.PlayerClassLevelInfoStorages;
import org.jmangos.realm.service.PlayerLevelStorages;
import org.jmangos.realm.service.UpdateService;
import org.jmangos.realm.utils.ShutdownHook;

import com.google.inject.Guice;
import com.google.inject.Injector;

// TODO: Auto-generated Javadoc
/**
 * The Class realmserver.
 */
@SuppressWarnings("unused")
public class realmserver {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new Handler());
		ServiceContent.setInjector(injector);
		
		injector.getInstance(LoggingService.class).start();
		injector.getInstance(ThreadPoolManager.class).start();
		injector.getInstance(Config.class).load();
		injector.getInstance(DatabaseFactory.class).start();
		Runtime.getRuntime().addShutdownHook(injector.getInstance(ShutdownHook.class));
		//injector.getInstance(ItemStorages.class).start();
		injector.getInstance(MapService.class).start();
		injector.getInstance(PlayerClassLevelInfoStorages.class).start();
		injector.getInstance(PlayerLevelStorages.class).start();
//		injector.getInstance(UpdateService.class).start();
		
		System.gc();
		injector.getInstance(NetworkService.class).start();
	}
}
