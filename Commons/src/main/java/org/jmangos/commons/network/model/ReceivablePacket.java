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
package org.jmangos.commons.network.model;

import java.nio.BufferUnderflowException;

import javolution.text.TextBuilder;

import org.jboss.netty.channel.Channel;

/**
 * The Class ReceivablePacket.
 * 
 * @author KenM
 */
public abstract class ReceivablePacket extends AbstractPacket implements Runnable, Cloneable {
    
    /**
     * Instantiates a new receivable packet.
     */
    protected ReceivablePacket() {
    
    }
    
    /**
     * Instantiates a new receivable packet.
     * 
     * @param opcode
     *            the opcode
     */
    protected ReceivablePacket(final int opcode) {
    
        setOpCode(opcode);
    }
    
    /** The _client. */
    protected NetworkChannel _client;
    
    /**
     * Sets the client.
     * 
     * @param client
     *            the new client
     */
    public final void setClient(final NetworkChannel client) {
    
        this._client = client;
    }
    
    /**
     * Gets the client.
     * 
     * @return the client
     */
    public NetworkChannel getClient() {
    
        return this._client;
    }
    
    /**
     * Gets the channel.
     * 
     * @return the channel
     */
    public final Channel getChannel() {
    
        return this._client.getChannel();
    }
    
    /**
     * Should be overridden.
     * 
     * @return the minimum length
     */
    public int getMinimumLength() {
    
        return 0;
    }
    
    /**
     * Gets the avaliable bytes.
     * 
     * @return the avaliable bytes
     */
    public final int getAvaliableBytes() {
    
        return getByteBuffer().readableBytes();
    }
    
    /**
     * Read.
     * 
     * @return true, if successful
     * @throws BufferUnderflowException
     *             the buffer underflow exception
     * @throws RuntimeException
     *             the runtime exception
     */
    public boolean read() throws BufferUnderflowException, RuntimeException {
    
        readImpl();
        runImpl();
        return true;
    }
    
    /**
     * Read impl.
     * 
     * @throws BufferUnderflowException
     *             the buffer underflow exception
     * @throws RuntimeException
     *             the runtime exception
     */
    protected abstract void readImpl() throws BufferUnderflowException, RuntimeException;
    
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public final void run() {
    
        runImpl();
    }
    
    /**
     * Run impl.
     */
    protected abstract void runImpl();
    
    /**
     * Skip.
     * 
     * @param bytes
     *            the bytes
     */
    protected final void skip(final int bytes) {
    
        if (getByteBuffer().readableBytes() < bytes) {
            throw new BufferUnderflowException();
        }
        
        getByteBuffer().skipBytes(bytes);
    }
    
    /**
     * Skip all.
     */
    protected final void skipAll() {
    
        skip(getByteBuffer().readableBytes());
    }
    
    /**
     * Read b.
     * 
     * @param len
     *            the len
     * @return the byte[]
     */
    protected final byte[] readB(final int len) {
    
        final byte[] tmp = new byte[len];
        getByteBuffer().readBytes(tmp);
        return tmp;
    }
    
    /**
     * Read b.
     * 
     * @param dst
     *            the dst
     * @param offset
     *            the offset
     * @param len
     *            the len
     */
    protected final void readB(final byte[] dst, final int offset, final int len) {
    
        getByteBuffer().readBytes(dst, offset, len);
    }
    
    /**
     * Read c.
     * 
     * @return the int
     */
    protected final int readC() {
    
        return getByteBuffer().readByte() & 0xFF;
    }
    
    /**
     * Read h.
     * 
     * @return the int
     */
    protected final int readH() {
    
        return getByteBuffer().readShort();
    }
    
    /**
     * Read d.
     * 
     * @return the int
     */
    protected final int readD() {
    
        return getByteBuffer().readInt();
    }
    
    /**
     * Read q.
     * 
     * @return the long
     */
    protected final long readQ() {
    
        return getByteBuffer().readLong();
    }
    
    /**
     * Read f.
     * 
     * @return the float
     */
    protected final float readF() {
    
        return getByteBuffer().readFloat();
    }
    
    /**
     * Read s.
     * 
     * @return the string
     */
    protected final String readS() {
    
        final TextBuilder tb = TextBuilder.newInstance();
        
        for (byte c; (c = getByteBuffer().readByte()) != 0;) {
            tb.append((char) c);
        }
        
        final String str = tb.toString();
        TextBuilder.recycle(tb);
        return str;
    }
    
    /**
     * Clone packet.
     * 
     * @return the receivable packet
     */
    public ReceivablePacket clonePacket() {
    
        try {
            return (ReceivablePacket) super.clone();
        } catch (final CloneNotSupportedException e) {
            return null;
        }
    }
}
