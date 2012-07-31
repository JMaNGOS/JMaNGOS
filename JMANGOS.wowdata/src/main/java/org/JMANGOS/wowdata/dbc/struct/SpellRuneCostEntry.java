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

public class SpellRuneCostEntry  extends DBCStruct<SpellRuneCostEntry> {
	@XmlAttribute(name = "id", required=true)
	public final Unsigned32 ID = new Unsigned32();
	@XmlAttribute(name="RuneCost", required=true)
	public final Unsigned32[] RuneCost = array(new Unsigned32[3]);	
	@XmlAttribute(name = "runePowerGain", required=true)
	public final Unsigned32 runePowerGain = new Unsigned32();

}   
