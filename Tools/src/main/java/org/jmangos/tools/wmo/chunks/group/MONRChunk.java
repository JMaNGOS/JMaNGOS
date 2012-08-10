/*******************************************************************************
 * Copyright (C) 2012 JMaNGOS <http://jmangos.org/>
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package org.jmangos.tools.wmo.chunks.group;

import java.nio.ByteBuffer;

import org.jmangos.tools.chunk.BaseChunk;
import org.jmangos.tools.chunk.Readable;
import org.jmangos.tools.wmo.chunks.WMOChunk;

/**
 * Chunk <tt>MONR</tt><br>
 * Contains normals, in (X,Z,-Y) order.
 * 
 * @author MinimaJack
 * 
 */
public class MONRChunk extends WMOChunk implements Readable {
	/** Normals */
	private Float32[] normals;
	/** count bytes in float */
	private static final byte COUNT_BYTES_FLOAT = 4;

	@Override
	public final BaseChunk reads(final ByteBuffer bb, final int offset, final int size) {
		setGlobalOffset(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		setNormals(array(new Float32[size / COUNT_BYTES_FLOAT]));
		return this;
	}

	/**
	 * @return the normals
	 */
	public final Float32[] getNormals() {
		return normals;
	}

	/**
	 * @param norm
	 *            the normals to set
	 */
	public final void setNormals(final Float32[] norm) {
		this.normals = norm;
	}

	@Override
	public final String toString() {
		return "[MONRChunk] \n\tNormals count:" + getNormals().length;
	}
}
