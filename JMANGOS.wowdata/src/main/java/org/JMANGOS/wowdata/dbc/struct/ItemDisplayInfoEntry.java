package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class ItemDisplayInfoEntry  extends DBCStruct<ItemDisplayInfoEntry> {
	@XmlAttribute(name = "id", required=true)
	public final Unsigned32 id = new Unsigned32();
	@XmlAttribute(name = "modelName")
	public final InternalString modelName = new InternalString();
	@XmlAttribute(name = "modelName_left")
	public final InternalString modelName2 = new InternalString();
	@XmlAttribute(name = "modelTexture")
	public final InternalString modelTexture = new InternalString();
	@XmlAttribute(name = "modelTexture_left")
	public final InternalString modelTexture2 = new InternalString();
	@XmlAttribute(name = "inventoryIcon")
	public final InternalString inventoryIcon = new InternalString();
}
