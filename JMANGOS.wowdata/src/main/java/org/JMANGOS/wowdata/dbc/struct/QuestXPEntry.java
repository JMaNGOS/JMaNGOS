package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class QuestXPEntry  extends DBCStruct<QuestXPEntry> {
	@XmlAttribute(name="questLevel", required=true)
	public final Unsigned32 questLevel = new Unsigned32();
	@XmlAttribute(name="xpIndex", required=true)
	public final Unsigned32[] xpIndex = array(new Unsigned32[10]);
}
