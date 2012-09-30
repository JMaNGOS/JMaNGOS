/**
 * 
 */
package org.jmangos.tools.dbcconverter;

import org.jmangos.tools.dbcconverter.service.impl.DbcStorages;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author MinimaJack
 * 
 */
public class DbcConverter {

    /**
     * @param args
     */
    public static void main(final String[] args) {

        final ClassPathXmlApplicationContext appContext =
                new ClassPathXmlApplicationContext(
                        new String[] { "/META-INF/applicationContext.xml" });
        appContext.getBean(DbcStorages.class).encode();
    }

}
