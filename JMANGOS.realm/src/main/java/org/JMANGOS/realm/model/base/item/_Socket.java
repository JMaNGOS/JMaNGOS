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
package org.JMANGOS.realm.model.base.item;

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
	 * @param color the color
	 * @param content the content
	 */
	public _Socket(byte color, int content) {
		Color = color;
		Content = content;
	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public byte getColor() {
		return Color;
	}

	/**
	 * Sets the color.
	 *
	 * @param color the color to set
	 */
	public void setColor(byte color) {
		Color = color;
	}

	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public int getContent() {
		return Content;
	}

	/**
	 * Sets the content.
	 *
	 * @param content the content to set
	 */
	public void setContent(int content) {
		Content = content;
	}

}

