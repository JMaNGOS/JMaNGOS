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
package org.JMANGOS.wowdata.adt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.JMANGOS.wowdata.adt.chunks.ADTChunk;
import org.JMANGOS.wowdata.adt.chunks.root.*;
import org.JMANGOS.wowdata.chunk.BaseChunk;
import org.JMANGOS.wowdata.chunk.MVERChunk;

public class ADT {
	private MVERChunk version;
	private MHDRChunk header;
	private MMIDChunk mmid;
	private MMDXChunk mmdx;
	private MWIDChunk mwid;
	private MWMOChunk mwmo;
	public MCNKChunk[] mcnks = new MCNKChunk[256];
	
	public ADT read(File f) throws IOException {
		FileInputStream fis = null;
		ByteBuffer bb = ByteBuffer.allocate((int) f.length());
		ADT result = new ADT();
		try {
			fis = new FileInputStream(f);
			fis.getChannel().read(bb);
			bb.rewind();
			bb.order(ByteOrder.LITTLE_ENDIAN);
			
			int glOffset = 0;
			int mcnksIndex = 0;
			while (glOffset < (int)f.length()) {
				BaseChunk ch = new ADTChunk().readChunkByHeader(bb,glOffset);
				if (ch instanceof MVERChunk){
					setVersion((MVERChunk) ch);
				} else if(ch instanceof MHDRChunk){
					setHeader((MHDRChunk) ch);
				}else if(ch instanceof MMIDChunk){
					mmid = (MMIDChunk) ch; 
					mmdx.setMMID(mmid);
				}else if(ch instanceof MMDXChunk){
					mmdx = (MMDXChunk) ch;
				}else if(ch instanceof MWIDChunk){
					mwid = (MWIDChunk) ch; 
					mwmo.setMWID(mwid);
				}else if(ch instanceof MWMOChunk){
					mwmo = (MWMOChunk) ch;
				}else if(ch instanceof MCNKChunk){
					mcnks[mcnksIndex++] = (MCNKChunk) ch;
				}
				glOffset = ch.getGlobalOffcet();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			fis.close();
		}
		return result;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(MVERChunk version) {
		this.version = version;
	}

	/**
	 * @return the version
	 */
	public MVERChunk getVersion() {
		return version;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(MHDRChunk header) {
		this.header = header;
	}

	/**
	 * @return the header
	 */
	public MHDRChunk getHeader() {
		return header;
	}
}
