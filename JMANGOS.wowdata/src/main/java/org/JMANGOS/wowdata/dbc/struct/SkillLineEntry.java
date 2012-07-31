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

public class SkillLineEntry extends DBCStruct<SkillLineEntry> {
	@XmlAttribute(name = "id", required=true)
	public final Unsigned32 Id = new Unsigned32();         	    
	@XmlAttribute(name = "categoryId", required=true)
	public final Signed32 categoryId = new Signed32();         	    
	@XmlAttribute(name = "skillCostID")
	public final Unsigned32 skillCostID = new Unsigned32();         	    
	@XmlAttribute(name = "name", required=true)
	public final MultiInternalString name = new MultiInternalString();
	@XmlAttribute(name = "description")
	public final MultiInternalString description = new MultiInternalString();
	@XmlAttribute(name = "spellIcon", required=true)
	public final Unsigned32 spellIcon = new Unsigned32();         	    
	@XmlAttribute(name = "alternateVerb")
	public final MultiInternalString alternateVerb = new MultiInternalString();
	@XmlAttribute(name = "canLink", required=true)
	public final Unsigned32 canLink = new Unsigned32();         	    
}
