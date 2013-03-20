/**
 * 
 */
package org.jmangos.commons.dataholder;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jmangos.commons.entities.CharacterData;

/**
 * @author MinimaJack
 * 
 */
public interface Streamable {

    public ChannelBuffer writeValuesUpdate();

    public int buildCreateBlock(final ChannelBuffer updateBlocks, CharacterData characterData);

}
