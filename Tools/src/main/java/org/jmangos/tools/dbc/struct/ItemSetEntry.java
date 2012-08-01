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

public class ItemSetEntry extends DBCStruct<ItemSetEntry> {
	@XmlAttribute(name = "id")
	public final Unsigned32 Id = new Unsigned32();         	    
	@XmlAttribute(name = "internalname", required=true)
	public final MultiInternalString internalname = new MultiInternalString();
	@XmlAttribute(name = "itemId")
	public final Unsigned32[] itemId = array(new Unsigned32[17]);      	 
	@XmlAttribute(name = "spells", required=true)
	public final Unsigned32[] spells = array(new Unsigned32[8]); 
	@XmlAttribute(name = "itemsToTriggerspell", required=true)
	public final Unsigned32[] itemsToTriggerspell = array(new Unsigned32[8]);
	@XmlAttribute(name = "requiredSkillId", required=true)
	public final Unsigned32 requiredSkillId = new Unsigned32();
	@XmlAttribute(name = "requiredSkillValue", required=true)
	public final Unsigned32 requiredSkillValue =new Unsigned32();
}
