package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class DeclinedWordCasesEntry extends DBCStruct<DeclinedWordCasesEntry> {
	@XmlAttribute(name = "id")
	public final Unsigned32 ID = new Unsigned32();
	@XmlAttribute(name = "id2")
	public final Unsigned32 ID2 = new Unsigned32();
	@XmlAttribute(name = "id3")
	public final Unsigned32 ID3 = new Unsigned32();
	@XmlAttribute(name="name")
	public final InternalString name = new InternalString();

}
