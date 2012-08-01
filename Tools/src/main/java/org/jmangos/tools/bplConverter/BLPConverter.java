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
package org.jmangos.tools.bplConverter;

import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.*;
import java.util.*;

import javax.imageio.ImageIO;

import org.jmangos.tools.blp.BLP;

public class BLPConverter {

	public static void main(String[] args) throws Exception {
			convertAllBLPsToPNGs("./blp");
	}

	protected static void convertAllBLPsToPNGs(String rootFolder)
			throws Exception {
		List<File> f = getAllBLPs(new File(rootFolder));

		for (int index = 0; index < f.size(); index++) {
			FileInputStream fis = null;
			try {
				ByteBuffer bb = ByteBuffer
						.allocate((int) f.get(index).length());
				fis = new FileInputStream(f.get(index));
				fis.getChannel().read(bb);
				bb.rewind();
				BLP blp = BLP.read(bb);
				if (blp != null) {
					BufferedImage bi = blp.getBufferedImage();
					System.out.println(blp.toString() + " - "
							+ f.get(index).getAbsolutePath());
					if (bi == null) {
						System.out.println("-- UNSUPPORTED --");
					} else {
						ImageIO.write(bi, "png", new File("./png/"+f.get(index)
								.getName()
								+ ".png"));
					}
				}
			} finally {
				if (fis != null) {
					fis.close();
				}
			}
		}
	}

	protected static List<File> getAllBLPs(File f) {
		List<File> result = new ArrayList<File>();

		if (f.isDirectory()) {
			File[] files = f.listFiles();
			for (int index = 0; index < files.length; index++) {
				if (files[index].isDirectory()
						&& !".svn".equals(files[index].getName())) {
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
