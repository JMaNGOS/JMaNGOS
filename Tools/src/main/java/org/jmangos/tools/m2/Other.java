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
