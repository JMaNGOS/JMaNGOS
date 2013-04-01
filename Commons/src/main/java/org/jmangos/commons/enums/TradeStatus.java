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
 * The Enum Trade Status.
 */
public enum TradeStatus {

    /** The BUSY. */
    BUSY(0),

    /** The BEGIN_TRADE. */
    BEGIN_TRADE(1),

    /** The OPEN_WINDOW. */
    OPEN_WINDOW(2),

    /** The TRADE_CANCELED. */
    TRADE_CANCELED(3),

    /** The TRADE_ACCEPT. */
    TRADE_ACCEPT(4),

    /** The BUSY_2. */
    BUSY_2(5),

    /** The NO_TARGET. */
    NO_TARGET(6),

    /** The BACK_TO_TRADE. */
    BACK_TO_TRADE(7),

    /** The TRADE_COMPLETE. */
    TRADE_COMPLETE(8),

    /** The TARGET_TO_FAR. */
    TARGET_TO_FAR(10),

    /** The TARGET_TO_FAR. */
    WRONG_FACTION(11),

    /** The CLOSE_WINDOW. */
    CLOSE_WINDOW(12),

    /** The IGNORE_YOU. */
    IGNORE_YOU(14),

    /** The YOU_STUNNED. */
    YOU_STUNNED(15),

    /** The TARGET_STUNNED. */
    TARGET_STUNNED(16),

    /** The YOU_DEAD. */
    YOU_DEAD(17),

    /** The TARGET_DEAD. */
    TARGET_DEAD(18),

    /** The YOU_LOGOUT. */
    YOU_LOGOUT(19),

    /** The TARGET_LOGOUT. */
    TARGET_LOGOUT(20),

    /** The TRIAL_ACCOUNT. */
    TRIAL_ACCOUNT(21),

    /** The ONLY_CONJURED. */
    ONLY_CONJURED(22);

    /** The status. */
    private int status;

    /**
     * Gets the status.
     * 
     * @return the status
     */
    public final int getStatus() {

        return this.status;
    }

    /**
     * Instantiates a new trade status.
     * 
     * @param status
     *        the status
     */
    TradeStatus(final int status) {

        this.status = status;
    }
}
