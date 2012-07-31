package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class ItemLimitCategoryEntry  extends DBCStruct<ItemLimitCategoryEntry> {
	@XmlAttribute(name = "id", required=true)
	public final Unsigned32 ID = new Unsigned32();
	@XmlAttribute(name="name")
	public final MultiInternalString name = new MultiInternalString();	
	@XmlAttribute(name = "maxCount", required=true)
	public final Unsigned32 maxCount = new Unsigned32();
	@XmlAttribute(name = "mode", required=true)
	public final Unsigned32 mode = new Unsigned32();
}