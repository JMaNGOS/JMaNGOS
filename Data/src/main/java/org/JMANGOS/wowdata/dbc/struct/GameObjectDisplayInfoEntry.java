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

public class GameObjectDisplayInfoEntry extends DBCStruct<GameObjectDisplayInfoEntry> 
{
	@XmlAttribute(name="Displayid", required=true)
	public final Unsigned32 Displayid = new Unsigned32();
	@XmlAttribute(name="filename")
    public final InternalString filename = new InternalString();
	@XmlAttribute(name="unk")
	public final Unsigned32[] unk = array(new Unsigned32[10]);
	@XmlAttribute(name="unk2")
	public final Float32[] unk2 = array(new Float32[6]);
	@XmlAttribute(name="unk3")
	public final Unsigned32 unk3 = new Unsigned32();
};
