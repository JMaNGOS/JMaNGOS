package org.jmangos.realm.network.packet.wow.client;

import java.nio.BufferUnderflowException;

import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.jmangos.realm.network.packet.wow.AbstractWoWClientPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 
 * @author MinimaJack
 * 
 */
@Component
public class CMSG_UPDATE_ACCOUNT_DATA extends AbstractWoWClientPacket {

    Logger log = LoggerFactory.getLogger(CMSG_UPDATE_ACCOUNT_DATA.class);
    /** The sender. */
    @Autowired
    @Qualifier("nettyPacketSender")
    private AbstractPacketSender sender;

    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {

        final int type, timestamp;
        int decompressedSize;
        readD();
        readD();
        decompressedSize = readD();
    }

    @Override
    protected void runImpl() {

    }
}
