package org.jmangos.realm.network.netty.packetClient.client;

import java.nio.BufferUnderflowException;

import javax.inject.Inject;
import javax.inject.Named;

import org.jmangos.commons.network.netty.sender.AbstractPacketSender;
import org.jmangos.realm.network.netty.packetClient.AbstractWoWClientPacket;
import org.jmangos.realm.network.netty.packetClient.server.SMSG_LOGOUT_COMPLETE;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA. User: paalgyula email: paalgyula@gmail.com Date: 2012.08.12. Time:
 * 17:31
 */
@Component
public class CMSG_LOGOUT_REQUEST extends AbstractWoWClientPacket {
    
    /** The sender. */
    @Inject
    @Named("nettyPacketSender")
    private AbstractPacketSender sender;
    
    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {
    
        skipAll();
    }
    
    @Override
    protected void runImpl() {
    
        // TODO: implement SMSG_LOGOUT_RESPONSE
        this.sender.send(getPlayer().getChannel(), new SMSG_LOGOUT_COMPLETE());
    }
}
