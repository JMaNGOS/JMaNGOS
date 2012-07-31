package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class AuctionHouseEntry extends DBCStruct<AuctionHouseEntry> {
	@XmlAttribute(name="id", required=true)
    public final Unsigned32 id= new Unsigned32(); 
	@XmlAttribute(name="faction", required=true)
    public final Unsigned32 faction= new Unsigned32(); 
	@XmlAttribute(name="depositPercent", required=true)
    public final Unsigned32 depositPercent= new Unsigned32(); 
	@XmlAttribute(name="cutPercent", required=true)
    public final Unsigned32 cutPercent= new Unsigned32(); 
	@XmlAttribute(name="name")
    public final MultiInternalString name= new MultiInternalString(); 
}
