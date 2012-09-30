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
package org.jmangos.tools.adt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.jmangos.tools.adt.chunks.ADTChunk;
import org.jmangos.tools.adt.chunks.root.MCNKChunk;
import org.jmangos.tools.adt.chunks.root.MHDRChunk;
import org.jmangos.tools.adt.chunks.root.MMDXChunk;
import org.jmangos.tools.adt.chunks.root.MMIDChunk;
import org.jmangos.tools.adt.chunks.root.MWIDChunk;
import org.jmangos.tools.adt.chunks.root.MWMOChunk;
import org.jmangos.tools.chunk.BaseChunk;
import org.jmangos.tools.chunk.MVERChunk;

public class ADT {

    private MVERChunk version;
    private MHDRChunk header;
    private MMIDChunk mmid;
    private MMDXChunk mmdx;
    private MWIDChunk mwid;
    private MWMOChunk mwmo;
    public MCNKChunk[] mcnks = new MCNKChunk[256];

    public ADT read(final File f) throws IOException {

        FileInputStream fis = null;
        final ByteBuffer bb = ByteBuffer.allocate((int) f.length());
        final ADT result = new ADT();
        try {
            fis = new FileInputStream(f);
            fis.getChannel().read(bb);
            bb.rewind();
            bb.order(ByteOrder.LITTLE_ENDIAN);

            int glOffset = 0;
            int mcnksIndex = 0;
            while (glOffset < (int) f.length()) {
                final BaseChunk ch = new ADTChunk().readChunkByHeader(bb, glOffset);
                if (ch instanceof MVERChunk) {
                    setVersion((MVERChunk) ch);
                } else if (ch instanceof MHDRChunk) {
                    setHeader((MHDRChunk) ch);
                } else if (ch instanceof MMIDChunk) {
                    this.mmid = (MMIDChunk) ch;
                    this.mmdx.setMMID(this.mmid);
                } else if (ch instanceof MMDXChunk) {
                    this.mmdx = (MMDXChunk) ch;
                } else if (ch instanceof MWIDChunk) {
                    this.mwid = (MWIDChunk) ch;
                    this.mwmo.setMWID(this.mwid);
                } else if (ch instanceof MWMOChunk) {
                    this.mwmo = (MWMOChunk) ch;
                } else if (ch instanceof MCNKChunk) {
                    this.mcnks[mcnksIndex++] = (MCNKChunk) ch;
                }
                glOffset = ch.getGlobalOffcet();
            }
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            fis.close();
        }
        return result;
    }

    /**
     * @param version
     *        the version to set
     */
    public void setVersion(final MVERChunk version) {

        this.version = version;
    }

    /**
     * @return the version
     */
    public MVERChunk getVersion() {

        return this.version;
    }

    /**
     * @param header
     *        the header to set
     */
    public void setHeader(final MHDRChunk header) {

        this.header = header;
    }

    /**
     * @return the header
     */
    public MHDRChunk getHeader() {

        return this.header;
    }
}
