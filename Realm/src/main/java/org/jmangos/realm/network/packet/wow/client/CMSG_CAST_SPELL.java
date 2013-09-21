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
package org.jmangos.realm.network.packet.wow.client;

import java.nio.BufferUnderflowException;

import org.jmangos.commons.entities.CharacterData;
import org.jmangos.commons.entities.CharacterSpell;
import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.jmangos.realm.network.packet.wow.AbstractWoWClientPacket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * The Class <tt>CMSG_CAST_SPELL</tt>.
 */
@Component
public class CMSG_CAST_SPELL extends AbstractWoWClientPacket {

    /** The sender. */
    @Autowired
    @Qualifier("nettyPacketSender")
    private AbstractPacketSender sender;

    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {

        final int castCount = readC();
        final int spellId = readD();
        final int flag = readC();
        final CharacterData character = getPlayer().getCharacterData();
        final CharacterSpell spell = character.getSpells().get(spellId);
        if ((spell != null) && spell.isActive()) {
            final long target = readQ();
        }
    }

    @Override
    protected void runImpl() {

    }

}
