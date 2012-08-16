/**
 * 
 */
package org.jmangos.tools.chunk;

import java.nio.ByteBuffer;

/**
 * @author MinimaJack
 *
 */
public interface Readable {
	/**
	 * Must be implemented
	 * 
	 * @param bb
	 *            - byte buffer
	 * @param offset
	 *            - offset
	 * @param size
	 *            - chunk's size
	 * @return reading chunk
	 */
	BaseChunk reads(final ByteBuffer bb, final int offset, final int size);
}
