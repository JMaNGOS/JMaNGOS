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

public class LockEntry  extends DBCStruct<LockEntry> {
	final static int MAX_LOCK_CASE = 8; 
	@XmlAttribute(name = "id", required=true)
	public final Unsigned32 ID = new Unsigned32();
	@XmlAttribute(name="Type", required=true)
	public final Unsigned32[] Type = array(new Unsigned32[MAX_LOCK_CASE]);	
	@XmlAttribute(name = "Index", required=true)
	public final Unsigned32[] Index = array(new Unsigned32[MAX_LOCK_CASE]);	
	@XmlAttribute(name = "Skill", required=true)
	public final Unsigned32[] Skill = array(new Unsigned32[MAX_LOCK_CASE]);	
	@XmlAttribute(name = "Action")
	public final Unsigned32[] Action = array(new Unsigned32[MAX_LOCK_CASE]);	
}
