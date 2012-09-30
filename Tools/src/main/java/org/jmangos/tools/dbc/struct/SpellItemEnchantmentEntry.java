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

public class SpellItemEnchantmentEntry extends DBCStruct<SpellItemEnchantmentEntry> {

    @XmlAttribute(name = "id", required = true)
    public final Unsigned32 Id = new Unsigned32();
    @XmlAttribute(name = "charges")
    public final Unsigned32 charges = new Unsigned32();
    @XmlAttribute(name = "type", required = true)
    public final Unsigned32[] type = array(new Unsigned32[3]);
    @XmlAttribute(name = "amount", required = true)
    public final Signed32[] amount = array(new Signed32[3]);
    @XmlAttribute(name = "amount2")
    public final Signed32[] amount2 = array(new Signed32[3]);
    @XmlAttribute(name = "spellid", required = true)
    public final Unsigned32[] spellid = array(new Unsigned32[3]);

    @XmlAttribute(name = "description", required = true)
    public final MultiInternalString description = new MultiInternalString();

    @XmlAttribute(name = "auraId", required = true)
    public final Unsigned32 auraId = new Unsigned32();
    @XmlAttribute(name = "slot", required = true)
    public final Unsigned32 slot = new Unsigned32();
    @XmlAttribute(name = "GemID", required = true)
    public final Unsigned32 GemID = new Unsigned32();
    @XmlAttribute(name = "EnchantmentCondition", required = true)
    public final Unsigned32 EnchantmentCondition = new Unsigned32();
    @XmlAttribute(name = "requiredSkill")
    public final Unsigned32 requiredSkill = new Unsigned32();
    @XmlAttribute(name = "requiredSkillValue")
    public final Unsigned32 requiredSkillValue = new Unsigned32();
    @XmlAttribute(name = "unk")
    public final Unsigned32 unk = new Unsigned32();

}
