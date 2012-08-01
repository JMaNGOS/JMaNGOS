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
package org.jmangos.commons.log4j;

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
