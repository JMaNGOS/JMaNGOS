package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class MapDifficultyEntry extends DBCStruct<MapDifficultyEntry> {
	@XmlAttribute(name = "id")
	public final Unsigned32 Id = new Unsigned32();  
	@XmlAttribute(name = "MapId", required=true)
	public final Unsigned32 MapId = new Unsigned32();  
	@XmlAttribute(name = "Difficulty", required=true)
	public final InternalString Difficulty = new InternalString();  
	@XmlAttribute(name = "areaTriggerText")
	public final MultiInternalString areaTriggerText = new MultiInternalString();
	@XmlAttribute(name = "resetTime", required=true)
	public final Unsigned32 resetTime = new Unsigned32();
	@XmlAttribute(name = "maxPlayers", required=true)
    public final Unsigned32 maxPlayers = new Unsigned32();  
	@XmlAttribute(name = "difficultyString")
    public final InternalString difficultyString = new InternalString();  
}
