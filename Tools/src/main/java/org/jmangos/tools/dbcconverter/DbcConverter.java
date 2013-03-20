/**
 * 
 */
package org.jmangos.tools.dbcconverter;

import org.jmangos.tools.dbcconverter.service.impl.DbcStorages;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author MinimaJack
 * 
 */
public class DbcConverter {

    /**
     * @param args
     */
    @SuppressWarnings("resource")
    public static void main(final String[] args) {

        final ApplicationContext appContext =
                new ClassPathXmlApplicationContext(
                        new String[] { "classpath:/META-INF/applicationContext.xml" });
        appContext.getBean(DbcStorages.class).encode();
    }

}
