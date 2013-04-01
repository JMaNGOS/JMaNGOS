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

public class ChrRacesEntry extends DBCStruct<ChrClassesEntry> {

    @XmlAttribute(name = "RaceID", required = true)
    public final Unsigned32 RaceID = new Unsigned32();
    public final Unsigned32 unk = new Unsigned32();
    @XmlAttribute(name = "FactionID", required = true)
    public final Unsigned32 FactionID = new Unsigned32();
    public final Unsigned32 unk2 = new Unsigned32();
    @XmlAttribute(name = "modelMale", required = true)
    public final Unsigned32 modelM = new Unsigned32();
    @XmlAttribute(name = "modelFemale", required = true)
    public final Unsigned32 modelF = new Unsigned32();
    public final InternalString ShortEnglishName = new InternalString();
    @XmlAttribute(name = "TeamID", required = true)
    public final Unsigned32 TeamID = new Unsigned32();
    public final Unsigned32[] unk42 = array(new Unsigned32[3]);
    public final InternalString EnglishName = new InternalString();
    @XmlAttribute(name = "CinematicSequence", required = true)
    public final Unsigned32 CinematicSequence = new Unsigned32();
    public final Unsigned32 team = new Unsigned32();
    @XmlAttribute(name = "name", required = true)
    public final MultiInternalString name = new MultiInternalString();
    @XmlAttribute(name = "nameFemale")
    public final MultiInternalString nameFemale = new MultiInternalString();
    @XmlAttribute(name = "nameNeutralGender")
    public final MultiInternalString nameNeutralGender = new MultiInternalString();
    public final InternalString BodyForMan = new InternalString();
    public final InternalString BodyForWoman = new InternalString();
    public final InternalString BodyForNeutral = new InternalString();
    @XmlAttribute(name = "expansion", required = true)
    public final Unsigned32 expansion = new Unsigned32();
}
