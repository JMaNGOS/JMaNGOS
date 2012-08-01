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



// TODO: Auto-generated Javadoc
/**
 * Transforms value that represents long to long. Value can be in decimal or hex format.
 */
public class LongTransformer implements PropertyTransformer<Long>
{
	/**
	 * Shared instance of this transformer. It's thread-safe so no need of multiple instances
	 */
	public static final LongTransformer	SHARED_INSTANCE	= new LongTransformer();

	/**
	 * Transforms value to long.
	 *
	 * @param value value that will be transformed
	 * @param field value will be assigned to this field
	 * @return Long that represents value
	 * @throws TransformationException if something went wrong
	 */
	@Override
	public Long transform(String value, Field field) throws TransformationException
	{
		try
		{
			return Long.decode(value);
		}
		catch (Exception e)
		{
			throw new TransformationException(e);
		}
	}
}
