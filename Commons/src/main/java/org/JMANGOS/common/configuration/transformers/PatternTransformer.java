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
import java.util.regex.Pattern;

import org.JMANGOS.common.configuration.PropertyTransformer;
import org.JMANGOS.common.configuration.TransformationException;


@SuppressWarnings("unchecked")
public class PatternTransformer implements PropertyTransformer
{
	
	/** Shared instance of this transformer. */
	public static final PatternTransformer	SHARED_INSTANCE	= new PatternTransformer();

	/**
	 * Transforms String to Pattern object.
	 *
	 * @param value value that will be transformed
	 * @param field value will be assigned to this field
	 * @return Pattern Object
	 * @throws TransformationException if pattern is not valid
	 */
	@Override
	public Pattern transform(String value, Field field) throws TransformationException
	{
		try
		{
			return Pattern.compile(value);
		}
		catch (Exception e)
		{
			throw new TransformationException("Not valid RegExp: " + value, e);
		}
	}
}
