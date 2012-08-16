package org.jmangos.commons.jmx;

import com.google.inject.Inject;
import org.jmangos.commons.service.Service;

public abstract class AbstractJmxBeanService implements Service {
	@Inject
	private JMXService jmxService;

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
