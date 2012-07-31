package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;


public class SpellCastTimesEntry extends DBCStruct<SpellCastTimesEntry> {
	@XmlAttribute(name="id", required=true)
    public final Unsigned32 ID= new Unsigned32(); 
	@XmlAttribute(name="CastTime", required=true)
    public final Signed32 CastTime = new Signed32();  
	@XmlAttribute(name="CastTimePerLevel")
    public final Signed32 CastTimePerLevel = new Signed32();  
	@XmlAttribute(name="MinCastTime")
    public final Signed32 MinCastTime = new Signed32();  
}
