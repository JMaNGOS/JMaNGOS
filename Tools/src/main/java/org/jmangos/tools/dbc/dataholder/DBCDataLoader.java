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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

public class DBCDataLoader {

    public static <T extends DBCStruct<T>> T loadStaticData(final Class<T> clazz,
            final String DBCFile) {

        final DBCHeader dbcHeader = new DBCHeader();
        final ByteBuffer bb = getByteBufferFromFile(DBCFile);
        dbcHeader.setByteBuffer(bb, 0);
        if (!dbcHeader.isCorrect()) {
            return null;
        }
        T Entry = null;
        try {
            Entry = clazz.newInstance();
            /*
             * System.out.println("[ " + Entry.getClass().getSimpleName() +
             * " ]");
             * System.out.println("Record size is: " + Entry.size());
             * System.out.println("Size in dbc header " +
             * dbcHeader.RecordSize.get());
             */
        } catch (final Exception e) {
            e.printStackTrace();
        }
        Entry.setByteBuffer(bb, DBCBaseStruct.HEADER_SIZE);
        Entry.setStringBufferPosition(DBCBaseStruct.HEADER_SIZE +
            (dbcHeader.RecordsCount.get() * dbcHeader.RecordSize.get()));
        Entry.setCount(dbcHeader.RecordsCount.get());
        Entry.setSkipLenght(dbcHeader.RecordSize.get() - Entry.size());
        return Entry;
    }

    public static <T extends DBCStruct<T>> boolean saveDBC2XML(final Class<T> clazz,
            final String dbcpath, final String xmlPath, final boolean full) {

        try {
            // String name = clazz.getSimpleName();
            // name = dbcpath.concat(name.substring(0,
            // name.length()-5)).concat(".dbc");
            final T Entry = DBCDataLoader.loadStaticData(clazz, dbcpath);
            Entry.saveToXML(xmlPath, full);
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static ByteBuffer getByteBufferFromFile(final String file) {

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
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        mBuf.order(ByteOrder.LITTLE_ENDIAN);
        return mBuf;
    }
}
