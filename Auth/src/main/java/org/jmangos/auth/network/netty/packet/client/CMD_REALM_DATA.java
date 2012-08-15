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
package org.jmangos.auth.network.netty.packet.client;

import java.nio.BufferUnderflowException;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.jmangos.auth.model.Realm;
import org.jmangos.auth.network.netty.packet.AbstractWoWClientPacket;
import org.jmangos.auth.service.RealmListService;
import org.jmangos.commons.network.netty.sender.AbstractPacketSender;
import org.springframework.stereotype.Component;

/**
 * The Class <tt>CMD_REALM_DATA</tt>.
 */
@Component
public class CMD_REALM_DATA extends AbstractWoWClientPacket {

	/** The logger. */
	private static Logger logger = Logger.getLogger(CMD_REALM_DATA.class);
	/** The sender. */
	@Inject
	@Named("nettyPacketSender")
	private AbstractPacketSender sender;
	@Inject
	private RealmListService realmListService;

	public CMD_REALM_DATA() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jmangos.commons.network.model.ReceivablePacket#readImpl()
	 */
	@Override
	protected void readImpl() throws BufferUnderflowException, RuntimeException {
		logger.debug("Receive realm info from realm account: "
				+ getAccount().getName());
		Realm realm = new Realm();
		realm.setId(getAccount().getObjectId());
		realm.setName(readS());
		realm.setAddress(readS());
		realm.setPort(readD());
		realm.setIcon(readC());
		realm.setRealmflags(readC());
		realm.setTimezone(readC());
		realm.setAllowedSecurityLevel(readC());
		realm.setPopulation(readF());
		realm.setRealmbuilds(readS());
		realmListService.addFromConnected(realm);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jmangos.commons.network.model.ReceivablePacket#runImpl()
	 */
	@Override
	protected void runImpl() {

	}
}
