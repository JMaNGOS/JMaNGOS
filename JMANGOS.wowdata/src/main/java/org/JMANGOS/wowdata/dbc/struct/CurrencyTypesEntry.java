package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;


public class CurrencyTypesEntry extends DBCStruct<CurrencyTypesEntry> {
	@XmlAttribute(name="ID")
    public final Unsigned32 ID= new Unsigned32(); 
	@XmlAttribute(name="ItemId", required=true)
    public final Unsigned32 ItemId = new Unsigned32();  
	@XmlAttribute(name="Category")
    public final Unsigned32 Category = new Unsigned32();  
	@XmlAttribute(name="BitIndex", required=true)
    public final Unsigned32 BitIndex = new Unsigned32();  
}
