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
package org.jmangos.world.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class <tt>PlayerXpForLevelEntity</tt>.
 */
@Entity
@Table(name = "player_xp_for_level")
public class PlayerXpForLevel {
    
    @Id
    @Column(name = "lvl", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    private Byte level;
    
    @Basic
    @Column(name = "xp_for_next_level", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private int  xpForNextLevel;
    
    /**
     * Initialize Persistent entity
     */
    public PlayerXpForLevel() {
    
    }

    
    /**
     * @return the level
     */
    public final Byte getLevel() {
    
        return level;
    }

    
    /**
     * @param level the level to set
     */
    public final void setLevel(final byte level) {
    
        this.level = level;
    }

    
    /**
     * @return the xpForNextLevel
     */
    public final int getXpForNextLevel() {
    
        return xpForNextLevel;
    }

    
    /**
     * @param xpForNextLevel the xpForNextLevel to set
     */
    public final void setXpForNextLevel(final int xpForNextLevel) {
    
        this.xpForNextLevel = xpForNextLevel;
    }
    
}
