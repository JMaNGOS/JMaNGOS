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

import java.io.File;
import java.net.InetSocketAddress;
import java.util.regex.Pattern;

import org.jmangos.commons.configuration.transformers.BooleanTransformer;
import org.jmangos.commons.configuration.transformers.ByteTransformer;
import org.jmangos.commons.configuration.transformers.CharTransformer;
import org.jmangos.commons.configuration.transformers.ClassTransformer;
import org.jmangos.commons.configuration.transformers.DoubleTransformer;
import org.jmangos.commons.configuration.transformers.EnumTransformer;
import org.jmangos.commons.configuration.transformers.FileTransformer;
import org.jmangos.commons.configuration.transformers.FloatTransformer;
import org.jmangos.commons.configuration.transformers.InetSocketAddressTransformer;
import org.jmangos.commons.configuration.transformers.IntegerTransformer;
import org.jmangos.commons.configuration.transformers.LongTransformer;
import org.jmangos.commons.configuration.transformers.PatternTransformer;
import org.jmangos.commons.configuration.transformers.ShortTransformer;
import org.jmangos.commons.configuration.transformers.StringTransformer;
import org.jmangos.commons.utils.ClassUtils;


// TODO: Auto-generated Javadoc

public class PropertyTransformerFactory
{
	
	@SuppressWarnings("unchecked")
	public static PropertyTransformer<?> newTransformer(Class<?> clazzToTransform, Class<? extends PropertyTransformer> tc) throws TransformationException
	{

		// Just a hack, we can't set null to annotation value
		if (tc == PropertyTransformer.class)
		{
			tc = null;
		}

		if (tc != null)
		{
			try
			{
				return tc.newInstance();
			}
			catch (Exception e)
			{
				throw new TransformationException("Can't instantiate property transfromer", e);
			}
		}
		else
		{
			if (clazzToTransform == Boolean.class || clazzToTransform == Boolean.TYPE)
			{
				return BooleanTransformer.SHARED_INSTANCE;
			}
			else if (clazzToTransform == Byte.class || clazzToTransform == Byte.TYPE)
			{
				return ByteTransformer.SHARED_INSTANCE;
			}
			else if (clazzToTransform == Character.class || clazzToTransform == Character.TYPE)
			{
				return CharTransformer.SHARED_INSTANCE;
			}
			else if (clazzToTransform == Double.class || clazzToTransform == Double.TYPE)
			{
				return DoubleTransformer.SHARED_INSTANCE;
			}
			else if (clazzToTransform == Float.class || clazzToTransform == Float.TYPE)
			{
				return FloatTransformer.SHARED_INSTANCE;
			}
			else if (clazzToTransform == Integer.class || clazzToTransform == Integer.TYPE)
			{
				return IntegerTransformer.SHARED_INSTANCE;
			}
			else if (clazzToTransform == Long.class || clazzToTransform == Long.TYPE)
			{
				return LongTransformer.SHARED_INSTANCE;
			}
			else if (clazzToTransform == Short.class || clazzToTransform == Short.TYPE)
			{
				return ShortTransformer.SHARED_INSTANCE;
			}
			else if (clazzToTransform == String.class)
			{
				return StringTransformer.SHARED_INSTANCE;
			}
			else if (clazzToTransform.isEnum())
			{
				return EnumTransformer.SHARED_INSTANCE;
			}
			else if (clazzToTransform == File.class)
			{
				return FileTransformer.SHARED_INSTANCE;
			}
			else if (ClassUtils.isSubclass(clazzToTransform, InetSocketAddress.class))
			{
				return InetSocketAddressTransformer.SHARED_INSTANCE;
			}
			else if (clazzToTransform == Pattern.class)
			{
				return PatternTransformer.SHARED_INSTANCE;
			}
			else if (clazzToTransform == Class.class)
			{
				return ClassTransformer.SHARED_INSTANCE;
			}
			else
			{
				throw new TransformationException("Transformer not found for class " + clazzToTransform.getName());
			}
		}
	}
}
