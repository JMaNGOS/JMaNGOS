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
package org.jmangos.realm.network.handler;

import org.jmangos.commons.network.handlers.AbstractPacketHandlerFactory;
import org.jmangos.commons.network.model.PacketData;
import org.springframework.stereotype.Component;

/**
 * A factory for creating RealmPacketHandler objects.
 */
@Component("сlientPacketHandlerFactory")
public class RealmToClientPacketHandlerFactory extends AbstractPacketHandlerFactory {
    
    /**
     * @see org.jmangos.commons.network.handlers.PacketHandlerFactory#loadPacket()
     */
    @Override
    public void loadPacket() {
    
        clientPacketPath = "./conf/packetData/rc-packets.xml";
        addList(loadStaticData(PacketData.class, this.packetXSDLocation, this.clientPacketPath));
    }
}
