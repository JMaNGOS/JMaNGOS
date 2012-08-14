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
package org.jmangos.auth.service;

import javax.inject.Named;

import org.apache.commons.lang.NotImplementedException;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jmangos.auth.config.Config;
import org.jmangos.commons.network.handlers.PacketHandlerFactory;
import org.jmangos.commons.network.netty.service.AbstractNetworkService;

import com.google.inject.Inject;

/**
 * The Class LoginNetworkService.
 */
public class AuthNetworkService extends AbstractNetworkService {

	@Inject
	private Config config;

	/** The auth to client pipeline factory. */
	@Inject
	@Named("AuthToClient")
	private ChannelPipelineFactory authToClientPipelineFactory;

	/** The packet service. */
	@Inject
	@Named("AuthToClient")
	private PacketHandlerFactory packetService;

	/**
	 * 
	 * @see org.jmangos.commons.service.Service#start()
	 */
	@Override
	public void start() {
		packetService.loadPacket();
		createServerChannel(config.CLIENT_ADDRESS, authToClientPipelineFactory);
	}

	/**
	 * 
	 * @see org.jmangos.commons.network.netty.service.NetworkService#status()
	 */
	@Override
	public void status() {
		throw new NotImplementedException();
	}

	/**
	 * @see org.jmangos.commons.service.Service#stop()
	 */
	@Override
	public void stop() {
		throw new NotImplementedException();
	}

}
