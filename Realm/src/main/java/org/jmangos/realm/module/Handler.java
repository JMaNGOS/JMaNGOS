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
package org.jmangos.realm.module;

import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jmangos.commons.database.DatabaseFactory;
import org.jmangos.commons.network.handlers.PacketHandlerFactory;
import org.jmangos.commons.network.model.ConnectHandler;
import org.jmangos.commons.network.netty.sender.AbstractPacketSender;
import org.jmangos.commons.network.netty.sender.NettyPacketSender;
import org.jmangos.commons.network.netty.sender.ServerPacketSender;
import org.jmangos.commons.network.netty.service.NetworkService;
import org.jmangos.commons.threadpool.CommonThreadPoolManager;
import org.jmangos.commons.threadpool.ThreadPoolManager;
import org.jmangos.realm.config.Config;
import org.jmangos.realm.dao.AccountDAO;
import org.jmangos.realm.dao.ItemDAO;
import org.jmangos.realm.dao.PlayerDAO;
import org.jmangos.realm.dao.SimpleDataDAO;
import org.jmangos.realm.dao.mysql5.MySQL5AccountDAO;
import org.jmangos.realm.dao.mysql5.MySQL5ItemDAO;
import org.jmangos.realm.dao.mysql5.MySQL5PlayerDAO;
import org.jmangos.realm.dao.mysql5.MySQL5SimpleDataDAO;
import org.jmangos.realm.network.handler.R2LPacketHandlerFactory;
import org.jmangos.realm.network.handler.RealmPacketHandlerFactory;
import org.jmangos.realm.network.netty.factory.R2CPipelineFactory;
import org.jmangos.realm.network.netty.factory.R2LPipelineFactory;
import org.jmangos.realm.network.netty.handler.R2CConnectHandler;
import org.jmangos.realm.network.netty.handler.R2LConnectHandler;
import org.jmangos.realm.service.AccountService;
import org.jmangos.realm.service.ItemStorages;
import org.jmangos.realm.service.MapService;
import org.jmangos.realm.service.PlayerClassLevelInfoStorages;
import org.jmangos.realm.service.PlayerLevelStorages;
import org.jmangos.realm.service.RealmNetworkService;
import org.jmangos.realm.service.SimpleStorages;
import org.jmangos.realm.utils.ShutdownHook;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;


// TODO: Auto-generated Javadoc
/**
 * The Class Handler.
 */
public class Handler extends AbstractModule {
	
	/* (non-Javadoc)
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {

		bind(NetworkService.class).to(RealmNetworkService.class).in(
				Scopes.SINGLETON);

		bind(ThreadPoolManager.class).to(CommonThreadPoolManager.class).in(
				Scopes.SINGLETON);
		bind(AbstractPacketSender.class).annotatedWith(Names.named("client"))
				.to(NettyPacketSender.class).in(Scopes.SINGLETON);

		bind(AbstractPacketSender.class).annotatedWith(Names.named("r2l")).to(
				ServerPacketSender.class).in(Scopes.SINGLETON);
		bind(PacketHandlerFactory.class).annotatedWith(Names.named("l2c")).to(
				RealmPacketHandlerFactory.class).in(Scopes.SINGLETON);
		bind(PacketHandlerFactory.class).annotatedWith(Names.named("r2l")).to(
				R2LPacketHandlerFactory.class).in(Scopes.SINGLETON);

		bind(ChannelPipelineFactory.class).annotatedWith(Names.named("r2c"))
				.to(R2CPipelineFactory.class).in(Scopes.SINGLETON);
		bind(ChannelPipelineFactory.class).annotatedWith(Names.named("r2l"))
				.to(R2LPipelineFactory.class).in(Scopes.SINGLETON);
		bind(ConnectHandler.class).annotatedWith(Names.named("r2c")).to(
				R2CConnectHandler.class).in(Scopes.SINGLETON);
		bind(ConnectHandler.class).annotatedWith(Names.named("r2l")).to(
				R2LConnectHandler.class).in(Scopes.SINGLETON);

		bind(AccountDAO.class).to(MySQL5AccountDAO.class).in(Scopes.SINGLETON);
		bind(PlayerDAO.class).to(MySQL5PlayerDAO.class).in(Scopes.SINGLETON);
		bind(ItemDAO.class).to(MySQL5ItemDAO.class).in(Scopes.SINGLETON);
		bind(SimpleDataDAO.class).to(MySQL5SimpleDataDAO.class).in(
				Scopes.SINGLETON);
		bind(ItemStorages.class).in(Scopes.SINGLETON);
		bind(SimpleStorages.class).in(Scopes.SINGLETON);
		bind(Config.class).in(Scopes.SINGLETON);

		bind(PlayerClassLevelInfoStorages.class).in(Scopes.SINGLETON);
		bind(PlayerLevelStorages.class).in(Scopes.SINGLETON);
		bind(MapService.class).in(Scopes.SINGLETON);
		bind(AccountService.class).in(Scopes.SINGLETON);
		bind(DatabaseFactory.class).in(Scopes.SINGLETON);
		bind(DatabaseFactory.class).in(Scopes.SINGLETON);
		bind(ShutdownHook.class).in(Scopes.SINGLETON);

	}
}
