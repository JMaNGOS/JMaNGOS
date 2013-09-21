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

/**
 * 
 * @author MinimaJack
 * 
 */
public class Other {

    /**
     * COUNT_MAGIC_BYTES
     */
    public static final int COUNT_MAGIC_BYTES = 4;
    /**
     * COUNT_UNK_FLOATS
     */
    public static final int COUNT_UNK_FLOATS = 14;
    /**
     * magic
     */
    private byte[] magic = new byte[COUNT_MAGIC_BYTES];
    /**
     * version
     */
    private int version;
    /**
     * globalModelFlags
     */
    private int globalModelFlags;
    /**
     * theFloats
     */
    private float[] theFloats = new float[COUNT_UNK_FLOATS];

    /**
     * @return the magic
     */
    public final byte[] getMagic() {

        return this.magic;
    }

    /**
     * @param givenMagic
     *        the magic to set
     */
    public final void setMagic(final byte[] givenMagic) {

        this.magic = givenMagic;
    }

    /**
     * @return the version
     */
    public final int getVersion() {

        return this.version;
    }

    /**
     * @param givenVersion
     *        the version to set
     */
    public final void setVersion(final int givenVersion) {

        this.version = givenVersion;
    }

    /**
     * @return the globalModelFlags
     */
    public final int getGlobalModelFlags() {

        return this.globalModelFlags;
    }

    /**
     * @param givenGlobalModelFlags
     *        the globalModelFlags to set
     */
    public final void setGlobalModelFlags(final int givenGlobalModelFlags) {

        this.globalModelFlags = givenGlobalModelFlags;
    }

    /**
     * @return the theFloats
     */
    public final float[] getTheFloats() {

        return this.theFloats;
    }

    /**
     * @param givenFloats
     *        the theFloats to set
     */
    public final void setTheFloats(final float[] givenFloats) {

        this.theFloats = givenFloats;
    }
}
