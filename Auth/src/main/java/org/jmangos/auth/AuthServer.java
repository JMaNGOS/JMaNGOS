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
package org.jmangos.auth;

import java.util.List;

import org.criteria4jpa.criterion.Criterion;
import org.criteria4jpa.criterion.Restrictions;
import org.jmangos.auth.model.AccountDto;
import org.jmangos.auth.services.AccountService;
import org.jmangos.auth.services.impl.AccountServiceImpl;
import org.jmangos.auth.utils.ShutdownHook;
import org.jmangos.commons.network.netty.service.NetworkService;
import org.jmangos.commons.service.ServiceContent;
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
     *            the arguments
     * @throws Exception
     *             the exception
     */
    public static void main(final String[] args) throws Exception {
    
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("org.jmangos.commons", "org.jmangos.auth");
        context.refresh();
        ServiceContent.setContext(context);
        
        Runtime.getRuntime().addShutdownHook(context.getBean(ShutdownHook.class));
        System.gc();
        context.getBean(NetworkService.class).start();
        final Criterion c = Restrictions.eq("username", new String("PLAYER"));
        System.out.println();
        final AccountService accountService = context.getBean("accountService2", AccountServiceImpl.class);
        System.out.println();
        final AccountDto accountDto = accountService.readAccount((long) 2);
        System.out.println();
        final List<AccountDto> accountDtos = accountService.readAccounts(c);
        System.out.println();
    }
}