package org.jmangos.realm.network.netty.packetClient.server;

import org.apache.log4j.Logger;
import org.jmangos.realm.model.UpdateType;
import org.jmangos.realm.model.base.update.UpdateFieldUtils;
import org.jmangos.realm.model.player.Player;
import org.jmangos.realm.network.netty.packetClient.AbstractWoWServerPacket;

import java.math.BigInteger;
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
    private BigInteger guid = null;
    private UpdateType updateType = UpdateType.VALUES;

    public SMSG_UPDATE_OBJECT() {};

    public SMSG_UPDATE_OBJECT( Player player, UpdateType updateType ) {
        this.player = player;
    }

    public void setGuid(BigInteger guid) {
        this.guid = guid;
    }

    @Override
    protected void writeImpl() {
        BitSet bits = player.getBitSet();

        byte[] bytes = bits.toByteArray();
        log.info( "Bytes size: " + bytes.length );

        // C or D?
        writeC( bytes.length ); // Size

        if ( guid != null )
            writeB( guid.toByteArray() );
        else
            writePackedGuid(player.getCharacterData().getGuid());

        writeB( bytes );

        for( int i = 0; i<bits.length(); i++ ) {
            if ( !bits.get(i) )
                continue;

            log.info( "Updating object: " + UpdateFieldUtils.getField(i) + " Type: " + player.getBitTypes().get( i ) );

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
                    writeQ( player.GetUInt64Value( i ) );
                    break;
                case BYTES:
                    writeC( player.GetByteValue( i ) );
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
