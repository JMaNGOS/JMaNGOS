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

import org.jmangos.commons.enums.ChatLanguage;
import org.jmangos.commons.enums.ChatMsg;
import org.jmangos.commons.model.player.Player;
import org.jmangos.realm.network.packet.wow.AbstractWoWServerPacket;

/**
 * Created with IntelliJ IDEA. User: Goofy Date: 2012.08.08. Time: 4:33 To
 * change this template use
 * File | Settings | File Templates.
 */
public class SMSG_MESSAGE_CHAT extends AbstractWoWServerPacket {

    private String message;
    private ChatMsg chatMsg = ChatMsg.SYSTEM;
    private ChatLanguage chatLanguage = ChatLanguage.UNIVERSAL;
    private Player speaker = null;

    public SMSG_MESSAGE_CHAT() {

    }

    public SMSG_MESSAGE_CHAT(final String message) {

        this.message = message;
    }

    public SMSG_MESSAGE_CHAT(final String message, final ChatMsg chatMsg) {

        this.message = message;
        this.chatMsg = chatMsg;
    }

    public SMSG_MESSAGE_CHAT(final String message, final ChatMsg chatMsg,
            final ChatLanguage chatLanguage) {

        this.message = message;
        this.chatMsg = chatMsg;
        this.chatLanguage = chatLanguage;
    }

    public void setSpeaker(final Player player) {

        this.speaker = player;
    }

    @Override
    protected void writeImpl() {

        writeC(this.chatMsg.ordinal()); // 8 CHAT_MSG_SYSTEM
        writeD(this.chatLanguage.ordinal()); // 32 LANG_UNIVERSAL

        if (this.speaker != null) {
            writeQ(this.speaker.getCharacterData().getGuid());
        } else {
            writeQ(0x00); // 64 GUID
        }

        writeD(0x00); // 2.1.0
        writeD(this.speaker.getCharacterData().getName().length() + 1);
        writeS(this.speaker.getCharacterData().getName());

        writeQ(0x00); // Listener guid TODO:implement target

        writeD(this.message.length());
        writeS(this.message);

        writeC(0x00);

        // Message packet completed
    }
}
