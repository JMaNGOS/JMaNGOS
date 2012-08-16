package org.jmangos.commons.jmx;

import javax.management.JMException;
import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.apache.log4j.Logger;

import com.google.inject.Inject;

/**
 * 
 * @author MinimaJack
 * 
 */
public class JMXService {
    
    private static final Logger log = Logger.getLogger(JMXService.class);
    
    @Inject
    private MBeanServer         server;
    
    /**
     * @param mBean
     * @param beanName
     */
    public void start(final Object mBean, final String name) {
    
        log.info(String.format("Starting JMX bean %s", name));
        try {
            this.server.registerMBean(mBean, new ObjectName(name));
        } catch (final JMException e) {
            log.error(String.format("Can't register bean %s", name), e);
        }
    }
    
    /**
     * @param beanName
     */
    public void stop(final String beanName) {
    
        log.info(String.format("Stopping JMX bean %s", beanName));
        try {
            this.server.unregisterMBean(new ObjectName(beanName));
        } catch (final JMException e) {
            log.error(String.format("Can't unregister bean %s", beanName), e);
        }
    }
}
