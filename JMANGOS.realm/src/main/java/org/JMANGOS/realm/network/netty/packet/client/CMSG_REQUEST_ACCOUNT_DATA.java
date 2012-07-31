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
package org.JMANGOS.realm.network.netty.packet.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.util.HashMap;
import java.util.zip.Deflater;

import javax.inject.Inject;
import javax.inject.Named;

import org.JMANGOS.realm.model.account.AccountData;
import org.JMANGOS.realm.model.account.AccountDataType;
import org.JMANGOS.realm.network.netty.packet.AbstractWoWClientPacket;
import org.JMANGOS.common.network.netty.sender.AbstractPacketSender;
// TODO: Auto-generated Javadoc
// FIXME implement opcode
/**
 * The Class CMSG_REQUEST_ACCOUNT_DATA.
 */
public class CMSG_REQUEST_ACCOUNT_DATA extends AbstractWoWClientPacket {

	/** The sender. */
	@SuppressWarnings("unused")
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
