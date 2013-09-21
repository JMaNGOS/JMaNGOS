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
/**
 * 
 */
package org.jmangos.auth.realm.container;

import org.jmangos.commons.dataholder.IdKeyContainer;
import org.jmangos.commons.model.RealmInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author MinimaJack
 * 
 */
public class RealmServersContainer extends IdKeyContainer<RealmInfo> {

    /** Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(RealmServersContainer.class);

    @Override
    public void onDataNotPresentEvent(final long objectId) {

        logger.error("Realm with id {} not exist in container.", objectId);

    }

    @Override
    public void onDataAlreadyAddedEvent(final long objectId) {

        logger.error("Realm server already in container. Duplicate Id : {}", objectId);

    }
}
