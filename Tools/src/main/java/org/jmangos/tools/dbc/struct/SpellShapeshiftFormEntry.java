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


public class SpellShapeshiftFormEntry extends DBCStruct<SpellShapeshiftFormEntry> {
	@XmlAttribute(name="ID", required=true)
    public final Unsigned32 ID= new Unsigned32(); 
	@XmlAttribute(name="buttonPosition")
    public final Unsigned32 buttonPosition = new Unsigned32();  
	@XmlAttribute(name="Name")
    public final MultiInternalString Name = new MultiInternalString();
	@XmlAttribute(name="flags1", required=true)
    public final Unsigned32 flags1 = new Unsigned32();  
	@XmlAttribute(name="creatureType", required=true)
    public final Signed32 creatureType = new Signed32();  
	@XmlAttribute(name="unk1")
    public final Unsigned32 unk1 = new Unsigned32();  
	@XmlAttribute(name="attackSpeed", required=true)
    public final Unsigned32 attackSpeed = new Unsigned32();  
	@XmlAttribute(name="modelID_A", required=true)
    public final Unsigned32 modelID_A = new Unsigned32();  
	@XmlAttribute(name="modelID_H", required=true)
    public final Unsigned32 modelID_H = new Unsigned32();  
	@XmlAttribute(name="unk")
    public final Unsigned32[] unk = array(new Unsigned32[2]);  
	@XmlAttribute(name="spellId", required=true)
    public final Unsigned32[] spellId = array(new Unsigned32[8]);  
}
