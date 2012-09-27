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
package org.jmangos.realm.network.packet.wow.server;

import java.util.HashMap;

import org.jmangos.realm.model.account.AccountData;
import org.jmangos.realm.model.enums.AccountDataType;
import org.jmangos.realm.network.packet.wow.AbstractWoWServerPacket;

/**
 * The Class SMSG_ACCOUNT_DATA_TIMES.
 */
public class SMSG_ACCOUNT_DATA_TIMES extends AbstractWoWServerPacket {
    
    /** The Constant GLOBAL_CACHE_MASK. */
    public static final int               GLOBAL_CACHE_MASK        = 0x15;
    
    /** The Constant PER_CHARACTER_CACHE_MASK. */
    public static final int               PER_CHARACTER_CACHE_MASK = 0xEA;
    
    /** The curmask. */
    private final int                     curmask;
    
    /** The account data. */
    private HashMap<Integer, AccountData> accountData;
    
    /**
     * Instantiates a new sMS g_ accoun t_ dat a_ times.
     */
    public SMSG_ACCOUNT_DATA_TIMES() {
    
        this.curmask = GLOBAL_CACHE_MASK;
    }
    
    /**
     * Instantiates a new sMS g_ accoun t_ dat a_ times.
     * 
     * @param mask
     *            the mask
     * @param accountData
     *            the account data
     */
    public SMSG_ACCOUNT_DATA_TIMES(final int mask, final HashMap<Integer, AccountData> accountData) {
    
        this.curmask = mask;
        this.accountData = accountData;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
     */
    @Override
    public void writeImpl() {
    
        if (curmask == GLOBAL_CACHE_MASK) {
            writeD(System.currentTimeMillis() / 1000L);
            writeC(1);
            writeD(0x00000015); // 0, 2, 4
            writeD(0x0); // 0 - CONFIG
            writeD(0x0); // 2 - BINDINGS
            writeD(0x0); // 4 - MACROS
        }else{
            writeD(System.currentTimeMillis() / 1000L);
            writeC(1);
            writeD(0x000000AA); // 1, 3, 5, 7
            writeD(0x0); // 1 -  CONFIG_2
            writeD(0x0); // 3 - unk
            writeD(0x0); // 5 - unk
            writeD(0x0); // 7 - COLORS
        }
    }
}
