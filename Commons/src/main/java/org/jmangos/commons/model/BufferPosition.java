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
/**
 * 
 */
package org.jmangos.commons.model;

/**
 * @author MinimaJack
 * 
 */
public class BufferPosition {

    private int startPosition = 0;
    private int endPosition = 0;

    /**
     * @param startPosition
     * @param endPosition
     */
    public BufferPosition(int startPosition, int endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    /**
     * @return the startPosition
     */
    public final int getStartPosition() {
        return this.startPosition;
    }

    /**
     * @param startPosition
     *        the startPosition to set
     */
    public final void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    /**
     * @return the endPosition
     */
    public final int getEndPosition() {
        return this.endPosition;
    }

    /**
     * @param endPosition
     *        the endPosition to set
     */
    public final void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }

    public int getLength() {
        return this.endPosition - this.startPosition;
    }
}
