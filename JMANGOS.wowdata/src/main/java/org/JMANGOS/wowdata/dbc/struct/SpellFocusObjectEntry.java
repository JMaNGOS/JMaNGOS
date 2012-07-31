package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;


public class SpellFocusObjectEntry extends DBCStruct<SpellFocusObjectEntry> {
	@XmlAttribute(name="ID", required=true)
    public final Unsigned32 ID= new Unsigned32(); 
	@XmlAttribute(name="Name")
    public final MultiInternalString Name = new MultiInternalString();  
}
