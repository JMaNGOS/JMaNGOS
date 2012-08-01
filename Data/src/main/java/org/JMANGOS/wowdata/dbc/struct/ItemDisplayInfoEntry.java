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

public class ItemDisplayInfoEntry  extends DBCStruct<ItemDisplayInfoEntry> {
	@XmlAttribute(name = "id", required=true)
	public final Unsigned32 id = new Unsigned32();
	@XmlAttribute(name = "modelName")
	public final InternalString modelName = new InternalString();
	@XmlAttribute(name = "modelName_left")
	public final InternalString modelName2 = new InternalString();
	@XmlAttribute(name = "modelTexture")
	public final InternalString modelTexture = new InternalString();
	@XmlAttribute(name = "modelTexture_left")
	public final InternalString modelTexture2 = new InternalString();
	@XmlAttribute(name = "inventoryIcon")
	public final InternalString inventoryIcon = new InternalString();
}
