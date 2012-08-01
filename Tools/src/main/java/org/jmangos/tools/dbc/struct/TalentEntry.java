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

public class TalentEntry extends DBCStruct<TalentEntry> {
	final static int MAX_TALENT_RANK = 9;
	@XmlAttribute(name = "TalentID", required=true)
	public final Unsigned32 TalentID = new Unsigned32();
	@XmlAttribute(name = "TalentTab", required=true)
	public final Unsigned32 TalentTab = new Unsigned32();
	@XmlAttribute(name = "Row", required=true)
	public final Unsigned32 Row = new Unsigned32();
	@XmlAttribute(name = "Col", required=true)
	public final Unsigned32 Col = new Unsigned32();
	@XmlAttribute(name = "RankID", required=true)
	public final Unsigned32[] RankID = array(new Unsigned32[MAX_TALENT_RANK]);
	@XmlAttribute(name = "DependsOn", required=true)
	public final Unsigned32[] DependsOn = array(new Unsigned32[3]);
	@XmlAttribute(name = "DependsOnRank", required=true)
	public final Unsigned32[] DependsOnRank = array(new Unsigned32[3]);
	@XmlAttribute(name = "needAddInSpellBook")
	public final Unsigned32 needAddInSpellBook = new Unsigned32();
	@XmlAttribute(name = "unk2")
	public final Unsigned32 unk2 = new Unsigned32();
	@XmlAttribute(name = "allowForPet")
	public final Unsigned32[] allowForPet = array(new Unsigned32[2]);
}
