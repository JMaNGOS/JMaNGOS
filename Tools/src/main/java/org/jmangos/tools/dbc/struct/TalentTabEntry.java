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

public class TalentTabEntry extends DBCStruct<TalentTabEntry> {
	@XmlAttribute(name = "TalentTabID", required=true)
	public final Unsigned32 TalentTabID = new Unsigned32();
	@XmlAttribute(name = "name")
	public final MultiInternalString name = new MultiInternalString();
	@XmlAttribute(name = "spellicon")
	public final Unsigned32 spellicon = new Unsigned32();
	@XmlAttribute(name = "unk")
	public final Signed32 unk = new Signed32();
	@XmlAttribute(name = "ClassMask", required=true)
	public final Unsigned32 ClassMask = new Unsigned32();
	@XmlAttribute(name = "petTalentMask", required=true)
	public final Unsigned32 petTalentMask = new Unsigned32();
	@XmlAttribute(name = "tabpage", required=true)
	public final Unsigned32 tabpage = new Unsigned32();
	@XmlAttribute(name = "internalName")
	public final InternalString internalName = new InternalString();
}
