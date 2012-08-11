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
package org.jmangos.realm.network.netty.packetClient.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.util.HashMap;
import java.util.zip.Deflater;

import javax.inject.Inject;
import javax.inject.Named;

import org.jmangos.commons.network.netty.sender.AbstractPacketSender;
import org.jmangos.realm.model.account.AccountData;
import org.jmangos.realm.model.account.AccountDataType;
import org.jmangos.realm.network.netty.packetClient.AbstractWoWClientPacket;
// TODO: Auto-generated Javadoc
// FIXME implement opcode
/**
 * The Class CMSG_REQUEST_ACCOUNT_DATA.
 */
public class CMSG_REQUEST_ACCOUNT_DATA extends AbstractWoWClientPacket {

	/** The sender. */
	@Inject
	@Named("client")
	private AbstractPacketSender sender;
	
	/** The type. */
	private int type;
	
	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ReceivablePacket#readImpl()
	 */
	@Override
	protected void readImpl() throws BufferUnderflowException, RuntimeException {
		type = readD();
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ReceivablePacket#runImpl()
	 */
	@Override
	protected void runImpl() {
		if (type > AccountDataType.NUM_ACCOUNT_DATA_TYPES.getValue())
			return;
		HashMap<Integer, AccountData> adata = getAccount().getAccountData();
		if (adata.containsKey(type)) {
			Deflater compressor = new Deflater();
			byte[] dataToCompress = adata.get(type).getData().getBytes();

			compressor.setInput(dataToCompress);
			compressor.finish();
			ByteArrayOutputStream bos = new ByteArrayOutputStream(dataToCompress.length);

			byte[] buf = new byte[1024];
			while (!compressor.finished()) {
				int count = compressor.deflate(buf);
				bos.write(buf, 0, count);
			}
			try {
				bos.close();
			} catch (IOException e) {
			}
			// FIXME NEED COMPLETE
			@SuppressWarnings("unused")
			byte[] compressedData = bos.toByteArray();
			
			

		}
	}
}
