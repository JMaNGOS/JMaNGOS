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
 * Enumerated <tt>ActionButtonMessageType</tt>
 * 
 * @author MinimaJack
 *         <ol>
 *         <li><b>INICIAL</b> - sent when initial action buttons get sent
 *         <li><b>SWAP</b> - used after specialisation swaps
 *         <li><b>CLEAR</b> - clears the action bars on client
 *         </ol>
 * 
 */
public enum ActionButtonMessageType {
    INICIAL,
    SWAP,
    CLEAR;
}
