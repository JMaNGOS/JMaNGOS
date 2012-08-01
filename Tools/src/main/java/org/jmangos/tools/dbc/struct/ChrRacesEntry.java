/*******************************************************************************
 * Copyright (c) 2012 JMANGOS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     JMANGOS - initial API and implementation
 ******************************************************************************/
package org.jmangos.tools.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.jmangos.tools.dbc.dataholder.DBCStruct;

public class ChrRacesEntry  extends DBCStruct<ChrClassesEntry> {
	@XmlAttribute(name = "RaceID", required=true)
	public final Unsigned32 RaceID = new Unsigned32();
	public final Unsigned32 unk = new Unsigned32();
	@XmlAttribute(name="FactionID", required=true)
	public final Unsigned32 FactionID = new Unsigned32();
	public final Unsigned32 unk2 = new Unsigned32();
	@XmlAttribute(name="modelMale", required=true)
	public final Unsigned32 modelM = new Unsigned32();
	@XmlAttribute(name="modelFemale", required=true)
	public final Unsigned32 modelF = new Unsigned32();
	public final InternalString ShortEnglishName = new InternalString();
	@XmlAttribute(name="TeamID", required=true)
	public final Unsigned32 TeamID = new Unsigned32();
	public final Unsigned32[] unk42 = array(new Unsigned32[3]);
	public final InternalString EnglishName = new InternalString();
	@XmlAttribute(name="CinematicSequence", required=true)
	public final Unsigned32 CinematicSequence = new Unsigned32();
	public final Unsigned32 team = new Unsigned32();
	@XmlAttribute(name="name", required=true)
	public final MultiInternalString name = new MultiInternalString();
	@XmlAttribute(name="nameFemale")
	public final MultiInternalString nameFemale = new MultiInternalString();
	@XmlAttribute(name="nameNeutralGender")
	public final MultiInternalString nameNeutralGender = new MultiInternalString();
	public final InternalString BodyForMan = new InternalString();
	public final InternalString BodyForWoman = new InternalString();
	public final InternalString BodyForNeutral = new InternalString();
	@XmlAttribute(name="expansion", required=true)
	public final Unsigned32 expansion = new Unsigned32();
}
