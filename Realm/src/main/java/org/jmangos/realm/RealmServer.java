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
package org.jmangos.realm;

import org.jmangos.commons.database.DatabaseFactory;
import org.jmangos.commons.network.netty.service.NetworkService;
import org.jmangos.commons.service.ServiceContent;
import org.jmangos.commons.threadpool.ThreadPoolManager;
import org.jmangos.realm.module.Handler;
import org.jmangos.realm.service.MapService;
import org.jmangos.realm.service.PlayerClassLevelInfoStorages;
import org.jmangos.realm.service.PlayerLevelStorages;
import org.jmangos.realm.utils.ShutdownHook;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * The Class RealmServer.
 */
public class RealmServer {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new Handler());
		ServiceContent.setInjector(injector);
		injector.getInstance(ThreadPoolManager.class).start();
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
