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


public class SpellFocusObjectEntry extends DBCStruct<SpellFocusObjectEntry> {
	@XmlAttribute(name="ID", required=true)
    public final Unsigned32 ID= new Unsigned32(); 
	@XmlAttribute(name="Name")
    public final MultiInternalString Name = new MultiInternalString();  
}
