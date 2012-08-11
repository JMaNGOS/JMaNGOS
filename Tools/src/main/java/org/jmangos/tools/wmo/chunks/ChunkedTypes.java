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
package org.jmangos.tools.wmo.chunks;

/**
 * All available chunks for reading. Contains string representations in file.
 * 
 * @author MinimaJack
 * 
 */
public enum ChunkedTypes {
	/** MVERChunk */
	MVER("REVM"),
	/** MOHDChunk */
	MOHD("DHOM"),
	/** MOTXChunk */
	MOTX("XTOM"),
	/** MOMTChunk */
	MOMT("TMOM"),
	/** MOGNChunk */
	MOGN("NGOM"),
	/** MOGIChunk */
	MOGI("IGOM"),
	/** MOSBChunk */
	MOSB("BSOM"),
	/** MOPVChunk */
	MOPV("VPOM"),
	/** MOPTChunk */
	MOPT("TPOM"),
	/** MOPRChunk */
	MOPR("RPOM"),
	/** MOVVChunk */
	MOVV("VVOM"),
	/** MOVBChunk */
	MOVB("BVOM"),
	/** MOLTChunk */
	MOLT("TLOM"),
	/** MODSChunk */
	MODS("SDOM"),
	/** MODNChunk */
	MODN("NDOM"),
	/** MODDChunk */
	MODD("DDOM"),
	/** MFOGChunk */
	MFOG("GOFM"),
	/** MCVPChunk */
	MCVP("PVCM"),
	// group
	/** MOGPChunk */
	MOGP("PGOM"),
	/** MOPYChunk */
	MOPY("YPOM"),
	/** MOVIChunk */
	MOVI("IVOM"),
	/** MOVTChunk */
	MOVT("TVOM"),
	/** MONRChunk */
	MONR("RNOM"),
	/** MCVPChunk */
	MOTV("VTOM"),
	/** MOBAChunk */
	MOBA("ABOM"),
	/** MOLRChunk */
	MOLR("RLOM"),
	/** MODRChunk */
	MODR("RDOM"),
	/** MOBNChunk */
	MOBN("NBOM"),
	/** MOBRChunk */
	MOBR("RBOM"),
	/** MPBVChunk */
	MPBV("VBPM"),
	/** MPBPChunk */
	MPBP("PBPM"),
	/** MPBIChunk */
	MPBI("IBPM"),
	/** MPBGChunk */
	MPBG("GBPM"),
	/** MOCVChunk */
	MOCV("VCOM"),
	/** MLIQChunk */
	MLIQ("QILM"),
	/** MORIChunk */
	MORI("IROM"),
	/** MORBChunk */
	MORB("BROM");

	/** String values of chunk. */
	private String value;

	/**
	 * 
	 * @param val
	 *            - values of chunk
	 */
	ChunkedTypes(final String val) {
		value = val;
	}

	/**
	 * 
	 * @return - string value in file
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 
	 * @param value
	 *            - value from file
	 * @return type of chunk if value exist in ChunkedTypes
	 */
	public static ChunkedTypes get(final String value) {
		for (ChunkedTypes ch : ChunkedTypes.values()) {
			if (value.equals(ch.getValue())) {
				return ch;
			}
		}
		return null;
	}
}
