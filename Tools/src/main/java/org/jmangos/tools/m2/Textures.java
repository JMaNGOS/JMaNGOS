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
package org.jmangos.tools.m2;

import java.nio.ByteBuffer;

public class Textures {
	public int type;
	public int flags;
	public int lenFilename;
	public int ofsFilename;
	public String fileName;

	public static Textures read(ByteBuffer bb) {
		Textures result = new Textures();
		result.type = bb.getInt();
		result.flags = bb.getInt();
		result.lenFilename = bb.getInt();
		result.ofsFilename = bb.getInt();

		return result;
	}
	public final String getFileName() {
		if(fileName != null){
			return fileName;
		}
		return null;
	}
	public final void setFileName(String fName) {
		fileName = fName;
	}
}
