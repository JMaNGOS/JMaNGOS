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

public class TaxiPathNodeEntry extends DBCStruct<TaxiPathNodeEntry> {

    @XmlAttribute(name = "id", required = true)
    public final Unsigned32 id = new Unsigned32();
    @XmlAttribute(name = "path", required = true)
    public final Unsigned32 path = new Unsigned32();
    @XmlAttribute(name = "index", required = true)
    public final Unsigned32 index = new Unsigned32();
    @XmlAttribute(name = "mapid", required = true)
    public final Unsigned32 mapid = new Unsigned32();
    @XmlAttribute(name = "coord", required = true)
    public final Float32[] coord = array(new Float32[3]);
    @XmlAttribute(name = "actionFlag", required = true)
    public final Unsigned32 actionFlag = new Unsigned32();
    @XmlAttribute(name = "delay", required = true)
    public final Unsigned32 delay = new Unsigned32();
    @XmlAttribute(name = "m_arrivalEventID")
    public final Unsigned32 m_arrivalEventID = new Unsigned32();
    @XmlAttribute(name = "m_departureEventID")
    public final Unsigned32 m_departureEventID = new Unsigned32();
}
