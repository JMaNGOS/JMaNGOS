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
