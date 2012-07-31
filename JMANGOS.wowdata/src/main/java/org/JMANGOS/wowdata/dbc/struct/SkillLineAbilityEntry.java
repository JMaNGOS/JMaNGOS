/*******************************************************************************
 * Copyright (c) 2012 JMANGOS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     JMANGOS - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class SkillLineAbilityEntry extends DBCStruct<SkillLineAbilityEntry> {
	@XmlAttribute(name="id", required=true)
	public final Unsigned32    Id= new Unsigned32();
	@XmlAttribute(name="skillId", required=true)
	public final Unsigned32    skillId= new Unsigned32();
	@XmlAttribute(name="spellId", required=true)
	public final Unsigned32    spellId= new Unsigned32();
	@XmlAttribute(name="racemask", required=true)
	public final Unsigned32    racemask= new Unsigned32();
	@XmlAttribute(name="classmask", required=true)
	public final Unsigned32    classmask= new Unsigned32();
	@XmlAttribute(name="racemaskNot")
	public final Unsigned32    racemaskNot= new Unsigned32();
	@XmlAttribute(name="classmaskNot")
	public final Unsigned32    classmaskNot= new Unsigned32();
	@XmlAttribute(name="req_skill_value", required=true)
	public final Unsigned32    req_skill_value= new Unsigned32();
	@XmlAttribute(name="forward_spellid", required=true)
	public final Unsigned32    forward_spellid= new Unsigned32();
	@XmlAttribute(name="learnOnGetSkill", required=true)
	public final Unsigned32    learnOnGetSkill= new Unsigned32();
	@XmlAttribute(name="maxValue", required=true)
	public final Unsigned32    maxValue= new Unsigned32();
	@XmlAttribute(name="minValue", required=true)
	public final Unsigned32    minValue= new Unsigned32();
	@XmlAttribute(name="characterPoints")
	public final Unsigned32[]    characterPoints= array(new Unsigned32[2]);
}
