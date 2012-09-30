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

public class ItemSetEntry extends DBCStruct<ItemSetEntry> {

    @XmlAttribute(name = "id")
    public final Unsigned32 Id = new Unsigned32();
    @XmlAttribute(name = "internalname", required = true)
    public final MultiInternalString internalname = new MultiInternalString();
    @XmlAttribute(name = "itemId")
    public final Unsigned32[] itemId = array(new Unsigned32[17]);
    @XmlAttribute(name = "spells", required = true)
    public final Unsigned32[] spells = array(new Unsigned32[8]);
    @XmlAttribute(name = "itemsToTriggerspell", required = true)
    public final Unsigned32[] itemsToTriggerspell = array(new Unsigned32[8]);
    @XmlAttribute(name = "requiredSkillId", required = true)
    public final Unsigned32 requiredSkillId = new Unsigned32();
    @XmlAttribute(name = "requiredSkillValue", required = true)
    public final Unsigned32 requiredSkillValue = new Unsigned32();
}
