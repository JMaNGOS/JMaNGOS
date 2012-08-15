package org.jmangos.commons.jmx;

import javax.inject.Inject;
import javax.management.JMException;
import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 
 * @author MinimaJack
 * 
 */
@Component
public class JMXService {
	private static final Logger log = Logger.getLogger(JMXService.class);

	@Inject
	private MBeanServer server;

	/**
	 * @param mBean
	 * @param beanName
	 */
	public void start(Object mBean, String name) {
		log.info(String.format("Starting JMX bean %s", name));
		try {
			server.registerMBean(mBean, new ObjectName(name));
		} catch (JMException e) {
			log.error(String.format("Can't register bean %s", name), e);
		}
	}

	/**
	 * @param beanName
	 */
	public void stop(String beanName) {
		log.info(String.format("Stopping JMX bean %s", beanName));
		try {
			server.unregisterMBean(new ObjectName(beanName));
		} catch (JMException e) {
			log.error(String.format("Can't unregister bean %s", beanName), e);
		}
	}
}
