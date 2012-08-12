package org.jmangos.realm.network.netty.packetClient.server;

import com.jcraft.jzlib.InflaterInputStream;
import org.apache.log4j.Logger;
import org.jmangos.realm.model.UpdateType;
import org.jmangos.realm.model.base.update.PlayerFields;
import org.jmangos.realm.model.player.Player;
import org.jmangos.realm.network.netty.packetClient.AbstractWoWServerPacket;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Goofy
 * Date: 2012.08.09.
 * Time: 0:07
 * To change this template use File | Settings | File Templates.
 */
public class SMSG_UPDATE_OBJECT extends AbstractWoWServerPacket {
    private Player player;
    private byte[] bPacket;
    private UpdateType updateType = UpdateType.VALUES;
    private PlayerFields playerFields = PlayerFields.PLAYER_XP;
    private int value = 0;

    public SMSG_UPDATE_OBJECT() {};

    public SMSG_UPDATE_OBJECT( Player player ) {
        this.player = player;
    }

    public void setPacket( byte[] packet ) {
        this.bPacket = packet;
    }

    public void setUpdateType(UpdateType updateType) {
        this.updateType = updateType;
    }

    public void setPlayerFields(PlayerFields playerFields) {
        this.playerFields = playerFields;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    protected void writeImpl() {
        // Decoding tauren
        byte[] decompressed = null;
        try {
            InflaterInputStream dis = new InflaterInputStream( new ByteArrayInputStream( bPacket ));
            decompressed = new byte[dis.available()];
            dis.read( decompressed );
            writeB( decompressed );
        } catch (IOException e) {
            Logger.getLogger( SMSG_UPDATE_OBJECT.class ).fatal("Nem sikerult kitomoriteni a csomagot", e);
            //writeC( 0x01 );
            //writePackedGuid( player.getObjectGuid().getRawValue() );
            writeB( bPacket );
            return;
        }
    }
}
