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
package org.jmangos.realm.network.packet.wow.server;

import org.jmangos.commons.model.base.Weather;
import org.jmangos.realm.network.packet.wow.AbstractWoWServerPacket;

/**
 * @author MinimaJack
 * 
 */
public class SMSG_WEATHER extends AbstractWoWServerPacket {

    private Weather weather;

    public SMSG_WEATHER() {}

    public SMSG_WEATHER(Weather weather) {
        this.setWeather(weather);
    }

    @Override
    protected void writeImpl() {
        writeD(weather.getState().getValue());
        writeF(weather.getGrade());
        writeC(0);
    }

    /**
     * @return the weather
     */
    public Weather getWeather() {
        return weather;
    }

    /**
     * @param weather the weather to set
     */
    public void setWeather(Weather weather) {
        this.weather = weather;
    }

}
