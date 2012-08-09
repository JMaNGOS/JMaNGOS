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
package org.jmangos.tools.adt.chunks.root;

import java.nio.ByteBuffer;

import org.jmangos.tools.adt.chunks.ADTChunk;

public class MHDRChunk extends ADTChunk {
	public enum MHDRFlags {
		mhdr_MFBO(0), mhdr_northrend(1);
		int value;

		MHDRFlags(int value) {
			this.value = value;
		}
	};

	final static int localOffset = new MHDRChunk().size();
	public final Enum32<MHDRFlags> MHDRflags = new Enum32<MHDRFlags>(
			MHDRFlags.values());
	Unsigned32 flag = new Unsigned32();
	Unsigned32 mcin = new Unsigned32();
	Unsigned32 mtex = new Unsigned32();
	Unsigned32 mmdx = new Unsigned32();
	Unsigned32 mmid = new Unsigned32();
	Unsigned32 mwmo = new Unsigned32();
	Unsigned32 mwid = new Unsigned32();
	Unsigned32 mddf = new Unsigned32();
	Unsigned32 mfbo; // this is only set if flags & mhdr_MFBO.
	Unsigned32 modf;

	Unsigned32 mh2o;
	Unsigned32 mtfx;
	Unsigned32 uint32_t;
	Unsigned32 uint32_t2;
	Unsigned32 uint32_t3;
	Unsigned32 uint32_t4;
	Unsigned32 uint32_t5;

	@Override
	public ADTChunk reads(ByteBuffer bb, int offset, int size) {
		setGlobalOffset(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		if (mfboIn()) {
			mfbo = new Unsigned32();
		}
		modf = new Unsigned32();
		mh2o = new Unsigned32();
		mtfx = new Unsigned32();
		uint32_t = new Unsigned32();
		uint32_t2 = new Unsigned32();
		uint32_t3 = new Unsigned32();
		uint32_t4 = new Unsigned32();
		uint32_t5 = new Unsigned32();
		return this;
	}

	public String toString() {
		return "[MHDRChunk]" + "\n ENUM: " + MHDRflags.get() + "\n FLAG: "
				+ flag.get() + "\n MCIN: " + mcin.get() + "\n MTEX: "
				+ mtex.get() + "\n MMDX: " + mmdx.get() + "\n MMID: "
				+ mmid.get() + "\n MWMO: " + mwmo.get() + "\n MWID: "
				+ mwid.get() + "\n MDDF: " + mddf.get() + "\n MODF: "
				+ modf.get() + (mfboIn() ? ("\n MFBO: " + mfbo.get()) : "");

	}

	private boolean mfboIn() {
		return (1 & flag.get()) > 0;
	}

}
