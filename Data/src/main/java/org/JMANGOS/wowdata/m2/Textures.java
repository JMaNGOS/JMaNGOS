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
package org.JMANGOS.wowdata.m2;

import java.nio.ByteBuffer;

public class Textures {
	public int Type;
	public int Flags;
	public int lenFilename;
	public int ofsFilename;
	public String FileName;

	public static Textures read(ByteBuffer bb) {
		Textures result = new Textures();
		result.Type = bb.getInt();
		result.Flags = bb.getInt();
		result.lenFilename = bb.getInt();
		result.ofsFilename = bb.getInt();

		return result;
	}
	public final String getFileName() {
		if(FileName != null){
			return FileName;
		}
		return null;
	}
	public final void setFileName(String fileName) {
		FileName = fileName;
	}
}
