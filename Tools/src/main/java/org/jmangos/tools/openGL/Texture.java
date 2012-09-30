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
package org.jmangos.tools.openGL;

import org.lwjgl.opengl.GL11;

/**
 * Modified code originally written by:
 * 
 * @author Kevin Glass
 * @author Brian Matzon
 */
public class Texture {

    /** The GL target type */
    public int target;
    /** The GL texture ID */
    public int textureID;
    /** The height of the image */
    private int height;
    /** The width of the image */
    private int width;
    /** The width of the texture */
    private int texWidth;
    /** The height of the texture */
    private int texHeight;
    /** The ratio of the width of the image to the texture */
    private float widthRatio;
    /** The ratio of the height of the image to the texture */
    private float heightRatio;

    /**
     * Create a new texture
     * 
     * @param target
     *        The GL target
     * @param textureID
     *        The GL texture ID
     */
    public Texture(final int target, final int textureID) {

        this.target = target;
        this.textureID = textureID;
    }

    /**
     * Bind the specified GL context to a texture
     * 
     * @param gl
     *        The GL context to bind to
     */
    public void bind() {

        GL11.glBindTexture(this.target, this.textureID);
    }

    /**
     * Set the height of the image
     * 
     * @param height
     *        The height of the image
     */
    public void setHeight(final int height) {

        this.height = height;
        setHeight();
    }

    /**
     * Set the width of the image
     * 
     * @param width
     *        The width of the image
     */
    public void setWidth(final int width) {

        this.width = width;
        setWidth();
    }

    /**
     * Get the height of the original image
     * 
     * @return The height of the original image
     */
    public int getImageHeight() {

        return (this.height);
    }

    /**
     * Get the width of the original image
     * 
     * @return The width of the original image
     */
    public int getImageWidth() {

        return (this.width);
    }

    /**
     * Get the height of the physical texture
     * 
     * @return The height of physical texture
     */
    public float getHeight() {

        return this.heightRatio;
    }

    /**
     * Get the width of the physical texture
     * 
     * @return The width of physical texture
     */
    public float getWidth() {

        return this.widthRatio;
    }

    /**
     * Set the height of this texture
     * 
     * @param texHeight
     *        The height of the texture
     */
    public void setTextureHeight(final int texHeight) {

        this.texHeight = texHeight;
        setHeight();
    }

    /**
     * Set the width of this texture
     * 
     * @param texWidth
     *        The width of the texture
     */
    public void setTextureWidth(final int texWidth) {

        this.texWidth = texWidth;
        setWidth();
    }

    /**
     * Set the height of the texture. This will update the ratio also.
     */
    private void setHeight() {

        if (this.texHeight != 0) {
            this.heightRatio = ((float) this.height) / this.texHeight;
        }
    }

    /**
     * Set the width of the texture. This will update the ratio also.
     */
    private void setWidth() {

        if (this.texWidth != 0) {
            this.widthRatio = ((float) this.width) / this.texWidth;
        }
    }
}
