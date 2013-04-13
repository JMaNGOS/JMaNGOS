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

import org.jmangos.commons.entities.*;
import org.jmangos.realm.network.packet.wow.AbstractWoWServerPacket;

/**
 * Created with IntelliJ IDEA.
 * User: GiBSON
 * Date: 13.04.13
 * Time: 21:12
 */
public class SMSG_CHAR_CUSTOMIZE extends AbstractWoWServerPacket {

    private Integer code;
    private CharacterData characterData;

    public static enum Code {
        SUCCESS(0x00),
        NAME_IN_USE(0x32);

        private int value;

        Code(final int value) {

            this.value = value;
        }

        public int getValue() {

            return this.value;
        }
    };

    public SMSG_CHAR_CUSTOMIZE() {

    }
    public SMSG_CHAR_CUSTOMIZE(final CharacterData characterData) {
        this.characterData = characterData;
    }

    public SMSG_CHAR_CUSTOMIZE(final int code) {

        this.code = code;
    }

    public SMSG_CHAR_CUSTOMIZE(final Code code) {

        this.code = code.getValue();
    }

    @Override
    protected void writeImpl() {
        if (this.code != null) {
            writeC(this.code);
        } else {
            writeC(Code.SUCCESS.getValue());
            writePackedGuid(this.characterData.getGuid());
            writeS(this.characterData.getName());
            writeC((this.characterData.getBytes() >> 16) & 0xFF); // gender
            writeC(this.characterData.getPlayerBytes() & 0xFF);   // skin
            writeC((this.characterData.getPlayerBytes() >> 8) & 0xFF); // face
            writeC((this.characterData.getPlayerBytes() >> 16) & 0xFF); // hairStyle
            writeC((this.characterData.getPlayerBytes() >> 24) & 0xFF); // hairColor
            writeC(this.characterData.getPlayerBytes2() & 0xFF); // facialHair
        }
    }
}
