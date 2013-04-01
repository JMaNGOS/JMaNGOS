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

public class SkillLineAbilityEntry extends DBCStruct<SkillLineAbilityEntry> {

    @XmlAttribute(name = "id", required = true)
    public final Signed32 Id = new Signed32();
    @XmlAttribute(name = "skillId", required = true)
    public final Signed32 skillId = new Signed32();
    @XmlAttribute(name = "spellId", required = true)
    public final Signed32 spellId = new Signed32();
    @XmlAttribute(name = "racemask", required = true)
    public final Signed32 racemask = new Signed32();
    @XmlAttribute(name = "classmask", required = true)
    public final Signed32 classmask = new Signed32();
    @XmlAttribute(name = "racemaskNot")
    public final Signed32 racemaskNot = new Signed32();
    @XmlAttribute(name = "classmaskNot")
    public final Signed32 classmaskNot = new Signed32();
    @XmlAttribute(name = "req_skill_value", required = true)
    public final Signed32 req_skill_value = new Signed32();
    @XmlAttribute(name = "forward_spellid", required = true)
    public final Signed32 forward_spellid = new Signed32();
    @XmlAttribute(name = "learnOnGetSkill", required = true)
    public final Signed32 learnOnGetSkill = new Signed32();
    @XmlAttribute(name = "maxValue", required = true)
    public final Signed32 maxValue = new Signed32();
    @XmlAttribute(name = "minValue", required = true)
    public final Signed32 minValue = new Signed32();
    @XmlAttribute(name = "characterPoints")
    public final Signed32[] characterPoints = array(new Signed32[2]);
}
