/**
 * 
 */
package org.jmangos.realm.model;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jmangos.realm.entities.CharacterData;

/**
 * @author MinimaJack
 * 
 */
public interface Streamable {
    
    public ChannelBuffer writeValuesUpdate();
    
    public int buildCreateBlock(final ChannelBuffer updateBlocks, CharacterData characterData);
    
}
