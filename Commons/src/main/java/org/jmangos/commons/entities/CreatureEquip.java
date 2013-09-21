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

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class <tt>CreatureEquip</tt>.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "creature_equip_template")
public class CreatureEquip implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3965466254149007916L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "entry")
    private int entry;

    @Column(name = "equipentry1")
    private int equipentry1;

    @Column(name = "equipentry2")
    private int equipentry2;

    @Column(name = "equipentry3")
    private int equipentry3;

    public CreatureEquip() {}

    /**
     * @return the entry
     */
    public final int getEntry() {
        return this.entry;
    }

    /**
     * @param entry
     *        the entry to set
     */
    public final void setEntry(final int entry) {
        this.entry = entry;
    }

    /**
     * @return the equipentry1
     */
    public final int getEquipentry1() {
        return this.equipentry1;
    }

    /**
     * @param equipentry1
     *        the equipentry1 to set
     */
    public final void setEquipentry1(final int equipentry1) {
        this.equipentry1 = equipentry1;
    }

    /**
     * @return the equipentry2
     */
    public final int getEquipentry2() {
        return this.equipentry2;
    }

    /**
     * @param equipentry2
     *        the equipentry2 to set
     */
    public final void setEquipentry2(final int equipentry2) {
        this.equipentry2 = equipentry2;
    }

    /**
     * @return the equipentry3
     */
    public final int getEquipentry3() {
        return this.equipentry3;
    }

    /**
     * @param equipentry3
     *        the equipentry3 to set
     */
    public final void setEquipentry3(final int equipentry3) {
        this.equipentry3 = equipentry3;
    }

}
