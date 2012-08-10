package org.jmangos.realm.network.netty.packetClient.server;

import org.jmangos.realm.network.netty.packetClient.AbstractWoWServerPacket;

/**
 * Created with IntelliJ IDEA.
 * User: Goofy
 * Date: 2012.08.07.
 * Time: 23:43
 * To change this template use File | Settings | File Templates.
 */
public class SMSG_CHAR_CREATE extends AbstractWoWServerPacket {
    @Override
    protected void writeImpl() {
        writeC( 0x2F ); // Success
    }
}
