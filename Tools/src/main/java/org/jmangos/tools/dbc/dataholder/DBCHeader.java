/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package org.jmangos.tools.dbc.dataholder;

public class DBCHeader extends DBCStruct<DBCHeader> {

    public static int DBCFmtSig = 0x43424457;
    public final Unsigned32 FileMark = new Unsigned32();
    public final Signed32 RecordsCount = new Signed32();
    public final Signed32 FieldsCount = new Signed32();
    public final Signed32 RecordSize = new Signed32();
    public final Signed32 StringTableSize = new Signed32();

    public boolean isCorrect() {

        return this.FileMark.get() == DBCFmtSig;
    }
}
