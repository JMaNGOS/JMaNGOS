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
package org.jmangos.commons.database;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.jmangos.commons.service.Service;
import org.springframework.stereotype.Component;

@Component
public class DatabaseFactory implements Service {
    
    /** Logger for this class. */
    private static final Logger   log = LoggerFactory.getLogger(DatabaseFactory.class);
    
    /** Database config */
    @Inject
    private DatabaseConfig        databaseConfig;
    
    /**
     * Returns Hibernate Session
     */
    private static SessionFactory worldSessionFactory;
    private static SessionFactory charactersSessionFactory;
    
    /**
     * Initializes DatabaseFactory.
     */
    @PostConstruct
    @Override
    public synchronized void start() {
    
        // Loading config fields
    }
    
    /**
     * Shuts down pool and closes connections.
     */
    @Override
    public synchronized void stop() {
    
        try {
            if (worldSessionFactory != null) {
                worldSessionFactory.close();
            }
            if (charactersSessionFactory != null) {
                charactersSessionFactory.close();
            }
        } catch (final Exception e) {
            log.warn("Failed to shutdown DatabaseFactory", e);
        }
        
        worldSessionFactory = null;
        charactersSessionFactory = null;
    }
    
    /**
     * Returns World Database's hibernate session
     * 
     * @return Hibernate Session
     */
    public synchronized SessionFactory getWorldSessionFactory() {
    
        if (worldSessionFactory == null) {
            final AnnotationConfiguration config = new AnnotationConfiguration();
            config.setProperty("hibernate.connection.driver_class", this.databaseConfig.WORLD_DATABASE_DRIVER);
            config.setProperty("hibernate.connection.url", this.databaseConfig.WORLD_DATABASE_URL + this.databaseConfig.WORLD_DATABASE_NAME
                    + "?autoReconnect=true");
            config.setProperty("hibernate.connection.username", this.databaseConfig.WORLD_DATABASE_USER);
            config.setProperty("hibernate.connection.password", this.databaseConfig.WORLD_DATABASE_PASSWORD);
            config.setProperty("hibernate.dialect", this.databaseConfig.WORLD_DATABASE_DIALECT);
            config.setProperty("hibernate.c3p0.min_size", this.databaseConfig.WORLD_DATABASE_CONNECTIONS_MIN.toString());
            config.setProperty("hibernate.c3p0.max_size", this.databaseConfig.WORLD_DATABASE_CONNECTIONS_MAX.toString());
            config.configure("/world.cfg.xml");
            worldSessionFactory = config.buildSessionFactory();
            worldSessionFactory.getStatistics().setStatisticsEnabled(true);
            
            log.info("Hibernate worldSessionFactory initialized...");
        }
        
        return worldSessionFactory;
    }
    
    /**
     * Returns Character Database's hibernate session
     * 
     * @return Hibernate Session
     */
    public synchronized SessionFactory getCharactersSessionFactory() {
    
        if (charactersSessionFactory == null) {
            // Bring up hibernate
            
            final AnnotationConfiguration config = new AnnotationConfiguration();
            config.setProperty("hibernate.connection.driver_class", this.databaseConfig.CHARS_DATABASE_DRIVER);
            config.setProperty("hibernate.connection.url", this.databaseConfig.CHARS_DATABASE_URL + this.databaseConfig.CHARS_DATABASE_NAME
                    + "?autoReconnect=true");
            config.setProperty("hibernate.connection.username", this.databaseConfig.CHARS_DATABASE_USER);
            config.setProperty("hibernate.connection.password", this.databaseConfig.CHARS_DATABASE_PASSWORD);
            config.setProperty("hibernate.dialect", this.databaseConfig.CHARS_DATABASE_DIALECT);
            config.setProperty("hibernate.c3p0.min_size", this.databaseConfig.CHARS_DATABASE_CONNECTIONS_MIN.toString());
            config.setProperty("hibernate.c3p0.max_size", this.databaseConfig.CHARS_DATABASE_CONNECTIONS_MAX.toString());
            config.configure("/characters.cfg.xml");
            
            charactersSessionFactory = config.buildSessionFactory();
            charactersSessionFactory.getStatistics().setStatisticsEnabled(true);
            log.info("Hibernate charactersSessionFactory initialized...");
        }
        
        return charactersSessionFactory;
    }
    
}
