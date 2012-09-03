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
package org.jmangos.tools.blp;

import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/**
 * References: http://madx.dk/wowdev/wiki/index.php?title=BLP
 * http://forum.worldwindcentral.com/showthread.php?p=71605
 * http://en.wikipedia.org/wiki/S3_Texture_Compression
 * http://oss.sgi.com/projects/ogl-sample/registry/EXT/texture_compression_s3tc.txt
 * http://msdn.microsoft.com/en-us/library/bb147243%28VS.85%29.aspx
 * 
 * This code is not at all optimized for performance nor for cleanliness.
 * 
 * ---
 * 
 * @author Dan Watling <dan@synaptik.com>
 **/
public class BLP {
    
    public byte[]       signature     = new byte[4];            // BLP2
    public int          type;                                   // 0 = JPEG compression; 1 =
                                                                 // Uncompressed or DirectX
                                                                 // compression
    public byte         encoding;                               // 1 for uncompressed, 2 for
                                                                 // DirectX compression
    public byte         alphaBitDepth;                          // 0, 1 or 8
    public byte         alphaEncoding;                          // 0 = DirectX 1 alpha (0/1 bit); 1
                                                                 // = DirectX 2/3 alpha (4-bit
                                                                 // alpha); 2 = DirectX 4/5 alpha
                                                                 // (interpolated)
    public byte         hasMips;                                // 0 = no mip maps; 1 = has mips (#
                                                                 // determined by dimensions)
    public int          width;
    public int          height;
    public int[]        mipmapOffsets = new int[16];
    public int[]        mipmapSize    = new int[16];
    public Color[]      palette       = new Color[256];
    public List<byte[]> mipmaps       = new ArrayList<byte[]>();
    
    public static BLP read(final ByteBuffer bb) {
    
        if (bb.capacity() < 20) {
            return null;
        }
        bb.order(ByteOrder.LITTLE_ENDIAN); // format is in little endian, ensure the buffer is too
        final BLP result = new BLP();
        bb.get(result.signature);
        result.type = bb.getInt();
        result.encoding = bb.get();
        result.alphaBitDepth = bb.get();
        result.alphaEncoding = bb.get();
        result.hasMips = bb.get();
        result.width = bb.getInt();
        result.height = bb.getInt();
        
        for (int index = 0; index < result.mipmapOffsets.length; index++) {
            result.mipmapOffsets[index] = bb.getInt();
        }
        for (int index = 0; index < result.mipmapSize.length; index++) {
            result.mipmapSize[index] = bb.getInt();
        }
        for (int index = 0; index < 256; index++) {
            final byte b = bb.get();
            final byte g = bb.get();
            final byte r = bb.get();
            bb.get(); // toss alpha value
            result.palette[index] = new Color(r, g, b); // RGB
        }
        
        readMipMaps(result, bb);
        return result;
    }
    
    @Override
    public String toString() {
    
        return "(" + this.width + "x" + this.height + ") " + this.type + "/" + this.encoding + "/" + this.alphaBitDepth + "/" + this.alphaEncoding;
    }
    
    private static void readMipMaps(final BLP result, final ByteBuffer bb) {
    
        for (int index = 0; index < result.mipmapOffsets.length; index++) {
            if ((result.mipmapOffsets[index] > 0) && (result.mipmapOffsets[index] < bb.capacity())) {
                bb.position(result.mipmapOffsets[index]);
                if ((bb.position() + result.mipmapSize[index]) > bb.capacity()) {
                    continue;
                }
                final byte[] data = new byte[result.mipmapSize[index]];
                bb.get(data);
                result.mipmaps.add(data);
            }
        }
    }
    
    public BufferedImage getBufferedImage() {
    
        if (this.mipmaps.size() == 0) {
            return null;
        }
        final ByteBuffer bb = ByteBuffer.wrap(this.mipmaps.get(0));
        bb.order(ByteOrder.LITTLE_ENDIAN);
        BufferedImage result = null;
        
        if ((this.type == 1) && (this.encoding == 1)) {
            if (this.alphaBitDepth == 0) {
                result = getBufferedImageUncompressed(bb, this.alphaBitDepth);
            } else if (this.alphaBitDepth == 1) {
                result = getBufferedImageUncompressed(bb, this.alphaBitDepth);
            } else if (this.alphaBitDepth == 8) {
                result = getBufferedImageUncompressed(bb, this.alphaBitDepth);
            }
        } else if ((this.type == 1) && (this.encoding == 2)) {
            if ((this.alphaBitDepth == 0) && (this.alphaEncoding == 0)) {
                // DTX1 (no alpha)
                result = getBufferedImageDXT1(bb, false);
            } else if ((this.alphaBitDepth == 1) && (this.alphaEncoding == 0)) {
                // DXT1 (alpha)
                result = getBufferedImageDXT1(bb, true);
            } else if ((this.alphaBitDepth == 8) && (this.alphaEncoding == 1)) {
                // DTX3
                result = getBufferedImageDXT3(bb);
            } else if ((this.alphaBitDepth == 8) && (this.alphaEncoding == 7)) {
                // DXT5
                result = getBufferedImageDXT5(bb);
            }
        }
        
        return result;
    }
    
