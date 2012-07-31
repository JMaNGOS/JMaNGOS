package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class CreatureTypeEntry  extends DBCStruct<CreatureTypeEntry> {
	@XmlAttribute(name = "id", required=true)
	public final Unsigned32 id = new Unsigned32();
	@XmlAttribute(name="name")
	public final MultiInternalString name = new MultiInternalString();
	@XmlAttribute(name="noExpirience")
	public final Unsigned32 noExpirience = new Unsigned32();
}
