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
package org.JMANGOS.common.configuration;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// TODO: Auto-generated Javadoc
/**
 * The Interface Property.
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Property
{
	/**
	 * This string shows to {@link org.JMANGOS.common.configuration.ConfigurableProcessor} that init value of the
	 * object should not be overriden.
	 */
	public static final String	DEFAULT_VALUE	= "DO_NOT_OVERWRITE_INITIALIAZION_VALUE";

	/**
	 * Property name in configuration.
	 *
	 * @return name of the property that will be used
	 */
	public String key();

	/**
	 * PropertyTransformer to use.<br>
	 * List of automatically transformed types:<br>
	 * <ul>
	 * <li>{@link Boolean} and boolean by {@link org.JMANGOS.common.configuration.transformers.BooleanTransformer}</li>
	 * <li>{@link Byte} and byte by {@link org.JMANGOS.common.configuration.transformers.ByteTransformer}</li>
	 * <li>{@link Character} and char by {@link org.JMANGOS.common.configuration.transformers.CharTransformer}</li>
	 * <li>{@link Short} and short by {@link org.JMANGOS.common.configuration.transformers.ShortTransformer}</li>
	 * <li>{@link Integer} and int by {@link org.JMANGOS.common.configuration.transformers.IntegerTransformer}</li>
	 * <li>{@link Float} and float by {@link org.JMANGOS.common.configuration.transformers.FloatTransformer}</li>
	 * <li>{@link Long} and long by {@link org.JMANGOS.common.configuration.transformers.LongTransformer}</li>
	 * <li>{@link Double} and double by {@link org.JMANGOS.common.configuration.transformers.DoubleTransformer}</li>
	 * <li>{@link String} by {@link org.JMANGOS.common.configuration.transformers.StringTransformer}</li>
	 * <li>{@link Enum} and enum by {@link org.JMANGOS.common.configuration.transformers.EnumTransformer}</li>
	 * <li>{@link java.io.File} by {@link org.JMANGOS.common.configuration.transformers.FileTransformer}</li>
	 * <li>{@link java.net.InetSocketAddress} by
	 *
	 * @return returns class that will be used to transform value
	 * {@link org.JMANGOS.common.configuration.transformers.InetSocketAddressTransformer}</li>
	 * <li>{@link java.util.regex.Pattern} by {@link org.JMANGOS.common.configuration.transformers.PatternTransformer}
	 * </ul>
	 * <p/>
	 * If your value is one of this types - just leave this field empty
	 */

	@SuppressWarnings("unchecked")
	public Class<? extends PropertyTransformer> propertyTransformer() default PropertyTransformer.class;

	/**
	 * Represents default value that will be parsed if key not found. If this key equals(default) {@link #DEFAULT_VALUE}
	 * init value of the object won't be overridden
	 * 
	 * @return default value of the property
	 */
	public String defaultValue() default DEFAULT_VALUE;
}
