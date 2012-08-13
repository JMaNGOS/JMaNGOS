package org.jmangos.realm.network.netty.packetClient.server;

import org.apache.log4j.Logger;
import org.jmangos.realm.model.UpdateType;
import org.jmangos.realm.model.player.Player;
import org.jmangos.realm.network.netty.packetClient.AbstractWoWServerPacket;

import java.util.BitSet;

/**
 * Created with IntelliJ IDEA.
 * User: Goofy
 * Date: 2012.08.09.
 * Time: 0:07
 * To change this template use File | Settings | File Templates.
 */
public class SMSG_UPDATE_OBJECT extends AbstractWoWServerPacket {
    Logger log = Logger.getLogger(getClass());

    private Player player;
    private UpdateType updateType = UpdateType.VALUES;

    public SMSG_UPDATE_OBJECT() {};

    public SMSG_UPDATE_OBJECT( Player player, UpdateType updateType ) {
        this.player = player;
    }

    @Override
    protected void writeImpl() {
        BitSet bits = player.getBitSet();

        byte[] bytes = new byte[bits.length()/8+1];
        for (int i=0; i<bits.length(); i++) {
            if (bits.get(i)) {
                bytes[bytes.length-i/8-1] |= 1<<(i%8);
            }
        }

        writeC( bytes.length ); // Size
        writeC( updateType );
        writePackedGuid( player.getCharacterData().getGuid() );
        writeB( bytes );

        for( int i = 0; i<bits.length(); i++ ) {
            if ( !bits.get(i) )
                continue;

            if ( !player.getBitTypes().containsKey( i ) )
                log.fatal( "Key not found: " + i );

            switch ( player.getBitTypes().get(i) ) {
                case FLOAT:
                    writeF( player.GetFloatValue( i ) );
                    break;
                case INT:
                    writeD( player.GetUInt32Value( i ) );
                    break;
                case LONG:
                    writeD( player.GetUInt64Value( i ) );
                    break;
                default:
                    log.fatal( "UNKNOWN SIZE!!! AAAaaaaAAAaaaa index: " + i );
                    //throw new Exception( "Fatal error at update packet!" );
            }
        }

        player.clearBits();
        log.info( "Update complete. packets cleared." );
    }
}
