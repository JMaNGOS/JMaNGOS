package org.jmangos.commons.jmx;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jmangos.commons.service.Service;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractJmxBeanService implements Service {

    @Inject
    private JMXService jmxService;

    @PostConstruct
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
