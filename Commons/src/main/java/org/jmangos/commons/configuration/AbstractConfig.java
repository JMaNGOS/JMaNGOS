package org.jmangos.commons.configuration;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jmangos.commons.utils.PropertiesUtils;

public abstract class AbstractConfig {
    
    /**
     * Logger.
     */
    private static final Logger log = LoggerFactory.getLogger(AbstractConfig.class);
    
    protected AbstractConfig(final String configFileName) {
    
        Properties properties;
        try {
            properties = PropertiesUtils.load(configFileName);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
        process(this, properties);
    }
    
    protected static void process(final Object obj, final Properties... properties) {
    
        for (final Field field : obj.getClass().getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers()) || Modifier.isFinal(field.getModifiers())) {
                continue;
            }
            if (field.isAnnotationPresent(Property.class)) {
                processField(obj, field, properties);
            }
        }
    }
    
    private static void processField(final Object obj, final Field field, final Properties... properties) {
    
        final Property property = field.getAnnotation(Property.class);
        final boolean isAccessible = field.isAccessible();
        field.setAccessible(true);
        String value = findPropertyByKey(property.key(), properties);
        if (value == null) {
            value = property.defaultValue();
        }
        try {
            field.set(obj, TypeTransformer.castFromString(value, field.getType()));
        } catch (final IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        field.setAccessible(isAccessible);
        if (log.isDebugEnabled()) {
            log.debug("Field " + field.getName() + " of class " + field.getDeclaringClass().getName() + " is " + value);
        }
    }
    
    private static String findPropertyByKey(final String key, final Properties... properties) {
    
        for (final Properties current : properties) {
            if (current.containsKey(key)) {
                return current.getProperty(key);
            }
        }
        return null;
    }
}
