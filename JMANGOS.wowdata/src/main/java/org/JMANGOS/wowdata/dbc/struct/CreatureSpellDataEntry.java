package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;


public class CreatureSpellDataEntry extends DBCStruct<CreatureSpellDataEntry> {
	public static int MAX_CREATURE_SPELL_DATA_SLOT = 4;
	@XmlAttribute(name="id", required=true)
    public final Unsigned32 ID= new Unsigned32(); 
	@XmlAttribute(name="spellId", required=true)
    public final Unsigned32[] spellId = array(new Unsigned32[MAX_CREATURE_SPELL_DATA_SLOT]);  
	@XmlAttribute(name="availability")
    public final Unsigned32[] availability = array(new Unsigned32[MAX_CREATURE_SPELL_DATA_SLOT]);  
}
