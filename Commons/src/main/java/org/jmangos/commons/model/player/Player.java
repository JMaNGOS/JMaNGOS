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
package org.jmangos.commons.model.player;

import org.jmangos.commons.entities.CharacterData;
import org.jmangos.commons.entities.CharacterPositionerHolder;
import org.jmangos.commons.entities.HomeBindData;
import org.jmangos.commons.model.AccountInfo;
import org.jmangos.commons.model.NamedObject;
import org.jmangos.commons.network.model.ChanneledObject;
import org.jmangos.commons.network.model.NettyNetworkChannel;
import org.jmangos.commons.network.model.NetworkChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class Player.
 */
public class Player extends NamedObject implements ChanneledObject {

    /** The Constant logger. */
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(Player.class);

    /** The character data. */
    private CharacterData characterData;

    /** The channel. */
    private NetworkChannel channel;

    /** The time sync counter. */
    private int timeSyncCounter = -1;

    /**
     * Instantiates a new player.
     * 
     * @param cd
     *        the cd
     */
    public Player(final CharacterData cd) {

        setObjectId(cd.getGuid());
        setCharacterData(cd);
        cd.setPlayer(this);
        setName(cd.getName());
    }

    /**
     * Sets the character data.
     * 
     * @param characterData
     *        the characterData to set
     */
    public final void setCharacterData(final CharacterData characterData) {

        this.characterData = characterData;
        setObjectId(characterData.getGuid());
        setName(characterData.getName());
    }

    /**
     * Instantiates a new player.
     * 
     * @param guid
     *        the guid
     */
    public Player(final long guid) {

        super(guid);
    }

    /**
     * Gets the home bind.
     * 
     * @return the home bind
     */
    public final HomeBindData getHomeBind() {

        return ((CharacterPositionerHolder) this.characterData.getMovement()).getHomeBindData();
    }

    /**
     * Gets the map id.
     * 
     * @return the int
     */
    public int getMapId() {

        return this.characterData.getMovement().getMap();
    }

    /**
     * Gets the character data.
     * 
     * @return the characterData
     */
    public CharacterData getCharacterData() {

        return this.characterData;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.wowemu.common.network.model.ChanneledObject#setChannel(org.wowemu.common
     * .network.model
     * .NetworkChannel)
     */
    @Override
    public void setChannel(final NetworkChannel channel) {

        this.channel = channel;

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.wowemu.common.network.model.ChanneledObject#getChannel()
     */
    @Override
    public NetworkChannel getChannel() {

        return this.channel;
    }

    /**
     * Gets the account.
     * 
     * @return the account
     */
    public AccountInfo getAccountInfo() {

        return (AccountInfo) ((NettyNetworkChannel) getChannel()).getChanneledObject();
    }

    /**
     * Gets the update time sync counter.
     * 
     * @return the update time sync counter
     */
    public int getUpdateTimeSyncCounter() {

        return this.timeSyncCounter++;
    }

}
