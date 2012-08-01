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

public class CreatureDisplayInfoEntry extends DBCStruct<CreatureDisplayInfoEntry> {
	@XmlAttribute(name="DisplayId", required=true)
    public final Unsigned32 DisplayId= new Unsigned32(); 
	@XmlAttribute(name="m_modelID")
    public final Unsigned32 m_modelID = new Unsigned32();  
	@XmlAttribute(name="sound")
    public final Unsigned32 sound= new Unsigned32();
	@XmlAttribute(name="ExtraDisplayInformation")
    public final Unsigned32 ExtraDisplayInformation= new Unsigned32();
	@XmlAttribute(name="creatureModelScale", required=true)
    public final Float32 creatureModelScale= new Float32();
	@XmlAttribute(name="Opacity")
    public final Unsigned32 Opacity= new Unsigned32();
	@XmlAttribute(name="m_textureVariation")
    public final InternalString m_textureVariation1= new InternalString();
	@XmlAttribute(name="m_textureVariation2")
    public final InternalString m_textureVariation2 = new InternalString();
	@XmlAttribute(name="m_textureVariation3")
    public final InternalString m_textureVariation3= new InternalString();
	@XmlAttribute(name="m_portraitTextureName")
    public final InternalString m_portraitTextureName= new InternalString();
	@XmlAttribute(name="m_sizeClass")
    public final Signed32 m_sizeClass= new Signed32();
	@XmlAttribute(name="m_bloodID")
    public final Signed32 m_bloodID= new Signed32();
	@XmlAttribute(name="m_NPCSoundID")
    public final Unsigned32 m_NPCSoundID= new Unsigned32();
	@XmlAttribute(name="m_particleColorID")
    public final Unsigned32 m_particleColorID= new Unsigned32();
	@XmlAttribute(name="m_creatureGeosetData")
    public final Unsigned32 m_creatureGeosetData= new Unsigned32();
	@XmlAttribute(name="m_objectEffectPackageID")
    public final Unsigned32 m_objectEffectPackageID= new Unsigned32();
}
