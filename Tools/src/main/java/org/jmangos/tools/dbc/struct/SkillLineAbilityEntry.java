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

public class SkillLineAbilityEntry extends DBCStruct<SkillLineAbilityEntry> {

    @XmlAttribute(name = "id", required = true)
    public final Unsigned32 Id = new Unsigned32();
    @XmlAttribute(name = "skillId", required = true)
    public final Unsigned32 skillId = new Unsigned32();
    @XmlAttribute(name = "spellId", required = true)
    public final Unsigned32 spellId = new Unsigned32();
    @XmlAttribute(name = "racemask", required = true)
    public final Unsigned32 racemask = new Unsigned32();
    @XmlAttribute(name = "classmask", required = true)
    public final Unsigned32 classmask = new Unsigned32();
    @XmlAttribute(name = "racemaskNot")
    public final Unsigned32 racemaskNot = new Unsigned32();
    @XmlAttribute(name = "classmaskNot")
    public final Unsigned32 classmaskNot = new Unsigned32();
    @XmlAttribute(name = "req_skill_value", required = true)
    public final Unsigned32 req_skill_value = new Unsigned32();
    @XmlAttribute(name = "forward_spellid", required = true)
    public final Unsigned32 forward_spellid = new Unsigned32();
    @XmlAttribute(name = "learnOnGetSkill", required = true)
    public final Unsigned32 learnOnGetSkill = new Unsigned32();
    @XmlAttribute(name = "maxValue", required = true)
    public final Unsigned32 maxValue = new Unsigned32();
    @XmlAttribute(name = "minValue", required = true)
    public final Unsigned32 minValue = new Unsigned32();
    @XmlAttribute(name = "characterPoints")
    public final Unsigned32[] characterPoints = array(new Unsigned32[2]);
}
