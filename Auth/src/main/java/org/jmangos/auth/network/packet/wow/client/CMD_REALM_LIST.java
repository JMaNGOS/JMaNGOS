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

import org.jmangos.auth.config.Config;
import org.jmangos.auth.network.packet.wow.AbstractWoWClientPacket;
import org.jmangos.auth.network.packet.wow.server.SMD_REALM_LIST;
import org.jmangos.auth.realm.controller.RealmListController;
import org.jmangos.commons.config.Compatiple;
import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * The Class <tt>CMD_REALM_LIST</tt>.
 */
@Component
public class CMD_REALM_LIST extends AbstractWoWClientPacket {

    /** The sender. */
    @Autowired
    @Qualifier("nettyPacketSender")
    private AbstractPacketSender sender;

    /** The RealmListController. */
    @Autowired
    private RealmListController realmListController;

    /** The Config. */
    @Autowired
    private Config config;

    /**
     * 
     * @see org.jmangos.commons.network.model.ReceivablePacket#getMinimumLength()
     */
    @Override
    public int getMinimumLength() {

        return 4;
    }

    /**
     * Instantiates a new CMD_REALM_LIST.
     */
    public CMD_REALM_LIST() {

        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void readImpl() {

        readB(getAvaliableBytes());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void runImpl() {

        // must be reloaded from db
        if (this.config.COMPATIBLE.equals(Compatiple.MANGOS)) {
            this.realmListController.update();
        }
        this.sender.send(getClient(), new SMD_REALM_LIST(this.realmListController));
    }
}
