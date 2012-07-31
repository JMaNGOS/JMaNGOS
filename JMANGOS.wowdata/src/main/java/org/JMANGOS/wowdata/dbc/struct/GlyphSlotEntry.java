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


public class GlyphSlotEntry extends DBCStruct<GlyphSlotEntry> {
	@XmlAttribute(name="Id", required=true)
    public final Unsigned32 Id= new Unsigned32(); 
	@XmlAttribute(name="TypeFlags", required=true)
    public final Unsigned32 TypeFlags= new Unsigned32(); 
	@XmlAttribute(name="Order", required=true)
    public final Unsigned32 Order= new Unsigned32(); 
}
