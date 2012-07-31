package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class SpellRangeEntry  extends DBCStruct<SpellRangeEntry> {
	@XmlAttribute(name = "id", required=true)
	public final Unsigned32 ID = new Unsigned32();
	@XmlAttribute(name="minRange", required=true)
	public final Float32 minRange = new Float32();	
	@XmlAttribute(name="minRangeFriendly", required=true)
	public final Float32 minRangeFriendly = new Float32();	
	@XmlAttribute(name="maxRange", required=true)
	public final Float32 maxRange = new Float32();	
	@XmlAttribute(name="maxRangeFriendly", required=true)
	public final Float32 maxRangeFriendly = new Float32();	
	@XmlAttribute(name = "unk")
	public final Unsigned32 unk = new Unsigned32();
	@XmlAttribute(name = "name")
	public final MultiInternalString name = new MultiInternalString();
	@XmlAttribute(name = "description")
	public final MultiInternalString description = new MultiInternalString();
	
	
}   