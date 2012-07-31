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

package org.JMANGOS.common.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

public class ThrowableAsMessageLogger extends Logger
{
	
	/**
	 * Creates new instance of this logger.
	 *
	 * @param name logger's name
	 */
	protected ThrowableAsMessageLogger(String name)
	{
		super(name);
	}

	/**
	 * This method checks if message is instance of throwbale and throwable is null. If it is so it will move message to
	 * throwable and set localized message of throwable as message of the log record
	 * 
	 * @param fqcn
	 *            fully qualified class name, it would be used to get the line of call
	 * @param level
	 *            level of log record
	 * @param message
	 *            message of log record
	 * @param t
	 *            throwable, if any present
	 */
	@Override
	protected void forcedLog(String fqcn, Priority level, Object message, Throwable t)
	{

		if (message instanceof Throwable && t == null)
		{
			t = (Throwable) message;
			message = t.getLocalizedMessage();
		}

		super.forcedLog(fqcn, level, message, t);
	}

	/* (non-Javadoc)
	 * @see org.apache.log4j.Category#error(java.lang.Object)
	 */
	@Override
	public void error(Object message)
	{
		super.error(((String) message));
	}

	/* (non-Javadoc)
	 * @see org.apache.log4j.Category#error(java.lang.Object, java.lang.Throwable)
	 */
	@Override
	public void error(Object message, Throwable t)
	{
		super.error(((String) message), t);
	}
}
