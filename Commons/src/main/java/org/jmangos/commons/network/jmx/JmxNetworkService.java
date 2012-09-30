package org.jmangos.commons.network.jmx;

import javax.inject.Inject;

import org.jmangos.commons.jmx.AbstractJmxBeanService;
import org.jmangos.commons.network.service.NetworkService;

public class JmxNetworkService extends AbstractJmxBeanService implements JmxNetworkServiceMBean {

    private static final String BEAN_NAME = "commons.network:name=JmxNetworkService";

    @Inject
    private NetworkService networkService;

    @Override
    public String printClientChannels() {

        return this.networkService.getChannelsInfo();
    }

    @Override
    protected String getBeanName() {

        return BEAN_NAME;
    }

}
