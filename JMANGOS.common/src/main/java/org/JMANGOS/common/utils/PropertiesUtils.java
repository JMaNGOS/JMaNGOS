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
package org.JMANGOS.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

public class PropertiesUtils
{
	
	/**
	 * Loads properties by given file.
	 *
	 * @param file filename
	 * @return loaded properties
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static Properties load(String file) throws IOException
	{
		return load(new File(file));
	}

	/**
	 * Loads properties by given file.
	 *
	 * @param file filename
	 * @return loaded properties
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static Properties load(File file) throws IOException
	{
		FileInputStream fis = new FileInputStream(file);
		Properties p = new Properties();
		p.load(fis);
		fis.close();
		return p;
	}

	/**
	 * Loads properties from given files.
	 *
	 * @param files list of string that represents files
	 * @return array of loaded properties
	 * @throws IOException if was unable to read properties
	 */
	public static Properties[] load(String... files) throws IOException
	{
		Properties[] result = new Properties[files.length];
		for (int i = 0; i < result.length; i++)
		{
			result[i] = load(files[i]);
		}
		return result;
	}

	/**
	 * Loades properties from given files.
	 *
	 * @param files list of files
	 * @return array of loaded properties
	 * @throws IOException if was unable to read properties
	 */
	public static Properties[] load(File... files) throws IOException
	{
		Properties[] result = new Properties[files.length];
		for (int i = 0; i < result.length; i++)
		{
			result[i] = load(files[i]);
		}
		return result;
	}

	/**
	 * Loads non-recursively all .property files form directory
	 * 
	 * @param dir
	 *            string that represents directory
	 * @return array of loaded properties
	 * @throws IOException
	 *             if was unable to read properties
	 */
	public static Properties[] loadAllFromDirectory(String dir) throws IOException
	{
		return loadAllFromDirectory(new File(dir), false);
	}

	/**
	 * Loads non-recursively all .property files form directory
	 * 
	 * @param dir
	 *            directory
	 * @return array of loaded properties
	 * @throws IOException
	 *             if was unable to read properties
	 */
	public static Properties[] loadAllFromDirectory(File dir) throws IOException
	{
		return loadAllFromDirectory(dir, false);
	}

	/**
	 * Loads all .property files form directory
	 * 
	 * @param dir
	 *            string that represents directory
	 * @param recursive
	 *            parse subdirectories or not
	 * @return array of loaded properties
	 * @throws IOException
	 *             if was unable to read properties
	 */
	public static Properties[] loadAllFromDirectory(String dir, boolean recursive) throws IOException
	{
		return loadAllFromDirectory(new File(dir), recursive);
	}

	/**
	 * Loads all .property files form directory
	 * 
	 * @param dir
	 *            directory
	 * @param recursive
	 *            parse subdirectories or not
	 * @return array of loaded properties
	 * @throws IOException
	 *             if was unable to read properties
	 */
	public static Properties[] loadAllFromDirectory(File dir, boolean recursive) throws IOException
	{
		Collection<File> files = FileUtils.listFiles(dir, new String[]
		{ "properties" }, recursive);
		return load(files.toArray(new File[files.size()]));
	}
}
