package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;


public class GlyphSlotEntry extends DBCStruct<GlyphSlotEntry> {
	@XmlAttribute(name="Id", required=true)
    public final Unsigned32 Id= new Unsigned32(); 
	@XmlAttribute(name="TypeFlags", required=true)
    public final Unsigned32 TypeFlags= new Unsigned32(); 
	@XmlAttribute(name="Order", required=true)
    public final Unsigned32 Order= new Unsigned32(); 
}