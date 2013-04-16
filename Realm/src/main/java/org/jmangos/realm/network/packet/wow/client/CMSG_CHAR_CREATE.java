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

import org.jmangos.commons.controller.CharacterController;
import org.jmangos.commons.enums.CharCreateCode;
import org.jmangos.commons.enums.Classes;
import org.jmangos.commons.enums.Gender;
import org.jmangos.commons.enums.Races;
import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.jmangos.realm.network.packet.wow.AbstractWoWClientPacket;
import org.jmangos.realm.network.packet.wow.server.SMSG_CHAR_CREATE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA. User: Goofy Date: 2012.08.07. Time: 23:26 To
 * change this template use
 * File | Settings | File Templates.
 */
@Component
public class CMSG_CHAR_CREATE extends AbstractWoWClientPacket {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier("nettyPacketSender")
    private AbstractPacketSender sender;
    @Autowired
    private CharacterController characterController;

    String charName;
    Races charRace;
    Classes charClass;
    Gender gender;

    Integer skin, face, hairStyle, hairColor, facialHair;

    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {

        this.charName = readS();
        this.charRace = Races.get(readC());
        this.charClass = Classes.get(readC());

        this.gender = Gender.get(readC());
        this.skin = readC();
        this.face = readC();
        this.hairStyle = readC();
        this.hairColor = readC();
        this.facialHair = readC();
        /* this.outfitId = */readC();

        skipAll();
    }

    @Override
    protected void runImpl() {

        final CharCreateCode code =
                this.characterController.createCharacter(getAccountInfo().getObjectId(),
                        this.charName, this.charRace, this.charClass, this.gender, this.skin,
                        this.face, this.hairStyle, this.hairColor, this.facialHair);
        this.sender.send(getClient(), new SMSG_CHAR_CREATE(code));

    }
}
