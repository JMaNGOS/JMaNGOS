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
package org.JMANGOS.wowdata.wmo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.JMANGOS.wowdata.chunk.BaseChunk;
import org.JMANGOS.wowdata.wmo.chunks.WMOChunk;
import org.JMANGOS.wowdata.wmo.chunks.group.*;

public class WmoGroup {
	public MOGPChunk groupChunk;

	public static WmoGroup read(File f) throws IOException {
		FileInputStream fis = null;
		ByteBuffer bb = ByteBuffer.allocate((int) f.length());
		WmoGroup result = new WmoGroup();
		try {
			fis = new FileInputStream(f);
			fis.getChannel().read(bb);
			bb.rewind();
			bb.order(ByteOrder.LITTLE_ENDIAN);
			
			int glOffset = 0;
			while (glOffset < (int)f.length()) {
				BaseChunk ch = new WMOChunk().readChunkByHeader(bb,glOffset);
				if (ch instanceof MOGPChunk){
					result.groupChunk = (MOGPChunk) ch;
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
}
