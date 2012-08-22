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
package org.jmangos.auth.network.packet.wow.server;

import org.jmangos.auth.network.packet.wow.AbstractWoWServerPacket;
import org.jmangos.auth.utils.AccountUtils;
import org.jmangos.commons.model.Account;
import org.jmangos.commons.model.WoWAuthResponse;
import org.jmangos.commons.utils.BigNumber;

/**
 * The Class <tt>TCMD_AUTH_LOGON_CHALLENGE</tt>.
 * 
 */
public class SMD_AUTH_LOGON_CHALLENGE extends AbstractWoWServerPacket {
    
    /** The response. */
    private WoWAuthResponse response;
    
    /**
     * Constructs new instance of <tt>TCMD_AUTH_LOGON_CHALLENGE</tt> packet.
     * 
     * @param response
     *            auth response
     */
    public SMD_AUTH_LOGON_CHALLENGE(final WoWAuthResponse response) {
    
        this.response = response;
    }
    
    /**
	 * 
	 */
    public SMD_AUTH_LOGON_CHALLENGE() {
    
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void writeImpl() {
    
        writeC(0x00);
        writeC(this.response.getMessageId());
        if (this.response == WoWAuthResponse.WOW_SUCCESS) {
            final BigNumber unk3 = new BigNumber();
            unk3.setRand(16);
            writeB(((Account) (getChannel().getChanneledObject())).getcryptoB().asByteArray(32));
            writeC(1);
            writeB(AccountUtils.g.asByteArray(1));
            writeC(32);
            writeB(AccountUtils.N.asByteArray(32));
            writeB(((Account) (getChannel().getChanneledObject())).getS_crypto().asByteArray(32));
            writeB(unk3.asByteArray(16));
            writeC(0);
        }
    }
}
