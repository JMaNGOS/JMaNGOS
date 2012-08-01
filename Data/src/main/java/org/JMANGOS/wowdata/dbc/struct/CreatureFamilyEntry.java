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

public class CreatureFamilyEntry  extends DBCStruct<CreatureFamilyEntry> {
	@XmlAttribute(name = "id", required=true)
	public final Unsigned32 ID = new Unsigned32();
	@XmlAttribute(name="minScale", required=true)
	public final Float32 minScale = new Float32();
	@XmlAttribute(name="minScaleLevel", required=true)
	public final Unsigned32 minScaleLevel = new Unsigned32();
	@XmlAttribute(name="maxScale", required=true)
	public final Float32 maxScale = new Float32();
	@XmlAttribute(name="maxScaleLevel", required=true)
	public final Unsigned32 maxScaleLevel = new Unsigned32();
	@XmlAttribute(name="skillLine", required=true)
	public final Unsigned32[] skillLine = array(new Unsigned32[2]);
	@XmlAttribute(name="petFoodMask", required=true)
	public final Unsigned32 petFoodMask = new Unsigned32();
	@XmlAttribute(name="TalentType", required=true)
	public final Signed32 petTalentType = new Signed32();
	@XmlAttribute(name="categoryEnumID")
	public final Unsigned32 categoryEnumID = new Unsigned32();
	@XmlAttribute(name="name", required=true)
	public final MultiInternalString name = new MultiInternalString();
	@XmlAttribute(name="iconFile")
	public final InternalString iconFile = new InternalString();
}
