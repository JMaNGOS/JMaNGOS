package org.jmangos.realm.network.netty.packetClient.client;

import org.jmangos.commons.network.netty.sender.AbstractPacketSender;
import org.jmangos.realm.network.netty.packetClient.AbstractWoWClientPacket;
import org.jmangos.realm.network.netty.packetClient.server.SMSG_CHAR_CREATE;

import javax.inject.Inject;
import javax.inject.Named;
import java.nio.BufferUnderflowException;

/**
 * Created with IntelliJ IDEA.
 * User: Goofy
 * Date: 2012.08.07.
 * Time: 23:26
 * To change this template use File | Settings | File Templates.
 */
public class CMSG_CHAR_CREATE extends AbstractWoWClientPacket {
    @Inject
    @Named("client")
    private AbstractPacketSender sender;

    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {
        String charName = readS();
        Integer charRace = readC();
        Integer charClass = readC();

        Integer gender, skin, face, hairStyle, hairColor, facialHair, outfitId;
        gender = readC();
        skin = readC();
        face = readC();
        hairStyle = readC();
        hairColor = readC();
        facialHair = readC();
        outfitId = readC();

        System.out.println(String.format("PlayerCreate: [%s] Race: %d, Class: %d", charName, charRace, charClass));
        skipAll();

        // Send SUCCESS
        sender.send( getClient(), new SMSG_CHAR_CREATE() );
    }

    @Override
    protected void runImpl() {
    }
}
