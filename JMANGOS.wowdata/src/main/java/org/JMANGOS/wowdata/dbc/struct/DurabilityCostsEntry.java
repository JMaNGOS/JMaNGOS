package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;


public class DurabilityCostsEntry extends DBCStruct<DurabilityCostsEntry> {
	public static int MAX_MULTIPLIER = 29;
	@XmlAttribute(name="Itemlvl", required=true)
    public final Unsigned32 Itemlvl= new Unsigned32(); 
	@XmlAttribute(name="multiplier", required=true)
    public final Unsigned32[] multiplier = array(new Unsigned32[MAX_MULTIPLIER]);  
}
