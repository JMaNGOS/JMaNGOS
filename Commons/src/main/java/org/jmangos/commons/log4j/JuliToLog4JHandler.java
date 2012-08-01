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
package org.jmangos.commons.log4j;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;


// TODO: Auto-generated Javadoc
/**
 * The Class JuliToLog4JHandler.
 */
public class JuliToLog4JHandler extends Handler
{
	/**
	 * Forwards JULI LogRecord to Log4J. This method resolves needed log4j level and fixes caller class issue so methods
	 * and lines are correctly displayed by log4j.
	 * 
	 * @param record
	 *            LogRecord to forward
	 */
	@Override
	public void publish(LogRecord record)
	{
		String loggerName = record.getLoggerName();
		if (loggerName == null)
		{
			loggerName = "";
		}

		Logger log = Logger.getLogger(loggerName);
		org.apache.log4j.Level level = toLog4jLevel(record.getLevel());
		log.log(java.util.logging.Logger.class.getName(), level, record.getMessage(), record.getThrown());
	}

	/**
	 * Converts JULI level to Log4J level.<br>
	 * 
	 * @param juliLevel
	 *            level that should be converted to log4j
	 * @return Log4J level
	 */
	protected org.apache.log4j.Level toLog4jLevel(Level juliLevel)
	{
		if (Level.OFF.equals(juliLevel))
		{
			return org.apache.log4j.Level.OFF;
		}
		else if (Level.SEVERE.equals(juliLevel))
		{
			return org.apache.log4j.Level.ERROR;
		}
		else if (Level.WARNING.equals(juliLevel))
		{
			return org.apache.log4j.Level.WARN;
		}
		else if (Level.INFO.equals(juliLevel))
		{
			return org.apache.log4j.Level.INFO;
		}
		else if (Level.CONFIG.equals(juliLevel) || Level.FINE.equals(juliLevel))
		{
			return org.apache.log4j.Level.DEBUG;
		}
		else if (Level.FINER.equals(juliLevel) || Level.FINEST.equals(juliLevel))
		{
			return org.apache.log4j.Level.TRACE;
		}
		else if (Level.ALL.equals(juliLevel))
		{
			return org.apache.log4j.Level.ALL;
		}
		else
		{
			// noinspection ThrowableInstanceNeverThrown
			LogLog.warn("Warning: usage of custom JULI level: " + juliLevel.getName(), new Exception());
			// Custom JULI Levels are cause of memory leaks with classloaders
			// Should not be used...
			// see:
			// http://blogs.sun.com/fkieviet/entry/classloader_leaks_the_dreaded_java
			// see: http://blogs.sun.com/fkieviet/entry/how_to_fix_the_dreaded
			// see:
			// http://blogs.sun.com/edwardchou/entry/javaone_bof_on_memory_leaks
			return new CustomLog4jLevel(juliLevel.intValue(), juliLevel.getName(), juliLevel.intValue());
		}
	}

	/**
	 * This method does nothing.
	 */
	@Override
	public void flush()
	{
		// do nothing
	}

	/**
	 * This method does nothing.
	 *
	 * @throws SecurityException never thrown
	 */
	@Override
	public void close() throws SecurityException
	{
		// do nothing
	}

	/**
	 * This class represents cutom level in Log4J. In best case it shouldn't be used at all.
	 */
	protected static class CustomLog4jLevel extends org.apache.log4j.Level
	{
		
		/** SerialID. */
		private static final long	serialVersionUID	= 4014557380173323844L;

		/**
		 * Creates new Level of logging for Log4J.
		 *
		 * @param level integer value of level
		 * @param levelStr name of level
		 * @param syslogEquivalent System log equvalent of level
		 */
		protected CustomLog4jLevel(int level, String levelStr, int syslogEquivalent)
		{
			super(level, levelStr, syslogEquivalent);
		}
	}
}
