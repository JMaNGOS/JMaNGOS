package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class WeatherEntry extends DBCStruct<WeatherEntry> {
	@XmlAttribute(name = "id", required=true)
	public final Unsigned32 Id = new Unsigned32();
	public final Unsigned32 unk1 = new Unsigned32();
	public final Unsigned32 type = new Unsigned32();
	public final Unsigned32 unk2 = new Unsigned32();
	public final Unsigned32 unk3 = new Unsigned32();
	public final Unsigned32 unk4 = new Unsigned32();
	public final Unsigned32 unk5 = new Unsigned32();
	@XmlAttribute(name = "texture", required = true)
	public final InternalString texture = new InternalString();
}
