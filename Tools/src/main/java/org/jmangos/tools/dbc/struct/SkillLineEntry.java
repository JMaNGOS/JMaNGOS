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

public class SkillLineEntry extends DBCStruct<SkillLineEntry> {

    @XmlAttribute(name = "id", required = true)
    public final Signed32 Id = new Signed32();
    @XmlAttribute(name = "categoryId", required = true)
    public final Signed32 categoryId = new Signed32();
    @XmlAttribute(name = "skillCostID")
    public final Signed32 skillCostID = new Signed32();
    @XmlAttribute(name = "name", required = true)
    public final MultiInternalString name = new MultiInternalString();
    @XmlAttribute(name = "description")
    public final MultiInternalString description = new MultiInternalString();
    @XmlAttribute(name = "spellIcon", required = true)
    public final Signed32 spellIcon = new Signed32();
    @XmlAttribute(name = "alternateVerb")
    public final MultiInternalString alternateVerb = new MultiInternalString();
    @XmlAttribute(name = "canLink", required = true)
    public final Signed32 canLink = new Signed32();
}
