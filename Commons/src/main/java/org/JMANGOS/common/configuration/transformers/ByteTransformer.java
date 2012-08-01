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



public class ByteTransformer implements PropertyTransformer<Byte>
{
	/**
	 * Shared instance of this transformer. It's thread-safe so no need of multiple instances
	 */
	public static final ByteTransformer	SHARED_INSTANCE	= new ByteTransformer();

	/**
	 * Tansforms string to byte.
	 *
	 * @param value value that will be transformed
	 * @param field value will be assigned to this field
	 * @return Byte object that represents value
	 * @throws TransformationException if something went wrong
	 */
	@Override
	public Byte transform(String value, Field field) throws TransformationException
	{
		try
		{
			return Byte.decode(value);
		}
		catch (Exception e)
		{
			throw new TransformationException(e);
		}
	}
}
