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

public class DeclinedWordCasesEntry extends DBCStruct<DeclinedWordCasesEntry> {
	@XmlAttribute(name = "id")
	public final Unsigned32 ID = new Unsigned32();
	@XmlAttribute(name = "id2")
	public final Unsigned32 ID2 = new Unsigned32();
	@XmlAttribute(name = "id3")
	public final Unsigned32 ID3 = new Unsigned32();
	@XmlAttribute(name="name")
	public final InternalString name = new InternalString();

}
