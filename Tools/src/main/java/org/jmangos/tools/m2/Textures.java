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
package org.jmangos.tools.m2;

import java.nio.ByteBuffer;

/**
 * 
 * @author MinimaJack
 * 
 */
public class Textures {

    /**
     * type
     */
    private int type;
    /**
     * flags
     */
    private int flags;
    /**
     * length of the filename
     */
    private int lenFilename;
    /**
     * Offset of the filename
     */
    private int ofsFilename;
    /**
     * File name
     */
    private String fileName;

    /**
     * 
     * @param bb
     *        ByteBuffer
     * @return Textures
     */
    public static Textures read(final ByteBuffer bb) {

        final Textures result = new Textures();
        result.type = bb.getInt();
        result.flags = bb.getInt();
        result.lenFilename = bb.getInt();
        result.ofsFilename = bb.getInt();

        return result;
    }

    /**
     * @return the type
     */
    public final int getType() {

        return this.type;
    }

    /**
     * @param givenType
     *        the type to set
     */
    public final void setType(final int givenType) {

        this.type = givenType;
    }

    /**
     * @return the flags
     */
    public final int getFlags() {

        return this.flags;
    }

    /**
     * @param givenFlags
     *        the flags to set
     */
    public final void setFlags(final int givenFlags) {

        this.flags = givenFlags;
    }

    /**
     * @return the lenFilename
     */
    public final int getLenFilename() {

        return this.lenFilename;
    }

    /**
     * @param givenLenFilename
     *        the lenFilename to set
     */
    public final void setLenFilename(final int givenLenFilename) {

        this.lenFilename = givenLenFilename;
    }

    /**
     * @return the ofsFilename
     */
    public final int getOfsFilename() {

        return this.ofsFilename;
    }

    /**
     * @param givenofsFilename
     *        the ofsFilename to set
     */
    public final void setOfsFilename(final int givenofsFilename) {

        this.ofsFilename = givenofsFilename;
    }

    /**
     * @return the fileName
     */
    public final String getFileName() {

        return this.fileName;
    }

    /**
     * @param givenFileName
     *        the fileName to set
     */
    public final void setFileName(final String givenFileName) {

        this.fileName = givenFileName;
    }

}
