/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
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
 ******************************************************************************/
package org.jmangos.commons.network.jmx;

import org.jmangos.commons.jmx.AbstractJmxBeanService;
import org.jmangos.commons.network.service.NetworkService;
import org.springframework.beans.factory.annotation.Autowired;

public class JmxNetworkService extends AbstractJmxBeanService implements JmxNetworkServiceMBean {

    private static final String BEAN_NAME = "commons.network:name=JmxNetworkService";

    @Autowired
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
