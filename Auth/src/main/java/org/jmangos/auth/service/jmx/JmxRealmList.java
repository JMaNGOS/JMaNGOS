package org.jmangos.auth.service.jmx;

import java.util.Map.Entry;

import org.jmangos.auth.model.Realm;
import org.jmangos.auth.service.RealmListService;
import org.jmangos.commons.jmx.AbstractJmxBeanService;

import com.google.inject.Inject;

public class JmxRealmList extends AbstractJmxBeanService implements
		JmxRealmListMBean {
	@Inject
	private RealmListService realmListService;

	private static final String BEAN_NAME = "auth.network.realms:name=JMXRealmList";

	@Override
	protected String getBeanName() {
		return BEAN_NAME;
	}

	@Override
	public String getRealmCount() {
		return String.valueOf(realmListService.getRealmCount());
	}

	@Override
	public String printRealmInfo() {
		StringBuffer sb = new StringBuffer();
		for (Entry<Integer, Realm> it : realmListService.getRealms().entrySet()) {
			sb.append("Realm info for: " + it.getKey() + " realm");
			sb.append("\n\tName: " + it.getValue().getName());
			sb.append("\n\tPopulation: " + it.getValue().getPopulation());
			sb.append("\n");
		}
		return sb.toString();
	}

}
