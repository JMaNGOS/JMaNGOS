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
package org.jmangos.commons.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Skill_Tiers")
public class SkillTiersEntity {

    @Id
    @Column(name = "id")
    private Integer Id;
    @Column(name = "cost")
    private final int[] cost = new int[16];
    @Column(name = "maxValue")
    private final int[] maxValue = new int[16];

    public SkillTiersEntity() {

    }

    /**
     * @return the id
     */
    public final Integer getId() {

        return this.Id;
    }

    /**
     * @param id
     *        the id to set
     */
    public final void setId(final Integer id) {

        this.Id = id;
    }

    /**
     * @return the cost
     */
    public final int[] getCost() {

        return this.cost;
    }

    /**
     * @param cost
     *        the cost to set
     */
    public final void setCost(final int index, final int cost) {

        this.cost[index] = cost;
    }

    /**
     * @return the maxValue
     */
    public final int[] getMaxValue() {

        return this.maxValue;
    }

    /**
     * @param maxValue
     *        the maxValue to set
     */
    public final void setMaxValue(final int index, final int maxValue) {

        this.maxValue[index] = maxValue;
    }

}
