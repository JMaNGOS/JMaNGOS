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
package org.jmangos.commons.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author MinimaJack
 * 
 */
@Entity
@Table(name = "game_event_creature")
public class GameEventCreature {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "guid")
    private int guid;
    @Column(name = "event")
    private int event;

    /**
     * @return the guid
     */
    public final int getGuid() {
        return this.guid;
    }

    /**
     * @param guid
     *        the guid to set
     */
    public final void setGuid(final int guid) {
        this.guid = guid;
    }

    /**
     * @return the event
     */
    public final int getEvent() {
        return this.event;
    }

    /**
     * @param event
     *        the event to set
     */
    public final void setEvent(final int event) {
        this.event = event;
    }

}
