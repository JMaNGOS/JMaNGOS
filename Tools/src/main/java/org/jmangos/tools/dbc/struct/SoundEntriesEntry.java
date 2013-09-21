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

public class SoundEntriesEntry extends DBCStruct<SoundEntriesEntry> {

    @XmlAttribute(name = "id", required = true)
    public final Unsigned32 id = new Unsigned32();
    @XmlAttribute(name = "Type")
    public final Unsigned32 Type = new Unsigned32();
    @XmlAttribute(name = "name")
    public final InternalString name = new InternalString();
    @XmlAttribute(name = "FileName")
    public final InternalString[] FileName = array(new InternalString[10]);
    @XmlAttribute(name = "repeatCount")
    public final Unsigned32[] repeatCount = array(new Unsigned32[10]);
    @XmlAttribute(name = "Path")
    public final InternalString Path = new InternalString();
    @XmlAttribute(name = "volumeFloat")
    public final Float32 volumeFloat = new Float32();
    @XmlAttribute(name = "flags")
    public final Unsigned32 flags = new Unsigned32();
    @XmlAttribute(name = "minDistance")
    public final Float32 minDistance = new Float32();
    @XmlAttribute(name = "maxDistance")
    public final Float32 maxDistance = new Float32();
    @XmlAttribute(name = "EAXDef")
    public final Unsigned32 EAXDef = new Unsigned32();
    @XmlAttribute(name = "unknown")
    public final Unsigned32 unknown = new Unsigned32();
}
