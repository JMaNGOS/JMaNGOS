/*******************************************************************************
 * Copyright (c) 2011 WoWEmu
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *    WoWEmu  - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.realm.module;

import org.JMANGOS.realm.config.Config;
import org.JMANGOS.realm.dao.AccountDAO;
import org.JMANGOS.realm.dao.ItemDAO;
import org.JMANGOS.realm.dao.PlayerDAO;
import org.JMANGOS.realm.dao.SimpleDataDAO;
import org.JMANGOS.realm.dao.mysql5.MySQL5AccountDAO;
import org.JMANGOS.realm.dao.mysql5.MySQL5ItemDAO;
import org.JMANGOS.realm.dao.mysql5.MySQL5PlayerDAO;
import org.JMANGOS.realm.dao.mysql5.MySQL5SimpleDataDAO;
import org.JMANGOS.realm.network.handler.R2LPacketHandlerFactory;
import org.JMANGOS.realm.network.handler.RealmPacketHandlerFactory;
import org.JMANGOS.realm.network.netty.factory.R2CPipelineFactory;
import org.JMANGOS.realm.network.netty.factory.R2LPipelineFactory;
import org.JMANGOS.realm.network.netty.handler.R2CConnectHandler;
import org.JMANGOS.realm.network.netty.handler.R2LConnectHandler;
import org.JMANGOS.realm.service.AccountService;
import org.JMANGOS.realm.service.ItemStorages;
import org.JMANGOS.realm.service.MapService;
import org.JMANGOS.realm.service.PlayerClassLevelInfoStorages;
import org.JMANGOS.realm.service.PlayerLevelStorages;
import org.JMANGOS.realm.service.RealmNetworkService;
import org.JMANGOS.realm.service.SimpleStorages;
import org.JMANGOS.realm.utils.ShutdownHook;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.JMANGOS.common.database.DatabaseFactory;
import org.JMANGOS.common.network.handlers.PacketHandlerFactory;
import org.JMANGOS.common.network.model.ConnectHandler;
import org.JMANGOS.common.network.netty.sender.AbstractPacketSender;
import org.JMANGOS.common.network.netty.sender.NettyPacketSender;
import org.JMANGOS.common.network.netty.sender.ServerPacketSender;
import org.JMANGOS.common.network.netty.service.NetworkService;
import org.JMANGOS.common.threadpool.CommonThreadPoolManager;
import org.JMANGOS.common.threadpool.ThreadPoolManager;

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
