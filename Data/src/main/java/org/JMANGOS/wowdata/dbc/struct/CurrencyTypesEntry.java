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


public class CurrencyTypesEntry extends DBCStruct<CurrencyTypesEntry> {
	@XmlAttribute(name="ID")
    public final Unsigned32 ID= new Unsigned32(); 
	@XmlAttribute(name="ItemId", required=true)
    public final Unsigned32 ItemId = new Unsigned32();  
	@XmlAttribute(name="Category")
    public final Unsigned32 Category = new Unsigned32();  
	@XmlAttribute(name="BitIndex", required=true)
    public final Unsigned32 BitIndex = new Unsigned32();  
}
