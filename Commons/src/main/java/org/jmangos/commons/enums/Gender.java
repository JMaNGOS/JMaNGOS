package org.jmangos.commons.enums;

public enum Gender {
    MALE((byte) 0),
    FEMALE((byte) 1);

    private byte value;

    Gender(final byte val) {

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

    public static Gender get(final int value) {

        for (final Gender val : values()) {
            if (val.getValue() == value) {
                return val;
            }
        }

        return null;
    }

}
