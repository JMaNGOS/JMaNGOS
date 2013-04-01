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

public class SkillRaceClassInfoEntry extends DBCStruct<SkillRaceClassInfoEntry> {

    @XmlAttribute(name = "id", required = true)
    public final Signed32 Id = new Signed32();
    @XmlAttribute(name = "skillLine", required = true)
    public final Signed32 skillLine = new Signed32();
    @XmlAttribute(name = "racemask")
    public final Signed32 racemask = new Signed32();
    @XmlAttribute(name = "classmask")
    public final Signed32 classmask = new Signed32();
    @XmlAttribute(name = "flags", required = true)
    public final Signed32 flags = new Signed32();
    @XmlAttribute(name = "reqlevel", required = true)
    public final Signed32 reqlevel = new Signed32();
    @XmlAttribute(name = "skillTierId", required = true)
    public final Signed32 skillTierId = new Signed32();
    @XmlAttribute(name = "skillCostId", required = true)
    public final Signed32 skillCostId = new Signed32();

}
