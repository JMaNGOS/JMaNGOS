/*******************************************************************************
 * Copyright (c) 2011 WoWEmu
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *    WoWEmu  - initial API and implementation
 ******************************************************************************/

package org.JMANGOS.common.network.model;

import java.net.InetSocketAddress;

import org.jboss.netty.channel.Channel;

// TODO: Auto-generated Javadoc
/**
 * The Interface NetworkChannel.
 */
public interface NetworkChannel {

  /**
   * Gets the channel id.
   *
   * @return unique ID for context's channel
   */
  int getChannelId();

  /**
   * Gets the object id.
   *
   * @return ID of channeled object or -1
   */
  int getObjectId();

  /**
   * Gets the channel.
   *
   * @return the channel
   */
  Channel getChannel();

  /**
   * Gets the address.
   *
   * @return the address
   */
 // ChannelHandler getHandler();

  /**
   * @param channeledObject
   */
//  void setChanneledObject(ChanneledObject channeledObject);

  /**
   * @return top-level channeled object that initiated connection
   */
 // ChanneledObject getChanneledObject();

  /**
   * @return in-game object that performs actions
   */
//  ManagedObject getActingObject();

  /**
   * @param actingObject
   */
 // void setActingObject(ManagedObject actingObject);
  public InetSocketAddress getAddress();
  
  /**
   * Gets the channel state.
   *
   * @return channel state
   */
  State getChannelState();

  /**
   * Sets the channel state.
   *
   * @param channelState the new channel state
   */
  void setChannelState(State channelState);

  /**
   * Checks if is connected.
   *
   * @return true, if is connected
   */
  boolean isConnected();

  /**
   * Write.
   *
   * @param buffer the buffer
   */
  void write(Object buffer);
}
