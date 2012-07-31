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
package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class ChrClassesEntry extends DBCStruct<ChrClassesEntry> {
	@XmlAttribute(name = "ClassID", required=true)
	public final Unsigned32 ClassID = new Unsigned32();
	public final Unsigned32 flags = new Unsigned32();
	@XmlAttribute(name="powerType", required=true)
	public final Unsigned32 powerType = new Unsigned32();
	@XmlAttribute(name="type")
	public final InternalString type = new InternalString();
	@XmlAttribute(name="name")
	public final MultiInternalString name = new MultiInternalString();
	@XmlAttribute(name="nameFemale")
	public final MultiInternalString nameFemale = new MultiInternalString();
	@XmlAttribute(name="nameNeutralGender")
	public final MultiInternalString nameNeutralGender = new MultiInternalString();	
	@XmlAttribute(name="capName")
	public final InternalString capName = new InternalString();
	@XmlAttribute(name="spellfamily", required=true)
	public final Unsigned32 spellfamily = new Unsigned32();
	@XmlAttribute(name="flags2")
	public final Unsigned32 flags2 = new Unsigned32();
	@XmlAttribute(name="CinematicSequence", required=true)
	public final Unsigned32 CinematicSequence = new Unsigned32();
	@XmlAttribute(name="expansion", required=true)
	public final Unsigned32 expansion = new Unsigned32();
}
