package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class BankBagSlotPricesEntry extends DBCStruct<BankBagSlotPricesEntry> {
	@XmlAttribute(name="id", required=true)
    public final Unsigned32 id= new Unsigned32(); 
	@XmlAttribute(name="price", required=true)
    public final Unsigned32 price= new Unsigned32(); 
}
