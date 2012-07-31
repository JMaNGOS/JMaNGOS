package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class SpellRadiusEntry  extends DBCStruct<SpellRadiusEntry> {
	@XmlAttribute(name = "id", required=true)
	public final Unsigned32 ID = new Unsigned32();
	@XmlAttribute(name="minRadius", required=true)
	public final Float32 minRadius = new Float32();	
	@XmlAttribute(name="RadiusPerLevel")
	public final Float32 RadiusPerLevel = new Float32();	
	@XmlAttribute(name="maxRadius", required=true)
	public final Float32 maxRadius = new Float32();	
}