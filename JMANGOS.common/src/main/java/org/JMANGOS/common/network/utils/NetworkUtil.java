/*******************************************************************************
 * Copyright (c) 2012 JMANGOS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     JMANGOS - initial API and implementation
 ******************************************************************************/
/**
 * 
 */
package org.JMANGOS.common.network.utils;

import java.nio.ByteOrder;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

// TODO: Auto-generated Javadoc
/**
 * The Class NetworkUtil.
 *
 * @author vangula
 */
public class NetworkUtil {

	  /**
  	 * New channel buffer.
  	 *
  	 * @return the channel buffer
  	 */
	  public static final ChannelBuffer newChannelBuffer() {
	    return newChannelBuffer(65536);
	  }

	  /**
  	 * New channel buffer.
  	 *
  	 * @param size the size
  	 * @return the channel buffer
  	 */
	  public static final ChannelBuffer newChannelBuffer(int size) {
	    return ChannelBuffers.buffer(ByteOrder.LITTLE_ENDIAN, size);
	  }
	  
  	/**
  	 * New dinamic channel buffer.
  	 *
  	 * @param size the size
  	 * @return the channel buffer
  	 */
	  public static final ChannelBuffer newDinamicChannelBuffer(int size) {
	    return ChannelBuffers.dynamicBuffer(ByteOrder.LITTLE_ENDIAN, size);
	  }
}
