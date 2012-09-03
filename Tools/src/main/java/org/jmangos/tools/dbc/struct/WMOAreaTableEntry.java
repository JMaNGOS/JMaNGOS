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

public class WMOAreaTableEntry extends DBCStruct<WMOAreaTableEntry> {
    
    @XmlAttribute(name = "id", required = true)
    public final Unsigned32          ID                          = new Unsigned32();
    @XmlAttribute(name = "wmoId", required = true)
    public final Signed32            wmoId                       = new Signed32();
    @XmlAttribute(name = "NameSetID")
    public final Signed32            NameSetID                   = new Signed32();
    @XmlAttribute(name = "WMOGroupID", required = true)
    public final Signed32            WMOGroupID                  = new Signed32();
    @XmlAttribute(name = "SoundProviderPref")
    public final Signed32            SoundProviderPref           = new Signed32();
    @XmlAttribute(name = "SoundProviderPrefUnderwater")
    public final Signed32            SoundProviderPrefUnderwater = new Signed32();
    @XmlAttribute(name = "AmbienceID")
    public final Unsigned32          AmbienceID                  = new Unsigned32();
    @XmlAttribute(name = "ZoneMusic")
    public final Unsigned32          ZoneMusic                   = new Unsigned32();
    @XmlAttribute(name = "IntroSound")
    public final Unsigned32          IntroSound                  = new Unsigned32();
    @XmlAttribute(name = "flags", required = true)
    public final Unsigned32          flags                       = new Unsigned32();
    @XmlAttribute(name = "AreaTableID", required = true)
    public final Unsigned32          AreaTableID                 = new Unsigned32();
    @XmlAttribute(name = "name", required = true)
    public final MultiInternalString name                        = new MultiInternalString();
}
