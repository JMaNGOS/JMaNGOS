/**
 * 
 */
package org.jmangos.auth.route;

import org.apache.camel.builder.RouteBuilder;

/**
 * @author MinimaJack
 * 
 */
public class AuthRouteBuilder extends RouteBuilder {

    public void configure() {
        from("jms:JManGOS.Auth"). // ?mapJmsMessage=false
        beanRef("realmListController", "addFromConnected");
    }

}
