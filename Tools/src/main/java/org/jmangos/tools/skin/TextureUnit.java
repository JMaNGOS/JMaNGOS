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
    
    short        Flags;
    short        Shading;
    public short SubmeshIndex;
    short        SubmeshIndex2;
    short        ColorIndex;
    public short RenderFlags;
    public short TexUnitNumber;
    short        Mode;
    public short Texture;
    short        TexUnitNumber2;
    short        Transparency;
    short        TextureAnim;
    
    public static TextureUnit read(final ByteBuffer bb) {
    
        final TextureUnit result = new TextureUnit();
        
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
    
    @Override
    public String toString() {
    
        return "[Submeshes]\n\tFlags = " + this.Flags + "\n\tShading: " + this.Shading + "\n\tSubmeshIndex: " + this.SubmeshIndex + "\n\tSubmeshIndex2: "
                + this.SubmeshIndex2 + "\n\tColorIndex: " + this.ColorIndex + "\n\tRenderFlags: " + this.RenderFlags + "\n\tTexUnitNumber: "
                + this.TexUnitNumber + "\n\tMode: " + this.Mode + "\n\tTexture: " + this.Texture + "\n\tTexUnitNumber2: " + this.TexUnitNumber2
                + "\n\tTransparency: " + this.Transparency + "\n\tTextureAnim: " + this.TextureAnim;
    }
}
