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
package org.jmangos.realm.service;

import com.google.inject.Inject;
import org.apache.commons.lang.NotImplementedException;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jmangos.commons.config.Compatiple;
import org.jmangos.commons.network.handlers.PacketHandlerFactory;
import org.jmangos.commons.network.netty.service.AbstractNetworkService;
import org.jmangos.realm.config.Config;

import javax.inject.Named;

/**
 * The Class RealmNetworkService.
 */
public class RealmNetworkService extends AbstractNetworkService {
	@Inject
	private Config config;

	/** The RealmToClient pipeline factory. */
	@Inject
	@Named("RealmToClient")
	private ChannelPipelineFactory realmToClientPipelineFactory;

	/** The packet service. */
	@Inject
	@Named("AuthToClient")
	private PacketHandlerFactory clientPacketService;
	/** The packet service. */
	@Inject
	@Named("RealmToAuth")
	private PacketHandlerFactory authPacketService;

	@Inject
	@Named("RealmToAuth")
	private ChannelPipelineFactory realmToAuthPipelineFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jmangos.commons.service.Service#start()
	 */
	@Override
	public void start() {
		clientPacketService.loadPacket();
		createServerChannel(config.CLIENT_ADDRESS, realmToClientPipelineFactory);
		// Only run if auth server not from mangos team
		if (!config.COMPATIBLE.equals(Compatiple.MANGOS)) {
			authPacketService.loadPacket();
			createClientChannel(config.AUTH_ADDRESS, realmToAuthPipelineFactory);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jmangos.commons.network.netty.service.NetworkService#status()
	 */
	@Override
	public void status() {
		throw new NotImplementedException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jmangos.commons.service.Service#stop()
	 */
	@Override
	public void stop() {
		throw new NotImplementedException();
	}
}
