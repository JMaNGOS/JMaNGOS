/*******************************************************************************
 * Copyright (c) 2012 JMANGOS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     JMANGOS - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.wowdata.wmo.chunks;

public enum ChunkedTypes {
	MVER("REVM"),
	MOHD("DHOM"),
	MOTX("XTOM"),
	MOMT("TMOM"),
	MOGN("NGOM"),
	MOGI("IGOM"),
	MOSB("BSOM"),
	MOPV("VPOM"),
	MOPT("TPOM"),
	MOPR("RPOM"),
	MOVV("VVOM"),
	MOVB("BVOM"),
	MOLT("TLOM"),
	MODS("SDOM"),
	MODN("NDOM"),
	MODD("DDOM"),
	MFOG("GOFM"),
	MCVP("PVCM"),
	//group
	MOGP("PGOM"),
	MOPY("YPOM"),
	MOVI("IVOM"),
	MOVT("TVOM"),
	MONR("RNOM"),
	MOTV("VTOM"),
	MOBA("ABOM"),
	
	MOLR("RLOM"),
	MODR("RDOM"),
	MOBN("NBOM"),
	MOBR("RBOM"),
	MPBV("VBPM"),
	MPBP("PBPM"),
	MPBI("IBPM"),
	MPBG("GBPM"),
	MOCV("VCOM"),
	MLIQ("QILM"),
	MORI("IROM"),
	MORB("BROM");

	private String value;
	ChunkedTypes(String val){
		this.setValue(val);
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	public static ChunkedTypes get(String value){
		for(ChunkedTypes ch: ChunkedTypes.values()){
			if (value.equals(ch.getValue())){
				return ch;
			}
		}
		return null;
		
	}
}
