/*******************************************************************************
 * Copyright (C) 2012 JMaNGOS <http://jmangos.org/>
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
 *******************************************************************************/
package org.jmangos.tools.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.jmangos.tools.dbc.dataholder.DBCStruct;

public class BattlemasterListEntry extends DBCStruct<BattlemasterListEntry> {
    
    @XmlAttribute(name = "id", required = true)
    public final Unsigned32          id                  = new Unsigned32();
    @XmlAttribute(name = "mapId", required = true)
    public final Signed32[]          mapid               = array(new Signed32[8]);
    @XmlAttribute(name = "type", required = true)
    public final Unsigned32          type                = new Unsigned32();
    @XmlAttribute(name = "canJoinAsGroup")
    public final Unsigned32          canJoinAsGroup      = new Unsigned32();
    @XmlAttribute(name = "name", required = true)
    public final MultiInternalString name                = new MultiInternalString();
    @XmlAttribute(name = "maxGroupSize", required = true)
    public final Unsigned32          maxGroupSize        = new Unsigned32();
    @XmlAttribute(name = "HolidayWorldStateId")
    public final Unsigned32          HolidayWorldStateId = new Unsigned32();
    @XmlAttribute(name = "minLevel", required = true)
    public final Unsigned32          minLevel            = new Unsigned32();
    @XmlAttribute(name = "maxLevel", required = true)
    public final Unsigned32          maxLevel            = new Unsigned32();
}
