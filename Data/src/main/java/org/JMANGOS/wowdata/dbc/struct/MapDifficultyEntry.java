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

public class MapDifficultyEntry extends DBCStruct<MapDifficultyEntry> {
	@XmlAttribute(name = "id")
	public final Unsigned32 Id = new Unsigned32();  
	@XmlAttribute(name = "MapId", required=true)
	public final Unsigned32 MapId = new Unsigned32();  
	@XmlAttribute(name = "Difficulty", required=true)
	public final InternalString Difficulty = new InternalString();  
	@XmlAttribute(name = "areaTriggerText")
	public final MultiInternalString areaTriggerText = new MultiInternalString();
	@XmlAttribute(name = "resetTime", required=true)
	public final Unsigned32 resetTime = new Unsigned32();
	@XmlAttribute(name = "maxPlayers", required=true)
    public final Unsigned32 maxPlayers = new Unsigned32();  
	@XmlAttribute(name = "difficultyString")
    public final InternalString difficultyString = new InternalString();  
}
