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


public class BattlemasterListEntry extends DBCStruct<BattlemasterListEntry> {
	@XmlAttribute(name="id", required=true)
    public final Unsigned32 id= new Unsigned32(); 
	@XmlAttribute(name="mapId", required=true)
    public final Signed32[] mapid= array (new Signed32[8]);  
	@XmlAttribute(name="type", required=true)
    public final Unsigned32 type= new Unsigned32(); 
	@XmlAttribute(name="canJoinAsGroup")
    public final Unsigned32 canJoinAsGroup= new Unsigned32(); 
	@XmlAttribute(name="name", required=true)
    public final MultiInternalString name= new MultiInternalString(); 
	@XmlAttribute(name="maxGroupSize", required=true)
    public final Unsigned32 maxGroupSize= new Unsigned32(); 
	@XmlAttribute(name="HolidayWorldStateId")
    public final Unsigned32 HolidayWorldStateId= new Unsigned32(); 
	@XmlAttribute(name="minLevel", required=true)
    public final Unsigned32 minLevel= new Unsigned32(); 
	@XmlAttribute(name="maxLevel", required=true)
    public final Unsigned32 maxLevel= new Unsigned32(); 
}
