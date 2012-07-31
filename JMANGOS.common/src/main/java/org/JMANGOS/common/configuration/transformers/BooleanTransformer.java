/*******************************************************************************
 * Copyright (c) 2011 WoWEmu
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *    WoWEmu  - initial API and implementation
 ******************************************************************************/

package org.JMANGOS.common.configuration.transformers;

import java.lang.reflect.Field;

import org.JMANGOS.common.configuration.PropertyTransformer;
import org.JMANGOS.common.configuration.TransformationException;


public class BooleanTransformer implements PropertyTransformer<Boolean>
{
	
	/** Shared instance of this transformer, it's thread safe so no need to create multiple instances. */
	public static final BooleanTransformer	SHARED_INSTANCE	= new BooleanTransformer();

	/**
	 * Transforms string to boolean.
	 * 
	 * @param value
	 *            value that will be transformed
	 * @param field
	 *            value will be assigned to this field
	 * @return Boolean object that represents transformed value
	 * @throws TransformationException
	 *             if something goes wrong
	 */
	@Override
	public Boolean transform(String value, Field field) throws TransformationException
	{
		// We should have error here if value is not correct, default
		// "Boolean.parseBoolean" returns false if string
		// is not "true" ignoring case
		if ("true".equalsIgnoreCase(value) || "1".equals(value))
		{
			return true;
		}
		else if ("false".equalsIgnoreCase(value) || "0".equals(value))
		{
			return false;
		}
		else
		{
			throw new TransformationException("Invalid boolean string: " + value);
		}
	}
}
