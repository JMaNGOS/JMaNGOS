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

import java.util.List;

import org.apache.log4j.Logger;
import org.jmangos.realm.model.base.character.CharacterData;
import org.jmangos.realm.network.netty.packetClient.AbstractWoWServerPacket;
import org.jmangos.realm.network.netty.packetClient.client.CMSG_AUTH_SESSION;

/**
 * The Class SMSG_CHAR_ENUM.
 */
public class SMSG_CHAR_ENUM extends AbstractWoWServerPacket {
	
	/** The charlist. */
	private List<CharacterData> charlist;
	
	/** The Constant logger. */
	private static final Logger logger = Logger
			.getLogger(CMSG_AUTH_SESSION.class);
	
	/**
	 * Instantiates a new sMS g_ cha r_ enum.
	 */
	public SMSG_CHAR_ENUM() {
	}

	/**
	 * Instantiates a new sMS g_ cha r_ enum.
	 *
	 * @param charlist the charlist
	 */
	public SMSG_CHAR_ENUM(List<CharacterData> charlist) {
		this.charlist = charlist;
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
	 */
	@Override
	public void writeImpl() {
		logger.info("CHARLIST SIZE "+charlist.size());
		writeC(charlist.size());
		for (CharacterData character : charlist) {
			writeQ(character.getGuid());
            //writePackedGuid( character.getGuid() );
			writeS(character.getName());
			writeC((byte)character.getRace().getValue());
			writeC((byte)character.getClazz().getValue());
			writeC(character.getGender());
			int playerBytes = character.getPlayerBytes();
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
			writeD( -1 );
            // Ban, dead, help, cloak, rename values. default: no flags
			writeD(0);
			writeD(character.getAtLoginFlags());

            writeC(0); // FIXME check at login first
            // TODO: implement Pet!
			writeD( 0x00 /*character.getPetDisplayId()*/ );
			writeD( 0x00 /*character.getPetLevel()*/ );
			writeD( 0x00 /*character.getPetFamily()*/ );

            // TODO: implement inventory
			/*for (int i = 0; i < character.getItems().length; i++) {
				writeD(character.getItems-()[i].getDisplayInfoID());
				writeC(character.getItems()[i].getDisplayInfoID());
				writeD(character.getItems()[i].getEnchantAuraId());
			}*/

            // TODO: implement bags
            for (int i = 0; i < /*character.getBags().length*/23; i++) {
				writeD(0); // DisplayID
				writeC(0); // InventoryType
				writeD(0); // Enchantment
			}
		}

	}

}
