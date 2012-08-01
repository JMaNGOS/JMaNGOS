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
package org.JMANGOS.wowdata.adt.chunks;

public enum ChunkedTypes {
	MVER("REVM"),
	MHDR("RDHM"),
	MCIN("NICM"),
	MTEX("XETM"),
	MMDX("XDMM"),
	MMID("DIMM"),
	MWMO("OMWM"),
	MWID("DIWM"),
	MDDF("FDDM"),
	MODF("FDOM"),
	MH2O("O2HM"),
	MCNK("KNCM"),
	;
	
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
