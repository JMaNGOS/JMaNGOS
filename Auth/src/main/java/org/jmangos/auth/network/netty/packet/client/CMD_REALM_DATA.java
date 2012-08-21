/*******************************************************************************
 * Copyright (C) 2012 JMaNGOS <http://jmangos.org/>
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
 *******************************************************************************/
package org.jmangos.auth.network.netty.packet.client;

import javax.inject.Inject;

import org.jmangos.auth.network.netty.packet.AbstractWoWClientPacket;
import org.jmangos.auth.service.RealmListService;
import org.jmangos.commons.model.Realm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The Class <tt>CMD_REALM_DATA</tt>.
 */
@Component
public class CMD_REALM_DATA extends AbstractWoWClientPacket {
    
    /** The logger. */
    private static Logger    logger = LoggerFactory.getLogger(CMD_REALM_DATA.class);
    
    @Inject
    private RealmListService realmListService;
    
    private Realm            realm;
    
    public CMD_REALM_DATA() {
    
        super();
    }
    
    @Override
    protected void readImpl() throws RuntimeException {
    
        logger.debug("Receive realm info from realm account: " + getAccount().getName());
        this.realm = new Realm();
        this.realm.setId(getAccount().getObjectId());
        this.realm.setName(readS());
        this.realm.setAddress(readS());
        this.realm.setPort(readD());
        this.realm.setIcon(readC());
        this.realm.setRealmflags(readC());
        this.realm.setTimezone(readC());
        this.realm.setAllowedSecurityLevel(readC());
        this.realm.setPopulation(readF());
        this.realm.setRealmbuilds(readS());
    }
    
    @Override
    protected void runImpl() {
    
        this.realmListService.addFromConnected(this.realm);
    }
}
