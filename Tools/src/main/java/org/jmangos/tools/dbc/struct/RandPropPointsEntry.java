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

public class RandPropPointsEntry extends DBCStruct<RandPropPointsEntry> {
    
    final static int          MAX_PROP                 = 5;
    @XmlAttribute(name = "itemLevel", required = true)
    public final Unsigned32   itemLevel                = new Unsigned32();
    @XmlAttribute(name = "EpicPropertiesPoints", required = true)
    public final Unsigned32[] EpicPropertiesPoints     = array(new Unsigned32[MAX_PROP]);
    @XmlAttribute(name = "RarePropertiesPoints", required = true)
    public final Unsigned32[] RarePropertiesPoints     = array(new Unsigned32[MAX_PROP]);
    @XmlAttribute(name = "UncommonPropertiesPoints", required = true)
    public final Unsigned32[] UncommonPropertiesPoints = array(new Unsigned32[MAX_PROP]);
}
