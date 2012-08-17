package org.jmangos.commons.module;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonModule {
    
    @Bean
    public MBeanServer provideMBeanServer() {
    
        return ManagementFactory.getPlatformMBeanServer();
    }
    
}
