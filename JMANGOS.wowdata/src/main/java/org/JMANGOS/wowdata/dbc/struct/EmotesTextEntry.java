package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;


public class EmotesTextEntry extends DBCStruct<EmotesTextEntry> {
	@XmlAttribute(name="id", required=true)
    public final Unsigned32 id= new Unsigned32(); 
	@XmlAttribute(name="textid", required=true)
    public final Unsigned32 textid = new Unsigned32();
	@XmlAttribute(name="unk2")
    public final Unsigned32[] unk2 = array(new Unsigned32[17]);  
}
