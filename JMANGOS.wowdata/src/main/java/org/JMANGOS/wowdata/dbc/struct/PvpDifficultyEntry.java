package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;


public class PvpDifficultyEntry extends DBCStruct<PvpDifficultyEntry> {
	@XmlAttribute(name="id")
    public final Unsigned32 id= new Unsigned32(); 
	@XmlAttribute(name="mapId", required=true)
    public final Unsigned32 mapId = new Unsigned32();  
	@XmlAttribute(name="bracketId", required=true)
    public final Unsigned32 bracketId = new Unsigned32();  
	@XmlAttribute(name="minLevel", required=true)
    public final Unsigned32 minLevel = new Unsigned32();  
	@XmlAttribute(name="maxLevel", required=true)
    public final Unsigned32 maxLevel = new Unsigned32();  
	@XmlAttribute(name="difficulty", required=true)
    public final Unsigned32 difficulty = new Unsigned32();  
}