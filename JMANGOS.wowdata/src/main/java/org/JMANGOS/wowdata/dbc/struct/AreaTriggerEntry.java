package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class AreaTriggerEntry extends DBCStruct<AreaTriggerEntry> {
	@XmlAttribute(name="id", required=true)
    public final Unsigned32 id= new Unsigned32(); 
	@XmlAttribute(name="mapid", required=true)
    public final Unsigned32 mapid= new Unsigned32(); 
	@XmlAttribute(name="x", required=true)
    public final Float32 x= new Float32(); 
	@XmlAttribute(name="y", required=true)
    public final Float32 y= new Float32(); 
	@XmlAttribute(name="z", required=true)
    public final Float32 z= new Float32(); 
	@XmlAttribute(name="radius", required=true)
    public final Float32 radius= new Float32(); 
	@XmlAttribute(name="box_x", required=true)
    public final Float32 box_x= new Float32(); 
	@XmlAttribute(name="box_y", required=true)
    public final Float32 box_y= new Float32(); 
	@XmlAttribute(name="box_z", required=true)
    public final Float32 box_z= new Float32(); 
	@XmlAttribute(name="box_orientation", required=true)
    public final Float32 box_orientation= new Float32(); 
}
