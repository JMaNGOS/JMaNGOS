package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;


public class GemPropertiesEntry extends DBCStruct<GemPropertiesEntry> {
	@XmlAttribute(name="ID", required=true)
    public final Unsigned32 ID= new Unsigned32(); 
	@XmlAttribute(name="spellitemenchantement", required=true)
    public final Unsigned32 spellitemenchantement= new Unsigned32(); 
	@XmlAttribute(name="color", required=true)
    public final Unsigned32 color= new Unsigned32(); 
	@XmlAttribute(name="unk")
    public final Unsigned32[] unk= array(new Unsigned32[2]); 
	
}
