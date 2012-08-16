package org.jmangos.commons.module;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;

import org.jmangos.commons.jmx.JMXService;
import org.jmangos.commons.log4j.LoggingService;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;

public class CommonModule extends AbstractModule {
    
    @Override
    protected void configure() {
    
        bind(String.class).annotatedWith(Names.named("packetXSD")).toInstance("./conf/packetData/packets.xsd");
        final LoggingService ls = new LoggingService();
        bind(LoggingService.class).toInstance(ls);
        ls.start();
        bind(JMXService.class).asEagerSingleton();
        
    }
    
    @Provides
    public MBeanServer provideMBeanServer() {
    
        return ManagementFactory.getPlatformMBeanServer();
    }
    
}
