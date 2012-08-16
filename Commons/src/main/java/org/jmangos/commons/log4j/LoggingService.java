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

import java.io.File;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.lang.NotImplementedException;
import org.apache.log4j.Hierarchy;
import org.apache.log4j.xml.DOMConfigurator;
import org.jmangos.commons.log4j.exception.Log4jInitializationError;
import org.jmangos.commons.service.Service;

import com.google.inject.Singleton;

/**
 * The Class LoggingService.
 * 
 * @author MinimaJack
 */
@Singleton
public class LoggingService implements Service {
    
    /**
     * Property that represents {@link org.apache.log4j.spi.LoggerFactory} class
     */
    public static final String LOGGER_FACTORY_CLASS_PROPERTY = "log4j.loggerfactory";
    
    /** Default log4j configuration file. */
    public static final String LOGGER_CONFIG_FILE            = "./conf/log4j.xml";
    
    /** Is Logging initialized or not?. */
    private static boolean     initialized;
    
    /**
     * Initializes logging system with {@link #LOGGER_CONFIG_FILE default} config file.
     * 
     * @throws Log4jInitializationError
     *             the log4j initialization error
     */
    @Override
    public void start() throws Log4jInitializationError {
    
        final File f = new File(LOGGER_CONFIG_FILE);
        
        if (!f.exists()) {
            throw new Log4jInitializationError("Missing file " + f.getPath());
        }
        
        try {
            init(f.toURI().toURL());
        } catch (final MalformedURLException e) {
            throw new Log4jInitializationError("Can't initalize logging", e);
        }
    }
    
    /**
     * Inits the.
     * 
     * @param url
     *            the url
     * @throws Log4jInitializationError
     *             the log4j initialization error
     */
    public static void init(final URL url) throws Log4jInitializationError {
    
        synchronized (LoggingService.class) {
            if (initialized) {
                return;
            } else {
                initialized = true;
            }
        }
        
        try {
            DOMConfigurator.configure(url);
        } catch (final Exception e) {
            throw new Log4jInitializationError("Can't initialize logging", e);
        }
        
        overrideDefaultLoggerFactory();
        
        // Initialize JULI to Log4J bridge
        /** configured via slf4j bridge */
    }
    
    /**
     * Override default logger factory.
     */
    private static void overrideDefaultLoggerFactory() {
    
        // Hack here, we have to overwrite default logger factory
        final Hierarchy lr = (Hierarchy) org.apache.log4j.LogManager.getLoggerRepository();
        try {
            final Field field = lr.getClass().getDeclaredField("defaultFactory");
            field.setAccessible(true);
            final String cn = System.getProperty(LOGGER_FACTORY_CLASS_PROPERTY, ThrowableAsMessageAwareFactory.class.getName());
            final Class<?> c = Class.forName(cn);
            field.set(lr, c.newInstance());
            field.setAccessible(false);
        } catch (final NoSuchFieldException e) {
            // never thrown
            e.printStackTrace();
        } catch (final IllegalAccessException e) {
            // never thrown
            e.printStackTrace();
        } catch (final ClassNotFoundException e) {
            throw new Log4jInitializationError("Can't found log4j logger factory class", e);
        } catch (final InstantiationException e) {
            throw new Log4jInitializationError("Can't instantiate log4j logger factory", e);
        }
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.wowemu.common.service.Service#stop()
     */
    @Override
    public void stop() {
    
        throw new NotImplementedException();
        
    }
}
