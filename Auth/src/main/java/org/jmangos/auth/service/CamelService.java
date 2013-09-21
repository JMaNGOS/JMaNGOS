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
package org.jmangos.auth.service;

import org.apache.camel.spring.CamelContextFactoryBean;
import org.springframework.stereotype.Service;

@Service
public class CamelService extends CamelContextFactoryBean {

    /**
     * Basic spring camel service
     */
    public CamelService() {
        super();
        /** set camel context id */
        setId("Camel");
        /** add packages to search routes */
        setPackages(new String[] { "org.jmangos.auth.route" });
    }
}
