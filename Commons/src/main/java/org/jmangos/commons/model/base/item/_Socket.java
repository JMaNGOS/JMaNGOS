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
package org.jmangos.commons.model.base.item;

// TODO: Auto-generated Javadoc
/**
 * The Class _Socket.
 */
public final class _Socket {

    /** The Color. */
    private byte Color;

    /** The Content. */
    private int Content;

    /**
     * Instantiates a new _ socket.
     * 
     * @param color
     *        the color
     * @param content
     *        the content
     */
    public _Socket(final byte color, final int content) {

        this.Color = color;
        this.Content = content;
    }

    /**
     * Gets the color.
     * 
     * @return the color
     */
    public byte getColor() {

        return this.Color;
    }

    /**
     * Sets the color.
     * 
     * @param color
     *        the color to set
     */
    public void setColor(final byte color) {

        this.Color = color;
    }

    /**
     * Gets the content.
     * 
     * @return the content
     */
    public int getContent() {

        return this.Content;
    }

    /**
     * Sets the content.
     * 
     * @param content
     *        the content to set
     */
    public void setContent(final int content) {

        this.Content = content;
    }

}
