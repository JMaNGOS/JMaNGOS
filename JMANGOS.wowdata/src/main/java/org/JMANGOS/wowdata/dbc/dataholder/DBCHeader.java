package org.JMANGOS.wowdata.dbc.dataholder;


public class DBCHeader extends DBCStruct<DBCHeader> {
	public static int DBCFmtSig = 0x43424457; 
	public final Unsigned32 FileMark = new Unsigned32();
	public final Signed32 RecordsCount = new Signed32();
	public final Signed32 FieldsCount = new Signed32();
	public final Signed32 RecordSize = new Signed32();
	public final Signed32 StringTableSize = new Signed32();
	public boolean isCorrect(){
		return FileMark.get() == DBCFmtSig;
	}
}
