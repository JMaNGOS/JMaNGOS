package org.jmangos.commons.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;
import org.jmangos.commons.jmx.JMXService;
import org.jmangos.commons.log4j.LoggingService;

import javax.management.MBeanServer;
import java.lang.management.ManagementFactory;

public class CommonModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(String.class).annotatedWith(Names.named("packetXSD")).toInstance(
				"./conf/packetData/packets.xsd");
		LoggingService ls = new LoggingService();
		bind(LoggingService.class).toInstance(ls);
		ls.start();
		bind(JMXService.class).asEagerSingleton();

	}

	@Provides
	public MBeanServer provideMBeanServer() {
		return ManagementFactory.getPlatformMBeanServer();
	}

}
