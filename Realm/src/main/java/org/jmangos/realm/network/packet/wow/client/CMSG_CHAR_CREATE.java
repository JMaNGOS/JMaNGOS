package org.jmangos.realm.network.packet.wow.client;

import java.nio.BufferUnderflowException;

import javax.inject.Inject;
import javax.inject.Named;

import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.jmangos.realm.controller.CharacterController;
import org.jmangos.realm.model.enums.Classes;
import org.jmangos.realm.model.enums.Gender;
import org.jmangos.realm.model.enums.Races;
import org.jmangos.realm.network.packet.wow.AbstractWoWClientPacket;
import org.jmangos.realm.network.packet.wow.server.SMSG_CHAR_CREATE;
import org.jmangos.realm.network.packet.wow.server.SMSG_CHAR_CREATE.Code;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA. User: Goofy Date: 2012.08.07. Time: 23:26 To
 * change this template use
 * File | Settings | File Templates.
 */
@Component
public class CMSG_CHAR_CREATE extends AbstractWoWClientPacket {

    Logger log = LoggerFactory.getLogger(getClass());

    @Inject
    @Named("nettyPacketSender")
    private AbstractPacketSender sender;
    @Inject
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

        final Code code =
                this.characterController.createCharacter(getAccountInfo().getObjectId(),
                        this.charName, this.charRace, this.charClass, this.gender, this.skin,
                        this.face, this.hairStyle, this.hairColor, this.facialHair);
        this.sender.send(getClient(), new SMSG_CHAR_CREATE(code));

    }
}
