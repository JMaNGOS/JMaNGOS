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

public class SpellRangeEntry  extends DBCStruct<SpellRangeEntry> {
	@XmlAttribute(name = "id", required=true)
	public final Unsigned32 ID = new Unsigned32();
	@XmlAttribute(name="minRange", required=true)
	public final Float32 minRange = new Float32();	
	@XmlAttribute(name="minRangeFriendly", required=true)
	public final Float32 minRangeFriendly = new Float32();	
	@XmlAttribute(name="maxRange", required=true)
	public final Float32 maxRange = new Float32();	
	@XmlAttribute(name="maxRangeFriendly", required=true)
	public final Float32 maxRangeFriendly = new Float32();	
	@XmlAttribute(name = "unk")
	public final Unsigned32 unk = new Unsigned32();
	@XmlAttribute(name = "name")
	public final MultiInternalString name = new MultiInternalString();
	@XmlAttribute(name = "description")
	public final MultiInternalString description = new MultiInternalString();
	
	
}   
