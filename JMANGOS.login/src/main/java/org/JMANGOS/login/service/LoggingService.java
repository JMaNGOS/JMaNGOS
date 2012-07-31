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
/**
 * 
 */
package org.JMANGOS.login.service;

import java.io.File;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.apache.commons.lang.NotImplementedException;
import org.apache.log4j.Hierarchy;
import org.apache.log4j.xml.DOMConfigurator;
import org.JMANGOS.common.log4j.JuliToLog4JHandler;
import org.JMANGOS.common.log4j.ThrowableAsMessageAwareFactory;
import org.JMANGOS.common.log4j.exception.Log4jInitializationError;
import org.JMANGOS.common.service.Service;



// TODO: Auto-generated Javadoc
/**
 * The Class LoggingService.
 *
 * @author admin
 */
public class LoggingService implements Service 
{
	/**
	 * Property that represents {@link org.apache.log4j.spi.LoggerFactory} class
	 */
	public static final String	LOGGER_FACTORY_CLASS_PROPERTY	= "log4j.loggerfactory";

	/** Default log4j configuration file. */
	public static final String	LOGGER_CONFIG_FILE				= "./config/log4j.xml";

	/** Is Logging initialized or not?. */
	private static boolean		initialized;

	/**
	 * Initializes logging system with {@link #LOGGER_CONFIG_FILE default} config file.
	 *
	 * @throws Log4jInitializationError the log4j initialization error
	 */
	public void start() throws Log4jInitializationError
	{
		File f = new File(LOGGER_CONFIG_FILE);

		if (!f.exists())
		{
			throw new Log4jInitializationError("Missing file " + f.getPath());
		}

		try
		{
			init(f.toURI().toURL());
		}
		catch (MalformedURLException e)
		{
			throw new Log4jInitializationError("Can't initalize logging", e);
		}
	}
	
	/**
	 * Inits the.
	 *
	 * @param url the url
	 * @throws Log4jInitializationError the log4j initialization error
	 */
	public static void init(URL url) throws Log4jInitializationError
	{
		synchronized (LoggingService.class)
		{
			if (initialized)
			{
				return;
			}
			else
			{
				initialized = true;
			}
		}

		try
		{
			DOMConfigurator.configure(url);
		}
		catch (Exception e)
		{
			throw new Log4jInitializationError("Can't initialize logging", e);
		}

		overrideDefaultLoggerFactory();

		Logger logger = LogManager.getLogManager().getLogger("");
		for (Handler h : logger.getHandlers())
		{
			logger.removeHandler(h);
		}

		logger.addHandler(new JuliToLog4JHandler());
	}
	
	/**
	 * Override default logger factory.
	 */
	private static void overrideDefaultLoggerFactory()
	{
		// Hack here, we have to overwrite default logger factory
		Hierarchy lr = (Hierarchy) org.apache.log4j.LogManager.getLoggerRepository();
		try
		{
			Field field = lr.getClass().getDeclaredField("defaultFactory");
			field.setAccessible(true);
			String cn = System.getProperty(LOGGER_FACTORY_CLASS_PROPERTY, ThrowableAsMessageAwareFactory.class.getName());
			Class<?> c = Class.forName(cn);
			field.set(lr, c.newInstance());
			field.setAccessible(false);
		}
		catch (NoSuchFieldException e)
		{
			// never thrown
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			// never thrown
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			throw new Log4jInitializationError("Can't found log4j logger factory class", e);
		}
		catch (InstantiationException e)
		{
			throw new Log4jInitializationError("Can't instantiate log4j logger factory", e);
		}
	}
	/* (non-Javadoc)
	 * @see org.wowemu.common.service.Service#stop()
	 */
	@Override
	public void stop() {
		throw new NotImplementedException();
	}
}
