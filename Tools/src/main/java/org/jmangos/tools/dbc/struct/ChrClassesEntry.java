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

public class ChrClassesEntry extends DBCStruct<ChrClassesEntry> {

    @XmlAttribute(name = "ClassID", required = true)
    public final Unsigned32 ClassID = new Unsigned32();
    public final Unsigned32 flags = new Unsigned32();
    @XmlAttribute(name = "powerType", required = true)
    public final Unsigned32 powerType = new Unsigned32();
    @XmlAttribute(name = "type")
    public final InternalString type = new InternalString();
    @XmlAttribute(name = "name")
    public final MultiInternalString name = new MultiInternalString();
    @XmlAttribute(name = "nameFemale")
    public final MultiInternalString nameFemale = new MultiInternalString();
    @XmlAttribute(name = "nameNeutralGender")
    public final MultiInternalString nameNeutralGender = new MultiInternalString();
    @XmlAttribute(name = "capName")
    public final InternalString capName = new InternalString();
    @XmlAttribute(name = "spellfamily", required = true)
    public final Unsigned32 spellfamily = new Unsigned32();
    @XmlAttribute(name = "flags2")
    public final Unsigned32 flags2 = new Unsigned32();
    @XmlAttribute(name = "CinematicSequence", required = true)
    public final Unsigned32 CinematicSequence = new Unsigned32();
    @XmlAttribute(name = "expansion", required = true)
    public final Unsigned32 expansion = new Unsigned32();
}
