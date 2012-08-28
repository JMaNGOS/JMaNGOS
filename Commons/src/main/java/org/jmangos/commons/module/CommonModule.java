package org.jmangos.commons.module;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;

import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.annotation.AnnotationMBeanExporter;

@Configuration
public class CommonModule {
    
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
    
        return new DefaultAdvisorAutoProxyCreator();
    }
    
    @Bean
    public AnnotationMBeanExporter annotationMBeanExporter() {
    
        return new AnnotationMBeanExporter();
    }
    
    @Bean
    public MBeanServer provideMBeanServer() {
    
        return ManagementFactory.getPlatformMBeanServer();
    }
    
}
