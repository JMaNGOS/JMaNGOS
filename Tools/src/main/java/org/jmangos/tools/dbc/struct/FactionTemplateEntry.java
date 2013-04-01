/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
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
 ******************************************************************************/
package org.jmangos.tools.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.jmangos.tools.dbc.dataholder.DBCStruct;

public class FactionTemplateEntry extends DBCStruct<FactionTemplateEntry> {

    public final static int MAX_FAXTION_MASK = 4;
    @XmlAttribute(name = "id", required = true)
    public final Unsigned32 ID = new Unsigned32();
    @XmlAttribute(name = "faction", required = true)
    public final Unsigned32 faction = new Unsigned32();                       // 1
    @XmlAttribute(name = "factionFlags", required = true)
    public final Unsigned32 factionFlags = new Unsigned32();                       // 2
    @XmlAttribute(name = "ourMask", required = true)
    public final Unsigned32 ourMask = new Unsigned32();                       // 2
    @XmlAttribute(name = "friendlyMask", required = true)
    public final Unsigned32 friendlyMask = new Unsigned32();                       // 2
    @XmlAttribute(name = "hostileMask", required = true)
    public final Unsigned32 hostileMask = new Unsigned32();                       // 2
    @XmlAttribute(name = "enemyFaction", required = true)
    public final Unsigned32[] enemyFaction = array(new Unsigned32[MAX_FAXTION_MASK]); // 2
    @XmlAttribute(name = "friendFaction", required = true)
    public final Unsigned32[] friendFaction = array(new Unsigned32[MAX_FAXTION_MASK]); // 2
};
