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

public class ChrRacesEntry extends DBCStruct<ChrRacesEntry> {

    @XmlAttribute(name = "RaceID", required = true)
    public final Signed32 RaceID = new Signed32();
    public final Signed32 unk = new Signed32();
    @XmlAttribute(name = "FactionID", required = true)
    public final Signed32 FactionID = new Signed32();
    public final Signed32 unk2 = new Signed32();
    @XmlAttribute(name = "modelMale", required = true)
    public final Signed32 modelM = new Signed32();
    @XmlAttribute(name = "modelFemale", required = true)
    public final Signed32 modelF = new Signed32();
    public final InternalString ShortEnglishName = new InternalString();
    @XmlAttribute(name = "TeamID", required = true)
    public final Signed32 TeamID = new Signed32();
    public final Signed32[] unk42 = array(new Signed32[3]);
    public final InternalString EnglishName = new InternalString();
    @XmlAttribute(name = "CinematicSequence", required = true)
    public final Signed32 CinematicSequence = new Signed32();
    public final Signed32 team = new Signed32();
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
    public final Signed32 expansion = new Signed32();
}
