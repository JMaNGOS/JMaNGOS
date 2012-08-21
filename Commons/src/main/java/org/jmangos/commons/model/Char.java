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
package org.jmangos.commons.model;

import org.jmangos.commons.network.model.ChanneledObject;
import org.jmangos.commons.network.model.NetworkChannel;
import org.jmangos.commons.utils.BigNumber;

/**
 * The Class Account.
 */
public class Char extends NamedObject implements ChanneledObject {
    
    private int            id;
    
    /** The user name. */
    private String         username;
    
    /** The channel. */
    private NetworkChannel channel;
    
    private String         sessionKey;
    
    public Char() {
    
    }
    
    /**
     * Instantiates a new account.
     * 
     * @param objectId
     *            the object id
     */
    public Char(final int objectId) {
    
        super(objectId);
    }
    
    @Override
    public NetworkChannel getChannel() {
    
        return this.channel;
    }
    
    @Override
    public void setChannel(NetworkChannel channel) {
    
        this.channel = channel;
    }
    
    @Override
    public String getName() {
    
        return this.username;
    }
    
    @Override
    public void setName(final String name) {
    
        this.username = name;
    }
    
    public int getId() {
    
        return id;
    }
    
    public void setId(int id) {
    
        this.id = id;
    }
    
    public String getSessionKey() {
    
        return sessionKey;
    }
    
    public void setSessionKey(String sessionKey) {
    
        this.sessionKey = sessionKey;
    }
    
}
