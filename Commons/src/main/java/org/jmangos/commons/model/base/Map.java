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
package org.jmangos.commons.model.base;

import gnu.trove.procedure.TObjectProcedure;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jmangos.commons.controller.CharacterController;
import org.jmangos.commons.controller.WeatherController;
import org.jmangos.commons.entities.CharacterData;
import org.jmangos.commons.entities.Position;
import org.jmangos.commons.enums.WeatherState;
import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * The Class Map.
 */
@Component
@Scope(value = "prototype")
@Lazy(value = true)
public class Map extends NestedMap {

    Weather weather = new Weather();

    // Dynamic creation...so better use setters
    @Autowired
    CharacterController characterController;
    @Autowired
    @Qualifier("nettyPacketSender")
    AbstractPacketSender sender;
    @Autowired
    WeatherController weatherController;

    private Position leftCorner;
    private Position rightCorner;

    /**
     * Instantiates a new map.
     * 
     * @param id
     *        the id
     */
    public Map() {

        super();
    }

    public String toString(final StringBuilder sbuilder, final String indent) {
        sbuilder.append(indent).append("[" + getId() + "]").append(getName()).append("\n");
        getSubArea().forEachValue(new TObjectProcedure<NestedMap>() {

            @Override
            public boolean execute(final NestedMap object) {
                ((Map) object).toString(sbuilder, indent + "\t");
                return true;
            }
        });

        return sbuilder.toString();
    }

    /**
     * @return the characterController
     */
    public CharacterController getCharacterController() {
        return this.characterController;
    }

    /**
     * @param characterController
     *        the characterController to set
     */
    public void setCharacterController(final CharacterController characterController) {
        this.characterController = characterController;
    }

    /**
     * @return the weather
     */
    public final Weather getWeather() {
        return this.weather;
    }

    /**
     * @param weather
     *        the weather to set
     */
    public final void setWeather(final Weather weather) {
        this.weather = weather;
    }

    /**
     * @return the weatherController
     */
    public final WeatherController getWeatherController() {
        return this.weatherController;
    }

    /**
     * @param weatherController
     *        the weatherController to set
     */
    public final void setWeatherController(final WeatherController weatherController) {
        this.weatherController = weatherController;
    }

    /**
     * @return the sender
     */
    public final AbstractPacketSender getSender() {
        return this.sender;
    }

    /**
     * @param sender
     *        the sender to set
     */
    public final void setSender(final AbstractPacketSender sender) {
        this.sender = sender;
    }

    /**
     * Update.
     * 
     * @return true, if successful
     */
    @Override
    public boolean update() {
        for (final Object pl : getPlayerList().values()) {
            this.characterController.update((CharacterData) pl);
        };
        final long time = System.currentTimeMillis();
        // TODO: move weather change time to config
        // now for test set only rain
        if ((time - getWeather().getLastUpdateTime()) > 150000) {
            getWeather().setLastUpdateTime(time);
            getWeather().setState(WeatherState.HEAVY_RAIN);
            getWeather().setGrade(1f);
            final ChannelBuffer data = this.weatherController.buildWeatherData(getWeather());

            for (final Object pl : getPlayerList().values()) {
                this.sender.send(((CharacterData) pl).getPlayer().getChannel(), data);
            };
        }
        return true;
    }

    /**
     * @return the leftCorner
     */
    public final Position getLeftCorner() {
        return this.leftCorner;
    }

    /**
     * @param leftCorner
     *        the leftCorner to set
     */
    public final void setLeftCorner(final Position leftCorner) {
        this.leftCorner = leftCorner;
    }

    /**
     * @return the rightCorner
     */
    public final Position getRightCorner() {
        return this.rightCorner;
    }

    /**
     * @param rightCorner
     *        the rightCorner to set
     */
    public final void setRightCorner(final Position rightCorner) {
        this.rightCorner = rightCorner;
    }

}
