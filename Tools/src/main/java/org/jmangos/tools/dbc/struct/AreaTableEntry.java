/*******************************************************************************
 * Copyright (c) 2012 JMANGOS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     JMANGOS - initial API and implementation
 ******************************************************************************/
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

