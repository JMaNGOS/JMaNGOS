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
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.jmangos.commons.enums.Classes;
import org.jmangos.commons.enums.Gender;
import org.jmangos.commons.enums.Races;

@SuppressWarnings("serial")
@Embeddable
public class CharClassRaceGender implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7105692996985287851L;

    @Column(name = "clazz", nullable = false, insertable = true, updatable = true)
    @Enumerated(EnumType.ORDINAL)
    public Classes clazz;

    @Column(name = "gender", nullable = true, insertable = true, updatable = true)
    @Enumerated(EnumType.ORDINAL)
    public Gender gender;

    @Column(name = "race", nullable = true, insertable = true, updatable = true)
    @Enumerated(EnumType.ORDINAL)
    public Races race;

    /**
     * @return the clazz
     */
    public final Classes getClazz() {

        return this.clazz;
    }

    /**
     * @param clazz
     *        the clazz to set
     */
    public final void setClazz(final Classes clazz) {

        this.clazz = clazz;
    }

    /**
     * @return the gender
     */
    public final Gender getGender() {

        return this.gender;
    }

    /**
     * @param gender
     *        the gender to set
     */
    public final void setGender(final Gender gender) {

        this.gender = gender;
    }

    /**
     * @return the race
     */
    public final Races getRace() {

        return this.race;
    }

    /**
     * @param race
     *        the race to set
     */
    public final void setRace(final Races race) {

        this.race = race;
    }

    @Override
    public boolean equals(final Object obj) {

        if (!(obj instanceof CharClassRaceGender)) {
            return false;
        }

        return ((CharClassRaceGender) obj).getGender().equals(getGender()) &&
            ((CharClassRaceGender) obj).getClazz().equals(getClazz()) &&
            ((CharClassRaceGender) obj).getRace().equals(getRace());
    }

    @Override
    public int hashCode() {

        return (getRace().getValue() << 16) | (getClazz().getValue() << 8) | getGender().ordinal();
    }
}
