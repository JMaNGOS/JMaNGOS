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
package org.jmangos.commons.enums;

/**
 * The Enum MovementFlags.
 */
public enum ItemFlags {

    /** The BINDED */
    BINDED(0x00000001),
    /** The UNK1 */
    UNK1(0x00000002),
    /** The UNLOCKED. */
    UNLOCKED(0x00000004),
    /** The WRAPPED. */
    WRAPPED(0x00000008),
    /** The UNK4. */
    UNK4(0x00000010),
    /** The UNK5. */
    UNK5(0x00000020),
    /** The UNK6. */
    UNK6(0x00000040),
    /** The UNK7. */
    UNK7(0x00000080),
    /** The UNK8. */
    UNK8(0x00000100),
    /** The READABLE. */
    READABLE(0x00000200),
    /** The UNK10. */
    UNK10(0x00000400),
    /** The UNK11. */
    UNK11(0x00000800),
    /** The UNK12. */
    UNK12(0x00001000),
    /** The UNK13. */
    UNK13(0x00002000),
    /** The UNK14. */
    UNK14(0x00004000),
    /** The UNK15. */
    UNK15(0x00008000),
    /** The JUST_CREATED</br><i><b>Modify:</b></i> 09182012 */
    JUST_CREATED(0x00010000),
    /** The UNK17. */
    UNK17(0x00020000),
    /** The UNK18. */
    UNK18(0x00040000),
    /** The UNK19. */
    UNK19(0x00080000),
    /** The UNK20. */
    UNK20(0x00100000),
    /** The UNK21. */
    UNK21(0x00200000),
    /** The UNK22. */
    UNK22(0x00400000),
    /** The UNK23. */
    UNK23(0x00800000),
    /** The UNK24. */
    UNK24(0x01000000),
    /** The UNK25. */
    UNK25(0x02000000),
    /** The UNK26. */
    UNK26(0x04000000),
    /** The UNK27. */
    UNK27(0x08000000),
    /** The UNK28. */
    UNK28(0x10000000),
    /** The UNK29. */
    UNK29(0x20000000),
    /** The UNK30. */
    UNK30(0x40000000),
    /** The UNK31. */
    UNK31(0x80000000);

    /** The value. */
    private int value;

    /**
     * Instantiates a new movement flags.
     * 
     * @param flag
     *        the flag
     */
    ItemFlags(final int flag) {

        setValue(flag);
    }

    /**
     * Sets the value.
     * 
     * @param value
     *        the new value
     */
    public void setValue(final int value) {

        this.value = value;
    }

    /**
     * Gets the value.
     * 
     * @return the value
     */
    public int getValue() {

        return this.value;
    }

    public boolean contains(final int val) {

        return ((getValue() & val) == getValue());
    }
}
