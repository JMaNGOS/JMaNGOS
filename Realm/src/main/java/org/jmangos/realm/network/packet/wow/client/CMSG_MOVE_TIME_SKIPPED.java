package org.jmangos.realm.network.packet.wow.client;

import java.nio.BufferUnderflowException;

import javax.inject.Inject;
import javax.inject.Named;

import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.jmangos.realm.network.packet.wow.AbstractWoWClientPacket;
import org.jmangos.realm.network.packet.wow.server.MSG_MOVE_TIME_SKIPPED;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA. User: Goofy Date: 2012.08.08. Time: 4:16 To change this template use
 * File | Settings | File Templates.
 */
@Component
public class CMSG_MOVE_TIME_SKIPPED extends AbstractWoWClientPacket {
    
    private static Logger        log = LoggerFactory.getLogger(CMSG_MOVE_TIME_SKIPPED.class);
    
    private long                 guid;
    private int                  time_dif;
    
    /** The sender. */
    @Inject
    @Named("nettyPacketSender")
    private AbstractPacketSender sender;
    
    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {
    
        log.warn("CMSG_MOVE_TIME_SKIPPED packet size: " + getAvaliableBytes());
        log.warn("CMSG_MOVE_TIME_SKIPPED wow guid: " + getPlayer().getCharacterData().getGuid());
        
        try {
            this.guid = readQ();
            this.time_dif = readD();
        } catch (final Exception e) {
            log.error("CMSG_MOVE_TIME_SKIPPED - Wrong Packet length");
        }
    }
    
    @Override
    protected void runImpl() {
    
        this.sender.send(getPlayer().getChannel(), new MSG_MOVE_TIME_SKIPPED(this.guid, this.time_dif));
    }
}
