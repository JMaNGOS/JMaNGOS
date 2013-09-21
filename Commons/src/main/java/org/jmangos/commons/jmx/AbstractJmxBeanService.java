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

import javax.annotation.PostConstruct;

import org.jmangos.commons.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractJmxBeanService implements Service {

    @Autowired
    private JMXService jmxService;

    @PostConstruct
    @Override
    public void start() {

        this.jmxService.start(this, getBeanName());
    }

    @Override
    public void stop() {

        this.jmxService.stop(getBeanName());
    }

    protected abstract String getBeanName();
}
