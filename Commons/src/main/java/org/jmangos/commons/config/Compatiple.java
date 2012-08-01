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
package org.jmangos.commons.config;

// TODO: Auto-generated Javadoc
/**
 * The Enum Compatiple.
 *
 * @author MinimaJack
 */
public enum Compatiple {
	
	/** The NONE. */
	NONE(0x00),
	
	/** The MANGOS. */
	MANGOS(0x01);
	
	/** The message id. */
	private int messageId;

	/**
	 * Instantiates a new compatiple.
	 *
	 * @param messageId the message id
	 */
	Compatiple(int messageId) {
		this.messageId = messageId;
	}

	/**
	 * Gets the message id.
	 *
	 * @return the message id
	 */
	public int getMessageId()
	{
		return messageId;
	}
}
