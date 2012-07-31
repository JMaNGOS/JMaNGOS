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

public class CreatureModelDataEntry extends DBCStruct<CreatureModelDataEntry> {
	@XmlAttribute(name="Id", required=true)
    public final Unsigned32 Id= new Unsigned32(); 
	@XmlAttribute(name="Flags")
    public final Unsigned32 Flags = new Unsigned32();  
	@XmlAttribute(name="ModelPath")
    public final InternalString ModelPath= new InternalString();
	@XmlAttribute(name="ModelPathAlt")
    public final Unsigned32 ModelPathAlt= new Unsigned32();
}
