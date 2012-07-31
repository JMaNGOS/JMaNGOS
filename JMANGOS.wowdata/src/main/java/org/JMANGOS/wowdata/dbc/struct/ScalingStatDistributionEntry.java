package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class ScalingStatDistributionEntry extends DBCStruct<ScalingStatDistributionEntry> {
	@XmlAttribute(name = "id", required=true)
	public final Unsigned32 Id = new Unsigned32();  
	@XmlAttribute(name = "StatMod", required=true)
	public final Signed32[] StatMod = array(new Signed32[10]);
	@XmlAttribute(name = "Modifier", required=true)
	public final Unsigned32[] Modifier = array(new Unsigned32[10]);
	@XmlAttribute(name = "MaxLevel", required=true)
	public final Unsigned32 MaxLevel = new Unsigned32();
}
