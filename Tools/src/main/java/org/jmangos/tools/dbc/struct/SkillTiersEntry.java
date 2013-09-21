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

public class SkillTiersEntry extends DBCStruct<SkillTiersEntry> {

    @XmlAttribute(name = "id", required = true)
    public final Signed32 Id = new Signed32();
    @XmlAttribute(name = "cost", required = true)
    public final Signed32[] cost = array(new Signed32[16]);
    @XmlAttribute(name = "maxValue", required = true)
    public final Signed32[] maxValue = array(new Signed32[16]);
}
