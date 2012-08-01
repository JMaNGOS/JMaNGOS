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

public class SpellItemEnchantmentEntry extends DBCStruct<SpellItemEnchantmentEntry> {
	@XmlAttribute(name = "id", required=true)
	public final Unsigned32 Id = new Unsigned32();         	    
	@XmlAttribute(name = "charges")
	public final Unsigned32 charges = new Unsigned32();         	    
	@XmlAttribute(name = "type", required=true)
	public final Unsigned32[] type = array(new Unsigned32[3]);         	    
	@XmlAttribute(name = "amount", required=true)
	public final Signed32[] amount = array(new Signed32[3]);         	    
	@XmlAttribute(name = "amount2")
	public final Signed32[] amount2 = array(new Signed32[3]);         	    
	@XmlAttribute(name = "spellid", required=true)
	public final Unsigned32[] spellid = array(new Unsigned32[3]);         	    

	@XmlAttribute(name = "description", required=true)
	public final MultiInternalString description = new MultiInternalString();

	@XmlAttribute(name = "auraId", required=true)
	public final Unsigned32 auraId = new Unsigned32();         	    
	@XmlAttribute(name = "slot", required=true)
	public final Unsigned32 slot = new Unsigned32();         	    
	@XmlAttribute(name = "GemID", required=true)
	public final Unsigned32 GemID = new Unsigned32();         	    
	@XmlAttribute(name = "EnchantmentCondition", required=true)
	public final Unsigned32 EnchantmentCondition = new Unsigned32();         	    
	@XmlAttribute(name = "requiredSkill")
	public final Unsigned32 requiredSkill = new Unsigned32();         	    
	@XmlAttribute(name = "requiredSkillValue")
	public final Unsigned32 requiredSkillValue = new Unsigned32();    
	@XmlAttribute(name = "unk")
	public final Unsigned32 unk = new Unsigned32();    
	
}
