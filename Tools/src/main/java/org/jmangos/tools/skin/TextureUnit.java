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
package org.jmangos.tools.skin;

import java.nio.ByteBuffer;

public class TextureUnit {
	short Flags;
	short Shading;
	public short SubmeshIndex;
	short SubmeshIndex2;
	short ColorIndex;
	public short RenderFlags;
	public short TexUnitNumber;
	short Mode;
	public short Texture;
	short TexUnitNumber2;
	short Transparency;
	short TextureAnim;

	public static TextureUnit read(ByteBuffer bb) {
		TextureUnit result = new TextureUnit();

		result.Flags = bb.getShort();
		result.Shading = bb.getShort();
		result.SubmeshIndex = bb.getShort();
		result.SubmeshIndex2 = bb.getShort();
		result.ColorIndex = bb.getShort();
		result.RenderFlags = bb.getShort();
		result.TexUnitNumber = bb.getShort();
		result.Mode = bb.getShort();
		result.Texture = bb.getShort();
		result.TexUnitNumber2 = bb.getShort();
		result.Transparency = bb.getShort();
		result.TextureAnim = bb.getShort();
		return result;
	}

	public String toString() {
		return "[Submeshes]\n\tFlags = " + Flags + "\n\tShading: " + Shading
				+ "\n\tSubmeshIndex: " + SubmeshIndex + "\n\tSubmeshIndex2: "
				+ SubmeshIndex2 + "\n\tColorIndex: " + ColorIndex
				+ "\n\tRenderFlags: " + RenderFlags + "\n\tTexUnitNumber: " + TexUnitNumber
				+ "\n\tMode: " + Mode
				+ "\n\tTexture: " + Texture
				+ "\n\tTexUnitNumber2: " + TexUnitNumber2
				+ "\n\tTransparency: " + Transparency
				+ "\n\tTextureAnim: " + TextureAnim;
	}
}
