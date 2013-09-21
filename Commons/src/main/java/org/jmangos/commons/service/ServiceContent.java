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
package org.jmangos.commons.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * The Class ServiceContent.
 */
@Component
public final class ServiceContent implements ApplicationContextAware {

    private static ApplicationContext context;

    /**
     * @param context
     *        the context to set
     */
    public static final void setContext(final ApplicationContext context) {
        ServiceContent.context = context;
    }

    public static ApplicationContext getContext() {

        return ServiceContent.context;
    }

    @Override
    public void setApplicationContext(final ApplicationContext context) throws BeansException {
        ServiceContent.context = context;
    }

}
