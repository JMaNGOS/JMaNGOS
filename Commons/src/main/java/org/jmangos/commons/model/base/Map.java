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

import gnu.trove.map.hash.TIntObjectHashMap;
import gnu.trove.map.hash.TLongObjectHashMap;
import gnu.trove.procedure.TIntProcedure;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jmangos.commons.controller.CharacterController;
import org.jmangos.commons.controller.WeatherController;
import org.jmangos.commons.entities.CharacterData;
import org.jmangos.commons.entities.FieldsObject;
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
@Component("Map")
@Scope(value = "prototype")
@Lazy(value = true)
@Qualifier("Map")
public class Map {

    /** The id. */
    int id = 0;

    Weather weather = new Weather();

    /** The player list. */
    TLongObjectHashMap<FieldsObject> playerList = new TLongObjectHashMap<FieldsObject>();

    /** The units. */
    TLongObjectHashMap<FieldsObject> units = new TLongObjectHashMap<FieldsObject>();

    TIntObjectHashMap<Area> subArea = new TIntObjectHashMap<>();

    // Dynamic creation...so better use setters
    @Autowired
    private CharacterController characterController;
    @Autowired
    @Qualifier("nettyPacketSender")
    private AbstractPacketSender sender;
    @Autowired
    private WeatherController weatherController;

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

    /**
     * Adds the object.
     * 
     * @param plObject
     *        the pl object
     */
    public void addObject(final FieldsObject plObject) {
        switch (plObject.getTypeId()) {
            case PLAYER:
                final int area = ((CharacterData) plObject).getMovement().getZone();
                if ((area > 0) & (getId() != area)) {
                    if (this.subArea.contains(area)) {
                        this.subArea.get(area).addObject(plObject);
                    }
                }
                this.playerList.put(plObject.getGuid(), plObject);
            break;
            case UNIT:
                System.out.println("Add creature to map {}" + getId());
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
        if ((time - getWeather().getLastUpdateTime()) > 150000) {
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
    public void setId(final int id) {

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

    public boolean addSubArea(final Area newsubArea) {
        if (newsubArea.getParentArea().getId() == getId()) {
            this.subArea.put(newsubArea.getId(), newsubArea);
            return true;
        } else {
            this.subArea.forEach(new TIntProcedure() {

                @Override
                public boolean execute(final int value) {
                    final Area iterArea = Map.this.subArea.get(value);
                    if (iterArea.addSubArea(newsubArea)) {
                        return false;
                    } else {
                        return true;
                    }
                }
            });
        }
        return true;
    }

    /**
     * @return the playerList
     */
    public final TLongObjectHashMap<FieldsObject> getPlayerList() {
        return this.playerList;
    }

    /**
     * @param playerList
     *        the playerList to set
     */
    public final void setPlayerList(final TLongObjectHashMap<FieldsObject> playerList) {
        this.playerList = playerList;
    }

    /**
     * @return the units
     */
    public final TLongObjectHashMap<FieldsObject> getUnits() {
        return this.units;
    }

    /**
     * @param units
     *        the units to set
     */
    public final void setUnits(final TLongObjectHashMap<FieldsObject> units) {
        this.units = units;
    }

    /**
     * @return the subArea
     */
    public final TIntObjectHashMap<Area> getSubArea() {
        return this.subArea;
    }

    /**
     * @param subArea
     *        the subArea to set
     */
    public final void setSubArea(final TIntObjectHashMap<Area> subArea) {
        this.subArea = subArea;
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
