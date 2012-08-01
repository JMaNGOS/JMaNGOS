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
package org.JMANGOS.common.configuration.transformers;

import java.lang.reflect.Field;

import org.JMANGOS.common.configuration.PropertyTransformer;
import org.JMANGOS.common.configuration.TransformationException;


public class EnumTransformer implements PropertyTransformer<Enum<?>>
{
	/**
	 * Shared instance of this transformer. It's thread-safe so no need of multiple instances
	 */
	public static final EnumTransformer	SHARED_INSTANCE	= new EnumTransformer();

	/**
	 * Trnasforms string to enum.
	 *
	 * @param value value that will be transformed
	 * @param field value will be assigned to this field
	 * @return Enum object representing the value
	 * @throws TransformationException if somehting went wrong
	 */
	@Override
	@SuppressWarnings({  "unchecked" })
	public Enum<?> transform(String value, Field field) throws TransformationException
	{
		Class<? extends Enum> clazz = (Class<? extends Enum>) field.getType();

		try
		{
			return Enum.valueOf(clazz, value);
		}
		catch (Exception e)
		{
			throw new TransformationException(e);
		}
	}
}
