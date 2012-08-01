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
package org.jmangos.commons.configuration.transformers;

import java.lang.reflect.Field;

import org.jmangos.commons.configuration.PropertyTransformer;
import org.jmangos.commons.configuration.TransformationException;


public class ClassTransformer implements PropertyTransformer<Class<?>>
{
	/** Shared instance. */
	public static final ClassTransformer	SHARED_INSTANCE	= new ClassTransformer();

	@Override
	public Class<?> transform(String value, Field field) throws TransformationException
	{
		try
		{
			return Class.forName(value, false, getClass().getClassLoader());
		}
		catch (ClassNotFoundException e)
		{
			throw new TransformationException("Cannot find class with name '" + value + "'");
		}
	}
}
