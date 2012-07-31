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

public class WmoRoot {
	public static WmoRoot read(File f) throws IOException {
		FileInputStream fis = null;
		ByteBuffer bb = ByteBuffer.allocate((int) f.length());
		WmoRoot result = new WmoRoot();
		try {
			fis = new FileInputStream(f);
			fis.getChannel().read(bb);
			bb.rewind();
			bb.order(ByteOrder.LITTLE_ENDIAN);
			
			int glOffset = 0;
			while (glOffset < (int)f.length()) {
				BaseChunk ch = new WMOChunk().readChunkByHeader(bb,glOffset);
				System.out.println(ch); 
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
