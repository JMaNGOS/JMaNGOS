/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
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
 ******************************************************************************/
package org.jmangos.auth;

import org.jmangos.commons.network.service.NetworkService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * The Class AuthServer.
 * 
 * @author MinimaJack
 */
public class AuthServer {

    /**
     * The main method.
     * 
     * @param args
     *        the arguments
     * @throws Exception
     *         the exception
     */
    public static void main(final String[] args) throws Exception {

        @SuppressWarnings("resource")
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("org.jmangos.commons", "org.jmangos.auth");
        context.refresh();
        context.getBean(NetworkService.class).start();
    }
}
