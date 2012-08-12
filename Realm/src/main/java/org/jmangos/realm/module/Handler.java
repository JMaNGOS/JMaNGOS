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
package org.jmangos.realm.module;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;
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
import org.jmangos.realm.network.handler.RealmToAuthPacketHandlerFactory;
import org.jmangos.realm.network.handler.RealmToClientPacketHandlerFactory;
import org.jmangos.realm.network.netty.factory.RealmToAuthPipelineFactory;
import org.jmangos.realm.network.netty.factory.RealmToClientPipelineFactory;
import org.jmangos.realm.network.netty.handler.RealmToAuthConnectHandler;
import org.jmangos.realm.network.netty.handler.RealmToClientConnectHandler;
import org.jmangos.realm.service.*;
import org.jmangos.realm.utils.ShutdownHook;


/**
 * The Class Handler.
 */
public class Handler extends AbstractModule {
	
	/** (non-Javadoc)
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

		bind(AbstractPacketSender.class).annotatedWith(Names.named("RealmToAuth")).to(
				ServerPacketSender.class).in(Scopes.SINGLETON);
		bind(PacketHandlerFactory.class).annotatedWith(Names.named("AuthToClient")).to(
				RealmToClientPacketHandlerFactory.class).in(Scopes.SINGLETON);
		bind(PacketHandlerFactory.class).annotatedWith(Names.named("RealmToAuth")).to(
				RealmToAuthPacketHandlerFactory.class).in(Scopes.SINGLETON);

		bind(ChannelPipelineFactory.class).annotatedWith(Names.named("RealmToClient"))
				.to(RealmToClientPipelineFactory.class).in(Scopes.SINGLETON);
		bind(ChannelPipelineFactory.class).annotatedWith(Names.named("RealmToAuth"))
				.to(RealmToAuthPipelineFactory.class).in(Scopes.SINGLETON);
		bind(ConnectHandler.class).annotatedWith(Names.named("RealmToClient")).to(
				RealmToClientConnectHandler.class).in(Scopes.SINGLETON);
		bind(ConnectHandler.class).annotatedWith(Names.named("RealmToAuth")).to(
				RealmToAuthConnectHandler.class).in(Scopes.SINGLETON);

        bind(AccountDAO.class).in(Scopes.SINGLETON);
		bind(PlayerDAO.class).in(Scopes.SINGLETON);
		bind(ItemDAO.class).in(Scopes.SINGLETON);
		bind(SimpleDataDAO.class).in(Scopes.SINGLETON);
		bind(ItemStorages.class).in(Scopes.SINGLETON);
        bind(DBCStorage.class).in(Scopes.SINGLETON);
		bind(SimpleStorages.class).in(Scopes.SINGLETON);
		bind(Config.class).in(Scopes.SINGLETON);

		bind(PlayerClassLevelInfoStorages.class).in(Scopes.SINGLETON);
		bind(PlayerLevelStorages.class).in(Scopes.SINGLETON);
		bind(MapService.class).in(Scopes.SINGLETON);
		bind(AccountService.class).in(Scopes.SINGLETON);
		bind(DatabaseFactory.class).in(Scopes.SINGLETON);
		bind(ShutdownHook.class).in(Scopes.SINGLETON);

	}
}
