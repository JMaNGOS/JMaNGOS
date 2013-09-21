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
package org.jmangos.realm.controller;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jmangos.commons.controller.WeatherController;
import org.jmangos.commons.model.base.Weather;
import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.jmangos.realm.network.packet.wow.server.SMSG_WEATHER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author MinimaJack
 * 
 */
@Component
public class WeatherControllerImpl implements WeatherController {

    @Autowired
    @Qualifier("nettyPacketSender")
    private AbstractPacketSender sender;

    @Override
    public ChannelBuffer buildWeatherData(final Weather weather) {
        final SMSG_WEATHER packet = new SMSG_WEATHER(weather);
        return this.sender.buildPacket(packet);
    }
}
