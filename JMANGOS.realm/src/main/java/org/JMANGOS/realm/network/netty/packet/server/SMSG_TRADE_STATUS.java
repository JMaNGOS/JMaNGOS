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
package org.JMANGOS.realm.network.netty.packet.server;

import org.JMANGOS.realm.model.base.TradeStatus;
import org.JMANGOS.realm.network.netty.packet.AbstractWoWServerPacket;

// TODO: Auto-generated Javadoc
/**
 * The Class SMSG_TRADE_STATUS.
 */
public class SMSG_TRADE_STATUS extends AbstractWoWServerPacket {

	/** The trade status. */
	TradeStatus tradeStatus;
	
	/**
	 * Instantiates a new sMS g_ trad e_ status.
	 */
	public SMSG_TRADE_STATUS() {
	}

	/**
	 * Instantiates a new sMS g_ trad e_ status.
	 *
	 * @param _status the _status
	 */
	public SMSG_TRADE_STATUS(TradeStatus _status) {
		tradeStatus = _status;
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
	 */
	@Override
	protected void writeImpl() {
		 writeD(tradeStatus.getStatus());
	}

}
