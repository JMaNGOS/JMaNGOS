package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class ItemRandomSuffixEntry  extends DBCStruct<ItemRandomSuffixEntry> {
	@XmlAttribute(name = "id", required=true)
	public final Unsigned32 ID = new Unsigned32();
	@XmlAttribute(name="nameSuffix", required=true)
	public final MultiInternalString nameSuffix = new MultiInternalString();
	@XmlAttribute(name="internalName")
	public final InternalString internalName = new InternalString();	
	@XmlAttribute(name = "enchantId", required=true)
	public final Unsigned32[] enchantId = array(new Unsigned32[5]);
	@XmlAttribute(name = "prefix", required=true)
	public final Unsigned32[] prefix = array(new Unsigned32[5]);
	
}
