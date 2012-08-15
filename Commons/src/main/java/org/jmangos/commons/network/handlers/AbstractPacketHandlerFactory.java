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

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
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

/**
 * A factory for creating AbstractPacketHandler objects.
 * 
 * @author minimajack
 */
public abstract class AbstractPacketHandlerFactory extends XmlDataLoader
		implements PacketHandlerFactory {
	private static final Logger logger = Logger
			.getLogger(AbstractPacketHandlerFactory.class);
	/** The c handler. */
	ClientPacketHandler cHandler = new ClientPacketHandler();

	/** The s handler. */
	ServerPacketHandler sHandler = new ServerPacketHandler();

	@Inject
	@Named("packetXSD")
	protected String packetXSDLocation;
	
	@Inject
	@Named("toClient")
	protected String clientPacketPath;
	
	/**
	 * Instantiates a new abstract packet handler factory.
	 */
	public AbstractPacketHandlerFactory() {
		super();
	}

	static abstract class AddPackets implements
			TIntObjectProcedure<PacketTemplate> {
		protected String upstreamPackageName;
		protected ClassLoader classLoader;
		protected AbstractPacketHandlerFactory packetHandlerFactory;

		public AddPackets(AbstractPacketHandlerFactory phf, String pkdgName) {
			super();
			packetHandlerFactory = phf;
			upstreamPackageName = pkdgName;
			classLoader = AbstractPacketHandlerFactory.class.getClassLoader();
		}
	}

	static final class AddUpstreamPackets extends AddPackets {
		private static final Logger logger = Logger
				.getLogger(AddUpstreamPackets.class);

		public AddUpstreamPackets(AbstractPacketHandlerFactory phf,
				String pkdgName) {
			super(phf, pkdgName);
		}

		@Override
		public boolean execute(int number, PacketTemplate template) {
			String fullPath = upstreamPackageName + template.getName();
			try {
				packetHandlerFactory.addPacket(classLoader.loadClass(fullPath)
						.asSubclass(SendablePacket.class), template
						.getTemplateId());
			} catch (ClassNotFoundException e) {
				logger.warn("Class " + fullPath + " not found", e);
			} catch (ClassCastException e) {
				logger.warn("Class " + fullPath
						+ " can't cast to SendablePacket.class", e);
			}
			return true;
		}
	}

	static final class AddDownstreamPackets extends AddPackets {
		private static final Injector injector = ServiceContent.getInjector();
		private static final Logger logger = Logger
				.getLogger(AddDownstreamPackets.class);

		public AddDownstreamPackets(AbstractPacketHandlerFactory phf,
				String pkdgName) {
			super(phf, pkdgName);
		}

		@Override
		public boolean execute(int number, PacketTemplate template) {
			String fullPath = upstreamPackageName + template.getName();
			try {
				ReceivablePacket packet = classLoader.loadClass(fullPath)
						.asSubclass(ReceivablePacket.class).newInstance();
				packet.setOpCode(template.getTemplateId());
				injector.injectMembers(packet);
				packetHandlerFactory.addPacket(packet, template.getState());

			} catch (ClassNotFoundException e) {
				logger.warn("Class " + fullPath + " not found", e);
			} catch (ClassCastException e) {
				logger.warn("Class " + fullPath
						+ " can't cast to ReceivablePacket.class", e);
			} catch (InstantiationException e) {
				logger.warn("Class " + fullPath
						+ " don't have empty constructor for instantinate", e);
			} catch (IllegalAccessException e) {
				logger.warn("Can't get acces for class " + fullPath, e);
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
	public void addList(PacketData pl) {
		for (PacketList plist : pl.templates) {
			switch (plist.getDirection()) {
			case DOWNSTREAM:
				plist.data.forEachEntry(new AddDownstreamPackets(this, plist
						.getPackageName()));
				break;
			case UPSTREAM:
				plist.data.forEachEntry(new AddUpstreamPackets(this, plist
						.getPackageName()));
				break;
			default:
				logger.warn("Unknown packets derection in configuration files.");
				break;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jmangos.commons.network.handlers.PacketHandlerFactory#addPacket(org
	 * .jmangos.commons.network.model.ReceivablePacket,
	 * org.jmangos.commons.network.model.State[])
	 */
	public void addPacket(ReceivablePacket packetPrototype, State... states) {
		cHandler.addPacketOpcode(packetPrototype, states);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jmangos.commons.network.handlers.PacketHandlerFactory#
	 * getServerPacketopCode(org.jmangos.commons.network.model.SendablePacket)
	 */
	public int getServerPacketopCode(SendablePacket packetClass) {
		return sHandler.getOpCode(packetClass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jmangos.commons.network.handlers.PacketHandlerFactory#handleClientPacket
	 * (int, org.jmangos.commons.network.model.NetworkChannel)
	 */
	public ReceivablePacket handleClientPacket(int id, NetworkChannel ch) {
		return cHandler.getPacket(id, ch);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jmangos.commons.network.handlers.PacketHandlerFactory#addPacket(java
	 * .lang.Class, int)
	 */
	public void addPacket(Class<? extends SendablePacket> packetPrototype,
			int opcode) {
		sHandler.addPacketOpcode(packetPrototype, opcode);

	}
}
