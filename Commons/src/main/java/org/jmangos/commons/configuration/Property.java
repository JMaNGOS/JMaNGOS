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
package org.jmangos.commons.configuration;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The Interface Property.
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Property {
	/**
	 * This string shows to
	 * {@link org.jmangos.commons.configuration.ConfigurableProcessor} that init
	 * value of the object should not be overriden.
	 */
	public static final String DEFAULT_VALUE = "DO_NOT_OVERWRITE_INITIALIAZION_VALUE";

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
	 * <li>{@link Boolean} and boolean by
	 * {@link org.jmangos.commons.configuration.transformers.BooleanTransformer}
	 * </li>
	 * <li>{@link Byte} and byte by
	 * {@link org.jmangos.commons.configuration.transformers.ByteTransformer}</li>
	 * <li>{@link Character} and char by
	 * {@link org.jmangos.commons.configuration.transformers.CharTransformer}</li>
	 * <li>{@link Short} and short by
	 * {@link org.jmangos.commons.configuration.transformers.ShortTransformer}</li>
	 * <li>{@link Integer} and int by
	 * {@link org.jmangos.commons.configuration.transformers.IntegerTransformer}
	 * </li>
	 * <li>{@link Float} and float by
	 * {@link org.jmangos.commons.configuration.transformers.FloatTransformer}</li>
	 * <li>{@link Long} and long by
	 * {@link org.jmangos.commons.configuration.transformers.LongTransformer}</li>
	 * <li>{@link Double} and double by
	 * {@link org.jmangos.commons.configuration.transformers.DoubleTransformer}</li>
	 * <li>{@link String} by
	 * {@link org.jmangos.commons.configuration.transformers.StringTransformer}</li>
	 * <li>{@link Enum} and enum by
	 * {@link org.jmangos.commons.configuration.transformers.EnumTransformer}</li>
	 * <li>{@link java.io.File} by
	 * {@link org.jmangos.commons.configuration.transformers.FileTransformer}</li>
	 * <li>{@link java.net.InetSocketAddress} by
	 * 
	 * @return returns class that will be used to transform value
	 *         {@link org.jmangos.commons.configuration.transformers.InetSocketAddressTransformer}
	 *         </li> <li>{@link java.util.regex.Pattern} by
	 *         {@link org.jmangos.commons.configuration.transformers.PatternTransformer}
	 *         </ul>
	 *         <p/>
	 *         If your value is one of this types - just leave this field empty
	 */

	@SuppressWarnings("unchecked")
	public Class<? extends PropertyTransformer> propertyTransformer() default PropertyTransformer.class;

	/**
	 * Represents default value that will be parsed if key not found. If this
	 * key equals(default) {@link #DEFAULT_VALUE} init value of the object won't
	 * be overridden
	 * 
	 * @return default value of the property
	 */
	public String defaultValue() default DEFAULT_VALUE;
}
