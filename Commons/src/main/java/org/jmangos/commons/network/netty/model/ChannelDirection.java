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
package org.jmangos.commons.network.netty.model;

// TODO: Auto-generated Javadoc
/**
 * The Enum ChannelDirection.
 */
public enum ChannelDirection {
	  
  	/** The UPSTREAM. */
  	UPSTREAM(1),
	  
  	/** The DOWNSTREAM. */
  	DOWNSTREAM(1 << 1);

	  /** The id. */
  	private int id;

	  /**
  	 * Instantiates a new channel direction.
  	 *
  	 * @param id the id
  	 */
	  ChannelDirection(int id) {
	    this.id = id;
	  }

	  /**
  	 * Gets the id.
  	 *
  	 * @return the id
  	 */
	  public int getId() {
	    return id;
	  }
}
