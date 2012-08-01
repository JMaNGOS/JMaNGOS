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
package org.jmangos.commons.configuration;

import java.lang.reflect.Field;


// TODO: Auto-generated Javadoc
/**
 * This insterface represents property transformer, each transformer should implement it.
 *
 * @param <T> Type of returned value
 */
public interface PropertyTransformer<T>
{

	/**
	 * This method actually transforms value to object instance.
	 *
	 * @param value value that will be transformed
	 * @param field value will be assigned to this field
	 * @return result of transformation
	 * @throws TransformationException if something went wrong
	 */
	public T transform(String value, Field field) throws TransformationException;
}
