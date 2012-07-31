package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class MovieEntry  extends DBCStruct<MovieEntry> {
	@XmlAttribute(name="id", required=true)
	public final Unsigned32 ID = new Unsigned32();
	@XmlAttribute(name="filename")
	public final InternalString filename = new InternalString();
	@XmlAttribute(name="unk2")
	public final Unsigned32 unk2 = new Unsigned32();
}
