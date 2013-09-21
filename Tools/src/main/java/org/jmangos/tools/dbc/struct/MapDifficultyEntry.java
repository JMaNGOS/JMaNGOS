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

public class MapDifficultyEntry extends DBCStruct<MapDifficultyEntry> {

    @XmlAttribute(name = "id")
    public final Unsigned32 Id = new Unsigned32();
    @XmlAttribute(name = "MapId", required = true)
    public final Unsigned32 MapId = new Unsigned32();
    @XmlAttribute(name = "Difficulty", required = true)
    public final InternalString Difficulty = new InternalString();
    @XmlAttribute(name = "areaTriggerText")
    public final MultiInternalString areaTriggerText = new MultiInternalString();
    @XmlAttribute(name = "resetTime", required = true)
    public final Unsigned32 resetTime = new Unsigned32();
    @XmlAttribute(name = "maxPlayers", required = true)
    public final Unsigned32 maxPlayers = new Unsigned32();
    @XmlAttribute(name = "difficultyString")
    public final InternalString difficultyString = new InternalString();
}
