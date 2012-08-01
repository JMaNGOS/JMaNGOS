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

public class ScalingStatValuesEntry extends DBCStruct<ScalingStatValuesEntry> {
	@XmlAttribute(name = "id", required=true)
	public final Unsigned32 Id = new Unsigned32();  
	@XmlAttribute(name = "Level", required=true)
	public final Unsigned32 Level = new Unsigned32();
	@XmlAttribute(name = "ssdMultiplier", required=true)
	public final Unsigned32[] ssdMultiplier = array(new Unsigned32[4]);
	@XmlAttribute(name = "armorMod", required=true)
	public final Unsigned32[] armorMod = array(new Unsigned32[4]);
	@XmlAttribute(name = "dpsMod", required=true)
	public final Unsigned32[] dpsMod = array(new Unsigned32[6]);
	
	@XmlAttribute(name = "spellBonus", required=true)
	public final Unsigned32 spellBonus = new Unsigned32();
	@XmlAttribute(name = "ssdMultiplier2", required=true)
	public final Unsigned32 ssdMultiplier2 = new Unsigned32();
	@XmlAttribute(name = "ssdMultiplier3", required=true)
	public final Unsigned32 ssdMultiplier3 = new Unsigned32();
	@XmlAttribute(name = "unk2")
	public final Unsigned32 unk2 = new Unsigned32();
	@XmlAttribute(name = "armorMod2", required=true)
	public final Unsigned32[] armorMod2 = array(new Unsigned32[4]);
}
