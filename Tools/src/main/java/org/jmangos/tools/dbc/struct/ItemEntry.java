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

public class ItemEntry extends DBCStruct<ItemEntry> {

    @XmlAttribute(name = "id", required = true)
    public final Unsigned32 ID = new Unsigned32();
    @XmlAttribute(name = "Class", required = true)
    public final Unsigned32 Class = new Unsigned32();
    @XmlAttribute(name = "SubClass", required = true)
    public final Unsigned32 SubClass = new Unsigned32();
    @XmlAttribute(name = "Unk0", required = true)
    public final Signed32 Unk0 = new Signed32();
    @XmlAttribute(name = "Material", required = true)
    public final Signed32 Material = new Signed32();
    @XmlAttribute(name = "DisplayId", required = true)
    public final Unsigned32 DisplayId = new Unsigned32();
    @XmlAttribute(name = "InventoryType", required = true)
    public final Unsigned32 InventoryType = new Unsigned32();
    @XmlAttribute(name = "Sheath", required = true)
    public final Unsigned32 Sheath = new Unsigned32();
}
