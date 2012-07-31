package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;
public class AreaGroupEntry extends DBCStruct<AreaGroupEntry> {
	@XmlAttribute(name="AreaGroupId", required=true)
    public final Unsigned32 AreaGroupId= new Unsigned32(); 
	@XmlAttribute(name="AreaId", required=true)
    public final Unsigned32[] AreaId= array(new Unsigned32[6]); 
	@XmlAttribute(name="prevGroup", required=true)
    public final Unsigned32 prevGroup= new Unsigned32(); 
}
