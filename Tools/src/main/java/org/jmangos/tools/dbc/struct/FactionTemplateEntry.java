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

public class FactionTemplateEntry extends DBCStruct<FactionTemplateEntry> 
{
	public static int MAX_FAXTION_MASK = 4;
	@XmlAttribute(name="id", required=true)
	public final Unsigned32 ID = new Unsigned32();
	@XmlAttribute(name="faction", required=true)
    public final Unsigned32 faction = new Unsigned32();                                          // 1
    @XmlAttribute(name="factionFlags", required=true)
    public final Unsigned32 factionFlags = new Unsigned32();                                          // 2
    @XmlAttribute(name="ourMask", required=true)
    public final Unsigned32 ourMask = new Unsigned32();                                          // 2
    @XmlAttribute(name="friendlyMask", required=true)
    public final Unsigned32 friendlyMask = new Unsigned32();                                          // 2
    @XmlAttribute(name="hostileMask", required=true)
    public final Unsigned32 hostileMask = new Unsigned32();                                          // 2
    @XmlAttribute(name="enemyFaction", required=true)
    public final Unsigned32[] enemyFaction = array(new Unsigned32[MAX_FAXTION_MASK]);                                          // 2
    @XmlAttribute(name="friendFaction", required=true)
    public final Unsigned32[] friendFaction = array(new Unsigned32[MAX_FAXTION_MASK]);                                          // 2
};
