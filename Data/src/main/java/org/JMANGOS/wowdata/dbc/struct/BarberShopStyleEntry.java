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

public class BarberShopStyleEntry extends DBCStruct<BarberShopStyleEntry> {
	@XmlAttribute(name="id", required=true)
    public final Unsigned32 id= new Unsigned32(); 
	@XmlAttribute(name="type", required=true)
    public final Unsigned32 type= new Unsigned32(); 
	@XmlAttribute(name="name")
    public final MultiInternalString name= new MultiInternalString(); 
	@XmlAttribute(name="uname")
    public final MultiInternalString uname= new MultiInternalString(); 
	@XmlAttribute(name="CostMultiplier")
	public final Float32 CostMultiplier = new Float32(); 
	@XmlAttribute(name="race", required=true)
    public final Unsigned32 race= new Unsigned32(); 
	@XmlAttribute(name="gender", required=true)
    public final Unsigned32 gender= new Unsigned32(); 
	@XmlAttribute(name="hairId", required=true)
    public final Unsigned32 hairId= new Unsigned32(); 
}
