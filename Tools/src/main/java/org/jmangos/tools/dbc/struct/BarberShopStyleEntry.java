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

public class BarberShopStyleEntry extends DBCStruct<BarberShopStyleEntry> {
    
    @XmlAttribute(name = "id", required = true)
    public final Unsigned32          id             = new Unsigned32();
    @XmlAttribute(name = "type", required = true)
    public final Unsigned32          type           = new Unsigned32();
    @XmlAttribute(name = "name")
    public final MultiInternalString name           = new MultiInternalString();
    @XmlAttribute(name = "uname")
    public final MultiInternalString uname          = new MultiInternalString();
    @XmlAttribute(name = "CostMultiplier")
    public final Float32             CostMultiplier = new Float32();
    @XmlAttribute(name = "race", required = true)
    public final Unsigned32          race           = new Unsigned32();
    @XmlAttribute(name = "gender", required = true)
    public final Unsigned32          gender         = new Unsigned32();
    @XmlAttribute(name = "hairId", required = true)
    public final Unsigned32          hairId         = new Unsigned32();
}
