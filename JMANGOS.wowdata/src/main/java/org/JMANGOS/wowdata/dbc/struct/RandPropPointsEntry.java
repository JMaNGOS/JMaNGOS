package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;


public class RandPropPointsEntry extends DBCStruct<RandPropPointsEntry> {
	final static int MAX_PROP = 5;
	@XmlAttribute(name="itemLevel", required=true)
    public final Unsigned32 itemLevel = new Unsigned32();  
	@XmlAttribute(name="EpicPropertiesPoints", required=true)
	   public final Unsigned32[] EpicPropertiesPoints = array(new Unsigned32[MAX_PROP]);
	@XmlAttribute(name="RarePropertiesPoints", required=true)
	   public final Unsigned32[] RarePropertiesPoints = array(new Unsigned32[MAX_PROP]);
	@XmlAttribute(name="UncommonPropertiesPoints", required=true)
	   public final Unsigned32[] UncommonPropertiesPoints = array(new Unsigned32[MAX_PROP]);
}