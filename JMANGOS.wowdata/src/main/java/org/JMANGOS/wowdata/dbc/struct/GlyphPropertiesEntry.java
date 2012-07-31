package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;


public class GlyphPropertiesEntry extends DBCStruct<GlyphPropertiesEntry> {
	@XmlAttribute(name="Id", required=true)
    public final Unsigned32 Id= new Unsigned32(); 
	@XmlAttribute(name="SpellId", required=true)
    public final Unsigned32 SpellId= new Unsigned32(); 
	@XmlAttribute(name="TypeFlags", required=true)
    public final Unsigned32 TypeFlags= new Unsigned32(); 
	@XmlAttribute(name="GlyphIconId", required=true)
    public final Unsigned32 GlyphIconId= new Unsigned32(); 
}