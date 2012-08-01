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

public class ItemExtendedCostEntry  extends DBCStruct<ItemExtendedCostEntry> {
	final static int REQ_COUNT = 5;
	@XmlAttribute(name = "id", required=true)
	public final Unsigned32 ID = new Unsigned32();
	@XmlAttribute(name="reqhonorpoints", required=true)
	public final Unsigned32 reqhonorpoints = new Unsigned32();	
	@XmlAttribute(name = "reqarenapoints", required=true)
	public final Unsigned32 reqarenapoints = new Unsigned32();
	@XmlAttribute(name = "reqarenaslot", required=true)
	public final Unsigned32 reqarenaslot = new Unsigned32();
	@XmlAttribute(name = "reqitem", required=true)
	public final Unsigned32[] reqitem = array(new Unsigned32[REQ_COUNT]);
	@XmlAttribute(name = "reqitemcount", required=true)
	public final Unsigned32[] reqitemcount = array(new Unsigned32[REQ_COUNT]);
	@XmlAttribute(name = "reqpersonalarenarating", required=true)
	public final Unsigned32 reqpersonalarenarating = new Unsigned32();
	@XmlAttribute(name = "unk")
	public final Unsigned32 unk = new Unsigned32();
}
