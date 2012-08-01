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

public class TaxiPathNodeEntry extends DBCStruct<TaxiPathNodeEntry> {
	@XmlAttribute(name = "id", required=true)
	public final Unsigned32 id = new Unsigned32();
	@XmlAttribute(name = "path", required=true)
	public final Unsigned32 path = new Unsigned32();
	@XmlAttribute(name = "index", required=true)
	public final Unsigned32 index = new Unsigned32();
	@XmlAttribute(name = "mapid", required=true)
	public final Unsigned32 mapid = new Unsigned32();
	@XmlAttribute(name = "coord", required=true)
	public final Float32[] coord = array(new Float32[3]);
	@XmlAttribute(name = "actionFlag", required=true)
	public final Unsigned32 actionFlag = new Unsigned32();
	@XmlAttribute(name = "delay", required=true)
	public final Unsigned32 delay = new Unsigned32();
	@XmlAttribute(name = "m_arrivalEventID")
	public final Unsigned32 m_arrivalEventID = new Unsigned32();
	@XmlAttribute(name = "m_departureEventID")
	public final Unsigned32 m_departureEventID = new Unsigned32();
}
