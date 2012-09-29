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
package org.jmangos.realm.network.packet.wow.client;

import java.nio.BufferUnderflowException;

import javax.inject.Inject;
import javax.inject.Named;

import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.jmangos.realm.network.packet.wow.AbstractWoWClientPacket;
import org.jmangos.realm.network.packet.wow.server.SMSG_PONG;
import org.springframework.stereotype.Component;

/**
 * The Class CMSG_PING.
 */
@Component
public class CMSG_PING extends AbstractWoWClientPacket {
    
    /** The ping. */
    private int                  ping;
    
    /** The latency. */
    private int                  latency;
    
    /** The sender. */
    @Inject
    @Named("nettyPacketSender")
    private AbstractPacketSender sender;
    
    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {
    
        this.ping = readD();
        setLatency(readD());
        
        if (GetChannelHandler().getLastPingTime() < 0) {
            GetChannelHandler().setLastPingTime(System.currentTimeMillis());
        } else {
            // FIXME flood protection need here??
        }
    }
    
    @Override
    protected void runImpl() {
    
        this.sender.send(getClient(), new SMSG_PONG(this.ping));
        
    }
    
    public int getLatency() {
    
        return this.latency;
    }
    
    public void setLatency(final int latency) {
    
        this.latency = latency;
    }
    
}
