package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class QuestFactionRewardEntry  extends DBCStruct<QuestFactionRewardEntry> {
	@XmlAttribute(name="id", required=true)
	public final Unsigned32 ID = new Unsigned32();
	@XmlAttribute(name="rewardValue", required=true)
	public final Signed32[] rewardValue = array(new Signed32[10]);
}
