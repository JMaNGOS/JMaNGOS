package org.jmangos.commons.configuration;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Properties;

import javax.inject.Singleton;

import org.apache.log4j.Logger;
import org.jmangos.commons.utils.PropertiesUtils;

@Singleton
public abstract class AbstractConfig {
	
	/**
	 * Logger.
	 */
	private static final Logger log = Logger.getLogger(AbstractConfig.class);
	
	protected AbstractConfig(String configFileName) {
		Properties properties;
		try {
			properties = PropertiesUtils.load(configFileName);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		process(this, properties);
	}
	
	private static void process(Object obj, Properties... properties) {
		for (Field field : obj.getClass().getDeclaredFields()) {
			if (Modifier.isStatic(field.getModifiers()) ||
					Modifier.isFinal(field.getModifiers())) {
				continue;
			}
			
			if (field.isAnnotationPresent(Property.class)) {
				processField(obj, field, properties);
			}
		}
		
		Class<? extends Object> superClass = obj.getClass().getSuperclass();
		if (!superClass.equals(Object.class)) {
			process(obj, properties);
		}
	}
	
	private static void processField(Object obj, Field field, Properties... properties) {
		Property property = field.getAnnotation(Property.class);
		boolean isAccessible = field.isAccessible();
		field.setAccessible(true);
		String value = findPropertyByKey(property.key(), properties);
		if (value == null) {
			value = property.defaultValue();
		}
		try {
			field.set(obj, TypeTransformer.castFromString(value, field.getType()));
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		field.setAccessible(isAccessible);
		if (log.isDebugEnabled()) {
			log.debug("Field " + field.getName() + " of class "
					+ field.getDeclaringClass().getName() + " is " + value);
		}
	}
	
	private static String findPropertyByKey(String key, Properties... properties) {
		for (Properties current : properties) {
			if (current.contains(key)) {
				return current.getProperty(key);
			}
		}
		return null;
	}
}
