package org.jmangos.realm.network.packet.wow.client;

import java.nio.BufferUnderflowException;

import javax.inject.Inject;
import javax.inject.Named;

import org.jmangos.commons.database.DatabaseFactory;
import org.jmangos.commons.network.model.SendablePacket;
import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.jmangos.realm.controller.CharacterController;
import org.jmangos.realm.network.packet.wow.AbstractWoWClientPacket;
import org.jmangos.realm.service.DBCStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA. User: Goofy Date: 2012.08.07. Time: 23:26 To change this template use
 * File | Settings | File Templates.
 */
@Component
public class CMSG_CHAR_CREATE extends AbstractWoWClientPacket {
    
    Logger                       log = LoggerFactory.getLogger(getClass());
    
    @Inject
    private DatabaseFactory      databaseFactory;
    
    @Inject
    @Named("nettyPacketSender")
    private AbstractPacketSender sender;
    @Inject
    private CharacterController  characterController;
    
    @Inject
    private DBCStorage           dbcStorage;
    
    String                       charName;
    Integer                      charRace;
    Integer                      charClass;
    Integer                      gender, skin, face, hairStyle, hairColor, facialHair, outfitId;
    
    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {
    
        this.charName = readS();
        this.charRace = readC();
        this.charClass = readC();
        
        this.gender = readC();
        this.skin = readC();
        this.face = readC();
        this.hairStyle = readC();
        this.hairColor = readC();
        this.facialHair = readC();
        this.outfitId = readC();
        
        this.log.info(String.format("PlayerCreate: [%s] Race: %d, Class: %d", this.charName, this.charRace, this.charClass));
        skipAll();
    }
    
    @Override
    protected void runImpl() {
    
        final SendablePacket packet = this.characterController.createCharacter(getAccountInfo().getObjectId(), this.charName, this.charRace, this.charClass, this.gender, this.skin, this.face, this.hairStyle, this.hairColor, this.facialHair, this.outfitId);
        this.sender.send(getClient(), packet);
    }
}
