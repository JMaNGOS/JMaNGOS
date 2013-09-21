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
package org.jmangos.commons.model.container;

import org.jmangos.commons.dataholder.IdNameKeyContainer;
import org.jmangos.commons.model.AccountInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountsContainer extends IdNameKeyContainer<AccountInfo> {

    /** Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(AccountsContainer.class);

    @Override
    public void onDataNotPresentEvent(final long objectId) {

        logger.error("Account with id {} not exist in container.", objectId);

    }

    @Override
    public void onDataAlreadyAddedEvent(final long objectId) {

        logger.error("Account data already in container. Duplicate Id : {}", objectId);

    }

}
