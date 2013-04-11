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
package org.jmangos.commons.enums;

/**
 * 
 * @author MinimaJack
 * 
 */
public enum WeatherState {
    FINE(0),
    LIGHT_RAIN(3),
    MEDIUM_RAIN(4),
    HEAVY_RAIN(5),
    LIGHT_SNOW(6),
    MEDIUM_SNOW(7),
    HEAVY_SNOW(8),
    LIGHT_SANDSTORM(22),
    MEDIUM_SANDSTORM(41),
    HEAVY_SANDSTORM(42),
    THUNDERS(86),
    BLACKRAIN(90);

    private int value;

    WeatherState(final int val) {

        this.value = val;
    }

    /**
     * @return the value
     */
    public final int getValue() {

        return this.value;
    }

}
