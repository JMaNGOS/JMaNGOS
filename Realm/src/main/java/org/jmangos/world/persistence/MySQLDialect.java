/**
 * 
 */
package org.jmangos.world.persistence;

import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StandardBasicTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author MinimaJack
 * 
 */
public class MySQLDialect extends org.hibernate.dialect.MySQLDialect {

    Logger logger = LoggerFactory.getLogger(MySQLDialect.class);

    public MySQLDialect() {
        super();
        registerFunction("bitwise_and", new SQLFunctionTemplate(StandardBasicTypes.INTEGER,
                "(?1 & ?2)"));
    }
}
