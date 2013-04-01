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
package org.jmangos.tools.openGL;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class PNGDecoder {

    public enum Format {
        ALPHA(1, true),
        LUMINANCE(1, false),
        LUMINANCE_ALPHA(2, true),
        RGB(3, false),
        RGBA(4, true),
        BGRA(4, true),
        ABGR(4, true);

        final int numComponents;
        final boolean hasAlpha;

        private Format(final int numComponents, final boolean hasAlpha) {

            this.numComponents = numComponents;
            this.hasAlpha = hasAlpha;
        }

        public int getNumComponents() {

            return this.numComponents;
        }

        public boolean isHasAlpha() {

            return this.hasAlpha;
        }
    }

    private static final byte[] SIGNATURE = { (byte) 137, 80, 78, 71, 13, 10, 26, 10 };

    private static final int IHDR = 0x49484452;
    private static final int PLTE = 0x504C5445;
    private static final int tRNS = 0x74524E53;
    private static final int IDAT = 0x49444154;
    @SuppressWarnings("unused")
    private static final int IEND = 0x49454E44;

    private static final byte COLOR_GREYSCALE = 0;
    private static final byte COLOR_TRUECOLOR = 2;
    private static final byte COLOR_INDEXED = 3;
    private static final byte COLOR_GREYALPHA = 4;
    private static final byte COLOR_TRUEALPHA = 6;

    private final InputStream input;
    private final CRC32 crc;
    private final byte[] buffer;

    private int chunkLength;
    private int chunkType;
    private int chunkRemaining;

    private int width;
    private int height;
    private int bitdepth;
    private int colorType;
    private int bytesPerPixel;
    private byte[] palette;
    private byte[] paletteA;
    private byte[] transPixel;

    public PNGDecoder(final InputStream input) throws IOException {

        this.input = input;
        this.crc = new CRC32();
        this.buffer = new byte[4096];

        readFully(this.buffer, 0, SIGNATURE.length);
        if (!checkSignature(this.buffer)) {
            throw new IOException("Not a valid PNG file");
        }

        openChunk(IHDR);
        readIHDR();
        closeChunk();

        searchIDAT:
        for (;;) {
            openChunk();
            switch (this.chunkType) {
                case IDAT:
                break searchIDAT;
                case PLTE:
                    readPLTE();
                break;
                case tRNS:
                    readtRNS();
                break;
            }
            closeChunk();
        }

        if ((this.colorType == COLOR_INDEXED) && (this.palette == null)) {
            throw new IOException("Missing PLTE chunk");
        }
    }

    public int getHeight() {

        return this.height;
    }

    public int getWidth() {

        return this.width;
    }

    /**
     * Checks if the image has a real alpha channel. This method does not check
     * for the presence of
     * a tRNS chunk.
     * 
     * @return true if the image has an alpha channel
     * @see #hasAlpha()
     */
    public boolean hasAlphaChannel() {

        return (this.colorType == COLOR_TRUEALPHA) || (this.colorType == COLOR_GREYALPHA);
    }

    /**
     * Checks if the image has transparency information either from an alpha
     * channel or from a tRNS
     * chunk.
     * 
     * @return true if the image has transparency
     * @see #hasAlphaChannel()
     * @see #overwriteTRNS(byte, byte, byte)
     */
    public boolean hasAlpha() {

        return hasAlphaChannel() || (this.paletteA != null) || (this.transPixel != null);
    }

    public boolean isRGB() {

        return (this.colorType == COLOR_TRUEALPHA) ||
            (this.colorType == COLOR_TRUECOLOR) ||
            (this.colorType == COLOR_INDEXED);
    }

    /**
     * Overwrites the tRNS chunk entry to make a selected color transparent.
     * <p>
     * This can only be invoked when the image has no alpha channel.
     * </p>
     * <p>
     * Calling this method causes {@link #hasAlpha()} to return true.
     * </p>
     * 
     * @param r
     *        the red component of the color to make transparent
     * @param g
     *        the green component of the color to make transparent
     * @param b
     *        the blue component of the color to make transparent
     * @throws UnsupportedOperationException
     *         if the tRNS chunk data can't be set
     * @see #hasAlphaChannel()
     */
    public void overwriteTRNS(final byte r, final byte g, final byte b) {

        if (hasAlphaChannel()) {
            throw new UnsupportedOperationException("image has an alpha channel");
        }
        final byte[] pal = this.palette;
        if (pal == null) {
            this.transPixel = new byte[] { 0, r, 0, g, 0, b };
        } else {
            this.paletteA = new byte[pal.length / 3];
            for (int i = 0, j = 0; i < pal.length; i += 3, j++) {
                if ((pal[i] != r) || (pal[i + 1] != g) || (pal[i + 2] != b)) {
                    this.paletteA[j] = (byte) 0xFF;
                }
            }
        }
    }

    /**
     * Computes the implemented format conversion for the desired format.
     * 
     * @param fmt
     *        the desired format
     * @return format which best matches the desired format
     * @throws UnsupportedOperationException
     *         if this PNG file can't be decoded
     */
    public Format decideTextureFormat(final Format fmt) {

        switch (this.colorType) {
            case COLOR_TRUECOLOR:
                switch (fmt) {
                    case ABGR:
                    case RGBA:
                    case BGRA:
                    case RGB:
                        return fmt;
                    default:
                        return Format.RGB;
                }
            case COLOR_TRUEALPHA:
                switch (fmt) {
                    case ABGR:
                    case RGBA:
                    case BGRA:
                    case RGB:
                        return fmt;
                    default:
                        return Format.RGBA;
                }
            case COLOR_GREYSCALE:
                switch (fmt) {
                    case LUMINANCE:
                    case ALPHA:
                        return fmt;
                    default:
                        return Format.LUMINANCE;
                }
            case COLOR_GREYALPHA:
                return Format.LUMINANCE_ALPHA;
            case COLOR_INDEXED:
                switch (fmt) {
                    case ABGR:
                    case RGBA:
                    case BGRA:
                        return fmt;
                    default:
                        return Format.RGBA;
                }
            default:
                throw new UnsupportedOperationException("Not yet implemented");
        }
    }

    /**
     * Decodes the image into the specified buffer. The first line is placed at
     * the current
     * position. After decode the buffer position is at the end of the last
     * line.
     * 
     * @param buffer
     *        the buffer
     * @param stride
     *        the stride in bytes from start of a line to start of the next
     *        line, can be
     *        negative.
     * @param fmt
     *        the target format into which the image should be decoded.
     * @throws IOException
     *         if a read or data error occurred
     * @throws IllegalArgumentException
     *         if the start position of a line falls outside the buffer
     * @throws UnsupportedOperationException
     *         if the image can't be decoded into the desired format
     */
    public void decode(final ByteBuffer buffer, final int stride, final Format fmt)
            throws IOException {

        final int offset = buffer.position();
        final int lineSize = (((this.width * this.bitdepth) + 7) / 8) * this.bytesPerPixel;
        byte[] curLine = new byte[lineSize + 1];
        byte[] prevLine = new byte[lineSize + 1];
        byte[] palLine = (this.bitdepth < 8) ? new byte[this.width + 1] : null;

        final Inflater inflater = new Inflater();
        try {
            for (int y = 0; y < this.height; y++) {
                readChunkUnzip(inflater, curLine, 0, curLine.length);
                unfilter(curLine, prevLine);

                buffer.position(offset + (y * stride));

                switch (this.colorType) {
                    case COLOR_TRUECOLOR:
                        switch (fmt) {
                            case ABGR:
                                copyRGBtoABGR(buffer, curLine);
                            break;
                            case RGBA:
                                copyRGBtoRGBA(buffer, curLine);
                            break;
                            case BGRA:
                                copyRGBtoBGRA(buffer, curLine);
                            break;
                            case RGB:
                                copy(buffer, curLine);
                            break;
                            default:
                                throw new UnsupportedOperationException(
                                        "Unsupported format for this image");
                        }
                    break;
                    case COLOR_TRUEALPHA:
                        switch (fmt) {
                            case ABGR:
                                copyRGBAtoABGR(buffer, curLine);
                            break;
                            case RGBA:
                                copy(buffer, curLine);
                            break;
                            case BGRA:
                                copyRGBAtoBGRA(buffer, curLine);
                            break;
                            case RGB:
                                copyRGBAtoRGB(buffer, curLine);
                            break;
                            default:
                                throw new UnsupportedOperationException(
                                        "Unsupported format for this image");
                        }
                    break;
                    case COLOR_GREYSCALE:
                        switch (fmt) {
                            case LUMINANCE:
                            case ALPHA:
                                copy(buffer, curLine);
                            break;
                            default:
                                throw new UnsupportedOperationException(
                                        "Unsupported format for this image");
                        }
                    break;
                    case COLOR_GREYALPHA:
                        switch (fmt) {
                            case LUMINANCE_ALPHA:
                                copy(buffer, curLine);
                            break;
                            default:
                                throw new UnsupportedOperationException(
                                        "Unsupported format for this image");
                        }
                    break;
                    case COLOR_INDEXED:
                        switch (this.bitdepth) {
                            case 8:
                                palLine = curLine;
                            break;
                            case 4:
                                expand4(curLine, palLine);
                            break;
                            case 2:
                                expand2(curLine, palLine);
                            break;
                            case 1:
                                expand1(curLine, palLine);
                            break;
                            default:
                                throw new UnsupportedOperationException(
                                        "Unsupported bitdepth for this image");
                        }
                        switch (fmt) {
                            case ABGR:
                                copyPALtoABGR(buffer, palLine);
                            break;
                            case RGBA:
                                copyPALtoRGBA(buffer, palLine);
                            break;
                            case BGRA:
                                copyPALtoBGRA(buffer, palLine);
                            break;
                            default:
                                throw new UnsupportedOperationException(
                                        "Unsupported format for this image");
                        }
                    break;
                    default:
                        throw new UnsupportedOperationException("Not yet implemented");
                }

                final byte[] tmp = curLine;
                curLine = prevLine;
                prevLine = tmp;
            }
        } finally {
            inflater.end();
        }
    }

    /**
     * Decodes the image into the specified buffer. The last line is placed at
     * the current position.
     * After decode the buffer position is at the end of the first line.
     * 
     * @param buffer
     *        the buffer
     * @param stride
     *        the stride in bytes from start of a line to start of the next
     *        line, must be
     *        positive.
     * @param fmt
     *        the target format into which the image should be decoded.
     * @throws IOException
     *         if a read or data error occurred
     * @throws IllegalArgumentException
     *         if the start position of a line falls outside the buffer
     * @throws UnsupportedOperationException
     *         if the image can't be decoded into the desired format
     */
    public void decodeFlipped(final ByteBuffer buffer, final int stride, final Format fmt)
            throws IOException {

        if (stride <= 0) {
            throw new IllegalArgumentException("stride");
        }
        final int pos = buffer.position();
        final int posDelta = (this.height - 1) * stride;
        buffer.position(pos + posDelta);
        decode(buffer, -stride, fmt);
        buffer.position(buffer.position() + posDelta);
    }

    private void copy(final ByteBuffer buffer, final byte[] curLine) {

        buffer.put(curLine, 1, curLine.length - 1);
    }

    private void copyRGBtoABGR(final ByteBuffer buffer, final byte[] curLine) {

        if (this.transPixel != null) {
            final byte tr = this.transPixel[1];
            final byte tg = this.transPixel[3];
            final byte tb = this.transPixel[5];
            for (int i = 1, n = curLine.length; i < n; i += 3) {
                final byte r = curLine[i];
                final byte g = curLine[i + 1];
                final byte b = curLine[i + 2];
                byte a = (byte) 0xFF;
                if ((r == tr) && (g == tg) && (b == tb)) {
                    a = 0;
                }
                buffer.put(a).put(b).put(g).put(r);
            }
        } else {
            for (int i = 1, n = curLine.length; i < n; i += 3) {
                buffer.put((byte) 0xFF).put(curLine[i + 2]).put(curLine[i + 1]).put(curLine[i]);
            }
        }
    }

    private void copyRGBtoRGBA(final ByteBuffer buffer, final byte[] curLine) {

        if (this.transPixel != null) {
            final byte tr = this.transPixel[1];
            final byte tg = this.transPixel[3];
            final byte tb = this.transPixel[5];
            for (int i = 1, n = curLine.length; i < n; i += 3) {
                final byte r = curLine[i];
                final byte g = curLine[i + 1];
                final byte b = curLine[i + 2];
                byte a = (byte) 0xFF;
                if ((r == tr) && (g == tg) && (b == tb)) {
                    a = 0;
                }
                buffer.put(r).put(g).put(b).put(a);
            }
        } else {
            for (int i = 1, n = curLine.length; i < n; i += 3) {
                buffer.put(curLine[i]).put(curLine[i + 1]).put(curLine[i + 2]).put((byte) 0xFF);
            }
        }
    }

    private void copyRGBtoBGRA(final ByteBuffer buffer, final byte[] curLine) {

        if (this.transPixel != null) {
            final byte tr = this.transPixel[1];
            final byte tg = this.transPixel[3];
            final byte tb = this.transPixel[5];
            for (int i = 1, n = curLine.length; i < n; i += 3) {
                final byte r = curLine[i];
                final byte g = curLine[i + 1];
                final byte b = curLine[i + 2];
                byte a = (byte) 0xFF;
                if ((r == tr) && (g == tg) && (b == tb)) {
                    a = 0;
                }
                buffer.put(b).put(g).put(r).put(a);
            }
        } else {
            for (int i = 1, n = curLine.length; i < n; i += 3) {
                buffer.put(curLine[i + 2]).put(curLine[i + 1]).put(curLine[i]).put((byte) 0xFF);
            }
        }
    }

    private void copyRGBAtoABGR(final ByteBuffer buffer, final byte[] curLine) {

        for (int i = 1, n = curLine.length; i < n; i += 4) {
            buffer.put(curLine[i + 3]).put(curLine[i + 2]).put(curLine[i + 1]).put(curLine[i]);
        }
    }

    private void copyRGBAtoBGRA(final ByteBuffer buffer, final byte[] curLine) {

        for (int i = 1, n = curLine.length; i < n; i += 4) {
            buffer.put(curLine[i + 2]).put(curLine[i + 1]).put(curLine[i]).put(curLine[i + 3]);
        }
    }

    private void copyRGBAtoRGB(final ByteBuffer buffer, final byte[] curLine) {

        for (int i = 1, n = curLine.length; i < n; i += 4) {
            buffer.put(curLine[i]).put(curLine[i + 1]).put(curLine[i + 2]);
        }
    }

    private void copyPALtoABGR(final ByteBuffer buffer, final byte[] curLine) {

        if (this.paletteA != null) {
            for (int i = 1, n = curLine.length; i < n; i += 1) {
                final int idx = curLine[i] & 255;
                final byte r = this.palette[(idx * 3) + 0];
                final byte g = this.palette[(idx * 3) + 1];
                final byte b = this.palette[(idx * 3) + 2];
                final byte a = this.paletteA[idx];
                buffer.put(a).put(b).put(g).put(r);
            }
        } else {
            for (int i = 1, n = curLine.length; i < n; i += 1) {
                final int idx = curLine[i] & 255;
                final byte r = this.palette[(idx * 3) + 0];
                final byte g = this.palette[(idx * 3) + 1];
                final byte b = this.palette[(idx * 3) + 2];
                final byte a = (byte) 0xFF;
                buffer.put(a).put(b).put(g).put(r);
            }
        }
    }

    private void copyPALtoRGBA(final ByteBuffer buffer, final byte[] curLine) {

        if (this.paletteA != null) {
            for (int i = 1, n = curLine.length; i < n; i += 1) {
                final int idx = curLine[i] & 255;
                final byte r = this.palette[(idx * 3) + 0];
                final byte g = this.palette[(idx * 3) + 1];
                final byte b = this.palette[(idx * 3) + 2];
                final byte a = this.paletteA[idx];
                buffer.put(r).put(g).put(b).put(a);
            }
        } else {
            for (int i = 1, n = curLine.length; i < n; i += 1) {
                final int idx = curLine[i] & 255;
                final byte r = this.palette[(idx * 3) + 0];
                final byte g = this.palette[(idx * 3) + 1];
                final byte b = this.palette[(idx * 3) + 2];
                final byte a = (byte) 0xFF;
                buffer.put(r).put(g).put(b).put(a);
            }
        }
    }

    private void copyPALtoBGRA(final ByteBuffer buffer, final byte[] curLine) {

        if (this.paletteA != null) {
            for (int i = 1, n = curLine.length; i < n; i += 1) {
                final int idx = curLine[i] & 255;
                final byte r = this.palette[(idx * 3) + 0];
                final byte g = this.palette[(idx * 3) + 1];
                final byte b = this.palette[(idx * 3) + 2];
                final byte a = this.paletteA[idx];
                buffer.put(b).put(g).put(r).put(a);
            }
        } else {
            for (int i = 1, n = curLine.length; i < n; i += 1) {
                final int idx = curLine[i] & 255;
                final byte r = this.palette[(idx * 3) + 0];
                final byte g = this.palette[(idx * 3) + 1];
                final byte b = this.palette[(idx * 3) + 2];
                final byte a = (byte) 0xFF;
                buffer.put(b).put(g).put(r).put(a);
            }
        }
    }

    private void expand4(final byte[] src, final byte[] dst) {

        for (int i = 1, n = dst.length; i < n; i += 2) {
            final int val = src[1 + (i >> 1)] & 255;
            switch (n - i) {
                default:
                    dst[i + 1] = (byte) (val & 15);
                case 1:
                    dst[i] = (byte) (val >> 4);
            }
        }
    }

    private void expand2(final byte[] src, final byte[] dst) {

        for (int i = 1, n = dst.length; i < n; i += 4) {
            final int val = src[1 + (i >> 2)] & 255;
            switch (n - i) {
                default:
                    dst[i + 3] = (byte) ((val) & 3);
                case 3:
                    dst[i + 2] = (byte) ((val >> 2) & 3);
                case 2:
                    dst[i + 1] = (byte) ((val >> 4) & 3);
                case 1:
                    dst[i] = (byte) ((val >> 6));
            }
        }
    }

    private void expand1(final byte[] src, final byte[] dst) {

        for (int i = 1, n = dst.length; i < n; i += 8) {
            final int val = src[1 + (i >> 3)] & 255;
            switch (n - i) {
                default:
                    dst[i + 7] = (byte) ((val) & 1);
                case 7:
                    dst[i + 6] = (byte) ((val >> 1) & 1);
                case 6:
                    dst[i + 5] = (byte) ((val >> 2) & 1);
                case 5:
                    dst[i + 4] = (byte) ((val >> 3) & 1);
                case 4:
                    dst[i + 3] = (byte) ((val >> 4) & 1);
                case 3:
                    dst[i + 2] = (byte) ((val >> 5) & 1);
                case 2:
                    dst[i + 1] = (byte) ((val >> 6) & 1);
                case 1:
                    dst[i] = (byte) ((val >> 7));
            }
        }
    }

    private void unfilter(final byte[] curLine, final byte[] prevLine) throws IOException {

        switch (curLine[0]) {
            case 0: // none
            break;
            case 1:
                unfilterSub(curLine);
            break;
            case 2:
                unfilterUp(curLine, prevLine);
            break;
            case 3:
                unfilterAverage(curLine, prevLine);
            break;
            case 4:
                unfilterPaeth(curLine, prevLine);
            break;
            default:
                throw new IOException("invalide filter type in scanline: " + curLine[0]);
        }
    }

    private void unfilterSub(final byte[] curLine) {

        final int bpp = this.bytesPerPixel;
        for (int i = bpp + 1, n = curLine.length; i < n; ++i) {
            curLine[i] += curLine[i - bpp];
        }
    }

    private void unfilterUp(final byte[] curLine, final byte[] prevLine) {

        for (int i = 1, n = curLine.length; i < n; ++i) {
            curLine[i] += prevLine[i];
        }
    }

    private void unfilterAverage(final byte[] curLine, final byte[] prevLine) {

        final int bpp = this.bytesPerPixel;

        int i;
        for (i = 1; i <= bpp; ++i) {
            curLine[i] += (byte) ((prevLine[i] & 0xFF) >>> 1);
        }
        for (final int n = curLine.length; i < n; ++i) {
            curLine[i] += (byte) (((prevLine[i] & 0xFF) + (curLine[i - bpp] & 0xFF)) >>> 1);
        }
    }

    private void unfilterPaeth(final byte[] curLine, final byte[] prevLine) {

        final int bpp = this.bytesPerPixel;

        int i;
        for (i = 1; i <= bpp; ++i) {
            curLine[i] += prevLine[i];
        }
        for (final int n = curLine.length; i < n; ++i) {
            final int a = curLine[i - bpp] & 255;
            final int b = prevLine[i] & 255;
            int c = prevLine[i - bpp] & 255;
            final int p = (a + b) - c;
            int pa = p - a;
            if (pa < 0) {
                pa = -pa;
            }
            int pb = p - b;
            if (pb < 0) {
                pb = -pb;
            }
            int pc = p - c;
            if (pc < 0) {
                pc = -pc;
            }
            if ((pa <= pb) && (pa <= pc)) {
                c = a;
            } else if (pb <= pc) {
                c = b;
            }
            curLine[i] += (byte) c;
        }
    }

    private void readIHDR() throws IOException {

        checkChunkLength(13);
        readChunk(this.buffer, 0, 13);
        this.width = readInt(this.buffer, 0);
        this.height = readInt(this.buffer, 4);
        this.bitdepth = this.buffer[8] & 255;
        this.colorType = this.buffer[9] & 255;

        switch (this.colorType) {
            case COLOR_GREYSCALE:
                if (this.bitdepth != 8) {
                    throw new IOException("Unsupported bit depth: " + this.bitdepth);
                }
                this.bytesPerPixel = 1;
            break;
            case COLOR_GREYALPHA:
                if (this.bitdepth != 8) {
                    throw new IOException("Unsupported bit depth: " + this.bitdepth);
                }
                this.bytesPerPixel = 2;
            break;
            case COLOR_TRUECOLOR:
                if (this.bitdepth != 8) {
                    throw new IOException("Unsupported bit depth: " + this.bitdepth);
                }
                this.bytesPerPixel = 3;
            break;
            case COLOR_TRUEALPHA:
                if (this.bitdepth != 8) {
                    throw new IOException("Unsupported bit depth: " + this.bitdepth);
                }
                this.bytesPerPixel = 4;
            break;
            case COLOR_INDEXED:
                switch (this.bitdepth) {
                    case 8:
                    case 4:
                    case 2:
                    case 1:
                        this.bytesPerPixel = 1;
                    break;
                    default:
                        throw new IOException("Unsupported bit depth: " + this.bitdepth);
                }
            break;
            default:
                throw new IOException("unsupported color format: " + this.colorType);
        }

        if (this.buffer[10] != 0) {
            throw new IOException("unsupported compression method");
        }
        if (this.buffer[11] != 0) {
            throw new IOException("unsupported filtering method");
        }
        if (this.buffer[12] != 0) {
            throw new IOException("unsupported interlace method");
        }
    }

    private void readPLTE() throws IOException {

        final int paletteEntries = this.chunkLength / 3;
        if ((paletteEntries < 1) || (paletteEntries > 256) || ((this.chunkLength % 3) != 0)) {
            throw new IOException("PLTE chunk has wrong length");
        }
        this.palette = new byte[paletteEntries * 3];
        readChunk(this.palette, 0, this.palette.length);
    }

    private void readtRNS() throws IOException {

        switch (this.colorType) {
            case COLOR_GREYSCALE:
                checkChunkLength(2);
                this.transPixel = new byte[2];
                readChunk(this.transPixel, 0, 2);
            break;
            case COLOR_TRUECOLOR:
                checkChunkLength(6);
                this.transPixel = new byte[6];
                readChunk(this.transPixel, 0, 6);
            break;
            case COLOR_INDEXED:
                if (this.palette == null) {
                    throw new IOException("tRNS chunk without PLTE chunk");
                }
                this.paletteA = new byte[this.palette.length / 3];
                Arrays.fill(this.paletteA, (byte) 0xFF);
                readChunk(this.paletteA, 0, this.paletteA.length);
            break;
            default:
                // just ignore it
        }
    }

    private void closeChunk() throws IOException {

        if (this.chunkRemaining > 0) {
            // just skip the rest and the CRC
            skip(this.chunkRemaining + 4);
        } else {
            readFully(this.buffer, 0, 4);
            final int expectedCrc = readInt(this.buffer, 0);
            final int computedCrc = (int) this.crc.getValue();
            if (computedCrc != expectedCrc) {
                throw new IOException("Invalid CRC");
            }
        }
        this.chunkRemaining = 0;
        this.chunkLength = 0;
        this.chunkType = 0;
    }

    private void openChunk() throws IOException {

        readFully(this.buffer, 0, 8);
        this.chunkLength = readInt(this.buffer, 0);
        this.chunkType = readInt(this.buffer, 4);
        this.chunkRemaining = this.chunkLength;
        this.crc.reset();
        this.crc.update(this.buffer, 4, 4); // only chunkType
    }

    private void openChunk(final int expected) throws IOException {

        openChunk();
        if (this.chunkType != expected) {
            throw new IOException("Expected chunk: " + Integer.toHexString(expected));
        }
    }

    private void checkChunkLength(final int expected) throws IOException {

        if (this.chunkLength != expected) {
            throw new IOException("Chunk has wrong size");
        }
    }

    private int readChunk(final byte[] buffer, final int offset, int length) throws IOException {

        if (length > this.chunkRemaining) {
            length = this.chunkRemaining;
        }
        readFully(buffer, offset, length);
        this.crc.update(buffer, offset, length);
        this.chunkRemaining -= length;
        return length;
    }

    private void refillInflater(final Inflater inflater) throws IOException {

        while (this.chunkRemaining == 0) {
            closeChunk();
            openChunk(IDAT);
        }
        final int read = readChunk(this.buffer, 0, this.buffer.length);
        inflater.setInput(this.buffer, 0, read);
    }

    private void readChunkUnzip(final Inflater inflater, final byte[] buffer, int offset, int length)
            throws IOException {

        assert (buffer != this.buffer);
        try {
            do {
                final int read = inflater.inflate(buffer, offset, length);
                if (read <= 0) {
                    if (inflater.finished()) {
                        throw new EOFException();
                    }
                    if (inflater.needsInput()) {
                        refillInflater(inflater);
                    } else {
                        throw new IOException("Can't inflate " + length + " bytes");
                    }
                } else {
                    offset += read;
                    length -= read;
                }
            } while (length > 0);
        } catch (final DataFormatException ex) {
            throw (IOException) (new IOException("inflate error").initCause(ex));
        }
    }

    private void readFully(final byte[] buffer, int offset, int length) throws IOException {

        do {
            final int read = this.input.read(buffer, offset, length);
            if (read < 0) {
                throw new EOFException();
            }
            offset += read;
            length -= read;
        } while (length > 0);
    }

    private int readInt(final byte[] buffer, final int offset) {

        return ((buffer[offset]) << 24) |
            ((buffer[offset + 1] & 255) << 16) |
            ((buffer[offset + 2] & 255) << 8) |
            ((buffer[offset + 3] & 255));
    }

    private void skip(long amount) throws IOException {

        while (amount > 0) {
            final long skipped = this.input.skip(amount);
            if (skipped < 0) {
                throw new EOFException();
            }
            amount -= skipped;
        }
    }

    private static boolean checkSignature(final byte[] buffer) {

        for (int i = 0; i < SIGNATURE.length; i++) {
            if (buffer[i] != SIGNATURE[i]) {
                return false;
            }
        }
        return true;
    }
}
