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

public class AchievementEntry extends DBCStruct<AchievementEntry>{
	@XmlAttribute(name="id", required=true)
	public final Unsigned32    Id= new Unsigned32();  
	@XmlAttribute(name="factionFlag", required=true)
	public final Signed32    factionFlag= new Signed32();  
	@XmlAttribute(name="mapID", required=true)
	public final Signed32    mapID = new Signed32();  
	@XmlAttribute(name="parentAchievement")
	public final Unsigned32    parentAchievement = new Unsigned32();  
	@XmlAttribute(name = "name", required=true)
    public final MultiInternalString name   = new MultiInternalString();
	@XmlAttribute(name = "description")
    public final MultiInternalString description   = new MultiInternalString();
	@XmlAttribute(name="categoryId", required=true)
	public final Unsigned32    categoryId = new Unsigned32();  
	@XmlAttribute(name="points", required=true)
	public final Unsigned32    points = new Unsigned32();  
	@XmlAttribute(name="OrderInCategory")
	public final Unsigned32    OrderInCategory = new Unsigned32();  
	@XmlAttribute(name="flags", required=true)
	public final Unsigned32    flags = new Unsigned32();  
	@XmlAttribute(name="icon")
	public final Unsigned32    icon = new Unsigned32();
	@XmlAttribute(name = "titleReward")
    public final MultiInternalString titleReward   = new MultiInternalString();	
	@XmlAttribute(name = "count", required=true)
	public final Unsigned32    count = new Unsigned32();
	@XmlAttribute(name = "refAchievement", required=true)
	public final Unsigned32    refAchievement = new Unsigned32();
}
