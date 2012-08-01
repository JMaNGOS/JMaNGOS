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
