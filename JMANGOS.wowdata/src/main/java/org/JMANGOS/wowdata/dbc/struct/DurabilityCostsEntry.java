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


public class DurabilityCostsEntry extends DBCStruct<DurabilityCostsEntry> {
	public static int MAX_MULTIPLIER = 29;
	@XmlAttribute(name="Itemlvl", required=true)
    public final Unsigned32 Itemlvl= new Unsigned32(); 
	@XmlAttribute(name="multiplier", required=true)
    public final Unsigned32[] multiplier = array(new Unsigned32[MAX_MULTIPLIER]);  
}
