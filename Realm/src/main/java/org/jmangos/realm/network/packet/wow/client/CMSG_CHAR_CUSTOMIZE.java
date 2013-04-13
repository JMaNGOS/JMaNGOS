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

import org.jmangos.commons.enums.Gender;
import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.jmangos.realm.controller.CharacterController;
import org.jmangos.realm.network.packet.wow.AbstractWoWClientPacket;
import org.jmangos.realm.network.packet.wow.server.SMSG_CHAR_CUSTOMIZE;
import org.jmangos.realm.network.packet.wow.server.SMSG_CHAR_CUSTOMIZE.Code;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
/**
 * Created with IntelliJ IDEA.
 * User: GiBSON
 * Date: 13.04.13
 * Time: 21:06
 */
@Component
public class CMSG_CHAR_CUSTOMIZE extends AbstractWoWClientPacket {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier("nettyPacketSender")
    private AbstractPacketSender sender;
    @Autowired
    private CharacterController characterController;

    Long guid;
    String charNewName;
    Gender gender;

    Integer skin, face, hairStyle, hairColor, facialHair;

    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {
        this.guid = readQ();
        this.charNewName = readS();

        this.gender = Gender.get(readC());
        this.skin = readC();
        this.hairColor = readC();
        this.hairStyle = readC();
        this.facialHair = readC();
        this.face = readC();
        log.info("Character with guid " + guid + " initialize customization");
    }

    @Override
    protected void runImpl() {

        final Code code =
                this.characterController.updateCharacter(this.guid,
                        this.charNewName, this.gender, this.skin,
                        this.face, this.hairStyle, this.hairColor, this.facialHair);
        if(code == Code.SUCCESS){
            this.sender.send(getClient(), new SMSG_CHAR_CUSTOMIZE(characterController.loadCharacterByGuid(guid)));
        }else{
            this.sender.send(getClient(), new SMSG_CHAR_CUSTOMIZE(code));
        }

    }
}
