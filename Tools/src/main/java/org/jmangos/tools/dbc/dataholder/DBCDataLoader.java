/*******************************************************************************
 * Copyright (C) 2012 JMaNGOS <http://jmangos.org/>
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
 *******************************************************************************/
package org.jmangos.tools.dbc.dataholder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

public class DBCDataLoader {
	public static <T extends DBCStruct<T>> T loadStaticData(Class<T> clazz,
			String DBCFile) {
		DBCHeader dbcHeader = new DBCHeader();
		ByteBuffer bb = getByteBufferFromFile(DBCFile);
		dbcHeader.setByteBuffer(bb, 0);
		if (!dbcHeader.isCorrect()) {
			return null;
		}
		T bdcEntry = null;
		try {
			bdcEntry = clazz.newInstance();
			bdcEntry.setByteBuffer(bb, DBCBaseStruct.HEADER_SIZE);
			bdcEntry.setStringBufferPosition(DBCBaseStruct.HEADER_SIZE
					+ dbcHeader.RecordsCount.get() * dbcHeader.RecordSize.get());
			bdcEntry.setCount(dbcHeader.RecordsCount.get());
			bdcEntry.setSkipLenght(dbcHeader.RecordSize.get() - bdcEntry.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bdcEntry;
	}

	public static <T extends DBCStruct<T>> boolean saveDBC2XML(Class<T> clazz,
			String dbcpath, String xmlPath, boolean full) {
		try {
			// String name = clazz.getSimpleName();
			// name = dbcpath.concat(name.substring(0,
			// name.length()-5)).concat(".dbc");
			T Entry = DBCDataLoader.loadStaticData(clazz, dbcpath);
			Entry.saveToXML(xmlPath, full);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public static ByteBuffer getByteBufferFromFile(String file) {
		FileInputStream fIn = null;
		FileChannel fChan;
		long fSize = 0;
		ByteBuffer mBuf = null;
		try {
			fIn = new FileInputStream(file);
			fChan = fIn.getChannel();
			fSize = fChan.size();
			mBuf = ByteBuffer.allocate((int) fSize);
			fChan.read(mBuf);
			mBuf.rewind();
			mBuf.order(ByteOrder.LITTLE_ENDIAN);
			fChan.close();
			fIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mBuf;
	}
}
