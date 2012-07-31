package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class StableSlotPricesEntry extends DBCStruct<StableSlotPricesEntry> {
	@XmlAttribute(name = "Slot", required=true)
	public final Unsigned32 Slot = new Unsigned32();
	@XmlAttribute(name = "Price", required=true)
	public final Unsigned32 Price = new Unsigned32();
}
