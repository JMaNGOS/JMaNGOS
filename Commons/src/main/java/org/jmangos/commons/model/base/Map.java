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

import gnu.trove.map.hash.TLongObjectHashMap;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jmangos.commons.controller.CharacterController;
import org.jmangos.commons.controller.WeatherController;
import org.jmangos.commons.entities.CharacterData;
import org.jmangos.commons.entities.FieldsObject;
import org.jmangos.commons.enums.WeatherState;
import org.jmangos.commons.network.sender.AbstractPacketSender;

/**
 * The Class Map.
 */
public class Map {

    /** The id. */
    int id = 0;

    Weather weather = new Weather();

    /** The player list. */
    TLongObjectHashMap<FieldsObject> playerList = new TLongObjectHashMap<FieldsObject>();

    /** The units. */
    TLongObjectHashMap<FieldsObject> units = new TLongObjectHashMap<FieldsObject>();

    // Dynamic creation...so better use setters
    private CharacterController characterController;
    private AbstractPacketSender sender;
    private WeatherController weatherController;

    /**
     * Instantiates a new map.
     * 
     * @param id
     *        the id
     */
    public Map(final int id) {

        super();
        this.id = id;
    }

    /**
     * Adds the object.
     * 
     * @param plObject
     *        the pl object
     */
    public void addObject(final FieldsObject plObject) {

        switch (plObject.getTypeId()) {
            case PLAYER:
                this.playerList.put(plObject.getGuid(), plObject);
            break;
            case UNIT:
                this.units.put(plObject.getGuid(), plObject);
            break;
            default:
            break;
        }

    }

    /**
     * Adds the object.
     * 
     * @param plObject
     *        the pl object
     */
    public void removeObject(final FieldsObject plObject) {

        switch (plObject.getTypeId()) {
            case PLAYER:
                this.playerList.remove(plObject.getGuid());
            break;
            case UNIT:
                this.units.remove(plObject.getGuid());
            break;
            default:
            break;
        }

    }

    /**
     * Update.
     * 
     * @return true, if successful
     */
    public boolean update() {

        for (final Object pl : this.playerList.values()) {
            this.characterController.update((CharacterData) pl);
        };
        final long time = System.currentTimeMillis();
        // TODO: move weather change time to config
        // now for test set only rain
        if ((time - getWeather().getLastUpdateTime()) > 15000) {
            getWeather().setLastUpdateTime(time);
            getWeather().setState(WeatherState.HEAVY_RAIN);
            getWeather().setGrade(1f);
            final ChannelBuffer data = this.weatherController.buildWeatherData(getWeather());

            for (final Object pl : this.playerList.values()) {
                this.sender.send(((CharacterData) pl).getPlayer().getChannel(), data);
            };
        }
        return true;
    }

    /**
     * @return the id
     */
    public final int getId() {

        return this.id;
    }

    /**
     * @param id
     *        the id to set
     */
    public final void setId(final int id) {

        this.id = id;
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

}
