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
package org.jmangos.realm.model.enums;

/**
 * The Enum CharacterFlags.
 */
public enum CharacterFlags {
    
    /** The NONE. */
    NONE(0),
    
    /** The UNK1. */
    UNK1(1 << 0),
    
    /** The UNK2. */
    UNK2(1 << 1),
    
    /** The LOCKED_FOR_TRANSFER. */
    LOCKED_FOR_TRANSFER(1 << 2),
    
    /** The UNK4. */
    UNK4(1 << 3),
    
    /** The UNK5. */
    UNK5(1 << 4),
    
    /** The UNK6. */
    UNK6(1 << 5),
    
    /** The UNK7. */
    UNK7(1 << 6),
    
    /** The UNK8. */
    UNK8(1 << 7),
    
    /** The UNK9. */
    UNK9(1 << 8),
    
    /** The UNK10. */
    UNK10(1 << 9),
    
    /** The HIDE_HELM. */
    HIDE_HELM(1 << 10),
    
    /** The HIDE_CLOAK. */
    HIDE_CLOAK(1 << 11),
    
    /** The UNK13. */
    UNK13(1 << 12),
    
    /** The GHOST. */
    GHOST(1 << 13),
    
    /** The RENAME. */
    RENAME(1 << 14),
    
    /** The UNK16. */
    UNK16(1 << 15),
    
    /** The UNK17. */
    UNK17(1 << 16),
    
    /** The UNK18. */
    UNK18(1 << 17),
    
    /** The UNK19. */
    UNK19(1 << 18),
    
    /** The UNK20. */
    UNK20(1 << 19),
    
    /** The UNK21. */
    UNK21(1 << 20),
    
    /** The UNK22. */
    UNK22(1 << 21),
    
    /** The UNK23. */
    UNK23(1 << 22),
    
    /** The UNK24. */
    UNK24(1 << 23),
    
    /** The LOCKED_BY_BILLING. */
    LOCKED_BY_BILLING(1 << 24),
    
    /** The DECLINED. */
    DECLINED(1 << 25),
    
    /** The UNK27. */
    UNK27(1 << 26),
    
    /** The UNK28. */
    UNK28(1 << 27),
    
    /** The UNK29. */
    UNK29(1 << 28),
    
    /** The UNK30. */
    UNK30(1 << 29),
    
    /** The UNK31. */
    UNK31(1 << 30);
    
    /** The flag. */
    private long flag;
    
    /**
     * Instantiates a new character flags.
     * 
     * @param flag
     *            the flag
     */
    CharacterFlags(final long flag) {
    
        this.flag = flag;
    }
    
    /**
     * Instantiates a new character flags.
     * 
     * @param es
     *            the es
     */
    CharacterFlags(final CharacterFlags... es) {
    
        this.flag = 0;
        for (final CharacterFlags e : es) {
            this.flag |= e.getMask();
        }
    }
    
    /**
     * Gets the mask.
     * 
     * @return the mask
     */
    public long getMask() {
    
        return this.flag;
    }
}
