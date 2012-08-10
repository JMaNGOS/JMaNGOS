package org.jmangos.realm.network.netty.packetClient.client;

import org.apache.log4j.Logger;
import org.jmangos.commons.network.netty.sender.AbstractPacketSender;
import org.jmangos.realm.network.netty.packetClient.AbstractWoWClientPacket;
import org.jmangos.realm.network.netty.packetClient.server.MSG_MOVE_TIME_SKIPPED;

import javax.inject.Inject;
import javax.inject.Named;
import java.nio.BufferUnderflowException;

/**
 * Created with IntelliJ IDEA.
 * User: Goofy
 * Date: 2012.08.08.
 * Time: 4:16
 * To change this template use File | Settings | File Templates.
 */
public class CMSG_MOVE_TIME_SKIPPED extends AbstractWoWClientPacket {
    Logger log = Logger.getLogger( getClass().getSimpleName() );

    private long guid;
    private int time_dif;

    @Inject
    @Named("client")
    private AbstractPacketSender sender;

    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {
        log.warn( "CMSG_MOVE_TIME_SKIPPED packet size: " + getAvaliableBytes() );
        log.warn( "CMSG_MOVE_TIME_SKIPPED wow guid: " + getPlayer().getObjectGuid().getRawValue() );

        try {
            this.guid = readQ();
            this.time_dif = readD();
        } catch (Exception e ){
            log.fatal( "CMSG_MOVE_TIME_SKIPPED - Wrong Packet length" );
        }
    }

    @Override
    protected void runImpl() {
        sender.send( getPlayer().getChannel(), new MSG_MOVE_TIME_SKIPPED( getPlayer().getObjectGuid().getRawValue(), time_dif ) );
    }
}
