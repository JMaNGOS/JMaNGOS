package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;


public class SoundEntriesEntry extends DBCStruct<SoundEntriesEntry> {
	@XmlAttribute(name="id", required=true)
    public final Unsigned32 id= new Unsigned32(); 
	@XmlAttribute(name="Type")
    public final Unsigned32 Type = new Unsigned32();
	@XmlAttribute(name="name")
    public final InternalString name = new InternalString();  
	@XmlAttribute(name="FileName")
    public final InternalString[] FileName = array(new InternalString[10]); 
	@XmlAttribute(name="repeatCount")
	public final Unsigned32[] repeatCount = array(new Unsigned32[10]);  
	@XmlAttribute(name="Path")
    public final InternalString Path = new InternalString();  
	@XmlAttribute(name="volumeFloat")
	public final Float32 volumeFloat = new Float32();
	@XmlAttribute(name="flags")
	public final Unsigned32 flags = new Unsigned32();
	@XmlAttribute(name="minDistance")
	public final Float32 minDistance = new Float32();
	@XmlAttribute(name="maxDistance")
	public final Float32 maxDistance = new Float32();
	@XmlAttribute(name="EAXDef")
	public final Unsigned32 EAXDef = new Unsigned32();
	@XmlAttribute(name="unknown")
	public final Unsigned32 unknown = new Unsigned32();
}