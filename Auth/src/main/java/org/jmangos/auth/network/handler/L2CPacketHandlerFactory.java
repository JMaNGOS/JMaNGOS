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
package org.jmangos.auth.network.handler;

import org.jmangos.commons.network.handlers.AbstractPacketHandlerFactory;
import org.jmangos.commons.network.netty.model.PacketData;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating L2CPacketHandler objects.
 */
/**
 * @author MinimaJack
 *
 */
public class L2CPacketHandlerFactory extends AbstractPacketHandlerFactory {

	/**
	 * Instantiates a new l2 c packet handler factory.
	 */
	public L2CPacketHandlerFactory() {
		addList(loadStaticData(PacketData.class,
				"./data/packetData/packets.xsd",
				"./data/packetData/lc-packets.xml"));
	}
}
