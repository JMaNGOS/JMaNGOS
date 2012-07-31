package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;


public class SpellDurationEntry extends DBCStruct<SpellDurationEntry> {
	@XmlAttribute(name="id", required=true)
    public final Unsigned32 id= new Unsigned32(); 
	@XmlAttribute(name="Duration", required=true)
    public final Signed32[] Duration = array(new Signed32[3]);  
}
