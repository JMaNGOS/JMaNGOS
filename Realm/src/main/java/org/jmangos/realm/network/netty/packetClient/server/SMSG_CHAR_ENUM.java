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
package org.jmangos.realm.network.netty.packetClient.server;

import java.util.BitSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.jmangos.commons.service.ServiceContent;
import org.jmangos.realm.model.InventoryItem;
import org.jmangos.realm.model.base.character.CharacterData;
import org.jmangos.realm.network.netty.packetClient.AbstractWoWServerPacket;
import org.jmangos.realm.network.netty.packetClient.client.CMSG_AUTH_SESSION;
import org.jmangos.realm.service.ItemStorages;

/**
 * The Class SMSG_CHAR_ENUM.
 */
public class SMSG_CHAR_ENUM extends AbstractWoWServerPacket {
    
    /** The charlist. */
    private final List<CharacterData> charlist;
    
    /** The Constant logger. */
    private static final Logger       logger = Logger.getLogger(CMSG_AUTH_SESSION.class);
    
    /**
     * Instantiates a new <tt>SMSG_CHAR_ENUM</tt> packet.
     * 
     * @param charlist
     *            the charlist
     */
    public SMSG_CHAR_ENUM(final List<CharacterData> charlist) {
    
        this.charlist = charlist;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
     */
    @Override
    public void writeImpl() {
    
        logger.info("CHARLIST SIZE " + this.charlist.size());
        writeC(this.charlist.size());
        for (final CharacterData character : this.charlist) {
            writeQ(character.getGuid());
            // writePackedGuid( character.getGuid() );
            writeS(character.getName());
            writeC((byte) character.getRace().getValue());
            writeC((byte) character.getClazz().getValue());
            writeC(character.getGender());
            final int playerBytes = character.getPlayerBytes();
            writeC(playerBytes & 0xFF);
            writeC((playerBytes >> 8) & 0xFF);
            writeC((playerBytes >> 16) & 0xFF);
            writeC((playerBytes >> 24) & 0xFF);
            writeC(character.getPlayerBytes2() & 0xFF);
            writeC(character.getLevel());
            writeD(character.getZone());
            writeD(character.getMap());
            writeF(character.getPositionX());
            writeF(character.getPositionY());
            writeF(character.getPositionY());
            // TODO: implement guild
            writeD(-1);
            // Ban, dead, help, cloak, rename values. default: no flags
            writeD(0);
            writeD(character.getAtLoginFlags());
            
            writeC(0); // FIXME check at login first
            // TODO: implement Pet!
            writeD(0x00 /* character.getPetDisplayId() */);
            writeD(0x00 /* character.getPetLevel() */);
            writeD(0x00 /* character.getPetFamily() */);
            
            final List<InventoryItem> inventory = character.getInventory();
            
            final ItemStorages itemStorages = ServiceContent.getInjector().getInstance(ItemStorages.class);
            if (itemStorages == null) {
                logger.fatal("Cannot get ItemStorages instance!");
            }
            
            for (int i = 0; i < 23; i++) {
                final InventoryItem invItem = character.findInventorySlot(i);
                if (invItem != null) {
                    int displayInfoID = 0x00;
                    try {
                        displayInfoID = itemStorages.get(invItem.getItem_guid()).getDisplayInfoID();
                    } catch (final Exception e) {
                        logger.fatal("ID not found in the storage: " + invItem.getItem_guid(), e);
                    }
                    
                    writeD(displayInfoID);
                    writeC(displayInfoID);
                    writeD(0x00 /*
                                 * paalgyula: need some info about it
                                 * character.getItems()[i].getEnchantAuraId()
                                 */);
                } else {
                    writeD(0x00);
                    writeC(0x00);
                    writeD(0x00);
                }
            }
            
            // TODO: implement bags
            /*
             * for (int i = 0; i < character.getBags().length; i++) { writeD(0); // DisplayID
             * writeC(0); // InventoryType writeD(0); // Enchantment }
             */
            
            new BitSet();
        }
        
    }
    
}
