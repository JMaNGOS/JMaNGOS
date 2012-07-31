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
package org.JMANGOS.realm.service;

import javax.inject.Named;

import org.JMANGOS.realm.config.Config;
import org.apache.commons.lang.NotImplementedException;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.JMANGOS.common.network.netty.service.AbstractNetworkService;
import com.google.inject.Inject;

// TODO: Auto-generated Javadoc
/**
 * The Class RealmNetworkService.
 */
public class RealmNetworkService extends AbstractNetworkService {
	
	/** The r2c pipeline factory. */
	@Inject
	@Named("r2c")
	private ChannelPipelineFactory r2cPipelineFactory;
	@Inject
	@Named("r2l")
	private ChannelPipelineFactory r2lPipelineFactory;

	/* (non-Javadoc)
 * @see org.wowemu.common.service.Service#start()
 */
@Override
	public void start() {
		createServerChannel(Config.CLIENT_ADDRESS, r2cPipelineFactory);
		createClientChannel(Config.LOGIN_ADDRESS, r2lPipelineFactory);
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.netty.service.NetworkService#status()
	 */
	@Override
	public void status() {
		throw new NotImplementedException();
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.service.Service#stop()
	 */
	@Override
	public void stop() {
		throw new NotImplementedException();
	}
}
