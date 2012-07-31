package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;


public class ChatChannelsEntry extends DBCStruct<ChatChannelsEntry> {
	@XmlAttribute(name="id", required=true)
    public final Unsigned32 id= new Unsigned32(); 
	@XmlAttribute(name="flags", required=true)
    public final Unsigned32 flags = new Unsigned32();  
	@XmlAttribute(name="pattern", required=true)
    public final MultiInternalString pattern= new MultiInternalString();
	@XmlAttribute(name="name")
    public final MultiInternalString name= new MultiInternalString();
	public final Unsigned32 unk = new Unsigned32();  
}
