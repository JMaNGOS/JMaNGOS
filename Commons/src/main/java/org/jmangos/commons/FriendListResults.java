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
package org.jmangos.commons;

/**
 * Created with IntelliJ IDEA. User: Goofy Date: 2012.08.08. Time: 12:15 To
 * change this template use
 * File | Settings | File Templates.
 */
public enum FriendListResults {
    FRIEND_DB_ERROR(0x00),
    FRIEND_LIST_FULL(0x01),
    FRIEND_ONLINE(0x02),
    FRIEND_OFFLINE(0x03),
    FRIEND_NOT_FOUND(0x04),
    FRIEND_REMOVED(0x05),
    FRIEND_ADDED_ONLINE(0x06),
    FRIEND_ADDED_OFFLINE(0x07),
    FRIEND_ALREADY(0x08),
    FRIEND_SELF(0x09),
    FRIEND_ENEMY(0x0A),
    FRIEND_IGNORE_FULL(0x0B),
    FRIEND_IGNORE_SELF(0x0C),
    FRIEND_IGNORE_NOT_FOUND(0x0D),
    FRIEND_IGNORE_ALREADY(0x0E),
    FRIEND_IGNORE_ADDED(0x0F),
    FRIEND_IGNORE_REMOVED(0x10);

    private int value;

    FriendListResults(final int value) {

        setValue(value);
    }

    /**
     * @return the value
     */
    public int getValue() {

        return this.value;
    }

    /**
     * @param value
     *        the value to set
     */
    public void setValue(final int value) {

        this.value = value;
    }
}
