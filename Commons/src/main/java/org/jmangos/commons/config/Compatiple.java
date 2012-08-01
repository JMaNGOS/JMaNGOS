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
