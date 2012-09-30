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

public class CharStartOutfitEntry extends DBCStruct<CharStartOutfitEntry> {

    public final static int MAX_OUTFIT_ITEMS = 24;
    @XmlAttribute(name = "id")
    public final Signed32 id = new Signed32();
    @XmlAttribute(name = "race", required = true)
    public final Signed8 race = new Signed8();
    @XmlAttribute(name = "class", required = true)
    public final Signed8 clazz = new Signed8();
    @XmlAttribute(name = "gender", required = true)
    public final Signed8 gender = new Signed8();
    public final Unsigned8 pad = new Unsigned8();
    @XmlAttribute(name = "ItemId", required = true)
    public final Signed32[] protoId = array(new Signed32[MAX_OUTFIT_ITEMS]);
    @XmlAttribute(name = "ItemDisplayId")
    public final Signed32[] ItemDisplayId = array(new Signed32[MAX_OUTFIT_ITEMS]);
    @XmlAttribute(name = "ItemInventorySlot")
    public final Signed32[] ItemInventorySlot = array(new Signed32[MAX_OUTFIT_ITEMS]);
}
