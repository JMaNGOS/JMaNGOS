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

public class GameObjectDisplayInfoEntry extends DBCStruct<GameObjectDisplayInfoEntry> {
    
    @XmlAttribute(name = "Displayid", required = true)
    public final Unsigned32     Displayid = new Unsigned32();
    @XmlAttribute(name = "filename")
    public final InternalString filename  = new InternalString();
    @XmlAttribute(name = "unk")
    public final Unsigned32[]   unk       = array(new Unsigned32[10]);
    @XmlAttribute(name = "unk2")
    public final Float32[]      unk2      = array(new Float32[6]);
    @XmlAttribute(name = "unk3")
    public final Unsigned32     unk3      = new Unsigned32();
};
