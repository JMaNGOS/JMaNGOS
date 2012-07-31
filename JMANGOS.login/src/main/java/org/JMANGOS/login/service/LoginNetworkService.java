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
package org.JMANGOS.login.service;

import javax.inject.Named;

import org.apache.commons.lang.NotImplementedException;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.JMANGOS.common.network.netty.service.AbstractNetworkService;
import org.JMANGOS.login.config.Config;

import com.google.inject.Inject;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginNetworkService.
 */
public class LoginNetworkService extends AbstractNetworkService {

	/** The l2c pipeline factory. */
	@Inject
	@Named("l2c")
	private ChannelPipelineFactory l2cPipelineFactory;

	/** The l2r pipeline factory. */
	@SuppressWarnings("unused")
	@Inject
	@Named("l2r")
	private ChannelPipelineFactory l2rPipelineFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.wowemu.common.service.Service#start()
	 */
	@Override
	public void start() {
		createServerChannel(Config.CLIENT_ADDRESS, l2cPipelineFactory);
		// createServerChannel(Config.REALM_ADDRESS, l2rPipelineFactory);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.wowemu.common.network.netty.service.NetworkService#status()
	 */
	@Override
	public void status() {
		throw new NotImplementedException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.wowemu.common.service.Service#stop()
	 */
	@Override
	public void stop() {
		throw new NotImplementedException();
	}
}