    protected BufferedImage getBufferedImageUncompressed(final ByteBuffer bb, final int alphaBitDepth) {
    
        final BufferedImage result = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB_PRE);
        final int[][] colors = new int[this.height][this.width];
        final int[][] alpha = new int[this.height][this.width];
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                final byte paletteIndex = bb.get();
                int pIndex = paletteIndex;
                if (paletteIndex < 0) {
                    pIndex = 256 + paletteIndex;
                }
                colors[y][x] = this.palette[pIndex].asInt();
            }
        }
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                if (alphaBitDepth == 0) {
                    alpha[y][x] = 255 << 24;
                } else if (alphaBitDepth == 1) {
                    final byte b = bb.get();
                    int actualB = b;
                    if (actualB < 0) {
                        actualB = 256 + b;
                    }
                    for (int bit = 0; bit < 8; bit++) {
                        alpha[y][x + bit] = (255 * ((actualB >> bit) & 0x01)) << 24;
                    }
                    x += 7;
                } else {
                    final byte b = bb.get();
                    int actualB = b;
                    if (actualB < 0) {
                        actualB = 256 + b;
                    }
                    alpha[y][x] = actualB << 24;
                }
            }
        }
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                result.setRGB(x, y, colors[y][x] + alpha[y][x]);
            }
        }
        return result;
    }
    
    /**
     * DXT1 doesn't look right. Alpha is odd (INV_Misc_Bag_09_Blue.blp)
     * 
     * @param bb
     * @param alpha
     * @return
     */
    protected BufferedImage getBufferedImageDXT1(final ByteBuffer bb, final boolean alpha) {
    
        final int[] pixels = new int[16];
        
        final BufferedImage result = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB_PRE);
        
        final int numTilesWide = this.width / 4;
        final int numTilesHigh = this.height / 4;
        for (int i = 0; i < numTilesHigh; i++) {
            for (int j = 0; j < numTilesWide; j++) {
                final short c0 = bb.getShort();
                final short c1 = bb.getShort();
                int uC0 = c0;
                int uC1 = c1;
                
                if (uC0 < 0) {
                    uC0 = 65536 + c0;
                }
                if (uC1 < 0) {
                    uC1 = 65536 + c1;
                }
                final Color[] lookupTable = expandLookupTableDXT1(c0, c1, alpha);
                
                final int colorData = bb.getInt();
                
                for (int k = pixels.length - 1; k >= 0; k--) {
                    final int colorCode = (colorData >>> (k * 2)) & 0x03;
                    int alphaValue = 255;
                    if (alpha && (colorCode == 3) && (uC0 < uC1)) {
                        alphaValue = 0;
                    }
                    pixels[k] = (alphaValue << 24) | getPixel888(lookupTable[colorCode]);
                }
                
                result.setRGB(j * 4, i * 4, 4, 4, pixels, 0, 4);
            }
        }
        return result;
    }
    
    // Yanked from http://forum.worldwindcentral.com/showthread.php?p=71605
    protected BufferedImage getBufferedImageDXT3(final ByteBuffer bb) {
    
        final int[] pixels = new int[16];
        final int[] alphas = new int[16];
        
        final BufferedImage result = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB_PRE);
        
        final int numTilesWide = this.width / 4;
        final int numTilesHigh = this.height / 4;
        for (int i = 0; i < numTilesHigh; i++) {
            for (int j = 0; j < numTilesWide; j++) {
                // Read the alpha table.
                final long alphaData = bb.getLong();
                for (int k = alphas.length - 1; k >= 0; k--) {
                    alphas[k] = (int) (alphaData >>> (k * 4)) & 0xF; // Alphas are just 4 bits per
                                                                     // pixel
                    alphas[k] <<= 4;
                }
                
                final short minColor = bb.getShort();
                final short maxColor = bb.getShort();
                final Color[] lookupTable = expandLookupTableDXT3(minColor, maxColor);
                
                final int colorData = bb.getInt();
                
                for (int k = pixels.length - 1; k >= 0; k--) {
                    final int colorCode = (colorData >>> (k * 2)) & 0x03;
                    pixels[k] = (alphas[k] << 24) | getPixel888(lookupTable[colorCode]);
                }
                
                result.setRGB(j * 4, i * 4, 4, 4, pixels, 0, 4);
            }
        }
        return result;
    }
    
    protected BufferedImage getBufferedImageDXT5(final ByteBuffer bb) {
    
        final int[] pixels = new int[16];
        final int[] alphas = new int[16];
        
        final BufferedImage result = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB_PRE);
        
        final int numTilesWide = this.width / 4;
        final int numTilesHigh = this.height / 4;
        for (int i = 0; i < numTilesHigh; i++) {
            for (int j = 0; j < numTilesWide; j++) {
                final long data = bb.getLong();
                final short a0 = (short) (data & 0xFF);
                final short a1 = (short) ((data >> 8) & 0xFF);
                
                final int[] alphaTable = expandAlphaTable(a0, a1);
                
                long alphaData = data >>> 16;
                for (int k = 0; k < alphas.length; k++) {
                    final int alphaIndex = (int) (alphaData & 0x07);
                    alphas[k] = alphaTable[alphaIndex];
                    alphaData >>>= 3;
                }
                
                final short minColor = bb.getShort();
                final short maxColor = bb.getShort();
                final Color[] lookupTable = expandLookupTableDXT3(minColor, maxColor);
                
                final int colorData = bb.getInt();
                
                for (int k = pixels.length - 1; k >= 0; k--) {
                    final int colorCode = (colorData >>> (k * 2)) & 0x03;
                    pixels[k] = (alphas[k] << 24) | getPixel888(lookupTable[colorCode]);
                }
                
                result.setRGB(j * 4, i * 4, 4, 4, pixels, 0, 4);
            }
        }
        return result;
    }
    
    // Yanked from http://forum.worldwindcentral.com/showthread.php?p=71605
    protected static Color getColor565(final int pixel) {
    
        final Color color = new Color();
        
        color.r = (int) (((long) pixel) & 0xf800) >>> 8;
        color.g = (int) (((long) pixel) & 0x07e0) >>> 3;
        color.b = (int) (((long) pixel) & 0x001f) << 3;
        
        return color;
    }
    
    protected static Color getColor555(final int pixel) {
    
        final Color color = new Color();
        
        color.r = (int) (((long) pixel) & 0xf800) >>> 8;
        color.g = (int) (((long) pixel) & 0x07c0) >>> 3;
        color.b = (int) (((long) pixel) & 0x001f) << 3;
        
        return color;
    }
    
    private static int[] expandAlphaTable(final short a0, final short a1) {
    
        final int[] a = new int[] { a0, a1, 0, 0, 0, 0, 0, 0 };
        
        if (a[0] > a[1]) {
            a[2] = ((6 * a[0]) + (1 * a[1]) + 3) / 7;
            a[3] = ((5 * a[0]) + (2 * a[1]) + 3) / 7;
            a[4] = ((4 * a[0]) + (3 * a[1]) + 3) / 7;
            a[5] = ((3 * a[0]) + (4 * a[1]) + 3) / 7;
            a[6] = ((2 * a[0]) + (5 * a[1]) + 3) / 7;
            a[7] = ((1 * a[0]) + (6 * a[1]) + 3) / 7;
        } else {
            a[2] = ((4 * a[0]) + (1 * a[1]) + 2) / 5;
            a[3] = ((3 * a[0]) + (2 * a[1]) + 2) / 5;
            a[4] = ((2 * a[0]) + (3 * a[1]) + 2) / 5;
            a[5] = ((1 * a[0]) + (4 * a[1]) + 2) / 5;
            a[6] = 0;
            a[7] = 255;
        }
        
        return a;
    }
    
    // Yanked from http://forum.worldwindcentral.com/showthread.php?p=71605
    private static Color[] expandLookupTableDXT3(final short c0, final short c1) {
    
        final Color[] c = new Color[] { getColor565(c0), getColor565(c1), new Color(), new Color() };
        
        c[2].r = ((2 * c[0].r) + c[1].r + 1) / 3;
        c[2].g = ((2 * c[0].g) + c[1].g + 1) / 3;
        c[2].b = ((2 * c[0].b) + c[1].b + 1) / 3;
        
        c[3].r = (c[0].r + (2 * c[1].r) + 1) / 3;
        c[3].g = (c[0].g + (2 * c[1].g) + 1) / 3;
        c[3].b = (c[0].b + (2 * c[1].b) + 1) / 3;
        
        return c;
    }
    
    private static Color[] expandLookupTableDXT1(final short c0, final short c1, final boolean alpha) {
    
        int uC0 = c0;
        int uC1 = c1;
        
        if (uC0 < 0) {
            uC0 = 65536 + c0;
        }
        if (uC1 < 0) {
            uC1 = 65536 + c1;
        }
        final Color[] c = new Color[] { getColor565(c0), getColor565(c1), new Color(), new Color() };
        
        if ((alpha && (uC0 > uC1)) || !alpha) {
            c[2].r = ((2 * c[0].r) + c[1].r + 1) / 3;
            c[2].g = ((2 * c[0].g) + c[1].g + 1) / 3;
            c[2].b = ((2 * c[0].b) + c[1].b + 1) / 3;
            
            c[3].r = (c[0].r + 1 + (2 * c[1].r)) / 3;
            c[3].g = (c[0].g + 1 + (2 * c[1].g)) / 3;
            c[3].b = (c[0].b + 1 + (2 * c[1].b)) / 3;
        } else {
            c[2].r = (c[0].r + c[1].r + 1) / 2;
            c[2].g = (c[0].g + c[1].g + 1) / 2;
            c[2].b = (c[0].b + c[1].b + 1) / 2;
            
            c[3].r = 0;
            c[3].g = 0;
            c[3].b = 0;
        }
        
        return c;
    }
    
    // Yanked from http://forum.worldwindcentral.com/showthread.php?p=71605
    protected static int getPixel888(final Color color) {
    
        final int r = color.r;
        final int g = color.g;
        final int b = color.b;
        return (r << 16) | (g << 8) | b;
    }
    
}
