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
package org.jmangos.auth.module;

import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jmangos.auth.dao.AccountDAO;
import org.jmangos.auth.dao.BanIpDAO;
import org.jmangos.auth.dao.RealmDAO;
import org.jmangos.auth.dao.mysql5.MySQL5AccountDAO;
import org.jmangos.auth.dao.mysql5.MySQL5BannedIpDAO;
import org.jmangos.auth.dao.mysql5.MySQL5RealmDAO;
import org.jmangos.auth.network.handler.AuthToClientPacketHandlerFactory;
import org.jmangos.auth.network.netty.factory.AuthToClientPipelineFactory;
import org.jmangos.auth.network.netty.handler.AuthToClientConnectHandler;
import org.jmangos.auth.service.AccountService;
import org.jmangos.auth.service.BanIpService;
import org.jmangos.auth.service.AuthNetworkService;
import org.jmangos.auth.service.RealmListService;
import org.jmangos.auth.service.jmx.JmxRealmList;
import org.jmangos.auth.utils.ShutdownHook;
import org.jmangos.commons.database.DatabaseFactory;
import org.jmangos.commons.module.CommonModule;
import org.jmangos.commons.network.handlers.PacketHandlerFactory;
import org.jmangos.commons.network.model.ConnectHandler;
import org.jmangos.commons.network.netty.sender.AbstractPacketSender;
import org.jmangos.commons.network.netty.sender.NettyPacketSender;
import org.jmangos.commons.network.netty.service.NetworkService;
import org.jmangos.commons.threadpool.CommonThreadPoolManager;
import org.jmangos.commons.threadpool.ThreadPoolManager;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;

/**
 * The Class HandlerDM.
 */
public class HandlerDM extends AbstractModule {

	/**
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		install(new CommonModule());
		
		bind(String.class).annotatedWith(Names.named("toClient")).toInstance(
				"./conf/packetData/lc-packets.xml");
		
		bind(NetworkService.class).to(AuthNetworkService.class).in(
				Scopes.SINGLETON);
		bind(ThreadPoolManager.class).to(CommonThreadPoolManager.class).in(
				Scopes.SINGLETON);

		bind(PacketHandlerFactory.class)
				.annotatedWith(Names.named("AuthToClient"))
				.to(AuthToClientPacketHandlerFactory.class)
				.in(Scopes.SINGLETON);
		bind(ChannelPipelineFactory.class)
				.annotatedWith(Names.named("AuthToClient"))
				.to(AuthToClientPipelineFactory.class).in(Scopes.SINGLETON);

		bind(ConnectHandler.class).annotatedWith(Names.named("AuthToClient"))
				.to(AuthToClientConnectHandler.class).in(Scopes.SINGLETON);
		bind(AbstractPacketSender.class).to(NettyPacketSender.class).in(
				Scopes.SINGLETON);

		bind(RealmDAO.class).to(MySQL5RealmDAO.class).in(Scopes.SINGLETON);
		bind(AccountDAO.class).to(MySQL5AccountDAO.class).in(Scopes.SINGLETON);
		bind(BanIpDAO.class).to(MySQL5BannedIpDAO.class).in(Scopes.SINGLETON);

		bind(RealmListService.class).in(Scopes.SINGLETON);
		bind(BanIpService.class).in(Scopes.SINGLETON);

		bind(DatabaseFactory.class).in(Scopes.SINGLETON);
		bind(AccountService.class).in(Scopes.SINGLETON);
		bind(ShutdownHook.class).in(Scopes.SINGLETON);
		
		bind(JmxRealmList.class).in(Scopes.SINGLETON);

	}
}
