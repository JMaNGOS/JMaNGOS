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

public class AchievementEntry extends DBCStruct<AchievementEntry> {
    
    @XmlAttribute(name = "id", required = true)
    public final Unsigned32          Id                = new Unsigned32();
    @XmlAttribute(name = "factionFlag", required = true)
    public final Signed32            factionFlag       = new Signed32();
    @XmlAttribute(name = "mapID", required = true)
    public final Signed32            mapID             = new Signed32();
    @XmlAttribute(name = "parentAchievement")
    public final Unsigned32          parentAchievement = new Unsigned32();
    @XmlAttribute(name = "name", required = true)
    public final MultiInternalString name              = new MultiInternalString();
    @XmlAttribute(name = "description")
    public final MultiInternalString description       = new MultiInternalString();
    @XmlAttribute(name = "categoryId", required = true)
    public final Unsigned32          categoryId        = new Unsigned32();
    @XmlAttribute(name = "points", required = true)
    public final Unsigned32          points            = new Unsigned32();
    @XmlAttribute(name = "OrderInCategory")
    public final Unsigned32          OrderInCategory   = new Unsigned32();
    @XmlAttribute(name = "flags", required = true)
    public final Unsigned32          flags             = new Unsigned32();
    @XmlAttribute(name = "icon")
    public final Unsigned32          icon              = new Unsigned32();
    @XmlAttribute(name = "titleReward")
    public final MultiInternalString titleReward       = new MultiInternalString();
    @XmlAttribute(name = "count", required = true)
    public final Unsigned32          count             = new Unsigned32();
    @XmlAttribute(name = "refAchievement", required = true)
    public final Unsigned32          refAchievement    = new Unsigned32();
}
