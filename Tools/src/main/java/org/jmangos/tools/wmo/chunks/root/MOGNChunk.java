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
package org.jmangos.tools.wmo.chunks.root;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;

import org.jmangos.tools.chunk.BaseChunk;
import org.jmangos.tools.chunk.Readable;
import org.jmangos.tools.wmo.chunks.WMOChunk;

/**
 * Chunk <tt>MOGI</tt><br>
 * List of group names for the groups in this map object.
 * 
 * @author MinimaJack
 * 
 */
public class MOGNChunk extends WMOChunk implements Readable {
	ArrayList<String> groupNames = new ArrayList<String>();

	@Override
	public BaseChunk reads(ByteBuffer bb, int offset, int size) {
		byte[] tsring = new byte[2024];
		CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
		setGlobalOffset(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		int reading = 0;
		int si = 0;
		while ((size - reading) > 0) {
			int i = 0;
			for (; (tsring[i] = getByteBuffer().get(
					(int) (offset + HEADERSIZE + i + si))) != 0; i++) {
				reading++;
			}
			if (i > 0)
				try {
					groupNames.add(decoder
							.decode(ByteBuffer.wrap(tsring, 0, i)).toString());
				} catch (CharacterCodingException e) {
					e.printStackTrace();
				}
			si = ++reading;
		}
		return this;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[MOGNChunk] groupNames size is:").append(groupNames.size());
		for (int i = 0; i < groupNames.size(); i++) {
			sb.append("\n\t").append(groupNames.get(i));
		}
		return sb.toString();

	}

}
