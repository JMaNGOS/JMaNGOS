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
package org.jmangos.realm.network.packet.wow.server;

import org.jmangos.commons.enums.TradeStatus;
import org.jmangos.realm.network.packet.wow.AbstractWoWServerPacket;

/**
 * The Class SMSG_TRADE_STATUS.
 */
public class SMSG_TRADE_STATUS extends AbstractWoWServerPacket {

    /** The trade status. */
    TradeStatus tradeStatus;

    /**
     * Instantiates a new sMS g_ trad e_ status.
     */
    public SMSG_TRADE_STATUS() {

    }

    /**
     * Instantiates a new sMS g_ trad e_ status.
     * 
     * @param _status
     *        the _status
     */
    public SMSG_TRADE_STATUS(final TradeStatus _status) {

        this.tradeStatus = _status;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
     */
    @Override
    protected void writeImpl() {

        writeD(this.tradeStatus.getStatus());
    }

}
