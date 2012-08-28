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
package org.jmangos.realm;

import java.util.List;

import groovy.ui.Console;

import org.jmangos.commons.network.service.NetworkService;
import org.jmangos.commons.service.ServiceContent;
import org.jmangos.realm.entities.PlayerLevelInfo;
import org.jmangos.realm.service.ItemStorages;
import org.jmangos.realm.services.impl.PlayerLevelInfoServiceImpl;
import org.jmangos.realm.utils.ShutdownHook;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * The Class RealmServer.
 */
public class RealmServer {
    
    public static Console console;
    
    /**
     * The main method.
     * 
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
    
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("org.jmangos.commons", "org.jmangos.realm");
        context.refresh();
        ServiceContent.setContext(context);
        
        Runtime.getRuntime().addShutdownHook(context.getBean(ShutdownHook.class));
        System.gc();
        
        context.getBean(NetworkService.class).start();
        
        console = new Console();
        console.setVariable("applicationContext", context);
        console.setVariable("itemStorage", context.getBean(ItemStorages.class));
        // console.run();
    }
}
