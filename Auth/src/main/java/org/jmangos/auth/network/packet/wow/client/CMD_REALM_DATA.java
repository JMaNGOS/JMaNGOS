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
package org.jmangos.auth.network.packet.wow.client;

import org.jmangos.auth.network.packet.wow.AbstractWoWClientPacket;
import org.jmangos.auth.realm.controller.RealmListController;
import org.jmangos.commons.model.RealmInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The Class <tt>CMD_REALM_DATA</tt>.
 */
@Component
public class CMD_REALM_DATA extends AbstractWoWClientPacket {

    /** The logger. */
    private static Logger logger = LoggerFactory.getLogger(CMD_REALM_DATA.class);

    @Autowired
    private RealmListController realmListService;

    private RealmInfo realmInfo;

    public CMD_REALM_DATA() {

        super();
    }

    @Override
    protected void readImpl() throws RuntimeException {

        logger.debug("Receive realm info from realm account: " + getAccountInfo().getName());
        this.realmInfo = new RealmInfo();
        this.realmInfo.setObjectId(getAccountInfo().getObjectId());
        this.realmInfo.setName(readS());
        this.realmInfo.setAddress(readS());
        this.realmInfo.setPort(readD());
        this.realmInfo.setIcon(readC());
        this.realmInfo.setRealmflags(readC());
        this.realmInfo.setTimezone(readC());
        this.realmInfo.setAllowedSecurityLevel(readC());
        this.realmInfo.setPopulation(readF());
        this.realmInfo.setRealmbuilds(readS());
    }

    @Override
    protected void runImpl() {

        this.realmListService.addFromConnected(this.realmInfo);
    }
}
