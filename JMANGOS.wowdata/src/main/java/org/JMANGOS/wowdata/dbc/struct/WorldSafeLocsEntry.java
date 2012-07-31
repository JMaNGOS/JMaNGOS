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

public class WorldSafeLocsEntry extends DBCStruct<WorldSafeLocsEntry> {
	@XmlAttribute(name="id", required=true)
	public final Unsigned32 ID = new Unsigned32();
	@XmlAttribute(name="mapId", required=true)
	public final Unsigned32 mapId = new Unsigned32();
	@XmlAttribute(name="coord", required=true)
	public final Float32[] coords = array(new Float32[3]);
	@XmlAttribute(name="name")
	public final MultiInternalString name = new MultiInternalString();
}
