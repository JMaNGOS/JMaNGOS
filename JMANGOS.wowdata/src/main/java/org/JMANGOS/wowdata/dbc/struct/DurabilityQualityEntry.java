package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class DurabilityQualityEntry  extends DBCStruct<DurabilityQualityEntry> {
	@XmlAttribute(name="Id", required=true)
    public final Unsigned32 Id= new Unsigned32(); 
	@XmlAttribute(name="qualityMod", required=true)
    public final Float32 qualityMod = new Float32();  
}
