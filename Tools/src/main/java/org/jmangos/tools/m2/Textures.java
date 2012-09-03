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
    
    public int    Type;
    public int    Flags;
    public int    lenFilename;
    public int    ofsFilename;
    public String FileName;
    
    public static Textures read(final ByteBuffer bb) {
    
        final Textures result = new Textures();
        result.Type = bb.getInt();
        result.Flags = bb.getInt();
        result.lenFilename = bb.getInt();
        result.ofsFilename = bb.getInt();
        
        return result;
    }
    
    public final String getFileName() {
    
        if (this.FileName != null) {
            return this.FileName;
        }
        return null;
    }
    
    public final void setFileName(final String fileName) {
    
        this.FileName = fileName;
    }
}
