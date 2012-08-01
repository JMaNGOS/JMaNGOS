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

public class WorldMapAreaEntry extends DBCStruct<WorldMapAreaEntry> {
	@XmlAttribute(name="id")
	public final Unsigned32 ID = new Unsigned32();
	@XmlAttribute(name="mapId", required=true)
	public final Unsigned32 map_id = new Unsigned32();
	@XmlAttribute(name="areaId", required=true)
	public final Unsigned32 area_id = new Unsigned32();
	@XmlAttribute(name="name")
	public final InternalString internalname = new InternalString();
	@XmlAttribute(name="y1", required=true)
	public final Float32 y1 = new Float32();
	@XmlAttribute(name="y2", required=true)
	public final Float32 y2 = new Float32();
	@XmlAttribute(name="x1", required=true)
	public final Float32 x1 = new Float32();
	@XmlAttribute(name="x2", required=true)
	public final Float32 x2 = new Float32();
	@XmlAttribute(name="virtualMapId", required=true)
	public final Signed32 virtualMapId = new Signed32();
	public final Signed32 dungeonMap_id = new Signed32();
	public final Unsigned32 someMapID = new Unsigned32();
}
