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
		T Entry = null;
		try {
			Entry = clazz.newInstance();
		/*	System.out.println("[ " + Entry.getClass().getSimpleName() + " ]");
			System.out.println("Record size is: " + Entry.size());
			System.out.println("Size in dbc header " + dbcHeader.RecordSize.get());*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		Entry.setByteBuffer(bb, DBCBaseStruct.HEADER_SIZE);
		Entry.setStringBufferPosition(DBCBaseStruct.HEADER_SIZE + dbcHeader.RecordsCount.get()
				* dbcHeader.RecordSize.get());
		Entry.setCount(dbcHeader.RecordsCount.get());
		Entry.setSkipLenght(dbcHeader.RecordSize.get() - Entry.size());
		return Entry;
	}
	public static <T extends DBCStruct<T>> boolean saveDBC2XML(Class<T> clazz, String dbcpath, String xmlPath, boolean full){
		try {
			//String name = clazz.getSimpleName();
		//	name = dbcpath.concat(name.substring(0, name.length()-5)).concat(".dbc");
			T Entry = DBCDataLoader.loadStaticData(clazz, dbcpath);
			Entry.saveToXML(xmlPath,full);
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
			fChan.close();
			fIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mBuf.order(ByteOrder.LITTLE_ENDIAN);
		return mBuf;
	}
}
