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
package org.jmangos.commons.jmx;

import javax.management.JMException;
import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author MinimaJack
 * 
 */
@Component
public class JMXService {

    private static final Logger log = LoggerFactory.getLogger(JMXService.class);

    @Autowired
    private MBeanServer server;

    /**
     * @param mBean
     * @param beanName
     */
    public void start(final Object mBean, final String name) {

        log.info(String.format("Starting JMX bean %s", name));
        try {
            this.server.registerMBean(mBean, new ObjectName(name));
        } catch (final JMException e) {
            log.error(String.format("Can't register bean %s", name), e);
        }
    }

    /**
     * @param beanName
     */
    public void stop(final String beanName) {

        log.info(String.format("Stopping JMX bean %s", beanName));
        try {
            this.server.unregisterMBean(new ObjectName(beanName));
        } catch (final JMException e) {
            log.error(String.format("Can't unregister bean %s", beanName), e);
        }
    }
}
