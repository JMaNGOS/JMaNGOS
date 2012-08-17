package org.jmangos.realm.network.netty.packetClient.client;

import java.nio.BufferUnderflowException;

import org.jmangos.realm.network.netty.packetClient.AbstractWoWClientPacket;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA. User: Goofy Date: 2012.08.08. Time: 2:40 To change this template use
 * File | Settings | File Templates.
 */
@Component
public class CMSG_STANDSTATECHANGED extends AbstractWoWClientPacket {
    
    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {
    
        // TODO: implement
        skipAll();
    }
    
    @Override
    protected void runImpl() {
    
    }
}
