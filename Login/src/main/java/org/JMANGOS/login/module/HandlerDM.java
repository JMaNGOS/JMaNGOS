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
package org.JMANGOS.login.module;

import org.jboss.netty.channel.ChannelPipelineFactory;
import org.JMANGOS.common.database.DatabaseFactory;
import org.JMANGOS.common.network.handlers.PacketHandlerFactory;
import org.JMANGOS.common.network.model.ConnectHandler;
import org.JMANGOS.common.network.netty.sender.AbstractPacketSender;
import org.JMANGOS.common.network.netty.sender.NettyPacketSender;
import org.JMANGOS.common.network.netty.service.NetworkService;
import org.JMANGOS.common.threadpool.CommonThreadPoolManager;
import org.JMANGOS.common.threadpool.ThreadPoolManager;
import org.JMANGOS.login.dao.AccountDAO;
import org.JMANGOS.login.dao.BanIpDAO;
import org.JMANGOS.login.dao.WorldDAO;
import org.JMANGOS.login.dao.mysql5.MySQL5AccountDAO;
import org.JMANGOS.login.dao.mysql5.MySQL5BannedIpDAO;
import org.JMANGOS.login.dao.mysql5.MySQL5WorldDAO;
import org.JMANGOS.login.network.handler.L2CPacketHandlerFactory;
import org.JMANGOS.login.network.handler.L2RPacketHandlerFactory;
import org.JMANGOS.login.network.netty.factory.L2CPipelineFactory;
import org.JMANGOS.login.network.netty.factory.L2RPipelineFactory;
import org.JMANGOS.login.network.netty.handler.L2CConnectHandler;
import org.JMANGOS.login.service.AccountService;
import org.JMANGOS.login.service.BanIpService;
import org.JMANGOS.login.service.LoginNetworkService;
import org.JMANGOS.login.service.WorldListService;
import org.JMANGOS.login.utils.ShutdownHook;

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
