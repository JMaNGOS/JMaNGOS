package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class WorldMapOverlayEntry extends DBCStruct<WorldMapOverlayEntry> {
	final static int MAX_WORLD_MAP_OVERLAY_AREA_IDX = 6;
	@XmlAttribute(name="id", required=true)
	public final Unsigned32 ID = new Unsigned32();
	@XmlAttribute(name="worldMapAreaId")
	public final Unsigned32 worldMapAreaId = new Unsigned32();
	@XmlAttribute(name="areatableID", required=true)
	public final Unsigned32[] areatableID = array(new Unsigned32[MAX_WORLD_MAP_OVERLAY_AREA_IDX]);
	@XmlAttribute(name="internalname")
	public final InternalString internalname = new InternalString();
	@XmlAttribute(name="unk")
	public final Unsigned32[] unk = array(new Unsigned32[8]);
}
