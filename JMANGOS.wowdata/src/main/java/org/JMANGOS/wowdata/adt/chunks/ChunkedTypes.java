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
