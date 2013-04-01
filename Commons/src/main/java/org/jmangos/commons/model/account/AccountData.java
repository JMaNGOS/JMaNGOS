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
package org.jmangos.commons.model.account;

/**
 * The Class AccountData.
 */
public class AccountData {

    /** The Time. */
    int Time;

    /** The Data. */
    String Data;

    /**
     * Gets the time.
     * 
     * @return the time
     */
    public final int getTime() {

        return this.Time;
    }

    /**
     * Sets the time.
     * 
     * @param time
     *        the new time
     */
    public final void setTime(final int time) {

        this.Time = time;
    }

    /**
     * Gets the data.
     * 
     * @return the data
     */
    public final String getData() {

        return this.Data;
    }

    /**
     * Sets the data.
     * 
     * @param data
     *        the new data
     */
    public final void setData(final String data) {

        this.Data = data;
    }

}
