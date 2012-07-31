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
