package org.jmangos.commons.jmx;

import org.jmangos.commons.service.Service;

import com.google.inject.Inject;

public abstract class AbstractJmxBeanService implements Service {
    
    @Inject
    private JMXService jmxService;
    
    @Override
    public void start() {
    
        this.jmxService.start(this, getBeanName());
    }
    
    @Override
    public void stop() {
    
        this.jmxService.stop(getBeanName());
    }
    
    protected abstract String getBeanName();
}
