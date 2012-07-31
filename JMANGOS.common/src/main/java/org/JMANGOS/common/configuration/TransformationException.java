/*******************************************************************************
 * Copyright (c) 2011 WoWEmu
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *    WoWEmu  - initial API and implementation
 ******************************************************************************/

package org.JMANGOS.common.configuration;


public class TransformationException extends RuntimeException
{
	
	/** SerialID. */
	private static final long	serialVersionUID	= -6641235751743285902L;

	/**
	 * Creates new instance of exception.
	 */
	public TransformationException()
	{
	}

	/**
	 * Creates new instance of exception.
	 *
	 * @param message exception message
	 */
	public TransformationException(String message)
	{
		super(message);
	}

	/**
	 * Creates new instance of exception.
	 *
	 * @param message exception message
	 * @param cause exception that is the reason of this exception
	 */
	public TransformationException(String message, Throwable cause)
	{
		super(message, cause);
	}

	/**
	 * Creates new instance of exception.
	 *
	 * @param cause exception that is the reason of this exception
	 */
	public TransformationException(Throwable cause)
	{
		super(cause);
	}
}
