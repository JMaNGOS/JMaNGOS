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
package org.JMANGOS.wowdata.dbc.dataholder;


public class DBCHeader extends DBCStruct<DBCHeader> {
	public static int DBCFmtSig = 0x43424457; 
	public final Unsigned32 FileMark = new Unsigned32();
	public final Signed32 RecordsCount = new Signed32();
	public final Signed32 FieldsCount = new Signed32();
	public final Signed32 RecordSize = new Signed32();
	public final Signed32 StringTableSize = new Signed32();
	public boolean isCorrect(){
		return FileMark.get() == DBCFmtSig;
	}
}
