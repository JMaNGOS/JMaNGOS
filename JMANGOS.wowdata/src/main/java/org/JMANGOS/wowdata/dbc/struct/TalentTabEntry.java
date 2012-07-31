package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class TalentTabEntry extends DBCStruct<TalentTabEntry> {
	@XmlAttribute(name = "TalentTabID", required=true)
	public final Unsigned32 TalentTabID = new Unsigned32();
	@XmlAttribute(name = "name")
	public final MultiInternalString name = new MultiInternalString();
	@XmlAttribute(name = "spellicon")
	public final Unsigned32 spellicon = new Unsigned32();
	@XmlAttribute(name = "unk")
	public final Signed32 unk = new Signed32();
	@XmlAttribute(name = "ClassMask", required=true)
	public final Unsigned32 ClassMask = new Unsigned32();
	@XmlAttribute(name = "petTalentMask", required=true)
	public final Unsigned32 petTalentMask = new Unsigned32();
	@XmlAttribute(name = "tabpage", required=true)
	public final Unsigned32 tabpage = new Unsigned32();
	@XmlAttribute(name = "internalName")
	public final InternalString internalName = new InternalString();
}