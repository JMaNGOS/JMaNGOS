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
 * Created with IntelliJ IDEA. User: Goofy Date: 2012.08.08. Time: 19:03 To
 * change this template use
 * File | Settings | File Templates.
 */
public enum ChatLanguage {
    /** UNIVERSAL. */
    UNIVERSAL(0),

    /** ORCISH. */
    ORCISH(1),

    /** DARNASSIAN. */
    DARNASSIAN(2),

    /** TAURAHE. */
    TAURAHE(3),

    /** DWARVISH. */
    DWARVISH(6),

    /** COMMON. */
    COMMON(7),

    /** DEMONIC. */
    DEMONIC(8),

    /** TITAN. */
    TITAN(9),

    /** THALASSIAN. */
    THALASSIAN(10),

    /** DRACONIC. */
    DRACONIC(11),

    /** KALIMAG. */
    KALIMAG(12),

    /** GNOMISH. */
    GNOMISH(13),

    /** TROLL. */
    TROLL(14),

    /** GUTTERSPEAK. */
    GUTTERSPEAK(33),

    /** DRAENEI. */
    DRAENEI(35),

    /** ZOMBIE. */
    ZOMBIE(36),

    /** GNOMISH_BINARY. */
    GNOMISH_BINARY(37),

    /** GOBLIN_BINARY. */
    GOBLIN_BINARY(38),

    /** ADDON. */
    ADDON(0xFFFFFFFF);

    private int value;

    ChatLanguage(final int val) {

        this.value = val;
    }

    /**
     * @return the value
     */
    public int getValue() {

        return this.value;
    }

}
