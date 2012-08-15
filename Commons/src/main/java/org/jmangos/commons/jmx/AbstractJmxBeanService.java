package org.jmangos.commons.jmx;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jmangos.commons.service.Service;

public abstract class AbstractJmxBeanService implements Service {
	@Inject
	private JMXService jmxService;

	@PostConstruct
	@Override
	public void start() {
		jmxService.start(this, getBeanName());
	}

	@Override
	public void stop() {
		jmxService.stop(getBeanName());
	}

	protected abstract String getBeanName();
}
