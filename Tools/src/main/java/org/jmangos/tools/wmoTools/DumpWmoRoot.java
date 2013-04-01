/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
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
 ******************************************************************************/
package org.jmangos.tools.wmoTools;

import java.io.File;
import java.io.IOException;

import org.jmangos.tools.chunk.BaseChunk;
import org.jmangos.tools.wmo.WmoRoot;

/**
 * Show information from wmoRoot file like stormwind.wmo
 */
public class DumpWmoRoot {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Usage: DumpWmoRoot <binary wmo file> ");
            System.exit(0);
        }
        WmoRoot wmoRoot = WmoRoot.read(new File(args[0]));
        for (BaseChunk chunk : wmoRoot.getChunks()) {
            System.out.println(chunk);
        }
    }
}
