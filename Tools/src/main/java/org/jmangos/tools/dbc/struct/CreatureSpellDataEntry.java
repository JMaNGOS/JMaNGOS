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


public class CreatureSpellDataEntry extends DBCStruct<CreatureSpellDataEntry> {
	public static int MAX_CREATURE_SPELL_DATA_SLOT = 4;
	@XmlAttribute(name="id", required=true)
    public final Unsigned32 ID= new Unsigned32(); 
	@XmlAttribute(name="spellId", required=true)
    public final Unsigned32[] spellId = array(new Unsigned32[MAX_CREATURE_SPELL_DATA_SLOT]);  
	@XmlAttribute(name="availability")
    public final Unsigned32[] availability = array(new Unsigned32[MAX_CREATURE_SPELL_DATA_SLOT]);  
}
