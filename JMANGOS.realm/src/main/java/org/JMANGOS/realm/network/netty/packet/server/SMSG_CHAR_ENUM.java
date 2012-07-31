/*******************************************************************************
 * Copyright (c) 2012 JMANGOS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     JMANGOS - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.realm.network.netty.packet.server;

import java.util.List;

import org.JMANGOS.realm.model.base.character.CharactersData;
import org.JMANGOS.realm.network.netty.packet.AbstractWoWServerPacket;
import org.JMANGOS.realm.network.netty.packet.client.CMSG_AUTH_SESSION;
import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class SMSG_CHAR_ENUM.
 */
public class SMSG_CHAR_ENUM extends AbstractWoWServerPacket {
	
	/** The charlist. */
	private List<CharactersData> charlist;
	
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
	public SMSG_CHAR_ENUM(List<CharactersData> charlist) {
		this.charlist = charlist;
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
	 */
	@Override
	public void writeImpl() {
		logger.info("CHARLIST SIZE "+charlist.size());
		writeC(charlist.size());
		for (CharactersData character : charlist) {
			writeQ(character.getObjectId());
			writeS(character.getName());
			writeC(character.getRace());
			writeC(character.getClazz());
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
			writeF(character.getPos_x());
			writeF(character.getPos_y());
			writeF(character.getPos_z());
			writeD(character.getGuildId());
			writeD(0);
			writeD(character.getAtLoginFlags());
			writeC(0); // FIXME check at login first
			writeD(character.getPetDisplayId());
			writeD(character.getPetLevel());
			writeD(character.getPetFamily());
			for (int i = 0; i < character.getItems().length; i++) {
				writeD(character.getItems()[i].getDisplayInfoID());
				writeC(character.getItems()[i].getDisplayInfoID());
				writeD(character.getItems()[i].getEnchantAuraId());
			}
			for (int i = 0; i < character.getBags().length; i++) {
				writeD(0);
				writeC(0);
				writeD(0);
			}
		}

	}

}
