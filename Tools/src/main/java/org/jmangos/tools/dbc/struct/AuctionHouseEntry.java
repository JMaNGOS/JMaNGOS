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

public class AuctionHouseEntry extends DBCStruct<AuctionHouseEntry> {
    
    @XmlAttribute(name = "id", required = true)
    public final Unsigned32          id             = new Unsigned32();
    @XmlAttribute(name = "faction", required = true)
    public final Unsigned32          faction        = new Unsigned32();
    @XmlAttribute(name = "depositPercent", required = true)
    public final Unsigned32          depositPercent = new Unsigned32();
    @XmlAttribute(name = "cutPercent", required = true)
    public final Unsigned32          cutPercent     = new Unsigned32();
    @XmlAttribute(name = "name")
    public final MultiInternalString name           = new MultiInternalString();
}
