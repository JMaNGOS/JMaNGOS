package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class ItemRandomPropertiesEntry  extends DBCStruct<ItemRandomPropertiesEntry> {
	private final static int MAX_ENCHANT = 5; 
	@XmlAttribute(name = "id", required=true)
	public final Unsigned32 ID = new Unsigned32();
	@XmlAttribute(name="internalName")
	public final InternalString internalName = new InternalString();	
	@XmlAttribute(name = "enchantId", required=true)
	public final Unsigned32[] enchantId = array(new Unsigned32[MAX_ENCHANT]);
	@XmlAttribute(name="nameSuffix", required=true)
	public final MultiInternalString nameSuffix = new MultiInternalString();	
}
