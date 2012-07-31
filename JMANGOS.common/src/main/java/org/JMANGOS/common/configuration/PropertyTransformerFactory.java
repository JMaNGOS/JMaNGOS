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
package org.JMANGOS.common.configuration;

import java.io.File;
import java.net.InetSocketAddress;
import java.util.regex.Pattern;

import org.JMANGOS.common.configuration.transformers.BooleanTransformer;
import org.JMANGOS.common.configuration.transformers.ByteTransformer;
import org.JMANGOS.common.configuration.transformers.CharTransformer;
import org.JMANGOS.common.configuration.transformers.ClassTransformer;
import org.JMANGOS.common.configuration.transformers.DoubleTransformer;
import org.JMANGOS.common.configuration.transformers.EnumTransformer;
import org.JMANGOS.common.configuration.transformers.FileTransformer;
import org.JMANGOS.common.configuration.transformers.FloatTransformer;
import org.JMANGOS.common.configuration.transformers.InetSocketAddressTransformer;
import org.JMANGOS.common.configuration.transformers.IntegerTransformer;
import org.JMANGOS.common.configuration.transformers.LongTransformer;
import org.JMANGOS.common.configuration.transformers.PatternTransformer;
import org.JMANGOS.common.configuration.transformers.ShortTransformer;
import org.JMANGOS.common.configuration.transformers.StringTransformer;
import org.JMANGOS.common.utils.ClassUtils;


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
