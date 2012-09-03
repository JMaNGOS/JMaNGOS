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

public class SpellShapeshiftFormEntry extends DBCStruct<SpellShapeshiftFormEntry> {
    
    @XmlAttribute(name = "ID", required = true)
    public final Unsigned32          ID             = new Unsigned32();
    @XmlAttribute(name = "buttonPosition")
    public final Unsigned32          buttonPosition = new Unsigned32();
    @XmlAttribute(name = "Name")
    public final MultiInternalString Name           = new MultiInternalString();
    @XmlAttribute(name = "flags1", required = true)
    public final Unsigned32          flags1         = new Unsigned32();
    @XmlAttribute(name = "creatureType", required = true)
    public final Signed32            creatureType   = new Signed32();
    @XmlAttribute(name = "unk1")
    public final Unsigned32          unk1           = new Unsigned32();
    @XmlAttribute(name = "attackSpeed", required = true)
    public final Unsigned32          attackSpeed    = new Unsigned32();
    @XmlAttribute(name = "modelID_A", required = true)
    public final Unsigned32          modelID_A      = new Unsigned32();
    @XmlAttribute(name = "modelID_H", required = true)
    public final Unsigned32          modelID_H      = new Unsigned32();
    @XmlAttribute(name = "unk")
    public final Unsigned32[]        unk            = array(new Unsigned32[2]);
    @XmlAttribute(name = "spellId", required = true)
    public final Unsigned32[]        spellId        = array(new Unsigned32[8]);
}
