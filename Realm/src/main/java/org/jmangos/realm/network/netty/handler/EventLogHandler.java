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
package org.jmangos.realm.network.netty.handler;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.DefaultExceptionEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class EventLogHandler.
 * 
 * @author MinimaJack
 */
public class EventLogHandler extends SimpleChannelUpstreamHandler {
    
    /** The Constant log. */
    private static final Logger log = LoggerFactory.getLogger(EventLogHandler.class);
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.netty.channel.SimpleChannelUpstreamHandler#messageReceived(
     * org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.MessageEvent)
     */
    @Override
    public void messageReceived(final ChannelHandlerContext ctx, final MessageEvent e) throws Exception {
    
        ctx.sendUpstream(e);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.netty.channel.SimpleChannelUpstreamHandler#exceptionCaught(
     * org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.ExceptionEvent)
     */
    @Override
    public void exceptionCaught(final ChannelHandlerContext ctx, final ExceptionEvent e) throws Exception {
    
        if ((e instanceof DefaultExceptionEvent) && (e.getCause() != null) && (e.getCause().getMessage() != null)
                && (e.getCause().getMessage().equals("connection timed out") || e.getCause().getMessage().contains("Connection refused"))) {
            log.warn("Connection timed out");
        } else {
            log.warn("Exception caught: ", e.getCause());
        }
        ctx.sendUpstream(e);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.netty.channel.SimpleChannelUpstreamHandler#channelConnected
     * (org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.ChannelStateEvent)
     */
    @Override
    public void channelConnected(final ChannelHandlerContext ctx, final ChannelStateEvent e) throws Exception {
    
        ctx.sendUpstream(e);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.netty.channel.SimpleChannelUpstreamHandler#channelDisconnected
     * (org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.ChannelStateEvent)
     */
    @Override
    public void channelDisconnected(final ChannelHandlerContext ctx, final ChannelStateEvent e) throws Exception {
    
        ctx.sendUpstream(e);
    }
}
