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


public class CharStartOutfitEntry extends DBCStruct<CharStartOutfitEntry> {
	public static int MAX_OUTFIT_ITEMS = 24;
	@XmlAttribute(name="id")
    public final Unsigned32 id = new Unsigned32();  
	@XmlAttribute(name="race" ,required=true)
    public final Unsigned8 race= new Unsigned8(); 
	@XmlAttribute(name="class" ,required=true)
    public final Unsigned8 clazz= new Unsigned8(); 
	@XmlAttribute(name="gender" ,required=true)
    public final Unsigned8 gender= new Unsigned8(); 
    public final Unsigned8 pad= new Unsigned8(); 
	@XmlAttribute(name="ItemId" ,required=true)
    public final Signed32[] ItemId= array(new Signed32[MAX_OUTFIT_ITEMS]); 
	@XmlAttribute(name="ItemDisplayId")
    public final Signed32[] ItemDisplayId= array(new Signed32[MAX_OUTFIT_ITEMS]); 
	@XmlAttribute(name="ItemInventorySlot")
    public final Signed32[] ItemInventorySlot= array(new Signed32[MAX_OUTFIT_ITEMS]); 
}
