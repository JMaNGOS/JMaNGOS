package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class MailTemplateEntry extends DBCStruct<MailTemplateEntry> {
	@XmlAttribute(name = "id", required=true)
	public final Unsigned32 Id = new Unsigned32();         	    
	@XmlAttribute(name = "subject")
	public final MultiInternalString subject = new MultiInternalString();
	@XmlAttribute(name = "content", required=true)
	public final MultiInternalString content = new MultiInternalString();
}

