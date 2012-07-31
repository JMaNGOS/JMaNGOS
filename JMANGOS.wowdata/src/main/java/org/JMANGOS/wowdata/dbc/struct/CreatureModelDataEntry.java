package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class CreatureModelDataEntry extends DBCStruct<CreatureModelDataEntry> {
	@XmlAttribute(name="Id", required=true)
    public final Unsigned32 Id= new Unsigned32(); 
	@XmlAttribute(name="Flags")
    public final Unsigned32 Flags = new Unsigned32();  
	@XmlAttribute(name="ModelPath")
    public final InternalString ModelPath= new InternalString();
	@XmlAttribute(name="ModelPathAlt")
    public final Unsigned32 ModelPathAlt= new Unsigned32();
}
