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
package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;


public class SpellCastTimesEntry extends DBCStruct<SpellCastTimesEntry> {
	@XmlAttribute(name="id", required=true)
    public final Unsigned32 ID= new Unsigned32(); 
	@XmlAttribute(name="CastTime", required=true)
    public final Signed32 CastTime = new Signed32();  
	@XmlAttribute(name="CastTimePerLevel")
    public final Signed32 CastTimePerLevel = new Signed32();  
	@XmlAttribute(name="MinCastTime")
    public final Signed32 MinCastTime = new Signed32();  
}
