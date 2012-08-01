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
package org.jmangos.tools.openGL;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import org.lwjgl.Sys;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

/**
 * Modified from code originally written by:
 * @author Kevin Glass
 * @author Brian Matzon
 * 
 */
public class TextureLoader {
	/** The table of textures that have been loaded in this loader */
	private HashMap<String, Texture> table = new HashMap<String, Texture>();
	
	/** The colour model including alpha for the GL image */
	public ColorModel glAlphaColorModel;
	
	/** The colour model for the GL image */
	private ColorModel glColorModel;
	
	private int target = GL11.GL_TEXTURE_2D;
	private int dstPixelFormat = GL11.GL_RGBA;
	//private int dstPixelFormat = GL13.GL_COMPRESSED_RGBA;
	private int minFilter = GL11.GL_LINEAR;
	private int magFilter = GL11.GL_LINEAR;
	
	/** 
	 * Create a new texture loader based on the game panel
	 *
	 * @param gl The GL content in which the textures should be loaded
	 */
	public TextureLoader() {
		//dstPixelFormat = 4;
		
		glAlphaColorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB),
				new int[] {8,8,8,8},
				true,
				false,
				ComponentColorModel.TRANSLUCENT,
				DataBuffer.TYPE_BYTE);
		
		glColorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB),
				new int[] {8,8,8,0},
				false,
				false,
				ComponentColorModel.OPAQUE,
				DataBuffer.TYPE_BYTE);
	}
	
	/**
	 * Create a new texture ID 
	 *
	 * @return A new texture ID
	 */
	private int createTextureID() 
	{ 
		IntBuffer tmp = createIntBuffer(1); 
		try {
			GL11.glGenTextures(tmp);
		} catch (NullPointerException e) {
			//e.printStackTrace();
			Sys.alert("Error","Your system is not capable of running this game.\nPlease make sure your video drivers are current.");
			System.exit(0);
		}
		return tmp.get(0);
	} 
	
	/**
	 * Load a texture
	 *
	 * @param resourceName The location of the resource to load
	 * @return The loaded texture
	 * @throws IOException Indicates a failure to access the resource
	 */
	public Texture getTexture(String resourceName, boolean injar) throws IOException {
		Texture tex = table.get(resourceName);
		
		if (tex != null) {
			return tex;
		}
		
		tex = getTexture(resourceName, injar,
				target, // target
				dstPixelFormat,     // dst pixel format
				minFilter, // min filter (unused)
				magFilter);
		
		table.put(resourceName,tex);
		
		return tex;
	}
	
	/**
	 * Load a texture into OpenGL from a image reference on
	 * disk.
	 *
	 * @param resourceName The location of the resource to load
	 * @param target The GL target to load the texture against
	 * @param dstPixelFormat The pixel format of the screen
	 * @param minFilter The minimising filter
	 * @param magFilter The magnification filter
	 * @return The loaded texture
	 * @throws IOException Indicates a failure to access the resource
	 */
	public Texture getTexture(String resourceName, boolean injar,
			int target, 
			int dstPixelFormat, 
			int minFilter, 
			int magFilter) throws IOException 
			{ 
		int srcPixelFormat = 0;
		
		// create the texture ID for this texture 
		int textureID = createTextureID(); 
		Texture texture = new Texture(target,textureID); 
		
		// bind this texture 
		GL11.glBindTexture(target, textureID); 
		
		BufferedImage bufferedImage = loadImage(resourceName, injar); 
		texture.setWidth(bufferedImage.getWidth());
		texture.setHeight(bufferedImage.getHeight());
		
		if (bufferedImage.getColorModel().hasAlpha()) {
			srcPixelFormat = GL11.GL_RGBA;
		} else {
			srcPixelFormat = GL11.GL_RGB;
		}
		
		// convert that image into a byte buffer of texture data 
		ByteBuffer textureBuffer = convertImageData(bufferedImage,texture); 
		
		if (target == GL11.GL_TEXTURE_2D) 
		{ 
			GL11.glTexParameteri(target, GL11.GL_TEXTURE_WRAP_S, GL11.GL_REPEAT);
			GL11.glTexParameteri(target, GL11.GL_TEXTURE_WRAP_T, GL11.GL_REPEAT);
			GL11.glTexParameteri(target, GL11.GL_TEXTURE_MIN_FILTER, minFilter); 
			GL11.glTexParameteri(target, GL11.GL_TEXTURE_MAG_FILTER, magFilter); 
		} 
		
		// produce a texture from the byte buffer
		/*
		GL11.glTexImage2D(target, 
				0, 
				dstPixelFormat, 
				get2Fold(bufferedImage.getWidth()), 
				get2Fold(bufferedImage.getHeight()), 
				0, 
				srcPixelFormat, 
				GL11.GL_UNSIGNED_BYTE, 
				textureBuffer ); 
		 */
		
		GLU.gluBuild2DMipmaps(target, dstPixelFormat, get2Fold(bufferedImage.getWidth()), 
				get2Fold(bufferedImage.getHeight()), srcPixelFormat, GL11.GL_UNSIGNED_BYTE, textureBuffer); 

		return texture; 
			} 
	
	
	
	
	/**
	 * Get the closest greater power of 2 to the fold number
	 * 
	 * @param fold The target number
	 * @return The power of 2
	 */
	private int get2Fold(int fold) {
		int ret = 2;
		while (ret < fold) {
			ret *= 2;
		}
		return ret;
	} 
	
	/**
	 * Convert the buffered image to a texture
	 *
	 * @param bufferedImage The image to convert to a texture
	 * @param texture The texture to store the data into
	 * @return A buffer containing the data
	 */
	private ByteBuffer convertImageData(BufferedImage bufferedImage,Texture texture) { 
		ByteBuffer imageBuffer = null; 
		WritableRaster raster;
		BufferedImage texImage;
		
		int texWidth = 2;
		int texHeight = 2;
		
		// find the closest power of 2 for the width and height
		// of the produced texture
		while (texWidth < bufferedImage.getWidth()) {
			texWidth *= 2;
		}
		while (texHeight < bufferedImage.getHeight()) {
			texHeight *= 2;
		}
		
		texture.setTextureHeight(texHeight);
		texture.setTextureWidth(texWidth);
		
		// create a raster that can be used by OpenGL as a source
		// for a texture
		if (bufferedImage.getColorModel().hasAlpha()) {
			raster = Raster.createInterleavedRaster(DataBuffer.TYPE_BYTE,texWidth,texHeight,4,null);
			texImage = new BufferedImage(glAlphaColorModel,raster,false,new Hashtable());
		} else {
			raster = Raster.createInterleavedRaster(DataBuffer.TYPE_BYTE,texWidth,texHeight,3,null);
			texImage = new BufferedImage(glColorModel,raster,false,new Hashtable());
		}
		
		// copy the source image into the produced image
		Graphics g = texImage.getGraphics();
		g.setColor(new Color(0f,0f,0f,0f));
		g.fillRect(0,0,texWidth,texHeight);
		g.drawImage(bufferedImage,0,0,null);
		
		// build a byte buffer from the temporary image 
		// that be used by OpenGL to produce a texture.
		byte[] data = ((DataBufferByte) texImage.getRaster().getDataBuffer()).getData(); 
		
		imageBuffer = ByteBuffer.allocateDirect(data.length); 
		imageBuffer.order(ByteOrder.nativeOrder()); 
		imageBuffer.put(data, 0, data.length); 
		imageBuffer.flip();
		
		return imageBuffer; 
	} 
	
	/** 
	 * Load a given resource as a buffered image
	 * 
	 * @param ref The location of the resource to load
	 * @return The loaded buffered image
	 * @throws IOException Indicates a failure to find a resource
	 */
	private BufferedImage loadImage(String ref, boolean injar) throws IOException 
	{ 
		//URL url = TextureLoader.class.getClassLoader().getResource(ref);
		
		//if (url == null) {
		//	throw new IOException("Cannot find: "+ref);
		//}
		
		if (injar) {
			BufferedImage bufferedImage = ImageIO.read(new BufferedInputStream(getClass().getClassLoader().getResourceAsStream(ref)));
			return bufferedImage;
		} else {
			File file = new File(ref);
			BufferedImage bufferedImage = null; 
			try {
				bufferedImage = ImageIO.read(file);
			} catch (IOException e) {
				System.out.println("Could not load texture: " + ref);
			}
			return bufferedImage;
		}
		
	}
	
	/**
	 * Creates an integer buffer to hold specified ints
	 * - strictly a utility method
	 *
	 * @param size how many int to contain
	 * @return created IntBuffer
	 */
	protected IntBuffer createIntBuffer(int size) {
		ByteBuffer temp = ByteBuffer.allocateDirect(4 * size);
		temp.order(ByteOrder.nativeOrder());
		
		return temp.asIntBuffer();
	}   
	

	//////////////////////////////////////////////////
	//// Added for BufferedImage Support /////////////
	//////////////////////////////////////////////////
	/**
	 * Load a texture
	 *
	 * @param resourceName The location of the resource to load
	 * @return The loaded texture
	 * @throws IOException Indicates a failure to access the resource
	 */
	public Texture getTexture(String resourceName, BufferedImage resourceImage) throws IOException {
		Texture tex = table.get(resourceName);
		
		if (tex != null) {
			return tex;
		}
		
		tex = getTexture(resourceImage, 
				target, // target
				dstPixelFormat,     // dst pixel format
				minFilter, // min filter (unused)
				magFilter);
		
		table.put(resourceName,tex);
		
		return tex;
	}
	
	/**
	 * Load a texture into OpenGL from a BufferedImage
	 *
	 * @param resourceName The location of the resource to load
	 * @param target The GL target to load the texture against
	 * @param dstPixelFormat The pixel format of the screen
	 * @param minFilter The minimising filter
	 * @param magFilter The magnification filter
	 * @return The loaded texture
	 * @throws IOException Indicates a failure to access the resource
	 */
	public Texture getTexture(BufferedImage resourceimage, 
			int target, 
			int dstPixelFormat, 
			int minFilter, 
			int magFilter) throws IOException 
			{ 
		int srcPixelFormat = 0;
		
		// create the texture ID for this texture 
		int textureID = createTextureID(); 
		Texture texture = new Texture(target,textureID); 
		
		// bind this texture 
		GL11.glBindTexture(target, textureID); 
		
		BufferedImage bufferedImage = resourceimage; 
		texture.setWidth(bufferedImage.getWidth());
		texture.setHeight(bufferedImage.getHeight());
		
		if (bufferedImage.getColorModel().hasAlpha()) {
			srcPixelFormat = GL11.GL_RGBA;
		} else {
			srcPixelFormat = GL11.GL_RGB;
		}
		
		// convert that image into a byte buffer of texture data 
		ByteBuffer textureBuffer = convertImageData(bufferedImage,texture); 
		
		if (target == GL11.GL_TEXTURE_2D) 
		{ 
			GL11.glTexParameteri(target, GL11.GL_TEXTURE_WRAP_S, GL11.GL_REPEAT);
			GL11.glTexParameteri(target, GL11.GL_TEXTURE_WRAP_T, GL11.GL_REPEAT);
			GL11.glTexParameteri(target, GL11.GL_TEXTURE_MIN_FILTER, minFilter); 
			GL11.glTexParameteri(target, GL11.GL_TEXTURE_MAG_FILTER, magFilter); 
		} 
		
		// produce a texture from the byte buffer
		/*
		GL11.glTexImage2D(target, 
				0, 
				dstPixelFormat, 
				get2Fold(bufferedImage.getWidth()), 
				get2Fold(bufferedImage.getHeight()), 
				0, 
				srcPixelFormat, 
				GL11.GL_UNSIGNED_BYTE, 
				textureBuffer ); 
		 */
		
		GLU.gluBuild2DMipmaps(target, dstPixelFormat, get2Fold(bufferedImage.getWidth()), 
				get2Fold(bufferedImage.getHeight()), srcPixelFormat, GL11.GL_UNSIGNED_BYTE, textureBuffer); 

		return texture; 
			} 
	
	
	
	//////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////
	
	


	//////////////////////////////////////////////////
	//// Added for No MipMapping Support /////////////
	//////////////////////////////////////////////////
	/**
	 * Load a texture
	 *
	 * @param resourceName The location of the resource to load
	 * @return The loaded texture
	 * @throws IOException Indicates a failure to access the resource
	 */
	public Texture getNMMTexture(String resourceName, BufferedImage resourceImage) throws IOException {
		Texture tex = table.get(resourceName);
		
		if (tex != null) {
			return tex;
		}
		
		tex = getNMMTexture(resourceImage, 
				target, // target
				dstPixelFormat,     // dst pixel format
				GL11.GL_NEAREST, // min filter (unused)
				GL11.GL_LINEAR);
		
		table.put(resourceName,tex);
		
		return tex;
	}
	
	/**
	 * Load a texture into OpenGL from a BufferedImage
	 *
	 * @param resourceName The location of the resource to load
	 * @param target The GL target to load the texture against
	 * @param dstPixelFormat The pixel format of the screen
	 * @param minFilter The minimising filter
	 * @param magFilter The magnification filter
	 * @return The loaded texture
	 * @throws IOException Indicates a failure to access the resource
	 */
	public Texture getNMMTexture(BufferedImage resourceimage, 
			int target, 
			int dstPixelFormat, 
			int minFilter, 
			int magFilter) throws IOException 
			{ 
		int srcPixelFormat = 0;
		
		// create the texture ID for this texture 
		int textureID = createTextureID(); 
		Texture texture = new Texture(target,textureID); 
		
		// bind this texture 
		GL11.glBindTexture(target, textureID); 
		
		BufferedImage bufferedImage = resourceimage; 
		texture.setWidth(bufferedImage.getWidth());
		texture.setHeight(bufferedImage.getHeight());
		
		if (bufferedImage.getColorModel().hasAlpha()) {
			srcPixelFormat = GL11.GL_RGBA;
		} else {
			srcPixelFormat = GL11.GL_RGB;
		}
		
		// convert that image into a byte buffer of texture data 
		ByteBuffer textureBuffer = convertImageData(bufferedImage,texture); 
		
		if (target == GL11.GL_TEXTURE_2D) 
		{ 
			GL11.glTexParameteri(target, GL11.GL_TEXTURE_WRAP_S, GL11.GL_REPEAT);
			GL11.glTexParameteri(target, GL11.GL_TEXTURE_WRAP_T, GL11.GL_REPEAT);
			GL11.glTexParameteri(target, GL11.GL_TEXTURE_MIN_FILTER, minFilter); 
			GL11.glTexParameteri(target, GL11.GL_TEXTURE_MAG_FILTER, magFilter); 
		} 
		
		// produce a texture from the byte buffer
		GL11.glTexImage2D(target, 
				0, 
				dstPixelFormat, 
				get2Fold(bufferedImage.getWidth()), 
				get2Fold(bufferedImage.getHeight()), 
				0, 
				srcPixelFormat, 
				GL11.GL_UNSIGNED_BYTE, 
				textureBuffer ); 

		return texture; 
			} 
	
	//////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////
	
}
