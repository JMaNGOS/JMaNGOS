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

public class QuestXPEntry  extends DBCStruct<QuestXPEntry> {
	@XmlAttribute(name="questLevel", required=true)
	public final Unsigned32 questLevel = new Unsigned32();
	@XmlAttribute(name="xpIndex", required=true)
	public final Unsigned32[] xpIndex = array(new Unsigned32[10]);
}
