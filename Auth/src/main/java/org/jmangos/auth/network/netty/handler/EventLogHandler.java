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
package org.jmangos.auth.network.netty.handler;

import org.apache.log4j.Logger;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.handler.timeout.ReadTimeoutException;

// TODO: Auto-generated Javadoc
/**
 * The Class EventLogHandler.
 *
 * @author minimajack
 */
public class EventLogHandler extends SimpleChannelUpstreamHandler {

	/** The Constant log. */
	private static final Logger             log     = Logger.getLogger(EventLogHandler.class);

	  /* (non-Javadoc)
  	 * @see org.jboss.netty.channel.SimpleChannelUpstreamHandler#messageReceived(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.MessageEvent)
  	 */
  	@Override
	  public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
	    ctx.sendUpstream(e);
	  }

	  /* (non-Javadoc)
  	 * @see org.jboss.netty.channel.SimpleChannelUpstreamHandler#exceptionCaught(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.ExceptionEvent)
  	 */
  	@Override
	  public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
	    if (e instanceof ReadTimeoutException) {
	      ctx.sendUpstream(e);
	    }
	    log.info("Exception caught: \n "+ e);
	    ctx.sendUpstream(e);
	  }

	  /* (non-Javadoc)
  	 * @see org.jboss.netty.channel.SimpleChannelUpstreamHandler#channelConnected(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.ChannelStateEvent)
  	 */
  	@Override
	  public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
		  ctx.sendUpstream(e);
	  }

	  /* (non-Javadoc)
  	 * @see org.jboss.netty.channel.SimpleChannelUpstreamHandler#channelDisconnected(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.ChannelStateEvent)
  	 */
  	@Override
	  public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
		  ctx.sendUpstream(e);
	  }
	}
