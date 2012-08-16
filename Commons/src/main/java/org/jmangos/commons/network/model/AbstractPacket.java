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
/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.jmangos.commons.network.model;

import org.jboss.netty.buffer.ChannelBuffer;

/**
 * The Class AbstractPacket.
 * 
 * @author KenM
 */
abstract class AbstractPacket {
    
    /** The op code. */
    protected int         opCode;
    
    /** The buf. */
    private ChannelBuffer buf;
    
    /**
     * Instantiates a new abstract packet.
     */
    public AbstractPacket() {
    
    }
    
    /**
     * Instantiates a new abstract packet.
     * 
     * @param opCode
     *            the op code
     */
    public AbstractPacket(final int opCode) {
    
        this.opCode = opCode;
    }
    
    /**
     * Sets the byte buffer.
     * 
     * @param buffer
     *            the new byte buffer
     */
    public final void setByteBuffer(final ChannelBuffer buffer) {
    
        this.buf = buffer;
    }
    
    /**
     * Gets the byte buffer.
     * 
     * @return the byte buffer
     */
    public final ChannelBuffer getByteBuffer() {
    
        return this.buf;
    }
    
    /**
     * Gets the op code.
     * 
     * @return the op code
     */
    public int getOpCode() {
    
        return this.opCode;
    }
    
    /**
     * Sets the op code.
     * 
     * @param opCode
     *            the new op code
     */
    public void setOpCode(final int opCode) {
    
        this.opCode = opCode;
    }
}
