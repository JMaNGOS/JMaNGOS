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

public class CreatureFamilyEntry extends DBCStruct<CreatureFamilyEntry> {

    @XmlAttribute(name = "id", required = true)
    public final Unsigned32 ID = new Unsigned32();
    @XmlAttribute(name = "minScale", required = true)
    public final Float32 minScale = new Float32();
    @XmlAttribute(name = "minScaleLevel", required = true)
    public final Unsigned32 minScaleLevel = new Unsigned32();
    @XmlAttribute(name = "maxScale", required = true)
    public final Float32 maxScale = new Float32();
    @XmlAttribute(name = "maxScaleLevel", required = true)
    public final Unsigned32 maxScaleLevel = new Unsigned32();
    @XmlAttribute(name = "skillLine", required = true)
    public final Unsigned32[] skillLine = array(new Unsigned32[2]);
    @XmlAttribute(name = "petFoodMask", required = true)
    public final Unsigned32 petFoodMask = new Unsigned32();
    @XmlAttribute(name = "TalentType", required = true)
    public final Signed32 petTalentType = new Signed32();
    @XmlAttribute(name = "categoryEnumID")
    public final Unsigned32 categoryEnumID = new Unsigned32();
    @XmlAttribute(name = "name", required = true)
    public final MultiInternalString name = new MultiInternalString();
    @XmlAttribute(name = "iconFile")
    public final InternalString iconFile = new InternalString();
}
