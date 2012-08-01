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
package org.jmangos.auth.module;

import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jmangos.auth.dao.AccountDAO;
import org.jmangos.auth.dao.BanIpDAO;
import org.jmangos.auth.dao.WorldDAO;
import org.jmangos.auth.dao.mysql5.MySQL5AccountDAO;
import org.jmangos.auth.dao.mysql5.MySQL5BannedIpDAO;
import org.jmangos.auth.dao.mysql5.MySQL5WorldDAO;
import org.jmangos.auth.network.handler.L2CPacketHandlerFactory;
import org.jmangos.auth.network.handler.L2RPacketHandlerFactory;
import org.jmangos.auth.network.netty.factory.L2CPipelineFactory;
import org.jmangos.auth.network.netty.factory.L2RPipelineFactory;
import org.jmangos.auth.network.netty.handler.L2CConnectHandler;
import org.jmangos.auth.service.AccountService;
import org.jmangos.auth.service.BanIpService;
import org.jmangos.auth.service.LoginNetworkService;
import org.jmangos.auth.service.WorldListService;
import org.jmangos.auth.utils.ShutdownHook;
import org.jmangos.commons.database.DatabaseFactory;
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

// TODO: Auto-generated Javadoc
/**
 * The Class HandlerDM.
 */
public class HandlerDM extends AbstractModule {
	
	/* (non-Javadoc)
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		bind(NetworkService.class).to(LoginNetworkService.class).in(
				Scopes.SINGLETON);
		bind(ThreadPoolManager.class).to(CommonThreadPoolManager.class).in(
				Scopes.SINGLETON);
		
		bind(PacketHandlerFactory.class).annotatedWith(Names.named("l2c")).to(
				L2CPacketHandlerFactory.class).in(Scopes.SINGLETON);
		bind(PacketHandlerFactory.class).annotatedWith(Names.named("l2r")).to(
				L2RPacketHandlerFactory.class).in(Scopes.SINGLETON);
		bind(ChannelPipelineFactory.class).annotatedWith(Names.named("l2c"))
				.to(L2CPipelineFactory.class).in(Scopes.SINGLETON);
		bind(ChannelPipelineFactory.class).annotatedWith(Names.named("l2r"))
				.to(L2RPipelineFactory.class).in(Scopes.SINGLETON);

		bind(ConnectHandler.class).annotatedWith(Names.named("l2c")).to(
				L2CConnectHandler.class).in(Scopes.SINGLETON);
		bind(AbstractPacketSender.class).to(NettyPacketSender.class).in(
				Scopes.SINGLETON);

		bind(WorldDAO.class).to(MySQL5WorldDAO.class).in(Scopes.SINGLETON);
		bind(AccountDAO.class).to(MySQL5AccountDAO.class).in(Scopes.SINGLETON);
		bind(BanIpDAO.class).to(MySQL5BannedIpDAO.class).in(Scopes.SINGLETON);

		bind(WorldListService.class).in(Scopes.SINGLETON);
		bind(BanIpService.class).in(Scopes.SINGLETON);

		bind(DatabaseFactory.class).in(Scopes.SINGLETON);
		bind(AccountService.class).in(Scopes.SINGLETON);
		bind(ShutdownHook.class).in(Scopes.SINGLETON);

	}
}
