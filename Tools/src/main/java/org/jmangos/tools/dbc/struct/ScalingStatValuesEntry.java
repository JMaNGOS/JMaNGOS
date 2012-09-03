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

public class ScalingStatValuesEntry extends DBCStruct<ScalingStatValuesEntry> {
    
    @XmlAttribute(name = "id", required = true)
    public final Unsigned32   Id             = new Unsigned32();
    @XmlAttribute(name = "Level", required = true)
    public final Unsigned32   Level          = new Unsigned32();
    @XmlAttribute(name = "ssdMultiplier", required = true)
    public final Unsigned32[] ssdMultiplier  = array(new Unsigned32[4]);
    @XmlAttribute(name = "armorMod", required = true)
    public final Unsigned32[] armorMod       = array(new Unsigned32[4]);
    @XmlAttribute(name = "dpsMod", required = true)
    public final Unsigned32[] dpsMod         = array(new Unsigned32[6]);
    
    @XmlAttribute(name = "spellBonus", required = true)
    public final Unsigned32   spellBonus     = new Unsigned32();
    @XmlAttribute(name = "ssdMultiplier2", required = true)
    public final Unsigned32   ssdMultiplier2 = new Unsigned32();
    @XmlAttribute(name = "ssdMultiplier3", required = true)
    public final Unsigned32   ssdMultiplier3 = new Unsigned32();
    @XmlAttribute(name = "unk2")
    public final Unsigned32   unk2           = new Unsigned32();
    @XmlAttribute(name = "armorMod2", required = true)
    public final Unsigned32[] armorMod2      = array(new Unsigned32[4]);
}
