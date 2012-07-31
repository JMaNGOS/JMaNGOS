package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;


public class EmotesEntry extends DBCStruct<EmotesEntry> {
	@XmlAttribute(name="id", required=true)
    public final Unsigned32 id= new Unsigned32(); 
	@XmlAttribute(name="Name")
    public final InternalString Name = new InternalString();  
	@XmlAttribute(name="AnimationId")
    public final Unsigned32 AnimationId= new Unsigned32();
	@XmlAttribute(name="Flags", required=true)
    public final Unsigned32 Flags= new Unsigned32();
	@XmlAttribute(name="EmoteType", required=true)
    public final Unsigned32 EmoteType= new Unsigned32();
	@XmlAttribute(name="UnitStandState", required=true)
    public final Unsigned32 UnitStandState= new Unsigned32();
	@XmlAttribute(name="SoundId")
    public final Unsigned32 SoundId= new Unsigned32();
}
