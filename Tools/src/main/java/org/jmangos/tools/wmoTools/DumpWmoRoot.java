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
