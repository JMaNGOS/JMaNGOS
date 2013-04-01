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
package org.jmangos.tools.blpConverter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.jmangos.tools.blp.BLP;

public class BLPConverter {

    public static void main(final String[] args) throws Exception {

        convertAllBLPsToPNGs("./blp");
    }

    protected static void convertAllBLPsToPNGs(final String rootFolder) throws Exception {

        final List<File> f = getAllBLPs(new File(rootFolder));

        for (int index = 0; index < f.size(); index++) {
            FileInputStream fis = null;
            try {
                final ByteBuffer bb = ByteBuffer.allocate((int) f.get(index).length());
                fis = new FileInputStream(f.get(index));
                fis.getChannel().read(bb);
                bb.rewind();
                final BLP blp = BLP.read(bb);
                if (blp != null) {
                    final BufferedImage bi = blp.getBufferedImage();
                    System.out.println(blp.toString() + " - " + f.get(index).getAbsolutePath());
                    if (bi == null) {
                        System.out.println("-- UNSUPPORTED --");
                    } else {
                        ImageIO.write(bi, "png", new File("./png/" +
                            f.get(index).getName() +
                            ".png"));
                    }
                }
            } finally {
                if (fis != null) {
                    fis.close();
                }
            }
        }
    }

    protected static List<File> getAllBLPs(final File f) {

        final List<File> result = new ArrayList<File>();

        if (f.isDirectory()) {
            final File[] files = f.listFiles();
            for (int index = 0; index < files.length; index++) {
                if (files[index].isDirectory() && !".svn".equals(files[index].getName())) {
                    result.addAll(getAllBLPs(files[index]));
                }
                if (files[index].getName().toUpperCase().endsWith("BLP")) {
                    result.add(files[index]);
                }
            }
        } else {
            result.add(f);
        }
        return result;

    }
}
