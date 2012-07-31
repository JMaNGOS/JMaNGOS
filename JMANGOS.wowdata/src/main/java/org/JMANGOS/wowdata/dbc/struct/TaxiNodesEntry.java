package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class TaxiNodesEntry extends DBCStruct<TaxiNodesEntry> {
	@XmlAttribute(name = "id", required=true)
	public final Unsigned32 id = new Unsigned32();
	@XmlAttribute(name = "mapId", required=true)
	public final Unsigned32 mapId = new Unsigned32();
	@XmlAttribute(name = "coord", required=true)
	public final Float32[] coord = array(new Float32[3]);
	@XmlAttribute(name = "name", required=true)
	public final MultiInternalString name = new MultiInternalString();
	@XmlAttribute(name = "MountCreatureID", required=true)
	public final Unsigned32[] MountCreatureID = array(new Unsigned32[2]);
}