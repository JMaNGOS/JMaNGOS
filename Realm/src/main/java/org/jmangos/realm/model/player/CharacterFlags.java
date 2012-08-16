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
package org.jmangos.realm.model.player;

// TODO: Auto-generated Javadoc
/**
 * The Enum CharacterFlags.
 */
public enum CharacterFlags {
    
    /** The CHARACTE r_ fla g_ none. */
    CHARACTER_FLAG_NONE(0),
    
    /** The CHARACTE r_ fla g_ un k1. */
    CHARACTER_FLAG_UNK1(1 << 0),
    
    /** The CHARACTE r_ fla g_ un k2. */
    CHARACTER_FLAG_UNK2(1 << 1),
    
    /** The CHARACTE r_ locke d_ fo r_ transfer. */
    CHARACTER_LOCKED_FOR_TRANSFER(1 << 2),
    
    /** The CHARACTE r_ fla g_ un k4. */
    CHARACTER_FLAG_UNK4(1 << 3),
    
    /** The CHARACTE r_ fla g_ un k5. */
    CHARACTER_FLAG_UNK5(1 << 4),
    
    /** The CHARACTE r_ fla g_ un k6. */
    CHARACTER_FLAG_UNK6(1 << 5),
    
    /** The CHARACTE r_ fla g_ un k7. */
    CHARACTER_FLAG_UNK7(1 << 6),
    
    /** The CHARACTE r_ fla g_ un k8. */
    CHARACTER_FLAG_UNK8(1 << 7),
    
    /** The CHARACTE r_ fla g_ un k9. */
    CHARACTER_FLAG_UNK9(1 << 8),
    
    /** The CHARACTE r_ fla g_ un k10. */
    CHARACTER_FLAG_UNK10(1 << 9),
    
    /** The CHARACTE r_ fla g_ hid e_ helm. */
    CHARACTER_FLAG_HIDE_HELM(1 << 10),
    
    /** The CHARACTE r_ fla g_ hid e_ cloak. */
    CHARACTER_FLAG_HIDE_CLOAK(1 << 11),
    
    /** The CHARACTE r_ fla g_ un k13. */
    CHARACTER_FLAG_UNK13(1 << 12),
    
    /** The CHARACTE r_ fla g_ ghost. */
    CHARACTER_FLAG_GHOST(1 << 13),
    
    /** The CHARACTE r_ fla g_ rename. */
    CHARACTER_FLAG_RENAME(1 << 14),
    
    /** The CHARACTE r_ fla g_ un k16. */
    CHARACTER_FLAG_UNK16(1 << 15),
    
    /** The CHARACTE r_ fla g_ un k17. */
    CHARACTER_FLAG_UNK17(1 << 16),
    
    /** The CHARACTE r_ fla g_ un k18. */
    CHARACTER_FLAG_UNK18(1 << 17),
    
    /** The CHARACTE r_ fla g_ un k19. */
    CHARACTER_FLAG_UNK19(1 << 18),
    
    /** The CHARACTE r_ fla g_ un k20. */
    CHARACTER_FLAG_UNK20(1 << 19),
    
    /** The CHARACTE r_ fla g_ un k21. */
    CHARACTER_FLAG_UNK21(1 << 20),
    
    /** The CHARACTE r_ fla g_ un k22. */
    CHARACTER_FLAG_UNK22(1 << 21),
    
    /** The CHARACTE r_ fla g_ un k23. */
    CHARACTER_FLAG_UNK23(1 << 22),
    
    /** The CHARACTE r_ fla g_ un k24. */
    CHARACTER_FLAG_UNK24(1 << 23),
    
    /** The CHARACTE r_ fla g_ locke d_ b y_ billing. */
    CHARACTER_FLAG_LOCKED_BY_BILLING(1 << 24),
    
    /** The CHARACTE r_ fla g_ declined. */
    CHARACTER_FLAG_DECLINED(1 << 25),
    
    /** The CHARACTE r_ fla g_ un k27. */
    CHARACTER_FLAG_UNK27(1 << 26),
    
    /** The CHARACTE r_ fla g_ un k28. */
    CHARACTER_FLAG_UNK28(1 << 27),
    
    /** The CHARACTE r_ fla g_ un k29. */
    CHARACTER_FLAG_UNK29(1 << 28),
    
    /** The CHARACTE r_ fla g_ un k30. */
    CHARACTER_FLAG_UNK30(1 << 29),
    
    /** The CHARACTE r_ fla g_ un k31. */
    CHARACTER_FLAG_UNK31(1 << 30);
    
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
