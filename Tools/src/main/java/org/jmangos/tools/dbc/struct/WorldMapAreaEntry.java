/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package org.jmangos.tools.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.jmangos.tools.dbc.dataholder.DBCStruct;

public class WorldMapAreaEntry extends DBCStruct<WorldMapAreaEntry> {

    @XmlAttribute(name = "id")
    public final Signed32 ID = new Signed32();
    @XmlAttribute(name = "mapId", required = true)
    public final Signed32 map_id = new Signed32();
    @XmlAttribute(name = "areaId", required = true)
    public final Signed32 area_id = new Signed32();
    @XmlAttribute(name = "name")
    public final InternalString internalname = new InternalString();
    @XmlAttribute(name = "y1", required = true)
    public final Float32 y1 = new Float32();
    @XmlAttribute(name = "y2", required = true)
    public final Float32 y2 = new Float32();
    @XmlAttribute(name = "x1", required = true)
    public final Float32 x1 = new Float32();
    @XmlAttribute(name = "x2", required = true)
    public final Float32 x2 = new Float32();
    @XmlAttribute(name = "virtualMapId", required = true)
    public final Signed32 virtualMapId = new Signed32();
    public final Signed32 dungeonMap_id = new Signed32();
    public final Signed32 someMapID = new Signed32();
}
