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
package org.jmangos.commons.network.handlers;

import gnu.trove.procedure.TIntObjectProcedure;

import org.apache.log4j.Logger;
import org.jmangos.commons.dataholder.XmlDataLoader;
import org.jmangos.commons.network.model.NetworkChannel;
import org.jmangos.commons.network.model.ReceivablePacket;
import org.jmangos.commons.network.model.SendablePacket;
import org.jmangos.commons.network.model.State;
import org.jmangos.commons.network.netty.model.PacketData;
import org.jmangos.commons.network.netty.model.PacketList;
import org.jmangos.commons.network.netty.model.PacketTemplate;
import org.jmangos.commons.service.ServiceContent;
import org.springframework.context.ApplicationContext;

/**
 * A factory for creating AbstractPacketHandler objects.
 * 
 * @author MinimaJack
 */
public abstract class AbstractPacketHandlerFactory extends XmlDataLoader implements PacketHandlerFactory {
    
    private static final Logger logger            = Logger.getLogger(AbstractPacketHandlerFactory.class);
    /** The c handler. */
    ClientPacketHandler         cHandler          = new ClientPacketHandler();
    
    /** The s handler. */
    ServerPacketHandler         sHandler          = new ServerPacketHandler();
    
    protected String            packetXSDLocation = "./conf/packetData/packets.xsd";
    
    protected String            clientPacketPath  = "./conf/packetData/lc-packets.xml";
    
    /**
     * Instantiates a new abstract packet handler factory.
     */
    public AbstractPacketHandlerFactory() {
    
        super();
    }
    
    static abstract class AddPackets implements TIntObjectProcedure<PacketTemplate> {
        
        protected String                       upstreamPackageName;
        protected ClassLoader                  classLoader;
        protected AbstractPacketHandlerFactory packetHandlerFactory;
        
        public AddPackets(final AbstractPacketHandlerFactory phf, final String pkdgName) {
        
            super();
            this.packetHandlerFactory = phf;
            this.upstreamPackageName = pkdgName;
            this.classLoader = AbstractPacketHandlerFactory.class.getClassLoader();
        }
    }
    
    static final class AddUpstreamPackets extends AddPackets {
        
        private static final Logger logger = Logger.getLogger(AddUpstreamPackets.class);
        
        public AddUpstreamPackets(final AbstractPacketHandlerFactory phf, final String pkdgName) {
        
            super(phf, pkdgName);
        }
        
        @Override
        public boolean execute(final int number, final PacketTemplate template) {
        
            final String fullPath = this.upstreamPackageName + template.getName();
            try {
                this.packetHandlerFactory.addPacket(this.classLoader.loadClass(fullPath).asSubclass(SendablePacket.class), template.getTemplateId());
            } catch (final ClassNotFoundException e) {
                logger.warn("Class " + fullPath + " not found", e);
            } catch (final ClassCastException e) {
                logger.warn("Class " + fullPath + " can't cast to SendablePacket.class", e);
            }
            return true;
        }
    }
    
    static final class AddDownstreamPackets extends AddPackets {
        
        private static final ApplicationContext context = ServiceContent.getContext();
        private static final Logger             logger  = Logger.getLogger(AddDownstreamPackets.class);
        
        public AddDownstreamPackets(final AbstractPacketHandlerFactory phf, final String pkdgName) {
        
            super(phf, pkdgName);
        }
        
        @Override
        public boolean execute(final int number, final PacketTemplate template) {
        
            final String fullPath = this.upstreamPackageName + template.getName();
            try {
                
                final Class<?> clazz = Class.forName(fullPath, false, this.classLoader);
                final ReceivablePacket packet = (ReceivablePacket) context.getBean(clazz);
                
                packet.setOpCode(template.getTemplateId());
                this.packetHandlerFactory.addPacket(packet, template.getState());
                
            } catch (final ClassNotFoundException e) {
                logger.warn("Class " + fullPath + " not found", e);
            } catch (final ClassCastException e) {
                logger.warn("Class " + fullPath + " can't cast to ReceivablePacket.class", e);
            }
            return true;
        }
    }
    
    /**
     * Adds the list.
     * 
     * @param pl
     *            the pl
     */
    public void addList(final PacketData pl) {
    
        for (final PacketList plist : pl.templates) {
            switch (plist.getDirection()) {
                case DOWNSTREAM:
                    plist.data.forEachEntry(new AddDownstreamPackets(this, plist.getPackageName()));
                    break;
                case UPSTREAM:
                    plist.data.forEachEntry(new AddUpstreamPackets(this, plist.getPackageName()));
                    break;
                default:
                    logger.warn("Unknown packets derection in configuration files.");
                    break;
            }
        }
    }
    
    /**
     * @see org.jmangos.commons.network.handlers.PacketHandlerFactory#addPacket(org.jmangos.commons.network.model.ReceivablePacket,
     *      org.jmangos.commons.network.model.State[])
     */
    @Override
    public void addPacket(final ReceivablePacket packetPrototype, final State... states) {
    
        this.cHandler.addPacketOpcode(packetPrototype, states);
        
    }
    
    /**
     * @see org.jmangos.commons.network.handlers.PacketHandlerFactory#getServerPacketopCode(org.jmangos.commons.network.model.SendablePacket)
     */
    @Override
    public int getServerPacketopCode(final SendablePacket packetClass) {
    
        return this.sHandler.getOpCode(packetClass);
    }
    
    /**
     * @see org.jmangos.commons.network.handlers.PacketHandlerFactory#handleClientPacket(int,
     *      org.jmangos.commons.network.model.NetworkChannel)
     */
    @Override
    public ReceivablePacket handleClientPacket(final int id, final NetworkChannel ch) {
    
        return this.cHandler.getPacket(id, ch);
    }
    
    /**
     * @see org.jmangos.commons.network.handlers.PacketHandlerFactory#addPacket(java.lang.Class,
     *      int)
     */
    @Override
    public void addPacket(final Class<? extends SendablePacket> packetPrototype, final int opcode) {
    
        this.sHandler.addPacketOpcode(packetPrototype, opcode);
        
    }
}
