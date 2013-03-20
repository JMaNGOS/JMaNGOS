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
package org.jmangos.realm.network.packet.wow;

import org.jmangos.commons.model.AccountInfo;
import org.jmangos.commons.model.player.Player;
import org.jmangos.commons.network.model.NettyNetworkChannel;
import org.jmangos.commons.network.model.ReceivablePacket;
import org.jmangos.realm.network.handler.RealmToClientChannelHandler;

/**
 * The Class AbstractWoWClientPacket.
 */
public abstract class AbstractWoWClientPacket extends ReceivablePacket {

    /**
     * Instantiates a new abstract wo w client packet.
     * 
     * @param opcode
     *        the opcode
     */
    public AbstractWoWClientPacket(final int opcode) {

        super(opcode);

    }

    /**
     * Instantiates a new abstract wo w client packet.
     */
    public AbstractWoWClientPacket() {

        super();
    }

    /**
     * Gets the channel handler.
     * 
     * @return the Realm-Client channel handler
     */
    protected RealmToClientChannelHandler GetChannelHandler() {

        return (RealmToClientChannelHandler) getChannel().getPipeline().getLast();

    }

    /**
     * Gets the account.
     * 
     * @return the account
     */
    public AccountInfo getAccountInfo() {

        return (AccountInfo) ((NettyNetworkChannel) this._client).getChanneledObject();
    }

    /**
     * Gets the player.
     * 
     * @return the player
     */
    public Player getPlayer() {

        return (Player) ((NettyNetworkChannel) this._client).getActiveObject();
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.network.model.ReceivablePacket#getClient()
     */
    @Override
    public NettyNetworkChannel getClient() {

        return ((NettyNetworkChannel) this._client);
    }

}
