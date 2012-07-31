package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class TotemCategoryEntry extends DBCStruct<TotemCategoryEntry> {
	@XmlAttribute(name = "id", required=true)
	public final Unsigned32 id = new Unsigned32();
	@XmlAttribute(name = "name")
	public final MultiInternalString name = new MultiInternalString();
	@XmlAttribute(name = "categoryType", required=true)
	public final Unsigned32 categoryType = new Unsigned32();
	@XmlAttribute(name = "categoryMask", required=true)
	public final Unsigned32 categoryMask = new Unsigned32();
}