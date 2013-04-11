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
 * Enumerated <tt>ActionButtonType</tt>
 * 
 * @author MinimaJack
 *         <ol> Button types
 *         <li><b>SPELL</b>
 *         <li><b>CLICK</b>
 *         <li><b>EQUIPSET</b>
 *         <li><b>MACRO</b>
 *         <li><b>ITEM</b>
 *         </ol>
 * 
 */
public enum ActionButtonType {
    SPELL(0),
    CLICK(1),
    EQUIPSET(32),
    MACRO(64),
    ITEM(128);

    private int value;

    ActionButtonType(int value) {
        this.setValue(value);
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value
     *        the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }
    /**
     * 
     * @param value
     *        - id value of the class
     * @return Game class
     */
    public static ActionButtonType get(final int value) {

        for (final ActionButtonType val : values()) {
            if (val.getValue() == value) {
                return val;
            }
        }

        return null;
    }
}
