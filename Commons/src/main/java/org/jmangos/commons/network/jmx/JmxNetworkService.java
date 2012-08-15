package org.jmangos.commons.network.jmx;

import org.jmangos.commons.jmx.AbstractJmxBeanService;
import org.jmangos.commons.network.netty.service.NetworkService;

import com.google.inject.Inject;

public class JmxNetworkService extends AbstractJmxBeanService  implements
		JmxNetworkServiceMBean {
	private static final String BEAN_NAME = "commons.network:name=JmxNetworkService";

	@Inject
	private NetworkService networkService;

	@Override
	public String printClientChannels() {
		return networkService.getChannelsInfo();
	}

	@Override
	protected String getBeanName() {
		return BEAN_NAME;
	}

}
