package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;


public class CharTitlesEntry extends DBCStruct<CharTitlesEntry> {
	@XmlAttribute(name="id", required=true)
    public final Unsigned32 id= new Unsigned32(); 
	@XmlAttribute(name="unk1")
    public final Unsigned32 unk1 = new Unsigned32();  
	@XmlAttribute(name="TitleName", required=true)
    public final MultiInternalString TitleName= new MultiInternalString();
	@XmlAttribute(name="FemaleTitleName")
    public final MultiInternalString FemaleTitleName= new MultiInternalString();
	@XmlAttribute(name="bitIndex", required=true)
    public final Unsigned32 bitIndex= new Unsigned32(); 
}
