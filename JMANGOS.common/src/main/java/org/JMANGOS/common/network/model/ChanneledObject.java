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

// TODO: Auto-generated Javadoc
/**
 * The Interface ChanneledObject.
 */
public interface ChanneledObject {

	  /**
  	 * Sets the channel.
  	 *
  	 * @param channel context
  	 */
	  void setChannel(NetworkChannel channel);

	  /**
  	 * Gets the channel.
  	 *
  	 * @return channel context
  	 */
	  NetworkChannel getChannel();

	  /**
  	 * Gets the object id.
  	 *
  	 * @return the object id
  	 */
	  int getObjectId();
	}

