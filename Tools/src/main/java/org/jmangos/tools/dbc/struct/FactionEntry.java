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

public class FactionEntry extends DBCStruct<FactionEntry> 
{
	public static int MAX_REP = 4;
	@XmlAttribute(name="id", required=true)
	public final Unsigned32 ID = new Unsigned32();                                              // 0, holiday id
	@XmlAttribute(name="reputationListID", required=true)
    public final Signed32 reputationListID = new Signed32();                                          // 1
    @XmlAttribute(name="BaseRepRaceMask", required=true)
    public final Unsigned32[] BaseRepRaceMask = array(new Unsigned32[MAX_REP]);                                          // 2
    @XmlAttribute(name="BaseRepClassMask", required=true)
    public final Unsigned32[] BaseRepClassMask = array(new Unsigned32[MAX_REP]);                                          // 2
    @XmlAttribute(name="BaseRepValue", required=true)
    public final Signed32[] BaseRepValue = array(new Signed32[MAX_REP]);                                          // 2
    @XmlAttribute(name="ReputationFlags", required=true)
    public final Unsigned32[] ReputationFlags = array(new Unsigned32[MAX_REP]);                                          // 2
    @XmlAttribute(name="team", required=true)
    public final Unsigned32 team =new Unsigned32();                                          // 2
    @XmlAttribute(name="unk1")
    public final Float32[] unk1 = array(new Float32[MAX_REP/2]);                                          // 2
    @XmlAttribute(name="unk12")
    public final Unsigned32[] unk12 = array(new Unsigned32[MAX_REP/2]);                                          // 2
    @XmlAttribute(name="name", required=true)
    public final MultiInternalString name = new MultiInternalString();
    @XmlAttribute(name="description")
    public final MultiInternalString description = new MultiInternalString();
};
