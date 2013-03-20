package org.jmangos.auth.service;

import org.apache.camel.spring.CamelContextFactoryBean;
import org.springframework.stereotype.Service;

@Service
public class CamelService extends CamelContextFactoryBean {

    /**
     * Basic spring camel service
     */
    public CamelService() {
        super();
        /** set camel context id */
        setId("Camel");
        /** add packages to search routes */
        setPackages(new String[] { "org.jmangos.auth.route" });
    }
}
