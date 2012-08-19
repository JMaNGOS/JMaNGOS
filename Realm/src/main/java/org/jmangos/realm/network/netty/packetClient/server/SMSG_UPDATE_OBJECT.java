package org.jmangos.realm.network.netty.packetClient.server;

import java.math.BigInteger;
import java.util.BitSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;import org.jmangos.realm.model.UpdateType;
import org.jmangos.realm.model.base.update.UpdateFieldUtils;
import org.jmangos.realm.model.player.Player;
import org.jmangos.realm.network.netty.packetClient.AbstractWoWServerPacket;

/**
 * Created with IntelliJ IDEA. User: Goofy Date: 2012.08.09. Time: 0:07 To change this template use
 * File | Settings | File Templates.
 */
public class SMSG_UPDATE_OBJECT extends AbstractWoWServerPacket {
    
    /** The logger. */
    private static Logger        log        = LoggerFactory.getLogger(SMSG_UPDATE_OBJECT.class);
    
    private Player           player;
    private BigInteger       guid       = null;
    private final UpdateType updateType = UpdateType.VALUES;
    
    public SMSG_UPDATE_OBJECT(final Player player, final UpdateType updateType) {
    
        this.player = player;
    }
    
    public void setGuid(final BigInteger guid) {
    
        this.guid = guid;
    }
    
    @Override
    protected void writeImpl() {
    
        final BitSet bits = this.player.getBitSet();
        
        final byte[] bytes = bits.toByteArray();
        log.info("Bytes size: " + bytes.length);
        
        // C or D?
        writeC(bytes.length); // Size
        
        if (this.guid != null) {
            writeB(this.guid.toByteArray());
        } else {
            writePackedGuid(this.player.getCharacterData().getGuid());
        }
        
        writeB(bytes);
        
        for (int i = 0; i < bits.length(); i++) {
            if (!bits.get(i)) {
                continue;
            }
            
            log.info("Updating object: " + UpdateFieldUtils.getField(i) + " Type: " + this.player.getBitTypes().get(i));
            
            if (!this.player.getBitTypes().containsKey(i)) {
                log.error("Key not found: " + i);
            }
            
            switch (this.player.getBitTypes().get(i)) {
                case FLOAT:
                    writeF(this.player.GetFloatValue(i));
                    break;
                case INT:
                    writeD(this.player.GetUInt32Value(i));
                    break;
                case LONG:
                    writeQ(this.player.GetUInt64Value(i));
                    break;
                case BYTES:
                    writeC(this.player.GetByteValue(i));
                    break;
                default:
                    log.error("UNKNOWN SIZE!!! AAAaaaaAAAaaaa index: " + i);
                    // throw new Exception( "Fatal error at update packet!" );
            }
        }
        
        this.player.clearBits();
        this.log.info("Update complete. packets cleared.");
    }
}
