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
package org.jmangos.commons.model;

import java.io.Serializable;

/**
 * @author MinimaJack
 * 
 */
@SuppressWarnings("serial")
public class UnitRegenModifier implements Serializable {

    private float flat;

    private float interrupted;

    public UnitRegenModifier() {

    }

    /**
     * @return the flat
     */
    public final float getFlat() {

        return this.flat;
    }

    /**
     * @param flat
     *        the flat to set
     */
    public final void setFlat(final float flat) {

        this.flat = flat;
    }

    /**
     * @return the interrupted
     */
    public final float getInterrupted() {

        return this.interrupted;
    }

    /**
     * @param interrupted
     *        the interrupted to set
     */
    public final void setInterrupted(final float interrupted) {

        this.interrupted = interrupted;
    }

}
