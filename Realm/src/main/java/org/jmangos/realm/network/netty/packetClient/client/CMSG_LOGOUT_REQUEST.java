package org.jmangos.realm.network.netty.packetClient.client;

import java.nio.BufferUnderflowException;

import org.jmangos.commons.network.netty.sender.AbstractPacketSender;
import org.jmangos.realm.network.netty.packetClient.AbstractWoWClientPacket;
import org.jmangos.realm.network.netty.packetClient.server.SMSG_LOGOUT_COMPLETE;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * Created with IntelliJ IDEA. User: paalgyula email: paalgyula@gmail.com Date: 2012.08.12. Time:
 * 17:31
 */
public class CMSG_LOGOUT_REQUEST extends AbstractWoWClientPacket {
    
    @Inject
    @Named("client")
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
