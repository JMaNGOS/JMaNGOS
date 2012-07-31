package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class TaxiPathEntry extends DBCStruct<TaxiPathEntry> {
	@XmlAttribute(name = "id", required=true)
	public final Unsigned32 id = new Unsigned32();
	@XmlAttribute(name = "from", required=true)
	public final Signed32 from = new Signed32();
	@XmlAttribute(name = "to", required=true)
	public final Signed32 to = new Signed32();
	@XmlAttribute(name = "price", required=true)
	public final Unsigned32 price = new Unsigned32();
}