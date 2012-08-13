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
/**
 * 
 */
package org.jmangos.auth.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.LogManager;

import org.apache.commons.lang.NotImplementedException;
import org.apache.log4j.Hierarchy;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.jmangos.commons.log4j.ThrowableAsMessageAwareFactory;
import org.jmangos.commons.log4j.exception.Log4jInitializationError;
import org.jmangos.commons.service.Service;

/**
 * The Class LoggingService.
 * 
 * @author MinimaJack
 */

public class LoggingService implements Service {
	/**
	 * Property that represents {@link org.apache.log4j.spi.LoggerFactory} class
	 */
	public static final String LOGGER_FACTORY_CLASS_PROPERTY = "log4j.loggerfactory";

	/** Default log4j configuration file. */
	public static final String LOGGER_CONFIG_FILE = "./config/log4j.xml";

	/** Is Logging initialized or not?. */
	private static boolean initialized;

	/**
	 * Initializes logging system with {@link #LOGGER_CONFIG_FILE default}
	 * config file.
	 * 
	 * @throws Log4jInitializationError
	 *             the log4j initialization error
	 */
	public void start() throws Log4jInitializationError {
        InputStream is = LoggingService.class.getResourceAsStream("/logging.properties");
        try {
            LogManager manager = LogManager.getLogManager();
            manager.readConfiguration(is);
        } catch (IOException e) {
            Logger.getLogger(getClass()).fatal( "logging.properties not found in the classpath! Please restore it!" );
        } finally {
            // FindBugs warning fix...
            if ( is != null )
                try {
                    is.close();
                } catch (IOException e) {
                    // It will be never thrown
                    Logger.getLogger(getClass()).fatal( "Can't close the logging.properties resource stream!" );
                }
        }

		File f = new File(LOGGER_CONFIG_FILE);

		if (!f.exists()) {
			throw new Log4jInitializationError("Missing file " + f.getPath());
		}

		try {
			init(f.toURI().toURL());
		} catch (MalformedURLException e) {
			throw new Log4jInitializationError("Can't initalize logging", e);
		}
	}

	/**
	 * 
	 * @param url
	 *            the url
	 * @throws Log4jInitializationError
	 *             the log4j initialization error
	 */
	public static void init(URL url) throws Log4jInitializationError {
		synchronized (LoggingService.class) {
			if (initialized) {
				return;
			} else {
				initialized = true;
			}
		}

		try {
			DOMConfigurator.configure(url);
		} catch (Exception e) {
			throw new Log4jInitializationError("Can't initialize logging", e);
		}

		overrideDefaultLoggerFactory();

		/** JULI bridge configured via slf4j bridge */
	}

	/**
	 * Override default logger factory.
	 */
	private static void overrideDefaultLoggerFactory() {
		Hierarchy lr = (Hierarchy) org.apache.log4j.LogManager
				.getLoggerRepository();
		try {
			Field field = lr.getClass().getDeclaredField("defaultFactory");
			field.setAccessible(true);
			String cn = System.getProperty(LOGGER_FACTORY_CLASS_PROPERTY,
					ThrowableAsMessageAwareFactory.class.getName());
			Class<?> c = Class.forName(cn);
			field.set(lr, c.newInstance());
			field.setAccessible(false);
		} catch (NoSuchFieldException e) {
			// never thrown
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// never thrown
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			throw new Log4jInitializationError(
					"Can't found log4j logger factory class", e);
		} catch (InstantiationException e) {
			throw new Log4jInitializationError(
					"Can't instantiate log4j logger factory", e);
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.jmangos.commons.service.Service#stop()
	 */
	@Override
	public void stop() {
		throw new NotImplementedException();
	}
}
