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

public class GemPropertiesEntry extends DBCStruct<GemPropertiesEntry> {

    @XmlAttribute(name = "ID", required = true)
    public final Unsigned32 ID = new Unsigned32();
    @XmlAttribute(name = "spellitemenchantement", required = true)
    public final Unsigned32 spellitemenchantement = new Unsigned32();
    @XmlAttribute(name = "color", required = true)
    public final Unsigned32 color = new Unsigned32();
    @XmlAttribute(name = "unk")
    public final Unsigned32[] unk = array(new Unsigned32[2]);

}
