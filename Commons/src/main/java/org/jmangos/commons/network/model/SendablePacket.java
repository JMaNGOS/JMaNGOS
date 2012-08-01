/*******************************************************************************
 * Copyright (c) 2012 JMANGOS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     JMANGOS - initial API and implementation
 ******************************************************************************/
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

// TODO: Auto-generated Javadoc
/**
 * The Class SendablePacket.
 *
 * @author KenM
 */
public abstract class SendablePacket extends AbstractPacket
{
	
	/** The channel. */
	protected NetworkChannel channel;

	/**
	 * Instantiates a new sendable packet.
	 */
	protected SendablePacket()
	{
	}

	/**
	 * Write c.
	 *
	 * @param value the value
	 */
	protected final void writeC(boolean value)
	{
		getByteBuffer(). writeByte((byte) (value ? 1 : 0));
	}

	/**
	 * Write c.
	 *
	 * @param value the value
	 */
	protected final void writeC(int value)
	{
		getByteBuffer().writeByte((byte) value);
	}

	/**
	 * Write h.
	 *
	 * @param value the value
	 */
	protected final void writeH(boolean value)
	{
		getByteBuffer().writeMedium((short) (value ? 1 : 0));
	}

	/**
	 * Write h.
	 *
	 * @param value the value
	 */
	protected final void writeH(int value)
	{
		getByteBuffer().writeShort((short) value);
	}

	/**
	 * Write d.
	 *
	 * @param value the value
	 */
	protected final void writeD(boolean value)
	{
		getByteBuffer().writeInt(value ? 1 : 0);
	}

	/**
	 * Write d.
	 *
	 * @param value the value
	 */
	protected final void writeD(int value)
	{
		getByteBuffer().writeInt(value);
	}

	/**
	 * Write d.
	 *
	 * @param value the value
	 */
	protected final void writeD(long value)
	{
		getByteBuffer().writeInt(value < Integer.MAX_VALUE ? (int) value : Integer.MAX_VALUE);
	}

	/**
	 * Write q.
	 *
	 * @param value the value
	 */
	protected final void writeQ(boolean value)
	{
		getByteBuffer().writeLong(value ? 1 : 0);
	}

	/**
	 * Write q.
	 *
	 * @param value the value
	 */
	protected final void writeQ(long value)
	{
		getByteBuffer().writeLong(value);
	}

	/**
	 * Write f.
	 *
	 * @param value the value
	 */
	protected final void writeF(float value)
	{
		getByteBuffer().writeFloat(value);
	}

	/**
	 * Write f.
	 *
	 * @param value the value
	 */
	protected final void writeF(int value)
	{
		getByteBuffer().writeFloat(value);
	}

	/**
	 * Write b.
	 *
	 * @param data the data
	 */
	protected final void writeB(byte[] data)
	{
		getByteBuffer().writeBytes(data);
	}
	
	/**
	 * Write packed guid.
	 *
	 * @param guid the guid
	 */
	protected final void writePackedGuid(long guid)
	{
		long tguid = guid;
		byte[] packGUID = new byte[8+1];
        packGUID[0] = 0;
        int size = 1;
        for (byte i = 0; tguid != 0; ++i)
        {
            if ((tguid & 0xFF) > 0)
            {
                packGUID[0] |= (1 << i);
                packGUID[size] =  (byte) (tguid & 0xFF);
                ++size;
            }

            tguid >>= 8;
        }
		getByteBuffer().writeBytes(packGUID,0,size);
	}
	
	/**
	 * Same as {@link SendablePacket#writeS(CharSequence)}, except that <code>'\000'</code> won't be written automatically.<br>
	 * So this way there is no need to concat multiple Strings into a single one.
	 *
	 * @param charSequence the char sequence
	 * @return the sendable packet
	 */
	protected final SendablePacket append(String charSequence)
	{
		putChars(charSequence);

		return this;
	}

	/**
	 * Write s.
	 *
	 * @param charSequence the char sequence
	 */
	protected final void writeS(String charSequence)
	{
		getByteBuffer().writeBytes(charSequence.getBytes());
		getByteBuffer().writeByte((byte) 0);
	}

	/**
	 * Put chars.
	 *
	 * @param charSequence the char sequence
	 */
	private void putChars(String charSequence)
	{
		if (charSequence == null)
			return;

		final int length = charSequence.length();
		for (int i = 0; i < length; i++)
			getByteBuffer().writeByte((byte)charSequence.charAt(i));
	}

	/**
	 * Write.
	 *
	 * @throws RuntimeException the runtime exception
	 */
	public void write() throws RuntimeException
	{
		writeC(this.opCode);
		writeImpl();
	}

	/**
	 * Write impl.
	 */
	protected abstract void writeImpl();

	/**
	 * Sets the channel.
	 *
	 * @param channel the new channel
	 */
	public void setChannel(NetworkChannel channel) {
		this.channel = channel;
		
	}
}
