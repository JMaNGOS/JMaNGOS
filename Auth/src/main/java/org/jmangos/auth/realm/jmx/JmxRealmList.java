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
package org.jmangos.auth.realm.jmx;

import org.jmangos.auth.realm.controller.RealmListController;
import org.jmangos.commons.dataholder.Visitor;
import org.jmangos.commons.jmx.AbstractJmxBeanService;
import org.jmangos.commons.model.RealmInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JmxRealmList extends AbstractJmxBeanService implements JmxRealmListMBean {

    @Autowired
    private RealmListController realmListService;

    private static final String BEAN_NAME = "auth.network.realms:name=JMXRealmList";

    /**
     * @see org.jmangos.commons.jmx.AbstractJmxBeanService#getBeanName()
     */
    @Override
    protected String getBeanName() {

        return BEAN_NAME;
    }

    /**
     * @see org.jmangos.auth.realm.jmx.JmxRealmListMBean#getRealmCount()
     */
    @Override
    public String getRealmCount() {

        return String.valueOf(this.realmListService.getRealmCount());
    }

    /**
     * @see org.jmangos.auth.realm.jmx.JmxRealmListMBean#printRealmInfo()
     */
    @Override
    public String printRealmInfo() {

        final StringBuffer sb = new StringBuffer();
        this.realmListService.getRealms().iterate(new Visitor<RealmInfo>() {

            @Override
            public void visit(final RealmInfo realmInfo) {

                sb.append("Realm info for: " + realmInfo.getObjectId() + " realm");
                sb.append("\n\tName: " + realmInfo.getName());
                sb.append("\n\tPopulation: " + realmInfo.getPopulation());
                sb.append("\n");

            }
        });
        return sb.toString();
    }

}
