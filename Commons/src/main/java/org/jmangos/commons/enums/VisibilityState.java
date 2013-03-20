package org.jmangos.commons.enums;

/**
 * Used in byte (PLAYER_FIELD_BYTES2,3) values.
 * <ul>
 * <li><b>DETECT_AMORE_LOW</b></li>
 * <li><b>DETECT_AMORE_NORMAL</b></li>
 * <li><b>DETECT_AMORE_HIGH</b></li>
 * <li><b>STEALTH</b></li>
 * <li><b>INVISIBILITY_GLOW</b></li>
 * </ul>
 * 
 * @author MinimaJack
 * 
 */
public enum VisibilityState {
    LOW((byte) 0x04),
    NORMAL((byte) 0x08),
    HIGH((byte) 0x10),
    STEALTH((byte) 0x20),
    INVISIBILITY_GLOW((byte) 0x40);

    private byte value;

    VisibilityState(final byte val) {

        this.value = val;
    }

    /**
     * @return the value
     */
    public final byte getValue() {

        return this.value;
    }

    /**
     * @param value
     *        the value to set
     */
    public final void setValue(final byte value) {

        this.value = value;
    }

}
