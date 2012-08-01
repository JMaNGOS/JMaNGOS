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

public class AreaTableEntry extends DBCStruct<AreaTableEntry> {
	@XmlAttribute(name="id", required=true)
    public final Signed32 id= new Signed32(); 
	@XmlAttribute(name="ContinentId", required=true)
    public final Signed32 m_ContinentID= new Signed32(); 
	@XmlAttribute(name="ParentAreaId", required=true)
    public final Signed32 ParentAreaID= new Signed32(); 
	@XmlAttribute(name="exploreFlag", required=true)
    public final Unsigned32 AreaBit= new Unsigned32(); 
	@XmlAttribute(name="flags", required=true)
    public final Unsigned32 flags= new Unsigned32(); 
    public final Signed32 m_SoundProviderPref= new Signed32(); 
    public final Signed32 m_SoundProviderPrefUnderwater= new Signed32(); 
    public final Signed32 m_AmbienceID= new Signed32(); 
    public final Signed32 m_ZoneMusic= new Signed32(); 
    public final Signed32 m_IntroSound= new Signed32(); 
    @XmlAttribute(name="ExplorationLevel", required=true)
    public final Signed32 ExplorationLevel= new Signed32(); 
    @XmlAttribute(name="AreaName", required=true)
    public final MultiInternalString AreaName = new MultiInternalString();
    @XmlAttribute(name="team", required=true)
    public final Signed32 team= new Signed32();
    @XmlAttribute(name="liquidTypeID")
    public final Signed32[] liquidTypeID= array(new Signed32[4]);
    @XmlAttribute(name="minElevation")
    public final Float32 minElevation= new Float32();
    public final Float32 ambientMultiplier= new Float32(); 
    public final Signed32 lightid= new Signed32(); 
}

