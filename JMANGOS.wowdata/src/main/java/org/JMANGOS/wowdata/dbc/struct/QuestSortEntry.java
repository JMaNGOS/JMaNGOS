package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class QuestSortEntry extends DBCStruct<QuestSortEntry> {
	@XmlAttribute(name = "id", required=true)
	public final Unsigned32 Id = new Unsigned32();  
	@XmlAttribute(name = "name")
	public final MultiInternalString name = new MultiInternalString();
}
