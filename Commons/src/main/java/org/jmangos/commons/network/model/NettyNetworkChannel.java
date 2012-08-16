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
package org.jmangos.commons.network.model;

import java.net.InetSocketAddress;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandler;
import org.jmangos.commons.model.ManagedObject;

/**
 * The Class NettyNetworkChannel.
 */
public class NettyNetworkChannel implements NetworkChannel {
    
    /**
     * Gets the channeled object.
     * 
     * @return the channeled object
     */
    public final ChanneledObject getChanneledObject() {
    
        return this.channeledObject;
    }
    
    /**
     * Sets the channeled object.
     * 
     * @param channeledObject
     *            the new channeled object
     */
    public final void setChanneledObject(final ChanneledObject channeledObject) {
    
        this.channeledObject = channeledObject;
    }
    
    /** The channel. */
    private final Channel   channel;
    
    /**
     * Channeled object of this context.<br>
     * During initial connection this object can be null.<br>
     * Example: Account
     */
    private ChanneledObject channeledObject;
    
    /** In-game object (example: Player). */
    private ManagedObject   activeObject;
    
    /**
     * Gets the active object.
     * 
     * @return the active object
     */
    public final ManagedObject getActiveObject() {
    
        return this.activeObject;
    }
    
    /**
     * Sets the active object.
     * 
     * @param activeObject
     *            the new active object
     */
    public final void setActiveObject(final ManagedObject activeObject) {
    
        this.activeObject = activeObject;
    }
    
    /** Channel handler. */
    @SuppressWarnings("unused")
    private final ChannelHandler    handler;
    
    /** The state. */
    private State                   state;
    
    /** The address. */
    private final InetSocketAddress address;
    
    /**
     * Channel state.
     * 
     * @param handler
     *            the handler
     * @param channel
     *            the channel
     */
    // private ChannelState channelState;
    
    /**
     * @param handler
     * @param channel
     */
    public NettyNetworkChannel(final ChannelHandler handler, final Channel channel) {
    
        this.handler = handler;
        this.channel = channel;
        this.address = (InetSocketAddress) channel.getRemoteAddress();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.wowemu.common.network.model.NetworkChannel#getAddress()
     */
    @Override
    public final InetSocketAddress getAddress() {
    
        return this.address;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.wowemu.common.network.model.NetworkChannel#write(java.lang.Object)
     */
    @Override
    public void write(final Object buffer) {
    
        this.channel.write(buffer);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.wowemu.common.network.model.NetworkChannel#getChannelId()
     */
    @Override
    public final int getChannelId() {
    
        return this.channel.getId();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.wowemu.common.network.model.NetworkChannel#getObjectId()
     */
    @Override
    public int getObjectId() {
    
        return this.channeledObject != null ? this.channeledObject.getObjectId() : -1;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.wowemu.common.network.model.NetworkChannel#getChannel()
     */
    @Override
    public Channel getChannel() {
    
        return this.channel;
    }
    
    /**
     * Close.
     */
    public void close() {
    
        this.channel.close();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.wowemu.common.network.model.NetworkChannel#isConnected()
     */
    @Override
    public boolean isConnected() {
    
        return this.channel.isConnected();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.wowemu.common.network.model.NetworkChannel#setChannelState(org.wowemu
     * .common.network.model.State)
     */
    @Override
    public void setChannelState(final State channelState) {
    
        this.state = channelState;
        
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.wowemu.common.network.model.NetworkChannel#getChannelState()
     */
    @Override
    public State getChannelState() {
    
        return this.state;
    }
}
