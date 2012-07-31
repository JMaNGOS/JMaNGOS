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
package org.JMANGOS.login.network.netty.handler;

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
