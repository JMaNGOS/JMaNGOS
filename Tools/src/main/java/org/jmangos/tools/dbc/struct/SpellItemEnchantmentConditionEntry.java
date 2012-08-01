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
package org.jmangos.tools.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.jmangos.tools.dbc.dataholder.DBCStruct;

public class SpellItemEnchantmentConditionEntry extends DBCStruct<SpellItemEnchantmentConditionEntry> {
	final static int CONDITION_COUNT = 5;
	@XmlAttribute(name = "id", required=true)
	public final Unsigned32 Id = new Unsigned32();         	    
	@XmlAttribute(name = "Color", required=true)
	public final Unsigned8[] Color = array(new Unsigned8[CONDITION_COUNT]);         	    
	@XmlAttribute(name = "LT_Operand")
	public final Unsigned32[] LT_Operand = array(new Unsigned32[CONDITION_COUNT]);
	@XmlAttribute(name = "Comparator", required=true)
	public final Unsigned8[] Comparator = array(new Unsigned8[CONDITION_COUNT]);         	    
	@XmlAttribute(name = "CompareColor", required=true)
	public final Unsigned8[] CompareColor = array(new Unsigned8[CONDITION_COUNT]);         	    
	@XmlAttribute(name = "Value", required=true)
	public final Unsigned32[] Value = array(new Unsigned32[CONDITION_COUNT]);         	    
}
